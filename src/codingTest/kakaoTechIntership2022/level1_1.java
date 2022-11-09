package codingTest.kakaoTechIntership2022;

public class level1_1 {

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[] resultCounts = {0,0,0,0};
        
        for(int i = 0 ; i < survey.length; i ++){
            int resultNum = getResultNum(survey[i]);
            if(getPlusMinus(survey[i])) 
            {
            	resultCounts[resultNum] += getChoiceScore(choices[i]);
            }
            else 
            {
            	resultCounts[resultNum] -= getChoiceScore(choices[i]);
            }
        }
        
        int count = 0;
        for(Integer resultCount: resultCounts) {
        	switch(count) {
        	case 0: if(resultCount >= 0) answer += "R"; else answer += "T"; break;
        	case 1: if(resultCount >= 0) answer += "C"; else answer += "F"; break;
        	case 2: if(resultCount >= 0) answer += "J"; else answer += "M"; break;
        	case 3: if(resultCount >= 0) answer += "A"; else answer += "N"; break;
        	}
        	count ++;
        }
        
        return answer;
        
    }
    
    private Integer getResultNum(String survey){
        if(survey.contains("R")) {
        	return 0;
        }
        else if(survey.contains("C")) {
        	return 1;
        }
        else if(survey.contains("J")) {
        	return 2;
        }
        else {
        	return 3;
        }
    }
    
    private boolean getPlusMinus(String survey) {
        if(survey.contains("R")) {
        	if(survey.indexOf("R") == 0) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        else if(survey.contains("C")) {
        	if(survey.indexOf("C") == 0) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        else if(survey.contains("J")) {
        	if(survey.indexOf("J") == 0) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
        else {
        	if(survey.indexOf("A") == 0) {
        		return true;
        	}
        	else {
        		return false;
        	}
        }
    }
    
    private Integer getChoiceScore(int num) {
    	if(num == 1) {
    		return 3;
    	}
    	else if(num == 2) {
    		return 2;
    	}
    	else if(num == 3) {
    		return 1;
    	}
    	else if(num == 5) {
    		return -1;
    	}
    	else if(num == 6) {
    		return -2;
    	}
    	else if(num == 7) {
    		return -3;
    	}
    	else
    		return 0;
    }
}
