package com.example.doctor.controlador;


import com.example.doctor.modelo.Doctor;
import com.example.doctor.servicio.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DoctorControlador {
    @Autowired
    private DoctorService doctorService;
    @GetMapping("/all")
    public List<Doctor> getComputers(){
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getCabin(@PathVariable("id") int cabinId) {
        return doctorService.getDoctor(cabinId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return doctorService.deleteDoctor(id);
    }

}
