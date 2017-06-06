package com.yx.logistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Guo LiXiao
 * date : 2017-5-31  18:20
 */
@EnableWebMvc
//@EnableAspectJAutoProxy
//@EnableScheduling
@EnableAsync
@ComponentScan(basePackages = {"com.yx.logistics.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * jsp视图解析器
     * @return
     */
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(org.springframework.web.servlet.view.JstlView.class);
        bean.setPrefix("/WEB-INF/pages/");
        bean.setSuffix(".jsp");
        return bean;
    }

    //@Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        HttpMessageConverter<?> jsonConverter = new MappingJackson2HttpMessageConverter();
        messageConverters.add(jsonConverter);
        requestMappingHandlerAdapter.setMessageConverters(messageConverters);
        return requestMappingHandlerAdapter;
    }

    /*@Bean
    public HandlerExceptionResolver handlerExceptionResolver(){
        HandlerExceptionResolver handle = (httpServletRequest, httpServletResponse, o, e) -> {
           return new ModelAndView(new AbstractView() {
               @Override
               protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

               }
           }).addObject("error","");
        };
        return handle;
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**/*").addResourceLocations("/img");
    }
}