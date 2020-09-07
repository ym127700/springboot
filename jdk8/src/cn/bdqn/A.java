package cn.bdqn;

public interface A {

    int add(int num1,int num2);

    default int jian(int num1,int num2){
        return  num1-num2;
    }

}
