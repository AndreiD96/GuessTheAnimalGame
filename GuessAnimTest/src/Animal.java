import java.util.ArrayList;
import java.util.List;

public class Animal {


    private String name;
    private List<String> factsAboutAnimal = new ArrayList<>();
    private String fact;


    public Animal(String name, String fact) {
        this.name = name;
        this.factsAboutAnimal.add(fact);
    }

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public List<String> getFactsAboutAnimal() {
        return factsAboutAnimal;
    }

    public void setFactsAboutAnimal(List<String> factsAboutAnimal) {
        this.factsAboutAnimal = factsAboutAnimal;
    }

    public void addAnimalFact(String fact) {
        this.factsAboutAnimal.add(fact);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
