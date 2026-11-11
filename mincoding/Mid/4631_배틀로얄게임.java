/*
 * [민코딩 Mid] 배틀 로얄 게임
 * https://pro.mincoding.co.kr/problem-step/30/level/198/detail/4631
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        // 점수를 저장할 hash map 인원수, 점수를 저장해야하므로 value를 배열로 설정
        HashMap<String, int[]> hm = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        // 팀의 색상, 점수를 입력받아 hm에 저장
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String team = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            int[] now = hm.getOrDefault(team, new int[] {0, 0});
            hm.put(team, new int[] {now[0] + 1, now[1] + score});
        }

        // 비교할 두 팀 입력받기
        st = new StringTokenizer(br.readLine());

        String team1n = st.nextToken();
        String team2n = st.nextToken();

        // 두 팀의 인원수, 점수 배열로 꺼내기
        int[] team1 = hm.getOrDefault(team1n, new int[] {0, 0});
        int[] team2 = hm.getOrDefault(team2n, new int[] {0, 0});

        // 각 팀의 인원수, 점수 출력
        System.out.println(team1[0] + " " + team1[1]);
        System.out.println(team2[0] + " " + team2[1]);

        // 점수가 더 높은 팀 이름 출력
        if(team1[1] > team2[1]){
            System.out.println(team1n);
        }
        else{
            System.out.println(team2n);
        }
    }
}