package view.cashierview;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashierGui extends JFrame implements ActionListener {
    static CashierView cashierView;
    public static final Dimension SCREEN_SIZE = new Dimension(800, 600);
    private JButton RegisterItem = new JButton();
    private JTextField IdText = new JTextField("Enter itemId");
    private JTextArea  productList = new JTextArea();
    JLabel lbl1 = new JLabel("Item ID");
    JLabel lbl2 = new JLabel("Quantity:");

    JTextField field1 = new JTextField(20);
    JTextField field2 = new JTextField( 10);
    JTextField field3 = new JTextField( 10);
    JButton btn1 = new JButton("Register Item");
    JButton btn2 = new JButton("End Sale");
    JButton startBtn = new JButton("Start Sale");
    JButton discountBtn = new JButton("Signal discount request");

    public CashierGui(CashierView cashierView) throws Exception {
        this.cashierView = cashierView;
        createAndShowGUI();
    }
    JTextArea customerDisplay = new JTextArea(10, 20);
    JTextArea cashierDisplay = new JTextArea(20, 20);;
    // lägger till komponenter till panelen
    public void addComponentToPane(Container pane) throws Exception {
        JPanel rootPanel = new JPanel(new MigLayout("fill"));
        JPanel panel = new JPanel ();
        panel.setLayout(new MigLayout("fill"));
        btn1.addActionListener(this::actionPerformed);
        btn2.addActionListener(this::actionPerformed);
        startBtn.addActionListener(this::actionPerformed);
        discountBtn.addActionListener(this::actionPerformed);

        panel.add(new ButtonPanel(),"dock south");
        panel.add(new mainPanel(), "dock center");
        rootPanel.add(panel, "dock north, h 50, gaptop 10");
        pane.add(panel);
    }

    private JPanel createCashierDisplay(JTextArea cashierDisplay){
        JPanel cashierPanel = new JPanel(new MigLayout("fill"));
        cashierPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                cashierPanel.getBorder()));

        return  cashierPanel;
    }
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public void createAndShowGUI() throws Exception {
        //Create and set up the window.
        JFrame frame = new JFrame("Point of sale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setPreferredSize(SCREEN_SIZE);
        //Create and set up the content pane.

        setDefaultLookAndFeelDecorated(true);
        addComponentToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() == btn1)){
            int itemId = Integer.parseInt(field1.getText());
            int quantity;

            if(field2.getText().isEmpty())
                quantity = 1;
            else
                quantity = Integer.parseInt(field2.getText());
            cashierDisplay.setText(cashierView.registerItem(itemId,quantity));
        }

        if(e.getSource() == btn2){
            cashierDisplay.setText(cashierView.endSale());
        }

        if(e.getSource() == startBtn){
            cashierView.startSale();
        }

        if(e.getSource() == discountBtn){
            cashierDisplay.setText(cashierView.signalDiscountRequest(field3.getText()));
        }
    }

    private class ButtonPanel extends JPanel{
        public ButtonPanel(){
            setLayout(new MigLayout("fill"));
            add(btn1, "growx");
            add(startBtn, "growx,wrap");
            add(btn2, "growx,wrap");
            add(discountBtn, " growx");
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.BLACK),
                   getBorder()));
        }
    }

    private class CashierDisplayPanel extends JPanel{
        public CashierDisplayPanel(){
            setLayout(new MigLayout());
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.BLUE),
                    getBorder()));
            add(new JLabel("Cashier Display"),"cell 1 0");
            add(cashierDisplay, "cell 2 0");
        }

    }

    private class mainPanel extends JPanel {
        JPanel riskAssessmentPanel = new JPanel();
        JPanel customerViewPan = new JPanel();
        JPanel CashierViewPan = new JPanel();

        public mainPanel() {
            setLayout(new MigLayout(""));
            riskAssessmentPanel.setLayout(
                    new MigLayout("wrap", "[grow, fill]", "[grow, fill, push][grow, fill, push][grow, fill, push]"));

            CashierViewPan.setLayout(new MigLayout("gap rel 2", "[0:0, grow 60, center][grow 40, left]"));
            CashierViewPan.setBorder(BorderFactory.createTitledBorder("Cashier view"));

            customerViewPan.setLayout(new MigLayout("gap rel 2", "[0:0, grow 60, center][grow 40, left]"));
            customerViewPan.setBorder(BorderFactory.createTitledBorder("Customer view"));


            customerViewPan.add(new JLabel("Customer Display"), "wrap");
            customerViewPan.add(customerDisplay,"push,growy, spany 6");
            customerDisplay.setEditable(false);
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JSeparator(), "growx, span");
            customerViewPan.add(new JLabel("Second Label"));
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JSeparator(), "growx, span");
            customerViewPan.add(new JLabel("This Label is fairly large and long and pushes the text around"));
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");
            customerViewPan.add(new JCheckBox("Checkbox with Label"), "skip, wrap");

            CashierViewPan.add(new JLabel("Cashier display"),"north");
            CashierViewPan.add(cashierDisplay,"dock west");
            cashierDisplay.setEditable(false);
            CashierViewPan.add(lbl1, "top, wrap");
            CashierViewPan.add(field1, "top, wrap");
            CashierViewPan.add(lbl2,"top, wrap" );
            CashierViewPan.add(field2, "top, wrap");
            CashierViewPan.add(field3, "top, wrap");



            riskAssessmentPanel.add(customerViewPan);
            riskAssessmentPanel.add(CashierViewPan);

            add(riskAssessmentPanel, "grow, push");
        }
    }
}

