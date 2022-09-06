package io.github.hdhxby.example.health;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;

/**
 * spring cloud 健康检查
 *
 * @author lixiaobin
 * @version 2.0, 03/06/21
 * @since 2.0
 */
public class ThinkHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private ThinkHealthIndicator thinkHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus currentStatus) {
        if (Status.UP.equals(thinkHealthIndicator.health().getStatus())) {
            return InstanceInfo.InstanceStatus.UP;
        }
        if (Status.DOWN.equals(thinkHealthIndicator.health().getStatus())) {
            return InstanceInfo.InstanceStatus.DOWN;
        }
        if (Status.OUT_OF_SERVICE.equals(thinkHealthIndicator.health().getStatus())) {
            return InstanceInfo.InstanceStatus.OUT_OF_SERVICE;
        }
        return InstanceInfo.InstanceStatus.UNKNOWN;
    }

}
