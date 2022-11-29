package cinema.service;

import cinema.entities.Cinema;
import cinema.entities.Seats;
import cinema.entities.Statistics;
import cinema.entities.Token;
import cinema.exceptions.SeatOutOfBoundsException;
import cinema.exceptions.TicketAlreadyPurchasedException;
import cinema.exceptions.WrongPasswordException;
import cinema.exceptions.WrongTokenException;
import cinema.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepo;
    private static final String PASSWORD = "super_secret";

    @Autowired
    public CinemaService(CinemaRepository cinemaRepo) {
        this.cinemaRepo = cinemaRepo;
    }

    public Cinema getCinemaInfo() {
        return new Cinema(cinemaRepo.getTotalRows(), cinemaRepo.getTotalColumns(), cinemaRepo.getAllSeats());
    }

    public Map<String,Object> generateTicket(Seats targetSeat) {
        if (!existsSeat(targetSeat)) throw new SeatOutOfBoundsException();

        Seats seat = cinemaRepo.getAllSeats().stream()
                .filter(s -> s.getRow() == targetSeat.getRow()
                && s.getColumn() == targetSeat.getColumn()
                && s.isAvailable())
                .findAny()
                .orElseThrow(TicketAlreadyPurchasedException::new);

        seat.setAvailable(false);
        return cinemaRepo.saveTicket(new Token().toString(), seat);
    }

    public Map<String, Seats> returnTicket(Token token) {
        if (!cinemaRepo.existsTicket(token.getToken())) throw new WrongTokenException();

        Seats refundedSeat = cinemaRepo.getSeatByToken(token.getToken());

        Seats seat = cinemaRepo.getAllSeats().stream()
                .filter(s -> s.getRow() == refundedSeat.getRow()
                        && s.getColumn() == refundedSeat.getColumn())
                .findAny()
                .orElseThrow(WrongTokenException::new);
        seat.setAvailable(true);
        cinemaRepo.removeTicket(token.getToken());
        return Map.of("returned_ticket",seat);
    }

    public boolean existsSeat(Seats s) {
        return s.getRow() <= cinemaRepo.getTotalRows()
                && s.getColumn() <= cinemaRepo.getTotalColumns()
                && s.getRow() > 0
                && s.getColumn() > 0;
    }

    public Statistics getStatistics(String password) {
        if (!isPasswordValid(password)) throw new WrongPasswordException();

        int income = cinemaRepo.getIncome();
        int availableSeats = cinemaRepo.getAvailableSeats();
        int purchasedTickets = cinemaRepo.getPurchasedTickets();

        return new Statistics(income,availableSeats,purchasedTickets);
    }

    public boolean isPasswordValid(String password) {
        return PASSWORD.equals(password);
    }
}
