package ch7;

class Person {
    long id;

    public Person(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
//        obj가 Person으로 형변환 가능하고 obj의 id가 인스턴스 변수 id와 값이 같으면 true 나머지는 모두 false
        return obj instanceof Person && ((Person) obj).id == id;
    }
}

class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(801108111122L);
        Person p2 = new Person(801108111122L);

        if (p1 == p2)
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");

        if (p1.equals(p2))
            System.out.println("p1과 p2는 같은 사람입니다.");
        else
            System.out.println("p1과 p2는 다른 사람입니다.");
    }

}

/*
[실행 결과]
p1과 p2는 다른 사람입니다.
p1과 p2는 같은 사람입니다.
*/
