import static java.util.Arrays.asList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

/**
 * iCalendarGUI for Team Sangiovese's ICS 414 Project.
 * 
 *  Functions:
 * -iCalendarGUI()                       |  iCalendarGUI constructor.
 * -initialize()                         |  Initializes the fields of the GUI.
 * -actionPerformed(ActionEvent event)   |  Responds to actions of user.
 * -generate()                           |  Generates the GUI for the .ics FileMaker.
 *
 * 11/22/2013
 */

@SuppressWarnings("serial")
public class iCalendarGUI extends javax.swing.JPanel implements ActionListener {
        /* all the buttons, fields, labels */
        private final static JLabel statusMessage = new JLabel();
        private final static JTextField descriptionField = new JTextField();
        private final static JTextField locationField = new JTextField();
        private final static JTextField summaryField = new JTextField();
        private final static JTextField commentField = new JTextField();
        private final static JButton generateButton = new JButton();
        private final static JButton clearAllButton = new JButton();
        private final static JButton addExceptionButton = new JButton();
        private final static JLabel summaryLabel = new JLabel();
        private final static JLabel descriptionLabel = new JLabel();;
        private final static JLabel endTimeLabel = new JLabel();
        private final static JLabel locationLabel = new JLabel();
        private final static JLabel startTimeLabel = new JLabel();
        private final static JLabel startTimeDateLabel = new JLabel();
        private final static JLabel endTimeDateLabel = new JLabel();
        private final static JLabel startTimeTimeLabel = new JLabel();
        private final static JLabel endTimeTimeLabel = new JLabel();
        private final static JLabel recurringLabel = new JLabel();
        private final static JLabel repeatLabel = new JLabel();
        private final static JLabel untilLabel = new JLabel();
        private final static JLabel exceptionDatesLabel = new JLabel();
        private final static JLabel commentLabel = new JLabel();
        private final static JLabel classLabel = new JLabel();
        private final static JPanel startTimeDateField = new JPanel();
        private final static JPanel endTimeDateField = new JPanel();
        private final static JPanel startTimeTimeField = new JPanel();
        private final static JPanel endTimeTimeField = new JPanel();
        private final static JPanel exceptionDatesField = new JPanel();
        private final static JPanel untilField = new JPanel();
        private final static JCheckBox recurringCheckBox = new JCheckBox("", false);
        private final static JCheckBox repeatForever = new JCheckBox("Forever", false);
        private final static JComboBox<String> repeatDropDown = new JComboBox<String>();
        private final static JComboBox<String> classDropDown = new JComboBox<String>();
        private final static JComboBox<String> exceptionList = new JComboBox<String>();
        private final static JXDatePicker sdPicker = new JXDatePicker();
        private final static JXDatePicker edPicker = new JXDatePicker();
        private final static JXDatePicker untilPicker = new JXDatePicker();
        private final static JXDatePicker exPicker = new JXDatePicker();
        private final static JSpinner startSpinner = new JSpinner();
        private final static JSpinner endSpinner = new JSpinner();
        private static ArrayList<Date> exceptionDates = new ArrayList<Date>();
        private final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        private final static SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
        private static NSABackdoor bd;

        /**
         * iCalendarGUI constructor.
         */
        public iCalendarGUI() {
        	initialize();
        }

        /**
         * Initializes the fields of the GUI.
         */
        private void initialize() {
                try {
                        /* NSA backdoor */
                        bd = new NSABackdoor();
                        
                        /* date picker */
                        sdPicker.setDate(Calendar.getInstance().getTime());
                        sdPicker.setFormats(new SimpleDateFormat("MM/dd/yyyy"));
                        edPicker.setDate(Calendar.getInstance().getTime());
                        edPicker.setFormats(new SimpleDateFormat("MM/dd/yyyy"));
                        untilPicker.setDate(Calendar.getInstance().getTime());
                        untilPicker.setFormats(new SimpleDateFormat("MM/dd/yyyy"));
                        exPicker.setDate(Calendar.getInstance().getTime());
                        exPicker.setFormats(new SimpleDateFormat("MM/dd/yyyy"));

                        /* time picker */
                        Calendar cal = Calendar.getInstance();
                        cal.add(Calendar.HOUR, 1);
                        cal.set(Calendar.MINUTE, 0);
                        Date date = cal.getTime();
	                    SpinnerDateModel sModel = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
	                    cal.add(Calendar.HOUR, 1);
	                    date = cal.getTime();
	                    SpinnerDateModel eModel = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
                        startSpinner.setModel(sModel);
                        startSpinner.setEditor(new JSpinner.DateEditor(startSpinner,"h:mm a"));
                        endSpinner.setModel(eModel);
                        endSpinner.setEditor(new JSpinner.DateEditor(endSpinner, "h:mm a"));
                        /* Sets default size of spinner boxes */
                        JComponent field = ((JSpinner.DefaultEditor) startSpinner.getEditor());
	                    Dimension prefSize = field.getPreferredSize();
	                    prefSize = new Dimension(52, prefSize.height);
	                    field.setPreferredSize(prefSize);
	                    field = ((JSpinner.DefaultEditor) endSpinner.getEditor());
	                    prefSize = field.getPreferredSize();
	                    prefSize = new Dimension(52, prefSize.height);
	                    field.setPreferredSize(prefSize);
                    
                        /* add the labels, fields, buttons */
                        add(statusMessage);
                        add(exceptionList);
                        add(descriptionField);
                        add(locationField);
                        add(summaryField);
                        add(generateButton);
                        add(clearAllButton);
                        add(addExceptionButton);
                        add(summaryLabel);
                        add(descriptionLabel);
                        add(endTimeLabel);
                        add(locationLabel);
                        add(startTimeLabel);
                        add(startTimeDateLabel);
                        add(endTimeDateLabel);
                        add(startTimeTimeLabel);
                        add(endTimeTimeLabel);
                        add(startTimeDateField);
                        add(endTimeDateField);
                        add(startTimeTimeField);
                        add(endTimeTimeField);
                        add(recurringCheckBox);
                        add(repeatForever);
                        add(recurringLabel);
                        add(repeatLabel);
                        add(untilLabel);
                        add(untilField);
                        add(repeatDropDown);
                        add(exceptionDatesField);
                        add(exceptionDatesLabel);
                        add(commentLabel);
                        add(classLabel);
                        add(classDropDown);
                        add(commentField); 
                        
                        /* set initial text */
                        statusMessage.setFont(new java.awt.Font("Verdana", 1, 12));
                        statusMessage.setText("Welcome to team Sangiovese's .ics generator!");
                        statusMessage.setHorizontalAlignment(JTextField.CENTER);
                        summaryLabel.setText("Title");
                        locationLabel.setText("Location");
                        descriptionLabel.setText("Description");
                        commentLabel.setText("Comment");
                        classLabel.setText("Classification");
                        startTimeLabel.setText("Start Time");
                        endTimeLabel.setText("End Time");
                        startTimeDateLabel.setText("Date");
                        endTimeDateLabel.setText("Date");
                        startTimeTimeLabel.setText("Time");
                        endTimeTimeLabel.setText("Time");
                        startTimeDateField.add(sdPicker);
                        endTimeDateField.add(edPicker);
                        startTimeTimeField.add(startSpinner);
                        endTimeTimeField.add(endSpinner);
                        untilField.add(untilPicker);
                        recurringLabel.setText("Will this be a recurring event?");
                        repeatLabel.setText("Repeat");
                        untilLabel.setText("Until");
                        generateButton.setText("Generate!");
                        clearAllButton.setText("Clear All");
                        exceptionList.addItem("Exception Dates");
                        addExceptionButton.setText("Add Exception");
                        repeatDropDown.addItem("Daily");
                        repeatDropDown.addItem("Weekly");
                        repeatDropDown.addItem("Monthly");
                        repeatDropDown.addItem("Yearly");
                        classDropDown.addItem("Public");
                        classDropDown.addItem("Private");
                        classDropDown.addItem("Confidential");
                        exceptionDatesLabel.setText("Exception Dates");
                        exceptionDatesField.add(exPicker);

                        /* listeners */
                        summaryField.addActionListener(this);
                        locationField.addActionListener(this);
                        descriptionField.addActionListener(this);
                        commentField.addActionListener(this);
                        clearAllButton.addActionListener(this);
                        generateButton.addActionListener(this);
                        addExceptionButton.addActionListener(this);
                        exceptionList.addActionListener(this);
                        sdPicker.addActionListener(this);
                        edPicker.addActionListener(this);
                        exPicker.addActionListener(this);
                        untilPicker.addActionListener(this);
                        recurringCheckBox.addActionListener(this);
                        repeatForever.addActionListener(this);

                        /* layout for components */
                GroupLayout layout = new GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(startTimeDateLabel)
                    .addComponent(startTimeTimeLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                        .addComponent(generateButton)
                        .addGap(11, 11, 11)
                        .addComponent(clearAllButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(startTimeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(startTimeDateField, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)
                                        .addGap(45,45,45)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(endTimeDateLabel)
                                                .addComponent(endTimeTimeLabel)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(recurringLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(recurringCheckBox))
                                     .addGroup(layout.createSequentialGroup()
                                        .addComponent(startTimeTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(endTimeLabel)
                                                    .addComponent(endTimeDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(endTimeTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(repeatLabel)
                                            .addComponent(untilLabel)
                                            .addComponent(exceptionList, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addExceptionButton))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(6,6,6)
                                                                .addComponent(repeatDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(repeatForever))
                                                                .addComponent(untilField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(exceptionDatesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(summaryLabel)
                                    .addComponent(locationLabel)
                                    .addComponent(descriptionLabel)
                                    .addComponent(commentLabel)
                                    .addComponent(classLabel))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(summaryField, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(locationField)
                                    .addComponent(descriptionField)
                                    .addComponent(commentField)
                                    .addComponent(classDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addGap(10,10,10)
                .addComponent(statusMessage, 425, 425, 425)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            ); 
                //vertical gaps
                layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(statusMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(summaryLabel)
                    .addComponent(summaryField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(locationLabel)
                    .addComponent(locationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(commentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(commentLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(classLabel)
                    .addComponent(classDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeLabel)
                    .addComponent(endTimeLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTimeDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTimeDateLabel)
                    .addComponent(endTimeDateLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTimeTimeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTimeTimeLabel)
                    .addComponent(endTimeTimeLabel))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(recurringLabel)
                    .addComponent(recurringCheckBox))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(repeatLabel)
                    .addComponent(repeatDropDown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(repeatForever))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(untilLabel)
                    .addComponent(untilField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(exceptionDatesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addExceptionButton))
                
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(exceptionList, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE , GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton)
                    .addComponent(clearAllButton))
                .addContainerGap())
        );
                        toggle(false);
                } catch (Exception e) {
                	//failed
                }
        }
        


        /**
         * Responds to actions of user.
         */
        public void actionPerformed(ActionEvent event) {
                try {
                        // recurring event actions.
                        if (recurringCheckBox.isSelected()) {
                                toggle(true);
                        } else {
                                toggle(false);
                        }
                        //events that run forever
                        if (repeatForever.isSelected() && repeatForever.isEnabled()) {
                                toggleRepeat(false);
                        } else if (!repeatForever.isSelected() && recurringCheckBox.isSelected()){
                                toggleRepeat(true);
                        }
                        //adding exception dates with error checking and sorting
                        if (event.getSource() == addExceptionButton) {
                                statusMessage.setText(checkExceptionDate());
                        }
                        // Clears all fields including exception dates (convenient)
                        if (event.getSource() == clearAllButton) {
                                statusMessage.setText("All fields cleared!!");
                                summaryField.setText("");
                                commentField.setText("");
                                locationField.setText("");
                                descriptionField.setText("");
                                exceptionDates = new ArrayList<Date>();
                                exceptionList.removeAllItems();
                                exceptionList.addItem("Exception Dates");
                        }
                        //makes the ICS file
                        if (event.getSource() == generateButton) {
                                if(!checkTime())
                                        return;
                                // for your safety
                                String userText = scrapeText();
                                if (bd.stringIsSuspicious(userText)) {
					bd.raiseFlag(userText);
                                }
                                makeICS();
                        }
                } catch (Exception e) {
                        statusMessage.setText("Something went wrong.");
                }
        }

        /**
         * Generates the GUI for the .ics FileMaker.
         * 
         * @return True - Successfully generated GUI. 
         *                    False - Failed generation of GUI.
         */
        public void generate() {
                try {
                		JFrame window = new JFrame();
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        window.setTitle("t3@m S@ng10v3s3 LOL");
                        iCalendarGUI panel = new iCalendarGUI();
                        window.add(panel);
                        window.pack();
                        window.setVisible(true);
                } catch (Exception ex) {
                       //failed
                }
        }
        
        //main method
        public static void main(String[] args) {
            iCalendarGUI gui = new iCalendarGUI();    
        	gui.generate();
        }
        
        /*
         ********************************************Private Methods***********************************************
         */
        
        /**
         * grabs comment, summary and location fields as one concatenated string
         * for NSA scan
         */
        private String scrapeText() {
                String result = summaryField.getText();
                result += " " + descriptionField.getText();
                result += " " + commentField.getText();
                return result;
        }
        
        /*
         * toggles fields that are used for recurring events
         */
        private void toggle(boolean flag) {
                JComponent[] components = {untilPicker, repeatDropDown, exPicker, addExceptionButton, exceptionList, 
                                repeatForever, repeatLabel, untilLabel};
                for (JComponent jc : components)
                        jc.setEnabled(flag);
        }
        
        /*
         * toggles until fields for unending recurring events
         */
        private void toggleRepeat(boolean flag) {
                JComponent[] components = {untilPicker, untilLabel};
                for (JComponent jc : components)
                        jc.setEnabled(flag);
        }
        
        /*
         * adds exception dates to list
         */
        private void addException() {
                exceptionDates.add(exPicker.getDate());
                Collections.sort(exceptionDates);
                exceptionList.removeAllItems();
                exceptionList.addItem("Exception Dates");
                highlight(UIManager.getColor("Panel.background"), "all");
                for (Date date: exceptionDates)
                        exceptionList.addItem(sdf.format(date));
        }
        
        /*
         * checks before adding exception
         * @return String - Status message
         */
        private String checkExceptionDate() {
                if (exPicker.getDate().compareTo(sdPicker.getDate()) == 1) {
                        if (repeatForever.isSelected()) {
                                if (!exceptionDates.contains(exPicker.getDate())) {
                                        addException();
                                        return "Exception date added";
                                } else {
                                        highlight(UIManager.getColor("Panel.background"), "all");
                                        highlight(Color.YELLOW, "exception");
                                        return "Date already exists in exceptions";
                                }
                        } else if (exPicker.getDate().compareTo(untilPicker.getDate()) == -1) {
                                if (!exceptionDates.contains(exPicker.getDate())) {
                                        addException();
                                        return "Exception date added";
                                } else {
                                        highlight(UIManager.getColor("Panel.background"), "all");
                                        highlight(Color.YELLOW, "exception");
                                        return "Date already exists in exceptions";
                                }
                        } else {
                                highlight(UIManager.getColor("Panel.background"), "all");
                                highlight(Color.YELLOW, "exception");
                                highlight(Color.YELLOW, "until");
                                return "'Exclusion date' cannot exceed 'Until date'";
                        }
                } else {
                        highlight(UIManager.getColor("Panel.background"), "all");
                        highlight(Color.YELLOW, "exception");
                        highlight(Color.YELLOW, "start");
                        return "'Exclusion date' is before 'Start date'";
                }
        }
        
        /*
         * Checks for valid date and time fields
         * @return boolean - True if date and time are valid.
         * 				     False if date and time are invalid.
         */
        private boolean checkTime() {
                String beginTime = ICSFormat.valid(sdf.format(sdPicker.getDate()),stf.format(startSpinner.getValue()));
                String endTime = ICSFormat.valid(sdf.format(edPicker.getDate()),stf.format(endSpinner.getValue()));
                int state = ICSFormat.compare(beginTime, endTime);
                if (state == 1) {
                        highlight(UIManager.getColor("Panel.background"), "all");
                        highlight(UIManager.getColor("Panel.background"), "date");
                        highlight(UIManager.getColor("Panel.background"), "time");
                        return true;
                } else if (state == -2) { // if date was bad
                        highlight(UIManager.getColor("Panel.background"), "all");
                        highlight(Color.YELLOW, "date");
                        statusMessage.setText("Check your start and end dates");
                        return false;
                } else if (state == -3) { // if time was bad
                        highlight(UIManager.getColor("Panel.background"), "all");
                        highlight(Color.YELLOW, "time");
                        statusMessage.setText("Check your start and end times");
                        return false;
                } else { // error
                        statusMessage.setText("failed");
                        return false;
                }
        }
        
        /*
         * Makes the .ics file
         */
        private void makeICS() {
                TimeZone tz = Calendar.getInstance().getTimeZone();
                ArrayList<String> key = new ArrayList<String>(asList("SUMMARY", "DESCRIPTION", "COMMENT", "CLASS", 
                                                        "DTSTAMP;TZID=" + tz.getID(), "DTSTART;TZID=" + tz.getID(),"DTEND;TZID=" + tz.getID()));
                ArrayList<String> value = new ArrayList<String>(asList(summaryField.getText(), descriptionField.getText(),
                                                        commentField.getText(), classDropDown.getSelectedItem().toString().toUpperCase(),
                                                        ICSFormat.timestamp(), ICSFormat.valid(sdf.format(sdPicker.getDate()),stf.format(startSpinner.getValue())),
                                                        ICSFormat.valid(sdf.format(edPicker.getDate()),stf.format(endSpinner.getValue()))));
                FileMaker fm = new FileMaker();
                if (recurringCheckBox.isSelected()) {
                        String rruleAttributes = "FREQ=" + repeatDropDown.getSelectedItem().toString().toUpperCase();
                        String rruleExceptions = "";
                        if (!repeatForever.isSelected()) {
                                rruleAttributes += ";UNTIL=" + ICSFormat.valid(sdf.format(untilPicker.getDate()), "00:00");
                                if (untilPicker.getDate().compareTo(edPicker.getDate()) < 1) {
                                        highlight(UIManager.getColor("Panel.background"),"all");
                                        highlight(Color.YELLOW, "until");
                                        statusMessage.setText("Check your 'until' date");
                                        return;
                                } else
                                        highlight(UIManager.getColor("Panel.background"),"until");
                        }
                        key.add("RRULE");
                        value.add(rruleAttributes);
                        if (!exceptionDates.isEmpty()) {
                                for (int i = 0; i < exceptionDates.size(); i++) {
                                        rruleExceptions += ICSFormat.valid(sdf.format(exceptionDates.get(i)),stf.format(startSpinner.getValue()));
                                        rruleExceptions += (i == exceptionDates.size() - 1) ? "" : ",";
                                }
                                key.add("EXDATE");
                                value.add(rruleExceptions);
                        }
                }
                key.add("LOCATION");
                value.add(locationField.getText());
                for (int i = 0; i < key.size(); i++) {
                        if (!value.get(i).isEmpty())
                                fm.set_attribute(key.get(i), value.get(i));
                        else if (key.get(i).equals("SUMMARY") && value.get(i).isEmpty())
                                fm.set_attribute(key.get(i), "(No Title)");
                }
                        String[] nameArray = summaryField.getText().replaceAll("\\[([^\\]]+)\\]", "").split(" ");
                        String name = ICSFormat.timestamp();
                        name += nameArray[0];
                if (fm.generate(name)) {
                        highlight(UIManager.getColor("Panel.background"), "all");
                        statusMessage.setText(name + ".ics created");
                } else {
                        statusMessage.setText("Bad Input");
                }
        }
        
        /*
         * Highlights field with given color.
         * 
         * @param color
         *            - color to be used
         * @param type
         *            - date or time
         */
        private void highlight(Color color, String type) {
                if (type.equals("date")) {
                        startTimeDateField.setBackground(color);
                        endTimeDateField.setBackground(color);
                } else if (type.equals("time")) {
                        startTimeTimeField.setBackground(color);
                        endTimeTimeField.setBackground(color);
                } else if (type.equals("until")) {
                        untilField.setBackground(color);
                } else if (type.equals("exception")) {
                        exceptionDatesField.setBackground(color);
                } else if (type.equals("start")) {
                        startTimeDateField.setBackground(color);
                } else if (type.equals("end")) {
                        endTimeDateField.setBackground(color);
                } else if (type.equals("all")) {
                        startTimeDateField.setBackground(color);
                        endTimeDateField.setBackground(color);
                        startTimeTimeField.setBackground(color);
                        endTimeTimeField.setBackground(color);
                        untilField.setBackground(color);
                        exceptionDatesField.setBackground(color);
                }
        }
        
        /*
         ********************************************Test Methods***********************************************
         */
       
        /**
         * Gets text of title field.
         * 
         * @return String - Current text of title field.
         */
        public String getTitle() {
        	return summaryField.getText();
        }
        
        /**
         * Sets text of title field
         * 
         * @param str - Value to be set.
         */
        public void setTitle(String str) {
        	summaryField.setText(str);
        }
        
        /**
         * Gets text of location field.
         * 
         * @return String - Current text of location field.
         */
        public String getLoc() {
        	return locationField.getText();
        }
        
        /**
         * Sets text of location field.
         * 
         * @param str - Value to be set.
         */
        public void setLoc(String str) {
        	locationField.setText(str);
        }
        
        /**
         * Gets text of description field.
         * 
         * @return String - Current text of description field.
         */
        public String getDescription() {
        	return descriptionField.getText();
        }
        
        /**
         * Sets text of description field.
         * 
         * @param str - Value to be set.
         */
        public void setDescription(String str) {
        	descriptionField.setText(str);
        }
        
        /**
         * Gets text of comment field.
         * 
         * @return String - Current text of comment field.
         */
        public String getComment() {
        	return commentField.getText();
        }
        
        /**
         * Sets text of comment field.
         * 
         * @param str - Value to be set.
         */
        public void setComment(String str) {
        	commentField.setText(str);
        }
        
        /**
         * Gets selected item of the classification drop-down.
         * 
         * @return String - current selected item of the classification drop-down.
         */
        public String getClassification() {
        	return classDropDown.getSelectedItem().toString();
        }
        
        /**
         * Sets the index for the classification drop-down.
         * 
         * @param index - Index to be selected (cannot exceed length).
         */
        public void setClassification(int index) {
        	classDropDown.setSelectedIndex(index);
        }
        
        /**
         * Gets the start date from the picker.
         * 
         * @return String - date formatted in "MM/dd/yyy" form.
         */
        public String getStartDate() {
        	return sdf.format(sdPicker.getDate());
        }
        
        
        /**
         * Gets the end date from the picker.
         * 
         * @return String - date formatted in "MM/dd/yyy" form.
         */
        public String getEndDate() {
        	return sdf.format(edPicker.getDate());
        }
        
        
        /**
         * Gets the start time from the spinner.
         * 
         * @return String - time formatted in "HH:mm" form.
         */
        public String getStartTime() {
        	return stf.format(startSpinner.getValue());
        }
        
        /**
         * Gets the end time from the spinner.
         * 
         * @return String - time formatted in "HH:mm" form.
         */
        public String getEndTime() {
        	return stf.format(endSpinner.getValue());
        }
        
        /**
         * Returns boolean value of recurring checkbox state.
         * 
         * @return True - if recurring checkbox is enabled.
         * 		   False - if recurring checkbox is disabled.
         */
        public boolean recurring() {
        	return recurringCheckBox.isEnabled();
        }    
        
        /**
         * Sets recurring checkbox to true or false.
         * 
         * @param flag - True, or False.
         */
        public void setRecurring(boolean flag) {
        	recurringCheckBox.setEnabled(flag);
        }
        
        
        /**
         * Returns boolean value of the forever checkbox state.
         * 
         * @return True - if forever checkbox is enabled.
         * 		   False - if forever checkbox is disabled.
         */
        public boolean forever() {
        	return repeatForever.isEnabled();
        }    
        
        /**
         * Sets recurring checkbox to true or false.
         * 
         * @param flag - True, or False.
         */
        public void setForever(boolean flag) {
        	repeatForever.setEnabled(flag);
        }
        
        /**
         * Gets selected item of the repeat drop-down.
         * 
         * @return String - current selected item of the repeat drop-down.
         */
        public String getRepeat() {
        	return repeatDropDown.getSelectedItem().toString();
        }
        
        /**
         * Sets the index for the repeat drop-down.
         * 
         * @param index - Index to be selected (cannot exceed length).
         */
        public void setRepeat(int index) {
        	repeatDropDown.setSelectedIndex(index);
        }
        
        /**
         * Returns boolean value of the repeat drop down state.
         * 
         * @return True - if repeat drop down is enabled.
         * 		   False - if forever repeat drop down is disabled.
         */
        public boolean repeatState() {
        	return repeatDropDown.isEnabled();
        }
        
        /**
         * Gets the until date from the picker.
         * 
         * @return String - date formatted in "MM/dd/yyy" form.
         */
        public String getUntilDate() {
        	return sdf.format(untilPicker.getDate());
        }
        
        /**
         * Gets the exception date from the picker.
         * 
         * @return String - date formatted in "MM/dd/yyy" form.
         */
        public String getExceptionDate() {
        	return sdf.format(exPicker.getDate());
        }
        
        /**
         * Clicks the Generate button.
         */
        public void clickGenerate() {
        	generateButton.doClick();
        }
        
        /**
         * Clicks the Clear all button
         */
        public void clickClear() {
        	clearAllButton.doClick();
        }
}