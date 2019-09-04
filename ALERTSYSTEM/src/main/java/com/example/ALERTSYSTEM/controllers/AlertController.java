package com.example.ALERTSYSTEM.controllers;

import com.example.ALERTSYSTEM.model.Alert;
import com.example.ALERTSYSTEM.services.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AlertController {
    final private AlertService alertService;

    @GetMapping("/alerts")
    public List<Alert> getAlert() {
        return alertService.getAlert();
    }

    @PostMapping("/alerts")
    public void addAlert(@RequestBody Alert alert) {
        alertService.addAlert(alert);
    }

    @GetMapping("/alertlist")
    public List<Alert> getAlerts() {
        return alertService.getAlerts();
    }

    @GetMapping("/alertlist/{id}")
    public Alert getAlertById(@PathVariable Long id) {
        return alertService.getOneById(id);
    }

    /*@DeleteMapping("/alertlist/{id}")
    public void deleteAlertById (@PathVariable Long id){
        alertService.deleteById(id);
    }*/


}
