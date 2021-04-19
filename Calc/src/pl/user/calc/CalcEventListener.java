package pl.user.calc;

import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

public class CalcEventListener implements java.awt.event.ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Pattern pattern = Pattern.compile("[0-9]");
        String actionValue = actionEvent.getActionCommand();
        if(actionValue.matches("[.]")){
            if(!Pattern.compile("\\d+[.]\\d.*").matcher(GUI.jTextField.getText()).matches()){
                GUI.jTextField.setText(GUI.jTextField.getText() + actionValue);
            }
        }else if(pattern.matcher(actionEvent.getActionCommand()).matches()){
            if(GUI.jTextField.getText().matches("0")){
                GUI.jTextField.setText(actionValue);
            }else{
                GUI.jTextField.setText(GUI.jTextField.getText() + actionValue);
            }
        }else{
            if(actionValue.matches("C")){
                GUI.lastOperationValue = "no";
                GUI.savedValue = "0";
                GUI.jTextField.setText("0");
            }else if(actionValue.matches("DEL") && !GUI.jTextField.getText().matches("0")){
                if(GUI.jTextField.getText().matches("[0-9]")){
                    GUI.jTextField.setText("0");
                }else {
                    try {
                        GUI.jTextField.setText(GUI.jTextField.getText(0,GUI.jTextField.getText().length()-1));
                    } catch ( BadLocationException e ) {
                        e.printStackTrace();
                    }
                }
            }else if(GUI.lastOperationValue.matches("no")){
                if(actionValue.matches("=")){
                    GUI.jTextField.setText(String.valueOf(Long.parseLong(GUI.jTextField.getText()) * 2));
                }else {
                    GUI.savedValue = GUI.jTextField.getText();
                    GUI.lastOperationValue = actionValue;
                    GUI.jTextField.setText("0");
                }
            }else {
                    CalcValue.calcResult(actionValue);

            }
        }

    }
}
