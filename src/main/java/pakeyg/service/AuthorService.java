package pakeyg.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pakeyg.annotation.Notify;
import pakeyg.entity.Author;
import pakeyg.repository.AuthorRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public Author getById(Integer id) throws ChangeSetPersister.NotFoundException {
        return authorRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Transactional
    public List<Author> getAllByFirstName(String name) {
        return authorRepository.findAllByFirstName(name);
    }

    @Transactional
    public List<Author> getAllByMiddleName(String name) {
        return authorRepository.findAllByMiddleName(name);
    }

    @Transactional
    public List<Author> getAllByLastName(String name) {
        return authorRepository.findAllByLastName(name);
    }

    @Transactional
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Transactional
    @Notify
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author edit(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }
}
