# Getting data from GitHub API

### Exercise for recruitment purposes


## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)


##### General info
This task requires to list all github repositories, which are not forks. Informations are presented as JSON. Informations shows:

Repository Name
Owner Login
For each branch it’s name and last commit sha

The code, also throws an error 404 when user is not found.


##### Technologies
Project uses:
 * Java 21
 * Spring Boot 3.3.2


##### Setup
First, you need to add your GitHub token in ```src/main/java/configuration/GitHubConfig.java```, to ```private static final String GITHUB_TOKEN```. If you don't, you get an error.

To run a project you need to lunch ```src/main/java/Application.java``` with Java 21.
Then, you need to type ```http://localhost:8080/git/username``` where username is a github user that you want to search for, ex.: ```http://localhost:8080/git/tymoteuszmh```.
