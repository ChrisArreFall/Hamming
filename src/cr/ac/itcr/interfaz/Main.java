package cr.ac.itcr.interfaz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import cr.ac.itcr.algoritmo.ConvertidorDeHex;
import cr.ac.itcr.algoritmo.Hamming;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	Stage hamming;
	Scene inicio, tabla1, tabla2;
	String bin;
	static boolean paridad;

	public static void main(String[] args) {
		paridad = true;
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		bin = "";
		hamming = primaryStage;
		hamming.setTitle("Bienvenido al corrector de errores Hamming");

		hamming.setScene(inicioScene());
		// hamming.setResizable(false);
		hamming.show();

	}

	private Scene inicioScene() throws FileNotFoundException {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		ImageView img1 = new ImageView(
				new Image(new FileInputStream("/Users/Christopher/eclipse-workspace/Hamming/img/logo-tec.png")));
		GridPane.setConstraints(img1, 0, 0, 3, 1);

		ImageView img2 = new ImageView(
				new Image(new FileInputStream("/Users/Christopher/eclipse-workspace/Hamming/img/hamming.jpg")));
		GridPane.setConstraints(img2, 3, 2, 1, 1);
		GridPane.setHalignment(img2, HPos.CENTER);

		// IP label
		Label info = new Label("" + "En informática, el código de Hamming es un código "
				+ "\ndetector y corrector de errores que lleva el nombre"
				+ "\nde su inventor, Richard Hamming. En los datos "
				+ "\ncodificados en Hamming se pueden detectar errores "
				+ "\nen un bit y corregirlos, sin embargo no se distingue"
				+ "\nentre errores de dos bits y de un bit (para lo que se"
				+ "\nusa Hamming extendido). Esto representa una mejora "
				+ "\nrespecto a los códigos con bit de paridad, que pueden"
				+ "\ndetectar errores en sólo un bit, pero no pueden " + "\ncorregirlo.");
		GridPane.setConstraints(info, 1, 2, 1, 1);

		Button Btabla1 = new Button("Obtener");
		Btabla1.setOnAction(e -> {
			try {
				hamming.setScene(tabla1Scene());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		GridPane.setConstraints(Btabla1, 1, 3);
		GridPane.setHalignment(Btabla1, HPos.RIGHT);

		Button Btabla2 = new Button(" Revisar ");
		Btabla2.setOnAction(e -> {
			hamming.setScene(tabla2Scene());
		});

		GridPane.setConstraints(Btabla2, 1, 4);
		GridPane.setHalignment(Btabla2, HPos.RIGHT);

		// Add to the grid
		grid.getChildren().addAll(img1, img2, info, Btabla1, Btabla2);

		inicio = new Scene(grid, 630, 450);
		return inicio;
	}

	private Scene tabla1Scene() throws FileNotFoundException {
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setPadding(new Insets(10, 10, 10, 10));

		Label nombre = new Label("Tabla 1");
		GridPane.setConstraints(nombre, 0, 0, 1, 1);
		GridPane.setHalignment(nombre, HPos.CENTER);
		Label p1 = new Label(" P1 ");
		GridPane.setConstraints(p1, 1, 0, 1, 1);
		GridPane.setHalignment(p1, HPos.CENTER);
		Label p2 = new Label(" P2 ");
		GridPane.setConstraints(p2, 2, 0, 1, 1);
		GridPane.setHalignment(p2, HPos.CENTER);
		Label d1 = new Label(" D1 ");
		GridPane.setConstraints(d1, 3, 0, 1, 1);
		GridPane.setHalignment(d1, HPos.CENTER);
		Label p3 = new Label(" P3 ");
		GridPane.setConstraints(p3, 4, 0, 1, 1);
		GridPane.setHalignment(p3, HPos.CENTER);
		Label d2 = new Label(" D2 ");
		GridPane.setConstraints(d2, 5, 0, 1, 1);
		GridPane.setHalignment(d2, HPos.CENTER);
		Label d3 = new Label(" D3 ");
		GridPane.setConstraints(d3, 6, 0, 1, 1);
		GridPane.setHalignment(d3, HPos.CENTER);
		Label d4 = new Label(" D4 ");
		GridPane.setConstraints(d4, 7, 0, 1, 1);
		GridPane.setHalignment(d4, HPos.CENTER);
		Label p4 = new Label(" P4 ");
		GridPane.setConstraints(p4, 8, 0, 1, 1);
		GridPane.setHalignment(p4, HPos.CENTER);
		Label d5 = new Label(" D5 ");
		GridPane.setConstraints(d5, 9, 0, 1, 1);
		GridPane.setHalignment(d5, HPos.CENTER);
		Label d6 = new Label(" D6 ");
		GridPane.setConstraints(d6, 10, 0, 1, 1);
		GridPane.setHalignment(d6, HPos.CENTER);
		Label d7 = new Label(" D7 ");
		GridPane.setConstraints(d7, 11, 0, 1, 1);
		GridPane.setHalignment(d7, HPos.CENTER);
		Label d8 = new Label(" D8 ");
		GridPane.setConstraints(d8, 12, 0, 1, 1);
		GridPane.setHalignment(d8, HPos.CENTER);
		Label d9 = new Label(" D9 ");
		GridPane.setConstraints(d9, 13, 0, 1, 1);
		GridPane.setHalignment(d9, HPos.CENTER);
		Label d10 = new Label(" D10 ");
		GridPane.setConstraints(d10, 14, 0, 1, 1);
		GridPane.setHalignment(d10, HPos.CENTER);
		Label d11 = new Label(" D11 ");
		GridPane.setConstraints(d11, 15, 0, 1, 1);
		GridPane.setHalignment(d11, HPos.CENTER);
		Label p5 = new Label(" P5 ");
		GridPane.setConstraints(p5, 16, 0, 1, 1);
		GridPane.setHalignment(p5, HPos.CENTER);
		Label d12 = new Label(" D12 ");
		GridPane.setConstraints(d12, 17, 0, 1, 1);
		GridPane.setHalignment(d12, HPos.CENTER);

		// --------------------------------------------------
		Label P1_PDSP = new Label("");
		Label P1_P1 = new Label("");
		Label P1_P2 = new Label("");
		Label P1_P3 = new Label("");
		Label P1_P4 = new Label("");
		Label P1_P5 = new Label("");
		Label P1_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P1_PDSP, 1, 1, 1, 1);
		GridPane.setHalignment(P1_PDSP, HPos.CENTER);
		GridPane.setConstraints(P1_P1, 1, 2, 1, 1);
		GridPane.setHalignment(P1_P1, HPos.CENTER);
		GridPane.setConstraints(P1_P2, 1, 3, 1, 1);
		GridPane.setHalignment(P1_P2, HPos.CENTER);
		GridPane.setConstraints(P1_P3, 1, 4, 1, 1);
		GridPane.setHalignment(P1_P3, HPos.CENTER);
		GridPane.setConstraints(P1_P4, 1, 5, 1, 1);
		GridPane.setHalignment(P1_P4, HPos.CENTER);
		GridPane.setConstraints(P1_P5, 1, 6, 1, 1);
		GridPane.setHalignment(P1_P5, HPos.CENTER);
		GridPane.setConstraints(P1_PDCP, 1, 7, 1, 1);
		GridPane.setHalignment(P1_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label P2_PDSP = new Label("");
		Label P2_P1 = new Label("");
		Label P2_P2 = new Label("");
		Label P2_P3 = new Label("");
		Label P2_P4 = new Label("");
		Label P2_P5 = new Label("");
		Label P2_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P2_PDSP, 2, 1, 1, 1);
		GridPane.setHalignment(P2_PDSP, HPos.CENTER);
		GridPane.setConstraints(P2_P1, 2, 2, 1, 1);
		GridPane.setHalignment(P2_P1, HPos.CENTER);
		GridPane.setConstraints(P2_P2, 2, 3, 1, 1);
		GridPane.setHalignment(P2_P2, HPos.CENTER);
		GridPane.setConstraints(P2_P3, 2, 4, 1, 1);
		GridPane.setHalignment(P2_P3, HPos.CENTER);
		GridPane.setConstraints(P2_P4, 2, 5, 1, 1);
		GridPane.setHalignment(P2_P4, HPos.CENTER);
		GridPane.setConstraints(P2_P5, 2, 6, 1, 1);
		GridPane.setHalignment(P2_P5, HPos.CENTER);
		GridPane.setConstraints(P2_PDCP, 2, 7, 1, 1);
		GridPane.setHalignment(P2_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D1_PDSP = new Label("");
		Label D1_P1 = new Label("");
		Label D1_P2 = new Label("");
		Label D1_P3 = new Label("");
		Label D1_P4 = new Label("");
		Label D1_P5 = new Label("");
		Label D1_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D1_PDSP, 3, 1, 1, 1);
		GridPane.setHalignment(D1_PDSP, HPos.CENTER);
		GridPane.setConstraints(D1_P1, 3, 2, 1, 1);
		GridPane.setHalignment(D1_P1, HPos.CENTER);
		GridPane.setConstraints(D1_P2, 3, 3, 1, 1);
		GridPane.setHalignment(D1_P2, HPos.CENTER);
		GridPane.setConstraints(D1_P3, 3, 4, 1, 1);
		GridPane.setHalignment(D1_P3, HPos.CENTER);
		GridPane.setConstraints(D1_P4, 3, 5, 1, 1);
		GridPane.setHalignment(D1_P4, HPos.CENTER);
		GridPane.setConstraints(D1_P5, 3, 6, 1, 1);
		GridPane.setHalignment(D1_P5, HPos.CENTER);
		GridPane.setConstraints(D1_PDCP, 3, 7, 1, 1);
		GridPane.setHalignment(D1_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label P3_PDSP = new Label("");
		Label P3_P1 = new Label("");
		Label P3_P2 = new Label("");
		Label P3_P3 = new Label("");
		Label P3_P4 = new Label("");
		Label P3_P5 = new Label("");
		Label P3_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P3_PDSP, 4, 1, 1, 1);
		GridPane.setHalignment(P3_PDSP, HPos.CENTER);
		GridPane.setConstraints(P3_P1, 4, 2, 1, 1);
		GridPane.setHalignment(P3_P1, HPos.CENTER);
		GridPane.setConstraints(P3_P2, 4, 3, 1, 1);
		GridPane.setHalignment(P3_P2, HPos.CENTER);
		GridPane.setConstraints(P3_P3, 4, 4, 1, 1);
		GridPane.setHalignment(P3_P3, HPos.CENTER);
		GridPane.setConstraints(P3_P4, 4, 5, 1, 1);
		GridPane.setHalignment(P3_P4, HPos.CENTER);
		GridPane.setConstraints(P3_P5, 4, 6, 1, 1);
		GridPane.setHalignment(P3_P5, HPos.CENTER);
		GridPane.setConstraints(P3_PDCP, 4, 7, 1, 1);
		GridPane.setHalignment(P3_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D2_PDSP = new Label("");
		Label D2_P1 = new Label("");
		Label D2_P2 = new Label("");
		Label D2_P3 = new Label("");
		Label D2_P4 = new Label("");
		Label D2_P5 = new Label("");
		Label D2_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D2_PDSP, 5, 1, 1, 1);
		GridPane.setHalignment(D2_PDSP, HPos.CENTER);
		GridPane.setConstraints(D2_P1, 5, 2, 1, 1);
		GridPane.setHalignment(D2_P1, HPos.CENTER);
		GridPane.setConstraints(D2_P2, 5, 3, 1, 1);
		GridPane.setHalignment(D2_P2, HPos.CENTER);
		GridPane.setConstraints(D2_P3, 5, 4, 1, 1);
		GridPane.setHalignment(D2_P3, HPos.CENTER);
		GridPane.setConstraints(D2_P4, 5, 5, 1, 1);
		GridPane.setHalignment(D2_P4, HPos.CENTER);
		GridPane.setConstraints(D2_P5, 5, 6, 1, 1);
		GridPane.setHalignment(D2_P5, HPos.CENTER);
		GridPane.setConstraints(D2_PDCP, 5, 7, 1, 1);
		GridPane.setHalignment(D2_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D3_PDSP = new Label("");
		Label D3_P1 = new Label("");
		Label D3_P2 = new Label("");
		Label D3_P3 = new Label("");
		Label D3_P4 = new Label("");
		Label D3_P5 = new Label("");
		Label D3_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D3_PDSP, 6, 1, 1, 1);
		GridPane.setHalignment(D3_PDSP, HPos.CENTER);
		GridPane.setConstraints(D3_P1, 6, 2, 1, 1);
		GridPane.setHalignment(D3_P1, HPos.CENTER);
		GridPane.setConstraints(D3_P2, 6, 3, 1, 1);
		GridPane.setHalignment(D3_P2, HPos.CENTER);
		GridPane.setConstraints(D3_P3, 6, 4, 1, 1);
		GridPane.setHalignment(D3_P3, HPos.CENTER);
		GridPane.setConstraints(D3_P4, 6, 5, 1, 1);
		GridPane.setHalignment(D3_P4, HPos.CENTER);
		GridPane.setConstraints(D3_P5, 6, 6, 1, 1);
		GridPane.setHalignment(D3_P5, HPos.CENTER);
		GridPane.setConstraints(D3_PDCP, 6, 7, 1, 1);
		GridPane.setHalignment(D3_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D4_PDSP = new Label("");
		Label D4_P1 = new Label("");
		Label D4_P2 = new Label("");
		Label D4_P3 = new Label("");
		Label D4_P4 = new Label("");
		Label D4_P5 = new Label("");
		Label D4_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D4_PDSP, 7, 1, 1, 1);
		GridPane.setHalignment(D4_PDSP, HPos.CENTER);
		GridPane.setConstraints(D4_P1, 7, 2, 1, 1);
		GridPane.setHalignment(D4_P1, HPos.CENTER);
		GridPane.setConstraints(D4_P2, 7, 3, 1, 1);
		GridPane.setHalignment(D4_P2, HPos.CENTER);
		GridPane.setConstraints(D4_P3, 7, 4, 1, 1);
		GridPane.setHalignment(D4_P3, HPos.CENTER);
		GridPane.setConstraints(D4_P4, 7, 5, 1, 1);
		GridPane.setHalignment(D4_P4, HPos.CENTER);
		GridPane.setConstraints(D4_P5, 7, 6, 1, 1);
		GridPane.setHalignment(D4_P5, HPos.CENTER);
		GridPane.setConstraints(D4_PDCP, 7, 7, 1, 1);
		GridPane.setHalignment(D4_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label P4_PDSP = new Label("");
		Label P4_P1 = new Label("");
		Label P4_P2 = new Label("");
		Label P4_P3 = new Label("");
		Label P4_P4 = new Label("");
		Label P4_P5 = new Label("");
		Label P4_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P4_PDSP, 8, 1, 1, 1);
		GridPane.setHalignment(P4_PDSP, HPos.CENTER);
		GridPane.setConstraints(P4_P1, 8, 2, 1, 1);
		GridPane.setHalignment(P4_P1, HPos.CENTER);
		GridPane.setConstraints(P4_P2, 8, 3, 1, 1);
		GridPane.setHalignment(P4_P2, HPos.CENTER);
		GridPane.setConstraints(P4_P3, 8, 4, 1, 1);
		GridPane.setHalignment(P4_P3, HPos.CENTER);
		GridPane.setConstraints(P4_P4, 8, 5, 1, 1);
		GridPane.setHalignment(P4_P4, HPos.CENTER);
		GridPane.setConstraints(P4_P5, 8, 6, 1, 1);
		GridPane.setHalignment(P4_P5, HPos.CENTER);
		GridPane.setConstraints(P4_PDCP, 8, 7, 1, 1);
		GridPane.setHalignment(P4_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D5_PDSP = new Label("");
		Label D5_P1 = new Label("");
		Label D5_P2 = new Label("");
		Label D5_P3 = new Label("");
		Label D5_P4 = new Label("");
		Label D5_P5 = new Label("");
		Label D5_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D5_PDSP, 9, 1, 1, 1);
		GridPane.setHalignment(D5_PDSP, HPos.CENTER);
		GridPane.setConstraints(D5_P1, 9, 2, 1, 1);
		GridPane.setHalignment(D5_P1, HPos.CENTER);
		GridPane.setConstraints(D5_P2, 9, 3, 1, 1);
		GridPane.setHalignment(D5_P2, HPos.CENTER);
		GridPane.setConstraints(D5_P3, 9, 4, 1, 1);
		GridPane.setHalignment(D5_P3, HPos.CENTER);
		GridPane.setConstraints(D5_P4, 9, 5, 1, 1);
		GridPane.setHalignment(D5_P4, HPos.CENTER);
		GridPane.setConstraints(D5_P5, 9, 6, 1, 1);
		GridPane.setHalignment(D5_P5, HPos.CENTER);
		GridPane.setConstraints(D5_PDCP, 9, 7, 1, 1);
		GridPane.setHalignment(D5_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D6_PDSP = new Label("");
		Label D6_P1 = new Label("");
		Label D6_P2 = new Label("");
		Label D6_P3 = new Label("");
		Label D6_P4 = new Label("");
		Label D6_P5 = new Label("");
		Label D6_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D6_PDSP, 10, 1, 1, 1);
		GridPane.setHalignment(D6_PDSP, HPos.CENTER);
		GridPane.setConstraints(D6_P1, 10, 2, 1, 1);
		GridPane.setHalignment(D6_P1, HPos.CENTER);
		GridPane.setConstraints(D6_P2, 10, 3, 1, 1);
		GridPane.setHalignment(D6_P2, HPos.CENTER);
		GridPane.setConstraints(D6_P3, 10, 4, 1, 1);
		GridPane.setHalignment(D6_P3, HPos.CENTER);
		GridPane.setConstraints(D6_P4, 10, 5, 1, 1);
		GridPane.setHalignment(D6_P4, HPos.CENTER);
		GridPane.setConstraints(D6_P5, 10, 6, 1, 1);
		GridPane.setHalignment(D6_P5, HPos.CENTER);
		GridPane.setConstraints(D6_PDCP, 10, 7, 1, 1);
		GridPane.setHalignment(D6_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D7_PDSP = new Label("");
		Label D7_P1 = new Label("");
		Label D7_P2 = new Label("");
		Label D7_P3 = new Label("");
		Label D7_P4 = new Label("");
		Label D7_P5 = new Label("");
		Label D7_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D7_PDSP, 11, 1, 1, 1);
		GridPane.setHalignment(D7_PDSP, HPos.CENTER);
		GridPane.setConstraints(D7_P1, 11, 2, 1, 1);
		GridPane.setHalignment(D7_P1, HPos.CENTER);
		GridPane.setConstraints(D7_P2, 11, 3, 1, 1);
		GridPane.setHalignment(D7_P2, HPos.CENTER);
		GridPane.setConstraints(D7_P3, 11, 4, 1, 1);
		GridPane.setHalignment(D7_P3, HPos.CENTER);
		GridPane.setConstraints(D7_P4, 11, 5, 1, 1);
		GridPane.setHalignment(D7_P4, HPos.CENTER);
		GridPane.setConstraints(D7_P5, 11, 6, 1, 1);
		GridPane.setHalignment(D7_P5, HPos.CENTER);
		GridPane.setConstraints(D7_PDCP, 11, 7, 1, 1);
		GridPane.setHalignment(D7_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D8_PDSP = new Label("");
		Label D8_P1 = new Label("");
		Label D8_P2 = new Label("");
		Label D8_P3 = new Label("");
		Label D8_P4 = new Label("");
		Label D8_P5 = new Label("");
		Label D8_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D8_PDSP, 12, 1, 1, 1);
		GridPane.setHalignment(D8_PDSP, HPos.CENTER);
		GridPane.setConstraints(D8_P1, 12, 2, 1, 1);
		GridPane.setHalignment(D8_P1, HPos.CENTER);
		GridPane.setConstraints(D8_P2, 12, 3, 1, 1);
		GridPane.setHalignment(D8_P2, HPos.CENTER);
		GridPane.setConstraints(D8_P3, 12, 4, 1, 1);
		GridPane.setHalignment(D8_P3, HPos.CENTER);
		GridPane.setConstraints(D8_P4, 12, 5, 1, 1);
		GridPane.setHalignment(D8_P4, HPos.CENTER);
		GridPane.setConstraints(D8_P5, 12, 6, 1, 1);
		GridPane.setHalignment(D8_P5, HPos.CENTER);
		GridPane.setConstraints(D8_PDCP, 12, 7, 1, 1);
		GridPane.setHalignment(D8_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D9_PDSP = new Label("");
		Label D9_P1 = new Label("");
		Label D9_P2 = new Label("");
		Label D9_P3 = new Label("");
		Label D9_P4 = new Label("");
		Label D9_P5 = new Label("");
		Label D9_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D9_PDSP, 13, 1, 1, 1);
		GridPane.setHalignment(D9_PDSP, HPos.CENTER);
		GridPane.setConstraints(D9_P1, 13, 2, 1, 1);
		GridPane.setHalignment(D9_P1, HPos.CENTER);
		GridPane.setConstraints(D9_P2, 13, 3, 1, 1);
		GridPane.setHalignment(D9_P2, HPos.CENTER);
		GridPane.setConstraints(D9_P3, 13, 4, 1, 1);
		GridPane.setHalignment(D9_P3, HPos.CENTER);
		GridPane.setConstraints(D9_P4, 13, 5, 1, 1);
		GridPane.setHalignment(D9_P4, HPos.CENTER);
		GridPane.setConstraints(D9_P5, 13, 6, 1, 1);
		GridPane.setHalignment(D9_P5, HPos.CENTER);
		GridPane.setConstraints(D9_PDCP, 13, 7, 1, 1);
		GridPane.setHalignment(D9_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D10_PDSP = new Label("");
		Label D10_P1 = new Label("");
		Label D10_P2 = new Label("");
		Label D10_P3 = new Label("");
		Label D10_P4 = new Label("");
		Label D10_P5 = new Label("");
		Label D10_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D10_PDSP, 14, 1, 1, 1);
		GridPane.setHalignment(D10_PDSP, HPos.CENTER);
		GridPane.setConstraints(D10_P1, 14, 2, 1, 1);
		GridPane.setHalignment(D10_P1, HPos.CENTER);
		GridPane.setConstraints(D10_P2, 14, 3, 1, 1);
		GridPane.setHalignment(D10_P2, HPos.CENTER);
		GridPane.setConstraints(D10_P3, 14, 4, 1, 1);
		GridPane.setHalignment(D10_P3, HPos.CENTER);
		GridPane.setConstraints(D10_P4, 14, 5, 1, 1);
		GridPane.setHalignment(D10_P4, HPos.CENTER);
		GridPane.setConstraints(D10_P5, 14, 6, 1, 1);
		GridPane.setHalignment(D10_P5, HPos.CENTER);
		GridPane.setConstraints(D10_PDCP, 14, 7, 1, 1);
		GridPane.setHalignment(D10_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D11_PDSP = new Label("");
		Label D11_P1 = new Label("");
		Label D11_P2 = new Label("");
		Label D11_P3 = new Label("");
		Label D11_P4 = new Label("");
		Label D11_P5 = new Label("");
		Label D11_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D11_PDSP, 15, 1, 1, 1);
		GridPane.setHalignment(D11_PDSP, HPos.CENTER);
		GridPane.setConstraints(D11_P1, 15, 2, 1, 1);
		GridPane.setHalignment(D11_P1, HPos.CENTER);
		GridPane.setConstraints(D11_P2, 15, 3, 1, 1);
		GridPane.setHalignment(D11_P2, HPos.CENTER);
		GridPane.setConstraints(D11_P3, 15, 4, 1, 1);
		GridPane.setHalignment(D11_P3, HPos.CENTER);
		GridPane.setConstraints(D11_P4, 15, 5, 1, 1);
		GridPane.setHalignment(D11_P4, HPos.CENTER);
		GridPane.setConstraints(D11_P5, 15, 6, 1, 1);
		GridPane.setHalignment(D11_P5, HPos.CENTER);
		GridPane.setConstraints(D11_PDCP, 15, 7, 1, 1);
		GridPane.setHalignment(D11_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label P5_PDSP = new Label("");
		Label P5_P1 = new Label("");
		Label P5_P2 = new Label("");
		Label P5_P3 = new Label("");
		Label P5_P4 = new Label("");
		Label P5_P5 = new Label("");
		Label P5_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P5_PDSP, 16, 1, 1, 1);
		GridPane.setHalignment(P5_PDSP, HPos.CENTER);
		GridPane.setConstraints(P5_P1, 16, 2, 1, 1);
		GridPane.setHalignment(P5_P1, HPos.CENTER);
		GridPane.setConstraints(P5_P2, 16, 3, 1, 1);
		GridPane.setHalignment(P5_P2, HPos.CENTER);
		GridPane.setConstraints(P5_P3, 16, 4, 1, 1);
		GridPane.setHalignment(P5_P3, HPos.CENTER);
		GridPane.setConstraints(P5_P4, 16, 5, 1, 1);
		GridPane.setHalignment(P5_P4, HPos.CENTER);
		GridPane.setConstraints(P5_P5, 16, 6, 1, 1);
		GridPane.setHalignment(P5_P5, HPos.CENTER);
		GridPane.setConstraints(P5_PDCP, 16, 7, 1, 1);
		GridPane.setHalignment(P5_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D12_PDSP = new Label("");
		Label D12_P1 = new Label("");
		Label D12_P2 = new Label("");
		Label D12_P3 = new Label("");
		Label D12_P4 = new Label("");
		Label D12_P5 = new Label("");
		Label D12_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D12_PDSP, 17, 1, 1, 1);
		GridPane.setHalignment(D12_PDSP, HPos.CENTER);
		GridPane.setConstraints(D12_P1, 17, 2, 1, 1);
		GridPane.setHalignment(D12_P1, HPos.CENTER);
		GridPane.setConstraints(D12_P2, 17, 3, 1, 1);
		GridPane.setHalignment(D12_P2, HPos.CENTER);
		GridPane.setConstraints(D12_P3, 17, 4, 1, 1);
		GridPane.setHalignment(D12_P3, HPos.CENTER);
		GridPane.setConstraints(D12_P4, 17, 5, 1, 1);
		GridPane.setHalignment(D12_P4, HPos.CENTER);
		GridPane.setConstraints(D12_P5, 17, 6, 1, 1);
		GridPane.setHalignment(D12_P5, HPos.CENTER);
		GridPane.setConstraints(D12_PDCP, 17, 7, 1, 1);
		GridPane.setHalignment(D12_PDCP, HPos.CENTER);
		// aqui termina
		// --------------------------------------------------

		Label palabraDeDatosSin = new Label(" Palabra de datos(sin paridad) ");
		GridPane.setConstraints(palabraDeDatosSin, 0, 1, 1, 1);
		GridPane.setHalignment(palabraDeDatosSin, HPos.CENTER);
		Label pp1 = new Label(" P1 ");
		GridPane.setConstraints(pp1, 0, 2, 1, 1);
		GridPane.setHalignment(pp1, HPos.CENTER);
		Label pp2 = new Label(" P2 ");
		GridPane.setConstraints(pp2, 0, 3, 1, 1);
		GridPane.setHalignment(pp2, HPos.CENTER);
		Label pp3 = new Label(" P3 ");
		GridPane.setConstraints(pp3, 0, 4, 1, 1);
		GridPane.setHalignment(pp3, HPos.CENTER);
		Label pp4 = new Label(" P4 ");
		GridPane.setConstraints(pp4, 0, 5, 1, 1);
		GridPane.setHalignment(pp4, HPos.CENTER);
		Label pp5 = new Label(" P5 ");
		GridPane.setConstraints(pp5, 0, 6, 1, 1);
		GridPane.setHalignment(pp5, HPos.CENTER);
		Label palabraDeDatosCon = new Label(" Palabra de datos(con paridad) ");
		GridPane.setConstraints(palabraDeDatosCon, 0, 7, 1, 1);
		GridPane.setHalignment(palabraDeDatosCon, HPos.CENTER);
		Label padding = new Label("  ");
		GridPane.setConstraints(padding, 0, 8, 1, 1);

		ToggleGroup group = new ToggleGroup();
		RadioButton bPar = new RadioButton("Par");
		bPar.setToggleGroup(group);
		bPar.setUserData(true);
		bPar.setSelected(true);
		GridPane.setConstraints(bPar, 0, 9, 1, 1);
		RadioButton bImpar = new RadioButton("Impar");
		bImpar.setToggleGroup(group);
		bImpar.setUserData(false);
		GridPane.setConstraints(bImpar, 0, 10, 1, 1);

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

				if (group.getSelectedToggle() != null) {
					paridad = (boolean) group.getSelectedToggle().getUserData();
					System.out.println(paridad);
					// Do something here with the userData of newly selected radioButton

				}

			}
		});

		Button regresar = new Button("Regresar");
		regresar.setOnAction(e -> {
			try {
				hamming.setScene(inicioScene());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GridPane.setConstraints(regresar, 14, 10, 3, 1);
		GridPane.setHalignment(regresar, HPos.LEFT);

		TextField entradaHex = new TextField();
		GridPane.setConstraints(entradaHex, 6, 10, 3, 1);

		Button obtener = new Button("Obtener");
		obtener.setOnAction(e -> {
			ConvertidorDeHex convertidor = new ConvertidorDeHex();

			if (!convertidor.revisarHex(entradaHex.getText())) {
				System.out.println("Error esto no es Hexadecimal");
			} else {
				List<List<String>> bitsHamming = new ArrayList<List<String>>();
				Hamming solucion = new Hamming();
				bin = convertidor.hexABin(entradaHex.getText());
				bitsHamming = solucion.start(bin, paridad);

				// -------------------------------------------------------------------
				List<String> lPalabraDeDatosSinParidad = new ArrayList<String>();
				lPalabraDeDatosSinParidad = bitsHamming.get(0);
				P1_PDSP.setText(lPalabraDeDatosSinParidad.get(0));
				P2_PDSP.setText(lPalabraDeDatosSinParidad.get(1));
				D1_PDSP.setText(lPalabraDeDatosSinParidad.get(2));
				P3_PDSP.setText(lPalabraDeDatosSinParidad.get(3));
				D2_PDSP.setText(lPalabraDeDatosSinParidad.get(4));
				D3_PDSP.setText(lPalabraDeDatosSinParidad.get(5));
				D4_PDSP.setText(lPalabraDeDatosSinParidad.get(6));
				P4_PDSP.setText(lPalabraDeDatosSinParidad.get(7));
				D5_PDSP.setText(lPalabraDeDatosSinParidad.get(8));
				D6_PDSP.setText(lPalabraDeDatosSinParidad.get(9));
				D7_PDSP.setText(lPalabraDeDatosSinParidad.get(10));
				D8_PDSP.setText(lPalabraDeDatosSinParidad.get(11));
				D9_PDSP.setText(lPalabraDeDatosSinParidad.get(12));
				D10_PDSP.setText(lPalabraDeDatosSinParidad.get(13));
				D11_PDSP.setText(lPalabraDeDatosSinParidad.get(14));
				P5_PDSP.setText(lPalabraDeDatosSinParidad.get(15));
				D12_PDSP.setText(lPalabraDeDatosSinParidad.get(16));

				// -------------------------------------------------------------------
				List<String> lP1 = new ArrayList<String>();
				lP1 = bitsHamming.get(1);

				P1_P1.setText(lP1.get(0));
				P2_P1.setText(lP1.get(1));
				D1_P1.setText(lP1.get(2));
				P3_P1.setText(lP1.get(3));
				D2_P1.setText(lP1.get(4));
				D3_P1.setText(lP1.get(5));
				D4_P1.setText(lP1.get(6));
				P4_P1.setText(lP1.get(7));
				D5_P1.setText(lP1.get(8));
				D6_P1.setText(lP1.get(9));
				D7_P1.setText(lP1.get(10));
				D8_P1.setText(lP1.get(11));
				D9_P1.setText(lP1.get(12));
				D10_P1.setText(lP1.get(13));
				D11_P1.setText(lP1.get(14));
				P5_P1.setText(lP1.get(15));
				D12_P1.setText(lP1.get(16));

				// -------------------------------------------------------------------
				List<String> lP2 = new ArrayList<String>();
				lP2 = bitsHamming.get(2);

				P1_P2.setText(lP2.get(0));
				P2_P2.setText(lP2.get(1));
				D1_P2.setText(lP2.get(2));
				P3_P2.setText(lP2.get(3));
				D2_P2.setText(lP2.get(4));
				D3_P2.setText(lP2.get(5));
				D4_P2.setText(lP2.get(6));
				P4_P2.setText(lP2.get(7));
				D5_P2.setText(lP2.get(8));
				D6_P2.setText(lP2.get(9));
				D7_P2.setText(lP2.get(10));
				D8_P2.setText(lP2.get(11));
				D9_P2.setText(lP2.get(12));
				D10_P2.setText(lP2.get(13));
				D11_P2.setText(lP2.get(14));
				P5_P2.setText(lP2.get(15));
				D12_P2.setText(lP2.get(16));

				// -------------------------------------------------------------------
				List<String> lP3 = new ArrayList<String>();
				lP3 = bitsHamming.get(3);

				P1_P3.setText(lP3.get(0));
				P2_P3.setText(lP3.get(1));
				D1_P3.setText(lP3.get(2));
				P3_P3.setText(lP3.get(3));
				D2_P3.setText(lP3.get(4));
				D3_P3.setText(lP3.get(5));
				D4_P3.setText(lP3.get(6));
				P4_P3.setText(lP3.get(7));
				D5_P3.setText(lP3.get(8));
				D6_P3.setText(lP3.get(9));
				D7_P3.setText(lP3.get(10));
				D8_P3.setText(lP3.get(11));
				D9_P3.setText(lP3.get(12));
				D10_P3.setText(lP3.get(13));
				D11_P3.setText(lP3.get(14));
				P5_P3.setText(lP3.get(15));
				D12_P3.setText(lP3.get(16));

				// -------------------------------------------------------------------
				List<String> lP4 = new ArrayList<String>();
				lP4 = bitsHamming.get(4);

				P1_P4.setText(lP4.get(0));
				P2_P4.setText(lP4.get(1));
				D1_P4.setText(lP4.get(2));
				P3_P4.setText(lP4.get(3));
				D2_P4.setText(lP4.get(4));
				D3_P4.setText(lP4.get(5));
				D4_P4.setText(lP4.get(6));
				P4_P4.setText(lP4.get(7));
				D5_P4.setText(lP4.get(8));
				D6_P4.setText(lP4.get(9));
				D7_P4.setText(lP4.get(10));
				D8_P4.setText(lP4.get(11));
				D9_P4.setText(lP4.get(12));
				D10_P4.setText(lP4.get(13));
				D11_P4.setText(lP4.get(14));
				P5_P4.setText(lP4.get(15));
				D12_P4.setText(lP4.get(16));

				// -------------------------------------------------------------------
				List<String> lP5 = new ArrayList<String>();
				lP5 = bitsHamming.get(5);

				P1_P5.setText(lP5.get(0));
				P2_P5.setText(lP5.get(1));
				D1_P5.setText(lP5.get(2));
				P3_P5.setText(lP5.get(3));
				D2_P5.setText(lP5.get(4));
				D3_P5.setText(lP5.get(5));
				D4_P5.setText(lP5.get(6));
				P4_P5.setText(lP5.get(7));
				D5_P5.setText(lP5.get(8));
				D6_P5.setText(lP5.get(9));
				D7_P5.setText(lP5.get(10));
				D8_P5.setText(lP5.get(11));
				D9_P5.setText(lP5.get(12));
				D10_P5.setText(lP5.get(13));
				D11_P5.setText(lP5.get(14));
				P5_P5.setText(lP5.get(15));
				D12_P5.setText(lP5.get(16));

				// -------------------------------------------------------------------
				List<String> lPalabraDeDatosConParidad = new ArrayList<String>();
				lPalabraDeDatosConParidad = bitsHamming.get(6);

				P1_PDCP.setText(lPalabraDeDatosConParidad.get(0));
				P2_PDCP.setText(lPalabraDeDatosConParidad.get(1));
				D1_PDCP.setText(lPalabraDeDatosConParidad.get(2));
				P3_PDCP.setText(lPalabraDeDatosConParidad.get(3));
				D2_PDCP.setText(lPalabraDeDatosConParidad.get(4));
				D3_PDCP.setText(lPalabraDeDatosConParidad.get(5));
				D4_PDCP.setText(lPalabraDeDatosConParidad.get(6));
				P4_PDCP.setText(lPalabraDeDatosConParidad.get(7));
				D5_PDCP.setText(lPalabraDeDatosConParidad.get(8));
				D6_PDCP.setText(lPalabraDeDatosConParidad.get(9));
				D7_PDCP.setText(lPalabraDeDatosConParidad.get(10));
				D8_PDCP.setText(lPalabraDeDatosConParidad.get(11));
				D9_PDCP.setText(lPalabraDeDatosConParidad.get(12));
				D10_PDCP.setText(lPalabraDeDatosConParidad.get(13));
				D11_PDCP.setText(lPalabraDeDatosConParidad.get(14));
				P5_PDCP.setText(lPalabraDeDatosConParidad.get(15));
				D12_PDCP.setText(lPalabraDeDatosConParidad.get(16));

				final Stage dialog = new Stage();
				dialog.initModality(Modality.NONE);
				dialog.initOwner(hamming);
				VBox dialogVbox = new VBox(20);
				String resultadoBits = "";
				for (int i = 0; i < lPalabraDeDatosConParidad.size(); i++) {
					if (lPalabraDeDatosConParidad.get(i).equals("-")) {
					} else {
						resultadoBits += lPalabraDeDatosConParidad.get(i);
					}
				}
				System.out.println(resultadoBits);
				dialogVbox.getChildren().add(new Text(resultadoBits));
				Scene dialogScene = new Scene(dialogVbox, 300, 200);
				dialog.setScene(dialogScene);
				dialog.show();
			}
		});
		GridPane.setConstraints(obtener, 2, 10, 3, 1);
		GridPane.setHalignment(obtener, HPos.LEFT);

		grid.getChildren().addAll(nombre, p1, p2, d1, p3, d2, d3, d4, p4, d5, d6, d7, d8, d9, d10, d11, p5, d12,
				palabraDeDatosSin, pp1, pp2, pp3, pp4, pp5, palabraDeDatosCon, bPar, bImpar, regresar, obtener,
				entradaHex, P1_PDSP, P1_P1, P1_P2, P1_P3, P1_P4, P1_P5, P1_PDCP, P2_PDSP, P2_P1, P2_P2, P2_P3, P2_P4,
				P2_P5, P2_PDCP, P3_PDSP, P3_P1, P3_P2, P3_P3, P3_P4, P3_P5, P3_PDCP, P4_PDSP, P4_P1, P4_P2, P4_P3,
				P4_P4, P4_P5, P4_PDCP, P5_PDSP, P5_P1, P5_P2, P5_P3, P5_P4, P5_P5, P5_PDCP, D1_PDSP, D1_P1, D1_P2,
				D1_P3, D1_P4, D1_P5, D1_PDCP, D2_PDSP, D2_P1, D2_P2, D2_P3, D2_P4, D2_P5, D2_PDCP, D3_PDSP, D3_P1,
				D3_P2, D3_P3, D3_P4, D3_P5, D3_PDCP, D4_PDSP, D4_P1, D4_P2, D4_P3, D4_P4, D4_P5, D4_PDCP, D5_PDSP,
				D5_P1, D5_P2, D5_P3, D5_P4, D5_P5, D5_PDCP, D6_PDSP, D6_P1, D6_P2, D6_P3, D6_P4, D6_P5, D6_PDCP,
				D7_PDSP, D7_P1, D7_P2, D7_P3, D7_P4, D7_P5, D7_PDCP, D8_PDSP, D8_P1, D8_P2, D8_P3, D8_P4, D8_P5,
				D8_PDCP, D9_PDSP, D9_P1, D9_P2, D9_P3, D9_P4, D9_P5, D9_PDCP, D10_PDSP, D10_P1, D10_P2, D10_P3, D10_P4,
				D10_P5, D10_PDCP, D11_PDSP, D11_P1, D11_P2, D11_P3, D11_P4, D11_P5, D11_PDCP, D12_PDSP, D12_P1, D12_P2,
				D12_P3, D12_P4, D12_P5, D12_PDCP);
		tabla1 = new Scene(grid, 650, 200);
		return tabla1;

	};

	private Scene tabla2Scene() {
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setPadding(new Insets(10, 10, 10, 10));

		Label nombre = new Label("Tabla 2");
		GridPane.setConstraints(nombre, 0, 0, 1, 1);
		GridPane.setHalignment(nombre, HPos.CENTER);
		Label p1 = new Label(" P1 ");
		GridPane.setConstraints(p1, 1, 0, 1, 1);
		GridPane.setHalignment(p1, HPos.CENTER);
		Label p2 = new Label(" P2 ");
		GridPane.setConstraints(p2, 2, 0, 1, 1);
		GridPane.setHalignment(p2, HPos.CENTER);
		Label d1 = new Label(" D1 ");
		GridPane.setConstraints(d1, 3, 0, 1, 1);
		GridPane.setHalignment(d1, HPos.CENTER);
		Label p3 = new Label(" P3 ");
		GridPane.setConstraints(p3, 4, 0, 1, 1);
		GridPane.setHalignment(p3, HPos.CENTER);
		Label d2 = new Label(" D2 ");
		GridPane.setConstraints(d2, 5, 0, 1, 1);
		GridPane.setHalignment(d2, HPos.CENTER);
		Label d3 = new Label(" D3 ");
		GridPane.setConstraints(d3, 6, 0, 1, 1);
		GridPane.setHalignment(d3, HPos.CENTER);
		Label d4 = new Label(" D4 ");
		GridPane.setConstraints(d4, 7, 0, 1, 1);
		GridPane.setHalignment(d4, HPos.CENTER);
		Label p4 = new Label(" P4 ");
		GridPane.setConstraints(p4, 8, 0, 1, 1);
		GridPane.setHalignment(p4, HPos.CENTER);
		Label d5 = new Label(" D5 ");
		GridPane.setConstraints(d5, 9, 0, 1, 1);
		GridPane.setHalignment(d5, HPos.CENTER);
		Label d6 = new Label(" D6 ");
		GridPane.setConstraints(d6, 10, 0, 1, 1);
		GridPane.setHalignment(d6, HPos.CENTER);
		Label d7 = new Label(" D7 ");
		GridPane.setConstraints(d7, 11, 0, 1, 1);
		GridPane.setHalignment(d7, HPos.CENTER);
		Label d8 = new Label(" D8 ");
		GridPane.setConstraints(d8, 12, 0, 1, 1);
		GridPane.setHalignment(d8, HPos.CENTER);
		Label d9 = new Label(" D9 ");
		GridPane.setConstraints(d9, 13, 0, 1, 1);
		GridPane.setHalignment(d9, HPos.CENTER);
		Label d10 = new Label(" D10 ");
		GridPane.setConstraints(d10, 14, 0, 1, 1);
		GridPane.setHalignment(d10, HPos.CENTER);
		Label d11 = new Label(" D11 ");
		GridPane.setConstraints(d11, 15, 0, 1, 1);
		GridPane.setHalignment(d11, HPos.CENTER);
		Label p5 = new Label(" P5 ");
		GridPane.setConstraints(p5, 16, 0, 1, 1);
		GridPane.setHalignment(p5, HPos.CENTER);
		Label d12 = new Label(" D12 ");
		GridPane.setConstraints(d12, 17, 0, 1, 1);
		GridPane.setHalignment(d12, HPos.CENTER);
		Label pruebaDeParidad = new Label(" Prueba de paridad ");
		GridPane.setConstraints(pruebaDeParidad, 18, 0, 1, 1);
		GridPane.setHalignment(pruebaDeParidad, HPos.CENTER);
		Label bitDeParidad = new Label(" Bit de paridad ");
		GridPane.setConstraints(bitDeParidad, 19, 0, 1, 1);
		GridPane.setHalignment(bitDeParidad, HPos.CENTER);

		Label palabraDeDatosRecibida = new Label(" Palabra de datos recibida: ");
		GridPane.setConstraints(palabraDeDatosRecibida, 0, 1, 1, 1);
		GridPane.setHalignment(palabraDeDatosRecibida, HPos.CENTER);
		Label pp1 = new Label(" P1 ");
		GridPane.setConstraints(pp1, 0, 2, 1, 1);
		GridPane.setHalignment(pp1, HPos.CENTER);
		Label pp2 = new Label(" P2 ");
		GridPane.setConstraints(pp2, 0, 3, 1, 1);
		GridPane.setHalignment(pp2, HPos.CENTER);
		Label pp3 = new Label(" P3 ");
		GridPane.setConstraints(pp3, 0, 4, 1, 1);
		GridPane.setHalignment(pp3, HPos.CENTER);
		Label pp4 = new Label(" P4 ");
		GridPane.setConstraints(pp4, 0, 5, 1, 1);
		GridPane.setHalignment(pp4, HPos.CENTER);
		Label pp5 = new Label(" P5 ");
		GridPane.setConstraints(pp5, 0, 6, 1, 1);
		GridPane.setHalignment(pp5, HPos.CENTER);

		// --------------------------------------------------
		Label P1_PDSP = new Label("");
		Label P1_P1 = new Label("");
		Label P1_P2 = new Label("");
		Label P1_P3 = new Label("");
		Label P1_P4 = new Label("");
		Label P1_P5 = new Label("");

		// ------
		GridPane.setConstraints(P1_PDSP, 1, 1, 1, 1);
		GridPane.setHalignment(P1_PDSP, HPos.CENTER);
		GridPane.setConstraints(P1_P1, 1, 2, 1, 1);
		GridPane.setHalignment(P1_P1, HPos.CENTER);
		GridPane.setConstraints(P1_P2, 1, 3, 1, 1);
		GridPane.setHalignment(P1_P2, HPos.CENTER);
		GridPane.setConstraints(P1_P3, 1, 4, 1, 1);
		GridPane.setHalignment(P1_P3, HPos.CENTER);
		GridPane.setConstraints(P1_P4, 1, 5, 1, 1);
		GridPane.setHalignment(P1_P4, HPos.CENTER);
		GridPane.setConstraints(P1_P5, 1, 6, 1, 1);
		GridPane.setHalignment(P1_P5, HPos.CENTER);
		// --------------------------------------------------
		Label P2_PDSP = new Label("");
		Label P2_P1 = new Label("");
		Label P2_P2 = new Label("");
		Label P2_P3 = new Label("");
		Label P2_P4 = new Label("");
		Label P2_P5 = new Label("");
		Label P2_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P2_PDSP, 2, 1, 1, 1);
		GridPane.setHalignment(P2_PDSP, HPos.CENTER);
		GridPane.setConstraints(P2_P1, 2, 2, 1, 1);
		GridPane.setHalignment(P2_P1, HPos.CENTER);
		GridPane.setConstraints(P2_P2, 2, 3, 1, 1);
		GridPane.setHalignment(P2_P2, HPos.CENTER);
		GridPane.setConstraints(P2_P3, 2, 4, 1, 1);
		GridPane.setHalignment(P2_P3, HPos.CENTER);
		GridPane.setConstraints(P2_P4, 2, 5, 1, 1);
		GridPane.setHalignment(P2_P4, HPos.CENTER);
		GridPane.setConstraints(P2_P5, 2, 6, 1, 1);
		GridPane.setHalignment(P2_P5, HPos.CENTER);
		GridPane.setConstraints(P2_PDCP, 2, 7, 1, 1);
		GridPane.setHalignment(P2_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D1_PDSP = new Label("");
		Label D1_P1 = new Label("");
		Label D1_P2 = new Label("");
		Label D1_P3 = new Label("");
		Label D1_P4 = new Label("");
		Label D1_P5 = new Label("");
		Label D1_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D1_PDSP, 3, 1, 1, 1);
		GridPane.setHalignment(D1_PDSP, HPos.CENTER);
		GridPane.setConstraints(D1_P1, 3, 2, 1, 1);
		GridPane.setHalignment(D1_P1, HPos.CENTER);
		GridPane.setConstraints(D1_P2, 3, 3, 1, 1);
		GridPane.setHalignment(D1_P2, HPos.CENTER);
		GridPane.setConstraints(D1_P3, 3, 4, 1, 1);
		GridPane.setHalignment(D1_P3, HPos.CENTER);
		GridPane.setConstraints(D1_P4, 3, 5, 1, 1);
		GridPane.setHalignment(D1_P4, HPos.CENTER);
		GridPane.setConstraints(D1_P5, 3, 6, 1, 1);
		GridPane.setHalignment(D1_P5, HPos.CENTER);
		GridPane.setConstraints(D1_PDCP, 3, 7, 1, 1);
		GridPane.setHalignment(D1_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label P3_PDSP = new Label("");
		Label P3_P1 = new Label("");
		Label P3_P2 = new Label("");
		Label P3_P3 = new Label("");
		Label P3_P4 = new Label("");
		Label P3_P5 = new Label("");
		Label P3_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P3_PDSP, 4, 1, 1, 1);
		GridPane.setHalignment(P3_PDSP, HPos.CENTER);
		GridPane.setConstraints(P3_P1, 4, 2, 1, 1);
		GridPane.setHalignment(P3_P1, HPos.CENTER);
		GridPane.setConstraints(P3_P2, 4, 3, 1, 1);
		GridPane.setHalignment(P3_P2, HPos.CENTER);
		GridPane.setConstraints(P3_P3, 4, 4, 1, 1);
		GridPane.setHalignment(P3_P3, HPos.CENTER);
		GridPane.setConstraints(P3_P4, 4, 5, 1, 1);
		GridPane.setHalignment(P3_P4, HPos.CENTER);
		GridPane.setConstraints(P3_P5, 4, 6, 1, 1);
		GridPane.setHalignment(P3_P5, HPos.CENTER);
		GridPane.setConstraints(P3_PDCP, 4, 7, 1, 1);
		GridPane.setHalignment(P3_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D2_PDSP = new Label("");
		Label D2_P1 = new Label("");
		Label D2_P2 = new Label("");
		Label D2_P3 = new Label("");
		Label D2_P4 = new Label("");
		Label D2_P5 = new Label("");
		Label D2_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D2_PDSP, 5, 1, 1, 1);
		GridPane.setHalignment(D2_PDSP, HPos.CENTER);
		GridPane.setConstraints(D2_P1, 5, 2, 1, 1);
		GridPane.setHalignment(D2_P1, HPos.CENTER);
		GridPane.setConstraints(D2_P2, 5, 3, 1, 1);
		GridPane.setHalignment(D2_P2, HPos.CENTER);
		GridPane.setConstraints(D2_P3, 5, 4, 1, 1);
		GridPane.setHalignment(D2_P3, HPos.CENTER);
		GridPane.setConstraints(D2_P4, 5, 5, 1, 1);
		GridPane.setHalignment(D2_P4, HPos.CENTER);
		GridPane.setConstraints(D2_P5, 5, 6, 1, 1);
		GridPane.setHalignment(D2_P5, HPos.CENTER);
		GridPane.setConstraints(D2_PDCP, 5, 7, 1, 1);
		GridPane.setHalignment(D2_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D3_PDSP = new Label("");
		Label D3_P1 = new Label("");
		Label D3_P2 = new Label("");
		Label D3_P3 = new Label("");
		Label D3_P4 = new Label("");
		Label D3_P5 = new Label("");
		Label D3_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D3_PDSP, 6, 1, 1, 1);
		GridPane.setHalignment(D3_PDSP, HPos.CENTER);
		GridPane.setConstraints(D3_P1, 6, 2, 1, 1);
		GridPane.setHalignment(D3_P1, HPos.CENTER);
		GridPane.setConstraints(D3_P2, 6, 3, 1, 1);
		GridPane.setHalignment(D3_P2, HPos.CENTER);
		GridPane.setConstraints(D3_P3, 6, 4, 1, 1);
		GridPane.setHalignment(D3_P3, HPos.CENTER);
		GridPane.setConstraints(D3_P4, 6, 5, 1, 1);
		GridPane.setHalignment(D3_P4, HPos.CENTER);
		GridPane.setConstraints(D3_P5, 6, 6, 1, 1);
		GridPane.setHalignment(D3_P5, HPos.CENTER);
		GridPane.setConstraints(D3_PDCP, 6, 7, 1, 1);
		GridPane.setHalignment(D3_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D4_PDSP = new Label("");
		Label D4_P1 = new Label("");
		Label D4_P2 = new Label("");
		Label D4_P3 = new Label("");
		Label D4_P4 = new Label("");
		Label D4_P5 = new Label("");
		Label D4_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D4_PDSP, 7, 1, 1, 1);
		GridPane.setHalignment(D4_PDSP, HPos.CENTER);
		GridPane.setConstraints(D4_P1, 7, 2, 1, 1);
		GridPane.setHalignment(D4_P1, HPos.CENTER);
		GridPane.setConstraints(D4_P2, 7, 3, 1, 1);
		GridPane.setHalignment(D4_P2, HPos.CENTER);
		GridPane.setConstraints(D4_P3, 7, 4, 1, 1);
		GridPane.setHalignment(D4_P3, HPos.CENTER);
		GridPane.setConstraints(D4_P4, 7, 5, 1, 1);
		GridPane.setHalignment(D4_P4, HPos.CENTER);
		GridPane.setConstraints(D4_P5, 7, 6, 1, 1);
		GridPane.setHalignment(D4_P5, HPos.CENTER);
		GridPane.setConstraints(D4_PDCP, 7, 7, 1, 1);
		GridPane.setHalignment(D4_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label P4_PDSP = new Label("");
		Label P4_P1 = new Label("");
		Label P4_P2 = new Label("");
		Label P4_P3 = new Label("");
		Label P4_P4 = new Label("");
		Label P4_P5 = new Label("");
		Label P4_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P4_PDSP, 8, 1, 1, 1);
		GridPane.setHalignment(P4_PDSP, HPos.CENTER);
		GridPane.setConstraints(P4_P1, 8, 2, 1, 1);
		GridPane.setHalignment(P4_P1, HPos.CENTER);
		GridPane.setConstraints(P4_P2, 8, 3, 1, 1);
		GridPane.setHalignment(P4_P2, HPos.CENTER);
		GridPane.setConstraints(P4_P3, 8, 4, 1, 1);
		GridPane.setHalignment(P4_P3, HPos.CENTER);
		GridPane.setConstraints(P4_P4, 8, 5, 1, 1);
		GridPane.setHalignment(P4_P4, HPos.CENTER);
		GridPane.setConstraints(P4_P5, 8, 6, 1, 1);
		GridPane.setHalignment(P4_P5, HPos.CENTER);
		GridPane.setConstraints(P4_PDCP, 8, 7, 1, 1);
		GridPane.setHalignment(P4_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D5_PDSP = new Label("");
		Label D5_P1 = new Label("");
		Label D5_P2 = new Label("");
		Label D5_P3 = new Label("");
		Label D5_P4 = new Label("");
		Label D5_P5 = new Label("");
		Label D5_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D5_PDSP, 9, 1, 1, 1);
		GridPane.setHalignment(D5_PDSP, HPos.CENTER);
		GridPane.setConstraints(D5_P1, 9, 2, 1, 1);
		GridPane.setHalignment(D5_P1, HPos.CENTER);
		GridPane.setConstraints(D5_P2, 9, 3, 1, 1);
		GridPane.setHalignment(D5_P2, HPos.CENTER);
		GridPane.setConstraints(D5_P3, 9, 4, 1, 1);
		GridPane.setHalignment(D5_P3, HPos.CENTER);
		GridPane.setConstraints(D5_P4, 9, 5, 1, 1);
		GridPane.setHalignment(D5_P4, HPos.CENTER);
		GridPane.setConstraints(D5_P5, 9, 6, 1, 1);
		GridPane.setHalignment(D5_P5, HPos.CENTER);
		GridPane.setConstraints(D5_PDCP, 9, 7, 1, 1);
		GridPane.setHalignment(D5_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D6_PDSP = new Label("");
		Label D6_P1 = new Label("");
		Label D6_P2 = new Label("");
		Label D6_P3 = new Label("");
		Label D6_P4 = new Label("");
		Label D6_P5 = new Label("");
		Label D6_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D6_PDSP, 10, 1, 1, 1);
		GridPane.setHalignment(D6_PDSP, HPos.CENTER);
		GridPane.setConstraints(D6_P1, 10, 2, 1, 1);
		GridPane.setHalignment(D6_P1, HPos.CENTER);
		GridPane.setConstraints(D6_P2, 10, 3, 1, 1);
		GridPane.setHalignment(D6_P2, HPos.CENTER);
		GridPane.setConstraints(D6_P3, 10, 4, 1, 1);
		GridPane.setHalignment(D6_P3, HPos.CENTER);
		GridPane.setConstraints(D6_P4, 10, 5, 1, 1);
		GridPane.setHalignment(D6_P4, HPos.CENTER);
		GridPane.setConstraints(D6_P5, 10, 6, 1, 1);
		GridPane.setHalignment(D6_P5, HPos.CENTER);
		GridPane.setConstraints(D6_PDCP, 10, 7, 1, 1);
		GridPane.setHalignment(D6_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D7_PDSP = new Label("");
		Label D7_P1 = new Label("");
		Label D7_P2 = new Label("");
		Label D7_P3 = new Label("");
		Label D7_P4 = new Label("");
		Label D7_P5 = new Label("");
		Label D7_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D7_PDSP, 11, 1, 1, 1);
		GridPane.setHalignment(D7_PDSP, HPos.CENTER);
		GridPane.setConstraints(D7_P1, 11, 2, 1, 1);
		GridPane.setHalignment(D7_P1, HPos.CENTER);
		GridPane.setConstraints(D7_P2, 11, 3, 1, 1);
		GridPane.setHalignment(D7_P2, HPos.CENTER);
		GridPane.setConstraints(D7_P3, 11, 4, 1, 1);
		GridPane.setHalignment(D7_P3, HPos.CENTER);
		GridPane.setConstraints(D7_P4, 11, 5, 1, 1);
		GridPane.setHalignment(D7_P4, HPos.CENTER);
		GridPane.setConstraints(D7_P5, 11, 6, 1, 1);
		GridPane.setHalignment(D7_P5, HPos.CENTER);
		GridPane.setConstraints(D7_PDCP, 11, 7, 1, 1);
		GridPane.setHalignment(D7_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D8_PDSP = new Label("");
		Label D8_P1 = new Label("");
		Label D8_P2 = new Label("");
		Label D8_P3 = new Label("");
		Label D8_P4 = new Label("");
		Label D8_P5 = new Label("");
		Label D8_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D8_PDSP, 12, 1, 1, 1);
		GridPane.setHalignment(D8_PDSP, HPos.CENTER);
		GridPane.setConstraints(D8_P1, 12, 2, 1, 1);
		GridPane.setHalignment(D8_P1, HPos.CENTER);
		GridPane.setConstraints(D8_P2, 12, 3, 1, 1);
		GridPane.setHalignment(D8_P2, HPos.CENTER);
		GridPane.setConstraints(D8_P3, 12, 4, 1, 1);
		GridPane.setHalignment(D8_P3, HPos.CENTER);
		GridPane.setConstraints(D8_P4, 12, 5, 1, 1);
		GridPane.setHalignment(D8_P4, HPos.CENTER);
		GridPane.setConstraints(D8_P5, 12, 6, 1, 1);
		GridPane.setHalignment(D8_P5, HPos.CENTER);
		GridPane.setConstraints(D8_PDCP, 12, 7, 1, 1);
		GridPane.setHalignment(D8_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D9_PDSP = new Label("");
		Label D9_P1 = new Label("");
		Label D9_P2 = new Label("");
		Label D9_P3 = new Label("");
		Label D9_P4 = new Label("");
		Label D9_P5 = new Label("");
		Label D9_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D9_PDSP, 13, 1, 1, 1);
		GridPane.setHalignment(D9_PDSP, HPos.CENTER);
		GridPane.setConstraints(D9_P1, 13, 2, 1, 1);
		GridPane.setHalignment(D9_P1, HPos.CENTER);
		GridPane.setConstraints(D9_P2, 13, 3, 1, 1);
		GridPane.setHalignment(D9_P2, HPos.CENTER);
		GridPane.setConstraints(D9_P3, 13, 4, 1, 1);
		GridPane.setHalignment(D9_P3, HPos.CENTER);
		GridPane.setConstraints(D9_P4, 13, 5, 1, 1);
		GridPane.setHalignment(D9_P4, HPos.CENTER);
		GridPane.setConstraints(D9_P5, 13, 6, 1, 1);
		GridPane.setHalignment(D9_P5, HPos.CENTER);
		GridPane.setConstraints(D9_PDCP, 13, 7, 1, 1);
		GridPane.setHalignment(D9_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D10_PDSP = new Label("");
		Label D10_P1 = new Label("");
		Label D10_P2 = new Label("");
		Label D10_P3 = new Label("");
		Label D10_P4 = new Label("");
		Label D10_P5 = new Label("");
		Label D10_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D10_PDSP, 14, 1, 1, 1);
		GridPane.setHalignment(D10_PDSP, HPos.CENTER);
		GridPane.setConstraints(D10_P1, 14, 2, 1, 1);
		GridPane.setHalignment(D10_P1, HPos.CENTER);
		GridPane.setConstraints(D10_P2, 14, 3, 1, 1);
		GridPane.setHalignment(D10_P2, HPos.CENTER);
		GridPane.setConstraints(D10_P3, 14, 4, 1, 1);
		GridPane.setHalignment(D10_P3, HPos.CENTER);
		GridPane.setConstraints(D10_P4, 14, 5, 1, 1);
		GridPane.setHalignment(D10_P4, HPos.CENTER);
		GridPane.setConstraints(D10_P5, 14, 6, 1, 1);
		GridPane.setHalignment(D10_P5, HPos.CENTER);
		GridPane.setConstraints(D10_PDCP, 14, 7, 1, 1);
		GridPane.setHalignment(D10_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D11_PDSP = new Label("");
		Label D11_P1 = new Label("");
		Label D11_P2 = new Label("");
		Label D11_P3 = new Label("");
		Label D11_P4 = new Label("");
		Label D11_P5 = new Label("");
		Label D11_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D11_PDSP, 15, 1, 1, 1);
		GridPane.setHalignment(D11_PDSP, HPos.CENTER);
		GridPane.setConstraints(D11_P1, 15, 2, 1, 1);
		GridPane.setHalignment(D11_P1, HPos.CENTER);
		GridPane.setConstraints(D11_P2, 15, 3, 1, 1);
		GridPane.setHalignment(D11_P2, HPos.CENTER);
		GridPane.setConstraints(D11_P3, 15, 4, 1, 1);
		GridPane.setHalignment(D11_P3, HPos.CENTER);
		GridPane.setConstraints(D11_P4, 15, 5, 1, 1);
		GridPane.setHalignment(D11_P4, HPos.CENTER);
		GridPane.setConstraints(D11_P5, 15, 6, 1, 1);
		GridPane.setHalignment(D11_P5, HPos.CENTER);
		GridPane.setConstraints(D11_PDCP, 15, 7, 1, 1);
		GridPane.setHalignment(D11_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label P5_PDSP = new Label("");
		Label P5_P1 = new Label("");
		Label P5_P2 = new Label("");
		Label P5_P3 = new Label("");
		Label P5_P4 = new Label("");
		Label P5_P5 = new Label("");
		Label P5_PDCP = new Label("");
		// ------
		GridPane.setConstraints(P5_PDSP, 16, 1, 1, 1);
		GridPane.setHalignment(P5_PDSP, HPos.CENTER);
		GridPane.setConstraints(P5_P1, 16, 2, 1, 1);
		GridPane.setHalignment(P5_P1, HPos.CENTER);
		GridPane.setConstraints(P5_P2, 16, 3, 1, 1);
		GridPane.setHalignment(P5_P2, HPos.CENTER);
		GridPane.setConstraints(P5_P3, 16, 4, 1, 1);
		GridPane.setHalignment(P5_P3, HPos.CENTER);
		GridPane.setConstraints(P5_P4, 16, 5, 1, 1);
		GridPane.setHalignment(P5_P4, HPos.CENTER);
		GridPane.setConstraints(P5_P5, 16, 6, 1, 1);
		GridPane.setHalignment(P5_P5, HPos.CENTER);
		GridPane.setConstraints(P5_PDCP, 16, 7, 1, 1);
		GridPane.setHalignment(P5_PDCP, HPos.CENTER);
		// --------------------------------------------------
		Label D12_PDSP = new Label("");
		Label D12_P1 = new Label("");
		Label D12_P2 = new Label("");
		Label D12_P3 = new Label("");
		Label D12_P4 = new Label("");
		Label D12_P5 = new Label("");
		Label D12_PDCP = new Label("");
		// ------
		GridPane.setConstraints(D12_PDSP, 17, 1, 1, 1);
		GridPane.setHalignment(D12_PDSP, HPos.CENTER);
		GridPane.setConstraints(D12_P1, 17, 2, 1, 1);
		GridPane.setHalignment(D12_P1, HPos.CENTER);
		GridPane.setConstraints(D12_P2, 17, 3, 1, 1);
		GridPane.setHalignment(D12_P2, HPos.CENTER);
		GridPane.setConstraints(D12_P3, 17, 4, 1, 1);
		GridPane.setHalignment(D12_P3, HPos.CENTER);
		GridPane.setConstraints(D12_P4, 17, 5, 1, 1);
		GridPane.setHalignment(D12_P4, HPos.CENTER);
		GridPane.setConstraints(D12_P5, 17, 6, 1, 1);
		GridPane.setHalignment(D12_P5, HPos.CENTER);
		GridPane.setConstraints(D12_PDCP, 17, 7, 1, 1);
		GridPane.setHalignment(D12_PDCP, HPos.CENTER);

		Label PdP_PDSP = new Label("");
		Label PdR_PDSP = new Label("");
		Label PdP_P1 = new Label("");
		Label PdR_P1 = new Label("");
		Label PdP_P2 = new Label("");
		Label PdR_P2 = new Label("");
		Label PdP_P3 = new Label("");
		Label PdR_P3 = new Label("");
		Label PdP_P4 = new Label("");
		Label PdR_P4 = new Label("");
		Label PdP_P5 = new Label("");
		Label PdR_P5 = new Label("");

		GridPane.setConstraints(PdP_PDSP, 18, 1, 1, 1);
		GridPane.setHalignment(PdP_PDSP, HPos.CENTER);
		GridPane.setConstraints(PdR_PDSP, 19, 1, 1, 1);
		GridPane.setHalignment(PdR_PDSP, HPos.CENTER);
		GridPane.setConstraints(PdP_P1, 18, 2, 1, 1);
		GridPane.setHalignment(PdP_P1, HPos.CENTER);
		GridPane.setConstraints(PdR_P1, 19, 2, 1, 1);
		GridPane.setHalignment(PdR_P1, HPos.CENTER);
		GridPane.setConstraints(PdP_P2, 18, 3, 1, 1);
		GridPane.setHalignment(PdP_P2, HPos.CENTER);
		GridPane.setConstraints(PdR_P2, 19, 3, 1, 1);
		GridPane.setHalignment(PdR_P2, HPos.CENTER);
		GridPane.setConstraints(PdP_P3, 18, 4, 1, 1);
		GridPane.setHalignment(PdP_P3, HPos.CENTER);
		GridPane.setConstraints(PdR_P3, 19, 4, 1, 1);
		GridPane.setHalignment(PdR_P3, HPos.CENTER);
		GridPane.setConstraints(PdP_P4, 18, 5, 1, 1);
		GridPane.setHalignment(PdP_P4, HPos.CENTER);
		GridPane.setConstraints(PdR_P4, 19, 5, 1, 1);
		GridPane.setHalignment(PdR_P4, HPos.CENTER);
		GridPane.setConstraints(PdP_P5, 18, 6, 1, 1);
		GridPane.setHalignment(PdP_P5, HPos.CENTER);
		GridPane.setConstraints(PdR_P5, 19, 6, 1, 1);
		GridPane.setHalignment(PdR_P5, HPos.CENTER);

		// --------------------------------------------------
		ToggleGroup group = new ToggleGroup();
		RadioButton bPar = new RadioButton("Par");
		bPar.setToggleGroup(group);
		bPar.setUserData(true);
		bPar.setSelected(true);
		GridPane.setConstraints(bPar, 0, 7, 1, 1);
		RadioButton bImpar = new RadioButton("Impar");
		bImpar.setToggleGroup(group);
		bImpar.setUserData(false);
		GridPane.setConstraints(bImpar, 0, 8, 1, 1);

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

				if (group.getSelectedToggle() != null) {
					paridad = (boolean) group.getSelectedToggle().getUserData();
					System.out.println(paridad);
					// Do something here with the userData of newly selected radioButton

				}

			}
		});

		// --
		Button regresar = new Button("Regresar");
		regresar.setOnAction(e -> {
			try {
				hamming.setScene(inicioScene());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GridPane.setConstraints(regresar, 19, 8, 3, 1);
		GridPane.setHalignment(regresar, HPos.CENTER);

		TextField entradaBin = new TextField();
		GridPane.setConstraints(entradaBin, 6, 8, 6, 1);

		Button obtener = new Button("Revisar");
		obtener.setOnAction(e -> {
			ConvertidorDeHex convertidor = new ConvertidorDeHex();

			if (!convertidor.revisarBin(entradaBin.getText())) {
				System.out.println("Error esto no es Binario");
			} else {
				List<List<String>> bitsHamming = new ArrayList<List<String>>();
				Hamming solucion = new Hamming();
				bin = entradaBin.getText();
				System.out.println("LLego aqui: " + bin);
				bitsHamming = solucion.check(bin, paridad);

				// -------------------------------------------------------------------
				List<String> lPalabraDeDatosSinParidad = new ArrayList<String>();
				lPalabraDeDatosSinParidad = bitsHamming.get(0);
				P1_PDSP.setText(lPalabraDeDatosSinParidad.get(0));
				P2_PDSP.setText(lPalabraDeDatosSinParidad.get(1));
				D1_PDSP.setText(lPalabraDeDatosSinParidad.get(2));
				P3_PDSP.setText(lPalabraDeDatosSinParidad.get(3));
				D2_PDSP.setText(lPalabraDeDatosSinParidad.get(4));
				D3_PDSP.setText(lPalabraDeDatosSinParidad.get(5));
				D4_PDSP.setText(lPalabraDeDatosSinParidad.get(6));
				P4_PDSP.setText(lPalabraDeDatosSinParidad.get(7));
				D5_PDSP.setText(lPalabraDeDatosSinParidad.get(8));
				D6_PDSP.setText(lPalabraDeDatosSinParidad.get(9));
				D7_PDSP.setText(lPalabraDeDatosSinParidad.get(10));
				D8_PDSP.setText(lPalabraDeDatosSinParidad.get(11));
				D9_PDSP.setText(lPalabraDeDatosSinParidad.get(12));
				D10_PDSP.setText(lPalabraDeDatosSinParidad.get(13));
				D11_PDSP.setText(lPalabraDeDatosSinParidad.get(14));
				P5_PDSP.setText(lPalabraDeDatosSinParidad.get(15));
				D12_PDSP.setText(lPalabraDeDatosSinParidad.get(16));
				PdP_PDSP.setText(lPalabraDeDatosSinParidad.get(17));
				PdR_PDSP.setText(lPalabraDeDatosSinParidad.get(18));

				// -------------------------------------------------------------------
				List<String> lP1 = new ArrayList<String>();
				lP1 = bitsHamming.get(1);

				P1_P1.setText(lP1.get(0));
				P2_P1.setText(lP1.get(1));
				D1_P1.setText(lP1.get(2));
				P3_P1.setText(lP1.get(3));
				D2_P1.setText(lP1.get(4));
				D3_P1.setText(lP1.get(5));
				D4_P1.setText(lP1.get(6));
				P4_P1.setText(lP1.get(7));
				D5_P1.setText(lP1.get(8));
				D6_P1.setText(lP1.get(9));
				D7_P1.setText(lP1.get(10));
				D8_P1.setText(lP1.get(11));
				D9_P1.setText(lP1.get(12));
				D10_P1.setText(lP1.get(13));
				D11_P1.setText(lP1.get(14));
				P5_P1.setText(lP1.get(15));
				D12_P1.setText(lP1.get(16));
				PdP_P1.setText(lP1.get(17));
				PdR_P1.setText(lP1.get(18));

				// PdP_P1,PdR_P1,PdP_P2,PdR_P2,PdP_P3,PdR_P3,PdP_P4,PdR_P4,PdP_P5,PdR_P5

				// -------------------------------------------------------------------
				List<String> lP2 = new ArrayList<String>();
				lP2 = bitsHamming.get(2);

				P1_P2.setText(lP2.get(0));
				P2_P2.setText(lP2.get(1));
				D1_P2.setText(lP2.get(2));
				P3_P2.setText(lP2.get(3));
				D2_P2.setText(lP2.get(4));
				D3_P2.setText(lP2.get(5));
				D4_P2.setText(lP2.get(6));
				P4_P2.setText(lP2.get(7));
				D5_P2.setText(lP2.get(8));
				D6_P2.setText(lP2.get(9));
				D7_P2.setText(lP2.get(10));
				D8_P2.setText(lP2.get(11));
				D9_P2.setText(lP2.get(12));
				D10_P2.setText(lP2.get(13));
				D11_P2.setText(lP2.get(14));
				P5_P2.setText(lP2.get(15));
				D12_P2.setText(lP2.get(16));
				PdP_P2.setText(lP2.get(17));
				PdR_P2.setText(lP2.get(18));

				// -------------------------------------------------------------------
				List<String> lP3 = new ArrayList<String>();
				lP3 = bitsHamming.get(3);

				P1_P3.setText(lP3.get(0));
				P2_P3.setText(lP3.get(1));
				D1_P3.setText(lP3.get(2));
				P3_P3.setText(lP3.get(3));
				D2_P3.setText(lP3.get(4));
				D3_P3.setText(lP3.get(5));
				D4_P3.setText(lP3.get(6));
				P4_P3.setText(lP3.get(7));
				D5_P3.setText(lP3.get(8));
				D6_P3.setText(lP3.get(9));
				D7_P3.setText(lP3.get(10));
				D8_P3.setText(lP3.get(11));
				D9_P3.setText(lP3.get(12));
				D10_P3.setText(lP3.get(13));
				D11_P3.setText(lP3.get(14));
				P5_P3.setText(lP3.get(15));
				D12_P3.setText(lP3.get(16));
				PdP_P3.setText(lP3.get(17));
				PdR_P3.setText(lP3.get(18));

				// -------------------------------------------------------------------
				List<String> lP4 = new ArrayList<String>();
				lP4 = bitsHamming.get(4);

				P1_P4.setText(lP4.get(0));
				P2_P4.setText(lP4.get(1));
				D1_P4.setText(lP4.get(2));
				P3_P4.setText(lP4.get(3));
				D2_P4.setText(lP4.get(4));
				D3_P4.setText(lP4.get(5));
				D4_P4.setText(lP4.get(6));
				P4_P4.setText(lP4.get(7));
				D5_P4.setText(lP4.get(8));
				D6_P4.setText(lP4.get(9));
				D7_P4.setText(lP4.get(10));
				D8_P4.setText(lP4.get(11));
				D9_P4.setText(lP4.get(12));
				D10_P4.setText(lP4.get(13));
				D11_P4.setText(lP4.get(14));
				P5_P4.setText(lP4.get(15));
				D12_P4.setText(lP4.get(16));
				PdP_P4.setText(lP4.get(17));
				PdR_P4.setText(lP4.get(18));

				// -------------------------------------------------------------------
				List<String> lP5 = new ArrayList<String>();
				lP5 = bitsHamming.get(5);

				P1_P5.setText(lP5.get(0));
				P2_P5.setText(lP5.get(1));
				D1_P5.setText(lP5.get(2));
				P3_P5.setText(lP5.get(3));
				D2_P5.setText(lP5.get(4));
				D3_P5.setText(lP5.get(5));
				D4_P5.setText(lP5.get(6));
				P4_P5.setText(lP5.get(7));
				D5_P5.setText(lP5.get(8));
				D6_P5.setText(lP5.get(9));
				D7_P5.setText(lP5.get(10));
				D8_P5.setText(lP5.get(11));
				D9_P5.setText(lP5.get(12));
				D10_P5.setText(lP5.get(13));
				D11_P5.setText(lP5.get(14));
				P5_P5.setText(lP5.get(15));
				D12_P5.setText(lP5.get(16));
				PdP_P5.setText(lP5.get(17));
				PdR_P5.setText(lP5.get(18));

				
				System.out.println(bitsHamming.get(6).get(0));
				final Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(hamming);
				VBox dialogVbox = new VBox(20);
				dialogVbox.getChildren().add(new Text(bitsHamming.get(6).get(0)));
				Scene dialogScene = new Scene(dialogVbox, 300, 200);
				dialog.setScene(dialogScene);
				dialog.show();
				

			}
		});
		GridPane.setConstraints(obtener, 2, 8, 3, 1);
		GridPane.setHalignment(obtener, HPos.LEFT);

		grid.getChildren().addAll(nombre, p1, p2, d1, p3, d2, d3, d4, p4, d5, d6, d7, d8, d9, d10, d11, p5, d12,
				pruebaDeParidad, bitDeParidad, pp1, pp2, pp3, pp4, pp5, palabraDeDatosRecibida, bPar, bImpar, regresar,
				obtener, entradaBin, P1_PDSP, P1_P1, P1_P2, P1_P3, P1_P4, P1_P5, P2_PDSP, P2_P1, P2_P2, P2_P3, P2_P4,
				P2_P5, P2_PDCP, P3_PDSP, P3_P1, P3_P2, P3_P3, P3_P4, P3_P5, P4_PDSP, P4_P1, P4_P2, P4_P3, P4_P4, P4_P5,
				P5_PDSP, P5_P1, P5_P2, P5_P3, P5_P4, P5_P5, D1_PDSP, D1_P1, D1_P2, D1_P3, D1_P4, D1_P5, D2_PDSP, D2_P1,
				D2_P2, D2_P3, D2_P4, D2_P5, D3_PDSP, D3_P1, D3_P2, D3_P3, D3_P4, D3_P5, D4_PDSP, D4_P1, D4_P2, D4_P3,
				D4_P4, D4_P5, D5_PDSP, D5_P1, D5_P2, D5_P3, D5_P4, D5_P5, D6_PDSP, D6_P1, D6_P2, D6_P3, D6_P4, D6_P5,
				D7_PDSP, D7_P1, D7_P2, D7_P3, D7_P4, D7_P5, D8_PDSP, D8_P1, D8_P2, D8_P3, D8_P4, D8_P5, D9_PDSP, D9_P1,
				D9_P2, D9_P3, D9_P4, D9_P5, D10_PDSP, D10_P1, D10_P2, D10_P3, D10_P4, D10_P5, D11_PDSP, D11_P1, D11_P2,
				D11_P3, D11_P4, D11_P5, D12_PDSP, D12_P1, D12_P2, D12_P3, D12_P4, D12_P5, PdP_PDSP, PdR_PDSP, PdP_P1,
				PdR_P1, PdP_P2, PdR_P2, PdP_P3, PdR_P3, PdP_P4, PdR_P4, PdP_P5, PdR_P5);
		tabla2 = new Scene(grid, 840, 180);
		return tabla2;
	};

}
