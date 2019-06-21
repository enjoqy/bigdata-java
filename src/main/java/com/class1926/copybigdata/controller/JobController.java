package com.class1926.copybigdata.controller;

import com.class1926.copybigdata.entity.CityResult;
import com.class1926.copybigdata.entity.MapResult;
import com.class1926.copybigdata.entity.ProvinceResult;
import com.class1926.copybigdata.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author zell
 */
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("city")
    public CityResult getInfoByCity(String type) {
        Object[][] citys = jobService.getCity(type);

        return CityResult.builder().city(citys[0])
                .avgByCity(citys[1])
                .countByCity(citys[2])
                .experience(citys[3])
                .budget(citys[4]).build();
    }

    @GetMapping("province")
    public ProvinceResult getInfoByProvince(String type) {
        Object[][] provinces = jobService.getProvince(type);

        return ProvinceResult.builder().province(provinces[0])
                .avgByProvince(provinces[1])
                .countByProvince(provinces[2])
                .experience(provinces[3])
                .budget(provinces[4]).build();
    }

    @GetMapping("cityMap")
    public List<MapResult> getMapByCity(String type) {
        return jobService.getMapByCity(type);
    }

    @GetMapping("cityAvgSalaryMap")
    public List<MapResult> getAvgSalaryByCity(String type) {
        return jobService.getAvgSalaryByCity(type);
    }

    @GetMapping("cityAvgExperienceMap")
    public List<MapResult> getAvgExperienceByCity(String type) {
        return jobService.getAvgExperienceByCity(type);
    }

    @GetMapping("provinceMap")
    public List<MapResult> getMapByProvince(String type) {
        return jobService.getMapByProvince(type);
    }

    @GetMapping("provinceAvgSalaryMap")
    public List<MapResult> getAvgSalaryByProvince(String type) {
        return jobService.getAvgSalaryByProvince(type);
    }

    @GetMapping("provinceAvgExperienceMap")
    public List<MapResult> getAvgExperienceByProvince(String type) {
        return jobService.getAvgExperienceByProvince(type);
    }

    @GetMapping("education")
    public List<Object> getCountByEducation(String type){
        return jobService.getCountByEducation(type);
    }

    @GetMapping("all")
    public List<Object> getAllJob(){
        return jobService.getAllJob();
    }

}
