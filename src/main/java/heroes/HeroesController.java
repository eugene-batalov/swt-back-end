package heroes;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heroes")
public class HeroesController {

    final private HeroRepository heroRepository;

    public HeroesController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable ("id") Long id) {
        return heroRepository.findById(id).orElse(null);
    }
    @GetMapping("/")
    public Collection<Hero> searchHero(@RequestParam("name") String name) {
        return heroRepository.findByNameContainsIgnoreCase(name);
    }

    @GetMapping("")
    public Collection<Hero> getHeroes() {
        return heroRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("")
    public Hero postHero(@RequestBody Hero hero) {
        return heroRepository.save(hero);
    }

    @PutMapping("")
    public Hero updateHero(@RequestBody Hero hero) {
        return heroRepository.save(heroRepository.findById(hero.getId()).get());
    }

    @DeleteMapping("")
    public Hero deleteHero(@RequestBody Hero hero) {
        heroRepository.delete(hero);
        return hero;
    }
}
