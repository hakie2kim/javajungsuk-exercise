package ch7;

class Parent1 {
    int x = 100;

    Parent1() {
        this(200); // Parent1(int x)를 호출
    }

    Parent1(int x) {
//        super(); 컴파일러가 추가
        this.x = x;
    }

    int getX() {
        return x;
    }
}

class Child1 extends Parent1 {
    int x = 3000;

    Child1() {
        this(1000); // Child1(int x)를 호출
    }

    Child1(int x) {
//        super(); 컴파일러가 추가
        this.x = x;
    }
}

class Exercise7_7 {
    public static void main(String[] args) {
        Child1 c = new Child1();
        System.out.println("x=" + c.getX());
    }
}

/*
[실행 결과]
x=200

[호출되는 생성자의 순서]
(1) Child1()
(2) Child(int x)
(3) Parent1()
(4) Parent1(int x)
(5) Object()
*/