package oss.core.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        // 인스턴스 생성
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("member1");
        //출력하기
//        String name  = helloLombok.getName();
//        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }
}
