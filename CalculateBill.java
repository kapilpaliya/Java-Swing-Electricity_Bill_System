
// Package And Class Import Statement.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CalculateBill  extends JFrame implements ActionListener {
        // Variable Declaration.
        ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
                CALCULATEBILL = new ImageIcon(ClassLoader.getSystemResource("icon/b_CalculateBill.png")),
                NEXT = new ImageIcon(ClassLoader.getSystemResource("icon/b_Submit.png")),
                b_BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png"));
        Image CALCULATEBILL1 = CALCULATEBILL.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT),
                NEXT1 = NEXT.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
                B_BACK = b_BACK.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        JLabel heading, meterNumber, name, Name, address, Address, unit, month, CALCULATEIMAGE;
        JComboBox MeterNumber, Month; JTextField Unit;
        String[] MONTHS =  {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        JButton Submit, Back; JPanel p = new JPanel(); Font font = new Font("Arial",Font.BOLD,20);
        CalculateBill(){
            // Create A Frame.
            setBounds(300,100,800,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(LOGO.getImage());
            setTitle("Calculate Bill");
            setResizable(false);
            setLayout(null);
            getContentPane().setBackground(Color.white);
            revalidate();


            // Set A CalculateBill Them Logo Image.
            CALCULATEIMAGE = new JLabel(new ImageIcon(CALCULATEBILL1));
            CALCULATEIMAGE.setBounds(0,100,200,200);
            this.add(CALCULATEIMAGE);


            // Add Container To Store Components.
            p.setBounds(200,0,600,500);
            p.setBackground(Color.white);
            p.setBorder(null);
            p.setLayout(null);
            this.add(p);


            // Add Heading.
            heading = new JLabel("Calculate Electricity Bill");
            heading.setBounds(200,5,300,20);
            heading.setFont(font);
            p.add(heading);


            // Create Meter Number Input And Label Field.
            meterNumber = new JLabel("Meter No. :");
            meterNumber.setBounds(30,70,200,40);
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
            MeterNumber.setBounds(230,70,300,35);
            MeterNumber.setBorder(null);
            MeterNumber.setBackground(Color.white);
            MeterNumber.setFont(font);
            p.add(MeterNumber);


            // Create Name Input And Label Field.
            name = new JLabel("Name :");
            name.setBounds(30,140,200,20);
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
            catch(Exception z){
                z.printStackTrace();
            }
            Name.setBounds(230,140,400,20);
            Name.setForeground(Color.blue);
            Name.setFont(font);
            p.add(Name);


            // Create Address Input And Label Field.
            address = new JLabel("Address :");
            address.setBounds(30,190,200,20);
            address.setFont(font);
            p.add(address);

            Address = new JLabel();
            MeterNumber.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try{
                        ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select uaddress from customer where umeter='"+MeterNumber.getSelectedItem()+"'").executeQuery();
                        while(rs.next()){
                            Address.setText(rs.getString("uaddress"));
                        }
                    }
                    catch(Exception z){
                        z.printStackTrace();
                    }
                }
            });
            try{
                ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select uaddress from customer where umeter='"+MeterNumber.getSelectedItem()+"'").executeQuery();
                while(rs.next()){
                    Address.setText(rs.getString("uaddress"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            Address.setBounds(230,190,400,20);
            Address.setForeground(Color.blue);
            Address.setFont(font);
            p.add(Address);


            // Create Meter Consume Unit Input And Label Field.
            unit = new JLabel("Unit Consumed :");
            unit.setBounds(30,240,200,35);
            unit.setFont(font);
            p.add(unit);

            Unit = new JTextField();
            Unit.setBounds(230,240,300,35);
            Unit.setBorder(BorderFactory.createLineBorder(Color.red));
            Unit.setBackground(Color.white);
            Unit.setFont(font);
            p.add(Unit);


            // Create Month Input And Label Field.
            month = new JLabel("Months :");
            month.setBounds(30,310,200,35);
            month.setFont(font);
            p.add(month);

            Month = new JComboBox(MONTHS);
            Month.setBounds(230,310,300,35);
            Month.setBackground(Color.white);
            Month.setFont(font);
            p.add(Month);


            // Create Submit And Exit Button To Store Data in DB And Close The Process.
            Submit = new JButton("Submit");
            Submit.setBounds(50,380,150,50);
            Submit.setIcon(new ImageIcon(NEXT1));
            Submit.setForeground(Color.blue);
            Submit.addActionListener(this);
            Submit.setBorder(null);
            Submit.setBackground(null);
            Submit.setFont(font);
            p.add(Submit);


            // Add Back Button.
            Back = new JButton("Back",new ImageIcon(B_BACK));
            Back.setBounds(350,382,150,50);
            Back.setBackground(Color.white);
            Back.setForeground(Color.blue);
            Back.addActionListener(this);
            Back.setBorder(null);
            Back.setFont(font);
            p.add(Back);


            setVisible(true);
        }


        // Override The ActionListener Method.
        @Override
        public void actionPerformed(ActionEvent e){

        // Declaration Of Submit Button.
        if(e.getSource()==Submit){
            long Cost_Unit = Integer.parseInt(Unit.getText());
            long total_Bill = 0;
            String Query = "select * from tax";
            String Meter_Number = (String)MeterNumber.getSelectedItem();
            String Unites_Day = Unit.getText();
            String Months = (String)Month.getSelectedItem();
            try{
                ResultSet rs = JDBC.getConnectionJDBC().prepareStatement(Query).executeQuery();
                while(rs.next()){
                    total_Bill += Cost_Unit * Integer.parseInt(rs.getString("cost_per_unit"));
                    total_Bill += Integer.parseInt(rs.getString("meter_rent"));
                    total_Bill += Integer.parseInt(rs.getString("service_charge"));
                    total_Bill += Integer.parseInt(rs.getString("service_tax"));
                    total_Bill += Integer.parseInt(rs.getString("swacche_bharat_cess"));
                    total_Bill += Integer.parseInt(rs.getString("fixed_tax"));
                }
            }
            catch(Exception z){
                z.printStackTrace();
            }

            String Query2 = "insert into bill values('"+Meter_Number+"', '"+Months+"', '"+Unites_Day+"', '"+total_Bill+"', 'Not Pay')";
            try{
                int x = JDBC.getConnectionJDBC().prepareStatement(Query2).executeUpdate();
                if(x>0){
                    JOptionPane.showMessageDialog(this,"Bill Successfully Saved!");
                    Unit.setText(null);
                }
            }
            catch(Exception z){
                z.printStackTrace();
            }
        }


        // Declaration Of Exit Button.
        if(e.getSource()==Back){
            dispose();
        }

   }

}
