package com.ivam.utilityBills.service;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.model.PreBill;
import com.ivam.utilityBills.repository.CheckDateRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Service
public class PreBillCreator implements PreBillCreatorInterface {
    //TODO Think to rename class
    //TODO change access modifiers for fields to private
    @Autowired
    CheckDateRepository checkDateRepository;

    @Autowired
    MetersDataRepository metersDataRepository;

    CheckDate currentCheckDate;
    CheckDate previousCheckDate;

    List<MetersData> currentMetersDataList;
    List<MetersData> previousMeterDataList;

    private int commonElectricityAmount;
    private int commonGasAmount;
    private int sumOfPrivateElectricityAmounts;

    List<PreBill> preBills = new ArrayList<>();

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

    //get a  lists of meters readings for these dates and set it to proper fields
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

//    public String getMeterDataName(int id) {
//        String meterName = getCurrentMeterName(id);
//        Date verificationDate = currentCheckDate.getVerificationDate();
//        SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
//        String dateForName = format.format(verificationDate);
//        return meterName + " - " + dateForName;
//    }

    List<PreBill> preBillListCreator() {
        for (int i = 0; i < currentMetersDataList.size(); i++) {
//            String name = getMeterDataName(i);
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
//                int amount = amountCalculator(currentValue, previousValue);
            }

            PreBill preBill = new PreBill();
//            preBill.setName(name);
            preBill.setMeterType(type);
            preBill.setTariff(tariff);
            preBill.setCurrentData(currentValue);
            preBill.setPreviousData(previousValue);
            preBill.setStatus(isCommonUser);
            preBill.setAmount(amountCalculator(currentValue, previousValue));

            preBills.add(preBill);
        }
        return preBills;
    }
//separate prebills List for common meters and for private Lists
//    List<PreBill> commonMetersPreBills = preBills.stream().filter(preBills -> preBills.isStatus())
//            .collect(Collectors.toList());
    List<PreBill> privateMetersPreBills = preBills.stream().filter(preBills -> !preBills.isStatus())
            .collect(Collectors.toList());



    public int getCommonGasAmount() {
        List<PreBill> commonMetersPreBills = preBills.stream().filter(preBills -> preBills.isStatus())
            .collect(Collectors.toList());
        commonGasAmount = commonMetersPreBills.stream()
                .filter(preBills -> "Газовый".equals(preBills.getMeterType()))
                .reduce(0,(x,y)-> {
                    return x + y.getAmount();
                }, (x, y)->x+y);
        return commonGasAmount;
    }





    int calculateCommonGasAmount() {
        for (int i = 0; i < preBills.size(); i++) {
            PreBill prebill = preBills.get(i);
            boolean status = prebill.isStatus();
            String type = prebill.getMeterType();

            if (status && type.equals("Газовый")) {
                commonGasAmount = amountCalculator(prebill.getCurrentData(), prebill.getPreviousData());
                break;
            }

        }
        return commonGasAmount;
    }

    int calculateCommonElectricityAmount() {
        for (int i = 0; i < preBills.size(); i++) {
            PreBill prebill = preBills.get(i);
            boolean status = prebill.isStatus();
            String type = prebill.getMeterType();

            if (status && type.equals("Электрический")) {
                commonElectricityAmount = amountCalculator(prebill.getCurrentData(), prebill.getPreviousData());
                break;
            }
        }
        return commonElectricityAmount;
    }
//    Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000),
//            new Phone("Lumia 950", 45000),
//            new Phone("Samsung Galaxy S 6", 40000),
//            new Phone("LG G 4", 32000));
//
//    int sum = phoneStream.reduce(0,
//            (x,y)-> {
//                if(y.getPrice()<50000)
//                    return x + y.getPrice();
//                else
//                    return x + 0;
//            },
//            (x, y)->x+y);
//
//System.out.println(sum); // 117000

    //
    int amountCalculator(int current, int previous) {
        return current - previous;
    }

    int privateGasAmountCalculator(int commonGasAmount, float share) {

        return Math.round(commonGasAmount * share);
    }

    int privateElecrticityAmountCalculator() {

        return 0;
    }

}


