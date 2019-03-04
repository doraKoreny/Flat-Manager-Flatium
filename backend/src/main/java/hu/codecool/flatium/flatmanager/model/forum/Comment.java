package hu.codecool.flatium.flatmanager.model.forum;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Comment {
    private int id;
    private static int idCount = 0;
    private int flatUserId;
    private String message;
    private LocalDate timeStamp;

    public Comment(int id, int flatUserId, String message) {
        this.timeStamp = LocalDate.now();
        this.id = id;
        this.flatUserId = flatUserId;
        this.message = message;
    }
}
