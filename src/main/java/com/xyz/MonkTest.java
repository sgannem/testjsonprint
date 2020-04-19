package com.xyz;

//https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
1
3 3
1 2
2 3
1 3

//import for Scanner and other utility classes */
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MonkTest {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        **/
        //Scanner
        Scanner s = new Scanner(System.in);
        String tcs = s.nextLine();                 // Reading input from STDIN
        // System.out.println("tcs:"+tcs);    // Writing output to STDOUT
        int ntcs = Integer.parseInt(tcs);
        while(ntcs>0) {
            String[] g = s.nextLine().split(" ");
            int vg = Integer.parseInt(g[0]);
            int eg = Integer.parseInt(g[1]);
            // System.out.println("vg:"+vg+", eg:"+eg);

            LinkedList<Integer> adj[] = new LinkedList[vg];
            for(int i=0;i<vg;i++) {
                adj[i]=new LinkedList<Integer>();
            }
            for(int i=0;i<eg;i++) {
                String[] g1 = s.nextLine().split(" ");
                int v1 = Integer.parseInt(g1[0]);
                int v2 = Integer.parseInt(g1[1]);
                // System.out.print("v1="+v1+", v2="+v2);
                for(int j=0;j<vg;j++) {
                    if(v1==(j+1)) {
                        adj[j].add(v2);
                        //  System.out.println("adj["+(j+1)+"]="+adj[j]);
                    }
                }
            }
            boolean visited[] = new boolean[vg];
            // for(int i=0;i<vg;i++) {
            if(vg>0) {

                LinkedList<Integer> q = new LinkedList<>();
                int i=0;

                q.add(i+1);
                int counter=0;
                while(q.size()!=0) {
                    int fe = q.remove();
                    if(!visited[fe-1]) {
                    counter++;
//                    System.out.print((fe+1)+" ");
                    visited[fe-1]=true;
//                    q.add(fe);
                    }
                    Iterator<Integer> l = adj[fe-1].listIterator();
                    while(l.hasNext()) {
                        int n = l.next();
                        if (!visited[n-1])
                        {
                            visited[n-1] = true;
                            q.add(n-1);
                        }
                    }

                }
                System.out.println(counter);
            }

            // }


            ntcs --;
        }

        // Write your code here

    }
}


