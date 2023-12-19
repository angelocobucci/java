package com.fabrick.checkfinancial.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(staticName = "of")
@Getter
@EqualsAndHashCode
@ToString
public class Accounts {
   private String accountId;
   private String iban;
   private String abiCode;
   private String cabCode;
   private String countryCode;
   private String internationalCin;
   private String nationalCin;
   private String account;
   private String alias;
   private String productName;
   private String holderName;
   private String activatedDate;
   private String currency;
}
