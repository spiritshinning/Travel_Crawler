package crawJena;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

import java.util.List;

public class CrawRDF {
    public CrawRDF() {
    }

    public String[][] Craw(ResultSet results) {
        String[][] SaveData = new String[100][100];
        List<String> columnNames = results.getResultVars();
        int dem = 0;
        for (; results.hasNext(); ) {
            QuerySolution soln = results.nextSolution();
            for (int i = 0; i < columnNames.size(); i++) {
                String columnName = columnNames.get(i);
                RDFNode rdfNode = soln.get(columnName);
                SaveData[dem][i] = rdfNode.toString();
            }
            dem++;
        }
        return SaveData;
    }

    public int Craw(ResultSet results, int dem) {
        return results.getRowNumber();
    }

    public int Craw(ResultSet results, int dem, int size) {
        List<String> columnNames = results.getResultVars();
        return columnNames.size();
    }
}