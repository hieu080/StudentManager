/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.util.ArrayList;

/**
 *
 * @author HELLO
 */
public class StudentList extends ArrayList<Student>{ 
    public StudentList() { // Default Constructor
        super();
    } 
    
    public Student search (String code) {
        code= code.trim().toUpperCase();
        for (int i=0; i < this.size(); i++)
            if (this.get(i).getCode().equals(code))
                return this.get(i);
        return null;
    }
    
    private boolean isCodeDupplicated (String code) { 
        code= code.trim().toUpperCase();
        return search (code) !=null;
    }

    public void addStudent() {
    String newCode;
    String newName;
    int newMark = 0;
    boolean codeDuplicated = false;
    do {
        newCode = Inputter.inputPattern("St. code S000: ", "[sS] [\\d] {3}");
        newCode= newCode.trim().toUpperCase(); 
        codeDuplicated = isCodeDupplicated(newCode);
        if (codeDuplicated) 
            System.out.println("Code is duplicated!");
    }
    while (codeDuplicated == true);
    newName = Inputter.inputNonBlankStr("Name of new student: ");
    newName= newName.toUpperCase();
    newMark = Inputter.inputInt("Mark: ", 0, 10);
            
    Student st = new Student (newCode, newName, newMark);
    this.add(st);
    System.out.println("Student" + newCode + " has been added.");
}
    
    public void searchStudent () {
        if (this.isEmpty())
            System.out.println("Empty list. No search can be performed!");
        else{
            String uCode =Inputter.inputStr("Input student code for search: "); 
            Student st = this.search(uCode);
            if (st==null)
                System.out.println("Student "+ uCode + " doesn't existed!");
            else 
                System.out.println("Found: " + st);
        }
    }

    public void updateStudent () {
        if (this.isEmpty())
            System.out.println("Empty list. No update can be performed!");
        else {
            String uCode =Inputter.inputStr("Input code of updated student: ");
            Student st = this.search(uCode); // search student
            if (st==null)
                System.out.println("Student " + uCode + " doesn't existed!");
            else{
                String oldName = st.getName();
                String msg = "old name: " + oldName + ", new name:";
                String newName = Inputter.inputNonBlankStr(msg);
                st.setName(newName);
                int oldMark = st.getMark(); 
                msg="old mark: " + oldMark + ", new mark 0..10:";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Student " + uCode + " has been updated.");
            }
        }
    } 
    public void removeStudent () {
        if (this.isEmpty())
            System.out.println("Empty list. No remove can be performed!");
        else {
            String rCode =Inputter. inputStr("Input code of removed student: "); 
            Student st = this.search (rCode);
            if (st==null)
                System.out.println("Student "+rCode + " doesn't existed!");
            else{
                this.remove(st);
                System.out.println("Student" + rCode + " has been removed.");
            }
        }
    } 
    
    public void printAll() {
        if (this.isEmpty()) 
            System.out.println("Empty list!");
        else{
            System.out.println("Student list: ");
            for (Student st: this) 
            System.out.println(st);
            System.out.println("Total: " + this.size() + " student(s).");
        }
    }
}