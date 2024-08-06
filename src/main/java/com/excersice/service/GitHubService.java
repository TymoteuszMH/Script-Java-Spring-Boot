package com.excersice.service;

import com.excersice.classes.Branch;
import com.excersice.classes.GitHub;
import com.excersice.classes.Responce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GitHubService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Responce> getUserRepositories(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        try {
            //pobieranie repozytorii z api githuba
            GitHub[] repos = restTemplate.getForObject(url, GitHub[].class);
            if (repos != null) {
                List<Responce> responce = new ArrayList<>();

                //formatowanie zwróconych wyników
                for(GitHub repo : repos){
                    if(!repo.isFork()){
                        responce.add(new Responce(
                                repo.getName(),
                                repo.getOwner().getLogin(),
                                getBranches(username, repo.getName())
                        ));
                    }
                }

                return responce;
            } else {
                return Collections.emptyList();
            }
        } catch (HttpClientErrorException e) {
            //wyświetlanie błędów
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new UserNotFoundException("User not found");
            } else if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new Unauthorized("You need to add your GitHub token. Check readme.md for more info.");
            } else {
                throw e;
            }
        }
    }

    //pobieranie branchy
    private List<Responce.Branches> getBranches(String username, String repoName) {
        String url = "https://api.github.com/repos/" + username + "/" + repoName + "/branches";
        //pobieranie branchy z api githuba
        Branch[] branches = restTemplate.getForObject(url, Branch[].class);

        //lista na sformatowane branche
        List<Responce.Branches> responseBranches = new ArrayList<>();

        //formatowanie branchy
        if(branches!=null){
            for(Branch branch : branches){
                responseBranches.add(new Responce.Branches(branch.getName(), branch.getCommit().getSha()));
            }
        }

        return responseBranches;
    }

    //błąd kiedy nie znajdzie użytkownika
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

    //błąd kiedy nie znajdzie wpisze się tokenu githuba
    public static class Unauthorized extends RuntimeException {
        public Unauthorized(String message) {
            super(message);
        }
    }
}