package com.sandeep.multi.db.postgres.repo

import com.sandeep.multi.db.postgres.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostgresRepository : JpaRepository<Student, Long>