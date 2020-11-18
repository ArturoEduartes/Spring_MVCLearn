// Sample from https://www.arquitecturajava.com/spring-boot-yaml-y-propiedades/
package spring_MVCLearn
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "datos")
class ConfiguratorProperties {
    var twitter: String? = null
    var web: String? = null
    var lista: List<String>? = null
}