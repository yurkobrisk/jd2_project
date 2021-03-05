package it.academy.service;

import it.academy.config.TestDataBaseConfig;
import it.academy.model.Document;
import it.academy.model.enums.DocumentType;
import it.academy.repository.DocumentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = TestDataBaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class DocumentServiceImplTest {
    static {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DocumentServiceImplTest.class);
        for (String definitionName : context.getBeanDefinitionNames()) {
            System.out.println(definitionName);
        }
    }

//    @Autowired
    private EntityManagerFactory emf;
    protected EntityManager em;

//    @Autowired
//    @Qualifier("documentServiceImpl")
    private DocumentRepository documentRepository;

//    @Before
//    public void setUp() throws Exception {
//        em = emf.createEntityManager();
//    }

    @Test
    public void saveDocument() {
        //Given
//        DocumentRepository documentRepositoryMock = Mockito.mock(DocumentRepository.class);
        Document document = new Document();
        document.setDocumentType(DocumentType.TEXT);
//        Mockito.when(documentRepositoryMock.findAll())
//                .thenReturn(List.of(document, document));
//        documentRepository.saveAndFlush(document);
        //When
    }
}