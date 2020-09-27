/**
 * Created by xiangtiangu on 4/26/17.
 */
public class BlackJackCard extends Card{

    public BlackJackCard(Suit suit, int faceValue) {
        super(suit, faceValue);

    }

    public int value() {
        if(isAce()) {
            return 1;
        }else if(is_face_Value()) {
            return 10;
        }
        return faceValue;
    }

    private boolean isAce() {
        return faceValue == 1;
    }

    private boolean is_face_Value() {
        return faceValue >= 11 && faceValue <= 13;
    }

    public int min_value() {
        if(isAce()) {
            return 1;
        }
        return value();
    }

    public int max_value() {
        if(isAce()) {
            return 10;
        }

        return value();
    }
    hahahahahahahahahahahahahaaxxxxxxxx
}
