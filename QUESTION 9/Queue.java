public class Queue {
    constructor() {
      this.queue = [];
    }
  
    insert(item) {
      this.queue.push(item);
    }
  
    remove() {
      if (this.isEmpty()) {
        return null;
      }
      return this.queue.shift();
    }
  
    isEmpty() {
      return this.queue.length === 0;
    }
  }
  
  class Vertex {
    constructor(label) {
      this.label = label;
      this.wasVisited = false;
    }
  }
  
  class Graph {
    constructor() {
      this.vertexList = [];
      this.adjMat = [];
      this.nVerts = 0;
      this.queue = new Queue();
    }
  
    addVertex(label) {
      this.vertexList[this.nVerts++] = new Vertex(label);
    }
  
    addEdge(start, end) {
      this.adjMat[start][end] = 1;
      this.adjMat[end][start] = 1;
    }
  
    displayVertex(v) {
      console.log(this.vertexList[v].label);
    }
  
    bfs() {
      this.vertexList[0].wasVisited = true;
      this.displayVertex(0);
      this.queue.insert(0);
  
      while (!this.queue.isEmpty()) {
        const v1 = this.queue.remove();
  
        let v2;
        while ((v2 = this.getAdjUnvisitedVertex(v1)) !== -1) {
          this.vertexList[v2].wasVisited = true;
          this.displayVertex(v2);
          this.queue.insert(v2);
        }
      }
  
      for (let j = 0; j < this.nVerts; j++) {
        this.vertexList[j].wasVisited = false;
      }
    }
  
    getAdjUnvisitedVertex(v) {
      for (let j = 0; j < this.nVerts; j++) {
        if (
          this.adjMat[v][j] === 1 &&
          this.vertexList[j].wasVisited === false
        ) {
          return j;
        }
      }
      return -1;
    }
  }
  
  const graph = new Graph();
  graph.addVertex("A");
  graph.addVertex("B");
  graph.addVertex("C");
  graph.addVertex("D");
  graph.addVertex("E");
  graph.addVertex("F");
  graph.addVertex("G");
  graph.addVertex("H");
  graph.addVertex("I");
  
  graph.addEdge(0, 1);
  graph.addEdge(0, 2);
  graph.addEdge(0, 3);
  graph.addEdge(1, 4);
  graph.addEdge(1, 5);
  graph.addEdge(2, 6);
  graph.addEdge(2, 7);
  graph.addEdge(3, 8);
  
  console.log("Minimum Spanning Tree:");
  graph.bfs();
  