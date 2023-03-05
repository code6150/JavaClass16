package kr.code6150;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class MyServer extends Thread{

    private final int port;
    private boolean isRunning;
    private List<ClientInfo> clients;

    private ServerSocket serverSocket;
    public MyServer(int port) {
        this.port = port;
        clients = new ArrayList<>();
    }

    // Thread -> start() 실행 -> 자동으로 run() 이라는 매서드를 찾아 실행
    // Thread 의 main()
    @Override
    public void run() {
        runServer();
    }

    public void runServer() {
        try {
            serverSocket = new ServerSocket(port);
            isRunning = true;
            System.out.println("서버가 시작되었습니다.");
            while (isRunning) {
                ClientInfo client = new ClientInfo(serverSocket.accept(),this);
                clients.add(client);
                client.start();
                System.out.println((client.getClientId() + 1) + " 번 클라이 언트가 접속하였습니다.");
            }
            serverSocket.close();
        } catch (IOException e) {
            isRunning = false;
        }
        System.out.println("서버가 종료되었습니다.");
    }

    public void stopServer() {
        isRunning = false;
        // serverSocket 을 강제로 종료
        if(serverSocket != null && !serverSocket.isClosed()) {
            try { serverSocket.close(); } catch (IOException ignored) { }
        }
    }

    public boolean isStarted() {
        return isRunning;
    }

    public void disconnect(ClientInfo client) {

    }

    public void sendMessage(ClientInfo client, String message) {
        new Thread(() -> clients.forEach((i) -> i.sendMessage(client,message))).start();
    }

}
