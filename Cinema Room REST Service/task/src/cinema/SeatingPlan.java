package cinema;

import java.util.*;

public class SeatingPlan {
    private int totalRows;
    private int totalColumns;
    private ArrayList<Seats> availableSeats = new ArrayList<>();

    public SeatingPlan() {}

    public SeatingPlan(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                this.availableSeats.add(new Seats(i,j));
            }
        }
    }

    public SeatingPlan(int totalRows, int totalColumns, ArrayList<Seats> availableSeats) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = availableSeats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public ArrayList<Seats> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(ArrayList<Seats> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Seats searchAvailableSeats(int row, int column) {
        for (Seats s: this.getAvailableSeats()) {
            if (s.getRow() == row && s.getColumn() == column) return s;
        }
        return null;
    }
}
