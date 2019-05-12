package com.pro;

import com.pro.Entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    private static List<Person> persons = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        Person p1 = new Person("Jack", "18293847394");
        Person p2 = new Person("Rose", "10928472845");
        Person p3 = new Person("Anna", "19283902934");
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        addId();
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("*******************欢迎使用通讯录*******************");
        System.out.println("---------------------------------------------------");
        System.out.println("*                    请选择功能                    *");
        System.out.println("* 1.查看通讯录 2.添加联系人 3.删除联系人 4.修改联系人 *");

        while (true) {
            System.out.print("* 请输入对应的功能编号:");
            Integer function = scanner.nextInt();
            switch (function) {
                case 1:
                    lookPerson();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    modifyPerson();
                    break;
            }
        }
    }

    public static void lookPerson() {
        for (Person person : persons) {
            System.out.println("编号:" + person.getId() + " 姓名:" + person.getName() + " 号码:" + person.getTel());
        }
    }

    public static void addPerson() {
        System.out.print("请输入联系人的姓名:");
        String name = scanner.next();
        System.out.print("请输入联系人的电话号码");
        String tel = scanner.next();
        Person person = new Person(name, tel);
        persons.add(person);
        addId();
    }

    public static void deletePerson() {
        System.out.print("输入要删除联系人的编号(输入0返回)");
        int id = scanner.nextInt();
        if (id != 0) {
            System.out.println("确定删除?(1:确定,0:取消)");
            int del = scanner.nextInt();
            if (del == 1) {
                persons.remove(id - 1);
                addId();
            } else {
                return;
            }
        } else if (id == 0) {
            return;
        }
    }

    public static void modifyPerson() {
        System.out.print("输入要修改联系人的编号:");
        int id = scanner.nextInt();
        System.out.print("输入新联系人的名称:");
        String name = scanner.next();
        System.out.print("输入新联系人的号码:");
        String tel = scanner.next();
        Person person = persons.get(id - 1);
        person.setName(name);
        person.setTel(tel);
    }

    public static void addId() {
        int i = 1;
        if (persons != null && persons.size() > 0) {
            for (Person person : persons) {
                person.setId(i);
                i++;
            }
        }
    }
}
