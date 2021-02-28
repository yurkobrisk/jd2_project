package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;

@Data
@NoArgsConstructor
@Entity
@Table(name = "T_FILE_DOCUMENT")
public class FileDocument {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Column(name = "FILE_ID")
    private String fileId;

    private File file;
}
