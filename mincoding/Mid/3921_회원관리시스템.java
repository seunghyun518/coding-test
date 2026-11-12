/*
 * [민코딩 Mid] 회원관리시스템
 * https://pro.mincoding.co.kr/problem-step/30/level/198/detail/3921
 */

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        // <String ID, int password>
        HashMap<String, Integer> logouted = new HashMap<>();
        HashMap<String, Integer> logined = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            String id = st.nextToken();

            // 회원가입
            if(command.equals("reg")){
                int password = Integer.parseInt(st.nextToken());
                int logoutedUser = logouted.getOrDefault(id, -1);
                int loginedUser = logined.getOrDefault(id, -1);
                if(logoutedUser == -1 && loginedUser == -1){
                    logouted.put(id, password);
                    System.out.println("welcome " + (logouted.size() + logined.size()));
                }
                else{
                    System.out.println("reg fail");
                }
            }

            // 로그인
            else if(command.equals("login")){
                int password = Integer.parseInt(st.nextToken());
                int user = logouted.getOrDefault(id, -1);
                if(user == password){
                    logouted.remove(id);
                    logined.put(id, password);
                    System.out.println("login " + logined.size());
                }
                else{
                    System.out.println("login fail");
                }
            }

            // 비밀번호 변경
            else if(command.equals("change")){
                int oldPassword = Integer.parseInt(st.nextToken());
                int newPassword = Integer.parseInt(st.nextToken());

                int logoutedUser = logouted.getOrDefault(id, -1);
                int loginedUser = logined.getOrDefault(id, -1);
                if(logoutedUser == oldPassword){
                    logouted.put(id, newPassword);
                    System.out.println("success");
                }
                else if(loginedUser == oldPassword){
                    logined.put(id, newPassword);
                    System.out.println("success");
                }
                else{
                    System.out.println("change fail");
                }
            }

            // 로그아웃
            else if(command.equals("logout")){
                int user = logined.getOrDefault(id, -1);
                if(user != -1){
                    logined.remove(id);
                    logouted.put(id, user);
                    System.out.println("logout " + logined.size());
                }
                else{
                    System.out.println("logout fail");
                }
            }

            // 회원탈퇴
            else if(command.equals("bye")){
                int user = logined.getOrDefault(id, -1);
                if(user != -1){
                    logined.remove(id);
                    System.out.println("bye " + (logined.size() + logouted.size()));
                }
                else{
                    System.out.println("bye fail");
                }
            }
        }
    }
}