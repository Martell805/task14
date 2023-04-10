package pakeyg.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pakeyg.entity.Book;
import pakeyg.repository.BookRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book getById(Integer id) throws ChangeSetPersister.NotFoundException {
        return bookRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Book> getAllByAuthorId(Integer authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public List<Book> getAllByName(String name) {
        return bookRepository.findAllByName(name);
    }

    public Book add(Book Book) {
        return bookRepository.save(Book);
    }

    public Book edit(Book Book) {
        return bookRepository.save(Book);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
