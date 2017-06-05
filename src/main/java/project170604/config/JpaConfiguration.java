package project170604.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by lyp on 2017/6/4.
 */

@Configuration
@EnableJpaRepositories(basePackages = "project170604.dao")
public class JpaConfiguration {
}
