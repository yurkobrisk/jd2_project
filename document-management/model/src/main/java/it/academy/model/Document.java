package it.academy.model;

import it.academy.model.enums.DocumentStatus;
import it.academy.model.enums.DocumentType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

// Объект "Документ" из себя представляет описание документа - можно добавить
//произвольных атрибутов - дата создания, статус, автор документа, файл документа
//(файл любого формата) и тд.

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "T_DOCUMENT")
public class Document {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "D_ID", nullable = false)
    private String documentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "C_ID", nullable = false)
    private ClientDocument clientDocument;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "P_ID", nullable = false)
    private ProviderDocument providerDocument;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "COMPLETION_DATE")
    private Date completionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
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

