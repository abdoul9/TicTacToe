package com.example.abdou.tictactoe;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Properties
    Game game;
    int row;
    int column;

    Button a;
    Button b;
    Button c;
    Button d;
    Button e;
    Button f;
    Button g;
    Button h;
    Button i;

    // Contructor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();

        // Create button objects for all tiles.
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
    }

    // Methods

    public void tileClicked(View view) {
        Button change_button = (Button) view;
        int id = view.getId();

        // Find out which button is clicked on, and provide the corresponding row and column.
        if (id == R.id.a || id == R.id.b || id == R.id.c) {
            row = 0;
        }
        else if (id == R.id.d || id == R.id.e || id == R.id.f) {
            row = 1;
        }
        else if (id == R.id.g || id == R.id.h || id == R.id.i) {
            row = 2;
        }

        if (id == R.id.a || id == R.id.d || id == R.id.g) {
            column = 0;
        }
        else if (id == R.id.b || id == R.id.e || id == R.id.h) {
            column = 1;
        }
        else if (id == R.id.c || id == R.id.f || id == R.id.i) {
            column = 2;
        }

        // Make sure the button can't be clicked on anymore.
        change_button.setClickable(false);

        // Provide the draw method with the row and column.
        // If the tile is empty, change the text of the button to either
        // a cross or a circle, depending on who has the turn.
        Tile tile = game.draw(row, column);

        switch (tile) {
            case CROSS:
                change_button.setText("X");
                break;
            case CIRCLE:
                change_button.setText("O");
                break;
            case INVALID:
                break;
        }

        // Check the state of the game.
        // If there is a result, show an alert dialog.
        // Make sure all buttons can't be clicked on anymore.
        GameState gameState = game.result();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        switch (gameState) {
            case PLAYER_ONE:
                a.setClickable(false);
                b.setClickable(false);
                c.setClickable(false);
                d.setClickable(false);
                e.setClickable(false);
                f.setClickable(false);
                g.setClickable(false);
                h.setClickable(false);
                i.setClickable(false);
                builder.setMessage("PLAYER ONE WINS");
                AlertDialog player1 = builder.create();
                player1.show();
                break;
            case PLAYER_TWO:
                a.setClickable(false);
                b.setClickable(false);
                c.setClickable(false);
                d.setClickable(false);
                e.setClickable(false);
                f.setClickable(false);
                g.setClickable(false);
                h.setClickable(false);
                i.setClickable(false);
                builder.setMessage("PLAYER TWO WINS");
                AlertDialog player2 = builder.create();
                player2.show();
                break;
            case DRAW:
                builder.setMessage("DRAW");
                AlertDialog draw = builder.create();
                draw.show();
                break;
            case IN_PROGRESS:
                break;
        }

    }

    // Start a new game.
    // Clear the text from all buttons and make them clickable again.
    public void resetClicked(View view) {
        game = new Game();

        a.setText("");
        a.setClickable(true);

        b.setText("");
        b.setClickable(true);

        c.setText("");
        c.setClickable(true);

        d.setText("");
        d.setClickable(true);

        e.setText("");
        e.setClickable(true);

        f.setText("");
        f.setClickable(true);

        g.setText("");
        g.setClickable(true);

        h.setText("");
        h.setClickable(true);

        i.setText("");
        i.setClickable(true);

    }
}
