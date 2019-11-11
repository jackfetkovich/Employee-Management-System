import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.Serializable;




import static java.lang.String.valueOf;

public class Interface extends Application implements Serializable{
    static Stage window;
    Scene welcomeScreen;
   static  Scene mainMenu;
    Scene createEmployee;

    @Override
    public void start(Stage primaryStage) throws Exception {


        ReadEmployees.main(null);


        window = primaryStage;
        window.setOnCloseRequest(event ->{
            WriteEmployees.main(null);
        });
        ListView listView = new ListView();

        for(int i = 0; i < Employee.list.size(); i++){
            listView.getItems().add(Employee.list.get(i));
        }

        //Scene 1

        //Welcome Button opens main menu
        Button welcome = new Button("Welcome");
        welcome.setOnAction(event ->{
            window.setScene(mainMenu);
        });
        Image importLogo = new Image("fetkovichlogo.png");
        ImageView logo = new ImageView(importLogo);
        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(logo, welcome);
        vbox1.setSpacing(100);
        vbox1.setAlignment(Pos.CENTER);
        welcomeScreen = new Scene(vbox1, 960, 540);

        //Scene 2
         //Dropdown menu
         //Making the plus button image and putting it on the menu
        Image importPlusBut = new Image("free-png-plus-sign-plus-icon-512.png");
         ImageView plusBut = new ImageView(importPlusBut);
        //resizing the plus button
         plusBut.setFitHeight(25);
         plusBut.setFitWidth(25);

       //Adding menu Actions to menu functionality
        Menu menu1 = new Menu("Actions");
            //Adding Add Employee as sub menu to actions
        MenuItem addEmployee = new MenuItem("Add Employee");
            addEmployee.setGraphic(plusBut);
        MenuItem removeEmployee = new MenuItem("Remove Employee");
            removeEmployee.setOnAction(event -> {
                int del = listView.getSelectionModel().getSelectedIndex();
                listView.getItems().remove(del);
                Employee.list.remove(del);
            });

            menu1.getItems().addAll(addEmployee, removeEmployee);
            //When you press the add employee sub menu, it opens the employee creation screen
            addEmployee.setOnAction(event -> window.setScene(createEmployee));
         Menu menu2 = new Menu("Profile");
         Menu menu3 = new Menu("Help");
         MenuBar menuBar = new MenuBar();
         menuBar.getMenus().addAll(menu1, menu2, menu3);

         //Sets up the main menu scene
        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(menuBar, listView);
        mainMenu = new Scene(vbox2, 960, 540);


        //Scene Create Employee

        //Creating the text fields and setting prompt text for Employee constructor fields
       TextField employeeFirstName = new TextField();
            employeeFirstName.setPromptText("John");
       TextField employeeLastName = new TextField();
            employeeLastName.setPromptText("Doe");
       TextField employeePosition = new TextField();
            employeePosition.setPromptText("Accountant");
       TextField employeeSalary = new TextField();
            employeeSalary.setPromptText("42000");

         //Creating labels for Employee creation text boxes and setting their font
        Label firstNameBoxLabel = new Label("First Name");
            firstNameBoxLabel.setFont(Font.font("Verdana", 30));
        Label lastNameBoxLabel = new Label("Last Name");
            lastNameBoxLabel.setFont(Font.font("Verdana", 30));
        Label positionBoxLabel = new Label("Position");
            positionBoxLabel.setFont(Font.font("Verdana", 30));
        Label salaryBox = new Label("Salary ($)");
            salaryBox.setFont(Font.font("Verdana", 30));

        //Setting variables to get text from the text fields
        String empFirstNameText = employeeFirstName.getText();
        String empLastNameText = employeeLastName.getText();
        String empPosition = employeePosition.getText();
        String empSalary = String.valueOf(employeeSalary);

        //Creating buttons for Employee creation
        Button confirm = new Button("Confirm");
        Button cancel = new Button("Cancel");

        //Resizing employee creation buttons
        confirm.setMinSize(75,50);
        cancel.setMinSize(75,50);

        //cancel button sends you back to main menu without creating employee object
        cancel.setOnAction(event -> {
            ConfirmBox.display("Confirm Exit", "Are you sure you want to exit?");
        }
                );

        //Making layout, setting padding, and making horizontal and vertical gaps
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //Adding elements to the layout
        gridPane.setConstraints(firstNameBoxLabel, 0, 0);
        gridPane.setConstraints(employeeFirstName, 1, 0 );

        gridPane.setConstraints(lastNameBoxLabel,0,1);
        gridPane.setConstraints(employeeLastName, 1, 1 );

        gridPane.setConstraints(positionBoxLabel, 0,2);
        gridPane.setConstraints(employeePosition, 1,2);

        gridPane.setConstraints(salaryBox, 0,3 );
        gridPane.setConstraints(employeeSalary, 1, 3);

        gridPane.setConstraints(confirm, 0,8);
        gridPane.setConstraints(cancel, 1, 8);

        //Confirm Button = create new employee on list
        confirm.setOnAction(event -> {
          if(employeeFirstName.getText().isEmpty()  || employeeLastName.getText().isEmpty()|| employeePosition.getText().isEmpty() || employeeSalary.getText().isEmpty()){
              FinishEditingBox.display();
          }else {

              Employee.addToList(employeeFirstName.getText(), employeeLastName.getText(), employeePosition.getText(), String.valueOf(employeeSalary.getText()));
              listView.getItems().clear();

              //Iterating throught employee list and adding all to listView
              for(int i = 0; i < Employee.list.size(); i++){
                  //listView.getItems().clear();
                  listView.getItems().add(Employee.list.get(i));
              }

              //clear all fields on employee creation
              employeeFirstName.clear();
              employeeLastName.clear();
              employeePosition.clear();
              employeeSalary.clear();

              window.setScene(mainMenu);
          }
        });

        //Setting all the obkects in layout to the center and adding them to the layout
        gridPane.setAlignment(Pos.CENTER);
        gridPane.getChildren().addAll(firstNameBoxLabel, employeeFirstName, lastNameBoxLabel, employeeLastName, positionBoxLabel, employeePosition, salaryBox, employeeSalary, confirm, cancel);

        //making the gridPane layout the official layout of the create employee scene
        createEmployee = new Scene(gridPane, 960,540);

        //Open Application
        window.setScene(welcomeScreen);

        window.setTitle("Fetkovich Enterprises");
        window.show();

    }

    public static void resWindow(){
        window.setScene(mainMenu);
   }
    public static void main(String[] args){
        launch(args);
    }
}
