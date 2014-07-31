package elements;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class Node {

    protected Point pos;
    private Boolean x = false;
    private Boolean y = false;
    private Boolean z = false;
    private Boolean Rx = false;
    private Boolean Ry = false;
    private Boolean Rz = false;
    protected final int number;
    private ArrayList<Force> forces = new ArrayList<>();
    protected final ArrayList<Edge> edges = new ArrayList<>();

    //Spring
    private int[] springUnitVector = new int[3];
    private double springValue = 0;
    //Spring

    public Node(Point pos, int number) {
        this.pos = pos;
        this.number = number;
    }
    
    /**
     *  Return the shape of an arrow representing the forces
     * applied to the node.
     * 
     * @return 
     */
    public Shape[] getForceArrows() {
        float xSum = pos.x;
        float ySum = pos.y;
        float zSum = 0;
        float rXSum = pos.x;
        float rYSum = pos.y;
        float rZSum = 0;
        float temp;
        Shape[] shapes = new Shape[2];

        for (Force f : forces) {
            temp = (f.getValue() > 0
                    ? -5 : +5) * ((int) Math.log(Math.abs(f.getValue())));
            switch (f.getAxis()) {
                case ("Y"):
                    ySum -= temp;
                    break;
                case ("X"):
                    xSum += temp;
                    break;
                case ("Z"):
                    zSum += temp;
                    break;
                case ("RX"):
                    rXSum += temp;
                    break;
                case ("RY"):
                    rYSum += temp;
                    break;
                case ("RZ"):
                    rZSum += temp;
                    break;
                default:
                    break;
            }
        }

        shapes[0] = createArrow(xSum, ySum, pos.x, pos.y, false);
        shapes[1] = createArrow(rXSum, rYSum, pos.x, pos.y, true);

        return shapes;
    }

    public Shape getConstraintArrow() {
        int size = 40;
        Shape shape = null;
        if (x || y || z || Rx || Ry || Rz) {
            shape = createTriangle(pos.x, pos.y - size, pos.x, pos.y, false);
        }

        return shape;
    }

    protected Shape createArrow(float fx, float fy, float tx, float ty, boolean rot) {
        int size = 7;
        float dx = tx - fx;
        float dy = ty - fy;
        float D = (float) Math.sqrt(dx * dx + dy * dy);
        float z = (dx <= 0) ? fx - D : fx + D;
        float mid = (dx <= 0) ? fx - D / 2 : fx + D / 2;
        float dec = (dx <= 0) ? size : -size;

        GeneralPath gp = new GeneralPath();
        gp.moveTo(fx, fy);
        gp.lineTo(z, fy);
        gp.lineTo(z + dec, fy - size / 2);
        gp.moveTo(z, fy);
        gp.lineTo(z + dec, fy + size / 2);

        if (rot) {
            gp.moveTo(mid + dec, fy - size / 2);
            gp.curveTo(mid, fy - size, mid, fy + size, mid + dec, fy + size / 2);
        }
        double alpha = (dx > 0) ? Math.asin(dy / D) : -Math.asin(dy / D);
        return alpha != 0
                ? gp.createTransformedShape(AffineTransform.getRotateInstance(alpha, fx, fy))
                : gp;
    }

    protected Shape createTriangle(float fx, float fy, float tx, float ty, boolean rot) {
        int size = 15;
        float dx = tx - fx;
        float dy = ty - fy;
        float D = (float) Math.sqrt(dx * dx + dy * dy);
        float z = (dx <= 0) ? fx - D : fx + D;
        float mid = (dx <= 0) ? fx - D / 2 : fx + D / 2;
        float dec = (dx <= 0) ? size : -size;

        GeneralPath gp = new GeneralPath();
        gp.moveTo(z, fy);
        //gp.lineTo(z, fy);
        gp.lineTo(z + dec, fy - size / 2);
        gp.moveTo(z, fy);
        gp.lineTo(z + dec, fy + size / 2);
        gp.lineTo(z + dec, fy - size / 2);

        if (rot) {
            gp.moveTo(mid + dec, fy - size / 2);
            gp.curveTo(mid, fy - size, mid, fy + size, mid + dec, fy + size / 2);
        }
        double alpha = (dx > 0) ? Math.asin(dy / D) : -Math.asin(dy / D);
        // transform the shape to follow the line direction
        return alpha != 0
                ? gp.createTransformedShape(AffineTransform.getRotateInstance(alpha, fx, fy))
                : gp;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int edgesSize() {
        return edges.size();
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public void addEdge(int index, Edge e) {
        edges.add(index, e);
    }

    public void deleteEdge(Edge e) {
        edges.remove(e);
    }

    public ArrayList<Force> getForces() {
        return forces;
    }

    public void setForces(ArrayList<Force> forces) {
        this.forces = forces;
    }

    public void addForce(String axis, int forceValue) {
        this.forces.add(new Force(axis, forceValue));
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Boolean isX() {
        return x;
    }

    public void setX(Boolean x) {
        this.x = x;
    }

    public Boolean isY() {
        return y;
    }

    public void setY(Boolean y) {
        this.y = y;
    }

    public Boolean isZ() {
        return z;
    }

    public void setZ(Boolean z) {
        this.z = z;
    }

    public Boolean isRx() {
        return Rx;
    }

    public void setRx(Boolean Rx) {
        this.Rx = Rx;
    }

    public Boolean isRy() {
        return Ry;
    }

    public void setRy(Boolean Ry) {
        this.Ry = Ry;
    }

    public Boolean isRz() {
        return Rz;
    }

    public void setRz(Boolean Rz) {
        this.Rz = Rz;
    }
    
    /**
     * Returns a boolean vector with the constraints.
     * @return 
     */
    public boolean[] getConst() {
        boolean[] constraint = new boolean[6];
        constraint[0] = x;
        constraint[1] = y;
        constraint[2] = z;
        constraint[3] = Rx;
        constraint[4] = Ry;
        constraint[5] = Rz;
        return constraint;
    }
    
    /**
     * Set the Constraint of the Node.
     * @param rest boolean vector representing the constraint
     */
    public void setRest(boolean[] rest) {
        x = rest[0];
        y = rest[1];
        z = rest[2];
        Rx = rest[3];
        Ry = rest[4];
        Rz = rest[5];
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return this.pos.equals(other.getPos());
    }

    public int[] getSpringUnitVector() {
        return springUnitVector;
    }

    public void setSpringUnitVector(int[] springUnitVector) {
        this.springUnitVector = springUnitVector;
    }

    public double getSpringValue() {
        return springValue;
    }

    public void setSpringValue(double springValue) {
        this.springValue = springValue;
    }

}
