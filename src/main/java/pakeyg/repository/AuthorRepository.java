package pakeyg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pakeyg.entity.Author;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAllByFirstName(String firstName);
    List<Author> findAllByMiddleName(String middleName);
    List<Author> findAllByLastName(String lastName);
}