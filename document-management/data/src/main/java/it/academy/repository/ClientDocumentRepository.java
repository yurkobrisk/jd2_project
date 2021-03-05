package it.academy.repository;

import it.academy.model.ClientDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDocumentRepository extends JpaRepository<ClientDocument, String> {

}
