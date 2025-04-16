package org.problems.designpatterns.chainofresponsibility;

public class Request {
    private String user;
    private String role;
    private String payload;
    private boolean isAuthenticated;
    private boolean isAutharized;

    public Request(String user, String role, String payload) {
        this.user = user;
        this.role = role;
        this.payload = payload;
    }

    public String getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    public String getPayload() {
        return payload;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public void setAutharized(boolean autharized) {
        isAutharized = autharized;
    }
}
