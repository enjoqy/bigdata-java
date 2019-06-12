package com.class1926.copybigdata.controller;

import com.class1926.copybigdata.entity.CityResult;
import com.class1926.copybigdata.entity.MapResult;
import com.class1926.copybigdata.entity.ProvinceResult;
import com.class1926.copybigdata.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("city")
    public CityResult getInfoByCity(String type) {
        Object[][] citys = jobService.getCity(type);

        CityResult cityResult = CityResult.builder().city(citys[0])
                .avgByCity(citys[1])
                .countByCity(citys[2])
                .experience(citys[3])
                .budget(citys[4]).build();
        return cityResult;

    }

    @RequestMapping("province")
    public ProvinceResult getInfoByProvince(String type) {
        Object[][] provinces = jobService.getProvince(type);

        ProvinceResult provinceResult = ProvinceResult.builder().province(provinces[0])
                .avgByProvince(provinces[1])
                .countByProvince(provinces[2])
                .experience(provinces[3])
                .budget(provinces[4]).build();
        return provinceResult;

    }

    @RequestMapping("cityMap")
    public List<MapResult> getMapByCity(String type) {

        List mapResult = jobService.getMapByCity(type);

        return mapResult;
    }

    @RequestMapping("cityAvgSalaryMap")
    public List<MapResult> getAvgSalaryByCity(String type) {

        List mapResult = jobService.getAvgSalaryByCity(type);

        return mapResult;
    }

    @RequestMapping("cityAvgExperienceMap")
    public List<MapResult> getAvgExperienceByCity(String type) {

        List mapResult = jobService.getAvgExperienceByCity(type);

        return mapResult;
    }

    @RequestMapping("provinceMap")
    public List<MapResult> getMapByProvince(String type) {

        List mapResult = jobService.getMapByProvince(type);

        return mapResult;
    }

    @RequestMapping("provinceAvgSalaryMap")
    public List<MapResult> getAvgSalaryByProvince(String type) {

        List mapResult = jobService.getAvgSalaryByProvince(type);

        return mapResult;
    }

    @RequestMapping("provinceAvgExperienceMap")
    public List<MapResult> getAvgExperienceByProvince(String type) {

        List mapResult = jobService.getAvgExperienceByProvince(type);

        return mapResult;
    }

    @GetMapping("education")
    public List<Object> getCountByEducation(String type){
        List<Object> all = jobService.getCountByEducation(type);
        return all;
    }

    @RequestMapping("all")
    public List getAllJob(){

        List allJob = jobService.getAllJob();

        return allJob;

    }

}
