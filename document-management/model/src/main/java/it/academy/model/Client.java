package it.academy.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "T_CLIENTS")
public class Client implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "C_ID")
    public String id;

    @Column(name = "C_NAME")
    private String name;

    @Column(name = "C_SURNAME")
    private String surname;

    @Column(name = "C_PASSPORTNUM")
    private String passportNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "A_ID")
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Document> documents;
}
