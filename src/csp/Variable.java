package csp;

import java.util.List;

public abstract class Variable {
    
    /**
     * Returns a human-readable representation of the variable. Useful
     * for debugging purposes.
     * 
     * @return      {@code String} representation of the variable
     */
    public abstract String toString();

    /**
     * Returns the domain of possible values for the variable.
     * 
     * @return      {@code List} of possible domain values
     */
    public abstract List<Object> domain();

}
