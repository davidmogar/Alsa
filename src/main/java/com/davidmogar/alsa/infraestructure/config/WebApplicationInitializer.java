package com.davidmogar.alsa.infraestructure.config;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

    private static final String CHARACTER_ENCODING_FILTER_ENCODING = "UTF-8";
    private static final String CHARACTER_ENCODING_FILTER_NAME = "characterEncoding";
    private static final String CHARACTER_ENCODING_FILTER_URL_PATTERN = "/*";

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING = "/";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationContext.class);

        //XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        //rootContext.setConfigLocation("classpath:applicationContext.xml");

        configureDispatcherServlet(servletContext, rootContext);
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        configureCharacterEncodingFilter(servletContext, dispatcherTypes);
        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

    private void configureDispatcherServlet(ServletContext servletContext, WebApplicationContext rootContext) {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                DISPATCHER_SERVLET_NAME,
                new DispatcherServlet(rootContext)
        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);
    }

    private void configureCharacterEncodingFilter(ServletContext servletContext, EnumSet<DispatcherType> dispatcherTypes) {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(CHARACTER_ENCODING_FILTER_ENCODING);
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic characterEncoding = servletContext.addFilter(CHARACTER_ENCODING_FILTER_NAME, characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, CHARACTER_ENCODING_FILTER_URL_PATTERN);
    }

}