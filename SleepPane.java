import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SleepPane extends GridPane
{
    private Button calculateButton;
    private Button exitButton;
    private Button clearButton;
    private TextField userName;
    private TextField userAge;
    private TextField userSleepHours;
    private Label sleepYears;
    private Label sleepDays;
    private Label sleepHours;
    private Label yearsResult;
    private Label hoursResult;
    private Label daysResult;
    
    public SleepPane()
    {
        /*------------------------------------------------------------------
         * Below the font size, textfield, and input/output label objects are 
         * all created and are added to the gridpane.
         * -----------------------------------------------------------------
         */
                                
        Font font = new Font(18);
        
        Label inputLabelName = new Label("Name:");
        inputLabelName.setFont(font);
        GridPane.setHalignment(inputLabelName, HPos.RIGHT);
        
        userName = new TextField();
        userName.setFont(font);
        userName.setPrefWidth(150);
        userName.setAlignment(Pos.CENTER);
        
        Label inputLabelAge = new Label("Age:");
        inputLabelAge.setFont(font);
        GridPane.setHalignment(inputLabelAge, HPos.RIGHT);
        
        userAge = new TextField();
        userAge.setFont(font);
        userAge.setPrefWidth(25);
        userAge.setAlignment(Pos.CENTER);
        
        Label inputLabelSleepHours = new Label("Average Sleep Hours:");
        inputLabelSleepHours.setFont(font);
        GridPane.setHalignment(inputLabelSleepHours, HPos.RIGHT);
        
        userSleepHours = new TextField();
        userSleepHours.setFont(font);
        userSleepHours.setPrefWidth(25);
        userSleepHours.setAlignment(Pos.CENTER);
        
        Label outputLabelYears = new Label("Years:");
        outputLabelYears.setFont(font);
        GridPane.setHalignment(outputLabelYears, HPos.RIGHT);
        
        Label outputLabelDays = new Label("Days:");
        outputLabelDays.setFont(font);
        GridPane.setHalignment(outputLabelDays, HPos.RIGHT);
        
        Label outputLabelHours = new Label("Hours:");
        outputLabelHours.setFont(font);
        GridPane.setHalignment(outputLabelHours, HPos.RIGHT);
        
        yearsResult = new Label("-");
        yearsResult.setFont(font);
        GridPane.setHalignment(yearsResult, HPos.CENTER);
        
        daysResult = new Label("-");
        daysResult.setFont(font);
        GridPane.setHalignment(daysResult, HPos.CENTER);
        
        hoursResult = new Label("-");
        hoursResult.setFont(font);
        GridPane.setHalignment(hoursResult, HPos.CENTER);

        /*--------------------------------------------------------------------
         * Below the three buttons are created and the processButtons method is
         * called for each Button object and then they're added to the gridpane.
         * -------------------------------------------------------------------
         */
        
        calculateButton = new Button("Calculate");
        calculateButton.setOnAction(this::processButtons);
        GridPane.setHalignment(calculateButton,HPos.LEFT);
 
        exitButton = new Button("Exit");
        exitButton.setOnAction(this::processButtons);
        GridPane.setHalignment(exitButton,HPos.LEFT);
        
        clearButton = new Button("Clear");
        clearButton.setOnAction(this::processButtons);
        GridPane.setHalignment(clearButton,HPos.LEFT);

        /*--------------------------------------------------------------------
         * Here the javafx window is adjusted and the labels, buttons, outputs, 
         * and text fields are designated their row, column, and sizes on the gridpane.
         * -------------------------------------------------------------------
         */
        
        setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(10);
        setStyle("-fx-background-color: deepskyblue");
        
        add(inputLabelName, 0, 0, 1, 1);
        add(inputLabelAge, 0, 1, 1, 1);
        add(inputLabelSleepHours, 0, 2, 1, 1);
        add(userName, 1, 0, 1, 1);
        add(userAge, 1, 1, 1, 1);
        add(userSleepHours, 1, 2, 1, 1);
        add(outputLabelYears, 0, 3, 1, 1);
        add(outputLabelDays, 0, 4, 1, 1);
        add(outputLabelHours, 0, 5, 1, 1);
        add(yearsResult, 1, 3, 1, 1);
        add(daysResult, 1, 4, 1, 1);
        add(hoursResult, 1, 5, 1, 1);
        add(calculateButton, 0, 6, 1, 1);
        add(clearButton, 1, 6, 1, 1);
        add(exitButton, 2, 6, 1, 1);
        
    }
    
    public void processButtons(ActionEvent event)
    {
        if(event.getSource() == calculateButton)
        {
            /*--------------------------------------------------------
             * Below int instance values are made and used to store and 
             * compute the amount of years, days, and hours the user has 
             * spent sleeping. Using the setText method the Result objects 
             * are updated for display.
             * -------------------------------------------------------
             */
            
            
                int age = Integer.parseInt(userAge.getText());
                int sleepTime = Integer.parseInt(userSleepHours.getText());
                int howManyHours = (age * 365 * sleepTime);
                int howManyDays = (howManyHours / 24);
                int howManyYears = (howManyDays / 365);
                
                yearsResult.setText(howManyYears + "");
                daysResult.setText(howManyDays + "");
                hoursResult.setText(howManyHours + "");
            }

            /*---------------------------------------------------------
             * For the clearButton each text field and output objects are 
             * reset to their original values and the input focus is 
             * on the userName text field using the requestFocus method.
             * If any other button is selected the program will terminate.
             * --------------------------------------------------------
             */
            
        else if (event.getSource() == clearButton){
            userName.setText("");
            userAge.setText("");
            userSleepHours.setText("");
            yearsResult.setText("-");
            daysResult.setText("-");
            hoursResult.setText("-");
            userName.requestFocus();
        }
        
        else    {   
                System.exit(0);
    }
    
}

}
                
                