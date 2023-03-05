package kr.code6150;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread {

    private final Socket socket;
    public WriteThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while(!socket.isClosed()) {
                System.out.print("메세지 입력 : ");
                dos.writeUTF(sc.nextLine());
                dos.flush();
            }
        } catch (IOException ignored) { }
    }

}
