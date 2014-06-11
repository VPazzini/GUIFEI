package windows;

import elements.Edge;
import gui2.Model;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JDialog;

public class FluidFlow extends javax.swing.JPanel {

    private final JDialog jDialog;
    private final int[] unitvector = new int[3];
    private float flowVelocity;
    private float flowDensity;
    private ArrayList<Edge> listEdges = new ArrayList<>();

    public FluidFlow(JDialog jDialog, ArrayList<Edge> list) {
        initComponents();
        this.jDialog = jDialog;
        listEdges = list;
    }

    public FluidFlow(JDialog jDialog, Edge e) {
        initComponents();
        this.jDialog = jDialog;
        this.flowVelocityField.setText(e.getFlowVelocity() + "");
        this.flowDensityField.setText(e.getFluidDensity() + "");
        x.setText(e.getFlowUnitVector()[0] + "");
        y.setText(e.getFlowUnitVector()[1] + "");
        z.setText(e.getFlowUnitVector()[2] + "");

        listEdges.add(e);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        flowVelocityLabel = new javax.swing.JLabel();
        flowVelocityField = new javax.swing.JTextField();
        flowDensityLabel = new javax.swing.JLabel();
        flowDensityField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        xLabel = new javax.swing.JLabel();
        x = new javax.swing.JTextField();
        yLabel = new javax.swing.JLabel();
        y = new javax.swing.JTextField();
        zLabel = new javax.swing.JLabel();
        z = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        flowVelocityLabel.setText("Velocity");

        flowVelocityField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        flowVelocityField.setText("0");

        flowDensityLabel.setText("Density");

        flowDensityField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        flowDensityField.setText("0");

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unit Vector"));

        xLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xLabel.setText("X");

        x.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        x.setText("0");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(xLabel)
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(yLabel)
                .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(zLabel)
                .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(flowVelocityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(flowVelocityField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(flowDensityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(flowDensityField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {flowDensityLabel, flowVelocityLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flowVelocityLabel)
                    .addComponent(flowVelocityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flowDensityLabel)
                    .addComponent(flowDensityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OKButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
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
            flowVelocityLabel.setForeground(Color.black);
            flowVelocity = Float.parseFloat(flowVelocityField.getText());
        } catch (NumberFormatException e) {
            flowVelocityLabel.setForeground(Color.red);
            error = true;
        }

        try {
            flowDensityLabel.setForeground(Color.black);
            flowDensity = Float.parseFloat(flowDensityField.getText());
        } catch (NumberFormatException e) {
            flowDensityLabel.setForeground(Color.red);
            error = true;
        }

        if (!error) {

            for (Edge e : listEdges) {
                e.setFlowUnitVector(unitvector);
                e.setFlowVelocity(flowVelocity);
                e.setFluidDensity(flowDensity);
            }
            Model.getInstance().setFluidFlow(true);
            jDialog.dispose();
        }
    }//GEN-LAST:event_OKButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField flowDensityField;
    private javax.swing.JLabel flowDensityLabel;
    private javax.swing.JTextField flowVelocityField;
    private javax.swing.JLabel flowVelocityLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField x;
    private javax.swing.JLabel xLabel;
    private javax.swing.JTextField y;
    private javax.swing.JLabel yLabel;
    private javax.swing.JTextField z;
    private javax.swing.JLabel zLabel;
    // End of variables declaration//GEN-END:variables
}
