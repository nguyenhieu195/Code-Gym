package Project_QuizBuilder.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private Integer id;
    private static Integer nextID = 0;

    private String username;
    private String password;

    private List<QuizResult> results;

    public Account(String username, String password) {
        this.id = ++nextID;
        this.username = username;
        this.password = password;
    }

    public Account(Integer id, String username, String password, List<QuizResult> results) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.results = results;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<QuizResult> getResults() {
        return results;
    }

    public void setResults(List<QuizResult> results) {
        this.results = results;
    }
    public static Integer getNextID() {
        return nextID;
    }

    public static void setNextID(Integer nextID) {
        Account.nextID = nextID;
    }
}