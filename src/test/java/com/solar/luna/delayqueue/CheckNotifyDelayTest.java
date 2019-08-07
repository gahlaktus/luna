package com.solar.luna.delayqueue;

import com.solar.luna.LunaApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author huangzhibo
 * @date 2019-08-07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LunaApplication.class)
public class CheckNotifyDelayTest {

    @Test
    public void testPushNotice(){

        CheckNotifyManager manager = new CheckNotifyManager();
        manager.addNotice(new CheckNoticeDelay(1, System.currentTimeMillis() + 1000));//1s
        manager.addNotice(new CheckNoticeDelay(2, System.currentTimeMillis() + 6 * 1000));//6s
        manager.addNotice(new CheckNoticeDelay(3, System.currentTimeMillis() + 3 * 1000));//3s

        CheckRecordsPushTask task = new CheckRecordsPushTask(manager);
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Test
    public void testPushNotice1(){

        CheckNotifyRedisManager manager = new CheckNotifyRedisManager();
        manager.addNotice(new CheckNoticeDelay(1, System.currentTimeMillis() + 1000));//1s
        manager.addNotice(new CheckNoticeDelay(2, System.currentTimeMillis() + 6 * 1000));//6s
        manager.addNotice(new CheckNoticeDelay(3, System.currentTimeMillis() + 3 * 1000));//3s

        CheckRecordsRedisPushTask task = new CheckRecordsRedisPushTask(manager);
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //thread.interrupt();
    }

}