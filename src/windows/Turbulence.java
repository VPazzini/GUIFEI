package windows;

import gui2.FileManager;
import gui2.Model;
import java.awt.Color;
import javax.swing.DefaultListModel;

public class Turbulence extends javax.swing.JFrame {

    public Turbulence() {
        initComponents();
        this.setLocationRelativeTo(null);
        showInfo();
        this.setVisible(true);
    }

    private void showInfo() {
        FileManager fManager = Model.getInstance().getFileManager();
        startFreqField.setText(fManager.getTurbF1() + "");
        endFreqField.setText(fManager.getTurbF2() + "");
        dfFreqField.setText(fManager.getTurbDF() + "");
        turbMetCombo.setSelectedIndex(fManager.getTurbModel() - 1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startLabel = new javax.swing.JLabel();
        startFreqField = new javax.swing.JTextField();
        endLabel = new javax.swing.JLabel();
        endFreqField = new javax.swing.JTextField();
        dfLabel = new javax.swing.JLabel();
        dfFreqField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        turbMetCombo = new javax.swing.JComboBox();
        corrLenLabel = new javax.swing.JLabel();
        corrLenField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Frequency Input"));

        startLabel.setText("Start");

        startFreqField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        startFreqField.setText("0");

        endLabel.setText("End");

        endFreqField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        endFreqField.setText("60");

        dfLabel.setText("DF");

        dfFreqField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dfFreqField.setText("0.1");

        jLabel4.setText("Turbulence Model");

        turbMetCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ziada", "Pettigrew" }));

        corrLenLabel.setText("Correlation Length");

        corrLenField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        corrLenField.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(startLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endLabel)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dfLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dfFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(turbMetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(corrLenLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(corrLenField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dfLabel, endLabel, startLabel});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startLabel)
                    .addComponent(startFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endLabel)
                    .addComponent(endFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dfLabel)
                    .addComponent(dfFreqField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(corrLenLabel)
                    .addComponent(corrLenField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(turbMetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FileManager fManager = Model.getInstance().getFileManager();
        boolean error = false;
        double fInput;
        int input;

        startLabel.setForeground(Color.black);
        endLabel.setForeground(Color.black);
        dfLabel.setForeground(Color.black);
        corrLenLabel.setForeground(Color.black);
        try {
            fInput = Double.parseDouble(startFreqField.getText());
            fManager.setTurbF1(fInput);
        } catch (NumberFormatException e) {
            error = true;
            startLabel.setForeground(Color.red);
        }
        try {
            fInput = Double.parseDouble(endFreqField.getText());
            fManager.setTurbF2(fInput);
        } catch (NumberFormatException e) {
            error = true;
            endLabel.setForeground(Color.red);
        }
        try {
            fInput = Double.parseDouble(dfFreqField.getText());
            fManager.setTurbDF(fInput);
        } catch (NumberFormatException e) {
            error = true;
            dfLabel.setForeground(Color.red);
        }
        try {
            fInput = Double.parseDouble(corrLenField.getText());
            fManager.setCorrLen(fInput);
        } catch (NumberFormatException e) {
            error = true;
            corrLenLabel.setForeground(Color.red);
        }
        input = turbMetCombo.getSelectedIndex() + 1;
        fManager.setTurbModel(input);
        if (!error) {
            this.dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public float getStartFreq() {
        float startf;
        try {
            startf = Float.parseFloat(startFreqField.getText());
        } catch (NumberFormatException e) {
            startf = 0;
            System.out.println(e);
        }
        return startf;
    }

    public float getEndFreq() {
        float endf;
        try {
            endf = Float.parseFloat(endFreqField.getText());
        } catch (NumberFormatException e) {
            endf = 0;
            System.out.println(e);
        }
        return endf;
    }

    public float getDFreq() {
        float df;
        try {
            df = Float.parseFloat(dfFreqField.getText());
        } catch (NumberFormatException e) {
            df = 0;
            System.out.println(e);
        }
        return df;
    }

    public String getMethod() {
        String s = (String) turbMetCombo.getSelectedItem();
        return s;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField corrLenField;
    private javax.swing.JLabel corrLenLabel;
    private javax.swing.JTextField dfFreqField;
    private javax.swing.JLabel dfLabel;
    private javax.swing.JTextField endFreqField;
    private javax.swing.JLabel endLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField startFreqField;
    private javax.swing.JLabel startLabel;
    private javax.swing.JComboBox turbMetCombo;
    // End of variables declaration//GEN-END:variables
}
