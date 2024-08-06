package com.excersice.classes;

import java.util.List;

//klasa do wyświetlania końcowego wyniku
public class Responce {

    private String name;
    private String owner;
    private List<Branches> branches;

    public Responce(){}

    public Responce(String name, String owner, List<Branches> branches){
        this.name = name;
        this.owner = owner;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Branches> getBranches() {
        return branches;
    }

    public void setBranches(List<Branches> branches) {
        this.branches = branches;
    }

    public static class Branches{
        private String name;
        private String lastSha;

        public Branches(){}

        public Branches(String name, String lastSha){
            this.name = name;
            this.lastSha = lastSha;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastSha() {
            return lastSha;
        }

        public void setLastSha(String lastSha) {
            this.lastSha = lastSha;
        }
    }
}
