package academy.programming.config;

import academy.programming.GuessCount;
import academy.programming.MaxNumber;
import academy.programming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan("academy.programming")
public class GameConfig {

    @Value("${game.maxNumber:60}")
    private int maxNumber;

    @Value("${game.minNumber:10}")
    private  int minNumber;

    @Value("${game.guessCount:10}")
    private  int guessCount;


    @Bean
    @MaxNumber
    public int maxNumberWithAnnotation(){
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumberWithAnnotation(){
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
