package pakeyg.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;
import pakeyg.entity.Author;
import pakeyg.repository.AuthorRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {
    @InjectMocks
    AuthorService authorService;
    
    @Mock
    AuthorRepository authorRepository;
    
    Author author;
    
    @BeforeEach
    void setUp() {
        author = new Author(
                0, 
                "author1",
                "author1",
                "author1",
                new Date()
        );
    }

    @Test
    void getById() throws ChangeSetPersister.NotFoundException {
        when(authorRepository.findById(0)).thenReturn(Optional.of(author));

        assertThat(author).isEqualTo(authorService.getById(0));
    }

    @Test
    void getAllByFirstName() {
        when(authorRepository.findAllByFirstName("author1")).thenReturn(List.of(author));

        assertThat(List.of(author)).isEqualTo(authorService.getAllByFirstName("author1"));
    }

    @Test
    void getAllByMiddleName() {
        when(authorRepository.findAllByMiddleName("author1")).thenReturn(List.of(author));

        assertThat(List.of(author)).isEqualTo(authorService.getAllByMiddleName("author1"));
    }

    @Test
    void getAllByLastName() {
        when(authorRepository.findAllByLastName("author1")).thenReturn(List.of(author));

        assertThat(List.of(author)).isEqualTo(authorService.getAllByLastName("author1"));
    }

    @Test
    void getAll() {
        when(authorRepository.findAll()).thenReturn(List.of(author));

        assertThat(List.of(author)).isEqualTo(authorService.getAll());
    }

    @Test
    void add() {
        when(authorRepository.save(author)).thenReturn(author);

        assertThat(author).isEqualTo(authorService.add(author));
    }

    @Test
    void edit() {
        when(authorRepository.save(author)).thenReturn(author);

        assertThat(author).isEqualTo(authorService.edit(author));
    }
}
