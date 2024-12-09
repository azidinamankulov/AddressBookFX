package databil.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import repository.*;

public class MainControlPane extends StackPane {

    private final CreateContactForm createContactForm;
    private final SearchContactForm searchContactForm;
    private final UpdateContactForm updateContactForm;

    public MainControlPane(CreateContactMove contactService,
                           CheckActionMove checkActionMove,
                           SearchActionMove searchActionMove,
                           SearchActionByPrefixMove searchActionByPrefixMove,
                           UpdateActionMove updateActionMove) {
        this.updateContactForm = new UpdateContactForm(updateActionMove, searchActionMove, checkActionMove);
        this.createContactForm = new CreateContactForm(contactService, checkActionMove);
        this.searchContactForm = new SearchContactForm(searchActionMove, searchActionByPrefixMove, checkActionMove);

        Button createButton = new Button("CREATE CONTACT");
        Button searchButton = new Button("SEARCH CONTACT");
        Button updateButton = new Button("UPDATE CONTACT");
        Button backButton = createStyledButton("BACK");

        createContactForm.setVisible(false);
        searchContactForm.setVisible(false);
        updateContactForm.setVisible(false);
        backButton.setVisible(false);

        VBox buttonBox = new VBox(15, createButton, searchButton, updateButton);
        buttonBox.setAlignment(Pos.TOP_CENTER);

        StackPane.setAlignment(backButton, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(backButton, new Insets(10));

        this.getChildren().addAll(buttonBox, createContactForm, searchContactForm, updateContactForm, backButton);

        createButton.setOnAction(_ -> {
            buttonBox.setVisible(false);
            createContactForm.setVisible(true);
            searchContactForm.setVisible(false);
            updateContactForm.setVisible(false);
            backButton.setVisible(true);
        });

        searchButton.setOnAction(_ -> {
            buttonBox.setVisible(false);
            searchContactForm.setVisible(true);
            createContactForm.setVisible(false);
            updateContactForm.setVisible(false);
            backButton.setVisible(true);
        });

        updateButton.setOnAction(_ -> {
            buttonBox.setVisible(false);
            searchContactForm.setVisible(false);
            createContactForm.setVisible(false);
            updateContactForm.setVisible(true);
            backButton.setVisible(true);
        });

        backButton.setOnAction(_ -> {
            buttonBox.setVisible(true);
            createContactForm.setVisible(false);
            searchContactForm.setVisible(false);
            updateContactForm.setVisible(false);
            backButton.setVisible(false);
        });
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #34495E; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 12px; -fx-border-color: #BDC3C7;");
        button.setPrefWidth(100);
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: #2C3E50; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 12px;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: #34495E; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-background-radius: 12px;"));
        return button;
    }
}
