package com.example.doctor.repositorio.crud;


import com.example.doctor.modelo.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
}
