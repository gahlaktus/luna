package com.solar.practise.patterndesign.builder;

/**
 * @author huangzhibo
 * @date 2019-08-09
 */
public class Person {

    private String name;

    private int age;

    private String sex;

    protected Person(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
    }

    public static class Builder{

        private String name;

        private int age;

        private String sex;

        public Builder(String name){
            this.name = name;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder sex(String sex){
            this.sex = sex;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
