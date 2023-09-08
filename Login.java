// Class Import Statements.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
    LOGIN = new ImageIcon(ClassLoader.getSystemResource("icon/Login.jpg")),
    b_LOGIN = new ImageIcon(ClassLoader.getSystemResource("icon/b_Login.png")),
    b_SIGNUP = new ImageIcon(ClassLoader.getSystemResource("icon/b_Signup.png")),
    b_CLEAR = new ImageIcon(ClassLoader.getSystemResource("icon/b_Clear.png")),
    b_EXIT = new ImageIcon(ClassLoader.getSystemResource("icon/b_Exit.png"));
    Image B_LOGIN = b_LOGIN.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
    B_SIGNUP = b_SIGNUP.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
    B_CLEAR = b_CLEAR.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT),
    B_EXIT = b_EXIT.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
    JLabel background, email, password, user; Font font = new Font("Arial",Font.BOLD,20);
    JTextField t_email; JPasswordField t_password; JComboBox t_user; Container c;
    String[] userType = {"----none----","Admin","Customer"}; JButton login, signup, clear, exit;

    Login(){
        // Create Frame.
        setBounds(300,100,800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("Login Page");
        setResizable(false);
        revalidate();

        // Add Container In Frame.
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);

        // Set Login Image Background Image.
        background = new JLabel(LOGIN);
        background.setBounds(20,100,LOGIN.getIconWidth(),LOGIN.getIconHeight());
        c.add(background);

        // Email Input Field.
        email = new JLabel("Username  :");
        email.setBounds(300,50,150,50);
        email.setFont(font);
        c.add(email);

        t_email = new JTextField();
        t_email.setBounds(450,50,300,40);
        t_email.setBorder(BorderFactory.createLineBorder(Color.red));
        t_email.setFont(font);
        c.add(t_email);

        // Password Input Field.
        password = new JLabel("Password  :");
        password.setBounds(300,130,150,50);
        password.setFont(font);
        c.add(password);

        t_password = new JPasswordField();
        t_password.setBounds(450,130,300,40);
        t_password.setBorder(BorderFactory.createLineBorder(Color.red));
        t_password.setFont(font);
        c.add(t_password);

        // Select User Type Bar.
        user = new JLabel("Login as    :");
        user.setBounds(300,210,150,50);
        user.setFont(font);
        c.add(user);

        t_user = new JComboBox(userType);
        t_user.setBounds(450,210,300,40);
        t_user.setBorder(null);
        t_user.setFont(font);
        t_user.setBackground(Color.white);
        c.add(t_user);

        // Add Exit Button.
        exit = new JButton("Exit",new ImageIcon(B_EXIT));
        exit.setBounds(435,262,150,50);
        exit.setBackground(Color.white);
        exit.setForeground(Color.blue);
        exit.addActionListener(this);
        exit.setBorder(null);
        exit.setFont(font);
        c.add(exit);

        // Add Login Button.
        login = new JButton("Login",new ImageIcon(B_LOGIN));
        login.setBounds(330,316,150,50);
        login.setBackground(Color.white);
        login.setForeground(Color.blue);
        login.addActionListener(this);
        login.setBorder(null);
        login.setFont(font);
        c.add(login);

        // Add Clear Button.
        clear = new JButton("Clear",new ImageIcon(B_CLEAR));
        clear.setBounds(550,316,150,50);
        clear.setBackground(Color.white);
        clear.setBorder(null);
        clear.setFont(font);
        clear.setForeground(Color.red);
        clear.addActionListener(this);
        c.add(clear);

        // Add Signup Button.
        signup = new JButton("Signup",new ImageIcon(B_SIGNUP));
        signup.setBounds(450,370,150,50);
        signup.setForeground(Color.green);
        signup.setBackground(Color.white);
        signup.addActionListener(this);
        signup.setBorder(null);
        signup.setFont(font);
        c.add(signup);

        setVisible(true);
    }

    // Action Listener Declaration.
    @Override
    public void actionPerformed(ActionEvent e){
        // Exit Button Declaration.
        if(e.getSource()==exit){
            this.dispose();
        }

        // Login Button Declaration.
        if(e.getSource()==login){
            String checkUser = (String)t_user.getSelectedItem(); String meterlelo;
            String checkEmail = t_email.getText(), checkPassword = t_password.getText();
            String adminQuery = "select * from login where username='"+checkEmail+"' and password='"+checkPassword+"' and usertype='"+checkUser+"'";
            if(checkUser.equals("")||checkEmail.equals("")||checkPassword.equals("")){
                JOptionPane.showMessageDialog(this,"Form Field Is Empty!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    Connection con = JDBC.getConnectionJDBC();
                    if(checkUser.equals(userType[0])){
                        JOptionPane.showMessageDialog(this,"Select Valid User Type!","Warning",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        ResultSet rs = JDBC.getConnectionJDBC().prepareStatement(adminQuery).executeQuery();
                        if(rs.next()){
                            meterlelo = rs.getString("meter");
                            if(checkUser.equals(userType[1])){
                                dispose();
                                new Home(checkUser,meterlelo);
                                JOptionPane.showMessageDialog(this,"Admin Login Successfully!");
                            }
                            else if(checkUser.equals(userType[2])){
                                dispose();
                                new Home(checkUser,meterlelo);
                                JOptionPane.showMessageDialog(this,"Customer Login Successfully!");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(this,"Inter Valid Email & Password!","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                catch(Exception z){
                    z.getStackTrace();
                }
            }
        }

        // Clear Button Declaration.
        if(e.getSource()==clear){
            t_email.setText(null);
            t_password.setText(null);
            t_user.setSelectedItem(userType[0]);
        }

        // Signup Button Declaration.
        if(e.getSource()==signup){
            this.dispose();
            new Sign_Up();
        }
    }
    
}
