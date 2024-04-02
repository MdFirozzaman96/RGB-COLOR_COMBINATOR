
package COLOR_MAKER;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class ColorMaker extends JFrame implements ChangeListener,ActionListener{
    
    JSlider red,green,blue;
    JLabel redLabel,greenLabel,blueLabel;
    JTextField redTxt,greenTxt,blueTxt; 
    JPanel panel;
    JButton colorChooser;
    
    public ColorMaker()
    {
        iconImage();
        createFrame();
        createSlider();
        createLabel();
        createTxtField();
        createPanel();
        createCursor();
        createButton();
        addContainer();
        addAction();
    }
    
    public Font createFont(int size)
    {
        Font f=new Font("Times New Roman",Font.BOLD,size);
        return f;
    }
    
    private ImageIcon iconImage()
    {
        ImageIcon icon=new ImageIcon(getClass().getResource("Md_Firozzaman.png"));
        return icon;
    }
    private void createFrame()
    {
        this.setSize(1000,730);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("RGB COLOR COMBINATOR");
        this.setIconImage(iconImage().getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        
    }
    private void createSlider()
    {
        red=new JSlider(0,255,0);
        green=new JSlider(0,255,0);
        blue=new JSlider(0,255,0);
        
        red.setBounds(80,50,700,50);
        green.setBounds(80,140,700,50);
        blue.setBounds(80,230,700,50);
        
        red.setMinorTickSpacing(2);
        red.setMajorTickSpacing(10);
        red.setPaintTicks(true);
        red.setPaintLabels(true);
        red.setBackground(Color.CYAN);
        
        green.setMinorTickSpacing(2);
        green.setMajorTickSpacing(10);
        green.setPaintTicks(true);
        green.setPaintLabels(true);
        green.setBackground(Color.CYAN);
        
        blue.setMinorTickSpacing(2);
        blue.setMajorTickSpacing(10);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);
        blue.setBackground(Color.CYAN);
        
        
    }
    private void createLabel()
    {
        redLabel=new JLabel("RED");
        greenLabel=new JLabel("GREEN");
        blueLabel=new JLabel("BLUE");
        
        redLabel.setBounds(10,40,60,40);
        greenLabel.setBounds(10,130,60,40);
        blueLabel.setBounds(10,220,60,40);
        
        redLabel.setFont(createFont(16));
        greenLabel.setFont(createFont(16));
        blueLabel.setFont(createFont(16));
        
        redLabel.setForeground(Color.RED);
        greenLabel.setForeground(Color.GREEN);
        blueLabel.setForeground(Color.BLUE);
    }
    private void createTxtField()
    {
        redTxt=new JTextField();
        greenTxt=new JTextField();
        blueTxt=new JTextField();
        
        redTxt.setBounds(800,40,70,50);
        greenTxt.setBounds(800,130,70,50);
        blueTxt.setBounds(800,220,70,50);
        
        redTxt.setFont(createFont(20));
        greenTxt.setFont(createFont(20));
        blueTxt.setFont(createFont(20));
        
        redTxt.setForeground(Color.RED);
        greenTxt.setForeground(Color.GREEN);
        blueTxt.setForeground(Color.BLUE);
    }
    private void createPanel()
    {
        panel=new JPanel();
        panel.setBounds(400,350,470,300);
        panel.setBackground(Color.yellow);
    }
    private Cursor createCursor()
    {
        Cursor c=new Cursor(Cursor.HAND_CURSOR);
        return c;
    }
    private void createButton()
    {
        colorChooser=new JButton("Choose A Color");
        colorChooser.setBounds(50,400,200,40);
        colorChooser.setBackground(Color.LIGHT_GRAY);
        colorChooser.setForeground(Color.WHITE);
        colorChooser.setFont(createFont(20));
        colorChooser.setCursor(createCursor());
    }
    private void addContainer()
    {
        Container c=this.getContentPane();
        c.setBackground(Color.CYAN);
        
        c.add(red);
        c.add(green);
        c.add(blue);
        
        c.add(redLabel);
        c.add(greenLabel);
        c.add(blueLabel);
        
        c.add(redTxt);
        c.add(greenTxt);
        c.add(blueTxt);
        
        c.add(panel);
        
        c.add(colorChooser);
       
    }
    
    private void addAction()
    {
        red.addChangeListener(this);
        green.addChangeListener(this);
        blue.addChangeListener(this);
        
        colorChooser.addActionListener(this);
    }
    
    @Override
    public void stateChanged(ChangeEvent ce)
    {
        int redValue=red.getValue();
        int greenValue=green.getValue();
        int blueValue=blue.getValue();
        
        redTxt.setText(""+redValue);
        greenTxt.setText(""+greenValue);
        blueTxt.setText(""+blueValue);
        
        panel.setBackground(new Color(redValue,greenValue,blueValue));
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Color color=JColorChooser.showDialog(null,"Choose A Color",Color.WHITE);
        panel.setBackground(color);
    }
    
    public static void main(String[] args) {
        
        ColorMaker obj = new ColorMaker();
    }

}
