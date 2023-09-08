
// Class Import Statements.
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
public class ViewUserInfo extends JFrame implements ActionListener{
    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            b_BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png"));
    Image B_BACK = b_BACK.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
    Container c;    JButton Back;   Font font = new Font("Arial",Font.BOLD,20);
    JLabel Head, name, Name, meter, Meter, address, Address, city, City, state, State, email, Email, phone, Phone;
    JLabel meter1, Meter1, location, Location, type, Type, phase, Phase, bill, Bill, day, Day;
    JRadioButton USER, METER; ButtonGroup Set;


    ViewUserInfo(String ID){
        // Create Frame.
        setBounds(300,100,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("View Customer Information");
        setResizable(false);
        revalidate();




        // Add Container In Frame.
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);




        // Add Hading In Frame.
        Head = new JLabel("View Customer Information!");
        Head.setBounds(235,10,280,40);
        Head.setForeground(Color.green);
        Head.setFont(font);
        c.add(Head);




        // Add Name Input And Label Field.
        name = new JLabel("Name :");
        name.setBounds(30,50,80,40);
        name.setFont(font);
        c.add(name);

        Name = new JLabel("Pta Nahi he");
        Name.setBounds(110,50,300,40);
        Name.setForeground(new Color(65, 105, 225));
        Name.setFont(font);
        c.add(Name);




        // Add State Input And Label Field.
        state = new JLabel("State :");
        state.setBounds(400,50,80,40);
        state.setFont(font);
        c.add(state);

        State = new JLabel("Pta Nahi he");
        State.setBounds(490,50,300,40);
        State.setForeground(new Color(65, 105, 225));
        State.setFont(font);
        c.add(State);




        // Add Meter Input And Label Field.
        meter = new JLabel("Meter_Id :");
        meter.setBounds(30,100,100,40);
        meter.setFont(font);
        c.add(meter);

        Meter = new JLabel("Pta Nahi he");
        Meter.setBounds(135,100,300,40);
        Meter.setForeground(new Color(65, 105, 225));
        Meter.setFont(font);
        c.add(Meter);




        // Add Email Input And Label Field.
        email = new JLabel("Email :");
        email.setBounds(400,100,80,40);
        email.setFont(font);
        c.add(email);

        Email = new JLabel("Pta Nahi he");
        Email.setBounds(490,100,300,40);
        Email.setForeground(new Color(65, 105, 225));
        Email.setFont(font);
        c.add(Email);




        // Add City Input And Label Field.
        city = new JLabel("City :");
        city.setBounds(30,150,80,40);
        city.setFont(font);
        c.add(city);

        City = new JLabel("Pta Nahi he");
        City.setBounds(110,150,300,40);
        City.setForeground(new Color(65, 105, 225));
        City.setFont(font);
        c.add(City);




        // Add Phone Input And Label Field.
        phone = new JLabel("Phone :");
        phone.setBounds(400,150,80,40);
        phone.setFont(font);
        c.add(phone);

        Phone = new JLabel("Pta Nahi he");
        Phone.setBounds(490,150,300,40);
        Phone.setForeground(new Color(65, 105, 225));
        Phone.setFont(font);
        c.add(Phone);




        // Add Address Input And Label Field.
        address = new JLabel("Address :");
        address.setBounds(30,200,100,40);
        address.setFont(font);
        c.add(address);

        Address = new JLabel("Pta Nahi he");
        Address.setBounds(140,200,600,40);
        Address.setForeground(new Color(65, 105, 225));
        Address.setFont(font);
        c.add(Address);




        // Add Meter Input And Label Field For Meter Information Radio Button.
        meter1 = new JLabel("Meter_Id :");
        meter1.setBounds(30,50,110,40);
        meter1.setFont(font);
        c.add(meter1);

        Meter1 = new JLabel("Pta Nahi he");
        Meter1.setBounds(130,50,300,40);
        Meter1.setForeground(new Color(65, 105, 225));
        Meter1.setFont(font);
        c.add(Meter1);




        // Add Meter Location Input And Label Field.
        location = new JLabel("Meter Location :");
        location.setBounds(400,50,180,40);
        location.setFont(font);
        c.add(location);

        Location = new JLabel();
        Location.setBounds(570,50,300,40);
        Location.setForeground(new Color(65, 105, 225));
        Location.setFont(font);
        c.add(Location);




        // Add Meter Type Input And Label Field.
        type = new JLabel("Meter Type :");
        type.setBounds(30,100,150,40);
        type.setFont(font);
        c.add(type);

        Type = new JLabel("Pta Nahi he");
        Type.setBounds(160,100,300,40);
        Type.setForeground(new Color(65, 105, 225));
        Type.setFont(font);
        c.add(Type);




        // Add Phase Code Input And Label Field.
        phase = new JLabel("Phase Code :");
        phase.setBounds(400,100,150,40);
        phase.setFont(font);
        c.add(phase);

        Phase = new JLabel("Pta Nahi he");
        Phase.setBounds(550,100,300,40);
        Phase.setForeground(new Color(65, 105, 225));
        Phase.setFont(font);
        c.add(Phase);




        // Add Bill Type Input And Label Field.
        bill = new JLabel("Bill Type :");
        bill.setBounds(30,150,150,40);
        bill.setFont(font);
        c.add(bill);

        Bill = new JLabel("Pta Nahi he");
        Bill.setBounds(150,150,300,40);
        Bill.setForeground(new Color(65, 105, 225));
        Bill.setFont(font);
        c.add(Bill);




        // Add Day Input And Label Field.
        day = new JLabel("Days :");
        day.setBounds(400,150,80,40);
        day.setFont(font);
        c.add(day);

        Day = new JLabel("Pta Nahi he");
        Day.setBounds(490,150,300,40);
        Day.setForeground(new Color(65, 105, 225));
        Day.setFont(font);
        c.add(Day);




        // Add User Info And Meter Info Radio Button.
        USER = new JRadioButton("User_Info");
        USER.setBounds(145,250,150,40);
        USER.addActionListener(this);
        USER.setSelected(true);
        USER.setForeground(Color.PINK);
        USER.setBackground(null);
        USER.setFont(font);
        c.add(USER);

        METER = new JRadioButton("Meter_Info");
        METER.setBounds(325,250,150,40);
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
        Back.setBounds(505,250,150,50);
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
               Location.setText(zq.getString("mlocation"));
               Type.setText(zq.getString("mmetertype"));
               Phase.setText(zq.getString("mphasecode"));
               Bill.setText(zq.getString("mbilltype"));
               Day.setText(zq.getString("mdays"));
           }
       }
       catch(Exception e){
            e.printStackTrace();
       }

        meter1.setVisible(false); Meter1.setVisible(false); location.setVisible(false); Location.setVisible(false);
        type.setVisible(false); Type.setVisible(false); phase.setVisible(false); Phase.setVisible(false);
        bill.setVisible(false); Bill.setVisible(false); day.setVisible(false); Day.setVisible(false);
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

    }

}
