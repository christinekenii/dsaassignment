package Question10;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private LinkList[] adjList;
    private int nVerts;
    private StackX theStack;
    // -----------------------------------------------------------
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjList = new LinkList[MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            adjList[j] = new LinkList();
        }
        theStack = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjList[start].insertFirst(end);
        adjList[end].insertFirst(start);
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());

            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        LinkList adj = adjList[v];
        Link current = adj.first;

        while (current != null) {
            if (!vertexList[current.vertexIndex].wasVisited) {
                return current.vertexIndex;
            }
            current = current.next;
        }

        return -1;
    }

// ------------------------------------------------------------
} // end class Graph