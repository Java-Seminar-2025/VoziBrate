package com.bus.bus_tracker.service;

import com.bus.bus_tracker.dto.SalesPointRequestDto;
import com.bus.bus_tracker.entity.SalesPointEntity;
import com.bus.bus_tracker.repository.SalesPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesPointService {

    private final SalesPointRepository repo;

    public List<SalesPointEntity> getAll() {
        // dohvaća sva prodajna mjesta iz baze
        // koristi se za USER prikaz (mapa)
        return repo.findAll();
    }

    public SalesPointEntity create(SalesPointRequestDto dto) {
        // kreira novo prodajno mjesto na temelju podataka iz forme (ADMIN dio)
        SalesPointEntity sp = new SalesPointEntity();
        sp.setName(dto.getName());
        sp.setAddress(dto.getAddress());
        sp.setGpsLat(dto.getGpsLat());
        sp.setGpsLng(dto.getGpsLng());
        // spremanje novog prodajnog mjesta u bazu
        return repo.save(sp);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    // briše prodajno mjesto po ID-u (ADMIN dio)
}
