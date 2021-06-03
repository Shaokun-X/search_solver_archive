package fr.emse.ai.search.solver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import fr.emse.ai.search.core.Search;
import fr.emse.ai.search.core.InformedProblem;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

public class AStartSearch implements Search {

    private Collection<Node> frontier;
    private Set<String> chosenNodes = new HashSet<String>();;

    @Override
    public Node solve(Problem problem) {
        if (problem instanceof InformedProblem) {
            return solveInformedProblem((InformedProblem) problem);
        } else {
            System.out.println("A-star alogirthm must be applied on informed problem.");
            return null;
        }
            
    }

    private Node solveInformedProblem(InformedProblem problem) {
        frontier = new ArrayList<Node>();
        Node solution = null;
        Node initNode = new Node(problem.getInitialState());
        boolean done = false;
        frontier.add(initNode);
        
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                Node node = chooseNode(problem);
                chosenNodes.add(node.getState().toString());
                System.out.print("Current node: " + node.getState());
                System.out.printf(
                    ", g(n)=%.2f, h(n)=%.2f, f(n)=%.2f\n",
                    node.getPathCost(), 
                    problem.getHeuristic(node),
                    node.getPathCost() + problem.getHeuristic(node)
                );
                if (problem.isGoal(node.getState())) {
                    System.out.println("Goal node reached => SUCCESS");
                    done = true;
                    solution = node;
                } else {
                    frontier.addAll(expand(node, problem));
                }
            }
        }

        return solution;
    }

    private Node chooseNode(InformedProblem problem) {
        Node chosenNode = null;
        for (Node node : frontier) {
            if (chosenNode == null || problem.getHeuristic(node) + node.getPathCost() < chosenNode.getPathCost() ) {
                chosenNode = node;
            }
        }
        frontier.remove(chosenNode);
        return chosenNode;
    }

    @Override
    public Collection<Node> expand(Node node, Problem problem) {
        Collection<Node> nodes = new ArrayList<Node>();
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            Object nextState = problem.getNextState(node.getState(), action);
            // if a vertex is already found and added into frontier
            if (isInFrontier(nextState)) {
                Node frontierNode = getFrontierNode(nextState);
                // if the new cost f(n) is better then the previous then update the node
                if (frontierNode.getPathCost() > problem.getStepCost(node.getState(), action, nextState) + node.getPathCost() ){
                    frontierNode.setPathCost(node.getPathCost() + problem.getStepCost(node.getState(), action, nextState));
                    frontierNode.setParent(node);
                }
            } else {
                if (!chosenNodes.contains(nextState.toString())) {
                    nodes.add(new Node(nextState, node, action, problem.getStepCost(node.getState(), action, nextState)));
                }
            }
        }
        return nodes;
    }

    private boolean isInFrontier(Object state) {
        for (Node frontierNode : frontier) {
            if (frontierNode.getState().equals(state)) {
                return true;
            }
        }
        return false;
    }

    private Node getFrontierNode(Object state) {
        for (Node node : frontier) {
            if (node.getState().equals(state)) {
                return node;
            }
        }
        return null;
    }

    
}
