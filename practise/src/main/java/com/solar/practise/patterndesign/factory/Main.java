package com.solar.practise.patterndesign.factory;

/**
 * @author huangzhibo
 * @date 2019-10-24
 */
public class Main {

    public static void main(String[] args) {
        // new 对象
        OperationAdd add = new OperationAdd();
        add.setVal1(10);
        add.setVal2(5);
        System.out.println(add.getResult());
        // 简单工厂
        Operation add1 = OperationFactory.createOperation("+");
        add1.setVal1(10);
        add1.setVal2(5);
        System.out.println(add1.getResult());
        // 工厂方法模式
        IFactory factory = new AddFactory();
        Operation add3 = factory.createOperation();
        add3.setVal1(10);
        add3.setVal2(5);
        System.out.println(add3.getResult());


    }

}
