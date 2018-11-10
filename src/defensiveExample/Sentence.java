package defensiveExample;

//beispiel wo defensive kopien nicht noetig sind, da String unveraenderlich
public class Sentence {

    private final String sentence;

    Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public static void main(String[] args) {
        String slogan = "wir koennen alles schaffen";
        Sentence sentence = new Sentence(slogan);

        System.out.println(sentence.getSentence());
        slogan = "wir muessen nur wollen";

        System.out.println(sentence.getSentence());

    }
}
