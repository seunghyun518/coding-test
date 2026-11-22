/*
 * [민코딩 Mid] 국토대장정
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/12715
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            Queue<int[]> q = new LinkedList<>();
            boolean isAnswer = false;

            int n = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[n];
            int[][] con = new int[n][2];

            st = new StringTokenizer(br.readLine());
            int[] home = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            q.offer(home);

            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                con[j] = new int[] {x, y};
            }

            st = new StringTokenizer(br.readLine());
            int[] dst = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            while(!q.isEmpty()){
                int[] now = q.poll();
                if((Math.abs(now[0] - dst[0]) + Math.abs(now[1] - dst[1])) <= 1000){
                    System.out.println("happy");
                    isAnswer = true;
                    break;
                }

                for(int j = 0; j < n; j++){
                    if(!visited[j]){
                        if((Math.abs(con[j][0] - now[0]) + Math.abs(con[j][1] - now[1])) <= 1000){
                            q.offer(con[j]);
                            visited[j] = true;
                        }
                    }
                }
            }
            if(!isAnswer){
                System.out.println("sad");
            }

        }
    }
}