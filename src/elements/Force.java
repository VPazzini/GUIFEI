package elements;

import java.util.Objects;

public class Force implements Cloneable{
    private final String axis;
    private float forceValue;

    public Force(String axis, float forceValue) {
        this.axis = axis;
        this.forceValue = forceValue;
    }

    public String getAxis() {
        return axis;
    }
    
    public int getAxisNumber(){
        switch(axis){
            case("X"):
                return 1;
            case("Y"):
                return 2;
            case("Z"):
                return 3;
            case("RX"):
                return 4;
            case("RY"):
                return 5;
            case("RZ"):
                return 6;
            default:
                return 0;
        }
    }

    public float getValue() {
        return forceValue;
    }
    
    public void addForce(float force){
        this.forceValue += force;
    }

    @Override
    public String toString() {
        return this.axis + ":" + this.forceValue;
    }

    @Override
    public Force clone(){
        Force f = new Force(this.axis, this.forceValue);
        return f;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Force)){
            return false;
        }
        Force f = (Force) obj;
        return f.getAxis().equals(this.axis);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.axis);
        hash = 79 * hash + Float.floatToIntBits(this.forceValue);
        return hash;
    }
    
    
    
}
