package com.company.mediator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import com.company.components.*;
import com.company.components.Component;
import com.company.components.List;

/**
 * EN: Concrete mediator. All chaotic communications between concrete components
 * have been extracted to the mediator. Now components only talk with the
 * mediator, which knows who has to handle a request.
 *
 * RU: Конкретный посредник. Все связи между конкретными компонентами переехали
 * в код посредника. Он получает извещения от своих компонентов и знает как на
 * них реагировать.
 */
public class Editor implements Mediator {
    private InputBox inputNameBox, inputLastNameBox, inputPartnerNameBox, inputPartnerLastNameBox, inputCompanyBox, inputPositionBox;
    private AgeComboBox ageComboBox;
    private MariedCheckBox mariedCheckBox;
    private EmploymentCheckBox employmentCheckBox;
    private TextBox textBox;
    private AddButton add;
    private DeleteButton del;
    private SaveButton save;
    private List list;
    private Filter filter;

    private JLabel nameLabel = new JLabel("Name:");
    private JLabel lastNameLabel = new JLabel("Last Name:");
    private JLabel ageLabel = new JLabel("Age:");
    private JLabel mariedLabel = new JLabel("Maried:");
    private JLabel partnerLabel = new JLabel("Partner information:");
    private JLabel partnerNameLabel = new JLabel("Name:");
    private JLabel partnerLastNameLabel  = new JLabel("Last Name:");
    private JLabel employmentLabel = new JLabel("Employment:");
    private JLabel companyLabel = new JLabel("Company:");
    private JLabel positionLabel = new JLabel("Position:");

    private JLabel otherInfoLabel = new JLabel("Other information:");
    private JLabel label = new JLabel("Add or select existing customer to proceed...");

    /**
     * EN: Here the registration of components by the mediator.
     *
     * RU: Здесь происходит регистрация компонентов посредником.
     */
    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "AddButton":
                add = (AddButton)component;
                break;
            case "DelButton":
                del = (DeleteButton)component;
                break;
            case "Filter":
                filter = (Filter)component;
                break;
            case "List":
                list = (List)component;
                this.list.addListSelectionListener(listSelectionEvent -> {
                    Customer customer = (Customer)list.getSelectedValue();
                    if (customer != null) {
                        getInfoFromList(customer);
                    } else {
                        clear();
                    }
                });
                break;
            case "SaveButton":
                save = (SaveButton)component;
                break;
            case "TextBox":
                textBox = (TextBox)component;
                break;
            case "InputNameBox":
                inputNameBox = (InputNameBox)component;
                break;
            case "InputLastNameBox":
                inputLastNameBox = (InputLastNameBox)component;
                break;
            case "AgeComboBox":
                ageComboBox = (AgeComboBox)component;
                break;
            case "MariedCheckBox":
                mariedCheckBox = (MariedCheckBox)component;
                break;
            case "InputPartnerNameBox":
                inputPartnerNameBox = (InputPartnerNameBox)component;
                break;
            case "InputPartnerLastName":
                inputPartnerLastNameBox = (InputPartnerLastName)component;
                break;
            case "EmploymentCheckBox":
                employmentCheckBox = (EmploymentCheckBox) component;
                break;
            case "InputCompanyBox":
                inputCompanyBox = (InputCompanyBox) component;
                break;
            case "InputPositionBox":
                inputPositionBox = (InputPositionBox) component;
                break;
        }
    }

    /**
     * EN: Various methods to handle requests from particular components.
     *
     * RU: Разнообразные методы общения с компонентами.
     */
    @Override
    public void addNewCustomer(Customer customer) {
        inputNameBox.setText("");
        textBox.setText("");
        list.addElement(customer);
    }

    @Override
    public void deleteCustomer() {
        list.deleteElement();
    }

    @Override
    public void getInfoFromList(Customer customer) {
        inputNameBox.setText(customer.getName().replace('*', ' '));
        inputLastNameBox.setText(customer.getLastName());
        //ageComboBox.set
        ageComboBox.setSelectedItem(new Integer(customer.getAge()));
        mariedCheckBox.setSelected(customer.isMarried());
        inputPartnerNameBox.setText(customer.getPartnerName());
        inputPartnerLastNameBox.setText(customer.getPartnerLastName());
        employmentCheckBox.setSelected(customer.isEmployment());
        inputCompanyBox.setText(customer.getCompany());
        inputPositionBox.setText(customer.getPosition());
        textBox.setText(customer.getOtherInfo());
    }

    @Override
    public void saveChanges() {
        try {
            Customer customer = (Customer) list.getSelectedValue();
            customer.setName(inputNameBox.getText().trim());
            customer.setLastName(inputLastNameBox.getText());
            customer.setAge((int)ageComboBox.getSelectedItem());
            customer.setMarried(mariedCheckBox.isSelected());
            customer.setPartnerName(inputPartnerNameBox.getText());
            customer.setPartnerLastName(inputPartnerLastNameBox.getText());
            customer.setEmployment(employmentCheckBox.isSelected());
            customer.setCompany(inputCompanyBox.getText());
            customer.setPosition(inputPositionBox.getText());
            customer.setOtherInfo(textBox.getText());
            list.repaint();
        } catch (NullPointerException ignored) {}
    }

    @Override
    public void markCustomer() {
        try {
            Customer customer = list.getCurrentElement();
            String name = customer.getName();
            if (!name.endsWith("*")) {
                customer.setName(customer.getName() + "*");
            }
            list.repaint();
        } catch (NullPointerException ignored) {}
    }

    @Override
    public void clear() {
        inputNameBox.setText("");
        textBox.setText("");
    }

    @Override
    public void sendToFilter(ListModel listModel) {
        filter.setList(listModel);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setElementsList(ListModel list) {
        this.list.setModel(list);
        this.list.repaint();
    }

    @Override
    public void hideElements(boolean flag) {
        nameLabel.setVisible(!flag);
        lastNameLabel.setVisible(!flag);
        inputNameBox.setVisible(!flag);
        inputLastNameBox.setVisible(!flag);
        ageLabel.setVisible(!flag);
        ageComboBox.setVisible(!flag);
        mariedLabel.setVisible(!flag);
        mariedCheckBox.setVisible(!flag);
        partnerLabel.setVisible(!flag);
        partnerNameLabel.setVisible(!flag);
        inputPartnerNameBox.setVisible(!flag);
        partnerLastNameLabel.setVisible(!flag);
        inputPartnerLastNameBox.setVisible(!flag);
        employmentLabel.setVisible(!flag);
        employmentCheckBox.setVisible(!flag);
        companyLabel.setVisible(!flag);
        inputCompanyBox.setVisible(!flag);
        positionLabel.setVisible(!flag);
        inputPositionBox.setVisible(!flag);



        otherInfoLabel.setVisible(!flag);

        textBox.setVisible(!flag);
        save.setVisible(!flag);
        label.setVisible(flag);
    }

    @Override
    public void checkEnableElements() {
        int age = (int)ageComboBox.getSelectedItem();

        mariedLabel.setEnabled(false);
        mariedCheckBox.setEnabled(false);
        partnerLabel.setEnabled(false);
        partnerNameLabel.setEnabled(false);
        inputPartnerNameBox.setEnabled(false);
        partnerLastNameLabel.setEnabled(false);
        inputPartnerLastNameBox.setEnabled(false);

        employmentLabel.setEnabled(false);
        employmentCheckBox.setEnabled(false);
        companyLabel.setEnabled(false);
        inputCompanyBox.setEnabled(false);
        positionLabel.setEnabled(false);
        inputPositionBox.setEnabled(false);

        if (age>13){
            employmentLabel.setEnabled(true);
            employmentCheckBox.setEnabled(true);
            if(employmentCheckBox.isSelected()==true){
                companyLabel.setEnabled(true);
                inputCompanyBox.setEnabled(true);
                positionLabel.setEnabled(true);
                inputPositionBox.setEnabled(true);
            }
            if (age>15){
                mariedLabel.setEnabled(true);
                mariedCheckBox.setEnabled(true);
                if (mariedCheckBox.isSelected()==true){
                    partnerLabel.setEnabled(true);
                    partnerNameLabel.setEnabled(true);
                    inputPartnerNameBox.setEnabled(true);

                    partnerLastNameLabel.setEnabled(true);
                    inputPartnerLastNameBox.setEnabled(true);
                }
            }
        }
    }

    @Override
    public void createGUI() {
        JFrame notes = new JFrame("Customers");
        notes.setSize(600, 600);
        notes.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(290, 600));
        leftPanel.setBorder(new LineBorder(Color.BLACK));

        nameLabel.setBounds(20, 5, 50, 20);
        inputNameBox.setBounds(100, 6, 220, 20);

        lastNameLabel.setBounds(20, 30, 70, 20);
        inputLastNameBox.setBounds(100, 31, 220, 20);

        ageLabel.setBounds(20,54,25,20);
        ageComboBox.setBounds(100, 56, 50,20);

        mariedLabel.setBounds(20,78,70,20);
        mariedCheckBox.setBounds(96, 81,20,15);

        partnerLabel.setBounds(205,78,120,20);

        partnerNameLabel.setBounds(20,102,70,20);
        inputPartnerNameBox.setBounds(100,102,220,20);

        partnerLastNameLabel.setBounds(20,126,70,20);
        inputPartnerLastNameBox.setBounds(100,127,220,20);

        employmentLabel.setBounds(20,151,75,20);
        employmentCheckBox.setBounds(96,151,20,20);

        companyLabel.setBounds(20,176,75,20);
        inputCompanyBox.setBounds(100,177,220,20);

        positionLabel.setBounds(20,201,75,20);
        inputPositionBox.setBounds(100,202,220,20);

        otherInfoLabel.setBounds(20, 226, 150, 20);
        textBox.setBorder(new LineBorder(Color.DARK_GRAY));
        textBox.setBounds(20, 251, 300, 269);
        save.setBounds(240, 535, 80, 25);

        label.setFont(new Font("Verdana", Font.PLAIN, 14));
        label.setBounds(10, 240, 500, 100);

        leftPanel.add(label);
        leftPanel.add(nameLabel);
        leftPanel.add(inputNameBox);
        leftPanel.add(lastNameLabel);
        leftPanel.add(inputLastNameBox);
        leftPanel.add(ageLabel);
        leftPanel.add(ageComboBox);
        leftPanel.add(mariedLabel);
        leftPanel.add(mariedCheckBox);
        leftPanel.add(partnerLabel);
        leftPanel.add(partnerNameLabel);
        leftPanel.add(inputPartnerNameBox);
        leftPanel.add(partnerLastNameLabel);
        leftPanel.add(inputPartnerLastNameBox);
        leftPanel.add(employmentLabel);
        leftPanel.add(employmentCheckBox);
        leftPanel.add(companyLabel);
        leftPanel.add(inputCompanyBox);
        leftPanel.add(positionLabel);
        leftPanel.add(inputPositionBox);

        leftPanel.add(otherInfoLabel);
        leftPanel.add(textBox);
        leftPanel.add(save);


        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(new LineBorder(Color.BLACK));
        rightPanel.setPreferredSize(new Dimension(200, 600));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter: "));
        filter.setColumns(15);
        filterPanel.add(filter);
        filterPanel.setPreferredSize(new Dimension(190, 40));

        JPanel listPanel = new JPanel();
        list.setFixedCellWidth(150);
        listPanel.setSize(320, 470);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(210, 470));
        listPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        add.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(add);
        del.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(del);
        buttonPanel.setLayout(new FlowLayout());

        rightPanel.add(filterPanel);
        rightPanel.add(listPanel);
        rightPanel.add(buttonPanel);


        JPanel notesPanel = new JPanel();
        notesPanel.setLayout(new BoxLayout(notesPanel, BoxLayout.X_AXIS));
        notesPanel.add(leftPanel);
        notesPanel.add(rightPanel);

        notes.add(notesPanel);
        notes.setResizable(false);
        notes.setLocationRelativeTo(null);
        notes.setVisible(true);
    }
}