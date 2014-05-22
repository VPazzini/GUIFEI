package gui2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import windows.FlowGeometry;
import windows.Geometry;
import windows.Material;
import windows.SolutionTypo;
import windows.StraightLine;
import windows.Turbulence;
import windows.UBend;

public class MainWindow extends javax.swing.JFrame {

    private static MainWindow mainWindow = new MainWindow();
    private DrawInterface drawInterf;
    private Model model;
    Turbulence turb;

    public MainWindow() {
        initComponents();
        drawInterf = DrawInterface.getInstance();
        model = Model.getInstance();
        this.drawPanel.add(drawInterf);
        this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());

        this.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent evt) {
                        drawInterf.holdControl();
                    }

                    @Override
                    public void keyReleased(KeyEvent evt) {
                        drawInterf.releaseControl();
                    }

                });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawPanel = new javax.swing.JPanel();
        treePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        optionsTree = new javax.swing.JTree();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        drawPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Options");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Pre-Processor");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Element");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Geometry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Material");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Tube Configuration");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Library");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("U bend");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Straight");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Free");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Solution");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Apply");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Constraint");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Force");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Pressure");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Spring");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Fluid Flow");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Add Group");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Flow Excitation");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Geometry");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Turbulence");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("FEI");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Solution Typo");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        optionsTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        optionsTree.setFocusable(false);
        optionsTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsTreeMouseClicked(evt);
            }
        });
        optionsTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                optionsTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(optionsTree);

        javax.swing.GroupLayout treePanelLayout = new javax.swing.GroupLayout(treePanel);
        treePanel.setLayout(treePanelLayout);
        treePanelLayout.setHorizontalGroup(
            treePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, treePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        treePanelLayout.setVerticalGroup(
            treePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(treePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(treePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionsTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_optionsTreeValueChanged
        //optionSelection();
    }//GEN-LAST:event_optionsTreeValueChanged

    private void optionsTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsTreeMouseClicked
        optionSelection();
    }//GEN-LAST:event_optionsTreeMouseClicked

    private void optionSelection() {
        DefaultMutableTreeNode node
                = (DefaultMutableTreeNode) optionsTree.getLastSelectedPathComponent();

        if (node == null) {
            return;
        }

        String name = node.toString();

        switch (name) {
            case ("Geometry"):
                if (node.getParent().toString().equals("Element")) {
                    drawInterf.setSelectionNodeMode(false);
                    drawInterf.setSelectionEdgeMode(false);
                    new Geometry();

                }
                if (node.getParent().toString().equals("Flow Excitation")) {
                    drawInterf.setSelectionNodeMode(false);
                    drawInterf.setSelectionEdgeMode(false);
                    new FlowGeometry(new JFrame(), true);

                }
                break;
            case ("Material"):
                drawInterf.setSelectionNodeMode(false);
                drawInterf.setSelectionEdgeMode(false);
                new Material();
                break;
            case ("U bend"):
                drawInterf.setSelectionNodeMode(false);
                drawInterf.setSelectionEdgeMode(false);
                new UBend();
                break;
            case ("Straight"):
                drawInterf.setSelectionNodeMode(false);
                drawInterf.setSelectionEdgeMode(false);
                new StraightLine();
                break;
            case ("Constraint"):
                drawInterf.setSelectionNodeMode(true);
                drawInterf.setSelectionEdgeMode(false);
                break;
            case ("Force"):
                drawInterf.setSelectionNodeMode(true);
                drawInterf.setSelectionEdgeMode(false);
                break;
            case ("Pressure"):
                drawInterf.setSelectionNodeMode(true);
                drawInterf.setSelectionEdgeMode(false);
                break;
            case ("Spring"):
                drawInterf.setSelectionEdgeMode(true);
                drawInterf.setSelectionNodeMode(false);
                break;
            case ("Add Group"):
                drawInterf.setSelectionEdgeMode(true);
                drawInterf.setSelectionNodeMode(false);
                break;
            case ("Solution Typo"):
                drawInterf.setSelectionNodeMode(false);
                drawInterf.setSelectionEdgeMode(false);
                new SolutionTypo(new JFrame(), true);
                break;
            case ("Turbulence"):
                drawInterf.setSelectionNodeMode(false);
                drawInterf.setSelectionEdgeMode(false);
                turb = new Turbulence();
                break;
            default:
                break;
        }
    }

    public void elemSelected() {
        DefaultMutableTreeNode node
                = (DefaultMutableTreeNode) optionsTree.getLastSelectedPathComponent();

        if (node == null) {
            return;
        }

        if (model.getSelectedNodes().isEmpty()
                && model.getSelectedEdges().isEmpty()) {
            return;
        }

        String name = node.toString();
        switch (name) {
            case ("Constraint"):
                model.addConstraint();
                break;
            case ("Force"):
                model.addForce();
                break;
            case ("Pressure"):
                //drawInterf.setSelectionNodeMode(true);
                break;
            case ("Spring"):
                model.addSpring();
                break;
            case ("Add Group"):
                model.addFluidFlow();
                break;
            case ("Turbulence"):
                model.addGroup(turb.getStartFreq(), turb.getEndFreq(),
                        turb.getDFreq(), turb.getMethod() );
                turb.attList();
                break;
            default:
                System.out.println(name);
                break;
        }
        model.setSelectedNodes(new ArrayList<>());
        model.setSelectedEdges(new ArrayList<>());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MainWindow().setVisible(true);
                mainWindow.setVisible(true);
            }
        });
    }

    public static synchronized MainWindow getInstance() {
        return mainWindow;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel drawPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree optionsTree;
    private javax.swing.JPanel treePanel;
    // End of variables declaration//GEN-END:variables
}