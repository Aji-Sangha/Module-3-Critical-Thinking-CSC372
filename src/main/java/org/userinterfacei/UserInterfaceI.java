package org.userinterfacei;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class UserInterfaceI extends JFrame {
    private JTextArea textBox;
    private Color backgroundColor;
    private JMenu menu;
    private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4;

    public UserInterfaceI() {
        setTitle("User Interface I");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textBox = new JTextArea();
        backgroundColor = getRandomColor();
        textBox.setBackground(backgroundColor);

        JMenuBar menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuItem1 = new JMenuItem("Print Date and Time");
        menuItem2 = new JMenuItem("Write to File");
        menuItem3 = new JMenuItem("Change Background Color");
        menuItem4 = new JMenuItem("Exit");

        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });

        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToFile();
            }
        });

        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        menuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuItem4);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        add(textBox);
    }
    private void printDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(new Date());
        textBox.append(dateTime + "\n");
    }

    private void writeToFile() {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write(textBox.getText());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void changeBackgroundColor() {
        backgroundColor = getRandomColor();
        textBox.setBackground(backgroundColor);
    }

    private Color getRandomColor() {
        Random rand = new Random();
        float hue = rand.nextFloat();
        return Color.getHSBColor(hue, 0.5f, 0.9f);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInterfaceI().setVisible(true);
            }
        });
    }
}
