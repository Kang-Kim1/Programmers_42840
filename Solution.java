import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 수포자 3명의 반복되는 패턴 배열로 저장
        int[] spj1 = {1,2,3,4,5};
        int[] spj2 = {2,1,2,3,2,4,2,5};
        int[] spj3 = {3,3,1,1,2,2,4,4,5,5};
        
        // For Loop에서 사용하기 위해 각 배열 사이즈 배열로 저장
        int[] size = {spj1.length, spj2.length, spj3.length};
        
        // 각 수포자의 정답 카운트 
        int[] corrCnt = new int[3];
        
        // 정답이 일치할 경우, 정답 카운트 배열에 기록
        for(int i = 0; i < answers.length; i++) {
            int currAns = answers[i];
            
            if(currAns == spj1[i % size[0]])
                corrCnt[0] ++;
            if(currAns == spj2[i % size[1]])
                corrCnt[1] ++;
            if(currAns == spj3[i % size[2]])
                corrCnt[2] ++;        
        }
        
        int highestScore = 0;
        
        // 가장 높은 스코어 확인
        for(int i = 0; i < 3; i++) {
            if(highestScore < corrCnt[i]) {
                highestScore = corrCnt[i];
            }
        }
        
        // 가장 높은 점수의 수포자 번호 ArrayList에 입력
        ArrayList<Integer> spjNumAl = new ArrayList<Integer>();
        int highestCount = 0;
        for(int i = 0; i < 3; i++) {
            if(highestScore == corrCnt[i]) {
                spjNumAl.add(i + 1);
            }
        }
        
        // ArrayList에 담긴 정보 Array에 입력
        int[] answer = new int[spjNumAl.size()];
        for(int i = 0; i < spjNumAl.size(); i++) {
            answer[i] = spjNumAl.get(i);
        }
        
        return answer;
    }
}
