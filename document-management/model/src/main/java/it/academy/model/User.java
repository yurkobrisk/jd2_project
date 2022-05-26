package it.academy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @Column(name = "USERNAME", columnDefinition = "varchar(50)", unique = true)
    private String userName;

    @Column(name = "PASSWORD", columnDefinition = "varchar(100)")
    private String password;

    @Column(name = "ENABLED", columnDefinition = "integer default 1")
    private Integer enabled;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AUTH_ID")
    private Authority authority;
}
