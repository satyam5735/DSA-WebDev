package SigmaBatchDSA.ClassProblems.GraphsSupplemental;

public class BridgeInGraphsTarjanAlgo {
    // Bridge is an edge whose deletion increases the graph's number of connected Components
    //Performed on undirected graphs : used Tarjan's Algorithm

    // Algorithm:
        // dt[] = new int[V] :- discovery time of node
        // low[] new int[V]  :- lowest discovery time of all neighbors

    // dt:- is the time value to reach a node
    // lowest dt = lowest(among neighbors)

    // Condition to be a bridge: only one path to go from Bundle of nodes U to Bundle of node V
    // Condition: src: dt[U] < low[V]: dest



}
