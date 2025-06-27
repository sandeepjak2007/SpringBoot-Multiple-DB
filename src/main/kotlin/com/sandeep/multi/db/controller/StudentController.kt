package com.sandeep.multi.db.controller

import com.sandeep.multi.db.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/student")
class StudentController(
    private val studentService: StudentService
) {

    @GetMapping
    fun getStudentsList(): ResponseEntity<Any> = try {
        ResponseEntity.ok(studentService.getAllStudents())

    } catch (e: Exception) {
        e.printStackTrace()
        ResponseEntity.internalServerError().body("Error in fetching student list")
    }
}