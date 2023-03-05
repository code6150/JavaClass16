package kr.code6150;

public class SingletonExample extends Abstract {

    // private -> 클래스 내부에서만 생성가능
    // 맴버 함수 ( 객체가 생성되어야만 호출 가능 )
    // 클래스 내부에 있으면서, 객체가 생성되지 않아도 호출 가능한 ㅎ마수
    // static 함수
    // 생성 된 객체 -> instance;

    private static SingletonExample instance;
    public static SingletonExample getInstance() {
        if(instance == null)
            instance = new SingletonExample();

        return instance;
    }

    private SingletonExample() {
        System.out.println("SingletonExample 생성됨");
    }

}
