package vemanhinh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vedulieu.VeJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MarketController implements Initializable {

    @FXML
    private Button buttonScene;
    @FXML
    private VBox chosenMemberCard;

    @FXML
    private Label memberNameLable;

    @FXML
    private Label memberPriceLabel;

    @FXML
    private ImageView fruitImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Member> members = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    private List<Member> getData() {
        List<Member> members = new ArrayList<>();
        Member member;

        member = new Member();
        member.setName("Đào Minh Chí");
        member.setPrice(10);
        member.setImgSrc("/vemanhinh/img/kiwi.jpg");
        member.setColor("6A7324");
        members.add(member);

        member = new Member();
        member.setName("Nguyễn Minh Quân");
        member.setPrice(10);
        member.setImgSrc("/vemanhinh/img/quan.jpg");
        member.setColor("A7745B");
        members.add(member);

        member = new Member();
        member.setName("Vũ Đức Toản");
        member.setPrice(10);
        member.setImgSrc("/vemanhinh/img/toan.jpg");
        member.setColor("F16C31");
        members.add(member);

        member = new Member();
        member.setName("Vũ Thùy Linh");
        member.setPrice(10);
        member.setImgSrc("/vemanhinh/img/linh.jpg");
        member.setColor("291D36");
        members.add(member);

        return members;
    }

    private void setChosenFruit(Member member) {
        memberNameLable.setText(member.getName());
        memberPriceLabel.setText(member.getPrice()+Draw_midterm_OOP_thay_Dat.Contribute);
        //System.out.println(fruit.getImgSrc());
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(member.getImgSrc())));
        fruitImg.setImage(image);
        chosenMemberCard.setStyle("-fx-background-color: #" + member.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        members.addAll(getData());
        if (members.size() > 0) {
            setChosenFruit(members.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Member member) {
                    setChosenFruit(member);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < members.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(members.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changedScene(ActionEvent e) throws IOException {
        VeJavaFX veJavaFx = new VeJavaFX();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        veJavaFx.start(stage);
    }
}
