package top.wale.rw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.wale.rw.base.utils.SpringUtil;

/**
 * Function:
 *
 * @author wale
 * @date 2019/11/29
 */
@Configuration
public class BaseConfiguration {

    @Bean
    public SpringUtil springUtil(){
        return new SpringUtil();
    }
}
