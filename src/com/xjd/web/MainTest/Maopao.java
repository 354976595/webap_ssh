package com.xjd.web.MainTest;

/**
 * Created by Administrator on 2018/1/12.
 */
public class Maopao {
    public static void main(String[] args) {
            int[] test=new int[]{1,3,2,5,2,56,14,5,58,4,17 };
            sort(test);
        for (int i : test) {
            System.out.println(i);
        }
    }
    public static void sort(int[] a)
    {
        int temp = 0;
        for (int i = a.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (a[j + 1] < a[j])
                {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
