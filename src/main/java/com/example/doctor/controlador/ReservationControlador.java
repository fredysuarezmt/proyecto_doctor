package com.example.doctor.controlador;


import com.example.doctor.modelo.Reservation;
import com.example.doctor.modelo.dtos.CountClient;
import com.example.doctor.modelo.dtos.CountStatus;
import com.example.doctor.servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationControlador {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return reservationService.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReportClientesTop(){
        return reservationService.getClientesTop();
    }

    @GetMapping("report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReportReservationBetweenDays(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsBetweenDays(dateOne, dateTwo);
    }

    @GetMapping("report-status")
    public CountStatus getReportSatatus(){
        return reservationService.getReservationsStatus();
    }

}
