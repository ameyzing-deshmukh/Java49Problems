package org.problems.designpatterns;

import org.junit.jupiter.api.Test;
import org.problems.designpatterns.proxy.APIService;
import org.problems.designpatterns.proxy.ProxyAPIService;

class ProxyAPIServiceTest {

    @Test
    public void testTrueAPIService() {
        APIService apiService = new ProxyAPIService();

        apiService.request("user", "/url/part");
        apiService.request("Amey", "/url/part");
        apiService.request(null, "/url/part");

    }

}