package it.academy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Users implements Serializable {

    @Id
    @OneToMany(mappedBy = "username")
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Integer enabled;
}
