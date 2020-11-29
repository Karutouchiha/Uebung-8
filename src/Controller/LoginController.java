package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {
    private Stage stage;
    private ArrayList<String> register = new ArrayList();
    @FXML private TextField txt_Username;
    @FXML private TextField txt_Password;
    @FXML private Text txt_Error;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void Login (){
        this.txt_Error.setVisible(false);
        if (!txt_Username.getText().equals("") && !txt_Password.getText().equals("")){
            for (int i=0; i<register.size()/2;i=i+2) {
                if (txt_Username.getText().equals(this.register.get(i))){
                    i++;
                    if (txt_Password.getText().equals(register.get(i))){
                        loadScene("");
                    }
                }
            }
        }
        else {
            txt_Error.setText("Error: Sie haben ein Feld Ausgelassen");
            txt_Error.setVisible(true);
            txt_Password.clear();
            txt_Username.clear();

        }
    }
    @FXML
    public void Register(){
        this.txt_Error.setVisible(false);
        loadScene("Register.fxml");
    }
    public ArrayList getRegister() {
        return register;
    }

    public void addRegister(String Username, String Password) {
        register.add(Username);
        register.add(Password);
    }
    public void loadScene(String s) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
            Parent root = loader.load();

            RegisterController Controller = loader.getController();
            stage.setScene(new Scene(root));
            Controller.setStage(this.stage);
            this.stage.close();
        } catch (Exception ex) {
            this.txt_Error.setText("Stage konnte nicht Geladen werden");
            this.txt_Error.setVisible(true);
        }
    }
}
