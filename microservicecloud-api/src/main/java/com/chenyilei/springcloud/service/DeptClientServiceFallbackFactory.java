package com.chenyilei.springcloud.service;

import com.chenyilei.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return  new  Dept().setDeptno(id)
                        .setDname("该ID："+id+"服务暂时没有处理能力")
                        .setDb_source("no this database in MySQL");
            }
            @Override
            public List<Dept> getlist() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
