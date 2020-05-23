package View;

import MockData.MockMovies;
import Models.MovieModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class FirstPageClient {

    private static HBox CurrentLayout;
    private static VBox pendingView,pendingContentView, moviesView,acceptedContentView;
    private static ArrayList<MovieModel> pendingMovies = new ArrayList<>();
    private static ArrayList<MovieModel> acceptedMovies = new ArrayList<>();


    static void display(String username) {

        Stage window = new Stage();
        window.setTitle("Pagina principala REDACTOR SEF " + username);
        CurrentLayout = new HBox();
        Scene scene = new Scene(CurrentLayout, 1000, 600);
        window.setScene(scene);
        window.show();

        onCreate();
    }

    private static void onCreate() {

        //TODO initiez listele cu movies
        pendingMovies.addAll(MockMovies.pendingMovies);
        acceptedMovies.addAll(MockMovies.acceptedMovies);

        //setPending List
        pendingView = new VBox();
        pendingView.setSpacing(10);

        pendingContentView=new VBox();
        pendingContentView.setPrefWidth(500);

        ScrollPane pendingScroll;
        pendingScroll = new ScrollPane();
        pendingScroll.setContent(pendingView);
        pendingScroll.setFitToWidth(true);

        Label pendingTitleView = new Label("All movies list ");
        pendingTitleView.setAlignment(Pos.CENTER);

        //TODO ADAUGATE IN PLUS
        pendingTitleView.setFont(new Font("Arial",15));
        pendingTitleView.setTextFill(Color.web("#ff0000", 0.8));
        pendingTitleView.setContentDisplay(ContentDisplay.CENTER);
        pendingTitleView.setStyle(
                "-fx-padding: 10; "
                        + "-fx-background-color: white; "
                        + "-fx-border-width:3; "
                        + "-fx-border-color: "
                        + "linear-gradient("
                        + "to bottom, "
                        + "red, "
                        + "derive(chocolate, 50%)"
                        + ");"
        );
        pendingView.setAlignment(Pos.CENTER);
        //TODO GATA ADAUHGATE IN PLUS
        pendingView.getChildren().addAll(pendingTitleView,pendingContentView);


        createPendingList();

        //set Movies view
        moviesView = new VBox();
        moviesView.setSpacing(10);

        acceptedContentView=new VBox();
        acceptedContentView.setPrefWidth(500);

        ScrollPane moviesScroll;
        moviesScroll = new ScrollPane();
        moviesScroll.setContent(moviesView);
        moviesScroll.setFitToWidth(true);

        Label moviesViewTitle = new Label("Accepted movies list");
        moviesViewTitle.setAlignment(Pos.CENTER);

        moviesView.getChildren().addAll(moviesViewTitle,acceptedContentView);

        createAcceptedList();

        CurrentLayout.getChildren().addAll(pendingScroll, moviesScroll);

    }

    private static void createPendingList() {
        pendingContentView.getChildren().clear();


        for (int i = 0; i< pendingMovies.size(); i++){
            pendingContentView.getChildren().add(createPendingCell(pendingMovies.get(i)));
        }
    }

    private static void createAcceptedList(){
        acceptedContentView.getChildren().clear();

        for (int i = 0; i< acceptedMovies.size(); i++){
            acceptedContentView.getChildren().add(createAcceptedCell(acceptedMovies.get(i)));
        }
    }


    private static VBox createAcceptedCell(MovieModel movie){
        String cssLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n";

        VBox cellParent = new VBox();
        cellParent.setPadding(new Insets(10, 10, 10, 10));
        cellParent.setStyle(cssLayout);
        cellParent.setSpacing(20);

        VBox detailBox = new VBox();
        detailBox.setPrefWidth(500);
        detailBox.setSpacing(5);

        Label titleLabel = new Label(movie.getAutor() + ":" + movie.getNume());
        Label descLabel = new Label(movie.getContinut());

        descLabel.setWrapText(true);
        descLabel.setPrefWidth(500);
        descLabel.setTextAlignment(TextAlignment.JUSTIFY);
        detailBox.getChildren().addAll(titleLabel, descLabel);

        cellParent.getChildren().add(detailBox);

        return cellParent;
    }



    private static VBox createPendingCell(final MovieModel movie) {
        String cssLayout = "-fx-border-color: black;\n" +
                "-fx-border-insets: 5;\n" +
                "-fx-border-width: 3;\n";

        VBox cellParent = new VBox();
        cellParent.setPadding(new Insets(10, 10, 10, 10));
        cellParent.setStyle(cssLayout);
        cellParent.setSpacing(20);

        VBox detailBox = new VBox();
        detailBox.setPrefWidth(500);
        detailBox.setSpacing(5);

        Label titleLabel = new Label(movie.getAutor() + ":" + movie.getNume());
        Label descLabel = new Label(movie.getContinut());

        descLabel.setWrapText(true);
        descLabel.setPrefWidth(500);
        descLabel.setTextAlignment(TextAlignment.JUSTIFY);
        detailBox.getChildren().addAll(titleLabel, descLabel);

        HBox actionBox = new HBox();
        actionBox.minWidth(60);
        actionBox.setSpacing(5);

        Button acceptButton = new Button("Accept");
        Button declineButton = new Button("Decline");

        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println(movie.getNume());
            }
        });
        declineButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println(movie.getNume() + " decline");
            }
        });

        actionBox.getChildren().addAll(acceptButton, declineButton);
        actionBox.setAlignment(Pos.CENTER);

        cellParent.getChildren().addAll(detailBox, actionBox);
        return cellParent;
    }
}
