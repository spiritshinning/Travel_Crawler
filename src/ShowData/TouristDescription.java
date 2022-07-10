package ShowData;

import crawJena.CrawRDF;
import crawJena.GetResultSet;
import org.apache.jena.query.ResultSet;

import static crawJena.SaveFormFile.que;

public class TouristDescription implements PrintData {
    private int selectQuery = 0;

    public void setSelectQuery(int qu) {
        this.selectQuery = qu;
        this.resultSet = new GetResultSet(selectQuery);
        this.results = resultSet.GetSet();
        this.Dataget = new CrawRDF();
        this.Datatourism = Dataget.Craw(results);
        this.dem = Dataget.Craw(results, 0);
        this.sizes = Dataget.Craw(results, 0, 0);
    }

    public void setSelectQuery(String text) {
        this.selectQuery = que + 1;
        this.resultSet = new GetResultSet(text);
        this.results = resultSet.GetSet();
        this.Dataget = new CrawRDF();
        this.Datatourism = Dataget.Craw(results);
        this.dem = Dataget.Craw(results, 0);
        this.sizes = Dataget.Craw(results, 0, 0);
    }

    private GetResultSet resultSet = new GetResultSet(selectQuery);

    public TouristDescription(int selectQuery) {
        this.setSelectQuery(selectQuery);
    }

    public TouristDescription() {
    }

    private ResultSet results = resultSet.GetSet();
    private CrawRDF Dataget = new CrawRDF();
    private String[][] Datatourism = Dataget.Craw(results);
    private int dem = Dataget.Craw(results, 0);
    private int sizes = Dataget.Craw(results, 0, 0);

    public int getDem() {
        return dem;
    }

    public int getSizes() {
        return sizes;
    }

    public String[][] getDataTourist(int qu) {
        this.setSelectQuery(qu);
        return this.Datatourism;
    }

    public String[][] getDataTourist(String filename) {
        this.setSelectQuery(filename);
        return this.Datatourism;
    }

    public String[] ReturnData(int d) {
        String[] Image = new String[100];
        for (int i = 0; i < dem; i++) Image[i] = this.Datatourism[i][d - 1];
        return Image;
    }

    @Override
    public void printData() {
        for (int i = 0; i < this.dem; i++) {
            for (int j = 0; j < this.sizes; j++)
                System.out.print(this.Datatourism[i][j] + '\n');
            System.out.print("\n");
        }
    }
}