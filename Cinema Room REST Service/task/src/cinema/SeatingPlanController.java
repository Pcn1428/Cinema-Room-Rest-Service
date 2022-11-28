package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class SeatingPlanController {
    
    private SeatingPlan seatingPlan = new SeatingPlan(9,9);

    @GetMapping("/seats")
    public SeatingPlan getSeatingPlan() {
        return seatingPlan;
    }

    @PostMapping("/purchase")
    public ResponseEntity<Map> purchaseSeat(@RequestBody UserInfo user) {
        Seats s = seatingPlan.searchAvailableSeats(user.getRow(), user.getColumn());
        if (s != null && s.isAvailable()) {
            s.setAvailable(false);
            return new ResponseEntity<Map>(Map.of("row", s.getRow(), "column", s.getColumn(), "price", s.getPrice()),HttpStatus.OK);
        } else if (user.getRow() > 9 || user.getRow() < 1 || user.getColumn() > 9 || user.getColumn() < 1){
            return new ResponseEntity<Map>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Map>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        }
    }


}
