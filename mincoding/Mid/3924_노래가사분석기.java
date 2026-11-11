/*
 * [민코딩 Mid] 노래 가사 분석기
 * https://pro.mincoding.co.kr/problem-step/30/level/198/detail/3924
 */

// Brute force 방식은 최악의 경우 시간복잡도에 걸릴 수 있음
// 풀이 방법: 찾으려는 노래 가사의 최대 길이가 5이므로 2 ~ 5길이의 나올 수 있는 모든 단어의 등장 횟수를 HashMap에 저장

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가사의 등장횟수를 저장하는 hash map
        HashMap<String, Integer> hm = new HashMap<>();

        // 가사 입력받기
        String lyrics = br.readLine();

        // 등장 횟수를 저장해야하는 가사의 길이 2 ~ 5
        for(int i = 2; i <= 5; i++){

            // 가사의 처음부터 끝까지 순회
            for(int j = 0; j <= lyrics.length() - i; j++){

                // 등장할 수 있는 가사 sub
                String sub = lyrics.substring(j, j + i);
                int count = hm.getOrDefault(sub, 0);
                hm.put(sub, count + 1);
            }
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String target = br.readLine();
            System.out.println(hm.getOrDefault(target, 0));
        }
    }
}


//import java.util.*;
//import java.io.*;
//
//public class Main{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String lyrics = br.readLine();
//
//        int n = Integer.parseInt(br.readLine());
//
//        for(int i = 0; i < n; i++){
//            String target = br.readLine();
//            int count = 0;
//
//            for(int j = 0; j < lyrics.length() - target.length() + 1; j++){
//                boolean isTarget = true;
//
//                for(int k = 0; k < target.length(); k++){
//                    if(target.charAt(k) != lyrics.charAt(j + k)){
//                        isTarget = false;
//                        break;
//                    }
//                }
//                if(isTarget){
//                    count++;
//                }
//            }
//
//            System.out.println(count);
//        }
//    }
//}