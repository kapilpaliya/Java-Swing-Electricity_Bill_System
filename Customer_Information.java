

// Package And Class Import Statement.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Customer_Information extends JFrame implements ActionListener{

    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            SEARCH = new ImageIcon(ClassLoader.getSystemResource("icon/b_Search.png")),
            PRINT = new ImageIcon(ClassLoader.getSystemResource("icon/b_Print.png")),
            BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png"));
    Image NEXT1 = SEARCH.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
            CANCEL1 = PRINT.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT),
            B_BACK = BACK.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
    JLabel heading, meterNumber, name, Name;
    JComboBox MeterNumber; JTable table; JScrollPane sp;
    JButton Search, Print, Back; JPanel p = new JPanel(); Font font = new Font("Arial",Font.BOLD,20);
    Customer_Information(){
        // Create A Frame.
        setBounds(300,100,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("Customer Information");
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


        // Add Heading.
        heading = new JLabel("All Customer Information");
        heading.setBounds(275,5,250,20);
        heading.setFont(font);
        p.add(heading);


        // Create Meter Number Input And Label Field.
        meterNumber = new JLabel("Meter No. :");
        meterNumber.setBounds(120,50,110,40);
        meterNumber.setFont(font);
        p.add(meterNumber);

        MeterNumber = new JComboBox();
        try{
           ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select umeter from customer").executeQuery();
           while(rs.next()){
                MeterNumber.addItem(rs.getString("umeter"));
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        MeterNumber.setBounds(240,50,120,35);
        MeterNumber.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    String n = (String)MeterNumber.getSelectedItem();
                    ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select uname from customer where umeter='"+n+"'").executeQuery();
                    if(rs.next()){
                        Name.setText(rs.getString("uname"));
                    }
                }
                catch(Exception x){

                }
            }
        });
        MeterNumber.setBorder(null);
        MeterNumber.setBackground(Color.white);
        MeterNumber.setForeground(Color.blue);
        MeterNumber.setFont(font);
        p.add(MeterNumber);


        // Create Name Input And Label Field.
        name = new JLabel("Username :");
        name.setBounds(400,60,110,20);
        name.setFont(font);
        p.add(name);

        Name = new JLabel();
        try{
          ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select uname from customer where umeter='"+MeterNumber.getSelectedItem()+"'").executeQuery();
          while(rs.next()){
             Name.setText(rs.getString("uname"));
          }
        }
        catch(Exception e){
          e.printStackTrace();
        }
        Name.setBounds(550,60,300,20);
        Name.setForeground(Color.blue);
        Name.setFont(font);
        p.add(Name);


        // Create Search And Print Button Used To Show And Store Data In Table Formate.
        Search = new JButton("Search");
        Search.setBounds(130,100,150,50);
        Search.setIcon(new ImageIcon(NEXT1));
        Search.setForeground(Color.black);
        Search.addActionListener(this);
        Search.setBorder(null);
        Search.setBackground(null);
        Search.setFont(font);
        p.add(Search);

        Print = new JButton("Print");
        Print.setBounds(310,100,150,40);
        Print.addActionListener(this);
        Print.setIcon(new ImageIcon(CANCEL1));
        Print.setForeground(Color.black);
        Print.setBackground(null);
        Print.setBorder(null);
        Print.setFont(font);
        p.add(Print);


        // Create Table To Display Data.
       table = new JTable();
       try{
            ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select * from customer").executeQuery();
               table.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch(Exception e){
             e.printStackTrace();
       }
       sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       sp.setBounds(1, 160, 785, 300);
       p.add(sp);


        // Add Back Button.
        Back = new JButton("Back",new ImageIcon(B_BACK));
        Back.setBounds(490,100,150,50);
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
        // Search Button Declaration.
        if(z.getSource()==Search){
                try{
                    ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select * from customer where umeter = '"+MeterNumber.getSelectedItem()+"'").executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }


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