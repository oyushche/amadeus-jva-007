package com.amadeus.birds;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime time;
    private Bird bird;
    private Client client;

    public Transaction(Client client, Bird bird) {
        this.time = LocalDateTime.now();

        this.client = client;
        this.bird = bird;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
