package com.webMvc.config;


import com.webMvc.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.webMvc")
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/WEB_INF/view/");
        return viewResolver;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new StringHttpMessageConverter());
//        converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new Jaxb2RootElementHttpMessageConverter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor());
    }

    //this method work for all error one page
//    @Bean
//    public HandlerExceptionResolver handlerExceptionResolver() {
//        return new HandlerExceptionResolver() {
//            @Override
//            public ModelAndView resolveException(HttpServletRequest request,
//                                                 HttpServletResponse response,
//                                                 Object handler, Exception ex) {
//
//                ModelAndView modelAndView = new ModelAndView();
//                modelAndView.setViewName("error");
//                modelAndView.addObject("error", ex);
//                return modelAndView;
//            }
//        };
//    }
    //this method work for all error custom response
//    @Bean
//    public HandlerExceptionResolver handlerExceptionResolver(){
//        SimpleMappingExceptionResolver s = new SimpleMappingExceptionResolver();
//        Properties m = new Properties();
//        m.put("java.lang.NullPointerException" , "error2");
//        m.put("java.lang.ArithmeticException" , "error");
//        s.setExceptionMappings(m);
//        Properties statusCodes = new Properties();
//        statusCodes.put("error2" , "500");
//        statusCodes.put("error" , "404");
//        s.setStatusCodes(statusCodes);
//        return s;
//    }
    //this is for add bundle of messages
    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){
        ResourceBundleMessageSource r = new ResourceBundleMessageSource();
        r.setBasename("errors");
        r.setDefaultEncoding("UTF-8");
        r.setUseCodeAsDefaultMessage(true);
        return r;
    }

}
