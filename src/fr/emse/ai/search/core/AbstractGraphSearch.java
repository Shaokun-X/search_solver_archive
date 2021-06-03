package fr.emse.ai.search.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGraphSearch extends AbstractTreeSearch {
	
	Set<String> visited = new HashSet<String>();

	@Override
    public Node solve(Problem problem) {
        // initialize fringe
        System.out.println("Solving...");
        frontier = initFrontier();
        Node initNode = new Node(problem.getInitialState());
        frontier.addAll(expand(initNode, problem));
        visited.add(initNode.getState().toString());
        System.out.println("Initial node: " + problem.getInitialState());
//        System.out.println("Starting frontier is " + frontier);
        boolean done = false;
        Node solution = null;
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                
                // get not visited node from frontier
                Node node = null;
                while (!frontier.isEmpty()) {
                    node = chooseLeafNode(frontier, problem);
                    if (!visited.contains(node.getState().toString())) {
                        break;
                    }
                    // last loop
                    if (frontier.isEmpty()) {
                        node = null;
                    }
                }

                if (node != null) {                    
                    visited.add(node.getState().toString());
                    System.out.println("Current node: " + node.getState());
    //                System.out.println("Inspecting node " + node);
                    if (problem.isGoal(node.getState())) {
                        System.out.println("Goal node reached => SUCCESS");
                        done = true;
                        solution = node;
                    } else {
                        frontier.addAll(expand(node, problem));
    //                    System.out.printf("Expanding node, frontier is " + frontier);
                    }
                }

            }
        }
        return solution;
    }

	@Override
    public Collection<Node> expand(Node node, Problem problem) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            if (!visited.contains(next.toString()))     	
            	nodes.add(new Node(next, node, action, problem.getStepCost(node.getState(), action, next)));
        }
        return nodes;
    }
    
	
}
