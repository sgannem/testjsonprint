package com.xyz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTest {

    //https://java2blog.com/breadth-first-search-in-java/
    //https://www.youtube.com/watch?v=EE_9U798nvQ

    // using neighbours list
    public static class Node {
        private int element;
        private boolean isVisited;
        private List<Node> neighbours;

        public Node(int element) {
            this.element=element;
            this.neighbours = new ArrayList<>();
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }

        public void addneighbours(Node node) {
            this.neighbours.add(node);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", isVisited=" + isVisited +
                    ", neighbours=" + neighbours +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        System.out.println("The BFS traversal of the graph is ");
        bfs(node40);
    }

    private static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        node.setVisited(Boolean.TRUE);
        while(!q.isEmpty()) {
            Node n = q.remove();
            System.out.print(n.getElement()+" t ");
            for(Node t:n.getNeighbours()) {
                if(t!=null && !t.isVisited) {
                    q.add(t);
                    t.setVisited(Boolean.TRUE);
                }
            }
        }
    }
}
