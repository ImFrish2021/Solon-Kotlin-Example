package xyz.frish2021

import org.noear.solon.Solon
import org.noear.solon.Solon.start
import org.noear.solon.annotation.SolonMain

@SolonMain
class App : Solon()

fun main(args : Array<String>) {
    start(App::class.java, args) { app -> {
            // 没啥用
        }
    };
}
