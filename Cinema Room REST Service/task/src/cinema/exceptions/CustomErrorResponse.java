package cinema.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micrometer.core.lang.NonNull;

import java.time.LocalDateTime;

public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    @NonNull
    private int status;

    @NonNull
    private String error;

    public CustomErrorResponse(int status, @NonNull String error) {
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @NonNull
    public String getError() {
        return error;
    }

    public void setError(@NonNull String error) {
        this.error = error;
    }
}
