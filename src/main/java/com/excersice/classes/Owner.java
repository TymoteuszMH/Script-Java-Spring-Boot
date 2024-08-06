package com.excersice.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
//klasa pomocnicza do pobierania danych właściciela
public class Owner {
    private String login;

    public Owner(@JsonProperty("login") String login){
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
