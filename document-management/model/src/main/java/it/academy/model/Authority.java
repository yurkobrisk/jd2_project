package it.academy.model;

import it.academy.model.enums.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "AUTHORITIES")
public class Authority implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "AUTH_ID", nullable = false)
    private String id;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(name = "AUTHORITY", nullable = false)
    private UserType userType;
}
