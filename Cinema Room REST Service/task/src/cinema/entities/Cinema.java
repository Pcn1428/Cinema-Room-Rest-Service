package cinema.entities;

import java.util.List;

public class Cinema {

    private int totalRows;
    private int totalColumns;
    private List<Seats> availableSeats;

    public Cinema() {}

    public Cinema(int totalRows, int totalColumns, List<Seats> availableSeats) {
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

    public List<Seats> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seats> availableSeats) {
        this.availableSeats = availableSeats;
    }

}
