package com.mypc.MyPcComponents.service;

import com.mypc.MyPcComponents.exception.ResourceNotFoundException;
import com.mypc.MyPcComponents.model.Component;
import org.springframework.stereotype.Service;
import com.mypc.MyPcComponents.repository.ComponentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService implements IComponentService{

    private final ComponentRepository repo;

    public ComponentService(ComponentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Component> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Component> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Component save(Component component) {
        return repo.save(component);
    }

    @Override
    public Component update(Long id, Component updated) {
        return repo.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setType(updated.getType());
            existing.setBrand(updated.getBrand());
            existing.setModel(updated.getModel());
            existing.setSpecs(updated.getSpecs());
            return repo.save(existing);
        }).orElseThrow(() -> new ResourceNotFoundException("Component with id: " + id + " Not found!"));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)){
            throw new ResourceNotFoundException("Component with id: " + id + " Not found!");
        }
        repo.deleteById(id);
    }
}
