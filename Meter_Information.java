
// Package And Class Import Statement.
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Meter_Information extends JFrame implements ActionListener {
    // Variable Declaration.
        ImageIcon LOGO = new ImageIcon(ClassLoader.getSystemResource("icon/logo.png")),
                METER = new ImageIcon(ClassLoader.getSystemResource("icon/b_Meter.png")),
                NEXT = new ImageIcon(ClassLoader.getSystemResource("icon/b_Submit.png"));
        Image METER1 = METER.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT),
                NEXT1 = NEXT.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        JLabel heading, location, meter, Number, meterType, code, billType, days, Days, notes, Notes, METERIMAGE;
        JComboBox Location, MeterType, Code, BillType;
        JButton Submit; JPanel p = new JPanel(); Font font = new Font("Arial",Font.BOLD,18);

        String [] LOCATION = {"Inside","Outside"};
        String[] METER_TYPE = {"Electric Meter","Solar Meter","Smart Meter"};
        String[] BILL_TYPE = {"Normal","Industrial"};
        String[] PHASE_CODE = {"011","022","033","044","055","066","077","088","099"};
        String Meter_Number;

        Meter_Information(String Meter_Number){
            this.Meter_Number = Meter_Number;


            // Create A Frame.
            setBounds(300,100,800,500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setIconImage(LOGO.getImage());
            setTitle("Meter Information");
            setResizable(false);
            setLayout(null);
            getContentPane().setBackground(Color.white);
            revalidate();


            // Set A Add User Them Logo Image.
            METERIMAGE = new JLabel(new ImageIcon(METER1));
            METERIMAGE.setBounds(0,100,200,200);
            this.add(METERIMAGE);


            // Add Container To Store Components.
            p.setBounds(200,0,600,500);
            p.setBackground(Color.white);
            p.setBorder(null);
            p.setLayout(null);
            this.add(p);


            // Add Heading.
            heading = new JLabel("Meter Information");
            heading.setBounds(200,5,200,20);
            heading.setFont(font);
            p.add(heading);


            // Create Meter Number Input And Label Field.
            meter = new JLabel("Meter No. :");
            meter.setBounds(30,40,200,20);
            meter.setFont(font);
            p.add(meter);

            Number = new JLabel(this.Meter_Number);
            Number.setBounds(230,40,200,20);
            Number.setForeground(Color.blue);
            Number.setFont(font);
            p.add(Number);


            // Create Meter Fitting Location Input And Label Field.
            location = new JLabel("Meter Location :");
            location.setBounds(30,80,200,40);
            location.setFont(font);
            p.add(location);

            Location = new JComboBox(LOCATION);
            Location.setBounds(230,80,300,35);
            Location.setBorder(null);
            Location.setBackground(Color.white);
            Location.setFont(font);
            p.add(Location);


            // Create Meter Type Input And Label Field.
            meterType = new JLabel("Meter Type :");
            meterType.setBounds(30,140,200,35);
            meterType.setFont(font);
            p.add(meterType);

            MeterType = new JComboBox(METER_TYPE);
            MeterType.setBounds(230,140,300,35);
            MeterType.setBorder(null);
            MeterType.setBackground(Color.white);
            MeterType.setFont(font);
            p.add(MeterType);


            // Create Meter Current Phase Code Input And Label Field.
            code = new JLabel("Phase Code :");
            code.setBounds(30,200,200,35);
            code.setFont(font);
            p.add(code);

            Code = new JComboBox(PHASE_CODE);
            Code.setBounds(230,200,300,35);
            Code.setBorder(null);
            Code.setBackground(Color.white);
            Code.setFont(font);
            p.add(Code);



            // Create Bill Type Input And Label Field.
            billType = new JLabel("Bill Type :");
            billType.setBounds(30,260,200,35);
            billType.setFont(font);
            p.add(billType);

            BillType = new JComboBox(BILL_TYPE);
            BillType.setBounds(230,260,300,35);
            BillType.setBorder(null);
            BillType.setBackground(Color.white);
            BillType.setFont(font);
            p.add(BillType);


            // Create Bill Day Input And Label Field.
            days = new JLabel("Days :");
            days.setBounds(30,310,200,35);
            days.setFont(font);
            p.add(days);

            Days = new JLabel("30 DAYS");
            Days.setBounds(230,310,300,35);
            Days.setFont(font);
            p.add(Days);


            // Add Notice Section Input And Label Field.
            notes = new JLabel("Note :");
            notes.setBounds(30,350,200,35);
            notes.setFont(font);
            p.add(notes);

            Notes = new JLabel("By Default Bill Is Calculated For 30 Days.");
            Notes.setBounds(230,350,350,35);
            Notes.setFont(new Font("Arial",Font.BOLD,16));
            p.add(Notes);


            // Create Submit Button.
            Submit = new JButton("Submit");
            Submit.setBounds(200,405,150,50);
            Submit.addActionListener(this);
            Submit.setIcon(new ImageIcon(NEXT1));
            Submit.setForeground(Color.blue);
            Submit.setBorder(null);
            Submit.setBackground(null);
            Submit.setFont(font);
            p.add(Submit);


            setVisible(true);
        }


        // Override The ActionListener Method.
        @Override
        public void actionPerformed(ActionEvent e){

            // Submit Button Declaration.
            if(e.getSource()==Submit){
                String umeter = Number.getText(), ulocation =(String) Location.getSelectedItem(), utype = (String)MeterType.getSelectedItem(),
                        ucode = (String)Code.getSelectedItem(),ubilltype = (String)BillType.getSelectedItem(), uday = "30";
                String Query = "insert into meterinfo values('"+umeter+"', '"+ulocation+"', '"+utype+"', '"+ucode+"', '"+ubilltype+"', '"+uday+"')";
                try{
                    int x = JDBC.getConnectionJDBC().prepareStatement(Query).executeUpdate();
                    if(x>0){
                        JOptionPane.showMessageDialog(this,"Data Successfully Insert!");
                        this.dispose();
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
