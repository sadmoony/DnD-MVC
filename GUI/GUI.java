package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GUI extends javax.swing.JFrame{

    private JPanel panel1;
    private JButton generateCharacterButton;
    private JButton saveJSONButton;
    public static JTextField typeYourNameTextField;
    public static JComboBox comboBox1;
    public static JComboBox comboBox2;
    public static JTextArea textArea1;
    public static JTextArea textArea2;
    public static JTextArea textArea3;
    public static JTextArea textArea4;
    public static JTextArea textArea5;
    public static JTextArea textArea6;
    private JButton saveButton;
    private JButton generateButton;
    private JLabel characterInfoLabel;
    private JLabel classLabel;
    private JLabel raceLabel;
    private JLabel STRLabel;
    private JLabel DEXLabel;
    private JLabel CONLabel;
    private JLabel INTLabel;
    private JLabel WISLabel;
    private JLabel CHALabel;
    private JButton returnButton;
    private JLabel attributesLabel;
    private JLabel nameLabel;
    public static JTextArea textArea8;
    public static JList list1;
    public static JTextPane textPane1;

    public GUI(){
        initComponents();
    }

    private void initComponents(){

        generateCharacterButton = new JButton();
        generateButton = new JButton();
        saveButton = new JButton();
        saveJSONButton = new JButton();
        returnButton = new JButton();

        typeYourNameTextField = new JTextField();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        textArea4 = new JTextArea();
        textArea5 = new JTextArea();
        textArea6 = new JTextArea();
        textArea8 = new JTextArea();

        list1 = new JList();
        textPane1 = new JTextPane();

        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();

        characterInfoLabel = new JLabel();
        nameLabel = new JLabel();
        classLabel = new JLabel();
        raceLabel = new JLabel();
        attributesLabel = new JLabel();
        STRLabel = new JLabel();
        DEXLabel = new JLabel();
        CONLabel = new JLabel();
        INTLabel = new JLabel();
        WISLabel = new JLabel();
        CHALabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("DnD Character Generator");

        characterInfoLabel.setText("Character Info");
        nameLabel.setText("Name");

        typeYourNameTextField.setText("Type your name");
        typeYourNameTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        typeYourNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionPerformed(e);
            }
        });

        classLabel.setText("Class");
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Barbarian", "Paladin"}));

        raceLabel.setText("Race");
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Elf", "Halfling"}));

        attributesLabel.setText("Attributes");

        STRLabel.setText("STR");
        textArea1.setEditable(false);
        textArea1.setText("0");

        DEXLabel.setText("DEX");
        textArea2.setEditable(false);
        textArea2.setText("0");

        CONLabel.setText("CON");
        textArea3.setEditable(false);
        textArea3.setText("0");

        INTLabel.setText("INT");
        textArea4.setEditable(false);
        textArea4.setText("0");

        WISLabel.setText("WIS");
        textArea5.setEditable(false);
        textArea5.setText("0");

        CHALabel.setText("CHA");
        textArea6.setEditable(false);
        textArea6.setText("0");

        generateButton.setText("Generate");
        generateButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Controller.generateStats();
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.runMemento();
            }
        });

        returnButton.setText("Return");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.returnMemento();
            }
        });

        generateCharacterButton.setText("Generate Character");
        generateCharacterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.createCharacter();
            }
        });

        saveJSONButton.setText("Save JSON");
        saveJSONButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Controller.saveJSON();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }



    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
