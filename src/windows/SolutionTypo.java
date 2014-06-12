package windows;

import gui2.FileManager;
import gui2.Model;
import java.awt.Color;

public class SolutionTypo extends javax.swing.JDialog {
    
    private final FileManager fManager;
    
    public SolutionTypo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        fManager = Model.getInstance().getFileManager();
        
        Double time = fManager.gettStop() - fManager.gettStart();
        
        timeField.setText(time.toString());
        timeStepField.setText(fManager.getDeltaT() + "");
        dampingField.setText(fManager.getDamping() + "");
        typeComboBox.setSelectedIndex(fManager.getIsolut() - 1);
        intMethodComboBox.setSelectedIndex(fManager.getIntMethod() - 1);
        gammaField.setText(fManager.getGamma() + "");
        betaField.setText(fManager.getBeta() + "");
        
        visibleType();
        
        setLocationRelativeTo(null);
        setVisible(true);
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
        dampingLabel = new javax.swing.JLabel();
        dampingField = new javax.swing.JTextField();
        intMethodComboBox = new javax.swing.JComboBox();
        OKButton = new javax.swing.JButton();
        gammaLabel = new javax.swing.JLabel();
        gammaField = new javax.swing.JTextField();
        betaLabel = new javax.swing.JLabel();
        betaField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solution Type");

        jPanel1.setMaximumSize(new java.awt.Dimension(178, 158));
        jPanel1.setMinimumSize(new java.awt.Dimension(178, 158));

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Static", "Modal Analisys", "Transient" }));
        typeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeComboBoxItemStateChanged(evt);
            }
        });

        timeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        timeField.setText("0");

        timeLabel.setText("Time");
        timeLabel.setToolTipText("Total Time");

        timeStepLabel.setText("Time Step");

        timeStepField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        timeStepField.setText("0");

        dampingLabel.setText("Damping");

        dampingField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dampingField.setText("0");

        intMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Central Difference Method", "Newmark" }));
        intMethodComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                intMethodComboBoxItemStateChanged(evt);
            }
        });

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        gammaLabel.setText("Gamma");

        gammaField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gammaField.setText("0");

        betaLabel.setText("Beta");

        betaField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        betaField.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(timeStepLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeStepField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dampingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dampingField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(intMethodComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(gammaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gammaField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(betaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OKButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(betaField, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {betaLabel, dampingLabel, gammaLabel, timeLabel, timeStepLabel});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dampingLabel)
                    .addComponent(dampingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(intMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gammaLabel)
                    .addComponent(gammaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(betaLabel)
                    .addComponent(betaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OKButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeComboBoxItemStateChanged
        visibleType();
    }//GEN-LAST:event_typeComboBoxItemStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        String s = (String) typeComboBox.getSelectedItem();
        if (s.equals("Transient")) {
            boolean error = false;
            double time = 0;
            double deltaT = 0;
            double damping = 0;
            double gamma = 0;
            double beta = 0;
            
            try {
                timeLabel.setForeground(Color.black);
                time = Double.parseDouble(timeField.getText());
            } catch (NumberFormatException e) {
                timeLabel.setForeground(Color.red);
                error = true;
            }
            try {
                timeStepLabel.setForeground(Color.black);
                deltaT = Double.parseDouble(timeStepField.getText());
            } catch (NumberFormatException e) {
                timeStepLabel.setForeground(Color.red);
                error = true;
            }
            
            try {
                dampingLabel.setForeground(Color.black);
                damping = Double.parseDouble(dampingField.getText());
            } catch (NumberFormatException e) {
                dampingLabel.setForeground(Color.red);
                error = true;
            }
            
            try {
                gammaLabel.setForeground(Color.black);
                gamma = Double.parseDouble(gammaField.getText());
            } catch (NumberFormatException e) {
                gammaLabel.setForeground(Color.red);
                error = true;
            }
            
            try {
                betaLabel.setForeground(Color.black);
                beta = Double.parseDouble(betaField.getText());
            } catch (NumberFormatException e) {
                betaLabel.setForeground(Color.red);
                error = true;
            }
            
            if (!error) {
                fManager.settStop(time);
                fManager.setDeltaT(deltaT);
                fManager.setDamping(damping);
                fManager.setBeta(beta);
                fManager.setGamma(gamma);
                fManager.setIntMethod(intMethodComboBox.getSelectedIndex() + 1);
                fManager.setIsolut(typeComboBox.getSelectedIndex() + 1);
                this.dispose();
            }
        } else {
            fManager.setIsolut(typeComboBox.getSelectedIndex() + 1);
            this.dispose();
        }
    }//GEN-LAST:event_OKButtonActionPerformed

    private void intMethodComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_intMethodComboBoxItemStateChanged
        visibleMethod();
    }//GEN-LAST:event_intMethodComboBoxItemStateChanged
    
    private void visibleType() {
        String s = (String) typeComboBox.getSelectedItem();
        if (s.equals("Transient")) {
            timeField.setVisible(true);
            timeStepField.setVisible(true);
            timeLabel.setVisible(true);
            timeStepLabel.setVisible(true);
            dampingLabel.setVisible(true);
            dampingField.setVisible(true);
            intMethodComboBox.setVisible(true);
            visibleMethod();
        } else {
            timeField.setVisible(false);
            timeStepField.setVisible(false);
            timeLabel.setVisible(false);
            timeStepLabel.setVisible(false);
            dampingLabel.setVisible(false);
            dampingField.setVisible(false);
            intMethodComboBox.setVisible(false);
            
            gammaLabel.setVisible(false);
            gammaField.setVisible(false);
            betaLabel.setVisible(false);
            betaField.setVisible(false);
        }
    }
    
    private void visibleMethod() {
        String s = (String) intMethodComboBox.getSelectedItem();
        if (s.equals("Newmark")) {
            gammaLabel.setVisible(true);
            gammaField.setVisible(true);
            betaLabel.setVisible(true);
            betaField.setVisible(true);
        } else {
            gammaLabel.setVisible(false);
            gammaField.setVisible(false);
            betaLabel.setVisible(false);
            betaField.setVisible(false);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField betaField;
    private javax.swing.JLabel betaLabel;
    private javax.swing.JTextField dampingField;
    private javax.swing.JLabel dampingLabel;
    private javax.swing.JTextField gammaField;
    private javax.swing.JLabel gammaLabel;
    private javax.swing.JComboBox intMethodComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField timeField;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeStepField;
    private javax.swing.JLabel timeStepLabel;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables
}
