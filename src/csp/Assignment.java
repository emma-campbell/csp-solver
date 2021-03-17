package csp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Representation of an Assignment in a CSP.
 * 
 * @author  Emma Campbell
 * @since   03/17/2021
 */
public class Assignment {

    Map<Variable, Object> assignments;      // tracks all current variable assignments
    Map<Variable, List<Object>> domain;     // tracks the domain of variables

    public Assignment() {
        this.assignments = new HashMap<>();
        this.domain = new HashMap<>();
    }

    /**
     * Assigns a value to a variable and returns a new assignment
     * representing the state.
     * 
     * @param v         {@code Variable} to be assigned
     * @param val       {@code Object} that we are assigning to variable
     * @return          new Assignment after assigning val to v
     */
    public Assignment assign(Variable v, Object val) {
        
        Assignment a = new Assignment();
        a.assignments = new HashMap<>(assignments);
        a.assignments.put(v, val);
        a.domain = new HashMap<>(domain);
        
        List<Object> varDomain = new LinkedList<>();
        varDomain.add(val);
        a.restrictDomain(v, varDomain);

        return a;
    }

    /**
     * Return the value of a variable
     * 
     * @param v         {@code Variable} to get value assigned to
     * @return          the value assigned to v
     */
    public Object getValue(Variable v) {
        return assignments.get(v);
    }

    /**
     * Assigned a restricted domain to a variable
     * 
     * @param v         {@code Variable} to restrict domain of
     * @param domain    {@code List<Object>} domain to restrict
     */
    public void restrictDomain(Variable v, List<Object> dom) {
        domain.put(v, dom);
    }

    /**
     * Returns the restricted domain of a variable
     * 
     * @param v         {@code Variable} to get domain of
     * @return          domain of v
     */
    public List<Object> getDomain(Variable v) {
        return domain.get(v);
    }

    /**
     * Returns the number of assignments made
     * 
     * @return      number of assignments made
     */
    public int size() {
        return assignments.size();
    }

    @Override
    public String toString() {
        return assignments.toString();
    }
}