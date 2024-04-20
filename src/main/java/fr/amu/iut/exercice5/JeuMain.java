package fr.amu.iut.exercice5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private double anx;
    private double any;
    private int secpassed;

    //Créer obstacles
    Obstacles rectangle = new Obstacles(300, 60, 300, 100);
    Obstacles carre = new Obstacles(60, 60, 20, 50);

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ++secpassed;
            }
        }));
        timeline.setCycleCount(timeline.INDEFINITE);


        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //ajout des obstacles
        root.getChildren().add(rectangle);
        root.getChildren().add(carre);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, rectangle);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Obstacles obstacles) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    anx = j1.getLayoutX();
                    any = j1.getLayoutY();
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    anx = j1.getLayoutX();
                    any = j1.getLayoutY();
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    anx = j1.getLayoutX();
                    any = j1.getLayoutY();
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    anx = j1.getLayoutX();
                    any = j1.getLayoutY();
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Z :
                    anx = j2.getLayoutX();
                    any = j2.getLayoutY();
                    j2.deplacerEnHaut();
                    break;
                case S:
                    anx = j2.getLayoutX();
                    any = j2.getLayoutY();
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Q:
                    anx = j2.getLayoutX();
                    any = j2.getLayoutY();
                    j2.deplacerAGauche();
                    break;
                case D:
                    anx = j2.getLayoutX();
                    any = j2.getLayoutY();
                    j2.deplacerADroite(scene.getWidth());
                    break;
            }
            if (j1.estEnCollision(j2)) {
                if(secpassed < 10)
                    System.out.println("Pac Man a gagné");
                else
                    System.out.println("Fantome a gagné");
                System.out.println("Collision....");
                System.exit(0);
            }
            if (j1.estEnCollisionAvecMur(rectangle)){
                j1.setLayoutX(anx);
                j1.setLayoutY(any);
            }
            System.out.println("OBSTACLE");
            if (j2.estEnCollisionAvecMur(rectangle)) {
                j2.setLayoutX(anx);
                j2.setLayoutY(any);
                System.out.println("OBSTACLE");
            }
            if (j2.estEnCollisionAvecMur(carre)) {
                j2.setLayoutX(anx);
                j2.setLayoutY(any);
                System.out.println("OBSTACLE");
            }
            if (j1.estEnCollisionAvecMur(carre)){
                j1.setLayoutX(anx);
                j1.setLayoutY(any);
            }
        });
    }
}
