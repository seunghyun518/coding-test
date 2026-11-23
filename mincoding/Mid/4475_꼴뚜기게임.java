/*
 * [민코딩 Mid] 꼴뚜기 게임
 * https://pro.mincoding.co.kr/problem-step/7/level/105/detail/4475
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 번째 다리와 두 번째 다리의 방문 기록 저장
        boolean[] firstVisited = new boolean[100000];
        boolean[] secondVisited = new boolean[100000];

        Queue<int[]> q = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 첫 번째 다리 정보 저장(0 ~ 100000)
        String str = br.readLine();

        int[] firstBridge = new int[str.length() + 1];

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            firstBridge[i] = ch - '0';
        }

        // 두 번째 다리 정보 저장
        str = br.readLine();

        int[] secondBridge = new int[str.length() + 1];

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            secondBridge[i] = ch - '0';
        }

        // 시작점 넣기(첫 번째 다리의 첫 번째 칸)
        q.offer(new int[] {1, 0, -1});
        firstVisited[0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            if(now[1] <= now[2]){
                continue;
            }

            int t = now[2];
            t += 1;

            if(now[1] + k >= n){
                System.out.println("1");
                return;
            }

            // 첫 번째 다리
            if(now[0] == 1){
                // 첫 번째 다리에서 앞으로 1칸 가기 검사
                if(!firstVisited[now[1] + 1] && firstBridge[now[1] + 1] == 1){
                    q.offer(new int[] {1, now[1] + 1, t});
                    firstVisited[now[1] + 1] = true;
                }

                // 첫 번째 다리에서 뒤로 1칸 가기 검사
                if(now[1] - 1 >= 0 && !firstVisited[now[1] - 1] && firstBridge[now[1] + 1] == 1){
                    q.offer(new int[] {1, now[1] - 1, t});
                    firstVisited[now[1] - 1] = true;
                }

                // 첫 번째 다리에서 점프 검사
                if(!secondVisited[now[1] + 1] && secondBridge[now[1] + k] == 1){
                    q.offer(new int[] {2, now[1] + k, t});
                    secondVisited[now[1] + k] = true;
                }
            }

            // 두 번째 다리
            else{
                // 두 번째 다리에서 앞으로 1칸 가기 검사
                if(!secondVisited[now[1] + 1] && secondBridge[now[1] + 1] == 1){
                    q.offer(new int[] {2, now[1] + 1, t});
                    secondVisited[now[1] + 1] = true;
                }

                // 두 번째 다리에서 뒤로 1칸 가기 검사
                if(now[1] - 1 >= 0 && !secondVisited[now[1] - 1] && secondBridge[now[1] + 1] == 1){
                    q.offer(new int[] {1, now[1] - 1, t});
                    secondVisited[now[1] - 1] = true;
                }

                // 두 번째 다리에서 점프 검사
                if(!firstVisited[now[1] + k] && firstBridge[now[1] + k] == 1){
                    q.offer(new int[] {1, now[1] + k, t});
                    firstVisited[now[1] + k] = true;
                }
            }
        }
        System.out.println("0");
        return;
    }
}