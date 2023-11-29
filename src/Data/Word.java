package Data;

public class Word {
    private int idx;
    private String word;
    private String mean;
    public Word (int idx ,String word, String mean) {
        this.idx = idx;
        this.word = word;
        this.mean = mean;
    }
    public String getWord() {
        return word;
    }
    public String getMean() {
        return mean;
    }

    public int getIdx() {
        return idx;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
    @Override
    public String toString() {
        return word;
    }
    public String getMeanFromWord() {
        int start = this.getMean().indexOf('-');
        int close = this.getMean().indexOf('\n', start + 1);
        if (close == -1) close = this.mean.length() -1 ;
        return this.getMean().substring(start+1, close);
    }
}
