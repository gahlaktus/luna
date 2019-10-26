package com.solar.practise.patterndesign.factory;

/**
 * 工厂类
 *
 * @author huangzhibo
 * @date 2019-10-24
 */
public class OperationFactory {

    public static Operation createOperation(String operation){

        Operation oper;

        switch (operation){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
            default:
                throw new UnsupportedOperationException("不支持该操作");
        }
        return oper;

    }

}
