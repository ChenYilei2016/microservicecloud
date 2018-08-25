package com.chenyilei.springcloud.controller;

import com.chenyilei.springcloud.entities.Dept;
import com.chenyilei.springcloud.service.DeptClientService;

import com.chenyilei.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id ){
        return deptService.findById(id);
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return deptService.findAll();
    }

}
