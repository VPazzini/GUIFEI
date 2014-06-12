package windows;

import gui2.FileManager;
import gui2.Model;
import java.awt.Color;

public class FlowGeometry extends javax.swing.JDialog {

    public FlowGeometry() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setModal(true);

        bTypeComboBox.setSelectedIndex(
                Model.getInstance().getFileManager().getbType() - 1
        );
        PTDTextField.setText(Model.getInstance().getFileManager().getP_d() + "");

        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bTypeComboBox = new javax.swing.JComboBox();
        OKButton = new javax.swing.JButton();
        PTDLabel = new javax.swing.JLabel();
        PTDTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "In Line", "Rotated Square", "Normal Triangle", "Parallel Triangle" }));

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        PTDLabel.setText("Pitch to Diameter Ratio");

        PTDTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        PTDTextField.setText("1.25");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PTDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PTDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PTDLabel)
                    .addComponent(PTDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OKButton)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        FileManager fManager = Model.getInstance().getFileManager();
        fManager.setbType(bTypeComboBox.getSelectedIndex() + 1);

        double ptd = 0;
        try {
            PTDLabel.setForeground(Color.black);
            ptd = Double.parseDouble(PTDTextField.getText());

            if (ptd >= 1.25 && ptd <= 3) {
                fManager.setP_d(ptd);
                this.dispose();
            } else {
                PTDLabel.setForeground(Color.red);
            }
        } catch (Exception e) {
            PTDLabel.setForeground(Color.red);
        }
    }//GEN-LAST:event_OKButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel PTDLabel;
    private javax.swing.JTextField PTDTextField;
    private javax.swing.JComboBox bTypeComboBox;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
