import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Collection<Population> populationData =  new FileHandler("Birth and Death Dataset.csv").getData();

        HashSet<String> regions = new HashSet<>();
        TreeSet<Integer> years = new TreeSet<>();

        HashSet<Population> s = new HashSet<>(populationData);
        System.out.println(s.size());


        for(Population data: populationData){
//            System.out.println(data.region());
            regions.add(data.region());
            years.add(data.period());
        }

        for(Integer year: years){
            System.out.println(year);
        }

        System.out.println("Display all the Regions as a List without Duplicates");
        System.out.println(regions);

        System.out.println("Display all the year mentioned under Period without Duplicates");
        System.out.println(years);
        System.out.println(populationData.size() +"--"+ years.size());



    }
}
