package crawJena;

import ShowData.TouristDescription;
import org.apache.jena.query.ParameterizedSparqlString;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.rdf.model.Model;

import java.io.*;

public class SaveFromJavaFX extends FormatSaved {

    @Override
    String getFormat(String text) {
        return text;
    }

    public SaveFromJavaFX(String text, String filename, String file_format) throws IOException {
        this.SaveFromJavaFX(text, filename, file_format);
    }

    public void SaveFromJavaFX(String text, String filename, String fileFormat) throws IOException {
        GetQuery preQuery = new GetQuery();
        String location = preQuery.Relocation();
        ParameterizedSparqlString queryStr = preQuery.getQuery(text);
        Query query = queryStr.asQuery();
        QueryExecution x = QueryExecutionFactory.sparqlService(location, query);
        String pathName = "src/fliesaved/";
        Model model = x.execConstruct();
        String tailForm = ".ttl";
        if (fileFormat == "JSON-LD") tailForm = ".json";
        if (fileFormat == "RDF/XML") tailForm = ".rdf";
        if (fileFormat == "N-TRIPLES") tailForm = ".nt";
        if (fileFormat == "RDF/JSON") tailForm = ".rdf";
        File file = new File(pathName + filename + tailForm);
        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        model.write(outputStream, fileFormat);
        String pathNametxt = "src/fileout/";
        File filetxt = new File(pathNametxt + filename + ".txt");
        filetxt.createNewFile();
        outputStream = new FileOutputStream(filetxt);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        TouristDescription TD = new TouristDescription();
        String[][] a = TD.getDataTourist(getFormat(text));
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
