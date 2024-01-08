package ch11;

import java.util.HashMap;

public class HashMapEx3 {
    private static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>(); // <grpName, <phoneNum, name>>

    // group을 추가하는 메서드
    private static void addGroup(String groupName) {
        if(!phoneBook.containsKey(groupName)) { // 만약 확인하지 않으면 추가하려는 그룹이 존재 -> 새로운 new HashMap<>() 빈 저장소로 초기화
            phoneBook.put(groupName, new HashMap<>());
        }
    }

    // group에 전화번호를 추가하는 메서드
    private static void addPhoneNum(String groupName, String name, String phoneNum) {
        addGroup(groupName);
        HashMap<String, String> group = phoneBook.get(groupName); // <phoneNum, name>
        group.put(phoneNum, name); // <name, phoneNum>으로 하면 중복되는 이름 때문에 문제가 발생
    }

    // group이 기타인 경우 전화번호를 추가하는 메서드
    private static void addPhoneNum(String name, String phoneNum) {
        addPhoneNum("기타", name, phoneNum);
    }

    private static void printList() {
        for (String groupName : phoneBook.keySet()) {
            System.out.printf(" * %s[%d]%n", groupName, phoneBook.get(groupName).size()); // groupName, group 크기

            HashMap<String, String> phoneNumName = phoneBook.get(groupName);
            for (String phoneNum : phoneNumName.keySet()) {
                System.out.printf("%s %s%n", phoneNumName.get(phoneNum), phoneNum); // name, phoneNum
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        addPhoneNum("친구", "이자바", "010-111-1111");
        addPhoneNum("친구", "김자바", "010-222-2222");
        addPhoneNum("친구", "김자바", "010-333-3333");
        addPhoneNum("회사", "김대리", "010-444-4444");
        addPhoneNum("회사", "김대리", "010-555-5555");
        addPhoneNum("회사", "박대리", "010-666-6666");
        addPhoneNum("회사", "이과장", "010-777-7777");
        addPhoneNum("세탁", "010-888-8888");

        printList();
    }
}
