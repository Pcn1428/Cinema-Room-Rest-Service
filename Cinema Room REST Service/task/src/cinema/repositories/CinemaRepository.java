package cinema.repositories;

import cinema.entities.Seats;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CinemaRepository {
    private static final int TOTAL_ROWS = 9;
    private static final int TOTAL_COLUMNS = 9;
    private static final int FRONT_PRICE = 10;
    private static final int BACK_PRICE = 8;
    private static final Map<String, Seats> PURCHASED_TICKETS;
    private static final List<Seats> SEATS;

    static {
        PURCHASED_TICKETS = new HashMap<>();
        SEATS = new ArrayList<>();
        for (int row = 1; row <= TOTAL_ROWS; row++) {
            for (int column = 1; column <= TOTAL_COLUMNS; column++) {
                SEATS.add(new Seats(row, column, row <= 4 ? FRONT_PRICE:BACK_PRICE, true));
            }
        }
    }

    public int getTotalRows() {
        return TOTAL_ROWS;
    }

    public int getTotalColumns() {
        return TOTAL_COLUMNS;
    }

    public List<Seats> getAllSeats() {
        return SEATS;
    }

    public Seats getSeatByToken(String token) {
        return PURCHASED_TICKETS.get(token);
    }

    public Map<String, Object> saveTicket(String token, Seats seat) {
        PURCHASED_TICKETS.put(token,seat);
        return Map.of("token", token, "ticket", seat);
    }

    public void removeTicket(String token) {
        PURCHASED_TICKETS.remove(token);
    }

    public boolean existsTicket(String token) {
        return PURCHASED_TICKETS.containsKey(token);
    }
}
