package com.example.ALERTSYSTEM.repository;

import com.example.ALERTSYSTEM.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepo extends JpaRepository<Alert, Long> {

}
