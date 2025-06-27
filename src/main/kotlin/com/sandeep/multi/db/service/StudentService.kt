package com.sandeep.multi.db.service

import com.sandeep.multi.db.postgres.entity.toDTO
import com.sandeep.multi.db.postgres.repo.PostgresRepository
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val postgresRepository: PostgresRepository
) {

    fun getAllStudents() = postgresRepository.findAll().map {
        it.toDTO()
    }
}