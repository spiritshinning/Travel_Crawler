package crawJena;

import ShowData.TouristDescription;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

import java.io.*;
import java.util.Scanner;

public class SaveFormFile extends FormatSaved {
    @Override
    String getFormat(String text) {
        return this.inheritance;
    }

    public static int que = 14;

    private String inheritance = super.getText();

    public SaveFormFile(String text, String filename, String file_format) {
    }

    public static void main(String args[]) throws IOException {
        GetQuery preQuery = new GetQuery();
        String location = preQuery.Relocation();
        ParameterizedSparqlString queryStr = preQuery.getQuery(que);
        Query query = queryStr.asQuery();
        QueryExecution x = QueryExecutionFactory.sparqlService(location, query);
        String pathName = "src/fliesaved/";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name of file you want to save:");
        String text = sc.nextLine();
        Model model = x.execConstruct();
        String dinhdang = "TURTLE";
        System.out.println("Enter form you want? TURTLE,JSON-LD, RDF/XML,N-TRIPLES,RDF/JSON");
        dinhdang = sc.nextLine();
        String tailForm = ".ttl";
        if (dinhdang == "JSON-LD") tailForm = ".json";
        if (dinhdang == "RDF/XML") tailForm = ".rdf";
        if (dinhdang == "N-TRIPLES") tailForm = ".nt";
        if (dinhdang == "RDF/JSON") tailForm = ".rdf";
        File file = new File(pathName + text + tailForm);
        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        model.write(outputStream, dinhdang);
        String pathNametxt = "src/fileout/";
        File filetxt = new File(pathNametxt + text + ".txt");
        filetxt.createNewFile();
        outputStream = new FileOutputStream(filetxt);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        TouristDescription TD = new TouristDescription();
        String[][] a = TD.getDataTourist(que);
        int dem = TD.getDem();
        for (int i = 0; i < dem; i++) {
            // System.out.println(a[i][0]+"\n"+a[i][1]+"\n"+a[i][2]+"\n\n");
            outputStreamWriter.write(a[i][0] + "\n");
            outputStreamWriter.write(a[i][1] + "\n");
            outputStreamWriter.write(a[i][2] + "\n");
            outputStreamWriter.write("\n");
        }
        outputStreamWriter.flush();
    }


}