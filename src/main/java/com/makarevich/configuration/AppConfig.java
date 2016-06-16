package com.makarevich.configuration;

import com.makarevich.configuration.formatter.PlayerFormatter;
import com.makarevich.configuration.formatter.RoleToUserProfileConverter;
import com.makarevich.configuration.formatter.TeamFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.makarevich")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TeamFormatter teamFormatter;
    @Autowired
    private PlayerFormatter playerFormatter;
    @Autowired
    private RoleToUserProfileConverter roleToUserProfileConverter;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
}

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(teamFormatter);
        registry.addConverter(playerFormatter);
        registry.addConverter(roleToUserProfileConverter);
    }


    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }


    }
