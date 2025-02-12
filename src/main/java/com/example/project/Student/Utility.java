package com.example.project.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            String lastName = list.get(i).getLastName();
            String firstName = list.get(i).getFirstName();
            double firstGPA = list.get(i).getGpa();
            for (int j = i + 1; j < list.size(); j++) {
                String nextLastName = list.get(j).getLastName();
                String nextFirstName = list.get(j).getFirstName();
                double secondGPA = list.get(j).getGpa();
                int compareLast = lastName.compareTo(nextLastName);
                int compareFirst = firstName.compareTo(nextFirstName);
                boolean compareGPA = secondGPA > firstGPA;
                if (compareLast > 0) {
                    list.add(i, list.remove(j));
                    list.add(j, list.remove(i + 1));
                    lastName = list.get(i).getLastName();
                } else if (compareLast == 0){
                    if (compareFirst > 0){
                        list.add(i, list.remove(j));
                        list.add(j, list.remove(i + 1));
                    }else if (compareFirst == 0){
                        System.out.println(firstName + " is equal to " + nextFirstName);
                        if (compareGPA) {
                            list.add(i, list.remove(j));
                            list.add(j, list.remove(i + 1));
                        }
                    }
                }
                lastName = list.get(i).getLastName();
                firstName = list.get(i).getFirstName();
                firstGPA = list.get(i).getGpa();
            }
        }
        return list;
    }
}
