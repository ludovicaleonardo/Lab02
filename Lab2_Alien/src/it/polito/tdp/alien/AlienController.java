package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	AlienDictionary alien;

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtWord;
	@FXML
	private TextArea txtResult;
	@FXML
	private Button btnTranslate;
	@FXML
	private Button btnReset;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

		alien = new AlienDictionary();
	}

	@FXML
	void doTranslate(ActionEvent event) {
		String parole[];
		String parola = txtWord.getText();
		parola=parola.trim();
		txtWord.clear();
		if (parola.matches("(^)([ ]*)([a-zA-Z]+)([ ]+)([a-zA-Z]+)([ ]*)($)")) {
		if (parola.contains(" ")) {
			parole = parola.split(" ");
			if (parole.length > 1) {
				alien.addWord(parole[0], parole[1]);
				txtResult.setText("Aggiunta nuova Parola");
				}
			}
		}
	 else {
		 if (parola.matches("(^)([ ]*)([a-zA-Z]+)([ ]*)($)")){
				txtWord.clear();
			txtResult.setText(alien.translateWord(parola));
	 		}
	 }
		//txtResult.setText("Devi inserire solo caratteri!");
		}
	

	@FXML
	void doReset(ActionEvent event) {
		txtResult.clear();
		alien.dizionario.clear();

	}

}
