package pl.user.calc;

import java.text.DecimalFormat;

public class CalcValue {

    public static void addValues(String value){
        Double val2 = Double.parseDouble(value);
        Double val1 = Double.parseDouble(GUI.lastValue);
        displayValue(val1+val2);
        GUI.lastValue = String.valueOf(val1+val2);
        GUI.lastOperation = "+";
        GUI.operation = true;
    }
    public static void subtractValues(String value){
        Double val2 = Double.parseDouble(value);
        Double val1 = Double.parseDouble(GUI.lastValue);
        displayValue(val1-val2);
        GUI.lastValue = String.valueOf(val1-val2);
        GUI.lastOperation = "-";
        GUI.operation = true;
    }
    public static void divideValues(String value){

        Double val2 = Double.parseDouble(value);
        Double val1 = Double.parseDouble(GUI.lastValue);
        System.out.println("val2" + val2);
        System.out.println("val2" + val1);
        displayValue(val1/val2);
        GUI.lastValue = String.valueOf(val1/val2);
        GUI.lastOperation = "/";
        GUI.operation = true;
    }
    public static void multiplyValues(String value){
        Double val2 = Double.parseDouble(value);
        Double val1 = Double.parseDouble(GUI.lastValue);
        displayValue(val1*val2);
        GUI.lastValue = String.valueOf(val1*val2);
        GUI.lastOperation = "x";
        GUI.operation = true;
    }
    public static void moduloValues(String value){
        Double val2 = Double.parseDouble(value);
        Double val1 = Double.parseDouble(GUI.lastValue);
        displayValue(val1%val2);
        GUI.lastValue = String.valueOf(val1%val2);
        GUI.lastOperation = "%";
        GUI.operation = true;
    }

    public static void displayValue(double val){
        DecimalFormat decimalFormat = new DecimalFormat("#0.00000");
        if(Math.round(val) == val){
            GUI.jTextField.setText(String.valueOf(Math.round(val)));
        }else{
            GUI.jTextField.setText(String.valueOf(decimalFormat.format(val)));
        }

    }

}
