package org.springframework.boot.autoconfigure.lock;

import org.springframework.boot.autoconfigure.lock.config.KlockConfig;
import org.springframework.boot.autoconfigure.lock.lock.LockFactory;
import org.springframework.boot.autoconfigure.lock.core.BusinessKeyProvider;
import org.springframework.boot.autoconfigure.lock.core.KlockAspectHandler;
import org.springframework.boot.autoconfigure.lock.core.LockInfoProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by kl on 2017/12/29.
 * Content :适用于内部低版本spring mvc项目配置,redisson外化配置
 */
@Configuration
@Import({KlockAspectHandler.class})
public class KlockConfiguration {
    @Bean
    public LockInfoProvider lockInfoProvider(){
        return new LockInfoProvider();
    }

    @Bean
    public BusinessKeyProvider businessKeyProvider(){
        return new BusinessKeyProvider();
    }

    @Bean
    public LockFactory lockFactory(){
        return new LockFactory();
    }
    @Bean
    public KlockConfig klockConfig(){
        return new KlockConfig();
    }
}
