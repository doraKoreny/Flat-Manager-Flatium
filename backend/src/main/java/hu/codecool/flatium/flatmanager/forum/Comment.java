package hu.codecool.flatium.flatmanager.forum;

import java.time.Instant;

public class Comment {
    private int id;
    private static int idCount = 0;
    private int flatUserId;
    private String message;
    private String timeStamp;

    public Comment() {
        this.id = idCount++;
        this.timeStamp = Instant.now().toString();
    }

    public Comment(int flatUserId, String message) {
        this.id = idCount++;
        this.flatUserId = flatUserId;
        this.message = message;
        this.timeStamp = Instant.now().toString();
    }

    public static String getNewInstant(){
        return Instant.now().toString();
    }

    public int getFlatUserId() {
        return flatUserId;
    }

    public void setFlatUserId(int flatUserId) {
        this.flatUserId = flatUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}
