package academy.programming.console;

import academy.programming.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("guess the number game");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//        int number = numberGenerator.next();
//        log.info("number={}", number);
//
//        Game game = context.getBean(Game.class);
//        game.reset();
//
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.debug("message 1 ={}",messageGenerator.getMainMessage());
//        log.debug("message 2= {}",messageGenerator.getResultMessage());
//        messageGenerator.getMainMessage();
//        messageGenerator.getResultMessage();


        context.close();
    }

}
