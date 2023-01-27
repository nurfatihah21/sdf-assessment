package task01;

public class TermFreq implements Comparable<TermFreq> {
    private String word;
    private Integer count;
    private Double termFrequency;

    public TermFreq(String word, Integer count, Double termFrequency) {
        this.word = word;
        this.count = count;
        this.termFrequency = termFrequency;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void calculateTF(Double termFrequency) {

    };

    @Override
    public int compareTo(TermFreq o) {
        return this.getWord().compareTo(o.getWord());
    }
}
