package tech.bulbytech.ke.employeemanager.models

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity

data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    val id: Long,
    val name: String,
    val email: String,
    val jobTitle: String,
    val phone: String,
    val imageUrl: String,
    @Column(nullable = false, updatable = false)
    var employeeCode: String = UUID.randomUUID().toString()
): java.io.Serializable
