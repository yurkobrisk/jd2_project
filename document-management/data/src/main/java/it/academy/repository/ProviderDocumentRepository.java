package it.academy.repository;

import it.academy.model.ProviderDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderDocumentRepository extends JpaRepository<ProviderDocument, String> {

}
