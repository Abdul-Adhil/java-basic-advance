import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

record Population(int period,String status,String region,int count){}

public class FileHandler {

    private final String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    private String filePath(){
        try {
            File file = new File("data",fileName);

            if(file.exists())
                return file.getAbsolutePath();
            else
                return "";

        } catch (Exception e) {
            System.err.println("Error occured while fetching the file path "+ e.getMessage());
            return "";
        }

    }

    public Collection<Population> getData() {
        String filePath = filePath();
        Collection <Population> arrList = new ArrayList<>();
        if (!filePath.equals("")) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] stringParts = line.split(",");
                    if(!stringParts[0].equals("Period")){
                        int period = Integer.parseInt(stringParts[0]);
                        String status = stringParts[1];
                        String region = stringParts[2];
                        int count = Integer.parseInt(stringParts[3]);
                        Population population = new Population(period, status, region, count);
//                        System.out.println( population.toString());
                        arrList.add(population);
                    }
                }
//                System.out.println(arrList);


            } catch (IOException e) {
                System.out.println("Error while reading from file..!!");
                return arrList;
            }
        }
        else{
            System.out.println("File not found..!!!");
            return arrList;
        }

        return arrList;
    }

}
