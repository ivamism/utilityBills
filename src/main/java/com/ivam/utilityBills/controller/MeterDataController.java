package com.ivam.utilityBills.controller;


import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.repository.CheckDateRepository;
import com.ivam.utilityBills.repository.MeterRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class MeterDataController {

    @Autowired
    MetersDataRepository metersDataRepository;

    @Autowired
    CheckDateRepository checkDateRepository;


//
//metersdata-for-checkdate

    @GetMapping("/metersdata")
    public String findAll(Model model) {
        List<MetersData> metersDataList = metersDataRepository.findAll();
        model.addAttribute("metersdatalist", metersDataList);
        return "metersdata/metersdata";
    }

    @GetMapping("/metersdata-for-checkdate")
    public String findAllByDate(@RequestParam int id, Model model) {
        Set<MetersData> metersDataList = metersDataRepository.getByCheckDates_Id(id);
        model.addAttribute("metersdatalist", metersDataList);
        CheckDate checkDate = checkDateRepository.findById(id).get();
        model.addAttribute("checkdate", checkDate);
        return "metersdata/metersdatabydate";
    }



//    @GetMapping("/delete-meter")
//    public String delete(@RequestParam int id) {
//        meterRepository.deleteById(id);
//        return "redirect:meters";
//    }
//
//    @GetMapping("/add-meter")
//    public String add(Model model) {
//        List<MeterType> typeList = meterTypeRepository.findAll();
//        List<Owners> ownersList = ownersRepository.findAll();
//        model.addAttribute("typelist", typeList);
//        model.addAttribute("ownerslist", ownersList);
//        return "meters/add-meter";
//    }
//
//    @PostMapping("/add-meter")
//    public String add(@ModelAttribute Meter meter) {
//        meterRepository.save(meter);
//        return "redirect:meters";
//    }
//
//    @GetMapping("/update-meter")
//    public String update(@RequestParam int id, Model model) {
//        Meter meter = meterRepository.findById(id).get();
//        List<MeterType> typeList = meterTypeRepository.findAll();
//        List<Owners> ownersList = ownersRepository.findAll();
//        model.addAttribute("typelist", typeList);
//        model.addAttribute("ownerslist", ownersList);
//        model.addAttribute("meter", meter);
//        return "meters/update-meter";
//    }
//
//    @PostMapping("/update-meter")
//    public String update(@ModelAttribute Meter meter) {
//        meterRepository.save(meter);
//        return "redirect:meters";
//    }
}
