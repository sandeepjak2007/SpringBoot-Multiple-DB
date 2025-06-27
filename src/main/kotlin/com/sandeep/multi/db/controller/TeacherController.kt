package com.sandeep.multi.db.controller

import com.sandeep.multi.db.service.TeacherService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/teacher")
class TeacherController(
    private val teacherService: TeacherService
) {

    @GetMapping
    fun getAllTeacher(): ResponseEntity<Any> = try {
        ResponseEntity.ok(teacherService.getAllTeachers())
    } catch (e: Exception) {
        e.printStackTrace()
        ResponseEntity.internalServerError().body("Error in fetching Teacher's list")
    }
}