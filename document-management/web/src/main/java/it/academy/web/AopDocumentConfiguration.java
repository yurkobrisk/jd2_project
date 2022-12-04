package it.academy.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "it.academy.web.aspect")
@EnableAspectJAutoProxy
public class AopDocumentConfiguration {
}
