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
        Student[] course1 = new Student[101];
        Student[] course2 = new Student[101];
        Student[] course3 = new Student[101];

        BufferedWriter fileWriter = null;
        BufferedWriter fileWriter2 = null;
        BufferedWriter fileWriter3 = null;

        //String studentInfo1 = "";
        Student headings = allStudents[0];
        try {
            fileWriter = new BufferedWriter(new FileWriter("course1.csv"));
            fileWriter2 = new BufferedWriter(new FileWriter("course2.csv"));
            fileWriter3 = new BufferedWriter(new FileWriter("course3.csv"));

            //int index = 0;
            int i1 = 0;
            int i2 = 0;
            int i3 = 0;

            String stCourse1 = "";
            String stCourse2 = "";
            String stCourse3 = "";
            String headString ="";


            for (int index = 0; index < allStudents.length; index++) {
                if (allStudents[index] == headings) {
                    headString = allStudents[index].getStudentID() + "," + allStudents[index].getName() + ","
                            + allStudents[index].getCourse() + "," + allStudents[index].getGrade();
                    fileWriter.write(headString + "\n");
                    fileWriter2.write(headString + "\n");
                    fileWriter3.write(headString + "\n");
                    course1[i1] = allStudents[index];
                    course2[i2] = allStudents[index];
                    course2[i3] = allStudents[index];
                    i1++;
                    i2++;
                    i3++;
                }else if (allStudents[index].getCourse().contains("COMPSCI")) {
                    stCourse1 = allStudents[index].getStudentID() + "," + allStudents[index].getName() + ","
                            + allStudents[index].getCourse() + "," + allStudents[index].getGrade();

                    fileWriter.write(stCourse1 + "\n");
                    course1[i1] = allStudents[index];
                    i1++;
                } else if (allStudents[index].getCourse().contains("STAT")) {
                    stCourse2 = allStudents[index].getStudentID() + "," + allStudents[index].getName() + ","
                            + allStudents[index].getCourse() + "," + allStudents[index].getGrade();
                    fileWriter2.write(stCourse2 + "\n");
                    course2[i2] = allStudents[index];
                    i2++;
                } else if (allStudents[index].getCourse().contains("APMTM")) {
                    stCourse3 = allStudents[index].getStudentID() + "," + allStudents[index].getName() + ","
                            + allStudents[index].getCourse() + "," + allStudents[index].getGrade();
                    fileWriter3.write(stCourse3 + "\n");
                    course2[i3] = allStudents[index];
                    i3++;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        Arrays.sort(course1, new Comparator <Student> () {
//
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getGrade().compareTo(o2.getGrade());
//            }
//        });

        for (int j = 0; j < course1.length; j++) {
            System.out.println(course1[j].getStudentID() + "," + course1[j].getName() + "," + course1[j].getCourse() + "," +
                    course1[j].getGrade());

        }
        for (int j = 0; j < course2.length; j++) {
            System.out.println(course2[j].getStudentID() + "," + course2[j].getName() + "," + course2[j].getCourse() + "," +
                    course2[j].getGrade());

        }
        for (int j = 0; j < course3.length; j++) {
            System.out.println(course3[j].getStudentID() + "," + course3[j].getName() + "," + course3[j].getCourse() + "," +
                    course3[j].getGrade());

        }


    }



}
