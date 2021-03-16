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

    Page<Document> findAll(Pageable pageable);

    @Query("select d from Document d where name like %?1%")
    List<Document> findByName(String name);

}
