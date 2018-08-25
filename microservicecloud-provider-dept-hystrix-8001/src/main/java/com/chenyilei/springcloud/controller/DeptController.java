package com.chenyilei.springcloud.controller;

import com.chenyilei.springcloud.entities.Dept;
import com.chenyilei.springcloud.service.DeptClientService;

import com.chenyilei.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @HystrixCommand(fallbackMethod ="processHystrix_Get" )
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept findById(@PathVariable("id") Long id ){
        Dept dept = this.deptService.findById(id);
        if(null == dept){
            throw new RuntimeException("错误");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "aaaaaa")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    public List<Dept> aaaaaa(){
        return null;
    }

    public  Dept processHystrix_Get(@PathVariable("id") Long  id)
    {
      return  new  Dept().setDeptno(id)
                     .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                     .setDb_source("no this database in MySQL");
    }

}
