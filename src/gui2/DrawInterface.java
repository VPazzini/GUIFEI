package gui2;

import elements.Edge;
import elements.Node;
import elements.Support;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import windows.SupportLocation;

public class DrawInterface extends JPanel implements ActionListener {

    private static final DrawInterface drawInterf = new DrawInterface();

    private Graphics2D g2d;
    private Model model;

    private boolean control = false;

    //Selection variables
    private boolean selectNodeMode = false;
    private boolean selectEdgeMode = false;
    private Point selectP1 = null;
    private Point selectP2 = null;
    //Selection variables

    //Free drawing variables
    private boolean newNode = false;
    private boolean newEdge = false;
    private boolean newSupport = false;
    //Free drawing variables

    private boolean showConst = true;
    private boolean showForce = true;
    private boolean showPressure = true;
    private boolean showSpring = true;
    private boolean showNodeName = false;
    private boolean showElementName = false;

    public DrawInterface() {
        model = Model.getInstance();
        this.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        if (evt.getButton() == MouseEvent.BUTTON1) {
                            if (selectNodeMode || selectEdgeMode) {
                                selectP1 = new Point(evt.getPoint());
                                selectP2 = new Point(evt.getPoint());
                            }
                            if (newNode) {
                                model.newNode(evt.getPoint());
                            }
                            if (newEdge) {
                                model.newEdge(evt.getPoint());
                            }
                            if (newSupport) {
                                model.newSupport(evt.getPoint());
                            }
                        }
                        if (evt.getButton() == MouseEvent.BUTTON3) {
                            if (newSupport) {
                                Support s = model.getSupport(evt.getPoint());
                                if (s != null) {
                                    new SupportLocation(s);
                                }
                            }

                        }
                        repaint();
                    }

                    @Override
                    public void mouseReleased(MouseEvent evt) {
                        if (selectEdgeMode || selectNodeMode) {
                            selectP2 = new Point(evt.getPoint());
                            if (selectNodeMode) {
                                model.selectNodes((Point) selectP1.clone(),
                                        (Point) selectP2.clone());
                            }

                            if (selectEdgeMode) {
                                model.selectEdges((Point) selectP1.clone(),
                                        (Point) selectP2.clone());
                            }

                            selectP1 = null;
                            selectP2 = null;

                            repaint();
                            if (!control) {
                                MainWindow.getInstance().elemSelected();
                            }
                        }

                    }

                });

        this.addMouseMotionListener(
                new MouseAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent evt) {
                        if (selectNodeMode || selectEdgeMode) {
                            selectP2.setLocation(evt.getPoint());
                        }
                        if (newNode || newSupport) {
                            if (!model.getSelectedNodes().isEmpty()) {
                                model.getSelectedNodes().get(0).setPos(evt.getPoint());
                            }
                        }
                        repaint();
                    }
                });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;

        ArrayList<Edge> edges = model.getEdges();
        ArrayList<Node> nodes = model.getNodes();

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        int h = this.getBounds().height - 30;
        int w = this.getBounds().width - 10;

        //<editor-fold defaultstate="collapsed" desc=" Drawing the coordinates symbol">
        g2d.drawLine(30, h, 55, h); //X
        g2d.drawLine(55, h, 49, h - 3);
        g2d.drawLine(55, h, 49, h + 3);
        g2d.drawString("x", 57, h);

        g2d.drawLine(30, h, 30, h - 25); //Y
        g2d.drawLine(30, h - 25, 33, h - 19);
        g2d.drawLine(30, h - 25, 27, h - 19);
        g2d.drawString("y", 32, h - 27);

        //g2d.drawLine(30, h, 20, h + 10); //Z
        //g2d.drawLine(20, h + 10, 23, h + 4);
        //g2d.drawLine(20, h + 10, 25, h + 8);
        //</editor-fold>
        if (selectEdgeMode || selectNodeMode) {
            if (selectP1 != null && selectP2 != null) {
                Rectangle rect = new Rectangle(selectP1);
                rect.add(selectP2);
                g2d.setColor(Color.blue);
                g2d.draw(rect);
                g2d.setColor(Color.black);
            }
        }

        for (Edge e : edges) {
            if (model.getSelectedEdges() != null) {
                if (model.getSelectedEdges().contains(e)) {
                    g2d.setColor(Color.red);
                }
            }
            for (int i = 0; i < e.getPoints().size() - 1; i++) {

                Point p1 = e.getPoints().get(i);
                Point p2 = e.getPoints().get(i + 1);
                g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
            }

            if (showElementName) {
                Point mP = e.middlePoint();
                g2d.drawString(e.getNumber() + "", mP.x + 5, mP.y - 5);
            }

            g2d.setColor(Color.red);

            if (showPressure && e.getPressureValue() != 0) {
                for (Shape s : e.getPressureArrow()) {
                    if (s != null) {
                        g2d.draw(s);
                    }
                }
            }

            g2d.setColor(Color.blue);

            if (showSpring) {
                /*if (e.getSpringValue() != 0) {
                    for (Shape s : e.getSpringArrow()) {
                        g2d.draw(s);
                    }
                }*/
            }

            g2d.setColor(Color.black);

        }

        int nodeSize = model.getNodeSize();
        for (Node n : nodes) {
            if (model.getSelectedNodes() != null) {
                if (model.getSelectedNodes().contains(n)) {
                    g2d.setColor(Color.red);
                }
            }

            if (showNodeName) {
                g2d.drawString(n.getNumber() + "",
                        n.getPos().x + nodeSize / 2, n.getPos().y - nodeSize / 2);
            }

            if (n instanceof Support) {
                /*g2d.draw3DRect(n.getPos().x - nodeSize / 2,
                 n.getPos().y - nodeSize / 2,
                 nodeSize, nodeSize, false);*/
                g2d.draw(((Support) n).getSupportShape());
            } else {
                g2d.drawOval(n.getPos().x - nodeSize / 2,
                        n.getPos().y - nodeSize / 2,
                        nodeSize, nodeSize);
            }
            g2d.setColor(Color.green);
            if (showForce) {
                for (Shape s : n.getForceArrows()) {
                    g2d.draw(s);
                }
            }

            g2d.setColor(Color.black);

            if (showConst) {
                for (Shape s : n.getConstraintArrow()) {
                    g2d.draw(s);
                }
                if (n.isZ()) {
                    g2d.draw3DRect(n.getPos().x - nodeSize / 2,
                            n.getPos().y - nodeSize / 2,
                            nodeSize, nodeSize, false);
                }
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

    public static synchronized DrawInterface getInstance() {
        return drawInterf;
    }

    public void setSelectionNodeMode(boolean mode) {
        if (!mode) {
            model.setSelectedNodes(new ArrayList<>());
        }
        this.selectNodeMode = mode;
    }

    public void setSelectionEdgeMode(boolean mode) {
        if (!mode) {
            model.setSelectedEdges(new ArrayList<>());
        }
        this.selectEdgeMode = mode;
    }

    public void setNewNode(boolean newNode) {
        this.newNode = newNode;
        model.setSelectedNodes(new ArrayList<>());
    }

    public void setNewSupport(boolean newSupport) {
        this.newSupport = newSupport;
        model.setSelectedNodes(new ArrayList<>());
    }

    public void setNewEdge(boolean newEdge) {
        this.newEdge = newEdge;
        model.setSelectedEdges(new ArrayList<>());
    }

    public void holdControl() {
        control = true;
    }

    public void releaseControl() {
        control = false;
    }

    public boolean isShowConst() {
        return showConst;
    }

    public void setShowConst(boolean showConst) {
        this.showConst = showConst;
    }

    public boolean isShowForce() {
        return showForce;
    }

    public void setShowForce(boolean showForce) {
        this.showForce = showForce;
    }

    public boolean isShowPressure() {
        return showPressure;
    }

    public void setShowPressure(boolean showPressure) {
        this.showPressure = showPressure;
    }

    public boolean isShowSpring() {
        return showSpring;
    }

    public void setShowSpring(boolean showSpring) {
        this.showSpring = showSpring;
    }

    public boolean isShowNodeName() {
        return showNodeName;
    }

    public void setShowNodeName(boolean showNodeName) {
        this.showNodeName = showNodeName;
    }

    public boolean isShowElementName() {
        return showElementName;
    }

    public void setShowElementName(boolean showElementName) {
        this.showElementName = showElementName;
    }

}
