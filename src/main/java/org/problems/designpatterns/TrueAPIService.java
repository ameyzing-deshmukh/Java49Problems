package org.problems.designpatterns;

import org.springframework.stereotype.Service;

@Service
public class TrueAPIService implements APIService {
    @Override
    public void request(String user, String endpoint) {
        System.out.println("Request endpoint: " + endpoint + " is invoked by User: " + user);
    }
}
