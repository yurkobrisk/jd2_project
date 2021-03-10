package it.academy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Authorities implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERNAME")
    private Users username;

    @Column(name = "AUTHORITY")
    private String authority;
}
