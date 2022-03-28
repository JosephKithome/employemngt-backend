package tech.bulbytech.ke.employeemanager.repositories

import org.springframework.data.jpa.repository.JpaRepository
import tech.bulbytech.ke.employeemanager.models.Employee
import java.util.Optional

interface EmployeeRepository:JpaRepository<Employee, Long> {

    fun findEmployeeById(id: Long): Optional<Employee>
    fun deleteEmployeeById(id: Long)
}