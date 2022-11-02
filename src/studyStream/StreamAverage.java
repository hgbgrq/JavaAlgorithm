package studyStream;

import java.util.Arrays;

public class StreamAverage {

    public double getAverage(int[] array){
        return (double) Arrays.stream(array).average().orElse(0);
    }

}
