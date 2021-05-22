package com.shubhamkumarwinner.relataionsroom

import androidx.room.*
import com.shubhamkumarwinner.relataionsroom.entities.Director
import com.shubhamkumarwinner.relataionsroom.entities.School
import com.shubhamkumarwinner.relataionsroom.entities.relations.SchoolAndDirector

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>
}