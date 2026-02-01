package com.bus.bus_tracker.repository;

import com.bus.bus_tracker.entity.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Long> {

    // pronalazi autobus u bazi po garage/bus broju (busNumber)
    // koristi se u PrometkoFetcherService za dohvat ili kreiranje busa
    Optional<BusEntity> findByBusNumber(String busNumber);
}
