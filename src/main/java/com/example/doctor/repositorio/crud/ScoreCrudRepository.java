package com.example.doctor.repositorio.crud;



import com.example.doctor.modelo.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository <Score, Integer> {
}
