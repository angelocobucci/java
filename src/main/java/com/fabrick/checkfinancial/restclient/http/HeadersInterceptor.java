package com.fabrick.checkfinancial.restclient.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@AllArgsConstructor(staticName = "of")
@Getter
public class HeadersInterceptor implements ClientHttpRequestInterceptor {

    private static final String LABLE_AUTH_SCHEMA = "Auth-Schema";
    private static final String LABLE_API_KEY = "Api-Key";
    private static final String LABLE_ACCOUNT_ID = "accountId";

    private String authSchema;
    private String apiKey;
    private String accountId;


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        enrichRequestHeader(request.getHeaders());
        return execution.execute(request, body);
    }

    private void enrichRequestHeader(HttpHeaders headers) {
        headers.add(LABLE_AUTH_SCHEMA,authSchema);
        headers.add(LABLE_API_KEY,apiKey);
        headers.add(LABLE_ACCOUNT_ID,accountId);
    }

}
