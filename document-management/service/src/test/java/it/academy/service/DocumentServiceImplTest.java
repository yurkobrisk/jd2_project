package it.academy.service;

import it.academy.ServiceTestConfig;
import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ServiceTestConfig.class, DocumentServiceImpl.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class DocumentServiceImplTest {

    @Autowired
    DocumentService documentService;

    @Autowired
    DocumentRepository documentRepository;

    @Test
    @DisplayName("it should return list of documents with size 2")
    void readAllDocuments() {
        //Given
        //When
        final List<Document> allDocuments = documentService.readAllDocuments();
        //Then
        assertThat(allDocuments).isNotNull();
        assertThat(allDocuments.size()).isEqualTo(2);
        assertThat(allDocuments.get(0).getDocumentId()).isEqualTo("15");
        assertThat(catchNullPointerException(
                () -> allDocuments.get(1).getClient())).isNull();
        assertThat(allDocuments.get(1).getCreationDate()).isNull();
    }

    @Test
    @DisplayName("it should return document when read method runs")
    void readDocument() {
        //Given
        //When
        Document document = documentService.readDocument("15");
        //Then
        assertThat(document.getDocumentId()).isNotNull();
        assertThat(document.getDocumentId()).isEqualTo("15");
    }

    @Test
    @DisplayName("it should return document when save method runs")
    void saveDocument() {
        //Given
        Document newDocument = new Document();
        newDocument.setDocumentId("15");
        //When
        Document document = documentService.saveDocument(newDocument);
        //Then
        assertThat(document).isNotNull();
        assertThat(document.getDocumentId()).isEqualTo("15");
    }

    @Test
    @DisplayName("it should return document when update method runs")
    void updateDocument() {
        //Given
        Document newDocument = new Document();
        newDocument.setDocumentId("15");
        //When
        Document document = documentService.saveDocument(newDocument);
        //Then
        assertThat(document).isNotNull();
        assertThat(document.getDocumentId()).isEqualTo("15");
    }

    @Test
    @DisplayName("it should runs delete method two times")
    void deleteDocument() {
        //Given
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        //When
        documentService.deleteDocument("15");
        documentService.deleteDocument("15");
        //Then
        verify(documentRepository, times(2))
                .deleteById("15");
    }
}
