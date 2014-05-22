package windows;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import elements.Force;

public class Constraint extends javax.swing.JPanel {

    JDialog jFrame;

    public Constraint(JDialog jFrame) {
        initComponents();
        this.jFrame = jFrame;

    }
    
    public Constraint(JDialog jFrame, boolean[] rest, ArrayList<Force> forces) {
        initComponents();
        this.jFrame = jFrame;
        this.jCheckBoxX.setSelected(rest[0]);
        this.jCheckBoxY.setSelected(rest[1]);
        this.jCheckBoxZ.setSelected(rest[2]);
        this.jCheckBoxRX.setSelected(rest[3]);
        this.jCheckBoxRY.setSelected(rest[4]);
        this.jCheckBoxRZ.setSelected(rest[5]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jCheckBoxRZ = new javax.swing.JCheckBox();
        jCheckBoxRX = new javax.swing.JCheckBox();
        jCheckBoxY = new javax.swing.JCheckBox();
        jCheckBoxX = new javax.swing.JCheckBox();
        jCheckBoxZ = new javax.swing.JCheckBox();
        jCheckBoxRY = new javax.swing.JCheckBox();

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBoxRZ.setText("RZ");

        jCheckBoxRX.setText("RX");

        jCheckBoxY.setText("Y");

        jCheckBoxX.setText("X");

        jCheckBoxZ.setText("Z");

        jCheckBoxRY.setText("RY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxX)
                            .addComponent(jCheckBoxY))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jCheckBoxZ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxRY))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxRX)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxRZ)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCheckBoxRX, jCheckBoxRY, jCheckBoxRZ, jCheckBoxX, jCheckBoxY, jCheckBoxZ});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxX)
                    .addComponent(jCheckBoxZ)
                    .addComponent(jCheckBoxRY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxY)
                    .addComponent(jCheckBoxRX)
                    .addComponent(jCheckBoxRZ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jFrame.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean isX() {
        return jCheckBoxX.isSelected();
    }

    public boolean isY() {
        return jCheckBoxY.isSelected();
    }

    public boolean isZ() {
        return jCheckBoxZ.isSelected();
    }

    public boolean isRX() {
        return jCheckBoxRX.isSelected();
    }

    public boolean isRY() {
        return jCheckBoxRY.isSelected();
    }

    public boolean isRZ() {
        return jCheckBoxRZ.isSelected();
    }

    public boolean[] getRest() {
        boolean[] rest = new boolean[6];
        rest[0] = isX();
        rest[1] = isY();
        rest[2] = isZ();
        rest[3] = isRX();
        rest[4] = isRY();
        rest[5] = isRZ();
        return rest;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxRX;
    private javax.swing.JCheckBox jCheckBoxRY;
    private javax.swing.JCheckBox jCheckBoxRZ;
    private javax.swing.JCheckBox jCheckBoxX;
    private javax.swing.JCheckBox jCheckBoxY;
    private javax.swing.JCheckBox jCheckBoxZ;
    // End of variables declaration//GEN-END:variables
}
