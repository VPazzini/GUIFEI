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
