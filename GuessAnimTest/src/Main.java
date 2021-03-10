import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Utility utility = new Utility();
        List<Animal> animals = new ArrayList<>();
        LanguageAnalyser lang = new LanguageAnalyser();

        boolean isValidAnswer;

        utility.greetUser();

        System.out.println("Enter the first animal: ");
        animals.add(new Animal(lang.getAnimalFromUser(input.nextLine())));
        System.out.println("Enter the second animal: ");
        animals.add(new Animal(lang.getAnimalFromUser(input.nextLine())));
        String fact;
        do {
            System.out.println("Specify a fact that distinguishes a cat from a dog."
                    + "\r\n" + "The sentence should be of the format: 'It can/has/is ...'.");
            System.out.println();
            fact = lang.getAnimalFact(input.nextLine());
            isValidAnswer = "*".equals(fact);
        } while (isValidAnswer);

        do {
            System.out.println("Is it correct for " + animals.get(0).getName());
            String answer = lang.getConfirmAnimalAnswer(input.nextLine());
            if ("Yes".equals(answer)){
                animals.get(0).addAnimalFact(fact);
                animals.get(0).setFact(fact);
                animals.get(1).addAnimalFact(utility.negateFact(fact));
                animals.get(1).setFact(utility.negateFact(fact));
                isValidAnswer = false;
            }else if ("No".equals(answer)){
                animals.get(1).addAnimalFact(fact);
                animals.get(1).setFact(fact);
                animals.get(0).addAnimalFact(utility.negateFact(fact));
                animals.get(0).setFact(utility.negateFact(fact));
                isValidAnswer = false;
            }else {
                isValidAnswer = true;
            }
        }while (isValidAnswer);
        System.out.println("I learned the following about animals: ");
        utility.printAnimalFacts(animals);
        System.out.println("I can distinguish these animals by asking the question:");
        System.out.println(" - "+utility.generateQuestionFromFact(fact));
        utility.sayGoodbye();
    }
}
