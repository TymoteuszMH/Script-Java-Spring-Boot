package com.excersice.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
//klasa pomocnicza dla commitów branchy
public class Commit {
    private String sha;

    public Commit(@JsonProperty("sha") String sha){
        this.sha = sha;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
