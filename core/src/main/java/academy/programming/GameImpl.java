package academy.programming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

//    public static final Logger log = LoggerFactory.getLogger(GameImpl.class);

//    @Autowired
//    private NumberGenerator numberGenerator;
//
//    @Autowired
//    @GuessCount
//    private int guessCount;

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;

//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

//    @Override
//    public int getNumber() {
//        return number;
//    }
//
//    @Override
//    public int getGuess() {
//        return guess;
//    }

//    @Override
//    public void setGuess(int guess) {
//        this.guess = guess;
//
//    }

//    @Override
//    public int getSmallest() {
//        return smallest;
//    }
//
//    @Override
//    public int getBiggest() {
//        return biggest;
//    }

//    @Override
//    public int getRemainingGuesses() {
//        return remainingGuesses;
//    }
//
//    @Override
//    public int getGuessCount() {
//        return guessCount;
//    }

    @PostConstruct
    @Override
    public void reset() {

        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number{}",number);

    }

    @PreDestroy
    public void preDestroy(){
        log.info("in game preDestroy");
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if(guess > number){
                biggest = guess - 1;
            }
            if(guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

//    @Override
//    public boolean isValidNumberRange() {
//        return validNumberRange;
//    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <=0;
    }

    private  void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }


}
