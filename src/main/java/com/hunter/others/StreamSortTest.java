package com.hunter.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2020/11/29 22:54
 */


public class StreamSortTest {

    public static class People {
        private int age;
        private int height;

        public People(int age, int height) {
            this.age = age;
            this.height = height;
        }

        public People() {
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        People people = new People();
        people.setAge(1);
        people.setHeight(2);
        list.add(people);
        People people1 = new People();
        people1.setAge(2);
        people1.setHeight(1);
        list.add(people1);
        Comparator<People> comparator = (o1, o2) -> {
            int ageA = o1.getAge();
            int ageB = o2.getAge();
            if (ageA != ageB) {
                return ageA - ageB;
            }

            int heightA = o1.getHeight();
            int heightB = o2.getHeight();
            if (heightA != heightB) {
                return heightA - heightB;
            }
            return 0;
        };
        // 最终的结果
        list = list.stream().sorted(comparator).collect(Collectors.toList());
        for (int i=0;i<list.size();i++){
            People people2 = list.get(i);
            System.out.println("age is" + people2.getAge() + "height is" + people2.getHeight());
        }
    }
}
