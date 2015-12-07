package fr.epita.tictactoe.tab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import fr.epita.tictactoe.R;

public class GameBoardFragment extends Fragment implements OnClickListener
{
    private RelativeLayout layout = null;
    // Multi-dimensional array representing the game board.
    // Cell values :
    // -1 : empty cell (not played yet)
    // 0 : played by X
    // 1 : played by O
    private int gameBoard[][] = new int[3][3];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        layout = (RelativeLayout) inflater.inflate(R.layout.fragment_game, null);

        return layout;
    }

    // Checks the game board to see if there is a winner
    // returns :
    // 0 : if player X has a winning line
    // 1 : if player O has a winning line
    // -1 : if no player has a winning line
    private int findWinner()
    {
        for (int i = 0; i < gameBoard.length; i++)
        {
            // Check for a winner in columns and lines
            if (gameBoard[0][i] != -1 && gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i])
                return gameBoard[0][i];
            else if (gameBoard[i][0] != -1 && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2])
                return gameBoard[i][0];
        }

        // Check for a winner in diagonals
        if (gameBoard[0][0] != -1 && gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2])
            return gameBoard[0][0];
        else if (gameBoard[0][2] != -1 && gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0])
            return gameBoard[0][2];

        return -1;
    }

    @Override
    public void onClick(View arg0)
    {

    }
}
