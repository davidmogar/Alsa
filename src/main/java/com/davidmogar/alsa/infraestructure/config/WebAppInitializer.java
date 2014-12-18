package com.davidmogar.alsa.infraestructure.config;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String CHARACTER_ENCODING_FILTER_ENCODING = "UTF-8";
    private static final String CHARACTER_ENCODING_FILTER_NAME = "characterEncoding";
    private static final String CHARACTER_ENCODING_FILTER_URL_PATTERN = "/*";

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING = "/";

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        WebApplicationContext context = super.createRootApplicationContext();
//        ConfigurableEnvironment env = (ConfigurableEnvironment) context.getEnvironment();
//        env.setActiveProfiles();
        return context;
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{DISPATCHER_SERVLET_MAPPING};
    }

    @Override
    protected Filter[] getServletFilters() {
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        delegatingFilterProxy.setTargetBeanName("springSecurityFilterChain");

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(CHARACTER_ENCODING_FILTER_ENCODING);
        characterEncodingFilter.setForceEncoding(true);
        OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{delegatingFilterProxy, characterEncodingFilter, openEntityManagerInViewFilter,
                hiddenHttpMethodFilter};
    }
}
