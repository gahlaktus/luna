package com.solar.practise.patterndesign.factory;

/**
 * @author huangzhibo
 * @date 2019-10-24
 */
public class DivFactory implements IFactory{

    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
