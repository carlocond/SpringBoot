package com.university.University.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired//Annotazione che crea un collegamento tra il servizio e la repository, e permette di interagire con il db
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //Metodo che restituisce tutti gli studenti presenti nel database
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getStudentsFromCourse(String courseName){
        return studentRepository.findAll().stream()//Trova tutti gli studenti e li scorre 1 ad 1
                .filter(student -> courseName.equals(student.getCourse())) //li filtra in base al nome del corso
                .collect(Collectors.toList()); //i corrispondenti li inserisce tutti all'interno di una lista e li restituisce
    }

    public List<Student> getStudentsByFirstName(String studentFName){
        return studentRepository.findAll().stream()
                .filter(student -> studentFName.equals(student.getFirstName().toLowerCase().contains(studentFName.toLowerCase())))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByLastName(String studentLName){
        return studentRepository.findAll().stream()
                .filter(student -> studentLName.equals(student.getLastName().toLowerCase().contains(studentLName.toLowerCase())))
                .collect(Collectors.toList());
    }

    //Metodo che aggiunge un nuovo studente
    public Student addStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    //Metodo che modifica uno studente
    public Student updateStudent(Student updatedStudent){
        Optional<Student> existingStudent = studentRepository.findById(updatedStudent.getId());
        //Controllo dell'esistenza dello studente selezionato, e se esiste permette la modifica
        if (existingStudent.isPresent()){
            Student studentToUpdate = updatedStudent;
            studentToUpdate.setFirstName(updatedStudent.getFirstName());
            studentToUpdate.setLastName(updatedStudent.getLastName());
            studentToUpdate.setAge(updatedStudent.getAge());
            studentToUpdate.setCourse(updatedStudent.getCourse());
            studentToUpdate.setCfu(updatedStudent.getCfu());
            studentToUpdate.setExams(updatedStudent.getExams());

            studentRepository.save(studentToUpdate);
            return studentToUpdate;
        }
        //Restituisce null se lo studente non è stato trovato
        return null;
    }

    //Metodo che restituisce uno studente che corrisponde all'id inserito
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }

    @Transactional //Mantiene l'integrità dei dati durante l'esecuzione di questa operazione
    //Metodo che elimina lo studente che corrisponde all'id inserito
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
