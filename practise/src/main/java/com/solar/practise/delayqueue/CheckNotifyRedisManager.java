package com.solar.practise.delayqueue;

import com.solar.practise.config.redis.ApplicationContextUtil;
import com.solar.practise.util.CommonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.Assert;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author huangzhibo
 * @date 2019-08-07
 */
public class CheckNotifyRedisManager {

    private JedisCluster jedisCluster;

    public CheckNotifyRedisManager(){
        this.jedisCluster= (JedisCluster)ApplicationContextUtil.getBean("jedisCluster");
    }

    public boolean addNotice(CheckNoticeDelay notice){
        Assert.notNull(notice, "");
        jedisCluster.zadd("delay_queue_key_test", Double.longBitsToDouble(notice.getDelayTime()), CommonUtils.toJsonString(notice));
        return Boolean.TRUE;
    }

    public List<CheckNoticeDelay> takeNotice(){
        Set<String> obj = jedisCluster.zrangeByScore("delay_queue_key_test", -1, System.currentTimeMillis());
        return CollectionUtils.isNotEmpty(obj) ? obj.stream().map(o -> CommonUtils.toJavaObject(o, CheckNoticeDelay.class)).collect(Collectors.toList()) : Collections.emptyList();
    }
}
