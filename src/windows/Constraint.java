package windows;

import elements.Node;
import java.util.ArrayList;

public class Constraint extends javax.swing.JDialog {

    private ArrayList<Node> listNodes = new ArrayList<>();

    public Constraint(ArrayList<Node> list) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setTitle(list.size() + " Nodes");

        this.listNodes = list;
        this.setVisible(true);
    }

    public Constraint(Node n) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setTitle("Node " + n.getNumber());

        listNodes.add(n);

        boolean[] rest = n.getConst();
        this.jCheckBoxX.setSelected(rest[0]);
        this.jCheckBoxY.setSelected(rest[1]);
        this.jCheckBoxZ.setSelected(rest[2]);
        this.jCheckBoxRX.setSelected(rest[3]);
        this.jCheckBoxRY.setSelected(rest[4]);
        this.jCheckBoxRZ.setSelected(rest[5]);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCheckBoxX = new javax.swing.JCheckBox();
        jCheckBoxY = new javax.swing.JCheckBox();
        jCheckBoxRX = new javax.swing.JCheckBox();
        jCheckBoxZ = new javax.swing.JCheckBox();
        jCheckBoxRY = new javax.swing.JCheckBox();
        jCheckBoxRZ = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(180, 110));
        setPreferredSize(new java.awt.Dimension(180, 150));

        jPanel1.setMinimumSize(new java.awt.Dimension(173, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(180, 150));

        jCheckBoxX.setText("X");

        jCheckBoxY.setText("Y");

        jCheckBoxRX.setText("RX");

        jCheckBoxZ.setText("Z");

        jCheckBoxRY.setText("RY");

        jCheckBoxRZ.setText("RZ");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxX)
                            .addComponent(jCheckBoxY))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxZ)
                            .addComponent(jCheckBoxRX))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxRY, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxRZ))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCheckBoxRX, jCheckBoxRZ, jCheckBoxX, jCheckBoxY, jCheckBoxZ});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxX)
                    .addComponent(jCheckBoxZ)
                    .addComponent(jCheckBoxRY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxY)
                    .addComponent(jCheckBoxRX)
                    .addComponent(jCheckBoxRZ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(189, 128));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean[] rest = new boolean[6];
        rest[0] = isX();
        rest[1] = isY();
        rest[2] = isZ();
        rest[3] = isRX();
        rest[4] = isRY();
        rest[5] = isRZ();

        for (Node t : listNodes) {
            t.setRest(rest);
        }

        this.dispose();
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
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
