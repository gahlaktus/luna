package com.solar.practise.delayqueue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author huangzhibo
 * @date 2019-08-07
 */
@Slf4j
@AllArgsConstructor
public class CheckRecordsRedisPushTask implements Runnable {


    private CheckNotifyRedisManager manager;

    @Override
    public void run() {

        while (true) {
            try {
                List<CheckNoticeDelay> delays = manager.takeNotice();
                if (delays != null) {
                    log.info("push msg, recordId:{}", delays);
                }
            } catch ( Exception e) {
                log.error("Thread is interrupted", e);
            }
        }

    }

}
