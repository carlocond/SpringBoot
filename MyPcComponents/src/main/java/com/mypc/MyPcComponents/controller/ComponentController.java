package com.mypc.MyPcComponents.controller;

import com.mypc.MyPcComponents.model.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mypc.MyPcComponents.service.ComponentService;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/components")
public class ComponentController {

    private final ComponentService service;

    public ComponentController(ComponentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Component> listAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Component> getById(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Component> create(@RequestBody Component component) {
        Component saved = service.save(component);
        return ResponseEntity.created(URI.create("/api/components" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Component> update(@PathVariable Long id, @RequestBody Component component){
        Component updated = service.update(id, component);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Component> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

