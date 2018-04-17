package heroes;

import java.util.stream.Stream;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner init(HeroRepository repository) {
        return args -> {
            Stream.of("Black Widow", "Superman","Rogue","Batman").forEach(name -> {
                repository.save(Hero.builder().name(name).build());
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
