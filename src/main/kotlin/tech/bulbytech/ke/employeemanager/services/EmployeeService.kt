package tech.bulbytech.ke.employeemanager.services

import org.springframework.stereotype.Service
import tech.bulbytech.ke.employeemanager.exceptions.EmployeeNotFoundException
import tech.bulbytech.ke.employeemanager.models.Employee
import tech.bulbytech.ke.employeemanager.repositories.EmployeeRepository
import java.util.*


@Service
class EmployeeService(val employeeRepository: EmployeeRepository) {


    //Add an employee
    fun addEmployee(employee: Employee): Employee {
        employee.employeeCode = UUID.randomUUID().toString()
        return employeeRepository.save(employee)
    }

    //get all employees
    fun findAllEmployees(): List<Employee>{
        return employeeRepository.findAll()
    }

    //update an employee
    fun updateEmployee(employee: Employee): Employee{
        return employeeRepository.save(employee)
    }
    //find employee by id
    fun findEmployeeById(id: Long): Optional<Employee> {
        return employeeRepository.findEmployeeById(id)
    }
    //delete employee
    fun deleteEmployee(id: Long){
        return employeeRepository.deleteEmployeeById(id)
    }
}