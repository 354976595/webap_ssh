package com.xjd.web.MainTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */
public class TestComParator {
    public static void main(String[] args) {
        List<Orange> list = new ArrayList<Orange>();
        list.add(new Orange("xjd", 25));
        list.add(new Orange("tgd", 52));
        list.add(new Orange("lwz", 24));
        list.add(new Orange("abc", 24));
        list.add(new Orange("axj", 25));
         Collections.sort(list, new Comparator<Orange>() {
             public int compare(Orange o1, Orange o2) {
                 if(o1.getAge()==o2.getAge()){
                     return 1;
                 }else{
                     return o1.getAge()-o2.getAge();
                 }

             }
         });
        for (Orange apple : list) {
            System.out.println(apple.toString());
        }
    }

    static class Orange {

        private String name;
        private Integer age;

        @Override
        public String toString() {
            return "Orange{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Orange(String name, Integer age) {

            this.name = name;
            this.age = age;
        }
    }
}
