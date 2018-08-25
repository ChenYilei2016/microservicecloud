package com.chenyilei.springcloud.controller;

import com.chenyilei.springcloud.entities.Dept;
import com.chenyilei.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@SuppressWarnings("all")
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public  Dept get(@PathVariable("id") Long  id)
    {
        Dept dept = this.service.get(id);
        return dept;
    }
    @RequestMapping(value = "/consumer/dept/list")
    public  List<Dept> list()
    {
      return  this.service.getlist();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public  Object add(Dept dept)
    {
      return  this.service.addDept(dept);
    }

}
//@RestController
//@SuppressWarnings("all")
//public class DeptController_Consumer {
//
//    public static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @RequestMapping("/consumer/dept/add")
//    public boolean addDept(Dept dept){
//        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
//    }
//
//    @RequestMapping("/consumer/dept/get/{id}")
//    public Dept get(@PathVariable("id") Long id){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
//    }
//
//    @RequestMapping("/consumer/dept/list")
//    public List<Dept> getlist(){
//        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
//    }
//}
