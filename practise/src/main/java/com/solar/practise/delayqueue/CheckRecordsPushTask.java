package com.solar.practise.delayqueue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Task，不断从延时队列取消息并发送push
 *
 * @author huangzhibo
 * @date 2019-08-07
 */
@Slf4j
@AllArgsConstructor
public class CheckRecordsPushTask implements Runnable {

    private CheckNotifyManager manager;

    @Override
    public void run() {

        while (true) {
            try {
                CheckNoticeDelay delay = manager.takeNotice();
                if (delay != null) {
                    log.info("push msg, recordId:{}", delay.getRecordId());
                }
            } catch (InterruptedException e) {
                log.error("Thread is interrupted");
            }
        }

    }
}
