package fr.emse.ai.search.solver;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import fr.emse.ai.search.core.AbstractGraphSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

public class BreadthFirstGraphSearch extends AbstractGraphSearch{
	
    public Collection<Node> initFrontier() {
    	Queue<Node> queue = new LinkedList<>();
        return queue;
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((Queue<Node>) frontier).remove();
    }
}
