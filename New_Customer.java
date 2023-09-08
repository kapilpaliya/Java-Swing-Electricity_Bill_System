
// Package And Class Import Statement.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class New_Customer extends JFrame implements ActionListener{
    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
    CUSTOMER = new ImageIcon(ClassLoader.getSystemResource("icon/newCustomer.png")),
    NEXT = new ImageIcon(ClassLoader.getSystemResource("icon/b_NEXT.png")),
    CANCEL = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png")),
    CLEAR = new ImageIcon(ClassLoader.getSystemResource("icon/b_Clear.png"));
    Image CUSTOMER1 = CUSTOMER.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT),
    CLEAR1 = CLEAR.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT),
    NEXT1 = NEXT.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT),
    CANCEL1 = CANCEL.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
    JLabel heading, name, meter, Number, address, city, state, email, phone, CUSTOMERIMAGE;
    JTextField Name, Address, City, State, Email, Phone;
    JButton Next, Exit, Clear; JPanel p = new JPanel(); Font font = new Font("Arial",Font.BOLD,18);
    String meterNumberLego = Take_Meter_Id();

    New_Customer(){
        // Create A Frame.
        setBounds(300,100,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("Add New Customer");
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        revalidate();


        // Set A Add User Them Logo Image.
        CUSTOMERIMAGE = new JLabel(new ImageIcon(CUSTOMER1));
        CUSTOMERIMAGE.setBounds(0,100,200,200);
        this.add(CUSTOMERIMAGE);


        // Add Container To Store Components.
        p.setBounds(200,0,600,500);
        p.setBackground(Color.white);
        p.setBorder(null);
        p.setLayout(null);
        this.add(p);


        // Add Heading.
        heading = new JLabel("Add New Customer");
        heading.setBounds(200,5,200,20);
        heading.setFont(font);
        p.add(heading);


        // Create Name Input And Label Field.
        name = new JLabel("Customer Name :");
        name.setBounds(30,40,200,40);
        name.setFont(font);
        p.add(name);

        Name = new JTextField();
        Name.setBounds(230,40,300,35);
        Name.setBorder(BorderFactory.createLineBorder(Color.red));
        Name.setFont(font);
        p.add(Name);


        // Create Meter Number Input And Label Field.
        meter = new JLabel("Meter No. :");
        meter.setBounds(30,90,200,20);
        meter.setFont(font);
        p.add(meter);

        Number = new JLabel(meterNumberLego);
        Number.setBounds(230,90,200,20);
        Number.setForeground(Color.blue);
        Number.setFont(font);
        p.add(Number);


        // Create Address Input And Label Field.
        address = new JLabel("Address :");
        address.setBounds(30,120,200,35);
        address.setFont(font);
        p.add(address);

        Address = new JTextField();
        Address.setBounds(230,120,300,35);
        Address.setBorder(BorderFactory.createLineBorder(Color.red));
        Address.setFont(font);
        p.add(Address);

        // Create City Input And Label Field.
        city = new JLabel("City :");
        city.setBounds(30,180,200,35);
        city.setFont(font);
        p.add(city);

        City = new JTextField();
        City.setBounds(230,180,300,35);
        City.setBorder(BorderFactory.createLineBorder(Color.red));
        City.setFont(font);
        p.add(City);

        // Create State Input And Label Field.
        state = new JLabel("State :");
        state.setBounds(30,240,200,35);
        state.setFont(font);
        p.add(state);

        State = new JTextField();
        State.setBounds(230,240,300,35);
        State.setBorder(BorderFactory.createLineBorder(Color.red));
        State.setFont(font);
        p.add(State);

        // Create Email_ID Input And Label Field.
        email = new JLabel("Email :");
        email.setBounds(30,300,200,35);
        email.setFont(font);
        p.add(email);

        Email = new JTextField();
        Email.setBounds(230,300,300,35);
        Email.setBorder(BorderFactory.createLineBorder(Color.red));
        Email.setFont(font);
        p.add(Email);

        // Create Phone Input And Label Field.
        phone = new JLabel("Phone Number :");
        phone.setBounds(30,360,200,35);
        phone.setFont(font);
        p.add(phone);

        Phone = new JTextField();
        Phone.setBounds(230,360,300,35);
        Phone.setBorder(BorderFactory.createLineBorder(Color.red));
        Phone.setFont(font);
        p.add(Phone);

        // Create Button To Show Next Filed, Clear Info And Exit Add Customer.
        Next = new JButton("Next");
        Next.setBounds(30,410,150,40);
        Next.addActionListener(this);
        Next.setIcon(new ImageIcon(NEXT1));
        Next.setForeground(Color.blue);
        Next.setBackground(null);
        Next.setBorder(null);
        Next.setFont(font);
        p.add(Next);

        Clear = new JButton("Clear");
        Clear.setBounds(210,410,150,40);
        Clear.setIcon(new ImageIcon(CLEAR1));
        Clear.addActionListener(this);
        Clear.setForeground(Color.black);
        Clear.setBackground(null);
        Clear.setBorder(null);
        Clear.setFont(font);
        p.add(Clear);

        Exit = new JButton("Cancel");
        Exit.setBounds(400,410,150,40);
        Exit.setIcon(new ImageIcon(CANCEL1));
        Exit.addActionListener(this);
        Exit.setForeground(Color.red);
        Exit.setBackground(null);
        Exit.setBorder(null);
        Exit.setFont(font);
        p.add(Exit);

        setVisible(true);
    }

    // Override The ActionListener Method.
    public void actionPerformed(ActionEvent e){
        // Describe The Exit Button.
        if(e.getSource()==Exit){
            this.dispose();
        }

        // Describe The Clear Button.
        if(e.getSource()==Clear){
            Name.setText(null); Address.setText(null); City.setText(null); State.setText(null);
            Email.setText(null); Phone.setText(null);
        }

        // Describe The Next Field Button.
        if(e.getSource()==Next){
            String uname = Name.getText(), umeter = Number.getText(), uaddress = Address.getText(),
                    ucity = City.getText(), ustate = State.getText(), uemail = Email.getText(), uphone = Phone.getText();
            String Query = "insert into customer values('"+uname+"','"+umeter+"','"+uaddress+"','"+ucity+"','"+ustate+"','"+uemail+"','"+uphone+"')";
            String QueryLogin = "insert into login values('"+umeter+"','','"+uname+"','','')";
            if(uname.equals("")|| umeter.equals("")|| uaddress.equals("")||ucity.equals("")||ustate.equals("")||uemail.equals("")||uphone.equals("") ){
                JOptionPane.showMessageDialog(this,"Data Field Is Empty!","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    int x = JDBC.getConnectionJDBC().prepareStatement(Query).executeUpdate();
                    int y = JDBC.getConnectionJDBC().prepareStatement(QueryLogin).executeUpdate();
                    if(x>0&&y>0){
                        JOptionPane.showMessageDialog(this,"Data Successfully Insert!");
                        this.dispose();
                        new Meter_Information(meterNumberLego);
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Data Field Match!","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(Exception z){
                    JOptionPane.showMessageDialog(this,"Database Connection Loss!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Create A User Define Function. Used To Generate 6 Digit Meter Number.
    public static String Take_Meter_Id(){
        Random rm = new Random(); long a = rm.nextLong(100000,999999);
        String check = String.valueOf(a); String value = "";
        try{
            ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select meter from login where meter = '"+check+"'").executeQuery();
            if(!rs.next()){
                value = check;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return value;
    }
}
