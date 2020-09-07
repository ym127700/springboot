package cn.bdqn;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {


    List<Student> list = new ArrayList<>();


    @Before
    public void init(){
        list.add(new Student(1001,"aaa",19,1));
        list.add(new Student(1002,"bbb",16,2));
        list.add(new Student(1003,"ccc",29,1));
        list.add(new Student(1004,"fff",32,1));
        list.add(new Student(1005,"ddd",17,3));
        list.add(new Student(1006,"ggg",23,3));
        list.add(new Student(1007,"eee",43,2));
        list.add(new Student(1008,"hhh",23,3));
        list.add(new Student(1009,"iii",51,1));
        list.add(new Student(1010,"kkk",22,1));
        list.add(new Student(1011,"xxx",16,2));
        list.add(new Student(1012,"nnn",32,3));
        list.add(new Student(1013,"lll",20,2));
        list.add(new Student(1014,"mmm",22,1));
    }


    @Test
    public void test1(){
        //获取流
        // 集合获取
        list.stream();  //串行流
        list.parallelStream();    //并行流(多线程)

        // 数组
        Stream.of(1,2,3,5,6,7,8,10);

        // generate
        Stream.generate(new Random()::nextInt).limit(100);
    }

    /**
     * 终止操作
     */
    @Test
    public void test2(){
        //list.stream().forEach(System.out::println);

        //Optional<Student> optional = list.stream().min((s1, s2) -> s1.getAge() < s2.getAge() ? -1 : 1);
        //Optional<Student> optional = list.stream().max((s1, s2) -> s1.getAge() < s2.getAge() ? -1 : 1);

       // List<Student> collect = list.stream().collect(Collectors.toList());
        //List<Integer> nums = Arrays.asList(1,2,5,58,2,3,5);
        //Set<Integer> collect = nums.stream().collect(Collectors.toSet());

        /*Map<Integer, StudentBo> map = list.stream().collect(Collectors.toMap(student -> student.getSno(), student -> {
            StudentBo bo = new StudentBo();
            bo.setAge(student.getAge());
            bo.setSchool("北大青鸟");
            return bo;
        }));*/

        //Map<Integer, Student> collect1 = list.stream().collect(Collectors.toMap(Student::getSno, student -> student));
        //Integer collect = list.stream().collect(Collectors.summingInt(stu -> stu.getAge()));

        //IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(stu -> stu.getAge()));


        //Student student = optional.get();
        //System.out.println(collect.getAverage());

       //Map<Boolean, List<Student>> collect = list.stream().collect(Collectors.partitioningBy(student -> student.getAge() < 30));

        //Map<Integer, List<Student>> collect = list.stream().collect(Collectors.groupingBy(student -> student.getCid(), Collectors.toList()));
        //System.out.println(collect);

    }

    @Test
    public void test3(){

        //Stream.of(1,2,3,2,3,2,4,1).distinct().forEach(System.out::println);
        //list.stream().sorted((stu1,stu2)->stu1.getAge()<stu2.getAge()?-1:1).forEach(System.out::println);
        //list.stream().skip(2).limit(3).forEach(System.out::println);

        //filter  查找
        //List<Student> collect = list.stream().filter(stu -> stu.getAge() > 25).collect(Collectors.toList());

        //map  循环修改原集合中对象的属性或者原集合中元素    循环原集合 变成另外的对象的集合
        /* List<StudentBo> collect = list.stream().map(stu -> {
            StudentBo bo = new StudentBo();
            bo.setAge(stu.getAge() + 10);
            bo.setSname(stu.getSname());
            return bo;
        }).collect(Collectors.toList());*/


        List<Integer> collect = list.stream().flatMap(student -> student.getList().stream()).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }


    @Test
    public void test4(){
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","30");

        ForkJoinPool pool = new ForkJoinPool(20);
        pool.submit( ()->{
            List<Integer> nums = Stream.generate(new Random()::nextInt).limit(1000).collect(Collectors.toList());
            nums.parallelStream().forEach(s->{
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"---"+s);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        pool.shutdown();
        new Scanner(System.in).next();
    }

}
