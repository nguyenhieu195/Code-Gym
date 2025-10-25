package pj8_refactoring;

public class TennisGame {
    public static String getResultTennis(int scorePlayer1, int scorePlayer2) {
        String result = "";
        int tempScore=0;
        if (scorePlayer1==scorePlayer2)
        {
            result = getScore(scorePlayer1);
        }
        else if (scorePlayer1>=4 || scorePlayer2>=4)
        {
            result = getAdvantage(scorePlayer1-scorePlayer2);
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = scorePlayer1;
                else { result+="-"; tempScore = scorePlayer2;}
                result += getScore(tempScore);
            }
        }
        return result;
    }

    private static String getAdvantage(int minusResult) {
        String result;
        if (minusResult ==1) result ="Advantage player1";
        else if (minusResult ==-1) result ="Advantage player2";
        else if (minusResult >=2) result = "Win for player1";
        else result ="Win for player2";
        return result;
    }

    private static String getScore(int score) {
        String result = "";
        switch (score)
        {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            case 3:
                result = "Forty-All";
                break;
            default:
                result = "Deuce";
                break;

        }
        return result;
    }
}