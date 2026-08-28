import java.util.*;

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

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        StudentManagement management = new StudentManagement();
        management.LoadFile();
        while (true) {
            System.out.println("======Student Management System======");
            System.out.println("1.For Add Student.");
            System.out.println("2.For Updating Student.");
            System.out.println("3.For Deleting Student.");
            System.out.println("4.For View Students.");
            System.out.println("5.For Exit Progarm.");
            int n = obj.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    int id;
                    while (true) {

                        try {
                            id = obj.nextInt();
                            obj.nextLine();
                            ValidatId(id);
                        } catch (UnmatchedArguement e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                        break;
                    }
                    System.out.println("Enter Name of the student:\n");
                    String name;
                    while (true) {
                        name = obj.nextLine();
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
                    Student student = new Student(id, name, email, course);
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
                    management.updateStudent(iid, nm, crs);
                    break;
                case 3:
                    System.out.println("Enter ID to delete the Student: ");
                    int rmd = obj.nextInt();
                    management.removeStudent(rmd);
                    break;
                case 4:
                    management.viewStudents();
                    break;
                case 5:
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
