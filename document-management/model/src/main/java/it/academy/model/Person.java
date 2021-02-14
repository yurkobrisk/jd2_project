package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "T_PERSON")
public class Person {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "P_ID")
    private String id;

    @Column(name = "P_NAME")
    private String name;

    @Column(name = "P_SURNAME")
    private String surname;

    @Column(name = "P_PASSPORTNUM")
    private String passportNumber;

    @OneToOne
    @JoinColumn(name = "A_ID")
    private Address address;

}
