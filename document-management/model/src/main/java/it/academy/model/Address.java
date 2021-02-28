package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "T_ADDRESS")
public class Address {

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
    private int index;

}
