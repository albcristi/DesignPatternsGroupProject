import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import com.google.common.graph.MutableGraph;

public class Main {

    @SuppressWarnings("all")
   public static void main(String[] args) {
        MutableGraph<String> mutableUndirectedGraph = GraphBuilder // Here we get the needed Builder
                .undirected() // we start specifying features of the complex object
                .allowsSelfLoops(true)
                .build(); // finally we build our custom object
        // since we have a mutable graph, we can  edit
        // it even after object creation
        mutableUndirectedGraph.putEdge("Romania", "Bulgaria");
        mutableUndirectedGraph.putEdge("Ukraine", "Romania");
        mutableUndirectedGraph.putEdge("Bulgaria", "Greece");
        System.out.println("Firstly created graph:");
        System.out.println(mutableUndirectedGraph.toString());

        //now we create another type of graph using the GraphBuilder
        ImmutableGraph<String> immutableUndirectedGraph = GraphBuilder // Here we get the needed Builder
                .undirected() // we specify one feature of our graph
                .<String>immutable() // from here we come with a new type of builder that will allow
                   // us to get a new representation of our complex object
                .addNode("Romania") // we start adding features to our graph
                .addNode("Bulgaria")
                .addNode("Greece")
                .putEdge("Romania", "Bulgaria")
                .putEdge("Bulgaria","Greece")
                .build(); // we finish by building our custom object
        //since this is an immutable graph, we notice that we can not
        //modify the graph, in contrast to the previous example
        System.out.println("Second created graph:");
        System.out.println(immutableUndirectedGraph);
    }
}
