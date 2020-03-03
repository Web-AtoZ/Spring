package com.test.hello.interfaces;

// 임시생성클래스 추후 개발시 삭제예정
public class Student {

    private String name;
    private int age;
    private String contact;

    public Student(String name, int age, String contact) {
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getStudentName() {
        return name;
    }

    public int getStudentAge() {
        return age;
    }

    public String getStudentContact() {
        return contact;
    }

}
