package cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.core.lang.NonNull;

import java.util.UUID;

public class Seats {
    @NonNull
    private int row;
    @NonNull
    private int column;
    private int price;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean available;

    public Seats() {}

    public Seats(int row, int column, int price, boolean available) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.available = available;
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
}
