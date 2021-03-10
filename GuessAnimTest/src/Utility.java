import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    private final List<String> goodbyes = new ArrayList<>();
    private final Random random = new Random();

    public Utility() {
        goodbyes.add("Bye!");
        goodbyes.add("See ya!");
        goodbyes.add("Have a nice day");
        goodbyes.add("See you later!");
        goodbyes.add("Goodbye!");
    }

    private final LocalTime currentTime = LocalTime.now();
    private final LocalTime morningStart = LocalTime.of(5, 0);
    private final LocalTime noonStart = LocalTime.NOON;
    private final LocalTime eveningStart = LocalTime.of(18, 0);
    private final boolean isMorning = (currentTime.isAfter(morningStart)
            || currentTime.equals(morningStart)) && currentTime.isBefore(noonStart);
    private final boolean isNoon = (currentTime.isAfter(noonStart)
            || currentTime.equals(noonStart)) && currentTime.isBefore(eveningStart);
    private final boolean isEvening = (currentTime.isAfter(eveningStart)
            || currentTime.equals(eveningStart) || currentTime.isAfter(LocalTime.MIDNIGHT)
            && currentTime.isBefore(morningStart));


    public void greetUser() {
        if (isMorning) {
            System.out.println("Hi, Early Bird!");
            System.out.println();
        } else if (isNoon) {
            System.out.println("Good afternoon!");
            System.out.println();
        } else if (isEvening) {
            System.out.println("Hi, Night Owl");
            System.out.println();
        }
    }

    public void sayGoodbye() {
        int x = random.nextInt(goodbyes.size());
        System.out.println();
        System.out.println(goodbyes.get(x));
    }

    public void printAnimalFacts(List<Animal> animals) {
        for (Animal animal : animals) {
            Pattern pattern = Pattern.compile("a |an ");
            Matcher matcher = pattern.matcher(animal.getName());
            System.out.println(" - The " + matcher.replaceFirst("") + " " + animal.getFact());
        }
    }

    public String negateFact(String fact) {
        if (fact.startsWith("can ")) {
            return fact.replaceFirst("can ", "can't ");
        } else if (fact.startsWith("has ")) {
            return fact.replaceFirst("has ", "doesn't have ");
        } else {
            return fact.replaceFirst("is ", "isn't ");
        }
    }

    public String generateQuestionFromFact (String fact){
        if (fact.startsWith("can ")) {
            return fact.replaceFirst("can ", "Can it ")+"?";
        } else if (fact.startsWith("has ")) {
            return fact.replaceFirst("has ", "Does it have ") + "?";
        } else {
            return fact.replaceFirst("is ", "Is it ") + "?";
        }
    }

    public String removeSpaceAtStart(String input) {
        char[] inputArray = input.toCharArray();
        int i = 0;
        while (inputArray[i] == ' ') {
            inputArray[i] = '%';
            i++;
        }
        return String.valueOf(inputArray).replace("%", "");
    }

    public String checkForErroneousPunctuation(String input) {

        char[] inputArray = input.toCharArray();
        int checkDot = 0;
        int checkExclamation = 0;
        int validExclamation = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[inputArray.length - 1 - i] == ' ') {
                continue;
            } else if ((inputArray[inputArray.length - 1 - i] == '.'
                    || inputArray[inputArray.length - 1 - i] == '!')) {
                validExclamation++;
                break;
            } else {
                break;
            }
        }

        for (char c : inputArray) {
            if (c == '.') {
                checkDot++;
            } else if (c == '!') {
                checkExclamation++;
            }
        }
        if (checkDot > 1 || checkExclamation > 1) {
            return "*";
        } else if ((checkDot == 1 || checkExclamation == 1) && validExclamation == 0) {
            return "*";
        } else if (checkDot >= 1 && checkExclamation >= 1) {
            return "*";
        } else {
            return input;
        }
    }

}
