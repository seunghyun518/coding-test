/*
 * [민코딩 Mid] 폭탄 설치 로봇
 * https://pro.mincoding.co.kr/problem-step/30/level/200/detail/4511
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // {폭탄 번호, y, x}, 번호 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] fire = new boolean[1000][1000];

        // 자기 칸 + 상하좌우
        int[] dy = {0, -1, 1, 0, 0};
        int[] dx = {0, 0, 0, -1, 1};

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            // 폭탄 설치
            if (num != 0) {
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                pq.offer(new int[]{num, y, x});
                continue;
            }

            // 폭파: 고장 난 폭탄은 꺼낼 때 버림
            int exploded = -1;
            while (!pq.isEmpty()) {
                int[] bomb = pq.poll();
                int y = bomb[1];
                int x = bomb[2];

                if (fire[y][x]) continue;

                exploded = bomb[0];
                for (int d = 0; d < 5; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny < 0 || ny >= 1000 || nx < 0 || nx >= 1000) continue;
                    fire[ny][nx] = true;
                }
                break;
            }
            sb.append(exploded).append('\n');
        }

        System.out.print(sb);
    }
}