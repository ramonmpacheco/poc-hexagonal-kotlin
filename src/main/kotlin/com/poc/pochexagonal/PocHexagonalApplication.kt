package com.poc.pochexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("com.poc.pochexagonal"))
class PocHexagonalApplication

fun main(args: Array<String>) {
	runApplication<PocHexagonalApplication>(*args)
}
