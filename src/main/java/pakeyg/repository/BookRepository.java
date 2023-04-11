package pakeyg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pakeyg.entity.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByAuthorId(Integer authorId);
//    CriteriaBuilder builder = session.getCriteriaBuilder();
//    CriteriaQuery<Book> bookCriteriaQuery = builder.createQuery(Book.class);
//    Root<Book> root = bookCriteriaQuery.from(Book.class);
//    bookCriteriaQuery.select(root).where(builder.like(root.get("author_id"), authorId.toString()));
//    Query<Dog> query = session.createQuery(bookCriteriaQuery);
//    return query.getResultList();

    List<Book> findAllByName(String name);
}
