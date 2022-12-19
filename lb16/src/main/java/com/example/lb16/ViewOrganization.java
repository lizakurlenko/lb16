package com.example.lb16;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ViewOrganization {
    private Organization org;
    private GridPane grid;
    private Text cashBonus;
    private Text nameOrg;
    private Text holidayOrg;
    private Text dateOrg;

    private void createPane() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Font font = Font.font("Tahoma", FontWeight.NORMAL, 24);

        nameOrg = new Text();
        nameOrg.setFont(font);
        GridPane.setHalignment(nameOrg, HPos.CENTER);
        grid.add(nameOrg, 0, 0, 2, 1);

        holidayOrg = new Text();
        holidayOrg.setFont(font);
        grid.add(holidayOrg, 0, 1);

        dateOrg = new Text();
        dateOrg.setFont(font);
        grid.add(dateOrg, 1, 1);

        Label bonusVolumeTitle = new Label("Bonus by one person");
        bonusVolumeTitle.setFont(font);
        grid.add(bonusVolumeTitle, 0, 2);

        cashBonus = new Text();
        cashBonus.setFont(font);
        grid.add(cashBonus, 1, 2);
    }

    private void addListenersOrg() {
        nameOrg.textProperty().bind(org.nameProperty());
        holidayOrg.textProperty().bind(org.holidayProperty());
        dateOrg.textProperty().bind(org.dateProperty().asString());
        org.bonusProperty().addListener((observable, oldValue, newValue) ->
                cashBonus.setText(Double.toString(org.getBonusPerPerson())));
        org.personnelProperty().addListener((observable, oldValue, newValue) ->
                cashBonus.setText(Double.toString(org.getBonusPerPerson())));
    }

    public GridPane getPane() {
        return grid;
    }

    public void setOrganization (Organization org) {
        this.org = org;
        addListenersOrg();
    }

    public ViewOrganization(Organization org) {
        createPane();
        setOrganization(org);
    }

}