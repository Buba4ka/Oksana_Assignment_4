package com.coderscampus.service;

import com.coderscampus.Student;

import java.io.File;
import java.io.IOException;

public interface CSVFileService {



    Student[] createStudents () throws IOException, ClassNotFoundException;

    void divideStudentsByCourse() throws IOException;
}
