package spring_MVCLearn

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@Controller
@RequestMapping("/info")
class InfoTagController {
    @Autowired
    private val webAppContext: WebApplicationContext? = null
    private val startDateTime = LocalDateTime.now()
    private val DT_FORMATTER = DateTimeFormatter.ofPattern("EEE, d MMM yyyy h:mm a")

    @RequestMapping("/server")
    @ResponseBody
    fun infoTagServer(): String? {
        return StringJoiner("<br>","<b>","<b>")
                .add("-------------------------------------")
                .add("<H2> Server: " +
                        webAppContext!!.servletContext!!.serverInfo + "</H2>")
                .add(" Start date: " +
                        startDateTime.format(DT_FORMATTER))
                .add(" Version: " +
                        webAppContext.getBean("webAppVersion"))
                .add("--------------------------------------")
                .toString()
    }

    @RequestMapping("/helloHandler")
    @ResponseBody
    fun helloController(): String {
        return "Hello Kotlin with Spring"
    }
}