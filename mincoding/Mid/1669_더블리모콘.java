/*
 * [민코딩 Mid] 더블 리모콘
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/1669
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[100001];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {s, 0});
        visited[s] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[0] == d){
                System.out.println(now[1]);
                return;
            }

            if(now[0] + 1 <= 100000 && !visited[now[0] + 1]){
                q.offer(new int[] {now[0] + 1, now[1] + 1});
                visited[now[0] + 1] = true;
            }

            if(now[0] * 2 <= 100000 && !visited[now[0] * 2]){
                q.offer(new int[] {now[0] * 2, now[1] + 1});
                visited[now[0] * 2] = true;
            }

            if(now[0] - 1 >= 0 && !visited[now[0] - 1]){
                q.offer(new int[] {now[0] - 1, now[1] + 1});
                visited[now[0] - 1] = true;
            }

            if(!visited[now[0] / 2]){
                q.offer(new int[] {now[0] / 2, now[1] + 1});
                visited[now[0] / 2] = true;
            }

        }
    }
}