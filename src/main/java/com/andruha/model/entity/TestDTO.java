package com.andruha.model.entity;

/**
 * Created by andrusha on 20.06.17.
 */
public class TestDTO {

    private String name;

    private int id;

    public TestDTO() {
    }

    public TestDTO(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
