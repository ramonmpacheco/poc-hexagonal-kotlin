package com.poc.pochexagonal.adapter.web.controllers

import com.poc.pochexagonal.adapter.web.requests.CreateStudentRequest
import com.poc.pochexagonal.adapter.web.responses.StudentResponse
import com.poc.pochexagonal.adapter.web.responses.toStudentResponse
import com.poc.pochexagonal.domain.student.ports.input.CreateStudentUseCaseInterface
import com.poc.pochexagonal.domain.student.ports.input.FindStudentByIdUseCaseInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student-management")
class StudentController(
    private val createStudentUseCase: CreateStudentUseCaseInterface,
    private val findStudentByIdUseCase: FindStudentByIdUseCaseInterface
) {
    @PostMapping("/v1/students")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateStudentRequest): StudentResponse =
        createStudentUseCase.save(request.toStudent())
            .toStudentResponse()

    @GetMapping("/v1/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): StudentResponse =
        findStudentByIdUseCase.findById(id)
            .toStudentResponse()
}
