package fr.emse.ai.search.core;

public interface InformedProblem extends Problem {

    double getHeuristic(Node node);

}
