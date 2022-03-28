package tech.bulbytech.ke.employeemanager.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.bulbytech.ke.employeemanager.models.Employee
import tech.bulbytech.ke.employeemanager.services.EmployeeService
import java.util.*
import javax.transaction.Transactional


@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/employee")

class EmployeeController(val employeeService: EmployeeService) {

    @GetMapping("/all")
    fun  getAllEmployees(): ResponseEntity<List<Employee>> {
        return  ResponseEntity.ok(employeeService.findAllEmployees())
    }

    //find employee by id
    @GetMapping("/find/{id}")
    fun getEmployeeById(@PathVariable("id") id: Long): ResponseEntity<Optional<Employee>> {
        return ResponseEntity.ok(employeeService.findEmployeeById(id))
    }

    //Add an employee
    @PostMapping("/add")
    fun addEmployee(@RequestBody employee: Employee): ResponseEntity<Employee>{
        return  ResponseEntity.ok(employeeService.addEmployee(employee))
    }
    //update employee
    @PutMapping("/update")
    fun updateEmployee(@RequestBody employee: Employee): ResponseEntity<Employee>{
        return  ResponseEntity.ok(employeeService.updateEmployee(employee))
    }

    //Delete an employee
    @Transactional
    @DeleteMapping("/delete/{id}")
    fun deleteEmployee(@PathVariable("id") id: Long): Any {
        return ResponseEntity.ok(employeeService.deleteEmployee(id))
    }
}