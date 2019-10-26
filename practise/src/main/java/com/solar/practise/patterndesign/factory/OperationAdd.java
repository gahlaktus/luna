package com.solar.practise.patterndesign.factory;

/**
 * @author huangzhibo
 * @date 2019-10-24
 */
public class OperationAdd extends Operation {

    @Override
    protected double getResult() {
        return getVal1() + getVal2();
    }
}
