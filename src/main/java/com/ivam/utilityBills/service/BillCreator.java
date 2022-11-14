package com.ivam.utilityBills.service;


import com.ivam.utilityBills.model.Bill;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Service
public class BillCreator implements BillCreatorInterface {

    private List<Bill> billList = new ArrayList<>();

    private int commonElectricityAmount;
    private int commonGasAmount;

    PreBillCreator preBillCreator = new PreBillCreator();

    List<PreBill> preBills = preBillCreator.preBillListCreator();

    int calculateCommonGasAmount() {
        for (int i = 0; i < preBills.size(); i++) {
            boolean status = preBills.get(i).isStatus();
            String type = preBills.get(i).getName();

            if (status && type.equals("Газ")) {
                commonGasAmount = commonAmountCalculator(preBills.get(i).getCurrentData(), preBills.get(i).getPreviousData());
            }
        }
        return commonGasAmount;
    }
    int commonAmountCalculator(int current, int previous){
        return current-previous;
    }
}
