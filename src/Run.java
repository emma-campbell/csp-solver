import algo.Backtrack;
import csp.Assignment;
import problems.map.AustralianMap;

public class Run {

    public static void main(String args[]) {

        System.out.println("CSP-Solver: Constraint Satisfaction Problems");
        AustralianMap mapProblem = new AustralianMap();
        Backtrack solver = new Backtrack(mapProblem);
        Assignment solution = solver.solve(new Assignment());
        System.out.print(solution);
        
    }
    
}
