package elements;

import gui2.Model;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class Support extends Node {
    
    private int supportType = 1;
    private double gap = 0.5;
    private int[] normalUnitVector = new int[3];
    private double offsetValue = 0;
    private int[] offsetUnitVector = new int[3];
    private double stiffines = 10E6;
    private double damp = 0.25;
    private int iterations = 100;
    private double tolerence = 1E-3;
    private double width = 0.1;
    
    
    
    public Support(Point pos, int number) {
        super(pos, number);
    }

    public Shape getSupportShape() {
        GeneralPath gp = new GeneralPath();
        int size = Model.getInstance().getNodeSize();
        int x = pos.x;
        int y = pos.y;

        gp.moveTo(x - size / 2, y - 2 * size);
        gp.lineTo(x - size / 2, y - size);
        gp.lineTo(x + size / 2, y - size);
        gp.lineTo(x + size / 2, y - 2 * size);

        gp.moveTo(x - size / 2, y + 2 * size);
        gp.lineTo(x - size / 2, y + size);
        gp.lineTo(x + size / 2, y + size);
        gp.lineTo(x + size / 2, y + 2 * size);

        Edge edge;
        Node n = Model.getInstance().getNode(pos);

        if (n == null) {
            edge = Model.getInstance().getEdges().get(0);
        } else {
            if (n.getEdges().size() > 1) {
                edge = new Edge(n.getEdges().get(1).getNode2(),
                        n.getEdges().get(0).getNode1(), 0);
            } else {
                edge = Model.getInstance().getEdges().get(0);;
            }
        }

        if (edge == null) {
            return gp;
        }

        Point[] seg = edge.getSegment(pos);

        if (seg == null) {
            return gp;
        }

        float dx = seg[1].x - seg[0].x;
        float dy = seg[1].y - seg[0].y;
        float D = (float) Math.sqrt(dx * dx + dy * dy);

        double alpha = (dx > 0) ? Math.asin(dy / D) : -Math.asin(dy / D);
        // transform the shape to follow the line direction
        return alpha != 0
                ? gp.createTransformedShape(AffineTransform.getRotateInstance(alpha, pos.x, pos.y))
                : gp;

    }

    public int getSupportType() {
        return supportType;
    }

    public void setSupportType(int supportType) {
        this.supportType = supportType;
    }

    public double getGap() {
        return gap;
    }

    public void setGap(double gap) {
        this.gap = gap;
    }

    public int[] getNormalUnitVector() {
        return normalUnitVector;
    }

    public void setNormalUnitVector(int[] normalUnitVector) {
        this.normalUnitVector = normalUnitVector;
    }

    public int[] getOffsetUnitVector() {
        return offsetUnitVector;
    }

    public void setOffsetUnitVector(int[] offsetUnitVector) {
        this.offsetUnitVector = offsetUnitVector;
    }

    public double getStiffines() {
        return stiffines;
    }

    public void setStiffines(double stiffines) {
        this.stiffines = stiffines;
    }

    public double getDamp() {
        return damp;
    }

    public void setDamp(double damp) {
        this.damp = damp;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public double getTolerence() {
        return tolerence;
    }

    public void setTolerence(double tolerence) {
        this.tolerence = tolerence;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getOffsetValue() {
        return offsetValue;
    }

    public void setOffsetValue(double offsetValue) {
        this.offsetValue = offsetValue;
    }

}
