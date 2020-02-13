package com.example.__GatewayZuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableAutoConfiguration
@RefreshScope
public class TagFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 7;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Value("${loadbalance.enable}")
    String enable;

    @Override
    public Object run() throws ZuulException {
        double ran = Math.random()*100+1;
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String tag = request.getHeader("tag");
        if(enable.equals("80A")){
            if(ran < 80.0){
                RibbonFilterContextHolder.getCurrentContext().add("Loadbalance", "8A");
            }else{
                RibbonFilterContextHolder.getCurrentContext().add("Loadbalance", "2B");
            }
        }else if(enable.equals("100B")){
            RibbonFilterContextHolder.getCurrentContext().add("Loadbalance", "2B");
        }else{
            RibbonFilterContextHolder.getCurrentContext().add("Loadbalance", "8A");
        }
        System.out.println(enable);
        return null;
    }
}