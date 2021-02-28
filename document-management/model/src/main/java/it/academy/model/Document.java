package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

// Объект "Документ" из себя представляет описание документа - можно добавить
//произвольных атрибутов - дата создания, статус, автор документа, файл документа
//(файл любого формата) и тд.

@Data
@NoArgsConstructor
@Entity
@Table(name = "T_DOCUMENT")
public class Document {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "D_ID")
    private String documentId;

    @ManyToOne
    @JoinColumn(name = "C_ID")
    private ClientDocument clientDocument;

    @ManyToOne
    @JoinColumn(name = "P_ID")
    private ProviderDocument providerDocument;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "COMPLETION_DATE")
    private Date completionDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_STATUS")
    private DocumentStatus documentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE")
    private DocumentType documentType;

    @OneToOne
    @JoinColumn(name = "FILE_ID")
    private FileDocument fileDocument;

}

