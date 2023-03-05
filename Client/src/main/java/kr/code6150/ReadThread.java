package kr.code6150;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadThread extends Thread {

    private final Socket socket;
    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
            while (!socket.isClosed()) {
                int id = dis.readInt();
                String msg = dis.readUTF();
                if(id == -1) ;
                else System.out.print("\r" + (id + 1) + "님의 메세지 : " + msg + "\n메세지 입력 : ");
            }
        } catch (IOException e) { }
    }

}
