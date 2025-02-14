import java.util.*;

public class Main {

    public static void main(String[] args) {

        Collection<Population> populationData =  new FileHandler("Birth and Death Dataset.csv").getData();

        HashSet<String> regions = new HashSet<>();
        TreeSet<Integer> years = new TreeSet<>();

        int overAllBirthCount = 0;
        int overAllDeathCount = 0;


        for(Population data: populationData){
            regions.add(data.region());
            years.add(data.period());

            if(data.status().equals("Births"))
                overAllBirthCount += data.count();
            else
                overAllDeathCount += data.count();
        }


        //Que1
        System.out.println("Display all the Regions as a List without Duplicates");
        System.out.println(regions);
        //Que2
        System.out.println("Display all the year mentioned under Period without Duplicates");
        System.out.println(years);
        //Que3
        System.out.printf("Overall Birth count: %d \nOverall Death count: %d",overAllBirthCount,overAllDeathCount);
        System.out.println();




        TreeMap<Integer,BirthAndDeathCountYear> yearWiseBirthDeath = new TreeMap<>();
        for(Integer year: years){
            int birthCount = 0;
            int deathCount = 0;
            for(Population data: populationData){
                if(data.period()==year){
                    if(data.status().equals("Births"))
                        birthCount+= data.count();
                    else
                        deathCount+= data.count();
                }
            }

            yearWiseBirthDeath.put(year,new BirthAndDeathCountYear(birthCount,deathCount));
        }
        //Que4
        System.out.println(yearWiseBirthDeath);
        System.out.println();




        TreeMap<String, TreeMap<Integer,BirthAndDeathCountYear>> regionWiseBirthDeath = new TreeMap<>();
        for(String region: regions){
            TreeMap<Integer,BirthAndDeathCountYear> yearWiseData = new TreeMap<>();
                    for(Integer year: years){
                        int birthCount = 0;
                        int deathCount = 0;
                        for(Population data: populationData){
                            if(data.period()==year && data.region().equals(region)){
                                if(data.status().equals("Births"))
                                    birthCount+= data.count();
                                else
                                    deathCount+= data.count();
                            }
                        }
                        yearWiseData.put(year,new BirthAndDeathCountYear(birthCount,deathCount));

                    }
                    regionWiseBirthDeath.put(region,yearWiseData);
        }
        //Que5
        System.out.println(regionWiseBirthDeath);
        System.out.println();



        //Que6
        System.out.println("Find which year has highest Birth and Death Rate");
        printHighestBirthAndDeathRate(yearWiseBirthDeath);
        System.out.println();


        //Que7
        System.out.println("Display the highest Birth and Death Rate for each region along with the year");
        for(Map.Entry<String, TreeMap<Integer,BirthAndDeathCountYear>> entry:regionWiseBirthDeath.entrySet()){
            System.out.println(entry.getKey());
            printHighestBirthAndDeathRate(entry.getValue());
        }

    }

    public static void printHighestBirthAndDeathRate( TreeMap<Integer,BirthAndDeathCountYear> data ){
        Map.Entry<Integer, BirthAndDeathCountYear> higestBirthRate = null;
        Map.Entry<Integer, BirthAndDeathCountYear> higestDeathRate = null;

        for (Map.Entry<Integer, BirthAndDeathCountYear> entry : data.entrySet()) {
            //birth
            if (higestBirthRate == null)
                higestBirthRate = entry;
            else if (entry.getValue().getBirthCount() > higestBirthRate.getValue().getBirthCount())
                higestBirthRate = entry;
            //death
            if (higestDeathRate == null)
                higestDeathRate = entry;
            else if (entry.getValue().getDeathCount() > higestBirthRate.getValue().getDeathCount())
                higestDeathRate = entry;

        }
        System.out.printf("%d Highest birth rate: %d",higestBirthRate.getKey(),higestBirthRate.getValue().getBirthCount());
        System.out.println();
        System.out.printf("%d Death birth rate: %d",higestDeathRate.getKey(),higestDeathRate.getValue().getBirthCount());
        System.out.println();
    }
}
