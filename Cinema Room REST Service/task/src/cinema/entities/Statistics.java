package cinema.entities;

public class Statistics {
    private int currentIncome;
    private int numberOfAvailableSeats;
    private int numberOfPurchasedTickets;

    public Statistics(int currentIncome, int numOfAvailableSeats, int numOfPurchasedTickets) {
        this.currentIncome = currentIncome;
        this.numberOfAvailableSeats = numOfAvailableSeats;
        this.numberOfPurchasedTickets = numOfPurchasedTickets;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public void setCurrentIncome(int currentIncome) {
        this.currentIncome = currentIncome;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setNumberOfAvailableSeats(int numberOfAvailableSeats) {
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }
}
