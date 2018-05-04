package com.DimensionData.Servermanagement;

public class Server {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toStringID() {
        return "Server ID: " + this.id + " Name: " + this.name;
    }
}
