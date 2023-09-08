
// Import Package & Classes.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.Image;
import java.awt.Container;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Home extends JFrame implements ActionListener {
    // Variable Declaration.
    ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
    BACKGROUND = new ImageIcon(ClassLoader.getSystemResource("icon/Background3.jpg")),
    ICON1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png")),
    ICON2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png")),
    ICON3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png")),
    ICON4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png")),
    ICON5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png")),
    ICON6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png")),
    ICON7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png")),
    ICON8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png")),
    ICON9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png")),
    ICON10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon10.png")),
    ICON11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png")),
    ICON12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));

    Image i_ICON1 = ICON1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON2 = ICON2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON3 = ICON3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON4 = ICON4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON5 = ICON5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON6 = ICON6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON7 = ICON7.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON8 = ICON8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON9 = ICON9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON10 = ICON10.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON11 = ICON11.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT),
            i_ICON12 = ICON12.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
    Font font = new Font("Arial",Font.BOLD,12); Container c; JLabel bg;
    JMenuBar m; JMenu master, information, user, report, utility, exit;
    JMenuItem newCustomer, customerDetail, depositDetail, calculateBill, updateInformation,
            viewInformation, payBill, billDetail, generateBill, notepad, calculator, Exit;
    String METERID;
    Home(String USERTYPE, String meterlelo){

        // Create A Frame.
        setBounds(300,100,890,560);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(LOGO.getImage());
        setTitle("Home Page");
        setResizable(false);
        revalidate();


        // Add Container To Store Components.
        c = getContentPane();
        c.setBackground(Color.white);
        c.setLayout(null);


        // Add Image In Background.
        bg = new JLabel(BACKGROUND);
        bg.setBounds(0,0,BACKGROUND.getIconWidth(),BACKGROUND.getIconHeight());
        c.add(bg);


        // Add A MenuBar The Name Is 'm'.
        m = new JMenuBar();
        m.setBackground(Color.black);
        m.setFont(font);
        this.setJMenuBar(m);




        // Create A Master Menu Handel By The Admin.
        master = new JMenu("Master");
        master.setForeground(Color.white);
        master.setFont(font);

        // Add newCustomer MenuItem In Master.
        newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(font);
        newCustomer.setBackground(Color.white);
        newCustomer.addActionListener(this);
        newCustomer.setMnemonic('N');
        newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newCustomer.setIcon(new ImageIcon(i_ICON1));
        master.add(newCustomer);

        // Add customerDetail MenuItem In Master.
        customerDetail = new JMenuItem("Customer Details");
        customerDetail.addActionListener(this);
        customerDetail.setFont(font);
        customerDetail.setBackground(Color.white);
        customerDetail.setMnemonic('D');
        customerDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        customerDetail.setIcon(new ImageIcon(i_ICON2));
        master.add(customerDetail);

        // Add depositDetail MenuItem In Master.
        depositDetail = new JMenuItem("Deposit Details");
        depositDetail.addActionListener(this);
        depositDetail.setFont(font);
        depositDetail.setBackground(Color.white);
        depositDetail.setMnemonic('I');
        depositDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        depositDetail.setIcon(new ImageIcon(i_ICON3));
        master.add(depositDetail);

        // Add calculateBill MenuItem In Master.
        calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.addActionListener(this);
        calculateBill.setFont(font);
        calculateBill.setBackground(Color.white);
        calculateBill.setMnemonic('C');
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        calculateBill.setIcon(new ImageIcon(i_ICON4));
        master.add(calculateBill);




        // Create A Information Menu Handel By The Customer.
        information = new JMenu("Information");
        information.setForeground(Color.white);
        information.setFont(font);

        // Add updateInformation MenuItem In Customer.
        updateInformation = new JMenuItem("Update Information");
        updateInformation.addActionListener(this);
        updateInformation.setFont(font);
        updateInformation.setBackground(Color.white);
        updateInformation.setMnemonic('U');
        updateInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        updateInformation.setIcon(new ImageIcon(i_ICON5));
        information.add(updateInformation);

        // Add viewInformation MenuItem In Customer.
        viewInformation = new JMenuItem("View Information");
        viewInformation.addActionListener(this);
        viewInformation.setFont(font);
        viewInformation.setBackground(Color.white);
        viewInformation.setMnemonic('V');
        viewInformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        viewInformation.setIcon(new ImageIcon(i_ICON6));
        information.add(viewInformation);




        // Create A User Menu Handel By The Customer.
        user = new JMenu("User");
        user.setForeground(Color.white);
        user.setFont(font);

        // Add payBill MenuItem In Customer.
        payBill = new JMenuItem("Pay Bill");
        payBill.addActionListener(this);
        payBill.setFont(font);
        payBill.setBackground(Color.white);
        payBill.setMnemonic('P');
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        payBill.setIcon(new ImageIcon(i_ICON7));
        user.add(payBill);

        // Add billDetail MenuItem In Customer.
        billDetail = new JMenuItem("Bill Detail");
        billDetail.addActionListener(this);
        billDetail.setFont(font);
        billDetail.setBackground(Color.white);
        billDetail.setMnemonic('B');
        billDetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        billDetail.setIcon(new ImageIcon(i_ICON8));
        user.add(billDetail);




        // Create A report Menu Handel By The Customer.
        report = new JMenu("Report");
        report.setForeground(Color.white);
        report.setFont(font);

        // Add billDetail MenuItem In Customer.
        generateBill = new JMenuItem("Generate Bill");
        generateBill.addActionListener(this);
        generateBill.setFont(font);
        generateBill.setBackground(Color.white);
        generateBill.setMnemonic('G');
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        generateBill.setIcon(new ImageIcon(i_ICON9));
        report.add(generateBill);




        // Create A Utility Menu Handel By The All User.
        utility = new JMenu("Utility");
        utility.setForeground(Color.white);
        utility.setFont(font);

        // Add notepad MenuItem In All User.
        notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        notepad.setFont(font);
        notepad.setBackground(Color.white);
        notepad.setMnemonic('T');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        notepad.setIcon(new ImageIcon(i_ICON10));
        utility.add(notepad);

        // Add calculator MenuItem In All User.
        calculator = new JMenuItem("Calculator");
        calculator.addActionListener(this);
        calculator.setFont(font);
        calculator.setBackground(Color.white);
        calculator.setMnemonic('O');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        calculator.setIcon(new ImageIcon(i_ICON11));
        utility.add(calculator);




        // Create A exit Menu Handel By The All User.
        exit = new JMenu("Exit");
        exit.setForeground(Color.white);
        exit.setFont(font);

        // Add Exit MenuItem In All User.
        Exit = new JMenuItem("Exit");
        Exit.addActionListener(this);
        Exit.setFont(font);
        Exit.setBackground(Color.white);
        Exit.setMnemonic('W');
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        Exit.setIcon(new ImageIcon(i_ICON12));
        exit.add(Exit);




        // Add Menu In Conditional Bases.
        if(USERTYPE.equals("Admin")){
            m.add(master);

        }
        else{
            m.add(information);
            m.add(user);
            m.add(report);
        }
        m.add(utility);
        m.add(exit);


        METERID = meterlelo;
        setVisible(true);
    }




    public void actionPerformed(ActionEvent e){

        // Declaration Of Admin ManuItems In Master Manu.
        if(e.getSource()==newCustomer){
            new New_Customer();
        }

        if(e.getSource()==customerDetail){
            new Customer_Information();
        }

        if(e.getSource()==depositDetail){
            new DepositDetails();
        }

        if(e.getSource()==calculateBill){
            new CalculateBill();
        }




        // Declaration Of Customer Menu Items In Information Manu.
        if(e.getSource()==viewInformation){
            new ViewUserInfo(METERID);
        }

        if(e.getSource()==updateInformation){
            new UpdateUserInfo(METERID);
        }




        // Declaration Of Customer Menu Items In User Manu.
        if(e.getSource()==payBill){
            new Pay_Bill(METERID);
        }

        if(e.getSource()==billDetail){
            new Bill_Information(METERID);
        }




        // Declaration Of Customer Menu Items In Report Manu.
        if(e.getSource()==generateBill){
            new GenerateBill(METERID);
        }




        // Declaration Of All User Menu Items In Utility Manu.
        if(e.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception z){
                z.printStackTrace();
            }
        }

        if(e.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception z){
                z.printStackTrace();
            }
        }




        // Declaration Of All User Menu Items In Exit Manu.
        if(e.getSource()==Exit){
            dispose();
            new Login();
        }

    }

}
