package codingTest;

import java.util.Arrays;

public class KAKAO2022TECHINTERNSHIP5 {
	 public int[][] solution(int[][] rc, String[] operations) {
	        int[][] answer = {};
	        
	        int row = rc[0].length;
	        int line = rc.length;
	        for(String operation: operations) {
		        int[] tmpRow = new int[row];
		        tmpRow = rc[0];
	        	if("ShiftRow".equals(operation)) {
	        		for(int i = 0; i < line; i ++) {
	        			int rowNum;
	        			if( i + 1 >= line) {
	        				rowNum = 0;
	        			}
	        			else
	        				rowNum = i + 1;
	        			int[] moveRow = rc[rowNum];
	        			rc[rowNum] = tmpRow;
	        			tmpRow = moveRow;
	        			
	        		}
	        	}
	        	
	        	else {
	        		int rowPlus = 0;
	        		int linePlus = 0;
	        		int rowCount = 0;
	        		int lineCount = 0;
	        		int Dcount = 0;
	        		int tmpNum = 0;
	        		int moveNum = rc[0][0];
	        		while(true) {
	        			if(Dcount == 0) {
	        				rowPlus = 1;
	        				linePlus = 0;
	        			}
	        			else if(Dcount == 1) {
	        				rowPlus = 0;
	        				linePlus = 1;
	        			}
	        			else if(Dcount == 2) {
	        				rowPlus = -1;
	        				linePlus = 0;
	        			}
	        			else if(Dcount == 3) {
	        				rowPlus = 0;
	        				linePlus = -1;
	        			}
	        			else {
	        				break;
	        			}
	        			rowCount += rowPlus;
	        			lineCount += linePlus;
	        			if(rowCount == row -1 && lineCount == 0) {
	        				Dcount = 1;
	        			}
	        			else if(rowCount == row -1 && lineCount == line-1) {
	        				Dcount = 2;
	        			}
	        			else if(rowCount == 0 && lineCount == line-1) {
	        				Dcount = 3;
	        			}
	        			else if(rowCount == 0 && lineCount == 0) {
	        				Dcount = 4;
	        			}
	        			int moveNum2 = rc[lineCount][rowCount];
	        			if(lineCount == 0 && rowCount == 1) {
	        				rc[lineCount][rowCount] = moveNum;
	        			}
	        			else {
	        				rc[lineCount][rowCount] = tmpNum;
	        			}
	        			tmpNum = moveNum2;
	        		}
	        	}
	        	
        		for(int i = 0; i < line; i ++) {
        			System.out.println(Arrays.toString(rc[i]));
        		}
	        }
	        
	        return rc;
	 }
}
