package com.rasoolghafari.bankingapplication.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ResourceBundleConfiguration {


    public ResourceBundleConfiguration() {
    }

    @Bean("messages")
    public PropertiesFactoryBean frameworkMessages() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("i18n/messages.properties"));
        propertiesFactoryBean.setFileEncoding("UTF-8");
        return propertiesFactoryBean;
    }

}
