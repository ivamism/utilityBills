//package com.ivam.utilityBills.controller;
//
//
//import com.ivam.utilityBills.model.Meter;
//import com.ivam.utilityBills.model.MetersData;
//import com.ivam.utilityBills.model.MetersData2;
//import com.ivam.utilityBills.repository.MeterRepository;
//import com.ivam.utilityBills.repository.MetersData2Repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class MeterDataController2 {
//
//    @Autowired
//    MetersData2Repository metersData2Repository;
//
//    @Autowired
//    MeterRepository meterRepository;
//
//
//    @GetMapping("/metersdata")
//    public String findAll(Model model) {
//        List<MetersData2> metersDataList = metersData2Repository.findAll();
//        model.addAttribute("metersdatalist", metersDataList);
//        return "metersdata2/metersdata";
//    }
//
//    @GetMapping("/delete-metersdata")
//    public String delete(@RequestParam int id) {
//        metersData2Repository.deleteById(id);
//        return "redirect:metersdata";
//    }
//
//    @GetMapping("/add-metersdata")
//    public String add(Model model) {
//        List<Meter> metersList = meterRepository.findAll();
//
//        model.addAttribute("metersList", metersList);
//
//        return "metersdata2/add-metersdata";
//    }
//
//    @PostMapping("/add-metersdata")
//    public String add(@ModelAttribute MetersData2 metersData) {
//        metersData2Repository.save(metersData);
//        return "redirect:metersdata";
//    }
//
//    @GetMapping("/update-metersdata")
//    public String update(@RequestParam int id, Model model) {
//        MetersData2 meterData = metersData2Repository.findById(id).get();
//        List<Meter> metersList = meterRepository.findAll();
//        model.addAttribute("metersList", metersList);
//        model.addAttribute("metersData", meterData);
//        return "metersdata/update-metersdata";
//    }
//
//    @PostMapping("/update-metersdata")
//    public String update(@ModelAttribute MetersData2 meterData) {
//        metersData2Repository.save(meterData);
//        return "redirect:metersdata";
//    }
//}
