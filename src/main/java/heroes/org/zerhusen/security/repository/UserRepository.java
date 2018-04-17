package heroes.org.zerhusen.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import heroes.org.zerhusen.model.security.User;

/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
