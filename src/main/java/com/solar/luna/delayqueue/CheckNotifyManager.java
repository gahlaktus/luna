package com.solar.luna.delayqueue;

import org.springframework.util.Assert;

import java.util.concurrent.DelayQueue;

/**
 * 队列管理
 *
 * @author huangzhibo
 * @date 2019-08-07
 */
public class CheckNotifyManager {

    private DelayQueue<CheckNoticeDelay> pushQueue = new DelayQueue<>();

    public boolean addNotice(CheckNoticeDelay notice) {
        Assert.notNull(notice, "");
        return pushQueue.offer(notice);
    }

    public CheckNoticeDelay takeNotice() throws InterruptedException {
        return pushQueue.take();
    }

}
