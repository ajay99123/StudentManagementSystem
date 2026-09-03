import java.sql.SQLOutput;
import java.util.*;
import java.io.IOException;
public class Main {
    static void ValidatId(int var) throws UnmatchedArguement {
        if (var <= 0 || var > 1999) {
            throw new UnmatchedArguement("Invalid ID please Enter Valid Id (1-1999).");
        }
    }

    static void ValidateName(String name) throws UnmatchedArguement {
        name = name.trim();
        if (!(name.matches("[a-zA-Z ]+"))) {
            throw new UnmatchedArguement("Invalid Name Format Please Enter Again.");
        }
    }

    static void UpdateName(String nm) throws UnmatchedArguement {
        if (!(nm.matches("[a-zA-Z ]+"))) {
            throw new UnmatchedArguement("Invalid Name Updation Please Enter Correct Name.");
        }
    }

    static void ValidateEmail(String email) throws UnmatchedArguement {
        if (email.length() == 0) {
            throw new UnmatchedArguement("Mail Must not should be Empty Try Again..");
        }
        if (Character.isDigit(email.charAt(0))) {
            throw new UnmatchedArguement("The Mail must not start with Numbers Please try again..");
        }
        if (!(email.contains("@"))) {
            throw new UnmatchedArguement("The Mail Must Contains @ Symbol Try Again..");
        }
        int count = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
            if (count >= 2) {
                break;
            }
        }
        if (count >= 2) {
            throw new UnmatchedArguement("The Mail Must conatin Only Single @ Symbol Try Again..");
        }
        String gmail = "gmail.com";
        String yahoo = "yahoo.com";
        String mailin = "gmail.in";
        String outlook = "outlook.com";
        String hotmail = "hotmail.com";
        String after = email.substring(email.indexOf('@') + 1);
        if (!gmail.equals(after) && !yahoo.equals(after) && !mailin.equals(after)
                && !outlook.equals(after) && !hotmail.equals(after)) {
            throw new UnmatchedArguement("Invalid Mail format , After @ it should be in Exact mail format");
        }
    }

    static void AvailableCourse(String course) throws UnmatchedArguement {
        String jav = "java";
        String pyt = "python";
        String cpp = "c++";
        String cc = "c";
        if ((!course.equals(jav)) && (!course.equals(pyt)) && (!course.equals(cpp)) && (!course.equals(cc))) {
            throw new UnmatchedArguement("Course Not Found..");
        }
    }
    static void ValidatePhone(String phone) throws UnmatchedArguement{
        if(phone.length()>10||phone.length()<10){
            throw new UnmatchedArguement("Enter A Valid Phone Number");
        }
        int count=0;
        for(int i=0;i<phone.length();i++){
            if(Character.isDigit(phone.charAt(i))){
                count++;
            }
        }
        if(count<10||count>10){
            throw new UnmatchedArguement("Enter A Valid Phone Number");
        }
        if(phone.charAt(0)!='9'&& phone.charAt(0)!='8'&& phone.charAt(0)!='7'&&phone.charAt(0)!='6'){
            throw new UnmatchedArguement("Enter A Valid Phone Number");
        }
    }
    static void ValidSearch(int id) throws UnmatchedArguement{
        if(id<=0){
            throw new UnmatchedArguement("Enter Valid ID.");
        }
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        while (true) {
            System.out.println("======Student Management System======");
            System.out.println("1.For Add Student.");
            System.out.println("2.For Updating Student.");
            System.out.println("3.For Deleting Student.");
            System.out.println("4.For View Students.");
            System.out.println("5.For Search Student By ID.");
            System.out.println("6.For Exit Progarm.");
            int n = obj.nextInt();
            obj.nextLine();
            switch (n) {
                case 1:
                    System.out.println("Enter Name of the student:");
                    String name;
                    while (true) {
                        name = obj.nextLine();
                        name=name.trim();
                        try {
                            ValidateName(name);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    System.out.println("Enter Student Email: ");
                    String email;
                    while (true) {
                        email = obj.nextLine();
                        try {
                            ValidateEmail(email);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    System.out.println("Enter your course: ");
                    String course;
                    while (true) {

                        course = obj.nextLine();
                        try {
                            AvailableCourse(course);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    System.out.println("Enter Phone NUmber: ");
                    String phone;
                    while (true) {
                        phone = obj.nextLine();
                        try {
                            ValidatePhone(phone);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    Student student = new Student(0,name, email,phone , course);
                    management.addStudent(student);
                    break;
                case 2:
                    System.out.println("Enter ID: ");
                    int iid;
                    while (true) {
                        try {
                            iid = obj.nextInt();
                            obj.nextLine();
                            ValidatId(iid);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    System.out.println("Enter New Name :");
                    String nm;
                    while (true) {
                        nm = obj.nextLine();
                        nm=nm.trim();
                        try {
                            UpdateName(nm);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    System.out.println("Enter New Course: ");
                    String crs;
                    while (true) {
                        crs = obj.nextLine();
                        try {
                            AvailableCourse(crs);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    System.out.println("Enter Phone NUmber: ");
                    String ph;
                    while (true) {
                        ph = obj.nextLine();
                        try {
                            ValidatePhone(ph);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    management.updateStudent(iid,nm,ph,crs);
                    break;
                case 3:
                    System.out.println("Enter ID to delete the Student: ");
                    int rmd;
                    while(true){
                        rmd=obj.nextInt();
                        obj.nextLine();
                        try{
                            ValidSearch(rmd);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    management.removeStudent(rmd);
                    break;
                case 4:
                    management.viewStudents();
                    break;
                case 5:
                    int id;
                    System.out.println("Enter Student ID: ");
                    while(true){
                        id=obj.nextInt();
                        obj.nextLine();
                        try{
                            ValidSearch(id);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    management.SearchStudent(id);
                    break;
                case 6:
                    System.out.println("Program Closed");
                    return;
                default:
                    System.out.println("Enter Correct Choices.");
            }
        }
    }
}

class UnmatchedArguement extends Exception {
    UnmatchedArguement(String message) {
        super(message);
    }
}
