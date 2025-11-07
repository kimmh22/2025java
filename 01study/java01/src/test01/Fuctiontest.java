package test01;

public class Fuctiontest {

    public static void sayhello(String name, int age){
        System.out.println(name+"님"+"당신의나이는"+age+"입니다");
    }

    public static  int add (int a,int b) {
        return a + b;
    }

    public static String text(String a,String b){
        return a+b;

    }
    public static void main(String[] args) {
        sayhello("홍길동",21);
        
        int result =add(2,4);
        String result1= text("안녕", "하세요");
        System.out.println(result+result1);
    }
    
}
