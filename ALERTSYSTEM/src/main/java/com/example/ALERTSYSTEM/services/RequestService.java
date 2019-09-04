package com.example.ALERTSYSTEM.services;

import com.example.ALERTSYSTEM.model.Alert;
import com.example.ALERTSYSTEM.model.AlertStatus;
import com.example.ALERTSYSTEM.repository.AlertRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class RequestService {
    @Autowired
    private final AlertRepo alertRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Async
    //çağrıldığında bloklamaaz geri döner thread açar.
    public void asyncRequestWorker(Alert alert, LocalDateTime requestingTime) {
        try {
            ResponseEntity<String> result = restTemplate.exchange(
                    alert.getUrl(),
                    alert.getMethod(),
                    null,
                    String.class);
            AlertStatus alertStatus = new AlertStatus(null, requestingTime, 0);
            if (result.getStatusCode() == HttpStatus.OK) {
                alertStatus.setStatus(1);
            }
            alert.getAlertStatuses().add(alertStatus);
        } catch (Exception e) {
            AlertStatus alertStatus = new AlertStatus(null, requestingTime, 0);
            alert.getAlertStatuses().add(alertStatus);
        }
        alertRepo.save(alert);
    }
}
