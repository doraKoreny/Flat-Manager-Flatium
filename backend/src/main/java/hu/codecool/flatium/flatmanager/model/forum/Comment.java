package hu.codecool.flatium.flatmanager.model.forum;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int flatUserId;

    private String message;
    private LocalDate timeStamp;

    public Comment(int flatUserId, String message) {
        this.timeStamp = LocalDate.now();
        this.flatUserId = flatUserId;
        this.message = message;
    }
}
