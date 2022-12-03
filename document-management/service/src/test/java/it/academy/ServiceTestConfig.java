package it.academy;

import it.academy.mapper.DocumentMap;
import it.academy.mapper.Mapper;
import it.academy.mapper.UserMap;
import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import it.academy.repository.UsersRepository;
import it.academy.service.*;
import org.springframework.context.annotation.*;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@Configuration
//@ComponentScan({"it.academy.service"})
@Profile("test")
public class ServiceTestConfig {

    @Bean
    @Primary
    public DocumentRepository documentRepository() {
        Document document = new Document();
        document.setDocumentId("15");

        final DocumentRepository documentRepositoryMock = mock(DocumentRepository.class);

        when(documentRepositoryMock.findAll())
                .thenReturn(List.of(document, document));

        when(documentRepositoryMock.getOne("15"))
                .thenReturn(document);

        when(documentRepositoryMock.save(any(Document.class)))
                .thenReturn(document);

        doAnswer(invocation -> {
            String id = invocation.getArgument(0);
            System.out.println("argument = " + id );
            return null;
                }
        ).when(documentRepositoryMock).deleteById("15");

        return documentRepositoryMock;
    }

    @Bean
    @Primary
    public Mapper mapper() {
        return mock(Mapper.class);
    }

    @Bean
    @Primary
    public DocumentMap documentMap() {
        return mock(DocumentMap.class);
    }

    @Bean
    @Primary
    public MapDocumentService mapDocumentService() {
        return mock(MapDocumentService.class);
    }

    @Bean
    @Primary
    public UserService userService() {
        return mock(UserService.class);
    }

    @Bean
    @Primary
    public MapUsersService mapUsersService() {
        return mock(MapUsersService.class);
    }

    @Bean
    @Primary
    public UserMap userMap() {
        return mock(UserMap.class);
    }

    @Bean
    @Primary
    public UsersRepository usersRepository() {
        return mock(UsersRepository.class);
    }
}
