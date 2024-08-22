<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");
        f.setSize(400, 400);
        JTextField t = new JTextField(16);
        JPanel p = new JPanel(new GridLayout(4, 4, 4, 2));
        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton("+");
        JButton b11 = new JButton("-");
        JButton b12 = new JButton("/");
        JButton b13 = new JButton("*");
        JButton b14 = new JButton("=");
        JButton b15 = new JButton("AC");
        t.setEditable(false);
        f.add(t, BorderLayout.NORTH);
        p.add(b0);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        p.add(b13);
        p.add(b14);
        p.add(b15);
        f.add(p, BorderLayout.CENTER);
        ActionListener numberListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                t.setText(t.getText() + source.getText());
            }
        };
        ActionListener operatorListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String text = t.getText();
                if (text.length() > 0 && !text.endsWith(" ")) {
                    t.setText(text + " " + source.getText() + " ");
                }
            }
        };
        
        ActionListener acListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        };
        
        ActionListener equalsListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] tokens = t.getText().split(" ");
                    if (tokens.length == 3) {
                        int num1 = Integer.parseInt(tokens[0]);
                        int num2 = Integer.parseInt(tokens[2]);
                        String op = tokens[1];
                        int result = 0;
                        switch (op) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                result = num1 / num2;
                                break;
                        }
                        t.setText(Integer.toString(result));
                    }
                } catch (Exception ex) {
                    t.setText("Error");
                }
            }
        };
        System.out.println("hello world");
        b0.addActionListener(numberListener);
        b1.addActionListener(numberListener);
        b2.addActionListener(numberListener);
        b3.addActionListener(numberListener);
        b4.addActionListener(numberListener);
        b5.addActionListener(numberListener);
        b6.addActionListener(numberListener);
        b7.addActionListener(numberListener);
        b8.addActionListener(numberListener);
        b9.addActionListener(numberListener);
        b10.addActionListener(operatorListener);
        b11.addActionListener(operatorListener);
        b12.addActionListener(operatorListener);
        b13.addActionListener(operatorListener);
        b14.addActionListener(equalsListener);
        b15.addActionListener(acListener);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
=======
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {
        JFrame f = new JFrame("Calculator");
        f.setSize(400, 400);
        JTextField t = new JTextField(16);
        JPanel p = new JPanel(new GridLayout(4, 4, 4, 2));
        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton("+");
        JButton b11 = new JButton("-");
        JButton b12 = new JButton("/");
        JButton b13 = new JButton("*");
        JButton b14 = new JButton("=");
        JButton b15 = new JButton("AC");
        t.setEditable(false);
        f.add(t, BorderLayout.NORTH);
        p.add(b0);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        p.add(b13);
        p.add(b14);
        p.add(b15);
        f.add(p, BorderLayout.CENTER);
        ActionListener numberListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                t.setText(t.getText() + source.getText());
            }
        };
        ActionListener operatorListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String text = t.getText();
                if (text.length() > 0 && !text.endsWith(" ")) {
                    t.setText(text + " " + source.getText() + " ");
                }
            }
        };
        
        ActionListener acListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        };
        
        ActionListener equalsListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String[] tokens = t.getText().split(" ");
                    if (tokens.length == 3) {
                        int num1 = Integer.parseInt(tokens[0]);
                        int num2 = Integer.parseInt(tokens[2]);
                        String op = tokens[1];
                        int result = 0;
                        switch (op) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                result = num1 / num2;
                                break;
                        }
                        t.setText(Integer.toString(result));
                    }
                } catch (Exception ex) {
                    t.setText("Error");
                }
            }
        };
        System.out.println("hello world");
        b0.addActionListener(numberListener);
        b1.addActionListener(numberListener);
        b2.addActionListener(numberListener);
        b3.addActionListener(numberListener);
        b4.addActionListener(numberListener);
        b5.addActionListener(numberListener);
        b6.addActionListener(numberListener);
        b7.addActionListener(numberListener);
        b8.addActionListener(numberListener);
        b9.addActionListener(numberListener);
        b10.addActionListener(operatorListener);
        b11.addActionListener(operatorListener);
        b12.addActionListener(operatorListener);
        b13.addActionListener(operatorListener);
        b14.addActionListener(equalsListener);
        b15.addActionListener(acListener);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
>>>>>>> 0f52bc97e85e923a2164c24bb1867f19cb28df76
