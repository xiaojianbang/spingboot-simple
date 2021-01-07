package cn.xiaojianbang.common.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Created by lf on 2021/1/7
 */
@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    /**
     * 判断监控检查
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 自定义监控检查信息
        if (1 == 1 ){
            builder.status(Status.UP);
        }else {
            builder.status(Status.OUT_OF_SERVICE);
        }

        builder.withDetail("code","200");
    }
}
