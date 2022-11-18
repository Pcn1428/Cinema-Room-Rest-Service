package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SeatingPlanController {
    
    private SeatingPlan seatingPlan = new SeatingPlan(9,9);

    @GetMapping("/seats")
    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }
}
