package dk.andreasjuul.galgeleg.activity;

public class Highscore implements Comparable<Highscore> {
    private String ord;
    private int score;

    public Highscore (String ord, int score) {
        this.ord = ord;
        this.score = score;
    }

    public String getOrd() {
        return ord;
    }

    public void setOrd(String ord) {
        this.ord = ord;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int calculate (int wrongWords, int lengthOfWord) {
        if(wrongWords == 0)
            return ((1000/1)*lengthOfWord)+2000; //to avoid divide by 0
        return ((1000/wrongWords)*lengthOfWord);
    }

    @Override
    public int compareTo(Highscore o) {
        int score1 = o.getScore();
        int score2 = this.getScore();
        if (score1 < score2)
            return 1;
        if(score1 == score2)
            return 0;
        else
            return -1;
    }
}
