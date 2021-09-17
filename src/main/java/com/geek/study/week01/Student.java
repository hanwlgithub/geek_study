package com.geek.study.week01;

public class Student {
    public String pname;

    private String name;

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student(String pname, String name, Integer id) {
        this.pname = pname;
        this.name = name;
        this.id = id;
    }

    public Student() {
    }

    public String method1(){
        System.out.println("method1......");
        return "hello method1";
    }

}
