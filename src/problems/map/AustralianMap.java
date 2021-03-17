package problems.map;

import java.util.LinkedList;
import java.util.List;

import csp.Assignment;
import csp.CSP;
import csp.Constraint;
import csp.Variable;

public class AustralianMap extends CSP {

    private List<Variable> regions = new LinkedList<>();
    private List<Constraint> constraints = new LinkedList<>(); 

    public AustralianMap() {

        Region WA = new Region("WA");
        Region NT = new Region("NT");
        Region SA = new Region("SA");
        Region NSW = new Region("NSW");
        Region Q = new Region("Q");
        Region V = new Region("V");
        Region T = new Region("T");

        regions.add(WA);
        regions.add(NT);
        regions.add(SA);
        regions.add(NSW);
        regions.add(Q);
        regions.add(V);
        regions.add(T);

        NotEquals c1 = new NotEquals(SA, WA);
        NotEquals c2 = new NotEquals(SA, NT);
        
        NotEquals c3 = new NotEquals(SA, Q);
        NotEquals c4 = new NotEquals(SA, NSW);

        NotEquals c5 = new NotEquals(SA, V);
        NotEquals c6 = new NotEquals(WA, NT);
        NotEquals c7 = new NotEquals(NT, Q);

        NotEquals c8 = new NotEquals(Q, NSW);
        NotEquals c9 = new NotEquals(NSW, V);
        
        constraints.add(c1);
        constraints.add(c2);
        constraints.add(c3);
        constraints.add(c4);
        constraints.add(c5);
        constraints.add(c6);
        constraints.add(c7);
        constraints.add(c8);
        constraints.add(c9);
    }

    @Override
    public List<Variable> variables() {
        return regions;
    }

    @Override
    public List<Constraint> constraints() {
        return constraints;
    }
    
    public Assignment inference(Assignment a, Variable v) throws IllegalStateException {

        List<Constraint> constr = variableConstraints(v);

        Object val = a.getValue(v);

        for (Constraint c : constr) {
            for (Variable var : c.reliesOn()) {

                if (var == v) continue;

                List<Object> domain = domainValues(a, var);

                if (domain.contains(val)) {
                    domain = new LinkedList<>(domain);
                    domain.remove(val);
                    a.restrictDomain(var, domain);
                    if (a.getValue(var) == null) {
                        if (domain.size() == 1) {
                            a = a.assign(var, domain.get(0));
                        } else if (domain.isEmpty()) {
                            throw new IllegalStateException("No remaining assignments for variable: " + var.toString());
                        }
                    }
                }
            }
        }

        return a;
    }
}   
