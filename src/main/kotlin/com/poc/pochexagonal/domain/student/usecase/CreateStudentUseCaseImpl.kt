package com.poc.pochexagonal.domain.student.usecase

import com.poc.pochexagonal.domain.enums.ErrorCodes.HEX002
import com.poc.pochexagonal.domain.student.Student
import com.poc.pochexagonal.domain.student.exceptions.StudentInvalidException
import com.poc.pochexagonal.domain.student.ports.input.CreateStudentUseCaseInterface
import com.poc.pochexagonal.domain.student.ports.output.StudentPersistenceInterface
import javax.inject.Named

@Named
class CreateStudentUseCaseImpl(private val studentData: StudentPersistenceInterface) : CreateStudentUseCaseInterface {

    override fun save(student: Student): Student {
        if (!student.isValid()) {
            throw StudentInvalidException(HEX002.msg.format("Sorry, check the information provided."), HEX002.code)
        }
        return studentData.save(student)
    }
}
