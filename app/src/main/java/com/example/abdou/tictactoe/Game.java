package com.example.abdou.tictactoe;

/**
 * Created by abdou on 13-2-2018.
 */

public class Game {
    // Properties
    final private int BOARD_SIZE = 3;
    private Tile[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    // Contructor
    public Game() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = Tile.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    // Methods

    public Tile draw(int row, int column) {

        // If the tile is empty, fill it with a cross or a circle, depending on who has the turn.
        // Give the turn to other player.
        if (board[row][column] == Tile.BLANK) {
            if (playerOneTurn) {
                board[row][column] = Tile.CROSS;
                playerOneTurn = false;
                return Tile.CROSS;
            }
            else {
                board[row][column] = Tile.CIRCLE;
                playerOneTurn = true;
                return Tile.CIRCLE;
            }
        }
        return Tile.INVALID;
    }


    public GameState result () {

        // Check if player one has won.
        if (board[0][0]==Tile.CROSS && board[0][1]==Tile.CROSS && board[0][2]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[1][0]==Tile.CROSS && board[1][1]==Tile.CROSS && board[1][2]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[2][0]==Tile.CROSS && board[2][1]==Tile.CROSS && board[2][2]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[0][0]==Tile.CROSS && board[1][0]==Tile.CROSS && board[2][0]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[0][1]==Tile.CROSS && board[1][1]==Tile.CROSS && board[2][1]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[0][2]==Tile.CROSS && board[1][2]==Tile.CROSS && board[2][2]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[0][0]==Tile.CROSS && board[1][1]==Tile.CROSS && board[2][2]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }
        else if (board[0][2]==Tile.CROSS && board[1][1]==Tile.CROSS && board[2][0]==Tile.CROSS) {
            return GameState.PLAYER_ONE;
        }


        // Check if player one has won.
        if (board[0][0]==Tile.CIRCLE && board[0][1]==Tile.CIRCLE && board[0][2]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }
        else if (board[1][0]==Tile.CIRCLE && board[1][1]==Tile.CIRCLE && board[1][2]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }
        else if (board[2][0]==Tile.CIRCLE && board[2][1]==Tile.CIRCLE && board[2][2]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }
        else if (board[0][0]==Tile.CIRCLE && board[1][0]==Tile.CIRCLE && board[2][0]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }
        else if (board[0][1]==Tile.CIRCLE && board[1][1]==Tile.CIRCLE && board[2][1]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }
        else if (board[0][2]==Tile.CIRCLE && board[1][2]==Tile.CIRCLE && board[2][2]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }
        else if (board[0][0]==Tile.CIRCLE && board[1][1]==Tile.CIRCLE && board[2][2]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }
        else if (board[0][2]==Tile.CIRCLE && board[1][1]==Tile.CIRCLE && board[2][0]==Tile.CIRCLE) {
            return GameState.PLAYER_TWO;
        }

        // If there's no winner yet, check if all tiles are filled.
        movesPlayed = 0;
        for(int i=0; i<BOARD_SIZE; i++) {
            for (int j=0; j<BOARD_SIZE; j++) {
                if ( board[i][j] != Tile.BLANK){
                    movesPlayed++;
                }
            }
        }

        // Return draw if all tiles are filled and there is no winner.
        if (movesPlayed == BOARD_SIZE * 3) {
            return GameState.DRAW;
        }

        // Game is still going on.
        return GameState.IN_PROGRESS;
    }
}
