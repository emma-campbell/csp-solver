package algo;

import java.util.List;

import csp.Assignment;
import csp.CSP;
import csp.Variable;

public class Backtrack {
    
    private CSP problem;

    public Backtrack(CSP problem) {
        this.problem = problem;
    }

    public Assignment solve(Assignment initial) {
        return __solve(initial);
    } 

    private Assignment __solve(Assignment a) {
        
        if (problem.satisfiedByAssignment(a)) { return a; }

        Variable v = unassignedVar(a);
        if (v == null) { return null; }

        List<Object> values = problem.domainValues(a, v);
        
        for (Object val : values) {
            
            if (problem.consistentAssignment(a)) {
                
                Assignment assign = a.assign(v, val);

                try {
                    assign = problem.inference(assign);
                } catch (IllegalStateException e) {
                    continue;
                } 

                assign = __solve(assign);
                if (assign != null) return assign;
            }
        }

        return null;
    }

    private Variable unassignedVar(Assignment a) {
        for (Variable v : problem.variables()) {
            if (a.getValue(v) == null) { return v; }
        }
        return null;
    }

}
