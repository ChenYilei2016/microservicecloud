package com.chenyilei.irule;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyRandom extends AbstractLoadBalancerRule {
    private Integer total = 0; //5 换一次
    private Integer currentIndex = 0 ; //服务器号

    public MyRandom() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                /**
                 *  改变原本的 随机策略
                 * int index = this.rand.nextInt(serverCount);
                 * server = (Server)upList.get(index);
                 */
                if(total < 5){
                    server = (Server)upList.get(currentIndex);
                    total++;
                }
                if(total >= 5){
                    total = 0;
                    currentIndex++;
                }
                if(currentIndex >= upList.size()){
                    currentIndex= 0 ;
                }

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }
                    server = null;
                    Thread.yield();
                }
            }
            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}