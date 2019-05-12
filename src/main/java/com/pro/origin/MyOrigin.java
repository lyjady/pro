package com.pro.origin;

public class MyOrigin {
    public static void main(String[] args) {
        System.out.println("Hello Origin");
    }

    public static void doGet() {
        System.out.println("MyOrigin.doGet");
        System.out.println("service")
    }

    public static void doPost() {
        System.out.println("MyOrigin.doPost");
    }
}
