package cn.bdqn;

import org.junit.Test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class lambda {

    @Test
    public void test1(){
        /*A a = new AImpl();
        int add = a.add(10, 20);
        System.out.println(add);
        System.out.println(a.jian(20,10));*/
    }

    @Test
    public void test2(){
        A a = (num1,num2)->num1+num2;
        int add = a.add(10, 20);
        System.out.println(add);
        System.out.println(a.jian(20,10));
    }

    @Test
    public void test3(){
        final int aaaa  = 100;

        A a = (num1,num2)->{
            return num1+num2+aaaa;
        };
        System.out.println(a.add(1,20));

    }




    public void test4(A a){
        System.out.println(a.add(10,20));
    }

    @Test
    public void test5(){
        test4( (num1,num2)->num1*num2 );
    }

    @Test
    public void test6(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1001,"ggg",18));
        list.add(new Student(1006,"fdg",20));
        list.add(new Student(1003,"fgd",16));
        list.add(new Student(1002,"dfa",30));
        list.add(new Student(1007,"Ar",19));

        //以学号进行排序
        //list.sort( (stu1,stu2)->stu1.getAge()>stu2.getAge()?1:-1 );

        //以名称排序
        list.sort( (stu1,stu2)->stu1.getSname().compareTo(stu2.getSname()));


        list.forEach(System.out::println);

    }

    @Test
    public void test7(){
        Consumer<Integer> a = (x)-> System.out.println(x*100);
        a.accept(100);
    }


    @Test
    public void test8(){
        Function<Integer,String> f = (a)->a+"武汉创美";
        String apply = f.apply(10086);
        System.out.println(apply);
    }

    @Test
    public void test9(){
        Predicate<Student> p = (stu)->stu.getAge()>20;
        boolean zx = p.test(new Student(1001, "赵鑫", 22));
        System.out.println(zx);
    }

    @Test
    public void test10(){
        Supplier<String> s = ()->"波哥很帅";
        System.out.println(s.get());
    }


    @Test
    public void test11(){
        //构造方法
        Supplier<Student> s = Student::new;

        //静态方法
        Consumer<String> c = Student::show;

        //对象(实例)的方法
        Student student = s.get();
        Consumer<Student> d = student::show1;
        d.accept(new Student(1001,"zhaan",19));

    }







}
