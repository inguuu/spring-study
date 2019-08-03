package com.company;

public class User {

    private int idx;
    private String name;

    public void print() {
        System.out.println("유저idx: " + idx + "이름: " + name);
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int idx, String name) {
        this.idx = idx;
        this.name = name;
    }
}
