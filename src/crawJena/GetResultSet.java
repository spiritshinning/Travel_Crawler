package crawJena;

import org.apache.jena.query.*;

import static crawJena.SaveFormFile.que;

public class GetResultSet {
    private int d = 0;
    private GetQuery preQuery = new GetQuery();
    private String location = preQuery.Relocation();

    private ParameterizedSparqlString queryStr = preQuery.getQuery(d);
    private Query query = queryStr.asQuery();
    private QueryExecution x = QueryExecutionFactory.sparqlService(location, query);
    private ResultSet results = x.execSelect();

    public GetResultSet() {
    }

    public GetResultSet(int d) {
        this.d = d;
        this.queryStr = preQuery.getQuery(d);
        this.query = queryStr.asQuery();
        this.x = QueryExecutionFactory.sparqlService(location, query);
        this.results = x.execSelect();
    }

    public GetResultSet(String text) {
        this.d = que + 1;
        this.queryStr = preQuery.getQuery(text);
        this.query = queryStr.asQuery();
        this.x = QueryExecutionFactory.sparqlService(location, query);
        this.results = x.execSelect();
    }

    public ResultSet GetSet() {
        return this.results;
    }
}
