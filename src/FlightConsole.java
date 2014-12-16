import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.Calendar;

public class FlightConsole extends javax.swing.JFrame {
    private String id;
    
    //Method to return the days of the month
    private int daysOfMonth(int month, int year){
        switch (month) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                return 31;
            case 2:
                if (((year % 4 == 0) &&
                        !(year % 100 == 0))
                        || (year % 400 == 0))
                    return 29;
                else
                    return 28;
        }
        return 30;
    }
    
    public FlightConsole(String ID) {
        initComponents();
        //Expand the window to fullscreen
        this.setExtendedState(this.getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH);
        id=ID;
        //<editor-fold defaultstate="collapsed" desc=" Add items to the combo boxes ">
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = currentYear;i<=currentYear+50;i++){
            yearCombo.addItem(i);
        }
        for(int i = currentYear;i<=currentYear+50;i++){
            yearCombo1.addItem(i);
        }
        refreshDays(dayCombo,monthCombo,yearCombo);
        refreshDays(dayCombo1,monthCombo1,yearCombo1);
        for(int i = 0;i<=23;i++){
            if(i<10) hourCombo.addItem("0"+i);
            else hourCombo.addItem(i);
        }
        for(int i = 0;i<=59;i++){
            if(i<10) minuteCombo.addItem("0"+i);
            else minuteCombo.addItem(i);
        }
        for(int i = 0;i<=23;i++){
            if(i<10) hourCombo1.addItem("0"+i);
            else hourCombo1.addItem(i);
        }
        for(int i = 0;i<=59;i++){
            if(i<10) minuteCombo1.addItem("0"+i);
            else minuteCombo1.addItem(i);
        }
        //</editor-fold>
        //Establish connection to JDBC
        try{
            //Show the customer info in the top left corner
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root", "password");
            Statement smt = con.createStatement();
            String sql = "SELECT * FROM customer WHERE id = '" + ID + "'";
            ResultSet result = smt.executeQuery(sql);
            result.next();
            info.setText(result.getString("first_name")+" "+result.getString("last_name"));
            info2.setText(result.getString("address"));
            //Remove the flight editing tab if the user is not an admin
            if (!result.getBoolean("admin"))jTabbedPane1.remove(2);
            //else add the red admin sign after the name
            else info.setText("<html>"+info.getText()+"<font color = \"red\"> (admin)</font></html>");
        } catch(Exception exc){
            System.out.println(exc);
        }
        //Refresh the tables
        String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
        refreshTable(editTable,editFilt,true,"");
        String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
        refreshTable(bookingTable,bookingFilt,false,"");
        String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
        refreshTable(flightTable,flightFilt,false,id);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        info = new javax.swing.JLabel();
        info2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        bookingFilter = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        bookingTable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        bookingFilter1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        bookingFilter2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        bookingFilter3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        flightTable = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        flightFilter = new javax.swing.JTextField();
        flightFilter1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        flightFilter3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        flightFilter2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        toField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fromField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        monthCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dayCombo = new javax.swing.JComboBox();
        yearCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hourCombo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        minuteCombo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        lim = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        hourCombo1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        minuteCombo1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        monthCombo1 = new javax.swing.JComboBox();
        dayCombo1 = new javax.swing.JComboBox();
        yearCombo1 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        editFilter = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        editFilter1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        editFilter2 = new javax.swing.JTextField();
        editFilter3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        info.setText("Name");

        info2.setText("Address");

        bookingFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingFilterActionPerformed(evt);
            }
        });

        bookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "From", "To", "Date depart", "Time depart", "Date arrive", "Time arrive", "Passengers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookingTable.setRowHeight(25);
        bookingTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        bookingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bookingTable);

        jLabel16.setText("From:");

        jButton5.setText("Book this flight");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        bookingFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingFilter1ActionPerformed(evt);
            }
        });

        jLabel18.setText("To:");

        bookingFilter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingFilter2ActionPerformed(evt);
            }
        });

        jLabel19.setText("Date:");

        bookingFilter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingFilter3ActionPerformed(evt);
            }
        });

        jLabel20.setText("Time:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookingFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookingFilter3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookingFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(bookingFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(bookingFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(bookingFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7)
                    .addComponent(jLabel19)
                    .addComponent(bookingFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(bookingFilter3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Book a flight", jPanel1);

        jButton6.setText("Delete this flight");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        flightTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "From", "To", "Date depart", "Time depart", "Date arrive", "Time arrive", "Passengers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        flightTable.setRowHeight(25);
        flightTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        flightTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flightTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(flightTable);

        jButton8.setText("Refresh");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel21.setText("From:");

        flightFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightFilterActionPerformed(evt);
            }
        });

        flightFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightFilter1ActionPerformed(evt);
            }
        });

        jLabel22.setText("To:");

        flightFilter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightFilter3ActionPerformed(evt);
            }
        });

        jLabel23.setText("Time:");

        flightFilter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightFilter2ActionPerformed(evt);
            }
        });

        jLabel24.setText("Date:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flightFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addGap(12, 12, 12)
                        .addComponent(flightFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flightFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(flightFilter3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(flightFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(flightFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(flightFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(flightFilter3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Your flights", jPanel2);

        editTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight ID", "From", "To", "Date depart", "Time depart", "Date arrive", "Time arrive", "Limit", "Passengers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        editTable.setRowHeight(25);
        editTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        editTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(editTable);

        jLabel3.setText("Flight ID:");

        jLabel4.setText("To");

        jLabel5.setText("From:");

        monthCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        monthCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboActionPerformed(evt);
            }
        });

        jLabel1.setText("Date:");

        jLabel2.setText("/");

        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        jLabel6.setText("/");

        jLabel7.setText("Time:");

        hourCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourComboActionPerformed(evt);
            }
        });

        jLabel8.setText(":");

        jLabel9.setText("Limit:");

        lim.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jLabel10.setText("Arrival time:");

        hourCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourCombo1ActionPerformed(evt);
            }
        });

        jLabel11.setText(":");

        jLabel12.setText("Arrival date:");

        monthCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        monthCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCombo1ActionPerformed(evt);
            }
        });

        yearCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCombo1ActionPerformed(evt);
            }
        });

        jLabel13.setText("/");

        jLabel14.setText("/");

        jButton2.setText("Edit/Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel25.setText("From:");

        editFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFilterActionPerformed(evt);
            }
        });

        jLabel26.setText("To:");

        editFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFilter1ActionPerformed(evt);
            }
        });

        jLabel27.setText("Date:");

        editFilter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFilter2ActionPerformed(evt);
            }
        });

        editFilter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFilter3ActionPerformed(evt);
            }
        });

        jLabel28.setText("Time:");

        jButton9.setText("Refresh");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromField, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minuteCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hourCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minuteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(10, 10, 10)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addGap(12, 12, 12)
                        .addComponent(editFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editFilter3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(fromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(dayCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(hourCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(minuteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(dayCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hourCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(minuteCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(editFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(editFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(editFilter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(editFilter3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Edit flights", jPanel3);

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(info)
                    .addComponent(info2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(info)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(info2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22)))
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Go back to the login screen
        final Login login  = new Login();
        login.setLocationRelativeTo(null);
        login.show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void monthComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboActionPerformed
        //Refresh the day combobox
        refreshDays(dayCombo,monthCombo,yearCombo);
    }//GEN-LAST:event_monthComboActionPerformed
    
    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        //Refresh the day combobox
        refreshDays(dayCombo,monthCombo,yearCombo);
    }//GEN-LAST:event_yearComboActionPerformed
    
    private void hourComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourComboActionPerformed
    }//GEN-LAST:event_hourComboActionPerformed
    
    private void hourCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourCombo1ActionPerformed
    }//GEN-LAST:event_hourCombo1ActionPerformed
    
    private void monthCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCombo1ActionPerformed
        //Refresh the arrival day combobox
        refreshDays(dayCombo1,monthCombo1,yearCombo1);
    }//GEN-LAST:event_monthCombo1ActionPerformed
    
    private void yearCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCombo1ActionPerformed
        //Refresh the arrival day combobox
        refreshDays(dayCombo1,monthCombo1,yearCombo1);
    }//GEN-LAST:event_yearCombo1ActionPerformed
    //Method to compare 2 time inputs (time2>time1)
    private boolean compareTime(int month1,int day1,int year1,int hour1,int minute1,
            int month2,int day2,int year2,int hour2,int minute2){
        if((year2>year1) || (year2==year1 && month2 > month1) || (year2==year1 && month2==month1 && day2>day1)
                || (year2==year1 && month2==month1 && day2==day1 && hour2>hour1)
                || (year2==year1 && month2==month1 && day2==day1 && hour2==hour1 && minute2>minute1))
            return true;
        return false;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Check if all fields are filled
        if(!(idField.getText().equals("") || fromField.getText().equals("") || toField.getText().equals(""))){
            //Check if the time inputs are valid
            if(compareTime(Integer.parseInt(monthCombo.getSelectedItem().toString()),
                    Integer.parseInt(dayCombo.getSelectedItem().toString()),
                    Integer.parseInt(yearCombo.getSelectedItem().toString()),
                    Integer.parseInt(hourCombo.getSelectedItem().toString()),
                    Integer.parseInt(minuteCombo.getSelectedItem().toString()),
                    Integer.parseInt(monthCombo1.getSelectedItem().toString()),
                    Integer.parseInt(dayCombo1.getSelectedItem().toString()),
                    Integer.parseInt(yearCombo1.getSelectedItem().toString()),
                    Integer.parseInt(hourCombo1.getSelectedItem().toString()),
                    Integer.parseInt(minuteCombo1.getSelectedItem().toString()))){
                //Establish connection to JDBC
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root", "password");
                    Statement smt = con.createStatement();
                    //Check if the flight id already exist
                    String sql = "SELECT COUNT(*) FROM flight WHERE id = '" + idField.getText().trim() + "'";
                    ResultSet result = smt.executeQuery(sql);
                    result.next();
                    if(result.getInt(1)!=0){//If it does then update the flight
                        sql = "UPDATE flight "
                                + "SET `from` = '"+fromField.getText().trim()+"',"
                                + " `to` = '"+toField.getText().trim()+"',"
                                + " `date` = '"+monthCombo.getSelectedItem()+"/"
                                + dayCombo.getSelectedItem()+"/"
                                + yearCombo.getSelectedItem()+"',"
                                + " `time` = '"+hourCombo.getSelectedItem()+":"
                                + minuteCombo.getSelectedItem()+"',"
                                + " `adate` = '"+monthCombo1.getSelectedItem()+"/"
                                + dayCombo1.getSelectedItem()+"/"
                                + yearCombo1.getSelectedItem()+"',"
                                + " `atime` = '"+hourCombo1.getSelectedItem()+":"
                                + minuteCombo1.getSelectedItem()+"',"
                                + " `limit` = '"+lim.getValue()+"' "
                                + "WHERE id = '"+idField.getText().trim() + "'";
                        smt.executeUpdate(sql);
                    }else{//If not then create the flight
                        sql = "insert into flight "
                                + "(id,`from`,`to`,`date`,`time`,adate,atime,`limit`)"
                                + " values ('"+idField.getText().trim()+"','"
                                + fromField.getText().trim()+"','"
                                + toField.getText().trim()+"','"
                                + monthCombo.getSelectedItem()+"/"
                                + dayCombo.getSelectedItem()+"/"
                                + yearCombo.getSelectedItem()+"','"
                                + hourCombo.getSelectedItem()+":"
                                + minuteCombo.getSelectedItem()+"','"
                                + monthCombo1.getSelectedItem()+"/"
                                + dayCombo1.getSelectedItem()+"/"
                                + yearCombo1.getSelectedItem()+"','"
                                + hourCombo1.getSelectedItem()+":"
                                + minuteCombo1.getSelectedItem()+"','"
                                + lim.getValue()+"')";
                        smt.executeUpdate(sql);
                    }
                } catch(Exception exc){
                    System.out.println(exc);
                }
                //Refresh the tables
                String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
                refreshTable(editTable,editFilt,true,"");
                String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
                refreshTable(bookingTable,bookingFilt,false,"");
                String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
                refreshTable(flightTable,flightFilt,false,id);
                
            }else JOptionPane.showMessageDialog(null, "Invalid time and date input.");
        }else JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void editTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTableMouseClicked
        //Return the information from the table to the fields
        idField.setText(editTable.getModel().getValueAt(editTable.getSelectedRow(), 0).toString());
        fromField.setText(editTable.getModel().getValueAt(editTable.getSelectedRow(), 1).toString());
        toField.setText(editTable.getModel().getValueAt(editTable.getSelectedRow(), 2).toString());
        String date1 = editTable.getModel().getValueAt(editTable.getSelectedRow(), 3).toString();
        String time1 = editTable.getModel().getValueAt(editTable.getSelectedRow(), 4).toString();
        String date2 = editTable.getModel().getValueAt(editTable.getSelectedRow(), 5).toString();
        String time2 = editTable.getModel().getValueAt(editTable.getSelectedRow(), 6).toString();
        goToValue(yearCombo,date1.substring(6));
        goToValue(monthCombo,date1.substring(0,2));
        goToValue(dayCombo,date1.substring(3,5));
        goToValue(yearCombo1,date2.substring(6));
        goToValue(monthCombo1,date2.substring(0,2));
        goToValue(dayCombo1,date2.substring(3,5));
        goToValue(hourCombo,time1.substring(0,2));
        goToValue(minuteCombo,time1.substring(3));
        goToValue(hourCombo1,time2.substring(0,2));
        goToValue(minuteCombo1,time2.substring(3));
        lim.setValue(Integer.parseInt(editTable.getModel().getValueAt(editTable.getSelectedRow(), 7).toString()));
    }//GEN-LAST:event_editTableMouseClicked
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Reset all fields
        idField.setText("");
        fromField.setText("");
        toField.setText("");
        yearCombo.setSelectedIndex(0);
        monthCombo.setSelectedIndex(0);
        dayCombo.setSelectedIndex(0);
        hourCombo.setSelectedIndex(0);
        minuteCombo.setSelectedIndex(0);
        yearCombo1.setSelectedIndex(0);
        monthCombo1.setSelectedIndex(0);
        dayCombo1.setSelectedIndex(0);
        hourCombo1.setSelectedIndex(0);
        minuteCombo1.setSelectedIndex(0);
        lim.setValue(1);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(editTable.getSelectedRow()>=0){//See if there is an item selected in the table
            //Establish connection to JDBC
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root", "password");
                Statement smt = con.createStatement();
                //Delete the flight
                String sql = "DELETE FROM flight WHERE id = '" +
                        editTable.getModel().getValueAt(editTable.getSelectedRow(), 0) + "'";
                smt.execute(sql);
                sql = "DELETE FROM booking_list WHERE flight_id = '" +
                        editTable.getModel().getValueAt(editTable.getSelectedRow(), 0) + "'";
                smt.execute(sql);
                //Refresh the tables
                String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
                refreshTable(editTable,editFilt,false,"");
                String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
                refreshTable(bookingTable,bookingFilt,false,"");
                String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
                refreshTable(flightTable,flightFilt,false,id);
            } catch(Exception exc){
                System.out.println(exc);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void bookingFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingFilterActionPerformed
        String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
        refreshTable(bookingTable,bookingFilt,false,"");
    }//GEN-LAST:event_bookingFilterActionPerformed
    
    private void bookingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingTableMouseClicked
    }//GEN-LAST:event_bookingTableMouseClicked
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(bookingTable.getSelectedRow()>=0){//See if there is an item selected in the table
            //Establish connection to JDBC
            try{
                String selectedFlight = bookingTable.getModel().getValueAt(bookingTable.getSelectedRow(), 0).toString();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root", "password");
                //We need 2 statements because we will be pulling dates from 2 tables
                Statement smt = con.createStatement();
                Statement smt2 = con.createStatement();
                //Check if this id already booked the flight
                String sql = "SELECT COUNT(*) FROM booking_list WHERE customer_id = '" +
                        id + "' AND flight_id = '"  + selectedFlight + "'";
                ResultSet result = smt.executeQuery(sql);
                result.next();
                if(result.getInt(1)==0){//If not booked
                    //Check if the flight is full
                    sql = "SELECT COUNT(*) FROM booking_list WHERE flight_id = '" + selectedFlight + "'";
                    result = smt.executeQuery(sql);
                    result.next();
                    int numOfPassengers = result.getInt(1);
                    sql = "SELECT * FROM flight WHERE id = '" + selectedFlight + "'";
                    result = smt.executeQuery(sql);
                    result.next();
                    if(numOfPassengers<result.getInt("limit")){//If the flight is not full
                        //<editor-fold defaultstate="collapsed" desc=" Check if flight times conflict ">
                        //Save the time of the selected flight to variables
                        int dmonth1 = Integer.parseInt(result.getString("date").substring(0,2));
                        int dday1 = Integer.parseInt(result.getString("date").substring(3,5));
                        int dyear1 = Integer.parseInt(result.getString("date").substring(6));
                        int dhour1 = Integer.parseInt(result.getString("time").substring(0,2));
                        int dminute1 = Integer.parseInt(result.getString("time").substring(3));
                        int amonth1 = Integer.parseInt(result.getString("adate").substring(0,2));
                        int aday1 = Integer.parseInt(result.getString("adate").substring(3,5));
                        int ayear1 = Integer.parseInt(result.getString("adate").substring(6));
                        int ahour1 = Integer.parseInt(result.getString("atime").substring(0,2));
                        int aminute1 = Integer.parseInt(result.getString("atime").substring(3));
                        //Create a no conflict checker
                        boolean noConflict = true;
                        //Save the booked flight into a separate result set
                        sql = "SELECT * FROM booking_list WHERE `customer_id` = '"+id+"'"
                                + " AND flight_id != '" + selectedFlight + "'";
                        ResultSet result2 = smt2.executeQuery(sql);
                        while(result2.next()){//Iterate every booked flight
                            sql = "SELECT * FROM flight WHERE id = '" + result2.getString("flight_id") + "'";
                            result = smt.executeQuery(sql);
                            result.next();
                            //Pull time information into variables
                            int dmonth2 = Integer.parseInt(result.getString("date").substring(0,2));
                            int dday2 = Integer.parseInt(result.getString("date").substring(3,5));
                            int dyear2 = Integer.parseInt(result.getString("date").substring(6));
                            int dhour2 = Integer.parseInt(result.getString("time").substring(0,2));
                            int dminute2 = Integer.parseInt(result.getString("time").substring(3));
                            int amonth2 = Integer.parseInt(result.getString("adate").substring(0,2));
                            int aday2 = Integer.parseInt(result.getString("adate").substring(3,5));
                            int ayear2 = Integer.parseInt(result.getString("adate").substring(6));
                            int ahour2 = Integer.parseInt(result.getString("atime").substring(0,2));
                            int aminute2 = Integer.parseInt(result.getString("atime").substring(3));
                            /*Check if the times overlap. Doing so by checking 
                            the negation of the condition: if one flight departs 
                            after the other one arrives or vice versa.*/
                            if (!((compareTime(amonth1,aday1,ayear1,ahour1,aminute1,dmonth2,dday2,dyear2,dhour2,dminute2)||
                                    compareTime(amonth2,aday2,ayear2,ahour2,aminute2,dmonth1,dday1,dyear1,dhour1,dminute1)))){
                                noConflict = false;
                                break;
                            }
                        }
                        //</editor-fold>
                        if (noConflict){//If there's no conflict then create new booking entry
                            sql = "INSERT INTO booking_list (customer_id,flight_id) VALUES('"
                                    + id + "','" + selectedFlight + "')";
                            smt.executeUpdate(sql);
                            JOptionPane.showMessageDialog(null, "Flight booked successfully.");
                        }else JOptionPane.showMessageDialog(null, "There is a time conflict between your flights.");
                    }else JOptionPane.showMessageDialog(null, "Flight is full.");
                }else JOptionPane.showMessageDialog(null, "Flight already booked.");
                
                //Refresh the tables
                String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
                refreshTable(editTable,editFilt,true,"");
                String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
                refreshTable(bookingTable,bookingFilt,false,"");
                String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
                refreshTable(flightTable,flightFilt,false,id);
            } catch(Exception exc){
                System.out.println(exc);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(flightTable.getSelectedRow()>=0){//See if there is an item selected in the table
            //Establish connection to JDBC
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root", "password");
                Statement smt = con.createStatement();
                //Delete the booking entry
                String sql = "DELETE FROM booking_list WHERE `customer_id` = '" +id+
                        "' AND flight_id = '"
                        + flightTable.getModel().getValueAt(flightTable.getSelectedRow(), 0) + "'";
                smt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Flight deleted successfully.");
                //Refresh the tables
                String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
                refreshTable(editTable,editFilt,true,"");
                String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
                refreshTable(bookingTable,bookingFilt,false,"");
                String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
                refreshTable(flightTable,flightFilt,false,id);
            } catch(Exception exc){
                System.out.println(exc);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    
    private void flightTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_flightTableMouseClicked
    }//GEN-LAST:event_flightTableMouseClicked
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
        refreshTable(bookingTable,bookingFilt,false,"");
    }//GEN-LAST:event_jButton7ActionPerformed
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
        refreshTable(flightTable,flightFilt,false,id);
    }//GEN-LAST:event_jButton8ActionPerformed
    
    private void bookingFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingFilter1ActionPerformed
        String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
        refreshTable(bookingTable,bookingFilt,false,"");
    }//GEN-LAST:event_bookingFilter1ActionPerformed
    
    private void bookingFilter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingFilter2ActionPerformed
        String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
        refreshTable(bookingTable,bookingFilt,false,"");
    }//GEN-LAST:event_bookingFilter2ActionPerformed
    
    private void bookingFilter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingFilter3ActionPerformed
        String[] bookingFilt = {bookingFilter.getText(),bookingFilter1.getText(),bookingFilter2.getText(),bookingFilter3.getText()};
        refreshTable(bookingTable,bookingFilt,false,"");
    }//GEN-LAST:event_bookingFilter3ActionPerformed
    
    private void flightFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightFilterActionPerformed
        String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
        refreshTable(flightTable,flightFilt,false,id);
    }//GEN-LAST:event_flightFilterActionPerformed
    
    private void flightFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightFilter1ActionPerformed
        String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
        refreshTable(flightTable,flightFilt,false,id);
    }//GEN-LAST:event_flightFilter1ActionPerformed
    
    private void flightFilter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightFilter3ActionPerformed
        String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
        refreshTable(flightTable,flightFilt,false,id);
    }//GEN-LAST:event_flightFilter3ActionPerformed
    
    private void flightFilter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightFilter2ActionPerformed
        String[] flightFilt = {flightFilter.getText(),flightFilter1.getText(),flightFilter2.getText(),flightFilter3.getText()};
        refreshTable(flightTable,flightFilt,false,id);
    }//GEN-LAST:event_flightFilter2ActionPerformed
    
    private void editFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFilterActionPerformed
        String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
        refreshTable(editTable,editFilt,true,"");        
    }//GEN-LAST:event_editFilterActionPerformed
    
    private void editFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFilter1ActionPerformed
        String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
        refreshTable(editTable,editFilt,true,"");        
    }//GEN-LAST:event_editFilter1ActionPerformed
    
    private void editFilter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFilter2ActionPerformed
        String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
        refreshTable(editTable,editFilt,true,"");        
    }//GEN-LAST:event_editFilter2ActionPerformed
    
    private void editFilter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFilter3ActionPerformed
        String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
        refreshTable(editTable,editFilt,true,"");        
    }//GEN-LAST:event_editFilter3ActionPerformed
    
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String[] editFilt = {editFilter.getText(),editFilter1.getText(),editFilter2.getText(),editFilter3.getText()};
        refreshTable(editTable,editFilt,true,"");        
    }//GEN-LAST:event_jButton9ActionPerformed
    
    //Method to go to a value in the combobox
    private void goToValue(JComboBox combo, String val){
        combo.setSelectedIndex(0);
        while(!combo.getSelectedItem().toString().equals(val) && combo.getSelectedIndex()<combo.getItemCount()-1){
            combo.setSelectedIndex(combo.getSelectedIndex()+1);
        }
    }
    
    //Method to refresh a table by filter and view
    private void refreshTable(JTable table, String[] filter, boolean admin, String ID){
        //Establish connection to JDBC
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root", "password");
            Statement smt = con.createStatement();
            if(ID.equals("")){//If there's no id input
                //Use the where statement to filter
                String sql = "SELECT * FROM flight WHERE `from` LIKE '%"+filter[0]+"%'"
                        + " AND `to` LIKE '%"+filter[1]+"%'"
                        + " AND `date` LIKE '"+filter[2]+"%'"
                        + " AND `time` LIKE '"+filter[3]+"%'";
                ResultSet result = smt.executeQuery(sql);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setNumRows(0);//Remove all items in the list
                Statement smt2 = con.createStatement();
                while(result.next()){//Iterate every flight
                    String[] row = new String[9];
                    if(admin){//If the view is from an admin
                        //Show all information but the number of passengers and limit are separate
                        for(int i = 0;i<=7;i++){
                            row[i] = result.getString(i+1);
                        }
                        sql = "SELECT COUNT(*) FROM booking_list WHERE flight_id = '"
                                + result.getString(1)+"'";
                        ResultSet result2 = smt2.executeQuery(sql);
                        result2.next();
                        row[8] = result2.getString(1);
                    }else{
                        //Show all information but the number of passengers and limit merged in one cell
                        for(int i = 0;i<=6;i++){
                            row[i] = result.getString(i+1);
                        }
                        sql = "SELECT COUNT(*) FROM booking_list WHERE flight_id = '"
                                + result.getString(1)+"'";
                        ResultSet result2 = smt2.executeQuery(sql);
                        result2.next();
                        row[7] = result2.getString(1)+"/"+result.getString(8);
                    }
                    model.addRow(row);//Add the row to the list
                }
            }else{//If there is an id input
                //Create the second statement to browse the booking list
                Statement smt2 = con.createStatement();
                String sql = "SELECT * FROM booking_list WHERE customer_id = '"+ID+"'";
                ResultSet result2 = smt2.executeQuery(sql);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setNumRows(0);
                while(result2.next()){//Iterate on only the flights booked by the id input
                    //Check if the flight with this id that fit the filter condition exists
                    sql = "SELECT COUNT(*) FROM flight WHERE id = '"+result2.getString("flight_id")+"'"
                            + " AND `from` LIKE '%"+filter[0]+"%'"
                            + " AND `to` LIKE '%"+filter[1]+"%'"
                            + " AND `date` LIKE '"+filter[2]+"%'"
                            + " AND `time` LIKE '"+filter[3]+"%'";
                    ResultSet result = smt.executeQuery(sql);
                    result.next();
                    if(result.getInt(1)!=0){//If it does
                        //Add that row in
                        sql = "SELECT * FROM flight WHERE id = '"+result2.getString("flight_id")+"'";
                        result = smt.executeQuery(sql);
                        result.next();
                        String[] row = new String[9];
                        for(int i = 0;i<=6;i++){
                            row[i] = result.getString(i+1);
                        }
                        sql = "SELECT COUNT(*) FROM booking_list WHERE flight_id = '"
                                + result.getString(1)+"'";
                        Statement smt3 = con.createStatement();
                        ResultSet result3 = smt3.executeQuery(sql);
                        result3.next();
                        row[7] = result3.getString(1)+"/"+result.getString(8);;
                        model.addRow(row);
                    }
                }
            }
        } catch(Exception exc){
            System.out.println(exc);
        }
        
    }
    
    //Method to refresh the day combobox
    private void refreshDays(JComboBox modl, JComboBox monthMdl, JComboBox yearMdl){
        //Save the current day into a variable
        String curDay = "01";
        //At the beginning there is no item in the box so this if statement is to avoid that
        if(modl.getItemCount()>0) curDay = modl.getSelectedItem().toString();
        //Remove all the items from the days combobox
        modl.removeAllItems();
        //Add the days to the days combobox according to the month and year
        int days =  daysOfMonth(Integer.parseInt(monthMdl.getSelectedItem().toString()),
                Integer.parseInt(yearMdl.getSelectedItem().toString()));
        for(int i = 1;i<=days;i++){
            if(i<10) modl.addItem("0"+i);
            else modl.addItem(i);
        }
        //Go back to that value
        goToValue(modl,curDay);
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PassRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookingFilter;
    private javax.swing.JTextField bookingFilter1;
    private javax.swing.JTextField bookingFilter2;
    private javax.swing.JTextField bookingFilter3;
    private javax.swing.JTable bookingTable;
    private javax.swing.JComboBox dayCombo;
    private javax.swing.JComboBox dayCombo1;
    private javax.swing.JTextField editFilter;
    private javax.swing.JTextField editFilter1;
    private javax.swing.JTextField editFilter2;
    private javax.swing.JTextField editFilter3;
    private javax.swing.JTable editTable;
    private javax.swing.JTextField flightFilter;
    private javax.swing.JTextField flightFilter1;
    private javax.swing.JTextField flightFilter2;
    private javax.swing.JTextField flightFilter3;
    private javax.swing.JTable flightTable;
    private javax.swing.JTextField fromField;
    private javax.swing.JComboBox hourCombo;
    private javax.swing.JComboBox hourCombo1;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel info;
    private javax.swing.JLabel info2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner lim;
    private javax.swing.JComboBox minuteCombo;
    private javax.swing.JComboBox minuteCombo1;
    private javax.swing.JComboBox monthCombo;
    private javax.swing.JComboBox monthCombo1;
    private javax.swing.JTextField toField;
    private javax.swing.JComboBox yearCombo;
    private javax.swing.JComboBox yearCombo1;
    // End of variables declaration//GEN-END:variables
}
