package fr.emse.ai.search.simple;

import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.core.Search;
import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstTreeSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;

public class SimpleTest {

    public static void main(String[] args) {
//        Problem problem = new SimpleOrientedGraphProblem();
    	Problem problem = new SimpleNonOrientedGraphProblem();
//        System.out.println("Solution to problem using depth first : ");

        /*
         * Even with breadth-first tree search algorithm in non-oriented graph problem, 
         * the search would end and the path can be found. Because even though the search
         * "goes back", the succeeding nodes are always added to the queue, at certain step
         * the node that is closer to the destination would be found. Therefore, the 
         * behavior of search looks like "jumping around" and gradually getting closer to
         * destination.
         */
         
//        Search solver = new DepthFirstTreeSearch();
//        Search solver = new BreadthFirstTreeSearch();
//        Search solver = new DepthFirstGraphSearch();
    	Search solver = new BreadthFirstGraphSearch();
        Node solution = solver.solve(problem);
        solution.pathToString();
    }
}
