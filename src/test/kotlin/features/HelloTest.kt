package features

import xyz.frish2021.App;
import org.junit.Test
import org.junit.runner.RunWith
import org.noear.solon.test.HttpTester
import org.noear.solon.test.SolonJUnit4ClassRunner
import org.noear.solon.test.SolonTest

@RunWith(SolonJUnit4ClassRunner::class)
@SolonTest(App::class)
open class HelloTest : HttpTester() {
    @Test
    fun hello() {
        assert(path("/hello?name=world").get().contains("world"))
        assert(path("/hello?name=solon").get().contains("solon"))
    }
}