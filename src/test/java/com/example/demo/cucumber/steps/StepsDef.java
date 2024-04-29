package com.example.demo.cucumber.steps;

import com.example.demo.cucumber.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StepsDef {

    private Map<String, Object> contextMap = new HashMap<>();
    private static final String BASE_URL = "http://localhost:8080/";

    @When("get balance from card {string}")
    public void getBalanceFromCard(String cardNumber) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + "getBalance/" + cardNumber)
                .get()
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        Response response = httpClient.newBuilder()
                .build()
                .newCall(request)
                .execute();

        contextMap.put("response", response);
    }

    @Then("response is success")
    public void responseIsSuccess() {
        Response response = (Response) contextMap.get("response");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
    }

    @And("balance equals {string}")
    public void balanceEquals(String expectedBalance) throws IOException {
        responseEquals(expectedBalance);
    }

    @When("create transaction with body {string}")
    public void createTransactionWithBody(String resourcePath) throws IOException {
        String body = Utils.getResourceFileAsString("/data/" + resourcePath);
        RequestBody requestBody = RequestBody.create(body, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(BASE_URL + "createTransaction")
                .post(requestBody)
                .build();
        OkHttpClient httpClient = new OkHttpClient();
        Response response = httpClient.newBuilder()
                .build()
                .newCall(request)
                .execute();

        contextMap.put("response", response);
    }


    @And("response equals {string}")
    public void responseEquals(String expectedBalance) throws IOException {
        Response response = (Response) contextMap.get("response");
        assertEquals(expectedBalance, response.body().string());
        response.close();
    }
}
