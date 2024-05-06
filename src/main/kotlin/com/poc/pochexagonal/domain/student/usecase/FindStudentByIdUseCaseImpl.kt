package com.poc.pochexagonal.domain.student.usecase

import com.poc.pochexagonal.domain.enums.ErrorCodes.HEX001
import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.exceptions.StudentNotFoundException
import com.poc.pochexagonal.domain.student.ports.input.FindStudentByIdUseCaseInterface
import com.poc.pochexagonal.domain.student.ports.output.StudentPersistenceInterface
import javax.inject.Named

@Named
class FindStudentByIdUseCaseImpl(private val studentData: StudentPersistenceInterface) :
    FindStudentByIdUseCaseInterface {

    override fun findById(id: String): Student {
        return studentData.findById(id)
            ?: throw StudentNotFoundException(HEX001.msg.format("Student with id: $id"), HEX001.code)
    }
}
