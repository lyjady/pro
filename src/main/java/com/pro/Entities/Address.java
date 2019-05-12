package com.pro.Entities;

public class Address {
    private int id;
    private String department;
    private String name;
    private String post;
    private String office;
    private String home;
    private String tel;

    public Address() {
    }

    public Address(int id, String department, String name, String post, String office, String home, String tel) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.post = post;
        this.office = office;
        this.home = home;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", office='" + office + '\'' +
                ", home='" + home + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
