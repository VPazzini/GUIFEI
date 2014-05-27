package windows;

import java.awt.Color;
import javax.swing.JDialog;

public class Spring extends javax.swing.JPanel {

    private JDialog jDialog;
    private int[] unitvector = new int[3];
    private float valueSpring;

    public Spring(JDialog jDialog) {
        initComponents();
        this.jDialog = jDialog;
    }

    public Spring(JDialog jDialog, float springValue, int[] unitVector) {
        initComponents();
        this.jDialog = jDialog;
        this.valueField.setText(((Float) springValue).toString());
        x.setText(((Integer) unitVector[0]).toString());
        y.setText(((Integer) unitVector[1]).toString());
        z.setText(((Integer) unitVector[2]).toString());

    }

    public int[] getUnitvector() {
        return unitvector;
    }

    public float getValueSpring() {
        return valueSpring;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valueLabel = new javax.swing.JLabel();
        valueField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        x = new javax.swing.JTextField();
        xLabel = new javax.swing.JLabel();
        yLabel = new javax.swing.JLabel();
        y = new javax.swing.JTextField();
        z = new javax.swing.JTextField();
        zLabel = new javax.swing.JLabel();

        valueLabel.setText("Value");

        valueField.setText("0");

        jLabel2.setText("Unit Vector");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        x.setText("0");

        xLabel.setText("X");

        yLabel.setText("Y");

        y.setText("0");

        z.setText("0");

        zLabel.setText("Z");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(xLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(yLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {valueLabel, xLabel, yLabel, zLabel});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {valueField, x, y, z});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean error = false;
        try {
            xLabel.setForeground(Color.black);
            unitvector[0] = Integer.parseInt(x.getText());
        } catch (NumberFormatException e) {
            xLabel.setForeground(Color.red);
            error = true;
        }
        try {
            yLabel.setForeground(Color.black);
            unitvector[1] = Integer.parseInt(y.getText());
        } catch (NumberFormatException e) {
            yLabel.setForeground(Color.red);
            error = true;
        }
        try {
            zLabel.setForeground(Color.black);
            unitvector[2] = Integer.parseInt(z.getText());
        } catch (NumberFormatException e) {
            zLabel.setForeground(Color.red);
            error = true;
        }
        try {
            valueLabel.setForeground(Color.black);
            valueSpring = Float.parseFloat(valueField.getText());
        } catch (NumberFormatException e) {
            valueLabel.setForeground(Color.red);
            error = true;
        }
        
        if(!error){
            jDialog.dispose();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField valueField;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTextField x;
    private javax.swing.JLabel xLabel;
    private javax.swing.JTextField y;
    private javax.swing.JLabel yLabel;
    private javax.swing.JTextField z;
    private javax.swing.JLabel zLabel;
    // End of variables declaration//GEN-END:variables
}
