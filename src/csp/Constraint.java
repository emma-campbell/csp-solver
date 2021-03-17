package csp;

import java.util.List;

public abstract class Constraint {
    
    /**
     * Returns a human readable representation of the Constraint
     * 
     * @return      {@code String} representation of constraint
     */
    public abstract String toString();

    /**
     * Checks if the constraint is satisfied by an assignment
     * 
     * @param a     {@code Assignment}
     * @return      {@code true} if satisfied, {@code false} otherwise.
     */
    public abstract boolean satisfied(Assignment a);

    /**
     * Checks if a constraint is consistent with an assignment.
     * 
     * @param a     {@code Assignment}
     * @return      {@code true} if consistent, {@code false} otherwise.
     */
    public abstract boolean consistent(Assignment a);

    /**
     * Returns the variables that the constraint relies on.
     * 
     * @return      {@code List<Variable>} list of variables the constraint
     *              relies on.
     */
    public abstract List<Variable> reliesOn();

}
