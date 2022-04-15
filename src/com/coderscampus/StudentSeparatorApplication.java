package com.coderscampus;

import com.coderscampus.service.CSVFileService;
import com.coderscampus.service.CSVFileServiceImpl;

import java.io.IOException;

public class StudentSeparatorApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        CSVFileService service = new CSVFileServiceImpl();
        service.divideStudentsByCourse();




    }
}
