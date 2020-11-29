package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginController {
    private Stage stage;
    private ArrayList register = new ArrayList();
    @FXML private TextField txt_Username;
    @FXML private TextField txt_Password;
    @FXML private Text txt_Error;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void Login (){
        if (!txt_Username.getText().equals("") && !txt_Password.getText().equals("")){
            for (int i=0; i<register.size()/2;i=+2) {
                if (txt_Username.equals(register.get(i))){
                    txt_Password.equals(register.get(i++));
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

        this.stage.close();
    }
    public ArrayList getRegister() {
        return register;
    }

    public void addRegister(String s) {
        register.add(s);
    }
}
