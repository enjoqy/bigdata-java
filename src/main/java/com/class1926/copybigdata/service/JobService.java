package com.class1926.copybigdata.service;

import com.class1926.copybigdata.entity.MapResult;
import com.class1926.copybigdata.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * service层
 * @author zell
 */
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Object[][] getCity(String type) {

        List<Object[]> groupByCity = jobRepository.findGroupByCity(type);
        Object[][] citys = new Object[5][groupByCity.size()];
        for (int i = 0; i < groupByCity.size(); i++) {
            citys[0][i] = groupByCity.get(i)[0];
            citys[1][i] = groupByCity.get(i)[1];
            citys[2][i] = groupByCity.get(i)[2];
            citys[3][i] = groupByCity.get(i)[3];
            citys[4][i] = groupByCity.get(i)[4];
        }
        return citys;

    }


    public Object[][] getProvince(String type) {

        List<Object[]> groupByProvince = jobRepository.findGroupByProvince(type);
        Object[][] provinces = new Object[5][groupByProvince.size()];
        for (int i = 0; i < groupByProvince.size(); i++) {
            provinces[0][i] = groupByProvince.get(i)[0];
            provinces[1][i] = groupByProvince.get(i)[1];
            provinces[2][i] = groupByProvince.get(i)[2];
            provinces[3][i] = groupByProvince.get(i)[3];
            provinces[4][i] = groupByProvince.get(i)[4];
        }
        return provinces;
    }

    public List<MapResult> getMapByCity(String type) {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByCity(type);
        for (Object[] objects : groupByCity) {
            mapResult.add(MapResult.builder().name(objects[0]).value(objects[2]).build());
        }
        return mapResult;
    }

    public List<MapResult> getAvgSalaryByCity(String type) {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByCity(type);
        for (Object[] objects : groupByCity) {
            mapResult.add(MapResult.builder().name(objects[0]).value(objects[1]).build());
        }
        return mapResult;
    }

    public List<MapResult> getAvgExperienceByCity(String type) {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByCity(type);
        for (Object[] objects : groupByCity) {
            mapResult.add(MapResult.builder().name(objects[0]).value(objects[3]).build());
        }
        return mapResult;
    }

    public List<MapResult> getMapByProvince(String type) {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByProvince(type);
        for (Object[] objects : groupByCity) {
            mapResult.add(MapResult.builder().name(objects[0]).value(objects[2]).build());
        }
        return mapResult;
    }
    public List<MapResult> getAvgSalaryByProvince(String type) {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByProvince(type);
        for (Object[] objects : groupByCity) {
            mapResult.add(MapResult.builder().name(objects[0]).value(objects[1]).build());
        }
        return mapResult;
    }

    public List<MapResult> getAvgExperienceByProvince(String type) {

        List<MapResult> mapResult = new ArrayList<>();
        List<Object[]> groupByCity = jobRepository.findGroupByProvince(type);
        for (Object[] objects : groupByCity) {
            mapResult.add(MapResult.builder().name(objects[0]).value(objects[3]).build());
        }
        return mapResult;
    }

    public List<Object> getCountByEducation(String type){
        ArrayList<Object> all = new ArrayList<>();
        List<Object[]> count = jobRepository.findCountGroupByEducation(type);

        double item = 0;
        for (Object[] objects : count) {
            item = item + Double.valueOf(objects[1].toString());
        }
        for (int i = 1; i < count.size(); i++) {
            ArrayList<Object> data = new ArrayList<>();
            double x = Double.valueOf(count.get(i)[1].toString())/item*100;
            MapResult other = MapResult.builder().name("other").value(100-(x)).build();
            MapResult result = MapResult.builder().name(count.get(i)[0]).value(x).build();
            data.add(other);
            data.add(result);
            all.add(data);
        }
        return all;
    }

    public List getAllJob(){

        List<List> allJob = new ArrayList<>();
        List<Object> city = new ArrayList<>();
        List<Object> uiSalary = new ArrayList<>();
        List<Object> javaSalary = new ArrayList<>();
        List<Object> bigdataSalary = new ArrayList<>();
        List<Object> cloudSalary = new ArrayList<>();
        city.add("city");
        uiSalary.add("UI");
        javaSalary.add("JAVA");
        bigdataSalary.add("大数据");
        cloudSalary.add("云计算");
        List<Object[]> avgs = jobRepository.findAvg();
        for (Object[] avg : avgs) {
            if ("北京".equals(avg[0]) || "上海".equals(avg[0]) || "广州".equals(avg[0]) || "深圳".equals(avg[0]) || "杭州".equals(avg[0]) || "南京".equals(avg[0]) || "成都".equals(avg[0]) || "苏州".equals(avg[0]) || "武汉".equals(avg[0]) || "合肥".equals(avg[0])) {
                city.add(avg[0]);
                uiSalary.add(avg[1]);
                javaSalary.add(avg[2]);
                bigdataSalary.add(avg[3]);
                cloudSalary.add(avg[4]);
            }
        }
        allJob.add(city);
        allJob.add(uiSalary);
        allJob.add(javaSalary);
        allJob.add(bigdataSalary);
        allJob.add(cloudSalary);

        return allJob;

    }
}
