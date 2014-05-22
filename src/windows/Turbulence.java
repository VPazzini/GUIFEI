package windows;

import gui2.DrawInterface;
import gui2.Model;
import javax.swing.DefaultListModel;

public class Turbulence extends javax.swing.JFrame {

    DefaultListModel resultList;
    
    public Turbulence() {
        initComponents();
        visible();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        resultList = new DefaultListModel();
        groupsList.setModel(resultList);
        attList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        startFreqField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        endFreqField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dFreqField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        turbMetCombo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        elementOrGroupComboBox = new javax.swing.JComboBox();
        groupsListScrollPane = new javax.swing.JScrollPane();
        groupsList = new javax.swing.JList();
        okButton = new javax.swing.JButton();
        newGroupButton = new javax.swing.JButton();
        removeGroupButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Frequency Input"));

        jLabel1.setText("Start");

        jLabel2.setText("End");

        jLabel3.setText("DF");

        jLabel4.setText("Turbulence Met");

        turbMetCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ziada", "Pettigrew" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(endFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(turbMetCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dFreqField, endFreqField, startFreqField});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(startFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(endFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(dFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(turbMetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        elementOrGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Element by Element", "Group Elements" }));
        elementOrGroupComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                elementOrGroupComboBoxItemStateChanged(evt);
            }
        });

        groupsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                groupsListValueChanged(evt);
            }
        });
        groupsListScrollPane.setViewportView(groupsList);

        okButton.setText("OK");

        newGroupButton.setText("New Group");
        newGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGroupButtonActionPerformed(evt);
            }
        });

        removeGroupButton.setText("Remove");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(groupsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(elementOrGroupComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newGroupButton, okButton, removeGroupButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(elementOrGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(newGroupButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeGroupButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton))
                    .addComponent(groupsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void elementOrGroupComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_elementOrGroupComboBoxItemStateChanged
        visible();
    }//GEN-LAST:event_elementOrGroupComboBoxItemStateChanged

    private void newGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGroupButtonActionPerformed
        DrawInterface drawInterf = DrawInterface.getInstance();
        drawInterf.setSelectionEdgeMode(true);
        drawInterf.setSelectionNodeMode(false);
    }//GEN-LAST:event_newGroupButtonActionPerformed

    private void groupsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_groupsListValueChanged
        //System.out.println(groupsList.getSelectedValue());
    }//GEN-LAST:event_groupsListValueChanged

    public void attList() {
        resultList = new DefaultListModel();

        for (String s : Model.getInstance().printGroups()) {
            resultList.addElement(s);
        }
        groupsList.setModel(resultList);
    }

    private void visible() {
        String s = (String) elementOrGroupComboBox.getSelectedItem();

        if (s.equals("Element by Element")) {
            groupsList.setVisible(false);
            newGroupButton.setVisible(false);
            removeGroupButton.setVisible(false);
            groupsListScrollPane.setVisible(false);
        } else {
            groupsList.setVisible(true);
            newGroupButton.setVisible(true);
            removeGroupButton.setVisible(true);
            groupsListScrollPane.setVisible(true);
        }
    }
    
    public float getStartFreq(){
        float startf;
        try{
            startf = Float.parseFloat(startFreqField.getText());
        }catch(NumberFormatException e){
            startf = 0;
            System.out.println(e);
        }
        return startf;
    }
    
    public float getEndFreq(){
        float endf;
        try{
            endf = Float.parseFloat(endFreqField.getText());
        }catch(NumberFormatException e){
            endf = 0;
            System.out.println(e);
        }
        return endf;
    }
    
    public float getDFreq(){
        float df;
        try{
            df = Float.parseFloat(dFreqField.getText());
        }catch(NumberFormatException e){
            df = 0;
            System.out.println(e);
        }
        return df;
    }
    
    public String getMethod(){
        String s = (String) turbMetCombo.getSelectedItem();
        return s;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dFreqField;
    private javax.swing.JComboBox elementOrGroupComboBox;
    private javax.swing.JTextField endFreqField;
    private javax.swing.JList groupsList;
    private javax.swing.JScrollPane groupsListScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton newGroupButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeGroupButton;
    private javax.swing.JTextField startFreqField;
    private javax.swing.JComboBox turbMetCombo;
    // End of variables declaration//GEN-END:variables
}
