package com.ivam.utilityBills.controller;


import com.ivam.utilityBills.model.Meter;
import com.ivam.utilityBills.model.MeterType;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.model.Owners;
import com.ivam.utilityBills.repository.MeterRepository;
import com.ivam.utilityBills.repository.MeterTypeRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import com.ivam.utilityBills.repository.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MeterDataController {

    @Autowired
    MetersDataRepository metersDataRepository;

    @Autowired
    MeterRepository meterRepository;
//    @Autowired
//    MeterTypeRepository meterTypeRepository;
//    @Autowired
//    OwnersRepository ownersRepository;


    @GetMapping("/metersdata")
    public String findAll(Model model) {
        List<MetersData> metersDataList = metersDataRepository.findAll();
        model.addAttribute("metersdatalist", metersDataList);
        return "metersdata/metersdata";
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