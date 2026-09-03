import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class StudentManagement {
    //Adding the Student here
    public void addStudent(Student student) {
        String query = "INSERT INTO STUDENT(name,email,phone,course) VALUES(?,?,?,?)";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement prepst = con.prepareStatement(query)) {
            prepst.setString(1, student.getName());
            prepst.setString(2, student.getEmail());
            prepst.setString(3, student.getPhone());
            prepst.setString(4, student.getCourse());
            prepst.executeUpdate();
            System.out.println("Successfully Added to Student Database.");
        } catch (SQLException e) {
            System.out.println("Error occured While adding Student to Database--" + e.getMessage());
        }
    }

    //updating the Student here
    public void updateStudent(int id, String name,  String phone,String course) {
        String query = "UPDATE STUDENT SET name=? ,phone=? , course=?  WHERE id= ?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement prepst = con.prepareStatement(query)) {
            prepst.setString(1, name);
            prepst.setString(2, phone);
            prepst.setString(3, course);
            prepst.setInt(4, id);
            int rows = prepst.executeUpdate();
            if (rows > 0) {
                System.out.println("Updated Successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error Occured while Updating Student." + e.getMessage());
        }
    }

    //viewing all the Students here
    public void viewStudents() {
        String query = "select * from student";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement prepst = con.prepareStatement(query);
             ResultSet rs = prepst.executeQuery()) {
            boolean found = true;
            while (rs.next()) {
                found = false;
                System.out.println("Student Id: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Enrolled Course: " + rs.getString("course"));
                System.out.println("<------------------------------------------------->");
            }
            if (found) {
                System.out.println("Students Not Found.");
            }
        } catch (SQLException e) {
            System.out.println("Error occured while Loading Student Databse" + e.getMessage());
        }
    }

    //deleting the Student here
    public void removeStudent(int id) {
        String query = "DELETE FROM STUDENT WHERE id=?";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement prepst = con.prepareStatement(query)) {
            prepst.setInt(1,id);
            int row=prepst.executeUpdate();
            if(row>0){
                System.out.println("Succesfully Deleted the Student.");
            }else{
                System.out.println("Student Not Found");
            }
        } catch (SQLException e) {
            System.out.println("Error Ocuured While Deleting Student" + e.getMessage());
        }
    }
    public void SearchStudent(int id){
        String query="select * from student where id= ?";
        try(Connection con=DbConnection.getConnection();
        PreparedStatement prepst= con.prepareStatement(query)){
            prepst.setInt(1,id);
            ResultSet rs= prepst.executeQuery();
            if(rs.next()) {
                System.out.println("Student Id: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Enrolled Course: " + rs.getString("course"));
                System.out.println("<------------------------------------------------->");
            }else{
                System.out.println("Student Not Found.");
            }
        }
        catch(SQLException e){
            System.out.println("Error occured While Searching Student."+e.getMessage());
        }
    }
}