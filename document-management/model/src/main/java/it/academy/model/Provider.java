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
@Table(name = "T_PROVIDERS")
public class Provider implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "P_ID")
    public String id;

    @Column(name = "P_NAME")
    private String name;

    @Column(name = "P_SURNAME")
    private String surname;

    @Column(name = "P_PASSPORTNUM")
    private String passportNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "A_ID")
    private Address address;

    @OneToMany(mappedBy = "provider")
    private List<Document> documents;
}

