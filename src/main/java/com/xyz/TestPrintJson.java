package com.xyz;

import org.codehaus.jackson.map.ObjectMapper;

public class TestPrintJson {

    public static void main(String[] args) {
        ObjectMapper obj = new ObjectMapper();
        Student s = new Student();
        s.setCourse("xxxxx");
        s.setName("Srini");
        s.setRollNo("xxxxxx-1001");
        try {
            // get Oraganisation object as a json string
            String jsonStr = obj.writeValueAsString(s);
            Student t = obj.readValue(jsonStr, Student.class);
            // Displaying JSON String
            System.out.println(jsonStr);
            System.out.println(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
