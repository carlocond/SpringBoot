package com.mypc.MyPcComponents.service;

import com.mypc.MyPcComponents.model.Component;

import java.util.List;
import java.util.Optional;

public interface IComponentService {
    List<Component> findAll();
    Optional<Component> findById(Long id);
    Component save(Component component);
    Component update(Long id, Component updated);
    void delete(Long id);
}
