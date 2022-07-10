package vedulieu;

import ShowData.TouristDescription;
import crawJena.SaveFromJavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller extends TouristDescription implements Initializable {
    @FXML
    private ImageView imageView;
    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/logohust.png")));
    private final Image image0 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/quetoi.jpg")));
    private final Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/food.jpg")));
    private final Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/festival.jpg")));
    private final Image image3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/city.jpg")));
    private final Image image4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/airline.jpg")));
    private final Image image5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/ethnic.jpg")));
    private final Image image6 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/lake.jpg")));
    private final Image image7 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/heritagesites.jpg")));
    private final Image image8 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/touac.jpg")));
    private final Image image9 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/dynasty.jpeg")));
    private final Image image10 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/airport.png")));
    private final Image image11 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/beach.jpeg")));
    private final Image image12 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/pagoda.png")));
    private final Image image13 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/moutain.jpg")));
    private final Image image14 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("img/island.jpg")));
    @FXML
    private ComboBox<String> comBoBox;
    @FXML
    private ComboBox<String> comBoBox1;
    @FXML
    private TableView<TouristData> table;
    @FXML
    private TableColumn<TouristData, Hyperlink> linkClolumn;
    @FXML
    private TableColumn<TouristData, String> abtractClolumn;
    @FXML
    private TableColumn<TouristData, String> thumbClolumn;

    private ObservableList<TouristData> touristList;
    @FXML
    public Label label;
    @FXML
    public Label label1;
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textField;
    @FXML
    public Button getDataButton;
    TouristData Data = new TouristData();
    ObservableList<String> list = FXCollections.observableArrayList("TouristPlace", "TouristFood", "TouristFestival", "City", "Airline", "Ethnic", "Lake", "Heritage Sites", "Tourist accommodation", "Dynasty", "Airport", "Beach", "Pagoda", "Mountain", "Island");
    ObservableList<String> list1 = FXCollections.observableArrayList("TURTLE", "JSON-LD", "RDF/XML", "N-TRIPLES", "RDF/JSON", "N3");

    public Controller() throws IOException {
    }

    private String text;
    private String filename;
    private String file_format = "TURTLE";

    public void getData(ActionEvent event) throws IOException {
        this.text = textArea.getText();
        this.filename = textField.getText();
        this.file_format = comBoBox1.getValue();
        SaveFromJavaFX a = new SaveFromJavaFX(text, filename, file_format);
        this.list.add(filename);
        this.imageView.setImage(image);
        putData(this.filename);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comBoBox.setItems(list);
        comBoBox1.setItems(list1);
        try {
            this.imageView.setImage(this.image);
            putData(1.1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void comBoBoxChanged(ActionEvent actionEvent) throws IOException {
        label.setText(comBoBox.getValue());
        int dem = this.list.size();
        for (int i = 15; i < dem; i++) {
            if (comBoBox.getValue() == this.list.get(i)) {
                this.imageView.setImage(this.image);
                putData(this.list.get(i));
            }
        }

        if (comBoBox.getValue() == "TouristPlace") {
            this.imageView.setImage(this.image0);
            putData(0);
        }
        if (comBoBox.getValue() == "TouristFood") {
            this.imageView.setImage(this.image1);
            putData(1);
        }
        if (comBoBox.getValue() == "TouristFestival") {
            this.imageView.setImage(this.image2);
            putData(2);
        }
        if (comBoBox.getValue() == "City") {
            this.imageView.setImage(this.image3);
            putData(3);
        }
        if (comBoBox.getValue() == "Airline") {
            this.imageView.setImage(this.image4);
            putData(4);
        }
        if (comBoBox.getValue() == "Ethnic") {
            this.imageView.setImage(this.image5);
            putData(5);
        }
        if (comBoBox.getValue() == "Lake") {
            this.imageView.setImage(this.image6);
            putData(6);
        }
        if (comBoBox.getValue() == "Heritage Sites") {
            this.imageView.setImage(this.image7);
            putData(7);
        }

        if (comBoBox.getValue() == "Tourist accommodation") {
            this.imageView.setImage(this.image8);
            putData(8);
        }

        if (comBoBox.getValue() == "Dynasty") {
            this.imageView.setImage(this.image9);
            putData(9);
        }

        if (comBoBox.getValue() == "Airport") {
            this.imageView.setImage(this.image10);
            putData(10);
        }

        if (comBoBox.getValue() == "Beach") {
            this.imageView.setImage(this.image11);
            putData(11);
        }

        if (comBoBox.getValue() == "Pagoda") {
            this.imageView.setImage(this.image12);
            putData(12);
        }

        if (comBoBox.getValue() == "Mountain") {
            this.imageView.setImage(this.image13);
            putData(13);
        }

        if (comBoBox.getValue() == "Island") {
            this.imageView.setImage(this.image14);
            putData(14);
        }

    }

    private void putData(int qu) throws IOException {
        touristList = FXCollections.observableArrayList();
        for (int i = 0; i < Data.getDem(); i++) {
            touristList.add(new TouristData(i, qu));
        }
        linkClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, Hyperlink>("linkDulieu"));
        abtractClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, String>("abtractDulieu"));
        thumbClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, String>("thumnailDulieu"));
        table.setItems(touristList);
    }

    private int query = super.getDem();

    private void putData(String filename) throws IOException {
        touristList = FXCollections.observableArrayList();
        for (int i = 0; i < Data.getDem(); i++) {
            touristList.add(new TouristData(i, query, filename));
        }
        linkClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, Hyperlink>("linkDulieu"));
        abtractClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, String>("abtractDulieu"));
        thumbClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, String>("thumnailDulieu"));
        table.setItems(touristList);
    }

    private void putData(double a) throws IOException {
        touristList = FXCollections.observableArrayList();
        touristList.add(new TouristData("Welcome", "This is a javaFX function", "To see information"));
        touristList.add(new TouristData("Choose", "The ComboBox to see more", "Thank You"));

        linkClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, Hyperlink>("linkDulieu"));
        abtractClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, String>("abtractDulieu"));
        thumbClolumn.setCellValueFactory(new PropertyValueFactory<TouristData, String>("thumnailDulieu"));
        table.setItems(touristList);

    }

}

