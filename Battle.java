import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

public class Battle extends JFrame {
    private double speed;
    private double CR;
    private boolean slow;
    private boolean outsped;
    private double topSpeed;

    public Battle(double x, double y, boolean z, boolean a){
        speed = x;
        CR = y;
        slow = z;
        outsped = a;
        if(outsped) {
            if(slow){
                CR *= 0.01;
                topSpeed = (7*CR*speed - 7*speed + speed*Math.sqrt(49*CR*CR + 22*CR + 729))/20;
            }
            else {
                topSpeed = speed * CR + speed;
            }
        }
        else{
            topSpeed = speed;
        }
    }

    public void createBattle(){
        //Declarations
        Font standard = new Font("Lucida Sans Typewriter", Font.PLAIN, 20);
        Font small = new Font("Lucida Sans Typewriter", Font.PLAIN, 10);
        Font large = new Font("Lucida Sans Typewriter", Font.PLAIN, 30);

        boolean constantSwap = true;
        JFrame f = new JFrame("Battle");
        f.setSize(1000,600);
        f.setLocation(50,50);
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("Images/arenaface.png"));
        f.setIconImage(image.getImage());

        JPanel p = new JPanel();
        p.setOpaque(true);
        p.setBackground(Color.GRAY);
        p.setLayout(null);
        f.add(p);

        //<editor-fold desc="Cr Editables on Left Side">
        JTextArea CRynit1 = new JTextArea();
        JTextArea CRynit2 = new JTextArea();
        JTextArea CRynit3 = new JTextArea();
        JTextArea CRynit4 = new JTextArea();
        JTextArea CRtnit1 = new JTextArea();
        JTextArea CRtnit2 = new JTextArea();
        JTextArea CRtnit3 = new JTextArea();
        JTextArea CRtnit4 = new JTextArea();
        CRynit1.setBounds(200, 75, 40,25);
        CRynit1.setBackground(Color.decode("#E29796"));
        CRynit1.setFont(standard);
        CRynit2.setBounds(200, 125, 40,25);
        CRynit2.setBackground(Color.decode("#E2BD96"));
        CRynit2.setFont(standard);
        CRynit3.setBounds(200, 175, 40,25);
        CRynit3.setBackground(Color.decode("#E2E096"));
        CRynit3.setFont(standard);
        CRynit4.setBounds(200, 225, 40,25);
        CRynit4.setBackground(Color.decode("#BFE296"));
        CRynit4.setFont(standard);
        CRtnit1.setBounds(200, 300, 40,25);
        CRtnit1.setBackground(Color.decode("#96E2DC"));
        CRtnit1.setFont(standard);
        CRtnit2.setBounds(200, 350, 40,25);
        CRtnit2.setBackground(Color.decode("#96A0E2"));
        CRtnit2.setFont(standard);
        CRtnit3.setBounds(200, 400, 40,25);
        CRtnit3.setBackground(Color.decode("#B196E2"));
        CRtnit3.setFont(standard);
        CRtnit4.setBounds(200, 450, 40,25);
        CRtnit4.setBackground(Color.decode("#FFFFFF"));
        CRtnit4.setFont(standard);
        //</editor-fold>
        //<editor-fold desc="CR Bar Input">
        JSlider barYnit1 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        JSlider barYnit2 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        JSlider barYnit3 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        JSlider barYnit4 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        JSlider barTnit1 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        JSlider barTnit2 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        JSlider barTnit3 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        JSlider barTnit4 = new JSlider(JSlider.HORIZONTAL, 0, 100,75);
        barYnit1.setBounds(250, 75, 300, 50);
        barYnit1.setPaintTrack(true);
        barYnit1.setPaintTicks(true);
        barYnit1.setPaintLabels(true);
        barYnit1.setMajorTickSpacing(20);
        barYnit1.setMinorTickSpacing(1);
        barYnit2.setBounds(250, 125, 300, 50);
        barYnit2.setPaintTrack(true);
        barYnit2.setPaintTicks(true);
        barYnit2.setPaintLabels(true);
        barYnit2.setMajorTickSpacing(20);
        barYnit2.setMinorTickSpacing(1);
        barYnit3.setBounds(250, 175, 300, 50);
        barYnit3.setPaintTrack(true);
        barYnit3.setPaintTicks(true);
        barYnit3.setPaintLabels(true);
        barYnit3.setMajorTickSpacing(20);
        barYnit3.setMinorTickSpacing(1);
        barYnit4.setBounds(250, 225, 300, 50);
        barYnit4.setPaintTrack(true);
        barYnit4.setPaintTicks(true);
        barYnit4.setPaintLabels(true);
        barYnit4.setMajorTickSpacing(20);
        barYnit4.setMinorTickSpacing(1);
        barTnit1.setBounds(250, 300, 300, 50);
        barTnit1.setPaintTrack(true);
        barTnit1.setPaintTicks(true);
        barTnit1.setPaintLabels(true);
        barTnit1.setMajorTickSpacing(20);
        barTnit1.setMinorTickSpacing(1);
        barTnit2.setBounds(250, 350, 300, 50);
        barTnit2.setPaintTrack(true);
        barTnit2.setPaintTicks(true);
        barTnit2.setPaintLabels(true);
        barTnit2.setMajorTickSpacing(20);
        barTnit2.setMinorTickSpacing(1);
        barTnit3.setBounds(250, 400, 300, 50);
        barTnit3.setPaintTrack(true);
        barTnit3.setPaintTicks(true);
        barTnit3.setPaintLabels(true);
        barTnit3.setMajorTickSpacing(20);
        barTnit3.setMinorTickSpacing(1);
        barTnit4.setBounds(250, 450, 300, 50);
        barTnit4.setPaintTrack(true);
        barTnit4.setPaintTicks(true);
        barTnit4.setPaintLabels(true);
        barTnit4.setMajorTickSpacing(20);
        barTnit4.setMinorTickSpacing(1);
        //</editor-fold>
        //<editor-fold desc="Turn2 Checkboxes">
        JCheckBox turn2Tnit1 = new JCheckBox("T2");
        JCheckBox turn2Tnit2 = new JCheckBox("T2");
        JCheckBox turn2Tnit3 = new JCheckBox("T2");
        JCheckBox turn2Tnit4 = new JCheckBox("T2");
        turn2Tnit1.setBounds(155, 300, 40, 25);
        turn2Tnit2.setBounds(155, 350, 40, 25);
        turn2Tnit3.setBounds(155, 400, 40, 25);
        turn2Tnit4.setBounds(155, 450, 40, 25);
        turn2Tnit1.setVisible(true);
        turn2Tnit2.setVisible(true);
        turn2Tnit3.setVisible(true);
        turn2Tnit4.setVisible(true);
        //</editor-fold>
        //<editor-fold desc="Speeds">
        JTextArea speedYnit1 = new JTextArea();
        JTextArea speedYnit2 = new JTextArea();
        JTextArea speedYnit3 = new JTextArea();
        JTextArea speedYnit4 = new JTextArea();
        JTextArea speedTnit1 = new JTextArea();
        JTextArea speedTnit2 = new JTextArea();
        JTextArea speedTnit3 = new JTextArea();
        JTextArea speedTnit4 = new JTextArea();
        speedYnit1.setFont(standard);
        speedYnit2.setFont(standard);
        speedYnit3.setFont(standard);
        speedYnit4.setFont(standard);
        speedTnit1.setFont(standard);
        speedTnit2.setFont(standard);
        speedTnit3.setFont(standard);
        speedTnit4.setFont(standard);
        speedYnit1.setEditable(false);
        speedYnit2.setEditable(false);
        speedYnit3.setEditable(false);
        speedYnit4.setEditable(false);
        speedTnit1.setEditable(false);
        speedTnit2.setEditable(false);
        speedTnit3.setEditable(false);
        speedTnit4.setEditable(false);
        speedYnit1.setBounds(555, 75, 40, 25);
        speedYnit2.setBounds(555, 125, 40, 25);
        speedYnit3.setBounds(555, 175, 40, 25);
        speedYnit4.setBounds(555, 225, 40, 25);
        speedTnit1.setBounds(555, 300, 40, 25);
        speedTnit2.setBounds(555, 350, 40, 25);
        speedTnit3.setBounds(555, 400, 40, 25);
        speedTnit4.setBounds(555, 450, 40, 25);
        //</editor-fold>
        //<editor-fold desc="Unit Names">
        JTextArea unit1 = new JTextArea("Red");
        JTextArea unit2 = new JTextArea("Orange");
        JTextArea unit3 = new JTextArea("Yellow");
        JTextArea unit4 = new JTextArea("Green");
        JTextArea unit5 = new JTextArea("Aqua");
        JTextArea unit6 = new JTextArea("Blue");
        JTextArea unit7 = new JTextArea("Purple");
        JTextArea unit8 = new JTextArea("White");
        unit1.setBounds(50, 75, 150, 25);
        unit2.setBounds(50, 125, 150, 25);
        unit3.setBounds(50, 175, 150, 25);
        unit4.setBounds(50, 225, 150, 25);
        unit5.setBounds(50, 300, 100, 25);
        unit6.setBounds(50, 350, 100, 25);
        unit7.setBounds(50, 400, 100, 25);
        unit8.setBounds(50, 450, 100, 25);
        unit1.setFont(standard);
        unit2.setFont(standard);
        unit3.setFont(standard);
        unit4.setFont(standard);
        unit5.setFont(standard);
        unit6.setFont(standard);
        unit7.setFont(standard);
        unit8.setFont(standard);
        //</editor-fold>
        //<editor-fold desc="Labels for Enemies">
        JTextArea crLabel = new JTextArea("Allies");
        crLabel.setBounds(10, 25, 70, 25);
        crLabel.setFont(standard);
        crLabel.setEditable(false);
        crLabel.setBackground(Color.decode("#616161"));
        JTextArea enemyCR = new JTextArea("Enemies");
        enemyCR.setFont(standard);
        enemyCR.setBounds(10, 260, 85, 25);
        enemyCR.setEditable(false);
        enemyCR.setBackground(Color.decode("#616161"));
        JTextArea speedsLabel = new JTextArea("Speeds");
        speedsLabel.setFont(standard);
        speedsLabel.setEditable(false);
        speedsLabel.setBackground(Color.decode("#616161"));
        speedsLabel.setBounds(550, 40, 70,25);
        JTextArea names = new JTextArea("Names");
        names.setFont(standard);
        names.setEditable(false);
        names.setBackground(Color.decode("#616161"));
        names.setBounds(100, 40, 60, 25);
        JTextArea crInput = new JTextArea("CR");
        crInput.setFont(standard);
        crInput.setEditable(false);
        crInput.setBackground(Color.decode("#616161"));
        crInput.setBounds(200, 40, 25,25);
        JTextArea crBarTitle = new JTextArea("CR Bars");
        crBarTitle.setFont(standard);
        crBarTitle.setEditable(false);
        crBarTitle.setBackground(Color.decode("#616161"));
        crBarTitle.setBounds(250, 40, 90, 25);
        //</editor-fold>
        //<editor-fold desc="Instructions">
        JTextArea instructions = new JTextArea("From your snapshot, enter in the combat readiness of your units and enemy units on the left, and indicate"
                +" for the enemy units whether it is their first or second turn. This is done for the speed calculation of all units. Change the unit names as you see fit.");
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setFont(small);
        /*
        instructions.setBounds(100, 25, 800, 25);
         */
        //</editor-fold>

        JTextArea function1Text1 = new JTextArea("Will unit");
        JTextArea function1Text2 = new JTextArea("at");
        JTextArea function1Text3 = new JTextArea("Combat Readiness");
        JTextArea function1Text4 = new JTextArea("outspeed");
        JTextArea function1Text5 = new JTextArea("at");
        JTextArea function1Text6 = new JTextArea("Combat Readiness?");
        JTextArea function1Text7 = new JTextArea();
        JTextArea function1Text8 = new JTextArea();
        function1Text5.setEditable(false);
        function1Text6.setEditable(false);
        function1Text7.setEditable(false);
        function1Text8.setEditable(false);
        function1Text1.setEditable(false);
        function1Text2.setEditable(false);
        function1Text3.setEditable(false);
        function1Text4.setEditable(false);

        JButton function1Enter = new JButton("Enter");
        function1Enter.setBounds(650, 390, 125, 60);
        function1Enter.setFont(large);
        function1Enter.setBackground(Color.white);

        JButton help = new JButton("Instructions");
        help.setBackground(Color.decode("#8DBA8B"));
        help.setFont(large);
        help.setBounds(660, 10, 300, 60);

        JSlider display1 = new JSlider(JSlider.VERTICAL, 0, 100, 75);
        JSlider display2 = new JSlider(JSlider.VERTICAL, 0, 100, 75);
        JTextArea display3 = new JTextArea();
        display3.setEditable(false);
        display3.setBounds(650, 450, 300, 100);
        display3.setBackground(Color.decode("#D2F4F0"));
        display3.setFont(standard);
        display3.setLineWrap(true);
        display3.setWrapStyleWord(true);
        JCheckBox isSlowed1 = new JCheckBox("Is slowed");
        JCheckBox isSlowed2 = new JCheckBox("Is slowed");
        JCheckBox isSped1 = new JCheckBox("Speed Buff");
        JCheckBox isSped2 = new JCheckBox("Speed Buff");

        String[] yunits = new String[]{unit1.getText(),unit2.getText(),unit3.getText(),unit4.getText(),unit5.getText(),unit6.getText(),unit7.getText(),unit8.getText()};
        JComboBox<String> dropDown1 = new JComboBox<>(yunits);
        String[] tunits = new String[]{unit1.getText(),unit2.getText(),unit3.getText(),unit4.getText(),unit5.getText(),unit6.getText(),unit7.getText(),unit8.getText()};
        JComboBox<String> dropDown2 = new JComboBox<>(tunits);

        JTextArea function1EditableText1 = new JTextArea();
        JTextArea function1EditableText2 = new JTextArea();

        function1Text1.setBounds(700, 75, 120, 25);
        function1Text1.setFont(standard);
        function1Text1.setBackground(Color.decode("#B8E3E2"));
        dropDown1.setBounds(820,75,150, 25);
        dropDown1.setFont(standard);
        dropDown1.setBackground(Color.decode("#D2F4F0"));
        function1Text2.setBounds(700, 100, 30, 25);
        function1Text2.setFont(standard);
        function1Text2.setBackground(Color.decode("#B8E3E2"));
        function1EditableText1.setFont(standard);
        function1EditableText1.setBounds(730, 100, 40, 25);
        function1EditableText1.setBackground(Color.decode("#D2F4F0"));
        function1Text3.setBounds(770, 100, 200, 25);
        function1Text3.setBackground(Color.decode("#B8E3E2"));
        function1Text3.setFont(standard);
        function1Text4.setBounds(700, 125, 100, 25);
        function1Text4.setBackground(Color.decode("#B8E3E2"));
        function1Text4.setFont(standard);
        dropDown2.setBounds(800, 125, 150, 25);
        dropDown2.setFont(standard);
        dropDown2.setBackground(Color.decode("#D2F4F0"));
        function1Text5.setBounds(700, 150, 30, 25);
        function1Text5.setFont(standard);
        function1Text5.setBackground(Color.decode("#B8E3E2"));
        function1EditableText2.setBounds(730, 150, 40, 25);
        function1EditableText2.setFont(standard);
        function1EditableText2.setBackground(Color.decode("#D2F4F0"));
        function1Text6.setBounds(770, 150, 200, 25);
        function1Text6.setFont(standard);
        function1Text6.setBackground(Color.decode("#B8E3E2"));
        isSlowed1.setBounds(650, 225, 100, 25);
        isSlowed1.setVisible(true);
        isSped1.setBounds(650, 250, 100, 25);
        isSped1.setVisible(true);
        display1.setBounds(750, 225, 50, 150);
        display1.setPaintTrack(true);
        display1.setPaintTicks(true);
        display1.setPaintLabels(true);
        display1.setMajorTickSpacing(20);
        display1.setMinorTickSpacing(1);
        display1.setPreferredSize(new Dimension(50, 150));
        isSlowed2.setBounds(800, 225, 100, 25);
        isSlowed2.setVisible(true);
        isSped2.setBounds(800, 250, 100, 25);
        isSped2.setVisible(true);
        display2.setBounds(900, 225, 50, 150);
        display2.setPaintTrack(true);
        display2.setPaintTicks(true);
        display2.setPaintLabels(true);
        display2.setMajorTickSpacing(20);
        display2.setMinorTickSpacing(1);
        display2.setPreferredSize(new Dimension(50,150));
        function1Text7.setBounds(700, 190, 100, 25);
        function1Text8.setBounds(850,190, 100, 25);
        function1Text7.setFont(standard);
        function1Text8.setFont(standard);
        function1Text7.setEditable(false);
        function1Text8.setEditable(false);
        function1Text7.setBackground(Color.decode("#B8E3E2"));
        function1Text8.setBackground(Color.decode("#B8E3E2"));

        //<editor-fold desc="CR Text Box Focus">
        class cr1textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRynit1.getText().trim()), topSpeed, speed, speedYnit1,false, false);
                barYnit1.setValue(Integer.parseInt(CRynit1.getText().trim()));
            }
        }
        class cr2textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRynit2.getText().trim()), topSpeed, speed, speedYnit2,false,false);
                barYnit2.setValue(Integer.parseInt(CRynit2.getText().trim()));
            }
        }
        class cr3textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRynit3.getText().trim()), topSpeed, speed, speedYnit3,false,false);
                barYnit3.setValue(Integer.parseInt(CRynit3.getText().trim()));
            }
        }
        class cr4textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRynit4.getText().trim()), topSpeed, speed, speedYnit4,false,false);
                barYnit4.setValue(Integer.parseInt(CRynit4.getText().trim()));
            }
        }
        class cr5textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRtnit1.getText().trim()), topSpeed, speed, speedTnit1,turn2Tnit1.isSelected(), slow);
                barTnit1.setValue(Integer.parseInt(CRtnit1.getText().trim()));
            }
        }
        class cr6textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRtnit2.getText().trim()), topSpeed, speed, speedTnit2,turn2Tnit2.isSelected(), slow);
                barTnit2.setValue(Integer.parseInt(CRtnit2.getText().trim()));
            }
        }
        class cr7textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRtnit3.getText().trim()), topSpeed, speed, speedTnit3, turn2Tnit3.isSelected(), slow);
                barTnit3.setValue(Integer.parseInt(CRtnit3.getText().trim()));
            }
        }
        class cr8textfocus implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                calculateSpeeds(Double.parseDouble(CRtnit4.getText().trim()), topSpeed, speed, speedTnit4,turn2Tnit4.isSelected(), slow);
                barTnit4.setValue(Integer.parseInt(CRtnit4.getText().trim()));
            }
        }
        //</editor-fold>
        //<editor-fold desc="Bar Text Box Focus">
        class cr1barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRynit1.setText(String.valueOf(barYnit1.getValue()));
                calculateSpeeds(barYnit1.getValue(), topSpeed, speed, speedYnit1, false,false);
            }
        }
        class cr2barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRynit2.setText(String.valueOf(barYnit2.getValue()));
                calculateSpeeds(barYnit2.getValue(), topSpeed, speed, speedYnit2, false,false);
            }
        }
        class cr3barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRynit3.setText(String.valueOf(barYnit3.getValue()));
                calculateSpeeds(barYnit3.getValue(), topSpeed, speed, speedYnit3, false,false);
            }
        }
        class cr4barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRynit4.setText(String.valueOf(barYnit4.getValue()));
                calculateSpeeds(barYnit4.getValue(), topSpeed, speed, speedYnit4, false,false);
            }
        }
        class cr5barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRtnit1.setText(String.valueOf(barTnit1.getValue()));
                calculateSpeeds(barTnit1.getValue(), topSpeed, speed, speedTnit1, turn2Tnit1.isSelected(), slow);
            }
        }
        class cr6barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRtnit2.setText(String.valueOf(barTnit2.getValue()));
                calculateSpeeds(barTnit2.getValue(), topSpeed, speed, speedTnit2,turn2Tnit2.isSelected(),slow);
            }
        }
        class cr7barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRtnit3.setText(String.valueOf(barTnit3.getValue()));
                calculateSpeeds(barTnit3.getValue(), topSpeed, speed, speedTnit3,turn2Tnit3.isSelected(),slow);
            }
        }
        class cr8barfocus implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                CRtnit4.setText(String.valueOf(barTnit4.getValue()));
                calculateSpeeds(barTnit4.getValue(), topSpeed, speed, speedTnit4,turn2Tnit4.isSelected(),slow);
            }
        }
        //</editor-fold>
        //<editor-fold desc="Adding Actionlisteners to Above">
        CRynit1.addFocusListener(new cr1textfocus());
        CRynit2.addFocusListener(new cr2textfocus());
        CRynit3.addFocusListener(new cr3textfocus());
        CRynit4.addFocusListener(new cr4textfocus());
        CRtnit1.addFocusListener(new cr5textfocus());
        CRtnit2.addFocusListener(new cr6textfocus());
        CRtnit3.addFocusListener(new cr7textfocus());
        CRtnit4.addFocusListener(new cr8textfocus());

        barYnit1.addChangeListener(new cr1barfocus());
        barYnit2.addChangeListener(new cr2barfocus());
        barYnit3.addChangeListener(new cr3barfocus());
        barYnit4.addChangeListener(new cr4barfocus());
        barTnit1.addChangeListener(new cr5barfocus());
        barTnit2.addChangeListener(new cr6barfocus());
        barTnit3.addChangeListener(new cr7barfocus());
        barTnit4.addChangeListener(new cr8barfocus());
        //</editor-fold>
        //<editor-fold desc="Name focus">
        class name1 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(0);
                dropDown1.insertItemAt(unit1.getText(), 0);
                dropDown2.removeItemAt(0);
                dropDown2.insertItemAt(unit1.getText(), 0);
            }
        }
        class name2 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(1);
                dropDown1.insertItemAt(unit2.getText(), 1);
                dropDown2.removeItemAt(1);
                dropDown2.insertItemAt(unit2.getText(), 1);
            }
        }
        class name3 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(2);
                dropDown1.insertItemAt(unit3.getText(), 2);
                dropDown2.removeItemAt(2);
                dropDown2.insertItemAt(unit3.getText(), 2);
            }
        }
        class name4 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(3);
                dropDown1.insertItemAt(unit4.getText(), 3);
                dropDown2.removeItemAt(3);
                dropDown2.insertItemAt(unit4.getText(), 3);
            }
        }
        class name5 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(4);
                dropDown1.insertItemAt(unit5.getText(), 4);
                dropDown2.removeItemAt(4);
                dropDown2.insertItemAt(unit5.getText(), 4);
            }
        }
        class name6 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(5);
                dropDown1.insertItemAt(unit6.getText(), 5);
                dropDown2.removeItemAt(5);
                dropDown2.insertItemAt(unit6.getText(), 5);
            }
        }
        class name7 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(6);
                dropDown1.insertItemAt(unit7.getText(), 6);
                dropDown2.removeItemAt(6);
                dropDown2.insertItemAt(unit7.getText(), 6);
            }
        }
        class name8 implements FocusListener{
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                dropDown1.removeItemAt(7);
                dropDown1.insertItemAt(unit8.getText(), 7);
                dropDown2.removeItemAt(7);
                dropDown2.insertItemAt(unit8.getText(), 7);
            }
        }
        unit1.addFocusListener(new name1());
        unit2.addFocusListener(new name2());
        unit3.addFocusListener(new name3());
        unit4.addFocusListener(new name4());
        unit5.addFocusListener(new name5());
        unit6.addFocusListener(new name6());
        unit7.addFocusListener(new name7());
        unit8.addFocusListener(new name8());
        //</editor-fold>
        class instruct implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JFrame helper = new JFrame("Instructions");
                helper.setLocation(600,50);
                helper.setSize(513, 313);
                helper.setVisible(true);
                ImageIcon image1 = new ImageIcon(getClass().getClassLoader().getResource("Images/helper.png"));
                helper.setIconImage(image1.getImage());

                JPanel helpPane = new JPanel();
                helpPane.setBackground(Color.gray);
                helpPane.setOpaque(true);
                helpPane.setLayout(null);
                helper.add(helpPane);

                JTextArea order = new JTextArea("Instructions:\n1. Manually enter the CR of each unit in the battle you are fighting OR slide the CR bar to match the unit's CR."+
                        "The speeds of each unit will be calculated based on the info entered on the previous window.\n"+
                        "You may also change the names of the units. This portion of the window can be used as guild war info screenshots " +
                        "or to merely record a battle against a specific individual.\nIf you marked outsped on the previous window, check the T2 box by the units who outsped you.\n"
                        +"2. During the battle, to check whether one unit will lap another, pick the name of the unit at the right.\nThen enter in the combat readiness OR drag the combat readiness bar below to set the combat readiness.\nCheck the slow/speed buff boxes per unit as needed, then hit enter.\nMore functions may be added as needed, such as CR pushes, revenge set with hp%, etc.");
                order.setBounds(25, 25, 450, 225);
                order.setFont(small);
                order.setBackground(Color.decode("#CDD3DF"));
                order.setWrapStyleWord(true);
                order.setLineWrap(true);
                order.setEditable(false);
                helpPane.add(order);
            }
        }
        help.addActionListener(new instruct());
        class text7ScalerToDisplay implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                function1EditableText1.setText(String.valueOf(display1.getValue()).trim());
            }
        }
        class text8ScalerToDisplay implements ChangeListener{
            public void stateChanged(ChangeEvent e){
                function1EditableText2.setText(String.valueOf(display2.getValue()).trim());
            }
        }
        display1.addChangeListener(new text7ScalerToDisplay());
        display2.addChangeListener(new text8ScalerToDisplay());

        class enterButton1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                function1Text7.setText(dropDown1.getSelectedItem().toString().trim());
                function1Text8.setText(dropDown2.getSelectedItem().toString().trim());
                display1.setValue(Integer.parseInt(function1EditableText1.getText().trim()));
                display2.setValue(Integer.parseInt(function1EditableText2.getText().trim()));
                Unit myNit = null;
                Unit theirNit = null;
                Unit ynit1 = new Unit(unit1.getText(), Double.parseDouble(speedYnit1.getText()));
                Unit ynit2 = new Unit(unit2.getText(), Double.parseDouble(speedYnit2.getText()));
                Unit ynit3 = new Unit(unit3.getText(), Double.parseDouble(speedYnit3.getText()));
                Unit ynit4 = new Unit(unit4.getText(), Double.parseDouble(speedYnit4.getText()));
                Unit tnit1 = new Unit(unit5.getText(), Double.parseDouble(speedTnit1.getText()));
                Unit tnit2 = new Unit(unit6.getText(), Double.parseDouble(speedTnit2.getText()));
                Unit tnit3 = new Unit(unit7.getText(), Double.parseDouble(speedTnit3.getText()));
                Unit tnit4 = new Unit(unit8.getText(), Double.parseDouble(speedTnit4.getText()));
                Unit[] unitArray = new Unit[]{ynit1, ynit2, ynit3, ynit4, tnit1, tnit2, tnit3, tnit4};
                double myCR = Double.parseDouble(function1EditableText1.getText());
                double theirCR = Double.parseDouble(function1EditableText2.getText());
                for(int i = 0; i < unitArray.length; i++){
                    if((unitArray[i].toString()).equals(dropDown1.getSelectedItem())){
                        myNit = unitArray[i];
                    }
                }
                for(int i = 0; i < unitArray.length; i++){
                    if((unitArray[i].toString()).equals(dropDown2.getSelectedItem())){
                        theirNit = unitArray[i];
                    }
                }
                if(!(myNit == null || theirNit == null)){
                    willOutspeed(myNit.getSpeed(), myCR, theirNit.getSpeed(), theirCR, topSpeed, display1, display2, display3, myNit.toString(), theirNit.toString(), isSlowed1.isSelected(), isSlowed2.isSelected(), isSped1.isSelected(), isSped2.isSelected());
                }
            }
        }
        function1Enter.addActionListener(new enterButton1());

        //SHORTCUT ctrlf
        f.setVisible(true);
        p.setVisible(true);
        p.add(CRynit1);
        p.add(CRynit2);
        p.add(CRynit3);
        p.add(CRynit4);
        p.add(CRtnit1);
        p.add(CRtnit2);
        p.add(CRtnit3);
        p.add(CRtnit4);
        p.add(barYnit1);
        p.add(barYnit2);
        p.add(barYnit3);
        p.add(barYnit4);
        p.add(barTnit1);
        p.add(barTnit2);
        p.add(barTnit3);
        p.add(barTnit4);
        p.add(turn2Tnit1);
        p.add(turn2Tnit2);
        p.add(turn2Tnit3);
        p.add(turn2Tnit4);
        p.add(speedYnit1);
        p.add(speedYnit2);
        p.add(speedYnit3);
        p.add(speedYnit4);
        p.add(speedTnit1);
        p.add(speedTnit2);
        p.add(speedTnit3);
        p.add(speedTnit4);
        p.add(instructions);
        p.add(crLabel);
        p.add(enemyCR);
        p.add(unit1);
        p.add(unit2);
        p.add(unit3);
        p.add(unit4);
        p.add(unit5);
        p.add(unit6);
        p.add(unit7);
        p.add(unit8);
        p.add(speedsLabel);
        p.add(function1Text1);
        p.add(function1Text2);
        p.add(dropDown1);
        p.add(function1Text3);
        p.add(function1EditableText1);
        p.add(function1Text4);
        p.add(dropDown2);
        p.add(function1Text5);
        p.add(function1EditableText2);
        p.add(function1Text6);
        p.add(function1Enter);
        p.add(isSlowed1);
        p.add(isSlowed2);
        p.add(isSped1);
        p.add(isSped2);
        p.add(display1);
        p.add(display2);
        p.add(display3);
        p.add(function1Text7);
        p.add(function1Text8);
        p.add(names);
        p.add(crInput);
        p.add(crBarTitle);
        p.add(help);
    }
    public void calculateSpeeds(double crOfUnit, double topSpeed, double speedOfUnit, JTextArea editThing, boolean outSped, boolean isSlow){
        double speed;
        crOfUnit *= 0.01;
        if(outsped){
            if(outSped){
                speed = ((crOfUnit + 1)/(CR + 1))*topSpeed;
            }
            else{
                speed = crOfUnit*speedOfUnit;
            }
        }
        else {
            speed = crOfUnit*topSpeed;
        }
        editThing.setText(String.valueOf((int)speed).trim());
    }
    public void willOutspeed(double myUnitSpeed, double myUnitCR, double theirUnitSpeed, double theirUnitCR, double fastestSpeed, JSlider crMine, JSlider crTheirs, JTextArea output, String color1, String color2, boolean mySlow, boolean theirSlow, boolean mySped, boolean theirSped){
        if(mySlow){
            myUnitSpeed *= 0.7;
        }
        if(mySped){
            myUnitSpeed *= 1.3;
        }
        if(theirSlow){
            theirUnitSpeed *= 0.7;
        }
        if(theirSped){
            theirUnitSpeed *= 1.3;
        }
        double x = (1 - myUnitCR*0.01)*(fastestSpeed/myUnitSpeed);
        double z = (1 - theirUnitCR*0.01)*(fastestSpeed/theirUnitSpeed);
        if(x>z){
            double y = z*(myUnitSpeed/fastestSpeed) + myUnitCR*0.01;
            crMine.setValue((int)(y*100));
            crTheirs.setValue(100);
            output.setText("No. " + color1 + " will not outspeed " + color2 + " and will be at "+ crMine.getValue() + "% when " + color2 + " takes a turn.");
        }
        else if(x == z){
            output.setText(color1 + " and "+ color2 + " will reach 100% at the same time.");
            crTheirs.setValue(100);
            crMine.setValue(100);
        }
        else{
            double y = x*(theirUnitSpeed/fastestSpeed) + theirUnitCR*0.01;
            crTheirs.setValue((int)(y*100));
            crMine.setValue(100);
            output.setText("Yes. "+color1 + " will outspeed " + color2 + " and "+ color2 + " will be at "+ crTheirs.getValue() + "% when " + color1 + " takes a turn.");
        }
    }
}
