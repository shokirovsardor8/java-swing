import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JFrame frame;
    JTextField textField;
    JTextField bufferField;
    JPanel panel;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;

    Font myFont = new Font("Comic Sans", Font.BOLD, 30);
    double num1 = 0, num2 = 0;
    char operator = ' ';

    public static void main(String[] args) {
        new Calculator();
    }

    Calculator() {
        frame = new JFrame("Sardor's Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setSize(360, 570);
        frame.setLayout(null);
        frame.setResizable(false);

        textField = new JTextField();
        textField.setBounds(20, 50, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(new Color(128, 128, 128));
        textField.setBorder(null);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        bufferField = new JTextField();
        bufferField.setBounds(20, 25, 300, 25);
        bufferField.setFont(new Font("Comic Sans", Font.BOLD, 16));
        bufferField.setEditable(false);
        bufferField.setBackground(new Color(128, 128, 128));
        bufferField.setBorder(null);
        bufferField.setHorizontalAlignment(SwingConstants.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");
        negButton = new JButton("+/-");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBorder(null);
            functionButtons[i].setBackground(new Color(233, 127, 13));
            functionButtons[i].setForeground(Color.white);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 0));
            numberButtons[i].setBackground(new Color(56, 56, 56));
            numberButtons[i].setForeground(Color.white);
        }

        delButton.setBounds(20, 455, 90, 50);
        clrButton.setBounds(230, 455, 90, 50);
        negButton.setBounds(125, 455, 90, 50);

        panel = new JPanel();
        panel.setBounds(20, 125, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(0, 0, 0));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(bufferField);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
            decButton.setEnabled(textField.getText().indexOf('.') < 0);
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            setNum2();
            operator = '+';
            bufferField.setText(bufferField.getText() + "+");
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            setNum2();
            operator = '-';
            bufferField.setText(bufferField.getText() + "-");
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            setNum2();
            operator = '*';
            bufferField.setText(bufferField.getText() + "*");
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            setNum2();
            operator = '/';
            bufferField.setText(bufferField.getText() + "/");
            textField.setText("");

        }
        if (e.getSource() == equButton) {
            num1 = Double.parseDouble(textField.getText());
            setNum2();
            bufferField.setText(bufferField.getText() + "=");
            int numInt = (int) num2;
            if (num2 - numInt == 0) {
                textField.setText(String.valueOf(numInt));
            } else {
                textField.setText(String.valueOf(num2));
            }
            num1 = 0;
            operator = ' ';
        }

        if (e.getSource() == clrButton) {
            num2 = 0;
            num1 = 0;
            operator = ' ';
            bufferField.setText("");
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String text = textField.getText();
            textField.setText(text.substring(0, text.length() - 1));
        }
        if (e.getSource() == negButton) {
            int numInt = (int) Double.parseDouble(textField.getText());
            if (Double.parseDouble(textField.getText()) - numInt == 0) {
                textField.setText(String.valueOf((-1) * numInt));
            } else {
                textField.setText(String.valueOf((-1) * Double.parseDouble(textField.getText())));
            }
        }
    }

    void setNum2() {
        switch (operator) {
            case '+':
                num2 += num1;
                break;
            case '-':
                num2 -= num1;
                break;
            case '*':
                num2 *= num1;
                break;
            case '/':
                num2 /= num1;
                break;
            case ' ':
                num2 = num1;
                break;
        }

        if (operator != ' ') {
            bufferField.setText(bufferField.getText().concat(textField.getText()));
        } else {
            bufferField.setText(textField.getText());
        }

    }
}
