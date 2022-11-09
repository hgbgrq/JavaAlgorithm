import codingTest.kakaoBlindRecruitment2022.level1_1;
import studyStream.StreamAverage;

public class Main {
    public static void main(String[] args) {


        level1_1 level1_1 = new level1_1();
        String[] a = {"muzi", "frodo", "apeach", "neo"};
        String[] b = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int c = 2;
        System.out.println(level1_1.solution(a,b,c));


    }
}