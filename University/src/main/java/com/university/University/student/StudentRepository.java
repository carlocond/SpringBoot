package com.university.University.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Estende l'interfaccia JpaRepository che fornisce metodi gia pronti per utilizzare le operazioni CRUD(Create, Read, Update, Delete)
@Repository
//Nell'estensione vengono inseriti il tipo di entità e il tipo della primary key, in questo caso Entity di tipo Student e primary key di tipo Long
public interface StudentRepository extends JpaRepository<Student, Long> {

    void deleteById(Long id); //Cancella l'entity che corrisponde all'id inserito
    Optional<Student> findById(Long id); //Cerca l'entity con quell'id

}
