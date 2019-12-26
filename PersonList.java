import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PersonList {
    public static void main(String [] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });

    }
    }
    class Frame extends JFrame{

    public JPanel panel;
    public JButton addButton;
    public JButton printButton;
    public JLabel firstLabel;
    public JLabel lastLabel;
    public JTextArea textArea;
    public JTextField firstField;
    public  JTextField lastField;
    public ArrayList<Person> people = new ArrayList<Person>();

    public Frame(){
        super("My app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800,300));

        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        firstLabel = new JLabel("First name");
        lastLabel = new JLabel("Last name");

        firstField = new JTextField(10);
        lastField = new JTextField(12);

        printButton = new JButton("Display people");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == printButton){
                    for (Person p: people
                         ) {
                        textArea.append(p+"\n");
                    }
                }
            }
        });

        addButton = new JButton("Add person");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addButton) {
                    String firstName = firstField.getText();
                    String lastName = lastField.getText();
                    people.add(new Person(firstName, lastName));
                    firstField.setText("");
                    lastField.setText("");
                }
            }
        });

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(firstLabel);
        panel.add(firstField);
        panel.add(lastLabel);
        panel.add(lastField);
        panel.add(printButton);
        panel.add(addButton);

        textArea = new JTextArea();

        add(panel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        setVisible(true);


        }
    }

    class Person{
    public String firstName;
    public String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString(){
        return lastName + ", " + firstName;

    }

    }

