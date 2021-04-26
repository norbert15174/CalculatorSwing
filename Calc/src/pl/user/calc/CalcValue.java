package pl.user.calc;

import java.text.DecimalFormat;

public class CalcValue {
    public static void addValue(Double first, Double second){
        GUI.lastOperationValue = "+";
        GUI.savedValue = String.valueOf(first+second);
        GUI.jTextField.setText("0");
    }
    public static void subtractValue(Double first, Double second){
        GUI.lastOperationValue = "-";
        GUI.savedValue = String.valueOf(first-second);
        GUI.jTextField.setText("0");
    }
    public static void multiplyValue(Double first, Double second){
        GUI.lastOperationValue = "x";
        GUI.savedValue = String.valueOf(first*second);
        GUI.jTextField.setText("0");
    }
    public static void divideValue(Double first, Double second){
        GUI.lastOperationValue = "/";
        GUI.savedValue = String.valueOf(first*second);
        GUI.jTextField.setText("0");
    }
    public static void modValue(Double first, Double second){
        GUI.lastOperationValue = "%";
        GUI.savedValue = String.valueOf(first%second);
        GUI.jTextField.setText("0");
    }

    public static void calcResult(String value) {
        Double firstValue = Double.parseDouble(GUI.savedValue);
        Double secondValue = Double.parseDouble(GUI.jTextField.getText());
        String val = GUI.lastOperationValue;
        if(value.matches("=")){
                checkOperation(firstValue,secondValue);
        }else{
            switch (val){
                case "+":
                    addValue(firstValue,secondValue);
                    break;
                case "-":
                    subtractValue(firstValue,secondValue);
                    break;
                case "/":
                    divideValue(firstValue,secondValue);
                    break;
                case "x":
                    multiplyValue(firstValue,secondValue);
                    break;
                case "%":
                    modValue(firstValue,secondValue);
                    break;
                case "=":
                    addValue(firstValue,0.0);
                    break;
                default:
                    break;
            }
        }
        GUI.lastOperationValue = value;
    }

    public static void checkOperation(Double first, Double second){
        double v;
        switch (GUI.lastOperationValue){
            case "+":
                v = first+second;
                setValue(v);
                break;
            case "-":
                v = first-second;
                setValue(v);
                break;
            case "/":
                v = first/second;
                setValue(v);
                break;
            case "x":
                v = first*second;
                setValue(v);
                break;
            case "%":
                v = first%second;
                setValue(v);
                break;
            case "=":
                v = 2*first;
                setValue(v);
            default:
                break;
        }


    }
    public static void setValue(Double v){
        if(v.longValue() == v){
            GUI.savedValue = String.valueOf(v.longValue());
        }else{
            DecimalFormat numberFormat = new DecimalFormat("#0.0000");
            GUI.savedValue = numberFormat.format(v);
        }
        GUI.jTextField.setText(GUI.savedValue);
        GUI.lastOperationValue = "no";
    }
}
