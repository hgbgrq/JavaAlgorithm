package codingTest.kakaoTechIntership2022;

import java.util.Arrays;

public class level3_2 {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int n = problems.length;
        int[][] distance = new int[n][3];
        boolean[] visted = new boolean[n];
        int index = 0;
        int min = 100;
      
        for(int i = 0; i < n; i++) {
        	int sum = 0;
        	if(problems[i][0] > alp) {
        		sum += problems[i][0] - alp;
        	}
        	if(problems[i][1] > cop) {
        		sum += problems[i][1] - cop;
        	}
        	distance[i][0] = sum;
        	distance[i][1] = Math.max(problems[i][0],alp);
        	distance[i][2] = Math.max(problems[i][1],cop);
        }
        
        
        
        for(int k = 0 ; k < n ; k ++) {
        	min = 100;
        	
        	for(int t = 0 ; t < n; t ++) {
        		if(distance[t][0] < min && !visted[t]) {
        			min = distance[t][0];
        			index = t;
        		}
        	}
        	
        	
        	visted[index] = true;
        	System.out.println(index);
            for(int i = 0 ; i < n; i++) {
            	if(!visted[i]) {
            		int[] cal = calculation(distance[index][1], distance[index][2], problems[index], problems[i]);
            		if(index == 3) {
            			System.out.print(Arrays.toString(distance[index]));
            			System.out.print(Arrays.toString(distance[index]));
            			System.out.println(Arrays.toString(cal));
            		}
            		if(distance[index][0] + cal[0] < distance[i][0]) {
            			distance[i][0] = distance[index][0] + cal[0];
            			distance[i][1] = cal[1];
            			distance[i][2] = cal[2];
            		}
            	}
            }
        	
        }
        
        for(int i = 0 ; i < n; i++) {
        	if(distance[i][0] > answer) {
        		answer = distance[i][0];
        	}
        }
        System.out.print(Arrays.toString(distance[3]));
    
        return answer;
    }
    
    private int[] calculation(int alp, int cop, int[] start , int [] end) {
    	int[] result = new int[3];
    	
    	int nesApl = 0;
    	int nesCop = 0;
    	
    	if(end[0] > alp) {
    		nesApl = (int) Math.ceil((end[0] - alp) / start[2]) * start[4] ; 
    	}
    	
    	if(end[1] > cop) {
    		nesCop = (int) Math.ceil((end[1] - cop) / start[3]) * start[4]; 
    	}
    	int maxtime = Math.max(nesApl, nesCop);
    	
    	int mintime = Math.min(nesApl, nesCop);
    	
    	int minAlp = 0;
    	int minCop = 0;
    	
    	if(end[0] > alp + start[2] * mintime) {
    		minAlp = end[0];
    		minCop = cop + start[2] * mintime;
    		mintime += end[0] - (alp + start[2] * mintime);
    	}
    	else {
    		minAlp = cop + start[3] * mintime;
    		minCop = end[1];
    		mintime += end[1] - (cop + start[3] * mintime);
    	}
    	
    	if(maxtime > mintime) {
    		result[0] = maxtime;
        	result[1] = (int) (alp + start[2] * Math.ceil(maxtime / start[4]));
        	result[2] = (int) (cop + start[3] *  Math.ceil(maxtime / start[4]));
    	}
    	else {
    		result[0] = mintime;
        	result[1] = minAlp;
        	result[2] = minCop;
    	}
    	
    	
    	return result;
    }
}
