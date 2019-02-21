package hu.codecool.flatium.flatmanager.api;

import hu.codecool.flatium.flatmanager.flat.FlatUser;

public class FlatUserUpdateRequest {
    private int flatUserId;
    private FlatUser flatUser;

    public FlatUserUpdateRequest() {
    }

    public FlatUserUpdateRequest(int flatUserId, FlatUser flatUser) {
        this.flatUserId = flatUserId;
        this.flatUser = flatUser;
    }

    public int getFlatUserId() {
        return flatUserId;
    }

    public void setFlatUserId(int flatUserId) {
        this.flatUserId = flatUserId;
    }

    public FlatUser getFlatUser() {
        return flatUser;
    }

    public void setFlatUser(FlatUser flatUser) {
        this.flatUser = flatUser;
    }
}
