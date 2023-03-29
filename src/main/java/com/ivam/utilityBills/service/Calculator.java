package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.model.PreliminaryBill;
import com.ivam.utilityBills.repository.CheckDateRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Service
public class Calculator implements CalculatorInterface {
    //TODO Think to rename class
    @Autowired
    CheckDateRepository checkDateRepository;

    @Autowired
    MetersDataRepository metersDataRepository;

    private CheckDate currentCheckDate;
    private CheckDate previousCheckDate;

    private List<MetersData> currentMetersDataList;
    private List<MetersData> previousMeterDataList;

    private int commonElectricityAmount;
    private int commonGasAmount;
    private int sumOfPrivateElectricityAmounts;

    private List<PreliminaryBill> preliminaryBills = new ArrayList<>();

    //Get From DB List of two last meters verification dates, means for current and previous periods
    @Override
    public List<CheckDate> findTwoLastCheckDates() {
        return checkDateRepository.findTop2AllByOrderByVerificationDateDesc();
    }

    //and set these dates to proper fields
    void setCurrentCheckDate() {
        currentCheckDate = findTwoLastCheckDates().get(0);
    }

    void setPreviousCheckDate() {
        previousCheckDate = findTwoLastCheckDates().get(1);
    }

    //get a  Lists of meters readings for these dates and set it to proper fields
    @Override
    public List<MetersData> getMetersDataForCheckDate(int id) {
        return metersDataRepository.findAllByCheckDates_Id(id);
    }

    public void setCurrentMetersDataList() {
        int checkDateId = currentCheckDate.getId();
        this.currentMetersDataList = getMetersDataForCheckDate(checkDateId);
    }

    public void setPreviousMeterDataList() {
        int checkDateId = previousCheckDate.getId();
        this.previousMeterDataList = getMetersDataForCheckDate(checkDateId);
    }

    public String getCurrentMeterName(int id) {
        return currentMetersDataList.get(id).getMeter().getName();
    }

    public String getPreviousMeterName(int id) {
        return previousMeterDataList.get(id).getMeter().getName();
    }

    public String getOwnerName(int id) {
        String ownerName = currentMetersDataList.get(id).getMeter().getOwner().getName();
        Date verificationDate = currentCheckDate.getVerificationDate();
        SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
        String dateForName = format.format(verificationDate);
        return ownerName + " - " + dateForName;
    }

    //    Method create a List of preliminary bills for each meter, which prepare data for final bills for each owner
    List<PreliminaryBill> preBillListCreator() {
        for (int i = 0; i < currentMetersDataList.size(); i++) {
            String name = getOwnerName(i);
            int currentValue = currentMetersDataList.get(i).getValue();
            String type = currentMetersDataList.get(i).getMeter().getMetertype().getName();
            float tariff = currentMetersDataList.get(i).getMeter().getMetertype().getTariff().getValue();
            boolean isCommonUser = currentMetersDataList.get(i).getMeter().getOwner().isCommonUser();
            int previousValue = 0;


            for (int j = 0; j < previousMeterDataList.size(); j++) {
                if (getCurrentMeterName(i).equals(getPreviousMeterName(j))) {
                    previousValue = previousMeterDataList.get(j).getValue();
                    break;
                }
            }

            PreliminaryBill preliminaryBill = new PreliminaryBill();
            preliminaryBill.setName(name);
            preliminaryBill.setMeterType(type);
            preliminaryBill.setTariff(tariff);
            preliminaryBill.setCurrentData(currentValue);
            preliminaryBill.setPreviousData(previousValue);
            preliminaryBill.setStatus(isCommonUser);
            preliminaryBill.setAmount(amountCalculator(currentValue, previousValue));

            preliminaryBills.add(preliminaryBill);
        }
        return preliminaryBills;
    }

//separate preliminary bills List for common and for private owners Lists

    List<PreliminaryBill> commonOwnersPreBills() {
        return preliminaryBills.stream().filter(preliminaryBills -> preliminaryBills.isStatus())
                .collect(Collectors.toList());
    }

    List<PreliminaryBill> privateOwnersPreBills() {
        return preliminaryBills.stream().filter(preliminaryBills -> !preliminaryBills.isStatus())
                .collect(Collectors.toList());
    }

    public int getCommonGasAmount() {
        commonGasAmount = commonOwnersPreBills().stream()
                .filter(preliminaryBills -> "Газовый".equals(preliminaryBills.getMeterType()))
                .reduce(0, (x, y) -> {
                    return x + y.getAmount();
                }, (x, y) -> x + y);
        return commonGasAmount;
    }

    public int getCommonElectricityAmount() {
        commonElectricityAmount = commonOwnersPreBills().stream()
                .filter(preliminaryBills -> "Электрический".equals(preliminaryBills.getMeterType()))
                .reduce(0, (x, y) -> {
                    return x + y.getAmount();
                }, (x, y) -> x + y);
        return commonElectricityAmount;
    }

public int privateElectricityAmountsSumCalculator (){
    sumOfPrivateElectricityAmounts = privateOwnersPreBills().stream()
            .reduce(0, (x, y) -> {
                return x + y.getAmount();
            }, (x, y) -> x + y);
    return sumOfPrivateElectricityAmounts;
}




    int amountCalculator(int current, int previous) {
        return current - previous;
    }

    int privateGasAmountCalculator(int commonGasAmount, float share) {

        return Math.round(commonGasAmount * share);
    }

    int privateElecrticityAmountCalculator(int meterAmount, int sum, int commonElectricityAmount,float share) {
        return Math.round(meterAmount + (commonElectricityAmount - sum) * share);
    }

}


