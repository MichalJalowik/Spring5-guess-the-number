package academy.programming;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();

//    @Autowired
//    @MaxNumber
//    private int maxNumber;
//
//    @Autowired
//    @MinNumber
//    private int minNumber;

    @Getter
    private final int maxNumber;

    @Getter
    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNUmber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNUmber;
    }

    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber() {
//        return minNumber;
//    }


}
