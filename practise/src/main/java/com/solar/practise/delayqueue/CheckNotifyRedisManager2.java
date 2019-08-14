package com.solar.practise.delayqueue;

import com.solar.practise.config.redis.ApplicationContextUtil;
import com.solar.practise.util.CommonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.Assert;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author huangzhibo
 * @date 2019-08-07
 */
public class CheckNotifyRedisManager2 {

    private JedisCluster jedisCluster;

    private final Object waitLock = new Object();

    public CheckNotifyRedisManager2(){
        this.jedisCluster= (JedisCluster) ApplicationContextUtil.getBean("jedisCluster");
    }

    public boolean addNotice(CheckNoticeDelay notice){
        Assert.notNull(notice, "");
        jedisCluster.zadd("delay_queue_key_test", Double.longBitsToDouble(notice.getDelayTime()), CommonUtils.toJsonString(notice));
        synchronized (waitLock){
            waitLock.notifyAll();
        }
        return Boolean.TRUE;
    }

    public List<CheckNoticeDelay> takeNotice() throws Exception {
        while (true){
            Set<String> obj = jedisCluster.zrangeByScore("delay_queue_key_test", -1, System.currentTimeMillis());
            if (CollectionUtils.isNotEmpty(obj)){
                List<CheckNoticeDelay> delays = obj.stream().map(o -> CommonUtils.toJavaObject(o, CheckNoticeDelay.class)).collect(Collectors.toList());
                return delays;
            }
            synchronized (waitLock){
                waitLock.wait();
            }
        }
    }

}
