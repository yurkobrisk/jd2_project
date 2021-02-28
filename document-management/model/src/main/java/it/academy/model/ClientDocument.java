package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "T_CLIENT_DOCUMENT")
public class ClientDocument {

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

    @OneToOne
    @JoinColumn(name = "A_ID")
    private Address clientAddress;

    @OneToMany(mappedBy = "clientDocument")
    private List<Document> clientDocuments;
}
