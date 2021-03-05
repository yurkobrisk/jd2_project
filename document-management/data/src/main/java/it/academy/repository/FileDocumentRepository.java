package it.academy.repository;

import it.academy.model.FileDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDocumentRepository extends JpaRepository<FileDocument, String> {

}
