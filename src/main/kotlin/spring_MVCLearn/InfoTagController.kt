package spring_MVCLearn

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.servlet.ServletRequest


@Controller
@RequestMapping("/info")
class InfoTagController {
    @Autowired
    private val webAppContext: WebApplicationContext? = null
    private val startDateTime = LocalDateTime.now()
    private val DT_FORMATTER = DateTimeFormatter.ofPattern("EEE, d MMM yyyy h:mm a")

    @Autowired
    var propiedades: ConfiguratorProperties? = null

    @RequestMapping("/server")
    @ResponseBody
    fun infoTagServer(): String? {
        return StringJoiner("<br>", "<b>", "<b>")
                .add("-------------------------------------")
                .add(
                    "<H2> Server: " +
                            webAppContext!!.servletContext!!.serverInfo + "</H2>"
                )
                .add(
                    " Start date: " +
                            startDateTime.format(DT_FORMATTER)
                )
                .add(
                    " Version: " +
                            webAppContext.getBean("webAppVersion")
                )
                .add("--------------------------------------")
                .toString()
    }

    @RequestMapping("/helloHandler")
    @ResponseBody
    fun helloController(): String {
        return "Hello Kotlin with Spring"
    }

    @RequestMapping(value = ["/index"])
    fun getRequestExample(request: ServletRequest?): ModelAndView? {
        val mav = ModelAndView()
        mav.viewName = "index"
        mav.addObject("variable1", propiedades?.lista)
        return mav
    }

    @RequestMapping(value = ["/*"], method = [RequestMethod.GET])
    fun fallback(): String? {
        return "index"
    }

    @RequestMapping(value = ["/example/{param}"])
    fun example(@PathVariable("param") parameter: String): HttpEntity<String>? {
        var responseHeaders = HttpHeaders()
        responseHeaders.set("MyResponseHeader","MyValue")
        return HttpEntity(parameter,responseHeaders)
    }
}
