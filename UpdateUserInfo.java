// Class Import Statements.
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class UpdateUserInfo extends JFrame implements ActionListener{
    // Variable Declaration.
        ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
                b_BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png")),
                UPDATE = new ImageIcon(ClassLoader.getSystemResource("icon/Updated.png"));
        Image B_BACK = b_BACK.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
                B_UPDATE = UPDATE.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        Container c;    JButton Back, Update;   Font font = new Font("Arial",Font.BOLD,20);
        JLabel Head, name, meter, address, city, state, email, phone;
        JTextField Name, Meter, Address, City, State, Email, Phone;
        JLabel meter1, location, type, phase, bill, day;
        JTextField Meter1, Day;
        JComboBox Location, Type, Phase, Bill;
        String [] LOCATION = {"Inside","Outside"};
        String[] METER_TYPE = {"Electric Meter","Solar Meter","Smart Meter"};
        String[] BILL_TYPE = {"Normal","Industrial"};
        String[] PHASE_CODE = {"011","022","033","044","055","066","077","088","099"};
        JRadioButton USER, METER; ButtonGroup Set;
        String METERID;
        UpdateUserInfo(String ID){
            // Create Frame.
            setBounds(300,100,800,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(LOGO.getImage());
            setTitle("Update Customer Information");
            setResizable(false);
            revalidate();


            // Add Container In Frame.
            c = this.getContentPane();
            c.setLayout(null);
            c.setBackground(Color.white);


            // Add Hading In Frame.
            Head = new JLabel("Update User & Meter Information!");
            Head.setBounds(235,10,320,40);
            Head.setForeground(Color.green);
            Head.setFont(font);
            c.add(Head);


            // Add Name Input And Label Field.
            name = new JLabel("Name :");
            name.setBounds(30,50,80,40);
            name.setFont(font);
            c.add(name);

            Name = new JTextField();
            Name.setBounds(135,50,250,40);
            Name.setEnabled(false);
            Name.setBorder(BorderFactory.createLineBorder(Color.red));
            Name.setForeground(new Color(65, 105, 225));
            Name.setFont(font);
            c.add(Name);




            // Add State Input And Label Field.
            state = new JLabel("State :");
            state.setBounds(400,50,80,40);
            state.setFont(font);
            c.add(state);

            State = new JTextField();
            State.setBounds(490,50,250,40);
            State.setBorder(BorderFactory.createLineBorder(Color.red));
            State.setForeground(new Color(65, 105, 225));
            State.setFont(font);
            c.add(State);




            // Add Meter Input And Label Field.
            meter = new JLabel("Meter_Id :");
            meter.setBounds(30,100,100,40);
            meter.setFont(font);
            c.add(meter);

            Meter = new JTextField();
            Meter.setBounds(135,100,250,40);
            Meter.setBorder(BorderFactory.createLineBorder(Color.red));
            Meter.setEnabled(false);
            Meter.setForeground(new Color(65, 105, 225));
            Meter.setFont(font);
            c.add(Meter);




            // Add Email Input And Label Field.
            email = new JLabel("Email :");
            email.setBounds(400,100,80,40);
            email.setFont(font);
            c.add(email);

            Email = new JTextField();
            Email.setBounds(490,100,250,40);
            Email.setBorder(BorderFactory.createLineBorder(Color.red));
            Email.setForeground(new Color(65, 105, 225));
            Email.setFont(font);
            c.add(Email);




            // Add City Input And Label Field.
            city = new JLabel("City :");
            city.setBounds(30,150,80,40);
            city.setFont(font);
            c.add(city);

            City = new JTextField();
            City.setBounds(135,150,250,40);
            City.setBorder(BorderFactory.createLineBorder(Color.red));
            City.setForeground(new Color(65, 105, 225));
            City.setFont(font);
            c.add(City);




            // Add Phone Input And Label Field.
            phone = new JLabel("Phone :");
            phone.setBounds(400,150,80,40);
            phone.setFont(font);
            c.add(phone);

            Phone = new JTextField();
            Phone.setBounds(490,150,250,40);
            Phone.setBorder(BorderFactory.createLineBorder(Color.red));
            Phone.setForeground(new Color(65, 105, 225));
            Phone.setFont(font);
            c.add(Phone);




            // Add Address Input And Label Field.
            address = new JLabel("Address :");
            address.setBounds(30,200,100,40);
            address.setFont(font);
            c.add(address);

            Address = new JTextField();
            Address.setBounds(135,200,500,40);
            Address.setBorder(BorderFactory.createLineBorder(Color.red));
            Address.setForeground(new Color(65, 105, 225));
            Address.setFont(font);
            c.add(Address);




            // Add Meter Input And Label Field For Meter Information Radio Button.
            meter1 = new JLabel("Meter_Id :");
            meter1.setBounds(30,50,110,40);
            meter1.setFont(font);
            c.add(meter1);

            Meter1 = new JTextField();
            Meter1.setBounds(160,50,200,40);
            Meter1.setEnabled(false);
            Meter1.setBorder(BorderFactory.createLineBorder(Color.red));
            Meter1.setForeground(new Color(65, 105, 225));
            Meter1.setFont(font);
            c.add(Meter1);




            // Add Meter Location Input And Label Field.
            location = new JLabel("Meter Location :");
            location.setBounds(400,50,180,40);
            location.setFont(font);
            c.add(location);

            Location = new JComboBox(LOCATION);
            Location.setBounds(570,50,200,40);
            Location.setBackground(Color.white);
            Location.setForeground(new Color(65, 105, 225));
            Location.setFont(font);
            c.add(Location);




            // Add Meter Type Input And Label Field.
            type = new JLabel("Meter Type :");
            type.setBounds(30,100,150,40);
            type.setFont(font);
            c.add(type);

            Type = new JComboBox(METER_TYPE);
            Type.setBounds(160,100,200,40);
            Type.setBackground(Color.white);
            Type.setForeground(new Color(65, 105, 225));
            Type.setFont(font);
            c.add(Type);




            // Add Phase Code Input And Label Field.
            phase = new JLabel("Phase Code :");
            phase.setBounds(400,100,150,40);
            phase.setFont(font);
            c.add(phase);

            Phase = new JComboBox(PHASE_CODE);
            Phase.setBounds(570,100,200,40);
            Phase.setBackground(Color.white);
            Phase.setForeground(new Color(65, 105, 225));
            Phase.setFont(font);
            c.add(Phase);




            // Add Bill Type Input And Label Field.
            bill = new JLabel("Bill Type :");
            bill.setBounds(30,150,150,40);
            bill.setFont(font);
            c.add(bill);

            Bill = new JComboBox(BILL_TYPE);
            Bill.setBounds(160,150,200,40);
            Bill.setBackground(Color.white);
            Bill.setForeground(new Color(65, 105, 225));
            Bill.setFont(font);
            c.add(Bill);




            // Add Day Input And Label Field.
            day = new JLabel("Days :");
            day.setBounds(400,150,80,40);
            day.setFont(font);
            c.add(day);

            Day = new JTextField();
            Day.setBounds(570,150,200,40);
            Day.setEnabled(false);
            Day.setBorder(BorderFactory.createLineBorder(Color.red));
            Day.setForeground(new Color(65, 105, 225));
            Day.setFont(font);
            c.add(Day);




            // Add Update Button.
            Update = new JButton(new ImageIcon(B_UPDATE));
            Update.setBounds(30,260,150,50);
            Update.addActionListener(this);
            Update.setBorder(null);
            Update.setBackground(Color.white);
            Update.setFont(font);
            c.add(Update);




            // Add User Info And Meter Info Radio Button.
            USER = new JRadioButton("User_Info");
            USER.setBounds(200,260,150,40);
            USER.addActionListener(this);
            USER.setSelected(true);
            USER.setForeground(Color.PINK);
            USER.setBackground(null);
            USER.setFont(font);
            c.add(USER);

            METER = new JRadioButton("Meter_Info");
            METER.setBounds(370,260,150,40);
            METER.addActionListener(this);
            METER.setForeground(Color.PINK);
            METER.setBackground(null);
            METER.setFont(font);
            c.add(METER);

            Set = new ButtonGroup();
            Set.add(METER);
            Set.add(USER);




            // Add Back Button.
            Back = new JButton("Back",new ImageIcon(B_BACK));
            Back.setBounds(540,260,150,50);
            Back.addActionListener(this);
            Back.setBackground(Color.white);
            Back.setBorder(null);
            Back.setFont(font);
            c.add(Back);




            // Starting Condition Of Display User Data.
            try{
                ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select * from customer where umeter='"+ID+"'").executeQuery();
                while(rs.next()){

                    Name.setText(rs.getString("uname"));
                    Meter.setText(rs.getString("umeter"));
                    Address.setText(rs.getString("uaddress"));
                    City.setText(rs.getString("ucity"));
                    State.setText(rs.getString("ustate"));
                    Email.setText(rs.getString("uemail"));
                    Phone.setText(rs.getString("uphone"));
                }
                ResultSet zq = JDBC.getConnectionJDBC().prepareStatement("select * from meterinfo where mmeter='"+ID+"'").executeQuery();
                while(zq.next()){
                    Meter1.setText(zq.getString("mmeter"));
                    Location.setSelectedItem(zq.getString("mlocation"));
                    Type.setSelectedItem(zq.getString("mmetertype"));
                    Phase.setSelectedItem(zq.getString("mphasecode"));
                    Bill.setSelectedItem(zq.getString("mbilltype"));
                    Day.setText(zq.getString("mdays"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }

            // Starting Phase Meter Info Is Hidden.
            meter1.setVisible(false); Meter1.setVisible(false); location.setVisible(false); Location.setVisible(false);
            type.setVisible(false); Type.setVisible(false); phase.setVisible(false); Phase.setVisible(false);
            bill.setVisible(false); Bill.setVisible(false); day.setVisible(false); Day.setVisible(false);

            METERID = ID;
            setVisible(true);
        }


        // Override The Action Listener Function.
        @Override
        public void actionPerformed(ActionEvent e){

            // Declaration Of User Radio Radio Button.
            if(USER.isSelected()){
                meter1.setVisible(false); Meter1.setVisible(false); location.setVisible(false); Location.setVisible(false);
                type.setVisible(false); Type.setVisible(false); phase.setVisible(false); Phase.setVisible(false);
                bill.setVisible(false); Bill.setVisible(false); day.setVisible(false); Day.setVisible(false);

                name.setVisible(true); Name.setVisible(true); meter.setVisible(true); Meter.setVisible(true);
                address.setVisible(true); Address.setVisible(true); city.setVisible(true); City.setVisible(true);
                state.setVisible(true); State.setVisible(true); email.setVisible(true); Email.setVisible(true);
                phone.setVisible(true); Phone.setVisible(true);
            }


            // Declaration Of Meter Radio Radio Button.
            if(METER.isSelected()){
                meter1.setVisible(true); Meter1.setVisible(true); location.setVisible(true); Location.setVisible(true);
                type.setVisible(true); Type.setVisible(true); phase.setVisible(true); Phase.setVisible(true);
                bill.setVisible(true); Bill.setVisible(true); day.setVisible(true); Day.setVisible(true);

                name.setVisible(false); Name.setVisible(false); meter.setVisible(false); Meter.setVisible(false);
                address.setVisible(false); Address.setVisible(false); city.setVisible(false); City.setVisible(false);
                state.setVisible(false); State.setVisible(false); email.setVisible(false); Email.setVisible(false);
                phone.setVisible(false); Phone.setVisible(false);
            }


            // Declaration Of Back Button.
            if(e.getSource()==Back){
                dispose();
            }


            // Declaration Of Update Button.
            if(e.getSource()==Update){
                String STATE = State.getText(), CITY = City.getText(), EMAIL = Email.getText(),
                        PHONE = Phone.getText(), ADDRESS = Address.getText();
                String LOCATION = (String)Location.getSelectedItem(), PHASE = (String)Phase.getSelectedItem(),
                        TYPE = (String)Type.getSelectedItem(), BILL = (String)Bill.getSelectedItem();
                String Query1 = "update customer set uaddress = '"+ADDRESS+"', ucity = '"+CITY+"', ustate='"+STATE+"', uemail = '"+EMAIL+"', uphone = '"+PHONE+"' where umeter = '"+METERID+"'";
                String Query2 = "update meterinfo set mlocation = '"+LOCATION+"', mmetertype = '"+TYPE+"', mphasecode ='"+PHASE+"', mbilltype = '"+BILL+"' where mmeter = '"+METERID+"'";
                try{
                    int rs1 = JDBC.getConnectionJDBC().prepareStatement(Query1).executeUpdate();
                    int rs2 = JDBC.getConnectionJDBC().prepareStatement(Query2).executeUpdate();
                    if(rs1>0 && rs2>0){
                        JOptionPane.showMessageDialog(this,"Successfully Data Updated!");
                        this.dispose();
                    }
                }
                catch(Exception z){
                    JOptionPane.showMessageDialog(this,"Database Connection Loss!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }

        }

}
