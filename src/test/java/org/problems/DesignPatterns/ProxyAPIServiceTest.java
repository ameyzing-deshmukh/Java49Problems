package org.problems.DesignPatterns;

import org.junit.jupiter.api.Test;

class ProxyAPIServiceTest {

    @Test
    public void testTrueAPIService() {
        APIService apiService = new ProxyAPIService();

        apiService.request("user", "/url/part");
        apiService.request("Amey", "/url/part");
        apiService.request(null, "/url/part");

    }

}