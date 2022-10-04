package codingTest;

import java.util.Arrays;

public class KAKAO2022TECHINTERNSHIP3 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        int[][] mount = new int[n][n];
        int min = 10000000;

        for(int i = 0 ; i < n; i ++) {
        	Arrays.fill(mount[i], min);
        }
       
        for (int i = 0; i < paths.length; i++) {
        	mount[paths[i][0]- 1][paths[i][1]- 1] = paths[i][2];
        	mount[paths[i][1]- 1][paths[i][0]- 1] = paths[i][2];
        }
        
        
        Arrays.sort(gates);
        Arrays.sort(summits);
        for (int j = 0 ; j < gates.length; j ++) {
        	int[] result = getMinTime(mount, n, gates[j]-1,summits); 	
        	
        	System.out.println(Arrays.toString(result));
        	
        	for(int k = 0 ; k < summits.length; k++) {
        		int goal = summits[k]; 
        		if(result[goal - 1] < min) {
        			answer[0] = goal;
        			answer[1] = result[goal - 1];
        			min = result[goal - 1];
        			System.out.printf("goal: %d, result: %d \n",answer[0] ,answer[1] );
        		}
        	}
        	
        }
        
        return answer;
    }
    
    public int[] getMinTime(int[][] mount, int n, int start,int[] summits) {
    	boolean[] visted = new boolean[n];
    	int[] minTime = new int[n];
    	for(int d = 0; d < n; d ++) {
    		minTime[d] = mount[start][d];
    	}
    	for(int d = 0; d < n -2 ; d ++) {
    		int min = 10000000;
    		int index = 0;
    		
    		for(int i = 0 ; i < n; i++) {
    			if(minTime[i] < min && !visted[i]) {
    				min = minTime[i];
        			index = i;
    			}
    		}
    		visted[index] = true;
    		Loop:
    		for(int k = 0 ; k < n; k ++) {
    			if(!visted[k]) {
    				for(int summit: summits) {
        				if(summit-1 == index) {
        					continue Loop;
        				}
        			}
    				if(minTime[index] < mount[index][k]) {
    					if(minTime[k] > mount[index][k]) {
    						minTime[k] = mount[index][k];
    					}
    				}
    				else {
    					if(minTime[k] > minTime[index]) {
    						minTime[k] = minTime[index];
    					}
    				}
    			}
    		}
    		
    	}
    	return minTime;
    }
    
}
