package org.example;

/**
 * Author（作者）：jtl
 * Date（日期）：2023/3/26 19:20
 * Detail（详情）：学生类
 */
public class Student extends Person{
    String name = "ZhangSan";// 对象引用：4字节
    boolean isRealMan;//boolean：1字节
    int age = 10;//boolean：1字节
    char score ='A';//char：2字节
    long time = 20230326;//long：8字节
    Student deskMate;//对象引用：4字节

    public Student() {
    }

    static int grade;

    public boolean isRealMan() {
        return isRealMan;
    }

    public void setRealMan(boolean realMan) {
        isRealMan = realMan;
    }
}
