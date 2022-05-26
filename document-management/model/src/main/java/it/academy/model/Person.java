package it.academy.model;

import it.academy.model.enums.UserType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//TODO Maybe this entity do not need. I do not know

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "T_PERSON_DOCUMENT")
public class Person implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "PERSON_ID")
    private String personId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_TYPE")
    private UserType userType;

    @OneToMany(mappedBy = "person")
    private List<Document> userDocuments;

}

