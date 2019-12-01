package paoo.Game;

import paoo.Items.Monster;

public class ScoreBoard {
    private static int player1Score = 0;
    private static int player2Score = 0;
    private Menu meniu;
    private static ScoreBoard instance;

    public void SetMeniu(Menu a){
        meniu=a;
    }
    public static ScoreBoard getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new ScoreBoard();
        }
    }

    public ScoreBoard() {
        player1Score = 0;
        player2Score = 0;
    }

    public int GetPlayer1Score() {
        return player1Score;
    }

    public int GetPlayer2Score() {
        return player2Score;
    }

    public void IncrementP1Score() {
        player1Score++;
    }

    public void IncrementP2Score() {
        player2Score++;
    }

    public void ResetScore() {
        player1Score = 0;
        player2Score = 0;
    }



}

