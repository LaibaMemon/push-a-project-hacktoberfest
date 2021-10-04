import java.util.Random;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.File;
import java.util.Scanner;


/*
* 1. Write a class to read the file named word, convert each word in it to lowercase, and
* store the word in data structure of your choice
*
* The data structure used to store words is: Trie
* The words are converted to lowercase in the trie's addWords function
*
 * */
public class ReadFile {

    // A method which takes the file name and a trie
    // Opens the file and saves the words in the trie
    static void readFile(String fileName, LexiconTrie trie) {
        File file = new File(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch(Exception e) {
            e.printStackTrace();
        }
        if(scan != null) {
            while (scan.hasNextLine()) {
                trie.addWord(scan.nextLine());
            }
        }
    }
}

public class BoggleBoard {

    public static final int DEFAULT_ROWS = 5;
    public static final int DEFAULT_COLUMNS = 5;

    private Random rng;

    // list of possible cubes swiped from "BigBoggleCubes" as used in Stanford's 106B.
    // isn't too picky about repeating cubes
    private String[] cubeStrings = {"AAAFRS", "AAEEEE", "AAFIRS", "ADENNN", "AEEEEM", "AEEGMU", "AEGMNN", "AFIRSY",
            "BJKQXZ", "CCNSTW", "CEIILT", "CEILPT", "CEIPST", "DDLNOR", "DDHNOT", "DHHLOR",
            "DHLNOR", "EIIITT", "EMOTTT", "ENSSSU", "FIPRSY", "GORRVW", "HIPRRY", "NOOTUW", "OOOTTU"};
    private BoggleLetter[][] board;
    private int rows;
    private int columns;

    // BoggleLetter represents the letter currently displayed on a space on the Boggle board.
    // (remember that outer classes can access private members of inner classes and vice-versa)
    private class BoggleLetter {
        private char letter;
        private boolean visited = false;
        private int row;
        private int column;

        public BoggleLetter() {
            String cube = cubeStrings[rng.nextInt(cubeStrings.length)];
            letter = Character.toLowerCase(cube.charAt(rng.nextInt(cube.length())));
        }
        public char getLetter(){ return letter; }
        public String toString(){ return Character.toString(letter); }

    }
    public BoggleBoard() {
        this(DEFAULT_ROWS, DEFAULT_COLUMNS);
    }

    public BoggleBoard(int rows, int columns, long seed){
        rng = new Random(seed);
        makeBoard(rows, columns);
    }

    public BoggleBoard(int rows, int columns){
        rng = new Random();
        makeBoard(rows, columns);
    }

    public BoggleBoard(long seed) {
        this(DEFAULT_ROWS, DEFAULT_COLUMNS, seed);
    }

    public void setVisited(int row, int column){
        board[row][column].visited = true;
    }
    public void setUnvisited(int row, int column){
        board[row][column].visited = false;
    }

    public boolean isVisited(int row, int column){
        return board[row][column].visited;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public char getCharAt(int row, int column){
        return board[row][column].getLetter();
    }

    public String toString(){
        int rows = board.length;
        int columns = board[0].length;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                output.append(board[i][j].toString().toUpperCase());
            }
            output.append("\n");
        }
        return output.toString();
    }

    private void makeBoard(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        board = new BoggleLetter[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                board[i][j] = new BoggleLetter();
            }
        }
    }


    public static void main(String[] args) {
        BoggleBoard board = new BoggleBoard();
        System.out.println(board);
    }

}

/* This is where you'll write your code to use a canonical graph-traversal algorithm to
 * solve a problem that at first may not seem like it's a graph problem at all.
 *
 * A note: This really is a fun one. If it gets to feel frustrating instead of fun, or if you feel
 * like you're  completely stuck, step back a bit and ask some questions.
 *
 * Spend a lot of time sketching out a plan, and figuring out which data structures might be
 * best for the various tasks, before you write any code at all.
 *
 * If you're not sure about how to approach this as a graph problem, feel free to ask questions.
 * (I won't give you all the answer, but...)
 * -Ben
 *
 */



public class BoggleWordFinder {

    // some useful constants
    public static final String WORD_LIST = "words";
    public static final int ROWS = 100;
    public static final int COLUMNS = 100;
    public static final int SEED = 137;

    // This is a Trie, which contains the valid words extracted from word file.
    // This trie is taken from "https://github.com/TaylorBeebe/Trie_Dictionary" which uses structure5 library ("http://www.cs.williams.edu/~bailey/JavaStructures/Software.html")
    // The necessary "structure5" can be found in the directory with file "bailey.jar"
    // There are 5 more functions added for our personal usages (is_word, is_path, current_move, current_move_back, reset_current)
    public static LexiconTrie trie = new LexiconTrie();

    // A simple counter to keep track of number of valid words found.
    static int counter = 0;

    // A TreeSet to store answers (valid words found) in a sorted manner
    static TreeSet<String> answer = new TreeSet<>();

    public static void main(String[] args) throws IOException {

        // Initializing boggle board
        BoggleBoard board = new BoggleBoard(ROWS, COLUMNS, SEED);

        // A function which reads the words.txt file and saves those words into trie
        ReadFile.readFile(WORD_LIST, trie);

        // Output file generating
        String outFileName = "output_optimized_large_board";
        FileOutputStream outStream = new FileOutputStream(outFileName);

        // Capturing starting time
        double startTime = System.currentTimeMillis();
        //Solver function which solves the board
        solver(board);
        // Capturing end time
        double endTime = System.currentTimeMillis();

        // Traversing the board to output the board's letters
        for(int i = 0; i < board.getRows(); i++) {
            for(int j = 0; j < board.getColumns(); j++) {
                System.out.print(Character.toUpperCase(board.getCharAt(i,j)));
                outStream.write(Character.toUpperCase(board.getCharAt(i,j)));
            }
            System.out.println();
            outStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        }

        // Outputting all the valid words found from the board
        for(String word : answer) {
            System.out.println(word);
            outStream.write(word.getBytes(StandardCharsets.UTF_8));
            outStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        }

        String temp = "Found "+counter+" words found in "+(endTime - startTime)+" milliseconds";
        System.out.println(temp);

        outStream.write(temp.getBytes(StandardCharsets.UTF_8));

    }


    // The main solver function which takes BoggleBoard as parameter and returns nothing
    static void solver(BoggleBoard board) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {

                // trie's added function, which resets the temporary positional node to start/root
                trie.reset_current();

                // Helper function which is used recursively
                processSolver(board, i, j, ""+board.getCharAt(i,j));
            }
        }
    }

    // Helper recursive function which takes BoggleBoard, x and y indices and word.
    private static void processSolver(BoggleBoard board, int x, int y, String word) {

        // trie's added function which tells if the temporary positional node
        // which we are at, makes a valid path (prefix) or not.
        if(!trie.is_path(board.getCharAt(x,y))) {
            return;
        }

        // trie's added function which moves the temporary positional node
        // to the child node, with letter present at x,y indices of board, of the current node
        trie.current_move(board.getCharAt(x,y));

        // trie's added function which tells if the node which we are at constitutes a word or not
        if(trie.is_word() && !answer.contains(word)) {
            answer.add(word);
            counter++;
        }


        // Continue checking the neighbours of the x,y index.

        // Upper left
        if (0 <= x - 1 && 0 <= y - 1 && !board.isVisited(x - 1,y - 1)){
            if(trie.is_path(board.getCharAt(x-1,y-1)))
            {
                processSolver(board, x-1, y-1, word+board.getCharAt(x-1,y-1));

                // trie's added function which pushes the current positional node to one step back.
                trie.current_move_back();
            }
        }

        // Up
        if (0 <= y - 1 && !board.isVisited(x,y - 1)){
            if(trie.is_path(board.getCharAt(x,y-1)))
            {
                processSolver(board, x, y-1, word + board.getCharAt(x,y-1));
                trie.current_move_back();
            }
        }

        // Upper right
        if (x + 1 < board.getRows() && 0 <= y - 1 && !board.isVisited(x + 1,y - 1)){
            if(trie.is_path(board.getCharAt(x+1,y-1)))
            {
                processSolver(board, x+1, y-1, word+board.getCharAt(x+1,y-1));
                trie.current_move_back();
            }
        }

        // Right
        if (x + 1 < board.getRows() && !board.isVisited(x + 1,y)){
            if(trie.is_path(board.getCharAt(x+1,y)))
            {
                processSolver(board, x+1, y, word + board.getCharAt(x+1,y));
                trie.current_move_back();
            }

        }

        // Lower right
        if (x+1 < board.getRows() && y+1 < board.getColumns() && !board.isVisited(x+1,y+1)){
            if(trie.is_path(board.getCharAt(x+1,y+1)))
            {
                processSolver(board, x+1, y+1, word+board.getCharAt(x+1,y+1));
                trie.current_move_back();
            }
        }

        // Down
        if (y + 1 < board.getColumns() && !board.isVisited(x,y + 1)){
            if(trie.is_path(board.getCharAt(x,y+1)))
            {
                processSolver(board, x, y+1, word + board.getCharAt(x,y+1));
                trie.current_move_back();
            }
        }

        // Lower left
        if (0 <= x - 1 && y + 1 < board.getColumns() && !board.isVisited(x - 1,y + 1)) {
            if (trie.is_path(board.getCharAt(x - 1, y + 1)))
            {
                processSolver(board, x-1, y+1, word+board.getCharAt(x-1,y+1));
                trie.current_move_back();
            }
        }

        // Left
        if (0 <= x - 1 && !board.isVisited(x - 1,y)){
            if(trie.is_path(board.getCharAt(x-1,y)))
            {
                processSolver(board, x-1, y, word + board.getCharAt(x-1,y));
                trie.current_move_back();
            }
        }


    }

}
