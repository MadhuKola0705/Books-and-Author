import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
public class TaskInsert {

    //  public static void main(String[] args) 
    {
        try {
			String url = "jdbc:mysql://localhost:3306/newdatabase";
			String user = "root"; 
			String pass = "Madhukola@123"; 
			Connection con = DriverManager.getConnection(url, user, pass);
			if (con != null) System.out.println("Successfully Connected");
            Statement ste=con.createStatement();
            JFrame j1=new JFrame("Insert Book");
            j1.setSize(500,700);
            Font font=new Font("MV Boli",Font.BOLD,20);

                            //ID
            JLabel l = new JLabel();
            l.setText("ID");
            l.setBounds(50, 50, 100, 40);
            l.setFont(new Font("Cascadia Code",Font.BOLD,30));
            JTextField id=new JTextField();
            id.setBounds(200, 50, 200, 50);
            id.setFont(font);
            // id.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent p)
            //     {
            //         String s=id.getText();
            //         System.out.println("ID"+s);
            //         // id.setText("");
                    
            //     }
            // });

                            //Title
            JLabel l1 = new JLabel();
            l1.setText("Title");
            l1.setBounds(50, 120, 200, 40);
            l1.setFont(new Font("Cascadia Code",Font.BOLD,30));
            JTextField title=new JTextField();
            title.setBounds(200, 120, 200, 50);
            title.setFont(font);
            // title.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent p)
            //     {
            //         String s1=title.getText();
            //         System.out.println("Title"+s1);
            //         // title.setText("");
                    
            //     }
            // });

                        //Author
            JLabel l2 = new JLabel();
            l2.setText("Author");
            l2.setBounds(50, 190, 200, 40);
            l2.setFont(new Font("Cascadia Code",Font.BOLD,30));
            JTextField author=new JTextField();
            author.setBounds(200, 190, 200, 50);
            author.setFont(font);
            // author.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent p)
            //     {
            //         String s2=author.getText();
            //         System.out.println("Author"+s2);
            //         // author.setText("");
            //     }
            // });   
            
                        //Genre
            JLabel l3 = new JLabel();
            l3.setText("Genre");
            l3.setBounds(50, 250, 200, 40);
            l3.setFont(new Font("Cascadia Code",Font.BOLD,30));
            JTextField genre=new JTextField();
            genre.setBounds(200, 250, 200, 50);
            genre.setFont(font);
            // genre.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent p)
            //     {
            //         String s1=genre.getText();
            //         System.out.println("Genre"+s1);
            //         // genre.setText("");
                    
            //     }
            // });

                        //Cost
            JLabel l4 = new JLabel();
            l4.setText("Cost");
            l4.setBounds(50, 320, 200, 40);
            l4.setFont(new Font("Cascadia Code",Font.BOLD,30));
            JTextField cost=new JTextField();
            cost.setBounds(200, 320, 200, 50);
            cost.setFont(font);
            // cost.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent p)
            //     {
            //         String s1=cost.getText();
            //         System.out.println("Cost"+s1);
            //         // cost.setText("");
            //     }
            // });

                        //Quantity
            JLabel l5 = new JLabel();
            l5.setText("Quantity");
            l5.setBounds(50, 380, 200, 40);
            l5.setFont(new Font("Cascadia Code",Font.BOLD,30));
            JTextField quantity=new JTextField();
            quantity.setBounds(200, 380, 200, 50);
            quantity.setFont(font);
            // quantity.addActionListener(new ActionListener() {
            //     public void actionPerformed(ActionEvent p)
            //     {
            //         String s1=quantity.getText();
            //         System.out.println("Quantity"+s1);
            //         // quantity.setText("");
            //     }
            // });

                         //Submit
            
            JButton button=new JButton("Submit");  
            button.setBounds(250, 500, 100, 50);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent p)
                {
                    String s1=id.getText();
                    String s2=title.getText();
                    String s3=author.getText();
                    String s4=genre.getText();
                    String s5=cost.getText();
                    String s6=quantity.getText();
                    // JOptionPane.showMessageDialog(id,"this is error", "error",JOptionPane.ERROR_MESSAGE);
                    //     System.out.println("Successfully");
                    System.out.println("submit  ");
                    if(s1.charAt(0)==' ' || s2.charAt(0)==' ' || s3.charAt(0)==' ' || s4.charAt(0)==' ' || s5.charAt(0)==' ' || s6.charAt(0)==' ')
                    {
                        JOptionPane.showMessageDialog(id,"Please enter valid details", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try{
                            int quantity=Integer.parseInt(s6);
                            int cost=Integer.parseInt(s5);
                            String qu= "insert into book values('"+s1+"','"+s2+"','"+s3+"','"+s4+"',"+cost+","+quantity+")";
                            // System.out.println(qu);
                            ste.executeUpdate(qu);

                        }
                        catch(Exception e)
                        {
                            JOptionPane.showMessageDialog(id,e, "Error",JOptionPane.ERROR_MESSAGE);
                            System.out.println(e);
                        }
                id.setText("");
                title.setText("");
                author.setText("");
                genre.setText("");
                cost.setText("");
                quantity.setText("");
               }
                   
    
                }
            });

                        //Clear button
        JButton clear=new JButton("Clear");  
        clear.setBounds(100, 500, 100, 50);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent p)
            {
                id.setText("");
                title.setText("");
                author.setText("");
                genre.setText("");
                cost.setText("");
                quantity.setText("");
            }  
        });

            j1.setResizable(false);
            j1.setLayout(null);          
            j1.setVisible(true);
            j1.add(l);
            j1.add(id);
            j1.add(l1);
            j1.add(title);
            j1.add(l2);
            j1.add(author);
            j1.add(l3);
            j1.add(genre);
            j1.add(l4);
            j1.add(cost);
            j1.add(l5);
            j1.add(quantity);
            j1.add(button);
            j1.add(clear);
            j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
			System.out.println(e);
		}

    }
    
}