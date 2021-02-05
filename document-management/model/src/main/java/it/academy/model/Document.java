package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
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
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "D_ID")
    private String documentId;

    @Column(name = "D_CUSTOMER")
    private Person customer;

    @Column(name = "D_EXECUTOR")
    private Person executor;

    @Column(name = "S_START_DATE")
    private Date startDate;

    @Column(name = "D_END_DATE")
    private Date endDate;

    @Column(name = "D_AUTOR")
    private User autor;

    @Column(name = "D_CREATE_DATE")
    private Date createDate;

    @Column(name = "D_STATUS")
    private Status status;

    @Column(name = "D_TYPE")
    private Type type;

    @Column(name = "D_FILE_NAME")
    private File fileName;

}


enum Status {
    NEW, EXECUTION, COMPLETED;
}

enum Type {
    SCAN, TEXT, IMAGE, VIDEO, PHOTO, AUDIO, BIO
}
