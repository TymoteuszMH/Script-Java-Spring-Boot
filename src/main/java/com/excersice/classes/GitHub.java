package com.excersice.classes;

import java.util.List;
//klasa pomocnicza do pobierania danych z githuba
public class GitHub {
        private String name;
        private Owner owner;
        private boolean fork;
        private List<Branch> branches;

    public GitHub(){
    }

    public GitHub(String name, Owner owner, boolean fork){
        this.name = name;
        this.owner = owner;
        this.fork = fork;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
