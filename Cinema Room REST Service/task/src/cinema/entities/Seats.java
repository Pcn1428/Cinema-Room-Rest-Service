package cinema.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Seats {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private UUID token;
    @JsonIgnore
    private boolean available;

    public Seats() {}

    public Seats (int row, int column) {
        this.row = row;
        this.column = column;
        if (row <= 4) this.price = 10;
        else this.price = 8;
        this.available = true;
        this.token = UUID.randomUUID();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }
}
