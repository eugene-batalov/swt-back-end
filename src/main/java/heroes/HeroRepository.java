package heroes;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroRepository extends JpaRepository<Hero, Long> {

    List<Hero> findByNameContainsIgnoreCase(@Param("name") String name);
}
