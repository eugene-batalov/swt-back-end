package heroes;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroRepository {
}
