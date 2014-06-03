package windows;

import gui2.DrawInterface;
import gui2.FileManager;
import gui2.Model;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;

public class MenuOptions extends javax.swing.JFrame {

    File path;

    public MenuOptions() {
        initComponents();
        Model model = Model.getInstance();
        DrawInterface draw = DrawInterface.getInstance();
        
        path = model.getFileManager().getFilePath();
        
        this.fileLocationField.setText(path.getAbsolutePath());
        this.fortranLocationField.setText(path.getAbsolutePath());
        this.nodeSizeSpinner.setValue(model.getNodeSize());
        this.forceBox.setSelected(draw.isShowForce());
        this.constBox.setSelected(draw.isShowConst());
        this.pressureBox.setSelected(draw.isShowPressure());
        this.springBox.setSelected(draw.isShowSpring());
        this.nodeNameBox.setSelected(draw.isShowNodeName());
        this.elementNameBox.setSelected(draw.isShowElementName());
        this.printLimitField.setText(model.getFileManager().getPrintLimit()+"");
        this.saveLimitField.setText(model.getFileManager().getSaveLimit()+"");
        
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fortranLocationField = new javax.swing.JTextField();
        fileLocationField = new javax.swing.JTextField();
        changeFileLocButton = new javax.swing.JButton();
        changeFortranLocButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nodeSizeSpinner = new javax.swing.JSpinner();
        constBox = new javax.swing.JCheckBox();
        forceBox = new javax.swing.JCheckBox();
        pressureBox = new javax.swing.JCheckBox();
        springBox = new javax.swing.JCheckBox();
        nodeNameBox = new javax.swing.JCheckBox();
        elementNameBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saveLimitField = new javax.swing.JTextField();
        printLimitField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(470, 400));

        jLabel1.setText("File Location");

        jLabel2.setText("Fortran Code Location");

        changeFileLocButton.setText("Change");
        changeFileLocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFileLocButtonActionPerformed(evt);
            }
        });

        changeFortranLocButton.setText("Change");
        changeFortranLocButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFortranLocButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileLocationField)
                    .addComponent(fortranLocationField, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changeFileLocButton)
                    .addComponent(changeFortranLocButton))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fileLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeFileLocButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fortranLocationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeFortranLocButton))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("File", jPanel1);

        jLabel3.setText("Node Size");

        nodeSizeSpinner.setModel(new javax.swing.SpinnerNumberModel(5, 2, 50, 1));

        constBox.setSelected(true);
        constBox.setText("Constraint");

        forceBox.setSelected(true);
        forceBox.setText("Force");

        pressureBox.setSelected(true);
        pressureBox.setText("Pressure");

        springBox.setSelected(true);
        springBox.setText("Spring");

        nodeNameBox.setText("Node Name");

        elementNameBox.setText("Element Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(nodeSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nodeNameBox)
                    .addComponent(elementNameBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(constBox)
                    .addComponent(forceBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pressureBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(springBox, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {constBox, forceBox, pressureBox, springBox});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {elementNameBox, nodeNameBox});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nodeSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(constBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nodeNameBox)
                    .addComponent(forceBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pressureBox)
                    .addComponent(elementNameBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(springBox)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Visual", jPanel2);

        jLabel4.setText("Save Limit");

        jLabel5.setText("Print Limit");

        saveLimitField.setText("1000");

        printLimitField.setText("1000");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printLimitField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveLimitField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(399, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(saveLimitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(printLimitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(269, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fortran", jPanel3);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OKButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changeFileLocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFileLocButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setPreferredSize(new Dimension(711, 400));
        chooser.setCurrentDirectory(path);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        if (file != null) {
            fileLocationField.setText(file.toString());
        }
    }//GEN-LAST:event_changeFileLocButtonActionPerformed

    private void changeFortranLocButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFortranLocButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(path);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        if (file != null) {
            fortranLocationField.setText(file.toString());
        }
    }//GEN-LAST:event_changeFortranLocButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        Model model = Model.getInstance();
        FileManager fManager = Model.getInstance().getFileManager();
        DrawInterface draw = DrawInterface.getInstance();
        
        fManager.setFilePath(new File(fileLocationField.getText()));
        fManager.setFortranPath(new File(fortranLocationField.getText()));
        fManager.setPrintLimit(Integer.parseInt(printLimitField.getText()));
        fManager.setSaveLimit(Integer.parseInt(saveLimitField.getText()));
        
        Model.getInstance().setNodeSize((Integer) nodeSizeSpinner.getValue());
        
        draw.setShowConst(constBox.isSelected());
        draw.setShowForce(forceBox.isSelected());
        draw.setShowSpring(springBox.isSelected());
        draw.setShowPressure(pressureBox.isSelected());
        draw.setShowNodeName(nodeNameBox.isSelected());
        draw.setShowElementName(elementNameBox.isSelected());
        
        draw.repaint();
        this.dispose();
    }//GEN-LAST:event_OKButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JButton changeFileLocButton;
    private javax.swing.JButton changeFortranLocButton;
    private javax.swing.JCheckBox constBox;
    private javax.swing.JCheckBox elementNameBox;
    private javax.swing.JTextField fileLocationField;
    private javax.swing.JCheckBox forceBox;
    private javax.swing.JTextField fortranLocationField;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox nodeNameBox;
    private javax.swing.JSpinner nodeSizeSpinner;
    private javax.swing.JCheckBox pressureBox;
    private javax.swing.JTextField printLimitField;
    private javax.swing.JTextField saveLimitField;
    private javax.swing.JCheckBox springBox;
    // End of variables declaration//GEN-END:variables
}
