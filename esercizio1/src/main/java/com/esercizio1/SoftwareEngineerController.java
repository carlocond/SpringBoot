package com.esercizio1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    // 🔹 GET: restituisce tutti gli engineers
    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    // 🔹 GET: restituisce un engineer per ID
    @GetMapping("{id}")
    public SoftwareEngineer getEngineersById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineersById(id);
    }

    // 🔹 POST: crea o aggiorna un engineer (JPA save gestisce entrambi i casi)
    @PostMapping
    public ResponseEntity<SoftwareEngineer> addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
        return ResponseEntity.ok(softwareEngineer);
    }

    // 🔹 PUT: aggiorna un engineer esistente
    @PutMapping("{id}")
    public ResponseEntity<SoftwareEngineer> updateSoftwareEngineer(
            @PathVariable Integer id,
            @RequestBody SoftwareEngineer updatedEngineer) {

        SoftwareEngineer existing = softwareEngineerService.getSoftwareEngineersById(id);
        existing.setName(updatedEngineer.getName());
        existing.setTechStack(updatedEngineer.getTechStack());
        softwareEngineerService.insertSoftwareEngineer(existing);

        return ResponseEntity.ok(existing);
    }

    // 🔹 DELETE: elimina un engineer per ID
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}