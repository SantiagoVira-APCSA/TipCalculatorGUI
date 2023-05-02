import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainForm extends JFrame implements ActionListener, KeyListener {
    private JPanel main;
    private JTextField PeopleInput;
    private JTextField TipInput;
    private JTextField BillInput;
    private JButton peoplem;
    private JButton peoplep;
    private JButton tipm;
    private JButton tipp;
    private JButton billm;
    private JButton billp;
    private JLabel TipAmount;
    private JLabel TotalAmt;
    private TipCalculator calc;

    public MainForm() {
        createUIComponents();
        calc = new TipCalculator(0, 0, 1);
    }

    private void createUIComponents() {
        setContentPane(main);
        setTitle("Tip Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        billm.addActionListener(this);
        billp.addActionListener(this);
        tipm.addActionListener(this);
        tipp.addActionListener(this);
        peoplem.addActionListener(this);
        peoplep.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;

            try {
                if (button.equals(billp)) {
                    double newBill = Double.parseDouble(BillInput.getText()) + 1;
                    calc.setBill(newBill);
                    BillInput.setText("" + newBill);
                } else if (button.equals(billm)) {
                    double newBill = Double.parseDouble(BillInput.getText()) - 1;
                    calc.setBill(newBill);
                    BillInput.setText("" + newBill);
                } else if (button.equals(tipp)) {
                    int newTip = Integer.parseInt(TipInput.getText()) + 1;
                    calc.setTipPercentage(newTip);
                    TipInput.setText("" + newTip);
                } else if (button.equals(tipm)) {
                    int newTip = Integer.parseInt(TipInput.getText()) - 1;
                    calc.setTipPercentage(newTip);
                    TipInput.setText("" + newTip);
                } else if (button.equals(peoplep)) {
                    int newPeople = Integer.parseInt(PeopleInput.getText()) + 1;
                    calc.setNumberOfPeople(newPeople);
                    PeopleInput.setText("" + newPeople);
                } else if (button.equals(peoplem)) {
                    int newPeople = Integer.parseInt(PeopleInput.getText()) - 1;
                    calc.setNumberOfPeople(newPeople);
                    PeopleInput.setText("" + newPeople);
                }
            } catch (Exception er) {
                System.out.println("error because input is bad");
                throw er;
            }

            TipAmount.setText("" + calc.getTip());
            TotalAmt.setText("" + calc.getBill());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
