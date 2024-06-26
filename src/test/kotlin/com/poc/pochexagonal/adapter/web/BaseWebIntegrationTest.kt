package com.poc.pochexagonal.adapter.web

import com.poc.pochexagonal.PocHexagonalApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc


@SpringBootTest(
    classes = arrayOf(PocHexagonalApplication::class),
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BaseWebIntegrationTest {
    @Autowired
    lateinit var mvc: MockMvc
}