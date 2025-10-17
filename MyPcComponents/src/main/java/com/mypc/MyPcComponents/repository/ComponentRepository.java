package com.mypc.MyPcComponents.repository;


import com.mypc.MyPcComponents.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
}
