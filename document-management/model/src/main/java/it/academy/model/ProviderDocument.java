package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "T_PROVIDER_DOCUMENT")
public class ProviderDocument {

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

    @OneToOne
    @JoinColumn(name = "A_ID")
    private Address providerAddress;

    @OneToMany(mappedBy = "providerDocument")
    private List<Document> providerDocuments;
}

