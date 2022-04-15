package com.coderscampus.service;

import com.coderscampus.Student;

import java.io.*;

public class CSVFileServiceImpl implements CSVFileService {



    @Override
    public Student[] createStudents() {

        Student[] students = new Student[101];

        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader("student-master-list.csv"));
            int index = 0;
            String studentString = "";
            while ((studentString = fileReader.readLine()) != null) {

//                try (FileInputStream fileInput = new FileInputStream("student-master-list.csv");
//                    ObjectInputStream objectInput = new ObjectInputStream(fileInput);) {
//
//            int index = 0;
//            while ((Student)objectInput.readObject() != null) {
//
                String[] studentInfo = studentString.split(",");
                Student student = new Student();

                student.setStudentID(studentInfo[0]);
                student.setName(studentInfo[1]);
                student.setCourse(studentInfo[2]);
                student.setGrade(studentInfo[3]);
                students[index] = student;
                index++;

            }
        } catch (FileNotFoundException ex) {
            System.out.println("There is no such file");
            ex.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(students.toString());
        return students;
    }

    @Override
    public void divideStudentsByCourse() throws IOException {
        Student[] allStudents = createStudents();
        Student headers = allStudents[0];

        for (int i=1; i < allStudents.length; i++) {

            if (allStudents[i].getCourse().contains("COMPSCI")) {
                try (FileOutputStream output1 = new FileOutputStream("course1.csv");
                     ObjectOutputStream objectOutput1 = new ObjectOutputStream(output1)){
                    objectOutput1.writeObject(headers);
                    objectOutput1.writeObject(allStudents[i] + "\n");

                }
            }else if (allStudents[i].getCourse().contains("STAT")) {
                try (FileOutputStream output2 = new FileOutputStream("course2.csv");
                     ObjectOutputStream objectOutput2 = new ObjectOutputStream(output2)){
                    objectOutput2.writeObject(headers);
                    objectOutput2.writeObject(allStudents[i] + "\n");
                }
            } else if (allStudents[i].getCourse().contains("APMTM")) {
                try (FileOutputStream output3 = new FileOutputStream("course3.csv");
                     ObjectOutputStream objectOutput3 = new ObjectOutputStream(output3)){
                    objectOutput3.writeObject(headers);
                    objectOutput3.writeObject(allStudents[i] + "\n");
                }

            }
        }


    }


}
