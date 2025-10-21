package com.university.University.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired//Collegamento tra il controller e il servizio
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping //Ricezione della richiesta http Get
    public List<Student> getStudent(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String cfu,
            @RequestParam(required = false) String exams){
        if (firstName != null){ //Filtra per nome
            return studentService.getStudentsByFirstName(firstName);
        } else if (lastName != null) { //Per cognome
            return studentService.getStudentsByLastName(lastName);
        } else if (course != null) { //Per corso
            return studentService.getStudentsFromCourse(course);
        } else { //Restituisce tutti gli studenti in caso di fallimento
            return studentService.getStudents();
        }
    }

    @PostMapping //Ricezione della richiesta http Post
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student createdStudent = studentService.addStudent(student); //Salvataggio dello studente creato
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping //Ricezione della richiesta http Put
    //Metodo che controlla se esiste lo studente da modificare e richiama il metodo di modifica
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(student);
        if (updatedStudent != null){
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK); //Messaggio di conclusione
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //Messaggio di errore
        }
    }

    @DeleteMapping("/{studentId}")//Ricezione della richiesta http Delete
    //Metodo che elimina uno studente in base all'id inserito e richiama il metodo di rimozione
    public ResponseEntity<Long> deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<Long>(studentId, HttpStatus.OK);
    }

}
