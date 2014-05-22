
package windows;

import elements.Force;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;


public class ForcesWindow extends javax.swing.JPanel {

    JDialog jDialog;
    DefaultListModel resultList;

    public ForcesWindow(JDialog jDialog) {
        initComponents();
        this.jDialog = jDialog;
        resultList = new DefaultListModel();
        jListForces.setModel(resultList);
    }

    public ForcesWindow(JDialog jDialog, ArrayList<Force> forces) {
        initComponents();
        this.jDialog = jDialog;
        resultList = new DefaultListModel();
        jListForces.setModel(resultList);

        for (Force f : forces) {
            resultList.addElement(f);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboForceAxis = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListForces = new javax.swing.JList();
        jTextFieldForceValue = new javax.swing.JTextField();
        jButtonAddForce = new javax.swing.JButton();
        jButtonRemoveForce = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jComboForceAxis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "X", "Y", "Z", "RX", "RY", "RZ" }));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(54, 100));

        jScrollPane1.setViewportView(jListForces);

        jTextFieldForceValue.setText("100");

        jButtonAddForce.setText("Add");
        jButtonAddForce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddForceActionPerformed(evt);
            }
        });

        jButtonRemoveForce.setText("Remove");
        jButtonRemoveForce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveForceActionPerformed(evt);
            }
        });

        jLabel1.setText("Axis");

        jLabel2.setText("Force Value");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRemoveForce, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddForce, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboForceAxis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldForceValue))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButtonAddForce, jButtonRemoveForce, jComboForceAxis, jTextFieldForceValue});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboForceAxis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldForceValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddForce)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoveForce)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddForceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddForceActionPerformed
        String axis = (String) this.jComboForceAxis.getSelectedItem();
        int force = 0;
        try {
            force = Integer.parseInt(jTextFieldForceValue.getText());
        } catch (Exception e) {
            force = 0;
        }
        Force f = new Force(axis, force);
        int ind = resultList.indexOf(f);

        if (ind == -1) {
            resultList.addElement(f);
        } else {
            f = (Force) resultList.get(ind);
            f.addForce(force);
            if (f.getForceValue() == 0) {
                resultList.remove(ind);
            } else {
                resultList.set(ind, f);
            }
        }
    }//GEN-LAST:event_jButtonAddForceActionPerformed

    private void jButtonRemoveForceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveForceActionPerformed
        int ind = jListForces.getSelectedIndex();
        if (ind != -1) {
            resultList.remove(ind);
        }
    }//GEN-LAST:event_jButtonRemoveForceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jDialog.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public ArrayList<Force> getForces() {
        ArrayList<Force> forces = new ArrayList<>();
        for (Object o : resultList.toArray()) {
            forces.add((Force) o);
        }
        return forces;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddForce;
    private javax.swing.JButton jButtonRemoveForce;
    private javax.swing.JComboBox jComboForceAxis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListForces;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldForceValue;
    // End of variables declaration//GEN-END:variables
}
