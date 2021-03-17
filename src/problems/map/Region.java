package problems.map;

import java.util.LinkedList;
import java.util.List;

import csp.Variable;

public class Region extends Variable {
    
    public String color;
    private String name; 
    private List<Object> domain;

    public Region(String name) {
        this.name = name;
        this.domain = new LinkedList<>();
        
        domain.add("Red");
        domain.add("Green");
        domain.add("Blue");

        this.color = null;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public List<Object> domain() {
        return this.domain;
    }

    @Override
    public boolean equals(Object other) {
        try {
            Region othRegion = (Region)other;
            return name.equals(othRegion.toString());
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
