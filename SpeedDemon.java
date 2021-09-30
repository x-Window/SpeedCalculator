import javax.swing.*;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class SpeedDemon extends JFrame{
    private boolean outspedbox = false;
    private boolean slowedbox = false;
    private double unitSpeed;
    private double crOpponent;
    private JButton create;
    private JCheckBox outsped;
    private JCheckBox slowed;
    private JTextArea opponentCR;
    private JTextArea yourUnitSpeed;
    private JTextArea yourUnitLabel;
    private JTextArea opponentCRLabel;
    private JTextArea intro;
    private JFrame f;
    private JPanel p;

    public void setupGUI(){
        //Declarations
        create = new JButton("Create Battle");
        outsped = new JCheckBox("Outsped/Turn 2");
        slowed = new JCheckBox("Speed debuffed");
        opponentCR = new JTextArea();
        yourUnitSpeed = new JTextArea();
        yourUnitLabel = new JTextArea("Speed of your unit\n(whose turn it is)");
        opponentCRLabel = new JTextArea("CR% of opponent's \nobserved fastest unit");
        intro = new JTextArea("Control a battle to your will! \nCalculate whether your unit will outspeed another during a battle after turn 1.");

        Font standard = new Font("Lucida Sans Typewriter", Font.PLAIN, 10);
        Font large = new Font("Lucida Sans Typewriter", Font.PLAIN, 15);

        f = new JFrame("Speed Demon");
        f.setSize(500, 300);
        f.setLocation(100, 50);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("Images/paveldog.png"));
        f.setIconImage(image.getImage());

        p = new JPanel();
        p.setOpaque(true);
        p.setBackground(Color.GRAY);
        p.setLayout(null);
        f.add(p);

        //SetBounds
        create.setBounds(150, 200, 200, 50);
        outsped.setBounds(50, 50, 150, 50);
        slowed.setBounds(50, 125, 150, 50);
        yourUnitSpeed.setBounds(300, 80, 50, 25);
        yourUnitLabel.setBounds(300, 50, 150, 25);
        opponentCR.setBounds(300, 155, 50, 25);
        opponentCRLabel.setBounds(300, 125, 150, 25);
        intro.setBounds(50, 5, 400, 40);

        //Setting
        create.setBackground(Color.WHITE);
        yourUnitLabel.setLineWrap(true);
        opponentCRLabel.setLineWrap(true);
        intro.setLineWrap(true);

        //Fonting
        create.setFont(large);
        outsped.setFont(standard);
        slowed.setFont(standard);
        opponentCR.setFont(large);
        yourUnitSpeed.setFont(large);
        opponentCRLabel.setFont(standard);
        yourUnitLabel.setFont(standard);
        intro.setFont(standard);

        //Adding
        p.add(create);
        p.add(outsped);
        p.add(slowed);
        p.add(yourUnitSpeed);
        p.add(yourUnitLabel);
        p.add(opponentCR);
        p.add(opponentCRLabel);
        p.add(intro);

        //Assign actionlisteners
        outsped.addItemListener(new checkOutsped());
        slowed.addItemListener(new checkSlowed());
        create.addActionListener(new createBattle());

        //SetEditable
        yourUnitLabel.setEditable(false);
        opponentCRLabel.setEditable(false);
        intro.setEditable(false);

        //Setvisible
        f.setVisible(true);
        p.setVisible(true);
        create.setVisible(true);
        outsped.setVisible(true);
        yourUnitSpeed.setVisible(true);
        yourUnitLabel.setVisible(true);
        opponentCR.setVisible(true);
        opponentCRLabel.setVisible(true);
        intro.setVisible(true);

    }
    public static void main(String []args){
        SpeedDemon window = new SpeedDemon();
        window.setupGUI();
    }
    class checkOutsped implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
                outspedbox = true;
            }
            else{
                outspedbox = false;
            }
        }
    }
    class checkSlowed implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            JCheckBox cb = (JCheckBox) e.getSource();
            if(e.getStateChange() == ItemEvent.SELECTED){
                slowedbox = true;
            }
            else{
                slowedbox = false;
            }
        }
    }
    class createBattle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if((isNumeric(yourUnitSpeed.getText().trim()) && outspedbox == false) || (isNumeric(opponentCR.getText().trim()) && outspedbox == true && (isNumeric(yourUnitSpeed.getText().trim())) && Double.parseDouble(opponentCR.getText().trim()) <= 100)){
                unitSpeed = Double.parseDouble(yourUnitSpeed.getText().trim());
                if(isNumeric(opponentCR.getText().trim())){
                    crOpponent = Double.parseDouble(opponentCR.getText().trim());
                    Battle xwindow = new Battle(unitSpeed, crOpponent, slowedbox, outspedbox);
                    xwindow.createBattle();
                }
                else{
                    Battle xwindow = new Battle(unitSpeed, 0, slowedbox, outspedbox);
                    xwindow.createBattle();
                }
            }
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
