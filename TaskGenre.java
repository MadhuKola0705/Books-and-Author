import java.sql.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.*;
public class TaskGenre{
	// public static void main(String[] args)
     {
		try {
			String url = "jdbc:mysql://localhost:3306/newdatabase";
			String user = "root"; 
			String pass = "Madhukola@123"; 
			Connection con = DriverManager.getConnection(url, user, pass);
			if (con != null) System.out.println("Successfully Connected");
                            //frame
            JFrame j1=new JFrame("Genre book details");
            j1.setSize(900,700);
                        //label
            JLabel l = new JLabel();
            l.setText("SELECT AN GENRE");
            l.setBounds(300, 20, 400, 50);
            l.setFont(new Font("Cascadia Code",Font.BOLD,30));
            JComboBox c1=new JComboBox();
                        //query
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select distinct genre from book");
             while (rs.next()) {
             c1.addItem(rs.getString(1));                
             }
                        //Scrollbar
             JScrollPane pane=new JScrollPane();
            pane.setBounds(50,200,800,400);  
                            //Textarea          
             JTextArea area=new JTextArea();
            area.setBounds(50,200,1000,500);                    
            area.setFont(new Font("Cascadia Code",Font.BOLD,20));
            j1.add(pane);
            pane.setViewportView(area);
             c1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent p)
                {
                    String str1=(String)c1.getSelectedItem();
                    String query = "select id,title,author,cost,quantity from book where genre='"+str1+"';";
                    try{                       
                        ResultSet rs1=(st.executeQuery(query));
                       if(area.getText()!=null)
                            {
                                area.setText("");
                            }
                            area.append("ID\tTITLE\t\tAUTHOR\tCOST\tQUANTITY\n\n");
                        while(rs1.next()){
                            area.append((rs1.getString(1)+"\t"+rs1.getString(2)+"\t\t"+rs1.getString(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5)).trim());
                            area.append("\n");                            
                        }
                    } catch(Exception e){
                        System.out.println("error "+e);
                    }
                     
                }
            });                
            c1.setFont(new Font("MV Boli",Font.BOLD,20));
            c1.setBounds(300, 100, 300, 50);
            j1.add(c1);
            j1.add(l);
            j1.setResizable(false);
            j1.setLayout(null);            
            j1.setVisible(true);
            j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}