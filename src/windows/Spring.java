package windows;

import elements.Node;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JDialog;

public class Spring extends javax.swing.JPanel {

    private JDialog jDialog;
    private int[] unitvector = new int[3];
    private double springValue = 0;
    ArrayList<Node> listNodes = new ArrayList<>();

    public Spring(JDialog jDialog, ArrayList<Node> list) {
        initComponents();

        this.listNodes = list;
        this.jDialog = jDialog;
    }

    public Spring(JDialog jDialog, Node n) {
        initComponents();
        this.jDialog = jDialog;

        listNodes.add(n);

        this.valueField.setText(n.getSpringValue() + "");
        x.setText(n.getSpringUnitVector()[0] + "");
        y.setText(n.getSpringUnitVector()[1] + "");
        z.setText(n.getSpringUnitVector()[2] + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valueLabel = new javax.swing.JLabel();
        valueField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        xLabel = new javax.swing.JLabel();
        x = new javax.swing.JTextField();
        yLabel = new javax.swing.JLabel();
        y = new javax.swing.JTextField();
        zLabel = new javax.swing.JLabel();
        z = new javax.swing.JTextField();

        valueLabel.setText("Value");

        valueField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valueField.setText("0");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unit Vector"));

        xLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel.setText("X");

        x.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        x.setText("0");
        x.setMinimumSize(new java.awt.Dimension(6, 30));
        x.setName(""); // NOI18N
        x.setPreferredSize(new java.awt.Dimension(30, 20));

        yLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yLabel.setText("Y");

        y.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        y.setText("0");

        zLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zLabel.setText("Z");

        z.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        z.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(xLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {x, y, z});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(xLabel)
                .addComponent(yLabel)
                .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(zLabel)
                .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(valueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean error = false;
        try {
            xLabel.setForeground(Color.black);
            unitvector[0] = Integer.parseInt(x.getText());
            if (unitvector[0] != 0) {
                unitvector[0] /= Math.abs(unitvector[0]);
            }
        } catch (NumberFormatException e) {
            xLabel.setForeground(Color.red);
            error = true;
        }
        try {
            yLabel.setForeground(Color.black);
            unitvector[1] = Integer.parseInt(y.getText());
            if (unitvector[1] != 0) {
                unitvector[1] /= Math.abs(unitvector[1]);
            }
        } catch (NumberFormatException e) {
            yLabel.setForeground(Color.red);
            error = true;
        }
        try {
            zLabel.setForeground(Color.black);
            unitvector[2] = Integer.parseInt(z.getText());
            if (unitvector[2] != 0) {
                unitvector[2] /= Math.abs(unitvector[2]);
            }
        } catch (NumberFormatException e) {
            zLabel.setForeground(Color.red);
            error = true;
        }
        try {
            valueLabel.setForeground(Color.black);
            springValue = Float.parseFloat(valueField.getText());
        } catch (NumberFormatException e) {
            valueLabel.setForeground(Color.red);
            error = true;
        }

        if (!error) {

            for (Node n : listNodes) {
                n.setSpringUnitVector(unitvector);
                n.setSpringValue(springValue);
            }

            jDialog.dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
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
