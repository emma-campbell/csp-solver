package problems.map;

import java.util.LinkedList;
import java.util.List;

import csp.Assignment;
import csp.Constraint;
import csp.Variable;

public class NotEquals extends Constraint {

    private Variable v1;
    private Variable v2;

    public NotEquals(Variable v1, Variable v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return (v1.toString() + " != " + v2.toString());
    }

    @Override
    public boolean satisfied(Assignment a) {
        
        Object valueA = a.getValue(v1);
        Object valueB = a.getValue(v2);

        if (valueA == null && valueB == null) {
            return true;
        } else if (valueA == null && valueB != null) {
            List<Object> newDom = v1.domain();
            newDom.remove(valueB);
            a.restrictDomain(v1, newDom);
            return true;
        } else if (valueA != null && valueB == null) {
            List<Object> newDom = v2.domain();
            newDom.remove(valueA);
            a.restrictDomain(v2, newDom);
            return true;
        } else if (valueA.equals(valueB)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean consistent(Assignment a) {
        Object valueA = a.getValue(v1);
        Object valueB = a.getValue(v2);

        if (valueA != null && valueB != null) {
            return (!valueA.equals(valueB));
        } else {
            return true;
        }
    }

    @Override
    public List<Variable> reliesOn() {
        List<Variable> variables = new LinkedList<>();
        variables.add(v1);
        variables.add(v2);
        return variables;
    }
    
}
