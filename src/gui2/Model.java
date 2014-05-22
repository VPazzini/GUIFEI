package gui2;

import elements.Edge;
import elements.Group;
import elements.Node;
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
import windows.Spring;

public class Model {

    private static Model model = new Model();
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();
    private final int nodeSize = 20;
    private int nodeNumber = 1;
    private int edgeNumber = 1;
    private FileManager fileManager = new FileManager();

    private ArrayList<Node> selectedNodes = new ArrayList<>();
    private ArrayList<Edge> selectedEdges = new ArrayList<>();

    //group of elements
    private ArrayList<Group> groups = new ArrayList<>();
    //group of elements

    public void drawLine(int length, int numNodes) {
        int ix = 100;
        int iy = 50;
        double elem = (length / (numNodes - 1));
        Node n1 = new Node(new Point(ix, iy), nodeNumber++);
        Node n2 = new Node(new Point(ix + length, iy), nodeNumber++);
        newEdge(n1, n2);
        nodes.add(n1);
        nodes.add(n2);
        ArrayList<Point> splitPoints = new ArrayList<>();
        for (int i = 0; i < numNodes - 2; i++) {
            double x = (ix + (i + 1) * elem);

            Point p = new Point((int) x, iy);
            this.splitEdge(p);
        }
    }

    public void drawUbend(int length, int width, int radius, int numNodes) {
        Path2D.Double path = new Path2D.Double();
        int ix = 100;
        int iy = 50;
        path.moveTo(ix, iy);
        path.lineTo(ix + length, iy);
        path.curveTo(ix + length + radius, iy, ix + length + radius,
                iy + width, ix + length, iy + width);
        path.lineTo(ix, iy + width);
        FlatteningPathIterator f = new FlatteningPathIterator(
                path.getPathIterator(new AffineTransform()), 1);

        Node n1 = new Node(new Point(100, 50), nodeNumber++);
        Node n2 = new Node(new Point(100, iy + width), nodeNumber++);
        nodes.add(n1);
        nodes.add(n2);
        Edge edge = new Edge(n1, n2, edgeNumber++);
        edges.add(edge);

        float[] coords = new float[6];
        while (!f.isDone()) {
            f.currentSegment(coords);
            int x = (int) coords[0];
            int y = (int) coords[1];
            edge.insertPoint(new Point(x, y));
            f.next();
        }

        ArrayList<Point> splitPoints = new ArrayList<>();
        double totalLength = edge.getLength();
        double elem = totalLength / (numNodes - 1);
        double distance = 0;
        for (int i = 0; i < edge.getPoints().size() - 1; i++) {
            Point p1 = edge.getPoints().get(i);
            Point p2 = edge.getPoints().get(i + 1);
            distance += p1.distance(p2);

            while ((distance - 1) > elem) {
                int dist = (int) (elem - (distance - p1.distance(p2)));
                Point split = interpolationByDistance(p1, p2, dist);
                distance = distance - elem;
                splitPoints.add(split);

            }

        }

        for (Point sPoint : splitPoints) {
            this.splitEdge(sPoint);
        }

    }

    public Point interpolationByDistance(Point p1, Point p2, double d) {
        double len = p1.distance(p2);
        double ratio = d / len;
        int x = (int) (ratio * p2.x + (1.0 - ratio) * p1.x);
        int y = (int) (ratio * p2.y + (1.0 - ratio) * p1.y);
        return (new Point(x, y));
    }

    private void splitEdge(Point p) {
        Edge newEdge = null;
        for (Edge e : edges) {
            if (e.belongToEdge(p)) {
                Node n = new Node(p, nodeNumber++);
                nodes.add(n);
                newEdge = e.splitEdge(p, n, edgeNumber++);
                break;
            }
        }
        if (newEdge != null) {
            edges.add(newEdge);
        }
    }

    private Node getNode(Point p) {
        for (Node n : nodes) {
            if (isInside(n, p)) {
                return n;
            }
        }
        return null;
    }

    private boolean isInside(Node n, Point p) {
        Point temp = (Point) n.getPos().clone();

        if (p.distance(temp) <= (nodeSize / 1.6)) {
            return true;
        }

        return false;
    }

    private void newEdge(Node n1, Node n2) {
        Edge newEdge1 = new Edge(n1, n2, edgeNumber);
        Edge newEdge2 = new Edge(n2, n1, edgeNumber);
        for (Edge e : edges) {
            if (e.equals(newEdge1) || e.equals(newEdge2)) {
                edges.remove(e);
                return;
            }
        }
        edges.add(newEdge1);
        edgeNumber++;
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
                this.selectedNodes.add(n);
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
                    this.selectedEdges.add(e);
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
        rest.setModal(true);
        rest.setResizable(false);
        rest.setLocationRelativeTo(null);

        Node temp;
        ForcesWindow r = new ForcesWindow(rest);
        if (selectedNodes.size() == 1) {
            temp = selectedNodes.get(0);
            rest.setTitle("Node " + temp.getNumber());
            r = new ForcesWindow(rest, temp.getForces());
        }

        rest.add(r);

        rest.setVisible(true);

        for (Node t : selectedNodes) {
            t.setForces(r.getForces());
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

        for (Group g : groups) {
            g.getGroup().removeAll(selectedEdges);
        }
        groups.add(new Group(selectedEdges, startF, endF, df, met));
        selectedEdges = new ArrayList<>();
    }

    public ArrayList<String> printGroups() {
        ArrayList<String> printList = new ArrayList<>();
        for (Group g : groups) {
            printList.add(g.toString());
        }
        return printList;
    }
}