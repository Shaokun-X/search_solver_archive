package fr.emse.ai.search.river;

import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.core.Search;
import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;

public class CrossRiverTest {
    public static void main(String[] args) {
    	
    	Problem problem = new CrossRiverProblem();
  			
 	  	// Search solver = new DepthFirstGraphSearch();
    	Search solver = new BreadthFirstGraphSearch();
      
    	Node solution = solver.solve(problem);
		// PathPrinter.printPath(solution);
		solution.pathToString();
  }
}
