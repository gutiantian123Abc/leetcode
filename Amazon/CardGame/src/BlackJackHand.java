import java.util.ArrayList;

/**
 * Created by xiangtiangu on 4/26/17.
 */
public class BlackJackHand extends Hand {
    public BlackJackHand() {
        super();
    }

    public ArrayList<Integer> possibleScores() {
        //...
        return new ArrayList<Integer>();
    }

    public int score() {
        ArrayList<Integer> scores = possibleScores();

        int Max_Under = Integer.MIN_VALUE;
        int Min_over = Integer.MAX_VALUE;

        for(Integer score : scores) {
            if(score <= 21 && score > Max_Under) {
                Max_Under = score;
            }else if(score > 21 && score < Min_over) {
                Min_over = score;
            }
        }

        return Max_Under == Integer.MIN_VALUE ? Min_over : Max_Under;
    }

    public boolean win() {
        return score() == 21;
    }

    public boolean lose() {
        return score() > 21;
    }





}