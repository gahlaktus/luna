package com.solar.luna.feign.demo;

import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.List;

/**
 * @author huangzhibo
 * @date 2019-08-09
 */
public class FeignDemo {

    public static void main(String[] args) {

        Github github = Feign.builder()
                .decoder(new GsonDecoder())
                .target(Github.class, "https://api.github.com");

        List<Contributor> contributors = github.cotributors("OpenFeign", "feign");
        for (Contributor contributor : contributors){
            System.out.println(contributor.getLogin() + "(" + contributor.getContributions() + ")");
        }
    }

}
