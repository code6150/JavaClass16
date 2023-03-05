package kr.code6150;

import java.io.IOException;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",5252);
        System.out.println("서버와 연결되었습니다.");

        ReadThread rt = new ReadThread(socket);
        WriteThread wt = new WriteThread(socket);

        rt.start();
        wt.start();
    }

}