package com.example.doctor.repositorio.crud;


import com.example.doctor.modelo.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}
