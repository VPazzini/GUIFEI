package gui2;

import elements.Edge;
import elements.Group;
import elements.Node;
import elements.Support;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import javax.swing.JDialog;
import windows.Constraint;
import windows.FluidFlow;
import windows.ForcesWindow;
import windows.Pressure;
import windows.Spring;
import windows.SupportParameters;

public class Model {

    private static final Model model = new Model();
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    private int nodeSize = 5;
    private int nodeNumber = 1;
    private int edgeNumber = 1;
    private final FileManager fileManager = new FileManager();

    private ArrayList<Node> selectedNodes = new ArrayList<>();
    private ArrayList<Edge> selectedEdges = new ArrayList<>();

    //group of elements
    private final ArrayList<Group> groups = new ArrayList<>();
    //group of elements
    
    //Meshing
    private boolean meshed = false;
    //Meshing
    
    public Node drawLine(int length, int ix, int iy) {
        meshed = false;
        Node n1 = new Node(new Point(ix, iy), nodeNumber++);
        Node n2 = new Node(new Point(ix + length, iy), nodeNumber++);
        newEdge(n1, n2);
        nodes.add(n1);
        nodes.add(n2);

        return n2;
    }

    public void drawLine(int length) {
        drawLine(length, 100, 50);
    }

    public void drawUbend(int length, int radius) {
        meshed = false;
        Path2D.Double path = new Path2D.Double();
        int ix = 100;
        int iy = 50;
        path.moveTo(ix + length, iy);
        path.curveTo(ix + length + radius, iy, ix + length + radius,
                iy + radius, ix + length, iy + radius);
        FlatteningPathIterator f = new FlatteningPathIterator(
                path.getPathIterator(new AffineTransform()), 1);

        Node n1 = new Node(new Point(ix, iy), nodeNumber++);
        Node n2 = new Node(new Point(ix, iy + radius), nodeNumber++);
        nodes.add(n1);
        nodes.add(n2);

        Edge edge = newEdge(n1, n2);

        float[] coords = new float[6];
        while (!f.isDone()) {
            f.currentSegment(coords);
            int x = (int) coords[0];
            int y = (int) coords[1];
            edge.insertPoint(new Point(x, y));
            f.next();
        }
    }

    public Point interpolationByDistance(Point p1, Point p2, double d) {
        double len = p1.distance(p2);
        double ratio = d / len;
        int x = (int) (ratio * p2.x + (1.0 - ratio) * p1.x);
        int y = (int) (ratio * p2.y + (1.0 - ratio) * p1.y);
        return (new Point(x, y));
    }

    private void splitEdge(Point p, boolean isNode) {
        Edge newEdge = null;
        int index = 0;
        int i = 0;
        for (Edge e : edges) {
            if (e.contains(p)) {
                Node n;
                if (isNode) {
                    n = new Node(p, nodeNumber++);

                    nodes.add(n);
                    newEdge = e.splitEdge(p, n, edgeNumber++);

                    index = i + 1;

                    n.addEdge(e);
                    n.addEdge(newEdge);
                } else {
                    n = new Support(p, nodeNumber++);
                    e.addSupport(p, (Support) n);
                    nodes.add(n);
                }
                break;
            }
            i++;
        }
        if (newEdge != null) {
            edges.add(index, newEdge);
        }
    }

    /**
     * Returns a Node which contains the given point on the screen. Or null if
     * there is none.
     *
     * @param p is the point used to find a Node
     * @return Closest Node to the given point, considering a limit boundary
     */
    public Node getNode(Point p) {
        for (Node n : nodes) {
            if (isInside(n, p)) {
                if (!(n instanceof Support)) {
                    return n;
                }
            }
        }
        return null;
    }

    public Support getSupport(Point p) {
        for (Node n : nodes) {
            if (isInside(n, p)) {
                if (n instanceof Support) {
                    return (Support) n;
                }
            }
        }
        return null;
    }

    private boolean isInside(Node n, Point p) {
        Point temp = (Point) n.getPos().clone();
        return p.distance(temp) <= (nodeSize / 1.6);
    }

    private Edge newEdge(Node n1, Node n2) {
        Edge newEdge1 = new Edge(n1, n2, edgeNumber);
        Edge newEdge2 = new Edge(n2, n1, edgeNumber);
        for (Edge e : edges) {
            if (e.equals(newEdge1) || e.equals(newEdge2)) {
                edges.remove(e);
                return null;
            }
        }
        edges.add(newEdge1);
        n1.addEdge(newEdge1);
        n2.addEdge(newEdge1);
        edgeNumber++;
        return newEdge1;
    }

    public void deleteAll() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.nodeNumber = 1;
        this.edgeNumber = 1;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public ArrayList<Node> getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(ArrayList<Node> selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    public ArrayList<Edge> getSelectedEdges() {
        return selectedEdges;
    }

    public void setSelectedEdges(ArrayList<Edge> selectedEdges) {
        this.selectedEdges = selectedEdges;
    }

    public void selectNodes(Point p1, Point p2) {
        Rectangle rect = new Rectangle(p1);
        rect.add(p2);

        for (Node n : nodes) {
            if (rect.contains(n.getPos())) {
                if (!selectedNodes.remove(n)) {
                    selectedNodes.add(n);
                }
            }
        }
    }

    public void selectEdges(Point p1, Point p2) {
        Rectangle rect = new Rectangle(p1);
        rect.add(p2);
        for (Edge e : edges) {
            ArrayList<Point> points = e.getPoints();
            for (int i = 0; i < points.size() - 1; i++) {
                Line2D line = new Line2D.Double(points.get(i), points.get(i + 1));
                if (line.intersects(rect)) {
                    if (!selectedEdges.remove(e)) {
                        selectedEdges.add(e);
                    }
                    break;
                }
            }
        }
    }

    public static synchronized Model getInstance() {
        return model;
    }

    public void addConstraint() {
        JDialog rest = new JDialog();
        rest.setSize(190, 120);
        rest.setModal(true);
        rest.setResizable(false);
        rest.setLocationRelativeTo(null);

        Node temp;
        Constraint r = new Constraint(rest);
        if (selectedNodes.size() == 1) {
            temp = selectedNodes.get(0);
            rest.setTitle("Node " + temp.getNumber());
            r = new Constraint(rest, temp.getRest(), temp.getForces());

        } else {
            rest.setTitle(selectedNodes.size() + " Nodes");
        }

        rest.add(r);

        rest.setVisible(true);

        for (Node t : selectedNodes) {
            t.setRest(r.getRest());
        }

        selectedNodes = new ArrayList<>();
        DrawInterface.getInstance().repaint();

    }

    public void addForce() {
        JDialog rest = new JDialog();
        rest.setSize(190, 240);
        rest.setTitle("Forces");
        rest.setModal(true);
        rest.setResizable(false);
        rest.setLocationRelativeTo(null);

        Node temp;
        ForcesWindow r = new ForcesWindow(rest);
        if (selectedNodes.size() == 1) {
            temp = selectedNodes.get(0);
            rest.setTitle("Node " + temp.getNumber());
            r = new ForcesWindow(rest, temp.getForces());
        } else {
            rest.setTitle(selectedNodes.size() + " Nodes");
        }

        rest.add(r);

        rest.setVisible(true);

        for (Node t : selectedNodes) {
            t.setForces(r.getForces());
        }

        selectedNodes = new ArrayList<>();
        DrawInterface.getInstance().repaint();
    }

    public void addSupport() {
        JDialog rest = new JDialog();
        rest.setSize(190, 240);
        rest.setModal(true);
        rest.setResizable(false);
        rest.setLocationRelativeTo(null);

        ArrayList<Support> supports = new ArrayList<>();

        for (Node n : selectedNodes) {
            if (n instanceof Support) {
                supports.add((Support) n);
            }
        }

        Node temp;
        SupportParameters r = new SupportParameters(rest);
        if (supports.size() == 1) {
            temp = supports.get(0);
            rest.setTitle("Support " + temp.getNumber());
            r = new SupportParameters(rest, (Support) temp);

        } else {
            rest.setTitle(supports.size() + " Supports");
        }

        rest.add(r);

        rest.setVisible(true);

        for (Support t : supports) {
            System.out.println("yeah");
        }

        selectedNodes = new ArrayList<>();
        DrawInterface.getInstance().repaint();
    }

    public void addSpring() {
        JDialog rest = new JDialog();
        rest.setSize(190, 240);
        rest.setModal(true);
        rest.setResizable(false);
        rest.setLocationRelativeTo(null);

        Edge temp;
        Spring r = new Spring(rest);
        if (selectedEdges.size() == 1) {
            temp = selectedEdges.get(0);
            rest.setTitle("Edge " + temp.getEdgeNumber());
            r = new Spring(rest, temp.getSpringValue(), temp.getSpringUnitVector());
        } else {
            rest.setTitle(selectedEdges.size() + " Nodes");
        }

        rest.add(r);

        rest.setVisible(true);

        for (Edge e : selectedEdges) {
            e.setSpringUnitVector(r.getUnitvector());
            e.setSpringValue(r.getValueSpring());
        }

        selectedEdges = new ArrayList<>();
        DrawInterface.getInstance().repaint();
    }

    public void addPressure() {
        JDialog rest = new JDialog();
        rest.setSize(190, 240);
        rest.setModal(true);
        rest.setResizable(false);
        rest.setLocationRelativeTo(null);

        Edge temp;
        Pressure r = new Pressure(rest);
        if (selectedEdges.size() == 1) {
            temp = selectedEdges.get(0);
            rest.setTitle("Edge " + temp.getEdgeNumber());
            r = new Pressure(rest, temp.getPressureValue(), temp.getPressureUnitVector());
        } else {
            rest.setTitle(selectedEdges.size() + " Nodes");
        }

        rest.add(r);
        rest.getRootPane().setDefaultButton(r.getOkButton());
        rest.setVisible(true);

        for (Edge e : selectedEdges) {
            e.setPressureUnitVector(r.getUnitVector());
            e.setPressureValue(r.getPressureValue());
        }

        selectedEdges = new ArrayList<>();
        DrawInterface.getInstance().repaint();
    }

    public void addFluidFlow() {
        JDialog rest = new JDialog();
        rest.setSize(190, 240);
        rest.setModal(true);
        rest.setResizable(false);
        rest.setLocationRelativeTo(null);

        Edge temp;
        FluidFlow r = new FluidFlow(rest);

        if (selectedEdges.size() == 1) {
            temp = selectedEdges.get(0);
            rest.setTitle("Edge " + temp.getEdgeNumber());
            r = new FluidFlow(rest, temp.getFlowVelocity(),
                    temp.getFluidDensity(), temp.getFlowUnitVector());
        } else {
            rest.setTitle(selectedEdges.size() + " Nodes");
        }

        rest.add(r);

        rest.setVisible(true);

        for (Edge e : selectedEdges) {
            e.setFlowUnitVector(r.getUnitvector());
            e.setFlowVelocity(r.getFlowVelocity());
            e.setFluidDensity(r.getFlowDensity());
        }

        selectedEdges = new ArrayList<>();
        DrawInterface.getInstance().repaint();
    }

    public void addGroup(float startF, float endF, float df, String met) {

        ArrayList<Group> toRemove = new ArrayList<>();
        for (Group g : groups) {
            g.getGroup().removeAll(selectedEdges);
            if (g.getGroup().isEmpty()) {
                toRemove.add(g);
            }
        }
        for (Group g : toRemove) {
            groups.remove(g);
        }

        groups.add(new Group(selectedEdges, startF, endF, df, met));
        selectedEdges = new ArrayList<>();
    }

    public void removeGroup(Group g) {
        this.groups.remove(g);
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void newNode(Point p1) {
        Node n = getNode(p1);
        if (n == null) {
            for (Edge e : edges) {
                if (e.contains(p1)) {
                    splitEdge(p1, true);
                    return;
                }
            }
            nodes.add(new Node(p1, nodeNumber++));
        } else {
            if (selectedNodes.isEmpty()) {
                selectedNodes.add(n);
            } else {
                if (!selectedNodes.remove(n)) {
                    selectedNodes.add(n);
                }
            }
        }
    }

    public void newSupport(Point p1) {
        Support s = getSupport(p1);
        if (s == null) {
            for (Edge e : edges) {
                if (e.contains(p1)) {
                    splitEdge(p1, false);
                    return;
                }
            }
            nodes.add(new Support(p1, nodeNumber++));
        } else {
            if (selectedNodes.isEmpty()) {
                selectedNodes.add(s);
            } else {
                if (!selectedNodes.remove(s)) {
                    selectedNodes.add(s);
                }
            }
        }
    }

    public void newEdge(Point p) {

        for (Edge e : edges) {
            if (e.contains(p)) {
                if (!selectedEdges.remove(e)) {
                    selectedEdges.add(e);
                }
                return;
            }
        }

        Node n = getNode(p);
        if (n != null) {
            if (selectedNodes.isEmpty()) {
                this.selectedNodes.add(n);
            } else {
                if (!selectedNodes.remove(n)) {
                    this.selectedNodes.add(n);
                }
            }
            if (selectedNodes.size() == 2) {
                this.newEdge(selectedNodes.get(0), selectedNodes.get(1));
                this.selectedNodes = new ArrayList<>();
            }

        }
    }

    public void deleteNode() {
        if (!selectedNodes.isEmpty()) {
            for (Node n : selectedNodes) {
                joinEdges(n);
                nodes.remove(n);
            }
        }
        selectedNodes = new ArrayList<>();
        DrawInterface.getInstance().repaint();
    }

    private void joinEdges(Node n) {
        if (n.edgesSize() > 1) {
            ArrayList<Edge> delete = new ArrayList<>();
            Edge e1 = n.getEdges().get(0);
            Edge e2 = n.getEdges().get(1);
            if (e2.getNode2().equals(e1.getNode1())) {
                e2.getPoints().addAll(e1.getPoints());
                e2.setNode2(e1.getNode2());
                delete.add(e1);
            }
            if (e1.getNode2().equals(e2.getNode1())) {
                e1.getPoints().addAll(e2.getPoints());
                e1.setNode2(e2.getNode2());
                delete.add(e2);
            }
            for (Edge e : delete) {
                edges.remove(e);
            }
        } else {
            if (n.edgesSize() == 1) {
                edges.remove(n.getEdges().get(0));
            }
        }
    }

    public void deleteEdge() {
        if (!selectedEdges.isEmpty()) {
            int con = 0;
            int eNode = 0;
            Edge dEdge = selectedEdges.get(0);

            for (Edge e : edges) {
                if (dEdge != e) {
                    if (e.getNode1().equals(dEdge.getNode1())) {
                        eNode = 1;
                        con++;
                    }
                    if (e.getNode1().equals(dEdge.getNode2())) {
                        eNode = 2;
                        con++;
                    }
                    if (e.getNode2().equals(dEdge.getNode1())) {
                        eNode = 1;
                        con++;
                    }
                    if (e.getNode2().equals(dEdge.getNode2())) {
                        eNode = 2;
                        con++;
                    }
                }
            }
            if (con == 1) {
                edges.remove(dEdge);
                if (eNode == 1) {
                    nodes.remove(dEdge.getNode2());
                } else {
                    nodes.remove(dEdge.getNode1());
                }
            } else {
                if (edges.size() == 1) {
                    nodes.remove(dEdge.getNode1());
                    nodes.remove(dEdge.getNode2());
                    edges.remove(dEdge);
                }
            }
            selectedEdges.remove(0);
        }
        DrawInterface.getInstance().repaint();
    }

    public int getNodeSize() {
        return nodeSize;
    }

    public void setNodeSize(int nodeSize) {
        this.nodeSize = nodeSize;
    }

    public void mesh(double maxElemLength) {
        meshed = true;
        ArrayList<Point> suppPoints = new ArrayList<>();
        for (Node n : nodes) {
            if (n instanceof Support) {
                suppPoints.add(n.getPos());
            }
        }
        for (Point p : suppPoints) {
            splitEdge(p, true);
        }

        ArrayList<Point> splitPoints = new ArrayList<>();
        for (Edge edge : edges) {

            double totalLength = edge.getLength();
            int numNodesCurve = ((int) Math.floor(totalLength / maxElemLength)) + 1;
            double elem = totalLength / (numNodesCurve - 1);
            double distance = 0;
            int j = 0;

            for (int i = 0; i < edge.getPoints().size() - 1; i++) {
                Point p1 = edge.getPoints().get(i);
                Point p2 = edge.getPoints().get(i + 1);
                distance += p1.distance(p2);

                while ((distance - 1) > elem) {

                    int dist = (int) (elem - (distance - p1.distance(p2)));
                    Point split = interpolationByDistance(p1, p2, dist);
                    distance = distance - elem;
                    splitPoints.add(split);
                    j++;
                }

            }
        }

        for (Point sPoint : splitPoints) {
            this.splitEdge(sPoint, true);
        }
        DrawInterface.getInstance().repaint();
    }

    public boolean isMeshed() {
        return meshed;
    }

}
