package com.example.doctor.repositorio;


import com.example.doctor.modelo.Doctor;
import com.example.doctor.repositorio.crud.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }

    public Optional<Doctor> getDoctor(int id){
        return doctorCrudRepository.findById(id);
    }

    public Doctor save(Doctor cabin){
        return doctorCrudRepository.save(cabin);
    }

    public void delete(Doctor cabin){
        doctorCrudRepository.delete(cabin);
    }
}
