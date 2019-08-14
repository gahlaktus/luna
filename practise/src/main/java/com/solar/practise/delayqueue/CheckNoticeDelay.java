package com.solar.practise.delayqueue;

import com.solar.practise.util.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 构建消息体
 *
 * <p>java.util.concurrent.Delayed 接口</p>
 *
 * @author huangzhibo
 * @date 2019-08-07
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckNoticeDelay implements Delayed {

    private Integer recordId;
    private long delayTime;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) {
            return 1;
        }
        if (o == this) {
            return 0;
        }
        long diff = this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
        return diff > 0 ? 1 : diff == 0 ? 0 : -1;
    }

    @Override
    public String toString() {
        return CommonUtils.toJsonString(this);
    }
}
