package pakeyg.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister;
import pakeyg.entity.Book;
import pakeyg.repository.BookRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @InjectMocks
    BookService bookService;
    
    @Mock
    BookRepository bookRepository;
    
    Book book;
    
    @BeforeEach
    void setUp() {
        book = new Book(
                0, 
                "book1",
                new Date(),
                null
        );
    }

    @Test
    void getById() throws ChangeSetPersister.NotFoundException {
        when(bookRepository.findById(0)).thenReturn(Optional.of(book));

        assertThat(book).isEqualTo(bookService.getById(0));
    }

    @Test
    void getAll() {
        when(bookRepository.findAll()).thenReturn(List.of(book));

        assertThat(List.of(book)).isEqualTo(bookService.getAll());
    }

    @Test
    void getAllBtName() {
        when(bookRepository.findAllByName("book1")).thenReturn(List.of(book));

        assertThat(List.of(book)).isEqualTo(bookService.getAllByName("book1"));
    }

    @Test
    void add() {
        when(bookRepository.save(book)).thenReturn(book);

        assertThat(book).isEqualTo(bookService.add(book));
    }

    @Test
    void edit() {
        when(bookRepository.save(book)).thenReturn(book);

        assertThat(book).isEqualTo(bookService.edit(book));
    }
}
