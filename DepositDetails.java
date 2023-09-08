
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

public class DepositDetails extends JFrame implements ActionListener{
        // Variable Declaration.
        ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
                SEARCH = new ImageIcon(ClassLoader.getSystemResource("icon/b_Search.png")),
                PRINT = new ImageIcon(ClassLoader.getSystemResource("icon/b_Print.png")),
                BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png"));
        Image   NEXT1 = SEARCH.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
                CANCEL1 = PRINT.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT),
                B_BACK = BACK.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
        JLabel heading, meterNumber, name, Name, month;
        JComboBox MeterNumber, Month; JTable table; JScrollPane sp;
        String[] MONTHS =  {"January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"};
        JButton Search, Print, Back; JPanel p = new JPanel(); Font font = new Font("Arial",Font.BOLD,20);
        DepositDetails(){

            // Create A Frame.
            setBounds(300,100,800,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(LOGO.getImage());
            setTitle("Deposit Bill Details");
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
            heading = new JLabel("Deposit Bill Details");
            heading.setBounds(300,5,200,20);
            heading.setFont(font);
            p.add(heading);


            // Create Meter Number Input And Label Field.
            meterNumber = new JLabel("Meter No. :");
            meterNumber.setBounds(20,50,110,40);
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
            MeterNumber.setBounds(140,50,135,35);
            MeterNumber.setBorder(null);
            MeterNumber.setBackground(Color.white);
            MeterNumber.setForeground(Color.blue);
            MeterNumber.setFont(font);
            p.add(MeterNumber);


            // Create Name Input And Label Field.
            name = new JLabel("Name :");
            name.setBounds(350,60,80,20);
            name.setFont(font);
            p.add(name);

            Name = new JLabel();
            MeterNumber.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try{
                        ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select uname from customer where umeter='"+MeterNumber.getSelectedItem()+"'").executeQuery();
                        while(rs.next()){
                            Name.setText(rs.getString("uname"));
                        }
                    }
                    catch(Exception z){
                        z.printStackTrace();
                    }
                }
            });
            try{
                ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select uname from customer where umeter='"+MeterNumber.getSelectedItem()+"'").executeQuery();
                while(rs.next()){
                    Name.setText(rs.getString("uname"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            Name.setBounds(450,60,350,20);
            Name.setForeground(Color.blue);
            Name.setFont(font);
            p.add(Name);


            // Create Month Input And Label Field.
            month = new JLabel("Months :");
            month.setBounds(20,110,100,40);
            month.setFont(font);
            p.add(month);

            Month = new JComboBox(MONTHS);
            Month.setBounds(140,110,135,35);
            Month.setBackground(Color.white);
            Month.setForeground(Color.blue);
            Month.setFont(font);
            p.add(Month);


            // Add Search And Print Button Used To Fiend And Store User Information.
            Search = new JButton("Search");
            Search.setBounds(300,100,150,50);
            Search.setIcon(new ImageIcon(NEXT1));
            Search.setForeground(Color.black);
            Search.addActionListener(this);
            Search.setBorder(null);
            Search.setBackground(null);
            Search.setFont(font);
            p.add(Search);

            Print = new JButton("Print");
            Print.setBounds(470,105,150,40);
            Print.addActionListener(this);
            Print.setIcon(new ImageIcon(CANCEL1));
            Print.setForeground(Color.black);
            Print.setBackground(null);
            Print.setBorder(null);
            Print.setFont(font);
            p.add(Print);


            // Create A Table To Store Used Data.
            table = new JTable();
            try{
                ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select * from bill").executeQuery();
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
            Back.setBounds(620,100,150,50);
            Back.setBackground(Color.white);
            Back.setForeground(Color.blue);
            Back.addActionListener(this);
            Back.setBorder(null);
            Back.setFont(font);
            p.add(Back);


            setVisible(true);
        }

        // Override The ActionListener Method
        @Override
        public void actionPerformed(ActionEvent z){

            // Describe The Search Button.
            if(z.getSource()==Search){
                try{
                    ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select * from bill where meter = '"+MeterNumber.getSelectedItem()+"' and month = '"+Month.getSelectedItem()+"'").executeQuery();
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }


            // Describe The Print Button.
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
