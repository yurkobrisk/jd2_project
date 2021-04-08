package it.academy.repository;

import it.academy.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {

//    @Query("FROM Document ORDER BY clientDocument.clientSurname")
//    List<Document> findAllOrderByClientSurname();
//
//    @Query("FROM Document ORDER BY providerDocument.providerSurname")
//    List<Document> findAllOrderByProviderSurname();

}
