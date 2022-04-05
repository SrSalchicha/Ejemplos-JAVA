package SegundoCuatrimestre.visible;
import SegundoCuatrimestre.ArrayExpresion.Operaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculadorBasica extends JFrame implements ActionListener{
    private JButton button[] = new JButton[18];
    private JTextField display = new JTextField();
    private JPanel higher = new JPanel();
    private JPanel middle = new JPanel();
    private JPanel lower = new JPanel();
    private String s = "";

    public CalculadorBasica(){
        //Initialization of objects
        for (int i = 1; i < 10; i++){
                button[i] = new JButton("" + i);
        }
        button[0] = new JButton("Del");
        button[10] = new JButton("0");
        button[11] = new JButton("+");
        button[12] = new JButton("-");
        button[13] = new JButton("/");
        button[14] = new JButton("*");
        button[15] = new JButton(".");
        button[16] = new JButton("=");
        button[17] = new JButton("New");
        //add components
        setLayout(new BorderLayout());
        higher.setLayout(new BorderLayout());
        higher.add("Center", display);
        display.setEditable(false);
        middle.setLayout(new GridLayout(4,4));

        for (int i = 0; i < 17; i++){
            middle.add(button[i]);
        }
        lower.setLayout(new BorderLayout());
        lower.add("Center", button[17]);
        add("North", higher);
        add("Center", middle);
        add("South", lower);

        for (int i = 0; i < 18; i++){
            button[i].addActionListener(this);
            button[i].setBackground(Color.darkGray);
            button[i].setForeground(Color.white);
        }

        setBounds(50,50,400,400);
        setVisible(true);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        display.setBackground(Color.gray);
        display.setSize(70,70);
        display.setForeground(Color.white);
    }

    public void actionPerformed(ActionEvent e){
        for (int i = 1; i < 16; i++){
            if (e.getSource() == button[i]){
                s += button[i].getText();
                display.setText(s);
            }
        }
        if (e.getSource() == button[17]){
            s = "";
            display.setText(s);
        }
        if (e.getSource() == button[0]){
            s = s.replaceFirst(".$", "");
            display.setText(s);
        }
        if (e.getSource() == button[16]){
            //aqui va la magia
            Operaciones oper = new Operaciones();
            display.setText(oper.Op(s));
        }

    }


}
