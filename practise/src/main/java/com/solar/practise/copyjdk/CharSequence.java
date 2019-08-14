package com.solar.practise.copyjdk;


/**
 * @author huangzhibo
 * @date 2019-08-12
 */
public interface CharSequence {

    int length();

    char charAt(int index);

    CharSequence subSequence(int start, int end);

    @Override
    public String toString();

}
