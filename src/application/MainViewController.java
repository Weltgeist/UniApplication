package application;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainViewController implements Initializable  { // 
	
	@FXML private Button nextButton;
	
	//TODO: Task 1: Create a single javafx.scene .control.TextField
	
	//TODO: Task 2: Delete all existing ComboBoxes
	@FXML private ComboBox<Integer> n1;
	@FXML private ComboBox<Integer> n2;
	@FXML private ComboBox<Integer> n3;
	@FXML private ComboBox<Integer> n4;
	@FXML private ComboBox<Integer> n5;
	@FXML private ComboBox<Integer> n6;
	@FXML private ComboBox<Integer> n7;
	@FXML private ComboBox<Integer> n8;
	@FXML private ComboBox<Integer> n9;

	
	@FXML private ImageView feedbackImageView;

	private Image redXImage =new Image(getClass().getResourceAsStream("view/redx.png"));
	private Image greencheckImage =new Image(getClass().getResourceAsStream("view/greencheck.png"));

	@Override
	public void initialize(URL location, ResourceBundle ressources) {
		// TODO Task 2: Delete the setup of the combo boxes
		Integer[] options= {0,1,2,3,4,5,6,7,8,9};
		for(ComboBox<Integer> comboBox: Arrays.asList(n1,n2,n3,n4,n5,n6,n7,n8,n9)) {
			comboBox.getItems().addAll(options);
		}
		
		//TODO: Task 1: Add a textProperty()listener to the new textField and Task 3: invoke the validate method with the new string value of the text...
		
		nextButton.setDisable(true);
		feedbackImageView.setImage(redXImage);

	}

	//TODO : Task 2:Delete the method comboBoxValueChanded()
	
	@FXML
	private void comboBoxValueChanged() {
		for (ComboBox<Integer> comboBox: Arrays.asList(n1,n2,n3,n4,n5,n6,n7,n8,n9)) {
			if (comboBox.getValue()==null) {
				System.out.println("At least 1 number of matriculation number not yet filled");
				nextButton.setDisable(true);
				feedbackImageView.setImage(redXImage);
				return;
			}
		}
		System.out.println("All numbers of matriculation number are filled");
		nextButton.setDisable(false);
		feedbackImageView.setImage(greencheckImage );
	}
	
	public void validate(String matriculationNumber) {
		boolean isCorrect=isMatriculationNumber(matriculationNumber);
		nextButton.setDisable(!isCorrect);
		if(!isCorrect) {
			System.out.println("Validation fail");
			feedbackImageView.setImage(redXImage);
			
		}
		else {
			System.out.println("Validation sucess");
			feedbackImageView.setImage(greencheckImage);
		}
	}
	
	@FXML
	private void next() {
		System.out.println("Next Button clicked");
	}
	
	public boolean isMatriculationNumber(String matriculationNumber) {
		return matriculationNumber.matches("[0-9]+")&& matriculationNumber.length()==8;
	}
}
