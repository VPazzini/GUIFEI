package windows;

import gui2.FileManager;
import gui2.Model;
import java.awt.Color;

public class FEI extends javax.swing.JDialog {
    
    public FEI() {
        initComponents();
        this.setSize(380, 300);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        loadParameters();
        visible();
        this.setVisible(true);
    }
    
    private void loadParameters() {
        FileManager fManager = Model.getInstance().getFileManager();
        
        modelComboBox.setSelectedIndex(fManager.getTurbModel() - 1);
        nflexComboBox.setSelectedIndex(fManager.getnFlex() - 1);
        turbLossField.setText(fManager.getTurbLoss() + "");
        RLFCField.setText(fManager.getRLFC() + "");
        STDUCheckBox.setSelected(fManager.isVarSTDU());
        STDACheckBox.setSelected(fManager.isVarSTDA());
        areaAmpModelComboBox.setSelectedIndex(fManager.getAreaAmpModel() - 1);
        timeLagModelComboBox.setSelectedIndex(fManager.getTimeLagModel() - 1);
        
        dragCoeffField.setText(fManager.getDragCoeff() + "");
        DCL_DYField.setText(fManager.getDCL_DY() + "");
        pepMUField.setText(fManager.getPepMU() + "");
        
        conCoeffField.setText(fManager.getConCoeff() + "");
        conExpField.setText(fManager.getConExp() + "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        modelComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        nflexComboBox = new javax.swing.JComboBox();
        LEWPanel = new javax.swing.JPanel();
        turbLossLabel = new javax.swing.JLabel();
        turbLossField = new javax.swing.JTextField();
        RLFCLabel = new javax.swing.JLabel();
        RLFCField = new javax.swing.JTextField();
        STDUCheckBox = new javax.swing.JCheckBox();
        STDACheckBox = new javax.swing.JCheckBox();
        areaAmpModelComboBox = new javax.swing.JComboBox();
        timeLagModelComboBox = new javax.swing.JComboBox();
        PEPPanel = new javax.swing.JPanel();
        dragCoeffLabel = new javax.swing.JLabel();
        dragCoeffField = new javax.swing.JTextField();
        DCL_DYLabel = new javax.swing.JLabel();
        DCL_DYField = new javax.swing.JTextField();
        pepMULabel = new javax.swing.JLabel();
        pepMUField = new javax.swing.JTextField();
        ChenPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ConnorPanel = new javax.swing.JPanel();
        conCoeffLabel = new javax.swing.JLabel();
        conCoeffField = new javax.swing.JTextField();
        conExpLabel = new javax.swing.JLabel();
        conExpField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("FEI Model");

        modelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L&W", "P&P", "Chen", "Connors" }));
        modelComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modelComboBoxItemStateChanged(evt);
            }
        });

        jLabel2.setText("NFlex");

        nflexComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single Flexible Tube", "Flexible Array" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nflexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(modelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(nflexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        turbLossLabel.setText("Turbulent Losses Coefficient");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, turbLossField, org.jdesktop.beansbinding.ObjectProperty.create(), turbLossLabel, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        turbLossField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        turbLossField.setText("0");

        RLFCLabel.setLabelFor(RLFCField);
        RLFCLabel.setText("Relevant Length of the Fluid Constant");

        RLFCField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        RLFCField.setText("0");

        STDUCheckBox.setText("Steady State velocity varies along channel");

        STDACheckBox.setText("Steady State area varies along channel");

        areaAmpModelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Constant", "Linear", "Sigmoid Y&W 93", "Modified Sigmoid" }));

        timeLagModelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Original L&W", "L&W '86", "El Bouzidi and Hassan" }));

        javax.swing.GroupLayout LEWPanelLayout = new javax.swing.GroupLayout(LEWPanel);
        LEWPanel.setLayout(LEWPanelLayout);
        LEWPanelLayout.setHorizontalGroup(
            LEWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEWPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LEWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(STDACheckBox)
                    .addComponent(STDUCheckBox)
                    .addGroup(LEWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LEWPanelLayout.createSequentialGroup()
                            .addComponent(areaAmpModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(timeLagModelComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LEWPanelLayout.createSequentialGroup()
                            .addComponent(turbLossLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(turbLossField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, LEWPanelLayout.createSequentialGroup()
                            .addComponent(RLFCLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RLFCField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LEWPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {RLFCLabel, STDACheckBox, STDUCheckBox, turbLossLabel});

        LEWPanelLayout.setVerticalGroup(
            LEWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LEWPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LEWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turbLossLabel)
                    .addComponent(turbLossField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LEWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RLFCLabel)
                    .addComponent(RLFCField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(STDUCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(STDACheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LEWPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaAmpModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeLagModelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dragCoeffLabel.setText("Drag Coefficient");

        dragCoeffField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dragCoeffField.setText("0.1");

        DCL_DYLabel.setText("Lift Coefficient Derivative");

        DCL_DYField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        DCL_DYField.setText("0.1");

        pepMULabel.setText("Time Delay Multiplier");

        pepMUField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pepMUField.setText("0");

        javax.swing.GroupLayout PEPPanelLayout = new javax.swing.GroupLayout(PEPPanel);
        PEPPanel.setLayout(PEPPanelLayout);
        PEPPanelLayout.setHorizontalGroup(
            PEPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEPPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PEPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PEPPanelLayout.createSequentialGroup()
                        .addComponent(dragCoeffLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dragCoeffField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PEPPanelLayout.createSequentialGroup()
                        .addComponent(DCL_DYLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DCL_DYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PEPPanelLayout.createSequentialGroup()
                        .addComponent(pepMULabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pepMUField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PEPPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DCL_DYField, dragCoeffField, pepMUField});

        PEPPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DCL_DYLabel, dragCoeffLabel, pepMULabel});

        PEPPanelLayout.setVerticalGroup(
            PEPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEPPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PEPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dragCoeffLabel)
                    .addComponent(dragCoeffField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PEPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DCL_DYLabel)
                    .addComponent(DCL_DYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PEPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pepMULabel)
                    .addComponent(pepMUField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Default Library will be used.");

        javax.swing.GroupLayout ChenPanelLayout = new javax.swing.GroupLayout(ChenPanel);
        ChenPanel.setLayout(ChenPanelLayout);
        ChenPanelLayout.setHorizontalGroup(
            ChenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ChenPanelLayout.setVerticalGroup(
            ChenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        conCoeffLabel.setText("Connors Coefficient");

        conCoeffField.setText("2.4");

        conExpLabel.setText("Connors Exponent");

        conExpField.setText("0.5");

        javax.swing.GroupLayout ConnorPanelLayout = new javax.swing.GroupLayout(ConnorPanel);
        ConnorPanel.setLayout(ConnorPanelLayout);
        ConnorPanelLayout.setHorizontalGroup(
            ConnorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConnorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConnorPanelLayout.createSequentialGroup()
                        .addComponent(conCoeffLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conCoeffField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConnorPanelLayout.createSequentialGroup()
                        .addComponent(conExpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(conExpField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ConnorPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {conCoeffLabel, conExpLabel});

        ConnorPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {conCoeffField, conExpField});

        ConnorPanelLayout.setVerticalGroup(
            ConnorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConnorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConnorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conCoeffLabel)
                    .addComponent(conCoeffField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConnorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conExpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conExpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LEWPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PEPPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ChenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ConnorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LEWPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PEPPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConnorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OKButton)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modelComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modelComboBoxItemStateChanged
        visible();
    }//GEN-LAST:event_modelComboBoxItemStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        FileManager fManager = Model.getInstance().getFileManager();
        int input;
        
        input = nflexComboBox.getSelectedIndex() + 1;
        fManager.setnFlex(input);
        
        input = modelComboBox.getSelectedIndex() + 1;
        fManager.setTurbModel(input);
        
        switch (input) {
            case (1):
                saveLEW();
                break;
            case (2):
                savePEP();
                break;
            case (3):
                saveConnors();
                break;
            default:
                break;
        }
        Model.getInstance().setFei(true);
    }//GEN-LAST:event_OKButtonActionPerformed
    
    private void saveLEW() {
        FileManager fManager = Model.getInstance().getFileManager();
        double dInput;
        boolean error = false;
        
        turbLossLabel.setForeground(Color.black);
        try {
            dInput = Double.parseDouble(turbLossField.getText());
            fManager.setTurbLoss(dInput);
        } catch (NumberFormatException e) {
            error = true;
            turbLossLabel.setForeground(Color.red);
        }
        
        RLFCLabel.setForeground(Color.black);
        try {
            dInput = Double.parseDouble(RLFCField.getText());
            fManager.setRLFC(dInput);
        } catch (NumberFormatException e) {
            error = true;
            RLFCLabel.setForeground(Color.red);
        }
        
        fManager.setAreaAmpModel(areaAmpModelComboBox.getSelectedIndex() + 1);
        fManager.setTimeLagModel(timeLagModelComboBox.getSelectedIndex() + 1);
        fManager.setVarSTDU(STDUCheckBox.isSelected());
        fManager.setVarSTDA(STDACheckBox.isSelected());
        
        if (!error) {
            this.dispose();
        }
        
    }
    
    private void savePEP() {
        FileManager fManager = Model.getInstance().getFileManager();
        double dInput;
        boolean error = false;
        
        dragCoeffLabel.setForeground(Color.black);
        try {
            dInput = Double.parseDouble(dragCoeffField.getText());
            fManager.setDragCoeff(dInput);
        } catch (NumberFormatException e) {
            error = true;
            dragCoeffLabel.setForeground(Color.red);
        }
        
        DCL_DYLabel.setForeground(Color.black);
        try {
            dInput = Double.parseDouble(dragCoeffField.getText());
            fManager.setDCL_DY(dInput);
        } catch (NumberFormatException e) {
            error = true;
            DCL_DYLabel.setForeground(Color.red);
        }
        
        pepMULabel.setForeground(Color.black);
        try {
            dInput = Double.parseDouble(pepMUField.getText());
            fManager.setPepMU(dInput);
        } catch (NumberFormatException e) {
            error = true;
            pepMULabel.setForeground(Color.red);
        }
        
        if (!error) {
            this.dispose();
        }
    }
    
    private void saveConnors() {
        FileManager fManager = Model.getInstance().getFileManager();
        double dInput;
        boolean error = false;
        
        conCoeffLabel.setForeground(Color.black);
        try {
            dInput = Double.parseDouble(conCoeffField.getText());
            fManager.setConCoeff(dInput);
        } catch (NumberFormatException e) {
            error = true;
            conCoeffLabel.setForeground(Color.red);
        }
        
        conExpLabel.setForeground(Color.black);
        try {
            dInput = Double.parseDouble(conExpField.getText());
            fManager.setConExp(dInput);
        } catch (NumberFormatException e) {
            error = true;
            conExpLabel.setForeground(Color.red);
        }
        
        if (!error) {
            this.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChenPanel;
    private javax.swing.JPanel ConnorPanel;
    private javax.swing.JTextField DCL_DYField;
    private javax.swing.JLabel DCL_DYLabel;
    private javax.swing.JPanel LEWPanel;
    private javax.swing.JButton OKButton;
    private javax.swing.JPanel PEPPanel;
    private javax.swing.JTextField RLFCField;
    private javax.swing.JLabel RLFCLabel;
    private javax.swing.JCheckBox STDACheckBox;
    private javax.swing.JCheckBox STDUCheckBox;
    private javax.swing.JComboBox areaAmpModelComboBox;
    private javax.swing.JTextField conCoeffField;
    private javax.swing.JLabel conCoeffLabel;
    private javax.swing.JTextField conExpField;
    private javax.swing.JLabel conExpLabel;
    private javax.swing.JTextField dragCoeffField;
    private javax.swing.JLabel dragCoeffLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox modelComboBox;
    private javax.swing.JComboBox nflexComboBox;
    private javax.swing.JTextField pepMUField;
    private javax.swing.JLabel pepMULabel;
    private javax.swing.JComboBox timeLagModelComboBox;
    private javax.swing.JTextField turbLossField;
    private javax.swing.JLabel turbLossLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void visible() {
        String feiModel = (String) modelComboBox.getSelectedItem();
        switch (feiModel) {
            case ("L&W"):
                LEWPanel.setVisible(true);
                PEPPanel.setVisible(false);
                ChenPanel.setVisible(false);
                ConnorPanel.setVisible(false);
                break;
            case ("P&P"):
                LEWPanel.setVisible(false);
                PEPPanel.setVisible(true);
                ChenPanel.setVisible(false);
                ConnorPanel.setVisible(false);
                break;
            case ("Chen"):
                LEWPanel.setVisible(false);
                PEPPanel.setVisible(false);
                ChenPanel.setVisible(true);
                ConnorPanel.setVisible(false);
                break;
            case ("Connors"):
                LEWPanel.setVisible(false);
                PEPPanel.setVisible(false);
                ChenPanel.setVisible(false);
                ConnorPanel.setVisible(true);
                break;
            default:
                break;
        }
    }
}
