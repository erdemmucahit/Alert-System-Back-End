package com.example.ALERTSYSTEM.services;

import com.example.ALERTSYSTEM.model.Alert;
import com.example.ALERTSYSTEM.repository.AlertRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    @Autowired
    private AlertRepo alertRepo;

    @Autowired
    private RequestService requestService;

    @Scheduled(fixedDelay = 1000) //her 1 sn
    public void scheduleAlerts() {
        List<Alert> alerts = alertRepo.findAll(Sort.by("id"));
        LocalDateTime requestingTime = LocalDateTime.now();
        if (alerts.size() > 0) {
            alerts.forEach(alert -> {
                if (alert.getPeriodLeft() == 0L) {
                    alert.setPeriodLeft(alert.getPeriod());
                    requestService.asyncRequestWorker(alert, requestingTime);
                } else {
                    alert.setPeriodLeft(alert.getPeriodLeft() - 1L);
                    alertRepo.save(alert);
                }
            });
        }
    }

}
