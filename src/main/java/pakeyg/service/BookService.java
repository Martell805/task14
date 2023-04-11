package pakeyg.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pakeyg.annotation.Notify;
import pakeyg.entity.Book;
import pakeyg.repository.BookRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public Book getById(Integer id) throws ChangeSetPersister.NotFoundException {
        return bookRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Transactional
    public List<Book> getAllByAuthorId(Integer authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Transactional
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public List<Book> getAllByName(String name) {
        return bookRepository.findAllByName(name);
    }

    @Transactional
    @Notify
    public Book add(Book Book) {
        return bookRepository.save(Book);
    }

    @Transactional
    public Book edit(Book Book) {
        return bookRepository.save(Book);
    }

    @Transactional
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
