package com.solar.practise.patterndesign.factory;

import lombok.Getter;
import lombok.Setter;

/**
 * @author huangzhibo
 * @date 2019-10-24
 */
@Getter
@Setter
public abstract class Operation {

    private double val1;

    private double val2;

    protected abstract double getResult();

}
