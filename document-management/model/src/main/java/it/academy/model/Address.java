package it.academy.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name = "T_ADDRESS")
public class Address implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "A_ID")
    private String addresId;

    @Column(name = "A_COUNTRY")
    private String country;

    @Column(name = "A_CITY")
    private String city;

    @Column(name = "A_STREET")
    private String street;

    @Column(name = "A_INDEX")
    private String index;

}
