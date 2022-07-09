package ShowData;
import org.apache.jena.rdf.model.*;

import java.io.*;

public class ReadTxt implements PrintData{
    private String pathName="src/fileout/";
    private int dem=0;
    private int sizes=3;
    private String[][] Datatourism=new String[100][100];

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }

    public int getSizes() {
        return sizes;
    }

    public void setSizes(int sizes) {
        this.sizes = sizes;
    }

    public String[][] getDatatourism() {
        return Datatourism;
    }

    public void setDatatourism(String[][] datatourism) {
        Datatourism = datatourism;
    }

    private String text[] = new String[100];
    public String[][] GetData(int qu) throws IOException {
        this.text[2]="festival.txt";
        this.text[1]="food.txt";
        this.text[0]="tourist.txt";
        this.text[3]="cityinVietnam.txt";
        this.text[4]="airline.txt";
        this.text[5]="ethnic.txt";
        this.text[6]="lake.txt";
        this.text[7]="heritagesites.txt";
        this.text[8]="touristacommodation.txt";
        this.text[9]="dynasty.txt";
        this.text[10]="Airport.txt";
        this.text[11]="beach.txt";
        this.text[12]="pagoda.txt";
        this.text[13]="moutain.txt";
        this.text[14]="island.txt";
        File file = new File(this.pathName+this.text[qu]);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = "";
        String[][] Data = new String[100][100];
        int i=0;
        int dem=0;
        while((line = reader.readLine()) != null){
            if(i!=3)Data[dem][i]=line;
            if(i==3)dem++;
            i=(i+1)%4;
        }
        this.dem=dem;
        this.Datatourism=Data;
        return Data;
    }
    public String[][] GetData(int qu,String text) throws IOException {
        File file = new File(this.pathName+text+".txt");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = "";
        String[][] Data = new String[100][100];
        int i=0;
        int dem=0;
        while((line = reader.readLine()) != null){
            if(i!=3)Data[dem][i]=line;
            if(i==3)dem++;
            i=(i+1)%4;
        }
        this.dem=dem;
        this.Datatourism=Data;
        return Data;
    }
    @Override
    public void PrintData() {
        for(int i=0;i<this.dem;i++)
        {
            for(int j=0;j<this.sizes;j++)
                System.out.print(this.Datatourism[i][j]+'\n');
            System.out.print("\n");
        }
    }
}