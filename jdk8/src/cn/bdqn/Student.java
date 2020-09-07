package cn.bdqn;

import java.util.Comparator;
import java.util.List;

public class Student{
    private  Integer sno;
    private  String sname;
    private  Integer age;
    private Integer cid;
    private List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Integer sno, String sname, Integer age, Integer cid) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
        this.cid = cid;
    }

    public Student(Integer sno, String sname, Integer age) {
        this.sno = sno;
        this.sname = sname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", cid=" + cid +
                '}';
    }

    public Student() {

    }

    public void show1(Student student){
        System.out.println(student);
    }



    public static void show(String name){
        System.out.println(name+"果然很帅!");
    }

}
