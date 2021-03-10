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
@Table(name = "T_CLIENT_DOCUMENT")
public class ClientDocument implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "C_ID")
    public String clientId;

    @Column(name = "C_NAME")
    private String clientName;

    @Column(name = "C_SURNAME")
    private String clientSurname;

    @Column(name = "C_PASSPORTNUM")
    private String clientPassportNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "A_ID")
    private Address clientAddress;

    @OneToMany(mappedBy = "clientDocument")
    private List<Document> clientDocuments;
}
