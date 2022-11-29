package cinema.controllers;

import cinema.entities.Cinema;
import cinema.entities.Statistics;
import cinema.entities.Token;
import cinema.entities.Seats;
import cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Map;

@RestController
public class SeatingPlanController {
    
    private final CinemaService cinemaService;

    @Autowired
    public SeatingPlanController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public Cinema getCinemaInfo() {
        return cinemaService.getCinemaInfo();
    }

    @PostMapping(path = "/purchase", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> purchaseTicket(@RequestBody Seats targetSeat) {
        return cinemaService.generateTicket(targetSeat);
    }

    @PostMapping(path = "/return", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Seats> returnTicket(@RequestBody Token token) {
        return cinemaService.returnTicket(token);
    }

    @PostMapping(path = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public Statistics getStatistics(@RequestParam(required = false) String password) {
        return cinemaService.getStatistics(password);
    }

}
