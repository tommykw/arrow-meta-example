package com.github.tommykw.arrow.meta.example

import arrow.meta.CliPlugin
import arrow.meta.Meta
import arrow.meta.invoke
import arrow.meta.quotes.Transform
import arrow.meta.quotes.namedFunction

val Meta.hello: CliPlugin
    get() =
        "Hello" {
            meta(
                namedFunction(this, { name == "hello" }) { c ->
                    Transform.replace(
                        replacing = c,
                        newDeclaration =
                        """|fun hello(): Unit =
                           |    println("Hello")
                           |""".function.syntheticScope
                    )
                }
           )
        }