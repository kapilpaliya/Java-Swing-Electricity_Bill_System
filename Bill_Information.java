// Package And Class Import Statement.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Bill_Information extends JFrame implements ActionListener{
        // Variable Declaration.
        ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
                PRINT = new ImageIcon(ClassLoader.getSystemResource("icon/b_Print.png")),
                BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png"));
        Image CANCEL1 = PRINT.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT),
                B_BACK = BACK.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        JTable table; JScrollPane sp;
        JButton Print, Back; JPanel p = new JPanel(); Font font = new Font("Arial",Font.BOLD,14);
        Bill_Information(String ID){
            // Create A Frame.
            setBounds(300,100,800,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(LOGO.getImage());
            setTitle("Bill Information");
            setResizable(false);
            setLayout(null);
            getContentPane().setBackground(Color.white);
            revalidate();


            // Add Container To Store Components.
            p.setBounds(0,0,800,500);
            p.setBackground(Color.white);
            p.setBorder(null);
            p.setLayout(null);
            this.add(p);


            // Create Table To Display Data.
            table = new JTable();
            table.setBackground(Color.white);
            table.setFont(font);
            try{
                ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select * from bill where meter='"+ID+"'").executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
            sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp.setBounds(1, 10, 785, 300);
            sp.setFont(font);
            sp.setBackground(Color.white);
            p.add(sp);


            // Add Printer Button.
            Print = new JButton("Print");
            Print.setBounds(225,350,150,40);
            Print.addActionListener(this);
            Print.setIcon(new ImageIcon(CANCEL1));
            Print.setForeground(Color.black);
            Print.setBackground(null);
            Print.setBorder(null);
            Print.setFont(font);
            p.add(Print);

            // Add Back Button.
            Back = new JButton("Back",new ImageIcon(B_BACK));
            Back.setBounds(425,350,150,50);
            Back.setBackground(Color.white);
            Back.setForeground(Color.red);
            Back.addActionListener(this);
            Back.setBorder(null);
            Back.setFont(font);
            p.add(Back);


            setVisible(true);
        }


        // Override The ActionListener Method.
        @Override
        public void actionPerformed(ActionEvent z){

            // Print Button Declaration.
            if(z.getSource()==Print){
                try{
                    table.print();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }


            // Back Button Declaration
            if(z.getSource()==Back){
                dispose();
            }

        }
}
