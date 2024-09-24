package com.mycompany.newmailboxfx;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SearchScreenController implements Initializable {
    @FXML
    Button btnHome;
    
    @FXML
    Button btnPhoto;
    
    @FXML
    Button btnManual;

    @FXML
    ImageView imageView;

    @FXML
    TextArea taAddress;

    @FXML public TableView<Student> tblStudent;
    @FXML public TableColumn<Student, Integer> colId;
    @FXML public TableColumn<Student, String> colFirstName;
    @FXML public TableColumn<Student, String> colLastName;
    @FXML public TableColumn<Student, String> colEmail;
    @FXML public TableColumn<Student, String> colAddress;
    
    public void onHomeButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnHome, "HomeScreen");
    }

    public void onPhotoButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnPhoto, "PhotoScreen");
    }
    
    public void onManualButtonClick(ActionEvent actionEvent) throws IOException {
        Common.loadWindow(btnManual, "Manual");
    }
    
    public void onSearchButtonClick(ActionEvent actionEvent) {
        //var server = "jdbc:ocu-mysql-capstone.mysql.database.azure.com:3306/mailbox";
        var server = "jdbc:mysql://localhost:3306/Student";
        var user = "root";
        var pwd = "Z8657a@&bced";

        ObservableList<Student> students = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(server, user, pwd)) {
                var sql = "SELECT * FROM StudentInformation WHERE id=?";
                
                PreparedStatement st = conn.prepareStatement(sql);
                
                st.setString(1, "avp");
                ResultSet rs = st.executeQuery();
                
                while(rs.next()) {
                    var student = new Student(rs.getInt("idstudent"),
                            rs.getString("FName"),
                            rs.getString("LName"),
                            rs.getString("Email"),
                            rs.getString("Address")
                    );
                    
                    students.add(student);
                }
            }


            tblStudent.setItems(loadData());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    private ObservableList<Student> loadData() {
        final ObservableList<Student> data =
                FXCollections.observableArrayList(
                        new Student(1,"Alex", "Powell", "123 example street", "avp@example.com"),
                        new Student(2,"Daelyn", "Bernard", "321 this street", "this@that.com"),
                        new Student(3, "Samantha", "Griffin", "456 that street", "example@mac.com"),
                        new Student(4, "Destiny", "Lyng", "654 here and there street", "here@there.com")
                );

        return data;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FileInputStream stream;
        try {
            stream = new FileInputStream("C:\\code\\capstone\\ocu-capstone-spring-2022-team-02\\MailboxFX\\photo.png");
            Image image = new Image(stream);
//        Image pictureTaken = new Image("C:\\code\\capstone\\ocu-capstone-spring-2022-team-02\\MailboxFX\\photo.png");
            imageView.setImage(image);
            imageView.setFitWidth(640);
            imageView.setFitHeight(380);
            imageView.setPreserveRatio(true);

            Tesseract tesseract = new Tesseract();
            try {

                tesseract.setDatapath("C:\\Java\\lib\\Tess4J\\tessdata");
                String text = tesseract.doOCR(new File("photo.png"));
                taAddress.setText(text);
            }
            catch (TesseractException e) {
                e.getMessage();
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("idstudent"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("FName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
    }
}