package com.excersice.controller;

import com.excersice.classes.GitHub;
import com.excersice.classes.Responce;
import com.excersice.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "git")
public class GitHubController {
    private final GitHubService gitHubService;

    @Autowired
    public GitHubController(GitHubService gitHubService){
        this.gitHubService = gitHubService;
    }

    //pobieranie metodą get nazwy użytkownika, następnie pobieranie danych z api githuba, formatowanie ich i zwracanie
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserRepositories(@PathVariable String username) {
        try {
            List<Responce> repos = gitHubService.getUserRepositories(username);
            return ResponseEntity.ok(repos);
        } catch (GitHubService.Unauthorized e) {
            return ResponseEntity.status(401).body(Map.of("status", 401, "message", e.getMessage()));
        } catch (GitHubService.UserNotFoundException e) {
            return ResponseEntity.status(404).body(Map.of("status", 404, "message", e.getMessage()));
        }
    }
}
