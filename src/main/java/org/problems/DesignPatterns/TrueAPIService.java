package org.problems.DesignPatterns;

public class TrueAPIService implements APIService {
    @Override
    public void request(String user, String endpoint) {
        System.out.println("Request endpoint: " + endpoint + " is invoked by User: " + user);
    }
}
