package com.xjd.web.MainTest;

import javax.xml.registry.infomodel.RegistryEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */
public class TestCompare {
    public static void main(String[] args) {
        List<Apple> list=new ArrayList<Apple>();
        list.add(new Apple("xjd",25));
        list.add(new Apple("tgd",52));
        list.add(new Apple("lwz",24));
        list.add(new Apple("abc",24));
        list.add(new Apple("axj",25));
        Collections.sort(list);
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }
    }
    static class Apple implements Comparable<Apple>{
        private String name;
        private Integer age;

        public Apple(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Apple{" +
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

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         * <p/>
         * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
         * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
         * <tt>y.compareTo(x)</tt> throws an exception.)
         * <p/>
         * <p>The implementor must also ensure that the relation is transitive:
         * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
         * <tt>x.compareTo(z)&gt;0</tt>.
         * <p/>
         * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
         * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
         * all <tt>z</tt>.
         * <p/>
         * <p>It is strongly recommended, but <i>not</i> strictly required that
         * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
         * class that implements the <tt>Comparable</tt> interface and violates
         * this condition should clearly indicate this fact.  The recommended
         * language is "Note: this class has a natural ordering that is
         * inconsistent with equals."
         * <p/>
         * <p>In the foregoing description, the notation
         * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
         * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
         * <tt>0</tt>, or <tt>1</tt> according to whether the value of
         * <i>expression</i> is negative, zero or positive.
         *
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object
         * is less than, equal to, or greater than the specified object.
         * @throws ClassCastException if the specified object's type prevents it
         *                            from being compared to this object.
         */
        public int compareTo(Apple o) {
            //年龄相同自然排序
            if(this.getAge()==o.getAge()){
                return 1;
            }
            //根据年龄排序
            return this.getAge()-o.getAge();
        }
    }
}
