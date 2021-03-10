import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageAnalyser {

    private final List<String> wasItYesOrNo = new ArrayList<>();
    private final Random random = new Random();

    private final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    private final Set<String> affirmativeAnswerUser = Set.of("y", "yes", "yeah", "yep", "sure", "right"
            , "affirmative", "correct", "indeed", "youbet", "exactly", "yousaidit");
    private final Set<String> negativeAnswerUser = Set.of("n", "no", "noway", "nah", "nope"
            , "negative", "idon'tthinkso", "yeahno");

    public LanguageAnalyser() {
        wasItYesOrNo.add("I'm not sure I caught you: was it yes or no?");
        wasItYesOrNo.add("Funny, I still don't understand, is it yes or no?");
        wasItYesOrNo.add("Oh, it's too complicated for me: just tell me yes or no.");
        wasItYesOrNo.add("Could you please simply say yes or no?");
        wasItYesOrNo.add("Oh, no, don't try to confuse me: say yes or no.");
        wasItYesOrNo.add("Just give it to me straight: is it yes or no?");
    }

    public String getAnimalFromUser(String animal) {
        boolean hasArticleAn = animal.startsWith("an ");
        boolean hasArticleA = animal.startsWith("a ");
        if(hasArticleA){
            return animal;
        }else if(hasArticleAn){
            return animal;
        }else if(vowels.contains(animal.charAt(0))) {
            return "an "+animal;
        }else {
            return "a "+animal;
        }
    }
    public String getAnimalFact(String fact){
        Pattern pattern = Pattern.compile("It (can.*)|It (has.*)|It (is.*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fact);
        if(matcher.find()){
            return matcher.group().replaceFirst("[Ii][Tt]'?s? ","");
        }else {
            return "*";
        }
    }

    public String getConfirmAnimalAnswer(String userAnswer) {
        String answer = userAnswer.replace(".", "")
                .replace("!", "").replace(" ", "");
        if (affirmativeAnswerUser.contains(answer)) {
            return "Yes";
        } else if (negativeAnswerUser.contains(answer)) {
            return "No";
        } else {
            int x = random.nextInt(wasItYesOrNo.size());
            return wasItYesOrNo.get(x);
        }
    }


}
