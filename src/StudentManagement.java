
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class StudentManagement {
    ArrayList<Student> students = new ArrayList<>();

    //Adding the Student here
    public void addStudent(Student student) {
        students.add(student);
        saveTOFile();
        System.out.println("Succesfully Added the Student.");
        return;
    }

    //updating the Student here
    public void updateStudent(int id, String name, String course) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setCourse(course);
                saveTOFile();
                System.out.println("Updated Successfully");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    //viewing all the Students here
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("Students Not found.");
            return;
        }
        for (Student student : students) {
//            System.out.println("<------------------------------------->");
            System.out.println("Student Id: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Enrolled Course: " + student.getCourse());
            System.out.println("<------------------------------------->");
            System.out.println();
        }
    }

    //deleting the Student here
    public void removeStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                saveTOFile();
                System.out.println("Successfully Removed the Student.");
                return;
            }
        }
        System.out.println("Student Not found.");
    }
    public void saveTOFile(){
        try{
            FileWriter wrt=new FileWriter("student.txt");
            for(Student student:students){
                wrt.write(student.getId()+" | "+student.getName()+" | "+student.getEmail()+" | "+student.getCourse()+"\n");
            }
            wrt.close();
        } catch (IOException e) {
            System.out.println(" Error Occured while Saving the content");
        }
    }
    public void LoadFile(){
        File file=new File("student.txt");
        if(!file.exists()){
            return;
        }
        try{
            Scanner obj=new Scanner(file);
            while(obj.hasNextLine()){
                String line= obj.nextLine();
                String[] data=line.split("\\|");
                int id=Integer.parseInt(data[0].trim());
                String name=data[1].trim();
                String email=data[2].trim();
                String course=data[3].trim();
                Student student=new Student(id,name,email,course);
                students.add(student);
            }
            obj.close();
        }
        catch(IOException e){
            System.out.println("Error Ocuured while Working With File.");
        }

    }
}
