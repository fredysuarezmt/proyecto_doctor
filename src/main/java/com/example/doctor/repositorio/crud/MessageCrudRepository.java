package com.example.doctor.repositorio.crud;


import com.example.doctor.modelo.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
