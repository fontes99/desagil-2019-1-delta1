package br.pro.hashi.ensino.desagil.desafio.model;

import java.util.Stack;

public class CpuPlayer extends Player {

    private final boolean[][] visited;
    private final int numRows;
    private final int numCols;
    private final Stack<Node> stack;


    CpuPlayer(int row, int col, Board board) {

        super(row, col, board);
        this.numRows = board.getNumRows();
        this.numCols = board.getNumCols();
        this.visited = new boolean[numRows][numCols];

        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j < numCols; j++) {
                visited[i][j] = board.isWall(i, j);
            }
        }

        this.stack = new Stack<>();
        save();
    }


    public void move() {

        if (!stack.isEmpty()) {
            if (row > 0 && !visited[row - 1][col]) {
                move(-1, 0);
                save();
            } else if (col < numCols - 1 && !visited[row][col + 1]) {
                move(0, 1);
                save();
            } else if (row < numRows - 1 && !visited[row + 1][col]) {
                move(1, 0);
                save();
            } else if (col > 0 && !visited[row][col - 1]) {
                move(0, -1);
                save();
            } else {
                stack.pop();

                if (!stack.isEmpty()) {
                    Node node = stack.peek();

                    row = node.getRow();
                    col = node.getCol();

                }
            }
        }
    }

    private void save() {
        visited[row][col] = true;
        stack.push(new Node(row, col));
    }


    private class Node {
        private final int row;
        private final int col;

        private Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        private int getRow() {
            return row;
        }

        private int getCol() {
            return col;
        }
    }
}
