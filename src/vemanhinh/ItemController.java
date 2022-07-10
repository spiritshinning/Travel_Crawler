package vemanhinh;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(member);
    }

    private Member member;
    private MyListener myListener;

    public void setData(Member member, MyListener myListener) {
        this.member = member;
        this.myListener = myListener;
        nameLabel.setText(member.getName());
        priceLable.setText(member.getPrice() + Draw_midterm_OOP_thay_Dat.Contribute);
        Image image = new Image(getClass().getResourceAsStream(member.getImgSrc()));
        img.setImage(image);
    }
}
