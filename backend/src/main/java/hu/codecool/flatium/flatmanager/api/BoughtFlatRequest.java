package hu.codecool.flatium.flatmanager.api;

public class BoughtFlatRequest {
    private int userId;
    private int flatId;

    public BoughtFlatRequest() {
    }

    public BoughtFlatRequest(int userId, int flatId) {
        this.userId = userId;
        this.flatId = flatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }
}
