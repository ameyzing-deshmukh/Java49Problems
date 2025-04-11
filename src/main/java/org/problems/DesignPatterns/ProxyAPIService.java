package org.problems.DesignPatterns;

import java.util.HashSet;
import java.util.Set;

public class ProxyAPIService implements APIService {
    TrueAPIService trueAPIService = new TrueAPIService();
    private final Set<String> authenticatedUsers = new HashSet<>();

    ProxyAPIService() {
        authenticatedUsers.add("amey");
        authenticatedUsers.add("vijay");
    }

    @Override
    public void request(String user, String endpoint) {

        if (null != user && authenticatedUsers.contains(user.toLowerCase())) {
            trueAPIService.request(user, endpoint);
        } else {
            System.out.println("Unauthenticated user");
        }
    }
}
