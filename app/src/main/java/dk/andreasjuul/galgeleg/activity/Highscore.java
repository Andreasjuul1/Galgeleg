package dk.andreasjuul.galgeleg.activity;

public class Highscore implements Comparable<Highscore> {
    private String ord;
    private int score;

    public Highscore (String ord, int score) {
        this.ord = ord;
        this.score = score;
    }
    //Getters og setters
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

    //udregning af score
    private static int calculate (int wrongWords, int lengthOfWord) {
        if(wrongWords == 0)
            return ((1000/1)*lengthOfWord)+1;//sat til 1 pga. hvis ordet er kort.
        return ((1000/wrongWords)*lengthOfWord);
    }

    @Override
    public int compareTo(Highscore highscore) {
        int hs1 = highscore.getScore();
        int hs2 = this.getScore();
        if (hs1 < hs2)
            return 1;
        if(hs1 == hs2)
            return 0;
        else
            return -1;
    }
}
