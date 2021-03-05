package it.academy;

import it.academy.model.*;
import it.academy.repository.AddressRepository;
import it.academy.service.DocumentServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("it.academy")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AddressRepository.class);

        for (String definitionName : context.getBeanDefinitionNames()) {
            System.out.println(definitionName);
        }
    }
}
