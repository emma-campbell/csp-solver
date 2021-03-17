package csp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class CSP {
    
    Map<Variable, List<Constraint>> varConstraints = null;     // Stores the constraints on any given variable
    
    /**
     * Returns a list of variables associated with the CSP.
     * 
     * @return      {@code List<Variable>}
     */
    public abstract List<Variable> variables();

    /**
     * Returns a list of constraints associated with the CSP.
     * 
     * @return      {@code List<Constraint>}
     */
    public abstract List<Constraint> constraints();

    /**
     * Checks if a given assignment satisfies the CSP.
     * 
     * @return      {@code true} if a satisfies the CSP, {@code false}
     *              otherwise.
     */
    public boolean satisfiedByAssignment(Assignment a) {

        if (variables().size() > a.size()) { return false; }
        
        for (Constraint c : constraints()) {
            if (!c.satisfied(a)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns all constrinats that rely on a given variable
     * 
     * @param v     {@code Variable} constriants rely on
     * @return      constraints that rely on v
     */
    public List<Constraint> variableConstraints(Variable v) {
        
        if (varConstraints != null) { return varConstraints.get(v); }

        varConstraints = new HashMap<>();

        for (Constraint c : constraints()) {
            List<Variable> vars = c.reliesOn();
            for (Variable var : vars) {
                if (varConstraints.containsKey(var)) {
                    varConstraints.get(var).add(c);
                } else {
                    List<Constraint> constr = new LinkedList<>();
                    constr.add(c);
                    varConstraints.put(var, constr);
                }
            }
        }

        return varConstraints.get(v);
    }

    /**
     * Returns a list of all possible domain values for a given variable.
     * 
     * @param a     {@code Assignment}
     * @param v     {@code Variable}
     * @return      {@code List<Object>} domain values
     */
    public List<Object> domainValues(Assignment a, Variable v) {
        List<Object> domain = a.getDomain(v);
        if (domain != null) { return domain; }
        return v.domain();
    }

    /**
     * Returns whether the varaable assignment is consistent.
     * 
     * @param a     {@code Assignment} to check
     * @return      {@code true} if assignment is consistent, {@code false}
     *              otherwise.
     */
    public boolean consistentAssignment(Assignment a) {
        for (Constraint c : constraints()) {
            if (!c.consistent(a)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a new assignment based on some inferences.
     * 
     * @param a     {@code Assignment}
     * @return      new {@code Assignment}
     * @throws IllegalStateException
     */
    public Assignment inference(Assignment a) throws IllegalStateException {
        return a;
    }
}
