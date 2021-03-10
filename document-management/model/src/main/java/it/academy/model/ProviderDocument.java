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
@Table(name = "T_PROVIDER_DOCUMENT")
public class ProviderDocument implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "P_ID")
    public String providerId;

    @Column(name = "P_NAME")
    private String providerName;

    @Column(name = "P_SURNAME")
    private String providerSurname;

    @Column(name = "P_PASSPORTNUM")
    private String providerPassportNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "A_ID")
    private Address providerAddress;

    @OneToMany(mappedBy = "providerDocument")
    private List<Document> providerDocuments;
}

