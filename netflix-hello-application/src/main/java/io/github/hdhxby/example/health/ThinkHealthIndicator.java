package io.github.hdhxby.example.health;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * spring boot 健康检查
 *
 * @author lixiaobin
 * @version 2.0, 03/06/21
 * @since 2.0
 */
public class ThinkHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().build();
    }
}
