package it.academy.service;

import it.academy.config.TestDataBaseConfig;
import it.academy.dao.DocumentDaoImpl;
import it.academy.model.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
    //очистка контекста перед запуском тестов в этом классе
@ContextConfiguration(classes = TestDataBaseConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DocumentServiceImplTest {
    static {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DocumentServiceImplTest.class);
        for (String definitionName : context.getBeanDefinitionNames()) {
            System.out.println(definitionName);
        }
    }
    @Autowired(required = false)
    DocumentServiceImpl documentServiceImpl;

    @Test
    public void readDocument() {
    }

    @Test
    public void saveDocument() {

        //Given
        Document document = new Document();
        //When
        //Then
    }

    @Test
    public void readAllDocuments() {
        //Given
        DocumentDaoImpl documentDaoMock = Mockito.mock(DocumentDaoImpl.class);
        Document document = new Document();
        document.setCompletionDate(Date.valueOf("2021-02-28"));
        Mockito.when(documentDaoMock.readAllDocuments()).thenReturn(List.of(document, document, document));

        ApplicationContext context =
                new AnnotationConfigApplicationContext(DocumentServiceImplTest.class);
        for (String definitionName : context.getBeanDefinitionNames()) {
            System.out.println(definitionName);
        }

        documentServiceImpl.setDocumentDao(documentDaoMock);
        //When
        final List<Document> allDocs = documentServiceImpl.readAllDocuments();
        //Then
        assertNotNull(allDocs);
        assertEquals(Date.valueOf("2021-02-28"), allDocs.get(0).getCompletionDate());
        assertEquals(3, allDocs.size());
        assertNull(allDocs.get(2).getDocumentId());
    }
}