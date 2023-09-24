package xyz.frish2021.Controller

import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Get
import org.noear.solon.annotation.Mapping
import org.noear.solon.core.handle.ModelAndView

@Controller
class indexController {

    @Get
    @Mapping("/")
    fun index() : String {
        return "Hello World"
    }

    @Mapping("/index")
    fun hello() : ModelAndView {
        return ModelAndView("/index.html")
    }
}
