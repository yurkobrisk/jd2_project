package it.academy.model;

import it.academy.model.enums.DocumentStatus;
import it.academy.model.enums.DocumentType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

// Объект "Документ" из себя представляет описание документа - можно добавить
//произвольных атрибутов - дата создания, статус, автор документа, файл документа
//(файл любого формата) и тд.

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "T_DOCUMENTS")
public class Document implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "D_ID", nullable = false)
    private String documentId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "C_ID")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "P_ID")
    private Provider provider;

    @Column(name = "CREATION_DATE")
    private String creationDate;

    @Column(name = "COMPLETION_DATE")
    private String completionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_STATUS")
    private DocumentStatus documentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE")
    private DocumentType documentType;

//    @OneToOne
//    @JoinColumn(name = "FILE_ID")
//    private FileDocument fileDocument;

}

