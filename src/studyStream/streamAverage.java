package studyStream;

import java.util.Arrays;

public class streamAverage {

    public int getAverage(int[] array){
        return (int) Arrays.stream(array).average().orElse(0);
    }

}
