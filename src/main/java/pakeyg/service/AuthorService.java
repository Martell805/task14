package pakeyg.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pakeyg.entity.Author;
import pakeyg.repository.AuthorRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author getById(Integer id) throws ChangeSetPersister.NotFoundException {
        return authorRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Author> getAllByFirstName(String name) {
        return authorRepository.findAllByFirstName(name);
    }

    public List<Author> getAllByMiddleName(String name) {
        return authorRepository.findAllByMiddleName(name);
    }

    public List<Author> getAllByLastName(String name) {
        return authorRepository.findAllByLastName(name);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author add(Author author) {
        return authorRepository.save(author);
    }

    public Author edit(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Integer id) {
        authorRepository.deleteById(id);
    }
}
