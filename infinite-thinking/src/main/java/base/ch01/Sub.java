package base.ch01;

public class Sub extends Super {
    int j = 30;
    Sub(){
        print();
        j = 40;
    }
    void print(){
        System.out.println(j);
    }
    public static void main(String[] args) {
        System.out.println(new Sub().j);
    }
}