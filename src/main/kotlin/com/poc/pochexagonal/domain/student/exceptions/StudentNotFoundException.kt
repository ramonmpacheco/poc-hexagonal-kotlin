package com.poc.pochexagonal.domain.student.exceptions

class StudentNotFoundException(msg: String, val errorCode: String): RuntimeException(msg)