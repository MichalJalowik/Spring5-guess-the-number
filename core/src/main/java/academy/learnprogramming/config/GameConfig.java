package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan("academy.learnprogramming")
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
