package Assignment_Calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SimpleCalculator extends JFrame implements ActionListener
{
    JLabel label = new JLabel();
    JTextField textfield = new JTextField();
    JButton buttonZero = new JButton("0");
    JButton []btn = new JButton[14];
    char[]op = {'/','-','*','+'};
    JButton buttonMinus = new JButton("+/-");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonDelete = new JButton("DEL");
    JButton buttonEqual = new JButton("=");
    JButton buttonSquare = new JButton("X\u00B2");
    JButton buttonReciprocal = new JButton("1/x");
    JButton buttonSqrt = new JButton("\u221A");

    double number , answer ;
    int calculation =0;
    int calCopy = 0;
    SimpleCalculator()
    {
        setTitle("Calculator");
        setLayout(null);
        setSize(300,490);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.white);
        add(label);

        textfield.setBounds(10,40,270,40);
        textfield.setFont(new Font ("Arial", Font.BOLD,20));
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(SwingConstants.RIGHT);
        add(textfield);
        int x = 10;
        int y = 230;
        for(int i=1;i<10;i++)
        {
            btn[i] = new JButton(i+"");
            btn[i].setBounds(x,y,60,40);
            btn[i].setFont(new Font ("Arial", Font.BOLD,20));
            add(btn[i]);
            if(i%3 == 0){
                x= 10;
                y += 60;
            }
            else
                x += 70;
        }

        buttonDot.setBounds(150,410,60,40);
        buttonDot.setFont(new Font ("Arial", Font.BOLD,20));
        add(buttonDot);

        buttonZero.setBounds(80,410,60,40);
        buttonZero.setFont(new Font ("Arial", Font.BOLD,20));
        add(buttonZero);

        buttonMinus.setBounds(10,410,60,40);
        buttonMinus.setFont(new Font ("Arial", Font.BOLD,20));
        add(buttonMinus);

        buttonEqual.setBounds(220,350,60,100);
        buttonEqual.setFont(new Font ("Arial", Font.BOLD,20));
        buttonEqual.setBackground(new Color(239,188,2));
        add(buttonEqual);

        buttonSqrt.setBounds(10,170,60,40);
        buttonSqrt.setFont(new Font ("Arial", Font.BOLD,20));
        add(buttonSqrt);

        // code for +,-,*,/
        int a = 220;
        int b = 110;
        for(int i=10;i<14;i++)
        {
            btn[i] = new JButton(op[i-10]+"");
            btn[i].setBounds(a,b,60,40);
            btn[i].setFont(new Font ("Arial", Font.BOLD,20));
            btn[i].setBackground(new Color(239,188,2));
            add(btn[i]);
            b += 60;
        }

        buttonSquare.setBounds(80,170,60,40);
        buttonSquare.setFont(new Font ("Arial", Font.BOLD,20));
        add(buttonSquare);

        buttonReciprocal.setBounds(150,170,60,40);
        buttonReciprocal.setFont(new Font ("Arial", Font.BOLD,13));
        add(buttonReciprocal);

        buttonDelete.setBounds(150,110,60,40);
        buttonDelete.setFont(new Font ("Arial", Font.BOLD,13));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        add(buttonDelete);

        buttonClear.setBounds(80,110,60,40);
        buttonClear.setFont(new Font ("Arial", Font.BOLD,20));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        add(buttonClear);

        buttonZero.addActionListener(this);
        buttonMinus.addActionListener(this);
        for(int i=1;i<14;i++)
            btn[i].addActionListener(this);

        buttonDot.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonSqrt.addActionListener(this);

        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Object source = ae.getSource();

        if (source == buttonClear)
        {
            label.setText("");
            textfield.setText("");
            calCopy = 0;
        }
        else if(source == buttonMinus)
        {
            if(textfield.getText().contains("-"))
            { return;}
            else if(textfield.getText().equals("0"))
            {   return;}
            else
            {textfield.setText("-"+textfield.getText());}
        }
        else if (source == buttonDelete)
        {
            int length = textfield.getText().length();
            int number = length - 1 ;
            if(length>0)
            {
                StringBuilder back = new StringBuilder(textfield.getText());
                back.deleteCharAt(number);
                textfield.setText(back.toString());
            }
            if(textfield.getText().endsWith(""))
            {
                label.setText("");
            }
        }
        else if(source == buttonZero)
        {
            if(textfield.getText().equals("0"))
            {   return;}
            else if(textfield.getText().equals("-"))
            { return;}
            else
            { textfield.setText(textfield.getText() + "0");   }

        }
        else if(source == buttonDot)
        {
            if(textfield.getText().contains("."))
            { return;}
            else
            {textfield.setText(textfield.getText() + ".");}
        }
        else if(source == btn[13])
        {
            if(checkEntry()) {
                String str = textfield.getText();
                number =Double.parseDouble(textfield.getText());
                label.setText(str + "+");
                calCopy = calculation = 1 ;
            }
            textfield.setText("");
        }
        else if(source == btn[11])
        {
            if(checkEntry()) {
                String str = textfield.getText();
                number = Double.parseDouble(textfield.getText());
                label.setText(str + "-");
                calCopy = calculation = 2 ;
            }
            textfield.setText("");
        }
        else if(source == btn[12])
        {
            if(checkEntry()) {
                String str = textfield.getText();
                number = Double.parseDouble(textfield.getText());
                label.setText(str + "X");
                calCopy = calculation = 3 ;
            }
            textfield.setText("");
        }
        else if(source == btn[10])
        {
            if(checkEntry()) {
                String str = textfield.getText();
                number = Double.parseDouble(str);
                label.setText(str + "/");
                calCopy = calculation = 4 ;
            }
            textfield.setText("");
        }
        else if(source == buttonSqrt)
        {
            if(checkEntry()) {
                number = Double.parseDouble(textfield.getText());
                Double sqrt = Math.sqrt(number);
                textfield.setText(Double.toString(sqrt));
            }
            else
            {
                textfield.setText("");
            }
        }
        else if(source == buttonSquare)
        {
            if(checkEntry()) {
                String str = textfield.getText();
                number = Double.parseDouble(textfield.getText());
                double square = Math.pow(number, 2);
                String string = Double.toString(square);
                if (string.endsWith(".0")) {
                    textfield.setText(string.replace(".0", ""));
                } else {
                    textfield.setText(string);
                }
                label.setText("(Sqr)" + str);
            }
            else{ textfield.setText(""); }
        }
        else if(source == buttonReciprocal)
        {
            if(checkEntry()) {
                number = Double.parseDouble(textfield.getText());
                double reciprocal = 1 / number;
                String string = Double.toString(reciprocal);
                if (string.endsWith(".0")) {
                    textfield.setText(string.replace(".0", ""));
                } else {
                    textfield.setText(string);
                }
            }
            else{ textfield.setText(""); }
        }
        else if(source == buttonEqual)
        {
            if(calculation == 0 || textfield.getText().equals("") || textfield.getText().equals("-"))
            {
                textfield.setText("");
            }
            else
            {
                if(calculation == 1)
                    answer = number + Double.parseDouble(textfield.getText());
                else if(calculation == 2)
                    answer = number - Double.parseDouble(textfield.getText());
                else if(calculation == 3)
                    answer = number * Double.parseDouble(textfield.getText());
                else if(calculation == 4)
                    answer = number / Double.parseDouble(textfield.getText());
                if (Double.toString(answer).endsWith(".0"))
                {
                    textfield.setText(Double.toString(answer).replace(".0",""));
                }
                else
                {
                    textfield.setText(Double.toString(answer));
                }
            }
            label.setText("");
        }
        else
            for(int i=1;i<10;i++)
            {
                if(source == btn[i])
                    textfield.setText(textfield.getText() + i);
            }
    }
    public boolean checkEntry()
    {
        if(textfield.getText().equals("")) return false;
        else {
            boolean flag = false;
            String st = textfield.getText();
            for(int i=0;i<st.length();i++)
            {
                if(st.charAt(i) == '.' || st.charAt(i) == '0' || st.charAt(i) == '-')
                    flag = false;
                else
                    flag = true;
            }
            if (flag) return true;
            else return false;
        }
    }
    public static void main (String[] args)
    {
        SimpleCalculator t = new SimpleCalculator();
    }
}