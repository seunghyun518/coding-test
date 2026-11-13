/*
 * [민코딩 Mid] 인터넷
 * https://pro.mincoding.co.kr/problem-step/30/level/201/detail/8478
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> back = new ArrayDeque<>();   // first = 가장 오래된, last = 가장 최근
        Deque<String> front = new ArrayDeque<>();  // 스택으로 사용 (push/pop)
        String now = "";

        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            // 뒤로 가기일 때
            if (command.equals("B")) {
                if (!back.isEmpty()) {
                    front.push(now);
                    now = back.removeLast();
                }
            }
            // 앞으로 가기일 때
            else if (command.equals("F")) {
                if (!front.isEmpty()) {
                    back.addLast(now);
                    now = front.pop();
                }
            }
            // 접속하기일 때
            else if (command.equals("A")) {
                if (!now.equals("")) back.addLast(now);
                front.clear();
                now = st.nextToken();
            }
            // 압축하기일 때
            else if (command.equals("C")) {
                Deque<String> compressed = new ArrayDeque<>();
                for (String page : back) {
                    if (compressed.isEmpty() || !compressed.peekLast().equals(page)) {
                        compressed.addLast(page);
                    }
                }
                back = compressed;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(now).append('\n');

        if (back.isEmpty()) sb.append("none");
        else while (!back.isEmpty()) sb.append(back.removeLast()).append(' ');
        sb.append('\n');

        if (front.isEmpty()) sb.append("none");
        else while (!front.isEmpty()) sb.append(front.pop()).append(' ');
        sb.append('\n');

        System.out.print(sb);
    }
}