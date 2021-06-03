package fr.emse.ai.search.routing;

import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.core.Search;
import fr.emse.ai.search.solver.AStartSearch;

public class TravelRoutingTest {
    public static void main(String[] args) {

        Problem problem = new TravelRoutingProblem();

        Search solver = new AStartSearch();

        Node solution = solver.solve(problem);
        solution.pathToString();
    }
}
