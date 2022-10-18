package com.example.doctor.controlador;


import com.example.doctor.modelo.Specialty;
import com.example.doctor.servicio.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SpecialtyControlador {
    @Autowired
    private SpecialtyService specialtyService;
    @GetMapping("/all")
    public List<Specialty> getSpecialty(){
        return specialtyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Specialty> getSpecialty(@PathVariable("id") int Id) {
        return specialtyService.getCategory(Id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty save(@RequestBody Specialty specialty) {
        return specialtyService.save(specialty);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Specialty update(@RequestBody Specialty specialty){
        return specialtyService.update(specialty);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return specialtyService.deleteCategory(id);
    }
}
