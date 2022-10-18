package com.example.doctor.servicio;

import com.example.doctor.modelo.Specialty;
import com.example.doctor.repositorio.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository categoryRepository;

    public List<Specialty> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Specialty> getCategory(int id){
        return categoryRepository.getSpecialty(id);
    }

    public Specialty save(Specialty specialty) {
        if (specialty.getId() == null) {
            return categoryRepository.save(specialty);
        } else {
            Optional<Specialty> category1 = categoryRepository.getSpecialty(specialty.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(specialty);
            } else {
                return specialty;
            }
        }
    }

    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty>g= categoryRepository.getSpecialty(specialty.getId());
            if(!g.isEmpty()){
                if(specialty.getDescription()!=null){
                    g.get().setDescription(specialty.getDescription());
                }
                if(specialty.getName()!=null){
                    g.get().setName(specialty.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return specialty;
    }


    public boolean deleteCategory (int id){
        Boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

}
