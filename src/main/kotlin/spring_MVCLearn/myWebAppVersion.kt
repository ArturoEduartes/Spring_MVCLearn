package spring_MVCLearn

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class myWebAppVersion {
    @Bean
    fun webAppVersion(): String {
        return "1.0.0"
    }
}