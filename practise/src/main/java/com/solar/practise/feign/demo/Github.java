package com.solar.practise.feign.demo;

import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @author huangzhibo
 * @date 2019-08-09
 */
public interface Github {

    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> cotributors(@Param("owner") String owner, @Param("repo") String repo);

}
