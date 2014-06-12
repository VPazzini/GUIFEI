package windows;

import elements.Support;
import gui2.FileManager;
import gui2.Model;
import java.awt.Color;
import java.util.ArrayList;

public class SupportParameters extends javax.swing.JDialog {
    
    private ArrayList<Support> listSupports = new ArrayList<>();
    
    public SupportParameters(ArrayList<Support> list) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setTitle(list.size() + " Supports");
        
        listSupports = list;
        
        this.setVisible(true);
    }
    
    public SupportParameters(Support s) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setTitle("Support " + s.getNumber());
        
        typeComboBox.setSelectedIndex(s.getSupportType() - 1);
        gapField.setText(s.getGap() + "");
        normalUVXField.setText(s.getNormalUnitVector()[0] + "");
        normalUVYField.setText(s.getNormalUnitVector()[1] + "");
        normalUVZField.setText(s.getNormalUnitVector()[2] + "");
        offsetValueField.setText(s.getOffsetValue() + "");
        offsetUVXField.setText(s.getOffsetUnitVector()[0] + "");
        offsetUVYField.setText(s.getOffsetUnitVector()[1] + "");
        offsetUVZField.setText(s.getOffsetUnitVector()[2] + "");
        stiffnessField.setText(s.getStiffines() + "");
        iterationsField.setText(s.getIterations() + "");
        toleranceField.setText(s.getTolerence() + "");
        widthField.setText(s.getWidth() + "");
        
        listSupports.add(s);
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        OKButton = new javax.swing.JButton();
        widthField = new javax.swing.JTextField();
        widthLabel = new javax.swing.JLabel();
        toleranceLabel = new javax.swing.JLabel();
        toleranceField = new javax.swing.JTextField();
        iterationsField = new javax.swing.JTextField();
        iterationsLabel = new javax.swing.JLabel();
        dampLabel = new javax.swing.JLabel();
        dampField = new javax.swing.JTextField();
        stiffnessField = new javax.swing.JTextField();
        stiffnessLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        offsetUVXLabel = new javax.swing.JLabel();
        offsetUVXField = new javax.swing.JTextField();
        offsetUVYLabel = new javax.swing.JLabel();
        offsetUVYField = new javax.swing.JTextField();
        offsetUVZLabel = new javax.swing.JLabel();
        offsetUVZField = new javax.swing.JTextField();
        offsetValueLabel = new javax.swing.JLabel();
        offsetValueField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        normalUVXLabel = new javax.swing.JLabel();
        normalUVXField = new javax.swing.JTextField();
        normalUVYLabel = new javax.swing.JLabel();
        normalUVYField = new javax.swing.JTextField();
        normalUVZLabel = new javax.swing.JLabel();
        normalUVZField = new javax.swing.JTextField();
        gapLabel = new javax.swing.JLabel();
        gapField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(215, 500));

        jPanel2.setMinimumSize(new java.awt.Dimension(100, 352));

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        widthField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        widthField.setText("1");

        widthLabel.setText("Width");

        toleranceLabel.setText("Tolerance");

        toleranceField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        toleranceField.setText("1E-3");

        iterationsField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        iterationsField.setText("100");

        iterationsLabel.setText("Iterations");

        dampLabel.setText("Damp");

        dampField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dampField.setText("0.25");

        stiffnessField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        stiffnessField.setText("10E6");

        stiffnessLabel.setText("Stiffness");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Offset"));

        offsetUVXLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        offsetUVXLabel.setText("X");

        offsetUVXField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        offsetUVXField.setText("0");

        offsetUVYLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        offsetUVYLabel.setText("Y");

        offsetUVYField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        offsetUVYField.setText("0");

        offsetUVZLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        offsetUVZLabel.setText("Z");

        offsetUVZField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        offsetUVZField.setText("0");

        offsetValueLabel.setText("Value");

        offsetValueField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        offsetValueField.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(offsetValueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(offsetValueField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(offsetUVXLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(offsetUVXField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(offsetUVYLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(offsetUVYField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(offsetUVZLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(offsetUVZField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offsetValueLabel)
                    .addComponent(offsetValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offsetUVXLabel)
                    .addComponent(offsetUVXField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offsetUVYLabel)
                    .addComponent(offsetUVYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offsetUVZLabel)
                    .addComponent(offsetUVZField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Normal Unit Vector"));

        normalUVXLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        normalUVXLabel.setText("X");

        normalUVXField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        normalUVXField.setText("0");

        normalUVYLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        normalUVYLabel.setText("Y");

        normalUVYField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        normalUVYField.setText("0");

        normalUVZLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        normalUVZLabel.setText("Z");

        normalUVZField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        normalUVZField.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(normalUVXLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(normalUVXField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(normalUVYLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(normalUVYField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(normalUVZLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(normalUVZField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(normalUVZLabel)
                .addComponent(normalUVZField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(normalUVYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(normalUVYLabel)
                .addComponent(normalUVXField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(normalUVXLabel))
        );

        gapLabel.setText("Gap");

        gapField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gapField.setText("1");

        jLabel1.setText("Type");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Flat Bar", "Lattice (Square)", "Lattice (Diamete)", "Circular", "Broachod", "Scallop" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(widthLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(widthField))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(toleranceLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(toleranceField))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(iterationsLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(iterationsField))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(dampLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dampField))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(gapLabel))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gapField)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(stiffnessLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(stiffnessField))))
                .addContainerGap(5, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dampLabel, iterationsLabel, stiffnessLabel, toleranceLabel, widthLabel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gapLabel)
                    .addComponent(gapField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stiffnessLabel)
                    .addComponent(stiffnessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dampLabel)
                    .addComponent(dampField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iterationsLabel)
                    .addComponent(iterationsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toleranceLabel)
                    .addComponent(toleranceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(widthLabel)
                    .addComponent(widthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(OKButton)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        boolean error = false;
        
        int supportType;
        double gap = 0.5;
        int[] normalUnitVector = new int[3];
        int[] offsetUnitVector = new int[3];
        double offsetValue = 0;
        double stiffiness = 10E6;
        double damp = 0.25;
        int iterations = 100;
        double tolerence = 1E-3;
        double width = 0.1;
        
        supportType = typeComboBox.getSelectedIndex() + 1;
        
        try {
            gapLabel.setForeground(Color.black);
            gap = Double.parseDouble(gapField.getText());
        } catch (NumberFormatException e) {
            gapLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            offsetValueLabel.setForeground(Color.black);
            offsetValue = Double.parseDouble(offsetValueField.getText());
        } catch (NumberFormatException e) {
            offsetValueLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            stiffnessLabel.setForeground(Color.black);
            stiffiness = Double.parseDouble(stiffnessField.getText());
        } catch (NumberFormatException e) {
            stiffnessLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            toleranceLabel.setForeground(Color.black);
            tolerence = Double.parseDouble(toleranceField.getText());
        } catch (NumberFormatException e) {
            toleranceLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            widthLabel.setForeground(Color.black);
            width = Double.parseDouble(widthField.getText());
        } catch (NumberFormatException e) {
            widthLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            dampLabel.setForeground(Color.black);
            damp = Double.parseDouble(dampField.getText());
        } catch (NumberFormatException e) {
            dampField.setForeground(Color.red);
            error = true;
        }
        
        try {
            iterationsLabel.setForeground(Color.black);
            iterations = Integer.parseInt(iterationsField.getText());
        } catch (NumberFormatException e) {
            iterationsLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            normalUVXLabel.setForeground(Color.black);
            normalUnitVector[0] = Integer.parseInt(normalUVXField.getText());
        } catch (NumberFormatException e) {
            normalUVXLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            normalUVYLabel.setForeground(Color.black);
            normalUnitVector[1] = Integer.parseInt(normalUVYField.getText());
        } catch (NumberFormatException e) {
            normalUVYLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            normalUVZLabel.setForeground(Color.black);
            normalUnitVector[2] = Integer.parseInt(normalUVZField.getText());
        } catch (NumberFormatException e) {
            normalUVZLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            offsetUVXLabel.setForeground(Color.black);
            offsetUnitVector[0] = Integer.parseInt(offsetUVXField.getText());
        } catch (NumberFormatException e) {
            offsetUVXLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            offsetUVYLabel.setForeground(Color.black);
            offsetUnitVector[1] = Integer.parseInt(offsetUVYField.getText());
        } catch (NumberFormatException e) {
            offsetUVYLabel.setForeground(Color.red);
            error = true;
        }
        
        try {
            offsetUVZLabel.setForeground(Color.black);
            offsetUnitVector[2] = Integer.parseInt(offsetUVZField.getText());
        } catch (NumberFormatException e) {
            offsetUVZLabel.setForeground(Color.red);
            error = true;
        }
        
        if (!error) {
            
            for (Support s : listSupports) {
                s.setGap(gap);
                s.setDamp(damp);
                s.setIterations(iterations);
                s.setNormalUnitVector(normalUnitVector);
                s.setOffsetUnitVector(offsetUnitVector);
                s.setStiffines(stiffiness);
                s.setTolerence(tolerence);
                s.setWidth(width);
                s.setSupportType(supportType);
                s.setOffsetValue(offsetValue);
            }
            
            this.dispose();
        }

    }//GEN-LAST:event_OKButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField dampField;
    private javax.swing.JLabel dampLabel;
    private javax.swing.JTextField gapField;
    private javax.swing.JLabel gapLabel;
    private javax.swing.JTextField iterationsField;
    private javax.swing.JLabel iterationsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField normalUVXField;
    private javax.swing.JLabel normalUVXLabel;
    private javax.swing.JTextField normalUVYField;
    private javax.swing.JLabel normalUVYLabel;
    private javax.swing.JTextField normalUVZField;
    private javax.swing.JLabel normalUVZLabel;
    private javax.swing.JTextField offsetUVXField;
    private javax.swing.JLabel offsetUVXLabel;
    private javax.swing.JTextField offsetUVYField;
    private javax.swing.JLabel offsetUVYLabel;
    private javax.swing.JTextField offsetUVZField;
    private javax.swing.JLabel offsetUVZLabel;
    private javax.swing.JTextField offsetValueField;
    private javax.swing.JLabel offsetValueLabel;
    private javax.swing.JTextField stiffnessField;
    private javax.swing.JLabel stiffnessLabel;
    private javax.swing.JTextField toleranceField;
    private javax.swing.JLabel toleranceLabel;
    private javax.swing.JComboBox typeComboBox;
    private javax.swing.JTextField widthField;
    private javax.swing.JLabel widthLabel;
    // End of variables declaration//GEN-END:variables
}
