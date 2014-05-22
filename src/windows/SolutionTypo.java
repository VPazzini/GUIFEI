package windows;

import gui2.FileManager;
import gui2.Model;
import java.awt.Color;

public class SolutionTypo extends javax.swing.JDialog {

    private FileManager fileM;

    public SolutionTypo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        fileM = Model.getInstance().getFileManager();

        Double time = fileM.gettStop() - fileM.gettStart();

        this.timeField.setText(time.toString());
        this.timeStepField.setText(((Double) fileM.getDeltaT()).toString());

        this.timeField.setVisible(false);
        this.timeStepField.setVisible(false);
        this.timeLabel.setVisible(false);
        this.timeStepLabel.setVisible(false);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        typeComboBox = new javax.swing.JComboBox();
        timeField = new javax.swing.JTextField();
        timeLabel = new javax.swing.JLabel();
        timeStepLabel = new javax.swing.JLabel();
        timeStepField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(178, 158));
        jPanel1.setMinimumSize(new java.awt.Dimension(178, 158));

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Static", "Modal Analisys", "Transient" }));
        typeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeComboBoxItemStateChanged(evt);
            }
        });

        timeLabel.setText("Time");

        timeStepLabel.setText("Time Step");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(timeStepLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeStepField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {timeLabel, timeStepLabel});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeStepField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeStepLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeComboBoxItemStateChanged
        String s = (String) typeComboBox.getSelectedItem();
        if (s.equals("Transient")) {
            this.timeField.setVisible(true);
            this.timeStepField.setVisible(true);
            this.timeLabel.setVisible(true);
            this.timeStepLabel.setVisible(true);
        } else {
            this.timeField.setVisible(false);
            this.timeStepField.setVisible(false);
            this.timeLabel.setVisible(false);
            this.timeStepLabel.setVisible(false);
        }
    }//GEN-LAST:event_typeComboBoxItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s = (String) typeComboBox.getSelectedItem();
        if (s.equals("Transient")) {
            boolean error = false;
            double time = 0;
            double deltaT = 0;
            try {
                timeLabel.setForeground(Color.black);
                time = Double.parseDouble(timeField.getText());
            } catch (NumberFormatException e) {
                timeLabel.setForeground(Color.red);
            }
            try {
                timeStepLabel.setForeground(Color.black);
                deltaT = Double.parseDouble(timeStepField.getText());
            } catch (NumberFormatException e) {
                timeStepLabel.setForeground(Color.red);
            }
            if (!error) {
                fileM.settStop(time);
                fileM.setDeltaT(deltaT);
                this.dispose();
            }
        }else{
            this.dispose();
        }
        //What to do when other option is selected on combobox
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField timeField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeStepField;
    private javax.swing.JLabel timeStepLabel;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables
}
