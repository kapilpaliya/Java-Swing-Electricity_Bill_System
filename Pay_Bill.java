
// Add Package And Class.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Pay_Bill extends JFrame implements ActionListener{
    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png")),
            PAY = new ImageIcon(ClassLoader.getSystemResource("icon/Pay.png")),
            BACKGROUND = new ImageIcon(ClassLoader.getSystemResource("icon/Background.jpg"));
    Image B_BACKGROUND = BACKGROUND.getImage().getScaledInstance(800,300,Image.SCALE_DEFAULT),
            B_BACK = BACK.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT),
            B_PAY = PAY.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
    Container c; Font font = new Font("Arial",Font.BOLD,20);
    JLabel heading, meter, Meter, name, Name, unit, Unit, bill, Bill, status, Status, month, background;
    JButton Pay, Back; JComboBox Month;
    String[] MONTHS =  {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    String METERID;

    Pay_Bill(String ID){
        METERID = ID;




        // Create A Frame.
        setBounds(300,100,800,530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("Pay Electricity Bill");
        setResizable(false);
        revalidate();


        // Add Container In Frame.
        c = getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);


        // Set Image In Background Logo Type.
        background = new JLabel(new ImageIcon(B_BACKGROUND));
        background.setFont(font);
        background.setBounds(0,235,800,300);
        c.add(background);




        // Add Meter Number Input And Label.
        meter = new JLabel("Meter Number :");
        meter.setFont(font);
        meter.setBounds(30,10,150,40);
        c.add(meter);

        Meter = new JLabel(METERID);
        Meter.setFont(font);
        Meter.setBounds(200,10,150,40);
        Meter.setForeground(Color.green);
        c.add(Meter);




        // Add Name Input And Label.
        name = new JLabel("Username :");
        name.setFont(font);
        name.setBounds(430,10,150,40);
        c.add(name);

        Name = new JLabel();
        Name.setFont(font);
        Name.setBounds(570,10,150,40);
        Name.setForeground(Color.green);
        c.add(Name);




        // Add Month Input And Label.
        month = new JLabel("Months :");
        month.setFont(font);
        month.setBounds(30,70,150,40);
        c.add(month);

        Month = new JComboBox(MONTHS);
        Month.setFont(font);
        Month.setBounds(200,70,150,40);
        Month.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String check = Month.getSelectedItem().toString();
                int x=0;
                try{
                    ResultSet rs1 = JDBC.getConnectionJDBC().prepareStatement("select * from bill where month='"+Month.getSelectedItem()+"' and meter='"+METERID+"'").executeQuery();
                    while(rs1.next()){
                        if(check.equals(rs1.getString("month"))){
                            x = 1;
                            break;
                        }
                    }
                    if(x>0){
                        Unit.setText(rs1.getString("units"));
                        Bill.setText(rs1.getString("totalbill"));
                        Status.setText(rs1.getString("pay"));
                    }
                    else{
                        Unit.setText(null);
                        Bill.setText(null);
                        Status.setText(null);
                    }

                }
                catch(Exception z){
                    z.printStackTrace();
                }
            }
        });
        Month.setBackground(Color.white);
        Month.setForeground(Color.green);
        c.add(Month);




        // Add Unit Consume Input And Label.
        unit = new JLabel("Units :");
        unit.setFont(font);
        unit.setBounds(430,70,150,40);
        c.add(unit);

        Unit = new JLabel();
        Unit.setFont(font);
        Unit.setBounds(570,70,150,40);
        Unit.setForeground(Color.green);
        c.add(Unit);




        // Add Total Bill Input And Label.
        bill = new JLabel("Total Bill :");
        bill.setFont(font);
        bill.setBounds(30,130,150,40);
        c.add(bill);

        Bill = new JLabel();
        Bill.setFont(font);
        Bill.setBounds(200,130,150,40);
        Bill.setForeground(Color.green);
        c.add(Bill);




        // Add Status Pay Or Not_Pay Input And Label.
        status = new JLabel("Status :");
        status.setFont(font);
        status.setBounds(430,130,150,40);
        c.add(status);

        Status = new JLabel();
        Status.setFont(font);
        Status.setForeground(Color.red);
        Status.setBounds(570,130,150,40);
        c.add(Status);




        // Add Pay Button.
        Pay = new JButton("Pay",new ImageIcon(B_PAY));
        Pay.setBounds(225,190,150,50);
        Pay.setBackground(Color.white);
        Pay.setForeground(Color.blue);
        Pay.addActionListener(this);
        Pay.setBorder(null);
        Pay.setFont(font);
        c.add(Pay);




        // Add Back Button.
        Back = new JButton("Back",new ImageIcon(B_BACK));
        Back.setBounds(420,190,150,50);
        Back.setBackground(Color.white);
        Back.setForeground(Color.red);
        Back.addActionListener(this);
        Back.setBorder(null);
        Back.setFont(font);
        c.add(Back);




        // Change Value On Selected Months.
        try{
            ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select uname from customer where umeter='"+METERID+"'").executeQuery();
            while(rs.next()){
                Name.setText(rs.getString("uname"));
            }

            ResultSet rs1 = JDBC.getConnectionJDBC().prepareStatement("select * from bill where meter='"+METERID+"' and month='"+Month.getSelectedItem()+"'").executeQuery();
            while(rs1.next()){
                Unit.setText(rs1.getString("units"));
                Bill.setText(rs1.getString("totalbill"));
                Status.setText(rs1.getString("pay"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }




        setVisible(true);
    }


    // Override The Action Listener Methods.
    public void actionPerformed(ActionEvent e){

        // Declaration Of Back Button.
        if(e.getSource()==Back){
            dispose();
        }

        // Declaration Of Pay Button.
        if(e.getSource()==Pay){
            try{
                int x = JDBC.getConnectionJDBC().prepareStatement("update bill set pay='Pay' where meter='"+METERID+"' and month='"+Month.getSelectedItem()+"'").executeUpdate();
                if(x>0){
                    JOptionPane.showMessageDialog(this,"Successfully Payed!");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Payment Methode Fail!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (Exception z){
                z.printStackTrace();
            }
        }

    }

}
