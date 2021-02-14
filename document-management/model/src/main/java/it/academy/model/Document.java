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

    @OneToOne
    @JoinColumn(name = "C_ID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "E_ID")
    private Executor executor;

    @Column(name = "S_START_DATE")
    private Date startDate;

    @Column(name = "D_END_DATE")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "D_CREATE_DATE")
    private Date createDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
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
