package com.solar.practise.patterndesign.factory;

/**
 * @author huangzhibo
 * @date 2019-10-24
 */
public class OperationDiv extends Operation{

    @Override
    protected double getResult() {
        if (getVal2() != 0){
            return getVal1() / getVal2();
        }
        throw new IllegalArgumentException("除数不能为0");
    }
}
