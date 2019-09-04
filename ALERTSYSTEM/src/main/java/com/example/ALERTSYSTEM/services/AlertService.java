package com.example.ALERTSYSTEM.services;

import com.example.ALERTSYSTEM.model.Alert;
import com.example.ALERTSYSTEM.repository.AlertRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.ALERTSYSTEM.repository.AlertRepo;

import javax.persistence.OrderBy;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AlertService {
    @Autowired
    private AlertRepo alertRepo;

    public void addAlert(Alert newAlert) {
        newAlert.setPeriodLeft(newAlert.getPeriod());
        this.alertRepo.save(newAlert);
    }

    @OrderBy()
    public List<Alert> getAlerts() {
        return alertRepo.findAll(Sort.by("id"));
    }

    @OrderBy()
    public List<Alert> getAlert() {
        return alertRepo.findAll(Sort.by("id"));
    }

    public Alert getOneById(Long id) {
        return alertRepo.findById(id).get();
    }

}
