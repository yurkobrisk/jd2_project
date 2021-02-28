package it.academy.service;

import it.academy.dao.DocumentDao;
import it.academy.model.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter
@Getter
@ToString
@Service("documentServiceImpl")
@Transactional
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    @Qualifier("documentDaoImpl")
    private DocumentDao documentDao;

    @Override
    public List<Document> readAllDocuments() {
        return documentDao.readAllDocuments();
    }

    @Override
    public Document readDocument(String id) {
        return documentDao.readDocument(id);
    }

    @Override
    public String saveDocument(Document document) {
        return documentDao.saveDocument(document);
    }

    @Override
    public String updateDocument(Document document) {
        return documentDao.updateDocument(document);
    }

    @Override
    public void deleteDocument(String id) {
        documentDao.deleteDocument(id);
    }
}
