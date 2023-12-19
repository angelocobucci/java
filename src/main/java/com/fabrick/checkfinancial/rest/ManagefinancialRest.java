package com.fabrick.checkfinancial.rest;

import com.fabrick.checkfinancial.dto.HelloDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class ManagefinancialRest {

    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloDto hello(){
        HelloDto outputMessage = HelloDto.of("Hello Fabric !");
        log.info("Getting hello with MESSAGE({}).",outputMessage);
        return outputMessage;
    }

}
