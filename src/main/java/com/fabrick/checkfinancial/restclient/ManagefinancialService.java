package com.fabrick.checkfinancial.restclient;


import com.fabrick.checkfinancial.dto.Accounts;
import com.fabrick.checkfinancial.dto.AccountsDto;
import com.fabrick.checkfinancial.dto.PayloadDto;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ManagefinancialService {

    @Value(value = "${fabrick.api.get.accounts}")
    private String getAccountUrl;
    @Autowired
    RestTemplate restTemplate;



    public List<Accounts> getAllAccounts() {
        log.info("Getting all accounts..");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        return Optional.of(
                restTemplate
                        .exchange(getAccountUrl, HttpMethod.GET, httpEntity, AccountsDto.class))
                .map(ResponseEntity::getBody)
                .map(AccountsDto::getPayload)
                .map(PayloadDto::getAccounts)
                .orElse(Collections.emptyList());
    }

}
