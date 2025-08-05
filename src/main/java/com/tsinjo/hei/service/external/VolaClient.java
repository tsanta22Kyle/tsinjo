package com.tsinjo.hei.service.external;


import com.tsinjo.hei.service.DTO.VolaPayment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class VolaClient {

    @Value("${vola.api.url}")
    private String baseUrl;

    @Value("${vola.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public VolaPayment getPayment(String email, String pspPaymentId, String pspType) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/v3/payment-status")
                .queryParam("apiKey", apiKey)
                .queryParam("payerEmail", email)
                .queryParam("pspPaymentId", pspPaymentId)
                .queryParam("pspType", pspType)
                .toUriString();

        try {
            return restTemplate.getForObject(url, VolaPayment.class);
        } catch (Exception e) {
            log.warn("Failed to verify payment with id {}: {}", pspPaymentId, e.getMessage());
            return null;
        }
    }
}
