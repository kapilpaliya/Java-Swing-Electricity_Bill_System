// Class Import Statements.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;

public class Sign_Up extends JFrame implements ActionListener{
    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
            b_SIGNUP1 = new ImageIcon(ClassLoader.getSystemResource("icon/Signup.png")),
            b_SIGNUP2 = new ImageIcon(ClassLoader.getSystemResource("icon/b_Signup.png")),
            b_BACK = new ImageIcon(ClassLoader.getSystemResource("icon/b_Back.png")),
            b_CLEAR = new ImageIcon(ClassLoader.getSystemResource("icon/b_Clear.png"));
    Image B_SIGNUP1 = b_SIGNUP1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT),
            B_SIGNUP2 = b_SIGNUP2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
            B_CLEAR = b_CLEAR.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
            B_BACK = b_BACK.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
    JLabel l_signup, user, meter, Uname, password, name; JTextField t_meter, t_Uname, t_name; JPasswordField t_password; JComboBox t_user;
    String[] userType = {"Admin","Customer"}; Font font = new Font("Arial",Font.BOLD,20);
    JButton signup, clear, back;

    Sign_Up(){
        // Create A Frame.
        setBounds(300,100,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("Registration Page");
        setResizable(false);
        revalidate();

        // Add Panel In Frame.
        JPanel p = new JPanel();
        add(p);
        p.setBounds(20,20,770,450);
        p.setFont(font);
        p.setBackground(Color.white);
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Create Account"));
        p.setBackground(Color.white);
        p.setLayout(null);

        // Set Them Image Or Login Image In Background.
        l_signup = new JLabel(new ImageIcon(B_SIGNUP1));
        l_signup.setBounds(10,80,300,300);
        l_signup.setBorder(null);
        p.add(l_signup);

        // Take User Type Validation.
        user = new JLabel("Create Account as :");
        user.setBounds(320,50,190,50);
        user.setFont(font);
        p.add(user);

        t_user = new JComboBox(userType);
        t_user.setBounds(520,55,250,40);
        t_user.setBorder(null);
        t_user.setFont(font);
        t_user.setBackground(Color.white);
        t_user.addActionListener(this);
        p.add(t_user);


        // Add Meter_Id Setting Field.
        meter = new JLabel("Meter Number:");
        meter.setBounds(320,90,200,50);
        meter.setVisible(false);
        meter.setFont(font);
        p.add(meter);

        t_meter = new JTextField();
        t_meter.setBounds(520,90,250,40);
        t_meter.setBorder(BorderFactory.createLineBorder(Color.red));
        t_meter.setVisible(false);
        t_meter.setForeground(Color.black);
        t_meter.setFont(font);
        p.add(t_meter);


        // Add User_Name Input Field.
        Uname = new JLabel("Username  :");
        Uname.setBounds(320,130,200,50);
        Uname.setFont(font);
        p.add(Uname);

        t_Uname = new JTextField();
        t_Uname.setBounds(520,130,250,40);
        t_Uname.setBorder(BorderFactory.createLineBorder(Color.red));
        t_Uname.setFont(font);
        p.add(t_Uname);


        // Add Email_Id Input Field.
        name = new JLabel("Name  :");
        name.setBounds(320,210,200,50);
        name.setFont(font);
        p.add(name);

        t_name = new JTextField();
        t_name.setBounds(520,210,250,40);
        t_name.setBorder(BorderFactory.createLineBorder(Color.red));
        t_name.setFont(font);
        p.add(t_name);


        // Add Password Field.
        password = new JLabel("Password  :");
        password.setBounds(320,290,200,50);
        password.setFont(font);
        p.add(password);

        t_password = new JPasswordField();
        t_password.setBounds(520,290,250,40);
        t_password.setBorder(BorderFactory.createLineBorder(Color.red));
        t_password.setFont(font);
        p.add(t_password);


        // Add Signup Button.
        signup = new JButton("Signup",new ImageIcon(B_SIGNUP2));
        signup.setBounds(300,370,150,50);
        signup.setForeground(Color.green);
        signup.setBackground(Color.white);
        signup.addActionListener(this);
        signup.setBorder(null);
        signup.setFont(font);
        p.add(signup);


        // Add Clear Button.
        clear = new JButton("Clear",new ImageIcon(B_CLEAR));
        clear.setBounds(460,370,150,50);
        clear.setBackground(Color.white);
        clear.setForeground(Color.red);
        clear.addActionListener(this);
        clear.setBorder(null);
        clear.setFont(font);
        p.add(clear);


        // Add Back Button.
        back = new JButton("Back",new ImageIcon(B_BACK));
        back.setBounds(620,370,150,50);
        back.setBackground(Color.white);
        back.setForeground(Color.blue);
        back.addActionListener(this);
        back.setBorder(null);
        back.setFont(font);
        p.add(back);


        setVisible(true);
    }


    // Add Action Listener Declaration.
    public void actionPerformed(ActionEvent e){

        // Describe The User_Type Input Fields.
        String item = (String) t_user.getSelectedItem();
        if(item.equals(userType[0])){
            meter.setVisible(false);
            t_meter.setVisible(false);
            t_name.setEnabled(true);

            user.setBounds(320,50,190,50);
            t_user.setBounds(520,55,250,40);

            Uname.setBounds(320,130,200,50);
            t_Uname.setBounds(520,130,250,40);

            name.setBounds(320,210,200,50);
            t_name.setBounds(520,210,250,40);

            password.setBounds(320,290,200,50);
            t_password.setBounds(520,290,250,40);
        }
        else if(item.equals(userType[1])){
            meter.setVisible(true);
            t_meter.setVisible(true);
            t_name.setEnabled(false);
            t_meter.addFocusListener(new FocusListener() {
                String USERTYPE = (String)t_user.getSelectedItem();
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if(USERTYPE.equals(userType[1])){
                        if(!t_meter.getText().equals("")){
                            try{
                                ResultSet rs = JDBC.getConnectionJDBC().prepareStatement("select name from login where meter='"+t_meter.getText()+"'").executeQuery();
                                while(rs.next()){
                                    t_name.setText(rs.getString("name"));
                                }
                            }
                            catch(Exception z){
                                z.printStackTrace();
                            }
                        }
                    }
                }
            });

            user.setBounds(320,20,190,50);
            t_user.setBounds(520,25,250,40);

            meter.setBounds(320,90,190,50);
            t_meter.setBounds(520,90,250,40);

            Uname.setBounds(320,160,200,50);
            t_Uname.setBounds(520,160,250,40);

            name.setBounds(320,230,200,50);
            t_name.setBounds(520,230,250,40);

            password.setBounds(320,300,200,50);
            t_password.setBounds(520,300,250,40);
        }


        // Clear Button Declaration.
        if(e.getSource()==clear){
            t_user.setSelectedItem(userType[0]);
            t_meter.setText(null);
            t_Uname.setText(null);
            t_name.setText(null);
            t_password.setText(null);
        }


        // Signup Button Declaration.
        if(e.getSource()==signup){
            String USERNAME = t_Uname.getText(), NAME = t_name.getText(),
                    PASSWORD = t_password.getText(), METERNUMBER = t_meter.getText(), USERTYPE = (String)t_user.getSelectedItem();
            String Query = "insert into login values('"+METERNUMBER+"', '"+USERNAME+"', '"+NAME+"', '"+PASSWORD+"', '"+USERTYPE+"')";
            String QueryCustomer = "update login set username='"+USERNAME+"', password= '"+PASSWORD+"', usertype='"+USERTYPE+"' where meter = '"+METERNUMBER+"'";
            try{
                if((USERNAME.equals("")||NAME.equals(""))||PASSWORD.equals("")){
                    JOptionPane.showMessageDialog(this,"Data Field Is Empty!","Warning",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    int x=0;
                    if(USERTYPE.equals(userType[0])){
                        x = JDBC.getConnectionJDBC().prepareStatement(Query).executeUpdate();
                    }
                    else if(USERTYPE.equals(userType[1])){
                        x = JDBC.getConnectionJDBC().prepareStatement(QueryCustomer).executeUpdate();
                    }
                    if(x>0){
                        JOptionPane.showMessageDialog(this,"Data Save Successfully!");
                        t_Uname.setText(null); t_name.setText(null); t_password.setText(null); t_meter.setText(null);
                    }
                    else{
                        JOptionPane.showMessageDialog(this,"Try Again, Data Will Not Forward!","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            catch(Exception z){
                JOptionPane.showMessageDialog(this,"Database Connection Loss!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }


        // Back Button Declaration.
        if(e.getSource()==back){
            this.dispose();
            new Login();
        }

    }

}
