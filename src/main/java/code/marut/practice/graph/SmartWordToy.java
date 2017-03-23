package code.marut.practice.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
/*
The toy company "I Can't Believe It Works!" has hired you to help develop educational toys. The current project is a word toy that displays four letters at 
all times. Below each letter are two buttons that cause the letter above to change to the previous or next letter in alphabetical order. So, with one click of a 
button the letter 'c' can be changed to a 'b' or a 'd'. The alphabet is circular, so for example an 'a' can become a 'z' or a 'b' with one click. 

In order to test the toy, you would like to know if a word can be reached from some starting word, given one or more constraints.A constraint defines a set of 
forbidden words that can never be displayed by the toy. Each constraint is formatted like "X X X X", where each X is a string of lowercase letters. A word is 
defined by a constraint if the ith letter of the word is contained in the ith X of the contraint. For example, the constraint "lf a tc e" defines the words 
"late", "fate", "lace" and "face". 

You will be given a String start, a String finish, and a String[] forbid. Calculate and return the minimum number of button presses required for the toy to show 
the word finish if the toy was originally showing the word start. Remember, the toy must never show a forbidden word. If it is impossible for the toy to ever 
show the desired word, return -1.
 
Definition
    	
Class:	SmartWordToy
Method:	minPresses
Parameters:	String, String, String[]
Returns:	int
Method signature:	int minPresses(String start, String finish, String[] forbid)
(be sure your method is public)
    
 
Constraints
-	start and finish will contain exactly four characters.
-	start and finish will contain only lowercase letters.
-	forbid will contain between 0 and 50 elements, inclusive.
-	Each element of forbid will contain between 1 and 50 characters.
-	Each element of forbid will contain lowercase letters and exactly three spaces.
-	Each element of forbid will not contain leading, trailing or double spaces.
-	Each letter within a group of letters in each element of forbid will be distinct. Thus "aa a a a" is not allowed.
-	start will not be a forbidden word.
 
Examples
0)	
    	
"aaaa"
"zzzz"
{"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"}
Returns: 8
1)	
    	
"aaaa"
"bbbb"
{}
Returns: 4
Simply change each letter one by one to the following letter in the alphabet.
2)	
    	
"aaaa"
"mmnn"
{}
Returns: 50
Just as in the previous example, we have no forbidden words. Simply apply the correct number of button presses for each letter and you're there.
3)	
    	
"aaaa"
"zzzz"
{"bz a a a", "a bz a a", "a a bz a", "a a a bz"}
Returns: -1
Here is an example where it is impossible to go to any word from "aaaa".
4)	
    	
"aaaa"
"zzzz"
{"cdefghijklmnopqrstuvwxyz a a a", 
 "a cdefghijklmnopqrstuvwxyz a a", 
 "a a cdefghijklmnopqrstuvwxyz a", 
 "a a a cdefghijklmnopqrstuvwxyz"}
Returns: 6
5)	
"aaaa"
"bbbb"
{"b b b b"}
Returns: -1
6)	
    	
"zzzz"
"aaaa"
{"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk",
 "abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"}
Returns: -1
 */
public class SmartWordToy {
    public int minPresses(String start, String finish, String[] forbid) {
        Node.initForbidden(forbid);
        Node s = new Node(start.toCharArray());
        //        System.out.println(s.neighbors());
        return bfs(s, finish);
    }

    private int bfs(Node s, String finish) {
        HashSet<String> visited = new HashSet<String>();

        LinkedList<Node> q = new LinkedList<Node>();
        q.add(s);
        while (q.isEmpty() == false) {
            Node top = q.getFirst();
            q.removeFirst();
            //            System.out.println(top);
            visited.add(top.toString());
            if (top.toString().equals(finish)) return top.steps;
            for (Node neighbor : top.neighbors()) {
                if (!visited.contains(neighbor.toString())) {
                    neighbor.steps = top.steps + 1;
                    q.add(neighbor);
                }
            }
        }
        return -1;
    }

    static class Node {
        public static final char A = 'a';
        int steps = 0;
        static boolean[][][][] forbidden;

        private static void initForbidden(final String[] forbid) {
            boolean[][][][] forbidden = new boolean[26][26][26][26];

            for (String s : forbid) {
                String[] split = s.split(" ");
                for (int i = 0; i < split[0].length(); i++) {
                    for (int j = 0; j < split[1].length(); j++) {
                        for (int k = 0; k < split[2].length(); k++) {
                            for (int l = 0; l < split[3].length(); l++) {
                                forbidden[split[0].charAt(i) - A][split[1].charAt(j) - A][split[2].charAt(k) - A][split[3].charAt(l) - A] = true;
                            }
                        }
                    }
                }
            }


            Node.forbidden = forbidden;
        }

        Node(char[] word) {
            this.word = word;
        }

        char[] word = new char[4];

        public String toString() {
            return new String(word);
        }

        List<Node> neighbors() {
            HashSet<Node> neighbors = new HashSet<Node>();

            for (int i = 0; i < word.length; i++) {
                char[] prev = createWordWithNextLetter(i);
                addToNeighborsIfNotForbidden(neighbors, prev);
            }

            for (int i = 0; i < word.length; i++) {
                char[] next = createWordWithPrevLetter(i);

                addToNeighborsIfNotForbidden(neighbors, next);
            }

            return new LinkedList(neighbors);
        }

        private void addToNeighborsIfNotForbidden(HashSet<Node> neighbors, char[] next) {
            if (isForbidden(next) == false) {
                neighbors.add(new Node(next));
            }
        }

        private char[] createWordWithPrevLetter(int i) {
            char[] next = new char[4];

            for (int j = 0; j < word.length; j++) {
                next[j] = (i == j) ? next(word[j]) : word[j];
            }
            return next;
        }

        private char[] createWordWithNextLetter(int i) {
            char[] prev = new char[4];

            for (int j = 0; j < word.length; j++) {
                prev[j] = (i == j) ? prev(word[j]) : word[j];
            }
            return prev;
        }

        private boolean isForbidden(char[] word) {
            return forbidden[word[0] - A][word[1] - A][word[2] - A][word[3] - A];
        }


        private char next(char c) {
            if (c == 'z') return 'a';
            return (char) (c + 1);
        }

        private char prev(char c) {
            if (c == 'a') return 'z';
            return (char) (c - 1);
        }
    }
}