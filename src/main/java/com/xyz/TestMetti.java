package com.xyz;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class TestMetti {
    /** To find distinct passwords **/
    public static void main(String[] args) {
//        Map map = new HashMap<>();
//        map.put("11", "test");
//        map.put(1, "test");
//        System.out.println(map);
//        int a[] = {1, 2, 3, };
//        System.out.println(a.length);

//        Iterator i = (Iterator) map.keySet().iterator();
//
//        while(i.hasNext()) {
//            System.out.println((String)i.next());
//        }

//        i = (Iterator) map.values().iterator();
//
//        while(i.hasNext()) {
//            System.out.println(i.next());
//        }


//        BigDecimal a1= new BigDecimal(39.13);
//        BigDecimal b1 = new BigDecimal(100);
//        System.out.println(a1.divide(b1));

        String[] strs = new String[]{"abcd", "cdab", "bacd"};
        class T1 {
            String id;

            T1(String id) {
                this.id = id;
            }

            @Override
            public int hashCode() {
                int sum = 0;
                for (int i = 0; i < id.length(); i++) {
                    sum += id.charAt(i);
                }
                return sum;
            }

            @Override
            public boolean equals(Object obj) {
                return true;
            }
        }
        HashSet<T1> t = new HashSet<>();
        for (String s : strs) {
            T1 t1 = new T1(s);
            System.out.println(t1.hashCode());
            t.add(t1);
        }
        System.out.println("passwords:" + Arrays.toString(strs));
        System.out.println("#no. of distinct passwords size:" + t.size());

    }
}
