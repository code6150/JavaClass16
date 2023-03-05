package kr.code6150;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        MyServer myServer = new MyServer(5252);
        myServer.start();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            String command = sc.nextLine();
            switch (command) {
                case "start":
                    if(myServer.isStarted()) System.out.print("이미 서버가 실행중입니다.");
                    else {
                        myServer = new MyServer(5252);
                        myServer.start();
                    }
                    break;
                case "stop":
                    if(myServer.isStarted()) myServer.stopServer();
                    else System.out.print("이미 서버가 종료되었습니다.");
                    break;
                case "cls":
                    for (int i = 0; i < 100; i++)
                        System.out.println();
                    break;
            }
        }

    }

}