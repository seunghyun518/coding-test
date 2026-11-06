/*
 * [민코딩 Mid] 카드발급기
 * https://pro.mincoding.co.kr/problem-step/7/level/89/detail/220
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        // t번 실행
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){

            // YES를 출력할지 NO를 출력할지 정하는 flag
            boolean answer = true;
            int n = Integer.parseInt(br.readLine());
            int[] h = new int[251];
            int[] temp = new int[n];

            st = new StringTokenizer(br.readLine());

            // 키를 인덱스로 배열 채우기
            for(int j = 0; j < n; j++){
                int height = Integer.parseInt(st.nextToken());
                h[height]++;
                temp[j] = height;
            }

            st = new StringTokenizer(br.readLine());

            // 카드 번호를 입력받아 키순서와 비교
            for(int j = 0; j < n; j++){
                int c = Integer.parseInt(st.nextToken());
                int a = 1;
                for(int k = temp[j] + 1; k < 251; k++){
                    a += h[k];
                }

                int low = a;
                int hight = a + h[temp[j]] - 1;
                if(c < low || c > hight){
                    answer = false;
                    break;
                }
            }

            if(answer){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}