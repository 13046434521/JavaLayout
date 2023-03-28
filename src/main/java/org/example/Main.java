package org.example;

import org.openjdk.jol.info.ClassLayout;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();
        System.out.println("-----------------------------第一阶段 new 对象-------------------------------");
        System.out.println(ClassLayout.parseInstance(student).toPrintable());

        System.out.println("-----------------------------第二阶段 hashcode-------------------------------");
        student.hashCode();
        System.out.println(ClassLayout.parseInstance(student).toPrintable());



        synchronized (student){
            System.out.println("-----------------------------第三阶段 synchronized加锁-------------------------------");
            System.out.println("synchronized (student)：\n"+ClassLayout.parseInstance(student).toPrintable());
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (student){
                    System.out.println("-----------------------------第四阶段 synchronized加锁-------------------------------");
                    System.out.println("new Thread:synchronized (student)：\n"+ClassLayout.parseInstance(student).toPrintable());
                }
            }
        }).start();

        synchronized (student) {
            System.out.println("-----------------------------第五阶段 Student[] 数组-------------------------------");
            System.out.println(ClassLayout.parseInstance(new Student[]{new Student(), new Student(), new Student()}).toPrintable());
        }
    }
}