/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package spring_MVCLearn

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

/**
 * @author Arturo
 */
@SpringBootApplication
@EnableConfigurationProperties(ConfiguratorProperties::class)
class SpringMVCApplication {
    val greeting: String = "Hello Spring World!"
        /*get() {
            return "Hello world."
        }*/
    @Bean
    fun init(): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            println(SpringMVCApplication().greeting)
        }
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            runApplication<SpringMVCApplication>(*args)
        }
    }
}