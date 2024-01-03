package ch7;

import java.util.*;

class Circle implements Cloneable {
    Point p;  // 원점
    double r; // 반지름

    Circle(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    public Circle shallowCopy() { // 얕은 복사
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        return (Circle)obj;
    }

    public Circle deepCopy() { // 깊은 복사
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}

        Circle c = (Circle)obj;
        c.p = new Point(this.p.x, this.p.y);

        return c;
    }

    public String toString() {
        return "[p=" + p + ", r="+ r +"]";
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("+x +", "+y+")";
    }
}

class ShallowDeepCopy {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(1, 1), 2.0);
        Circle c2 = c1.shallowCopy();
        Circle c3 = c1.deepCopy();

        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
        System.out.println("c3="+c3);
//        c1과 c2의 p가 서로 같은 Point 인스턴스를 참조하기 때문에 c1과 c2의 원점이 둘 다 바뀜
        c1.p.x = 9;
        c1.p.y = 9;
        System.out.println("= c1의 변경 후 =");
        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
        System.out.println("c3="+c3);
    }
}

/*
[실행 결과]
c1=[p=(1, 1), r=2.0]
c2=[p=(1, 1), r=2.0]
c3=[p=(1, 1), r=2.0]
= c1의 변경 후 =
c1=[p=(9, 9), r=2.0]
c2=[p=(9, 9), r=2.0]
c3=[p=(1, 1), r=2.0]
 */
