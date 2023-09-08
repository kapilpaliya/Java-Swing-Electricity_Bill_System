
// Add Package And Class.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.print.PrinterException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class GenerateBill extends JFrame implements ActionListener {
    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png"));
    Font font = new Font(Font.SANS_SERIF,Font.BOLD,18);
    JLabel meter, Meter, month; JComboBox Month; JTextArea Data; JButton Bill, Print, Back; JScrollPane sp; JPanel p, p1;
    String[] MONTHS =  {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    String METERID;
    GenerateBill(String M){
        METERID = M;




        // Create A Frame.
        setBounds(300,100,500,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("Generate Bill Details");
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setLayout(new BorderLayout());
        revalidate();


        // Add Panel One.
        p = new JPanel();


        // Add Panel Two.
        p1 = new JPanel();




        // Add Meter Number Input And Label.
        meter = new JLabel("Meter Number :");
        meter.setFont(font);
        p.add(meter,"North");

        Meter = new JLabel(METERID+"     ");
        Meter.setFont(font);
        Meter.setForeground(Color.blue);
        p.add(Meter,"North");




        // Add Month Number Input And Label.
        month = new JLabel("Months :");
        month.setFont(font);
        p.add(month,"North");

        Month = new JComboBox(MONTHS);
        Month.setForeground(Color.blue);
        Month.setBackground(Color.white);
        Month.setFont(font);
        p.add(Month,"North");




        // Add Bill Text In TextArea.
        Data = new JTextArea(50,30);
        Data.setText("\n\n\t--------Click on the---------\n\tGenerate Bill Button To Get\n\tThe Bill Of The Selected Month.");
        Data.setForeground(Color.blue);
        Data.setBackground(Color.red);
        Data.setLineWrap(true);
        Data.setFont(font);

        // Add ScrollPane To Draga Page.
        sp = new JScrollPane(Data);




        // Add Generate Bill Button.
        Bill = new JButton("       Generate Bill        ");
        Bill.setBackground(Color.white);
        Bill.setForeground(Color.black);
        Bill.addActionListener(this);
        Bill.setBorder(null);
        Bill.setFont(font);
        p1.add(Bill,"Left");




        // Add Print Button.
        Print = new JButton("     Print Bill       ");
        Print.setBackground(Color.white);
        Print.setForeground(Color.green);
        Print.addActionListener(this);
        Print.setBorder(null);
        Print.setFont(font);
        p1.add(Print,"Center");




        // Add Back Button.
        Back = new JButton("          Back         ");
        Back.setBackground(Color.white);
        Back.setForeground(Color.red);
        Back.addActionListener(this);
        Back.setBorder(null);
        Back.setFont(font);
        p1.add(Back,"Right");



        // Add Component In BorderLayout.
        add(p1,"South");
        add(p,"North");
        add(sp,"Center");


        setVisible(true);
    }


    public void actionPerformed(ActionEvent e){

        // Declaration Of Bill Button.
        if(e.getSource()==Bill){
            try{
                Data.setText("\n\n\tReliance Power Limited \n          Electricity Bill Genrated For The Month Of \n\t        '"+Month.getSelectedItem()+"', 2023");
                ResultSet CUSTOMER = JDBC.getConnectionJDBC().prepareStatement("select * from customer where umeter='"+METERID+"'").executeQuery();
                while(CUSTOMER.next()){
                    Data.append("\n\n    Meter Number    :     "+CUSTOMER.getString("umeter")+"\n");
                    Data.append("    Username           :     "+CUSTOMER.getString("uname")+"\n");
                    Data.append("    Address              :     "+CUSTOMER.getString("uaddress")+"\n");
                    Data.append("    City                      :     "+CUSTOMER.getString("ucity")+"\n");
                    Data.append("    State                    :     "+CUSTOMER.getString("ustate")+"\n");
                    Data.append("    Email                   :     "+CUSTOMER.getString("uemail")+"\n");
                    Data.append("    Phone                 :     "+CUSTOMER.getString("uphone")+"\n");
                    Data.append("\n\n----------------------------------------------------------------------");
                }

                ResultSet METER = JDBC.getConnectionJDBC().prepareStatement("select * from meterinfo where mmeter='"+METERID+"'").executeQuery();
                while(METER.next()){
                    Data.append("\n\n    Meter Location    :     "+METER.getString("mlocation")+"\n");
                    Data.append("    Meter Type           :     "+METER.getString("mmetertype")+"\n");
                    Data.append("    Phase Code         :     "+METER.getString("mphasecode")+"\n");
                    Data.append("    Bill Type               :     "+METER.getString("mbilltype")+"\n");
                    Data.append("    Day                        :     "+METER.getString("mdays")+"\n");
                    Data.append("\n\n----------------------------------------------------------------------");
                }

                ResultSet TAX = JDBC.getConnectionJDBC().prepareStatement("select * from tax").executeQuery();
                while(TAX.next()){
                    Data.append("\n\n    Cost Per Unit                      :     "+TAX.getString("cost_per_unit")+"\n");
                    Data.append("    Meter Rent                          :     "+TAX.getString("meter_rent")+"\n");
                    Data.append("    Service Charge                  :     "+TAX.getString("service_charge")+"\n");
                    Data.append("    Service Tax                         :     "+TAX.getString("service_tax")+"\n");
                    Data.append("    Swacche Bharat Cess      :     "+TAX.getString("swacche_bharat_cess")+"\n");
                    Data.append("    Fixed Tex                             :     "+TAX.getString("fixed_tax")+"\n");
                    Data.append("\n\n----------------------------------------------------------------------");
                }

                ResultSet BILL = JDBC.getConnectionJDBC().prepareStatement("select * from bill where meter='"+METERID+"' and month = '"+Month.getSelectedItem()+"'").executeQuery();
                while(BILL.next()){
                    Data.append("\n\n    Current Month            :     "+BILL.getString("month")+"\n");
                    Data.append("    Unit Consumed           :     "+BILL.getString("units")+"\n");
                    Data.append("    Total Charges              :     "+BILL.getString("totalbill")+"\n");
                    Data.append("----------------------------------------------------------------------");
                    Data.append("\n\n\tTotal Payable  :  "+BILL.getString("totalbill")+"\n");
                    Data.append("\n\n----------------------------------------------------------------------");
                }
            }
            catch(Exception z){
                z.printStackTrace();
            }
        }


        // Declaration Of Print Button.
        if(e.getSource()==Print){
            try {
                Data.print();
            } catch (PrinterException ex) {
                throw new RuntimeException(ex);
            }
        }


        // Declaration Of Back Button.
        if(e.getSource()==Back){
            dispose();
        }

    }

}
