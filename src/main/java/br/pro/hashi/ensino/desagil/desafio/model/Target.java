package br.pro.hashi.ensino.desagil.desafio.model;

import java.util.Random;

public class Target extends Element {
    private Board board;

    public Target(int row, int col, Board board) {
        super(row, col);
        this.board = board;
    }

    public void move(int rowShift, int colShift) {
        row += rowShift;
        col += colShift;
    }

    public void moveRandom() {

        Random movimento = new Random();

        int n = movimento.nextInt(4);

        if (n == 0 && row > 0 && !board.isWall(row - 1, col)) {
            move(-1, 0);
        }

        if (n == 1 && col < board.getNumCols() - 1 && !board.isWall(row, col + 1)) {
            move(0, 1);
        }

        if (n == 2 && row < board.getNumRows() - 1 && !board.isWall(row + 1, col)) {
            move(1, 0);
        }

        if (n == 3 && col > 0 && !board.isWall(row, col - 1)) {
            move(0, -1);
        }

    }
}
