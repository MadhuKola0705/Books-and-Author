import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.*;
public class MainFrame {
    public static void main(String[] args) {
            JFrame j1=new JFrame("Books");
            j1.setSize(500,300);
            Font font=new Font("MV Boli",Font.BOLD,20);
                            //insert
            JButton button=new JButton("Insert Book");
            button.setBounds(180, 50, 100, 50);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent p)
                {
                    new TaskInsert();
                }
            });
                        // Author
            JButton button1=new JButton("By Author");
            button1.setBounds(50, 150, 150, 50);
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent p)
                {
                    new TaskBook();
                }
            });

                        //Genre
            JButton button2=new JButton("By Genre");
            button2.setBounds(240, 150, 150, 50);
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent p)
                {
                    new TaskGenre();
                }
            });
            j1.add(button);
            j1.add(button1);
            j1.add(button2);
            j1.setResizable(false);
            j1.setLayout(null);
            j1.setVisible(true);
            j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}