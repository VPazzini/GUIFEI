package elements;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class Edge {

    private Node node1;
    private Node node2;
    private final ArrayList<Point> points = new ArrayList<>();
    private final int number;

    //Pressure
    private int[] pressureUnitVector = new int[3];
    private float pressureValue = 0;
    //Pressure

    //Fluid Flow
    private float flowVelocity;
    private float fluidDensity;
    private int[] flowUnitVector = new int[3];
    //Fluid Flow

    public Edge(Node node1, Node node2, int number) {
        this.node1 = node1;
        this.node2 = node2;
        this.number = number;
        points.add(node1.getPos());
        points.add(node2.getPos());
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

    public int getNumber() {
        return number;
    }
    
    /**
     * Returns an ArrayLIst of Points, the points are an ordered list
     * of all point that form the element.
     * @return 
     */
    public ArrayList<Point> getPoints() {
        this.points.set(0, node1.getPos());
        this.points.set(points.size() - 1, node2.getPos());
        return points;
    }
    
    /**
     * Return the total length of the element.
     * @return 
     */
    public double getLength() {
        double length = 0;
        double elem_length;
        for (int i = 0; i < points.size() - 1; i++) {
            elem_length = points.get(i).distance(points.get(i + 1));
            length += elem_length;
        }
        return length;
    }
    
    /**
     * Insert a new point at the end of the element.
     * @param p 
     */
    public void insertPoint(Point p) {
        if (p != null && !points.contains(p)) {
            points.add(points.size() - 1, p);
        }
    }
    
    /**
     * Return whether the element contain or no the given Point
     * @param p
     * @return 
     */
    public boolean contains(Point p) {
        Point p1 = new Point();
        Point p2 = new Point();
        for (int i = 0; i < points.size() - 1; i++) {
            p1.setLocation(points.get(i));
            p2.setLocation(points.get(i + 1));

            Point closePoint = getClosestPointOnSegment(p1.x, p1.y, p2.x, p2.y, p.x, p.y);
            if (closePoint == null) {
                return false;
            }
            if (closePoint.distance(p) < 10) {
                return true;
            }

        }
        return false;
    }

    /**
     * Return the two point that define the segment that contain
     * the given point.
     * @param p
     * @return 
     */
    public Point[] getSegment(Point p) {
        Point p1 = new Point();
        Point p2 = new Point();
        for (int i = 0; i < points.size() - 1; i++) {
            p1.setLocation(points.get(i));
            p2.setLocation(points.get(i + 1));

            Point closePoint = getClosestPointOnSegment(p1.x, p1.y, p2.x, p2.y, p.x, p.y);
            if (closePoint == null) {
                return null;
            }
            if (closePoint.distance(p) < 10) {
                Point[] seg = new Point[2];
                seg[0] = p1;
                seg[1] = p2;
                return seg;
            }

        }
        return null;
    }
    
    /**
     * Return the closest point to the given point.
     * @param p
     * @return 
     */
    public Point getClosestPointOnSegment(Point p) {
        Point p1, p2;
        
        int closeDist = 10;
        Point closestPoint = null;

        for (int i = 0; i < points.size() - 1; i++) {
            p1 = points.get(i);
            p2 = points.get(i + 1);

            Point closePoint = getClosestPointOnSegment(p1.x, p1.y, p2.x, p2.y, p.x, p.y);

            if (closePoint.distance(p) < closeDist) {
                closeDist = (int) closePoint.distance(p);
                closestPoint = closePoint;
            }
        }
        return closestPoint;
    }

    /**
     * Set the position of the given support to be over the
     * element.
     * @param p
     * @param supp 
     */
    public void addSupport(Point p, Support supp) {
        Point closestPoint = getClosestPointOnSegment(p);
        supp.setPos(closestPoint);
    }
    
    /**
     * Divide the element in the given point and update
     * the created node, and create a new edge.
     * @param p
     * @param newNode
     * @param edgeNumber The new Element's ID
     * @return 
     */
    public Edge splitEdge(Point p, Node newNode, int edgeNumber) {
        Point p1, p2;

        Edge newEdge = new Edge(newNode, node2, edgeNumber);

        int div = 0;
        int closeDist = 10;
        Point closestPoint = null;

        for (int i = 0; i < points.size() - 1; i++) {
            p1 = points.get(i);
            p2 = points.get(i + 1);

            Point closePoint = getClosestPointOnSegment(p1.x, p1.y, p2.x, p2.y, p.x, p.y);

            if (closePoint.distance(p) < closeDist) {
                closeDist = (int) closePoint.distance(p);
                div = i;
                closestPoint = closePoint;
            }
        }

        newNode.setPos(closestPoint);

        for (int i = div + 1; i < points.size();) {
            Point rPoint = points.remove(i);
            newEdge.insertPoint(rPoint);
        }
        this.points.add(closestPoint);

        this.node2.deleteEdge(this);
        this.node2.addEdge(0, newEdge);
        this.node2 = newNode;

        return newEdge;
    }
    
    /**
     * Returns the closest point on the segment defined by s1 and s2, to
     * the point p.
     * @param sx1
     * @param sy1
     * @param sx2
     * @param sy2
     * @param px
     * @param py
     * @return 
     */
    public Point getClosestPointOnSegment(int sx1, int sy1, int sx2, int sy2, int px, int py) {
        double xDelta = sx2 - sx1;
        double yDelta = sy2 - sy1;

        if ((xDelta == 0) && (yDelta == 0)) {
            return new Point(sx1, sy1);
        }

        double u = ((px - sx1) * xDelta + (py - sy1) * yDelta) / (xDelta * xDelta + yDelta * yDelta);

        final Point closestPoint;
        if (u < 0) {
            closestPoint = new Point(sx1, sy1);
        } else if (u > 1) {
            closestPoint = new Point(sx2, sy2);
        } else {
            closestPoint = new Point((int) Math.round(sx1 + u * xDelta), (int) Math.round(sy1 + u * yDelta));
        }

        return closestPoint;
    }
    
    /**
     * Return the distance over the element between the closest
     * point of p till the closest element's ending.
     * @param p
     * @return 
     */
    public double distanceFirstNode(Point p) {
        double distance1 = 0;
        Point p1, p2;

        for (int i = 0; i < points.size() - 1; i++) {
            p1 = points.get(i);
            p2 = points.get(i + 1);

            Point closePoint = getClosestPointOnSegment(p1.x, p1.y, p2.x, p2.y, p.x, p.y);
            if (closePoint.distance(p) < 5) {
                distance1 += p1.distance(p);
                break;
            } else {
                distance1 += p1.distance(p2);
            }
        }
        return distance1;
    }
    
    /**
     * Return the distance between the first point of the element
     * to the point P.
     * @param p
     * @return 
     */
    public double distance(Point p) {
        double distance1 = 0;
        double distance2 = 0;
        Point p1, p2;

        for (int i = 0; i < points.size() - 1; i++) {
            p1 = points.get(i);
            p2 = points.get(i + 1);

            Point closePoint = getClosestPointOnSegment(p1.x, p1.y, p2.x, p2.y, p.x, p.y);
            if (closePoint.distance(p) < 5) {
                distance1 += p1.distance(p);
                break;
            } else {
                distance1 += p1.distance(p2);
            }
        }

        for (int i = points.size() - 1; i > 0; i--) {
            p1 = points.get(i);
            p2 = points.get(i - 1);

            Point closePoint = getClosestPointOnSegment(p1.x, p1.y, p2.x, p2.y, p.x, p.y);

            if (closePoint.distance(p) < p1.distance(p2)) {
                distance2 += p1.distance(p);
                break;
            } else {
                distance2 += p1.distance(p2);
            }
        }

        return Math.min(distance1, distance2);
    }
    
    /**
     * Return the point that is at a distance Length to the Point p.
     * @param length the wanted distance between the point p and the
     * returned point.
     * @param p
     * @return 
     */
    public Point distance(double length, Point p) {
        double elem = length;
        double distance = 0;

        Point p1 = getPoints().get(0);
        Point p2 = getPoints().get(getPoints().size() - 1);
        if (p.distance(p1) < p.distance(p2)) {
            for (int i = 0; i < getPoints().size() - 1; i++) {
                p1 = getPoints().get(i);
                p2 = getPoints().get(i + 1);
                distance += p1.distance(p2);

                if (distance >= elem) {
                    double dist = (elem - (distance - p1.distance(p2)));
                    Point split = interpolationByDistance(p1, p2, dist);

                    return split;
                }

            }
        } else {
            for (int i = getPoints().size() - 1; i > 0; i--) {
                p1 = getPoints().get(i);
                p2 = getPoints().get(i - 1);
                distance += p1.distance(p2);

                if (distance >= elem) {
                    double dist = (elem - (distance - p1.distance(p2)));
                    Point split = interpolationByDistance(p1, p2, dist);
                    return split;
                }

            }
        }

        return null;
    }

    public float getFlowVelocity() {
        return flowVelocity;
    }

    public void setFlowVelocity(float flowVelocity) {
        this.flowVelocity = flowVelocity;
    }

    public float getFluidDensity() {
        return fluidDensity;
    }

    public void setFluidDensity(float fluidDensity) {
        this.fluidDensity = fluidDensity;
    }

    public int[] getFlowUnitVector() {
        return flowUnitVector;
    }

    public void setFlowUnitVector(int[] flowUnitVector) {
        this.flowUnitVector = flowUnitVector;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public int[] getPressureUnitVector() {
        return pressureUnitVector;
    }

    public void setPressureUnitVector(int[] pressureUnitVector) {
        this.pressureUnitVector = pressureUnitVector;
    }

    public float getPressureValue() {
        return pressureValue;
    }

    public void setPressureValue(float pressureValue) {
        this.pressureValue = pressureValue;
    }
    
    /**
     * Return the point in the middle of the element.
     * @return 
     */
    public Point middlePoint() {

        double totalLength = getLength();
        double elem = totalLength / 2;
        double distance = 0;
        int j = 0;

        Point split = null;

        for (int i = 0; i < getPoints().size() - 1; i++) {
            Point p1 = getPoints().get(i);
            Point p2 = getPoints().get(i + 1);
            distance += p1.distance(p2);

            if ((distance - 1) > elem) {
                int dist = (int) (elem - (distance - p1.distance(p2)));
                split = interpolationByDistance(p1, p2, dist);
                distance = distance - elem;
            }

        }
        return split;
    }

    public Shape[] getPressureArrow() {

        if (pressureValue == 0) {
            return null;
        }

        double totalLength = getLength();
        double elem = totalLength / 5;
        double distance = 0;

        ArrayList<Point> splitPoints = new ArrayList<>();
        Point split = null;

        for (int i = 0; i < getPoints().size() - 1; i++) {
            Point p1 = getPoints().get(i);
            Point p2 = getPoints().get(i + 1);
            distance += p1.distance(p2);

            while ((distance - 1) > elem) {
                int dist = (int) (elem - (distance - p1.distance(p2)));
                split = interpolationByDistance(p1, p2, dist);
                distance = distance - elem;
                splitPoints.add(split);
            }

        }

        //Point split = middlePoint();
        Shape[] arrows = new Shape[4];
        int i = 0;
        for (Point p : splitPoints) {

            double x = p.x;
            double y = p.y;

            if (pressureValue > 0) {
                x = p.x - 10 * pressureUnitVector[0]
                        * Math.log(pressureValue + 1);

                y = p.y + 10 * pressureUnitVector[1]
                        * Math.log(pressureValue + 1);

            }
            arrows[i++] = createArrow((float) x, (float) y,
                    p.x, p.y);

        }
        return arrows;
    }

    protected Shape createArrow(float fx, float fy, float tx, float ty) {
        int size = 7;
        float dx = tx - fx;
        float dy = ty - fy;
        float D = (float) Math.sqrt(dx * dx + dy * dy);
        float z = (dx <= 0) ? fx - D : fx + D;
        float dec = (dx <= 0) ? size : -size;

        GeneralPath gp = new GeneralPath();
        gp.moveTo(fx, fy);
        gp.lineTo(z, fy);
        gp.lineTo(z + dec, fy - size / 2);
        gp.moveTo(z, fy);
        gp.lineTo(z + dec, fy + size / 2);

        double alpha = (dx > 0) ? Math.asin(dy / D) : -Math.asin(dy / D);
        // transform the shape to follow the line direction
        return alpha != 0
                ? gp.createTransformedShape(AffineTransform.getRotateInstance(alpha, fx, fy))
                : gp;
    }

    public Point interpolationByDistance(Point p1, Point p2, double d) {
        double len = p1.distance(p2);
        double ratio = d / len;
        int x = (int) (ratio * p2.x + (1.0 - ratio) * p1.x);
        int y = (int) (ratio * p2.y + (1.0 - ratio) * p1.y);
        return (new Point(x, y));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (!this.node1.equals(other.node1)) {
            return false;
        }
        if (!this.node2.equals(other.node2)) {
            return false;
        }
        return true;
    }

}
