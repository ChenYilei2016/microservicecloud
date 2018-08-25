package com.chenyilei.springcloud.service;

import com.chenyilei.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping("/dept/list")
    public List<Dept> getlist();

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);
}
