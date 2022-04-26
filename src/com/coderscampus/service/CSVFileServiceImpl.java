package com.coderscampus.service;

import com.coderscampus.Student;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;


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

        BufferedWriter [] fileWriters = new BufferedWriter[3];
        fileWriters[0] = new BufferedWriter(new FileWriter("course1.csv"));
        fileWriters[1] = new BufferedWriter(new FileWriter("course2.csv"));
        fileWriters[2] = new BufferedWriter(new FileWriter("course3.csv"));

        Student headings = allStudents[0];
        String headString = "";
        try {
            for (int i=0; i< fileWriters.length; i++) {
                headString = allStudents[0].getStudentID() + "," + allStudents[0].getName() + ","
                        + allStudents[0].getCourse() + "," + allStudents[0].getGrade();
                fileWriters[i].write(headString + "\n");
            }

                for (int j=1; j< allStudents.length; j++) {

                    Arrays.sort(allStudents, new Comparator<Student>() {

                        @Override
                        public int compare(Student o1, Student o2) {
                            return o2.getGrade().compareTo(o1.getGrade());
                        }
                    });

                    String courseStudents = allStudents[j].getStudentID() + "," + allStudents[j].getName() + ","
                            + allStudents[j].getCourse() + "," + allStudents[j].getGrade();

                    if (allStudents[j].getCourse().contains("COMPSCI")) {
                        fileWriters[0].write(courseStudents + "\n");
                    } else if (allStudents[j].getCourse().contains("STAT")) {
                        fileWriters[1].write(courseStudents + "\n");
                    } else {
                        fileWriters[2].write(courseStudents + "\n");
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                for (int i=0; i< fileWriters.length; i++) {
                    fileWriters[i].close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
