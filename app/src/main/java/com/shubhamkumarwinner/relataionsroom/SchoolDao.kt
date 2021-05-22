package com.shubhamkumarwinner.relataionsroom

import androidx.room.*
import com.shubhamkumarwinner.relataionsroom.entities.Director
import com.shubhamkumarwinner.relataionsroom.entities.School
import com.shubhamkumarwinner.relataionsroom.entities.Student
import com.shubhamkumarwinner.relataionsroom.entities.Subject
import com.shubhamkumarwinner.relataionsroom.entities.relations.*

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("select * from school where schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudent>

    @Transaction
    @Query("select * from subject where subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("select * from student where studentName = :studentName")
    suspend fun getSubjectOfStudent(studentName: String): List<StudentWithSubjects>
}