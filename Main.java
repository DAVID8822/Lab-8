package csci2020u.lab08;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import java.io.*;

public class Main extends Application {

    @FXML private TableView<StudentRecord> tableView;
    @FXML private TextField studentIdField;
    @FXML private TextField assignmentsField;
    @FXML private TextField midtermField;
    @FXML private TextField finalExamField;
    private String currentFilename = "output.txt";
    private ObservableList<StudentRecord> data = Data.getAllMarks();
    public Stage stage;
    @FXML
    public void initialize() {

        TableColumn col1 = new TableColumn("SID");
        col1.setMinWidth(100);
        col1.setCellValueFactory(new PropertyValueFactory<csci2020u.lab05.StudentRecord, String>("studentNumber"));
        TableColumn col2 = new TableColumn("Assignments");
        col2.setMinWidth(100);
        col2.setCellValueFactory(new PropertyValueFactory<csci2020u.lab05.StudentRecord, Float>("assignments"));
        TableColumn col3 = new TableColumn("Midterm");
        col3.setMinWidth(100);
        col3.setCellValueFactory(new PropertyValueFactory<csci2020u.lab05.StudentRecord, Float>("midterm"));
        TableColumn col4 = new TableColumn("Final Exam");
        col4.setMinWidth(100);
        col4.setCellValueFactory(new PropertyValueFactory<csci2020u.lab05.StudentRecord, Float>("finalexam"));
        TableColumn col5 = new TableColumn("Final Mark");
        col5.setMinWidth(100);
        col5.setCellValueFactory(new PropertyValueFactory<csci2020u.lab05.StudentRecord, Double>("finalmark"));
        TableColumn col6 = new TableColumn("Letter Grade");
        col6.setMinWidth(100);
        col6.setCellValueFactory(new PropertyValueFactory<csci2020u.lab05.StudentRecord, Character>("letterGrade"));
        col1.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        col2.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        col3.setCellValueFactory(new PropertyValueFactory<>("assignments"));
        col4.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        col5.setCellValueFactory(new PropertyValueFactory<>("finalMark"));
        col6.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
        tableView.setItems(data);
        tableView.getColumns().addAll(col1,col2,col3,col4,col5,col6);
    }

    @FXML
    public void newButton() {
        data.clear();
    }

    @FXML
    public void exitButton()
    {
        System.exit(0);
    }

    @FXML
    public void openButton() throws IOException {
        data.clear();
        String line = "";
        FileChooser fileChooser = new FileChooser();
        currentFilename = fileChooser.showOpenDialog(stage).getName();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.csv"));
            BufferedReader reader = new BufferedReader(new FileReader(currentFilename));
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                // add the new student record
                String studentID = columns[0];
                float assignments = Float.parseFloat(columns[1]);
                float midterm = Float.parseFloat(columns[2]);
                float finalExam = Float.parseFloat(columns[3]);

                StudentRecord newStudentRecord = new StudentRecord(studentID, assignments, midterm, finalExam);
                data.add(newStudentRecord);
            }
            // finish reading
        reader.close();

    }

    @FXML
    public void saveButton() {

    }
    @FXML
    public void saveAsButton() {

    }




    @FXML
    public void addStudentRecord() {
        double assignments = Double.parseDouble(assignmentsField.getText());
        double midterm = Double.parseDouble(midtermField.getText());
        double finalExam = Double.parseDouble(finalExamField.getText());
        String studentID = studentIdField.getText();
        StudentRecord newStudentRecord = new StudentRecord(studentID, assignments, midterm, finalExam);
        data.add(newStudentRecord);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Lab08");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}