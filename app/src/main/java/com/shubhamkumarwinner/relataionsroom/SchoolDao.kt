package com.shubhamkumarwinner.relataionsroom

import androidx.room.*
import com.shubhamkumarwinner.relataionsroom.entities.Director
import com.shubhamkumarwinner.relataionsroom.entities.School
import com.shubhamkumarwinner.relataionsroom.entities.Student
import com.shubhamkumarwinner.relataionsroom.entities.relations.SchoolAndDirector
import com.shubhamkumarwinner.relataionsroom.entities.relations.SchoolWithStudent

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudent>
}