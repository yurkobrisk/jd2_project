package it.academy.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@EnableSpringDataWebSupport
@ComponentScan(basePackages = "it.academy")
public class WebDocumentConfiguration implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //добавляться будет каждому логическому имени
        resolver.setPrefix("/WEB-INF/jsp/");
        // /WEB-INF/jsp/<home>.jsp
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
