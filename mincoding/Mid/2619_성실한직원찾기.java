/*
 * [민코딩 Mid] 성실한 직원 찾기
 * https://pro.mincoding.co.kr/problem-step/7/level/89/detail/2619
 */

// arr의 index = 사원번호로 사용
// arr[1] = 10이면 사원번호가 1인 사람이 정시출근을 10번했다.
// arr 배열을 순회하면서 max를 찾아 index 출력

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사원번호가 최대 10_000_000이므로
        int[] arr = new int[10_000_001];

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        // arr 채우기
        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++){
                int empNo = Integer.parseInt(st.nextToken());
                arr[empNo] += 1;
            }
        }

        // max값 찾아서 index = answer로 출력
        int max = 0;
        int answer = 0;

        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }
}