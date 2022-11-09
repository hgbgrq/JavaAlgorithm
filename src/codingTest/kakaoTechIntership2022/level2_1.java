package codingTest.kakaoTechIntership2022;

import java.util.LinkedList;
import java.util.Queue;

public class level2_1 {
    public int solution(int[] queue1, int[] queue2) {
    
        int sum = 0;
        
        for(int i = 0; i < queue1.length; i++) {
        	sum = sum + queue1[i] + queue2[i];
        }
        
        if(sum % 2 == 1) {
        	return -1;
        }
        
        long max = (queue1.length + queue2.length ) * 2;

        Queue<Integer> queue1List = makeList(queue1);
        Queue<Integer> queue2List = makeList(queue2);
        
        long sumQueue1 = sumQueue(queue1List);
        long sumQeueu2 = sumQueue(queue2List);
        
        long count = 0;
        while(true) {
        	
          	if(max < count) {
        		return -1;
        	}
        	
        	if(sumQueue1 == sumQeueu2) {
        		break;
        	}
        	
        	else if (sumQueue1 > sumQeueu2) {
        		int chgNum = queue1List.peek();
        		sumQueue1 -= chgNum;
                sumQeueu2 += chgNum;
        		queue2List.add(chgNum);
        		queue1List.poll();
        	}
        	else {
        		int chgNum = queue2List.peek();
                sumQeueu2 -= chgNum;
                sumQueue1 += chgNum;
        		queue1List.add(chgNum);
        		queue1List.poll();
        	}
     
        	if(sumQueue1 == 0 || sumQeueu2 == 0) {
        		return -1;
        	}
        	
        	
        	count++;
        }
        return (int) count;
    }
    
    private Queue<Integer> makeList(int[] queue){
    	Queue<Integer> resultList = new LinkedList<>();
    	for(Integer queue1Num: queue) {
    		resultList.add(queue1Num);
        }
    	return resultList;
    }
    
    private long sumQueue(Queue<Integer> queueList) {
    	long sum = 0;
    	
    	for(Integer num: queueList) {
    		sum += num;
    	}
    	
    	return sum;
    }
}
