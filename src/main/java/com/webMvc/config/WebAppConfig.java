package com.webMvc.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppConfig implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
//        root.scan("com.webMvc");
//        var dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(root));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");
//    }
@Override
public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

    registerContext(servletContext, WebConfig.class, "dispatcher1", "/");
//    registerContext(servletContext, WebConfig2.class, "dispatcher2", "/app2/*");



}

    private void registerContext(ServletContext servletContext, Class<?> configClass,
                                 String servletName, String mapping) {
        AnnotationConfigWebApplicationContext ctx =
                new AnnotationConfigWebApplicationContext();
        ctx.scan("com.webMvc");
        ctx.register(configClass);
        ctx.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet =
                servletContext.addServlet(servletName, new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping(mapping);
    }
}
