package elements;

import gui2.Model;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class Support extends Node {

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

}
