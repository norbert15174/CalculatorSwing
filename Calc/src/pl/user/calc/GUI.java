package pl.user.calc;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class GUI {
    public static JFrame jf = new JFrame("Calculator");
    public static JTextField jTextField = new JTextField();
    public static String lastValue = "0";
    public static String lastOperation = "no";
    public static String operValue = "0";
    public static boolean operation = false;
    public static boolean afterEqual = true;





    public static JButton createButton(String name){
        JButton jb = new JButton(name);
        jb.setBackground(new Color(52, 52, 46));
        jb.setFont(new Font("Serif", Font.PLAIN, 20));
        jb.setForeground(Color.orange);
        if(Pattern.compile("^[0-9 | INV | . | x | \\- | +]").matcher(name).matches()){
            jb.setBackground(Color.orange);
            jb.setForeground(Color.decode("#2e2d2d"));
            jb.setFont(new Font("Serif", Font.PLAIN, 22));
        }
        jb.setBorder(BorderFactory.createLineBorder(Color.decode("#2e2d2d")));
        jb.setPreferredSize(new Dimension(100, 100));
        jb.addActionListener(new CalcEventListener());
        return jb;
    }

    public static JTextField createJTextField(){
        jTextField.setFont(new Font("Serif", Font.PLAIN, 40));
        jTextField.setForeground(Color.orange);
        jTextField.setBorder(BorderFactory.createLineBorder(Color.decode("#2e2d2d")));
        jTextField.setBackground(new Color(52, 52, 46));
        jTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        jTextField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 35));
        jTextField.setPreferredSize(new Dimension(100,100));
        jTextField.setEditable(false);
        jTextField.setText("0");
        return jTextField;
    }

    public static void createAndShowGUI() {

        JPanel jPanel = new JPanel(new GridLayout(5,5,0,0));
        createJTextField();


        String[] keyTab = {"/","%","C","DEL","9","8","7","x","6","5","4","-","3","2","1","+","INV","0",".","="};
        for(String s : keyTab) jPanel.add(createButton(s));

        jf.getContentPane().add(jTextField,BorderLayout.NORTH);
        jf.getContentPane().add(jPanel);



        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
