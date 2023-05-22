package pakeyg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pakeyg.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getByUsername(String username);
    Optional<User> deleteByUsername(String username);
}