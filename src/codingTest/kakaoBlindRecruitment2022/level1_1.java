package codingTest.kakaoBlindRecruitment2022;

import java.util.HashMap;
import java.util.Map;

public class level1_1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] reported = new int[id_list.length];
        String[] reporting = new String[id_list.length];
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0 ; i < id_list.length; i++){
            count.put(id_list[i] , i);
        }

        for(String re: report){
            String[] reports = re.split(" ");
            reported[count.get(reports[1])] += 1;
            reporting[count.get(reports[1])] += ","+count.get(reports[0]);
        }

        for(int i = 0 ; i < id_list.length ; i ++ ){
            if (reported[i] >= k){
                String[] users = reporting[i].split(",");
                for(String user: users){
                    if(!user.equals("null")){
                        answer[Integer.parseInt(user)] += 1;
                    }
                }
            }
        }
        return answer;
    }
}
