package com.sandeep.multi.db.service

import com.sandeep.multi.db.dto.TeacherDTO
import com.sandeep.multi.db.mysql.entity.toDTO
import com.sandeep.multi.db.mysql.repo.MySqlRepository
import org.springframework.stereotype.Service

@Service
class TeacherService(
    private val mySqlRepository: MySqlRepository
) {

    fun getAllTeachers(): List<TeacherDTO> = mySqlRepository.findAll().map {
        it.toDTO()
    }
}