package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureConverter extends Application 
{
	private Button buttonReset ;
	private Button buttonClose;
	private Label labelC ;
	private Label labelF ;
	private TextField textFieldC ;
	private TextField textFieldF ;
	private EventHandler<KeyEvent> textFieldCListener;
	private EventHandler<KeyEvent> textFieldFListener;
	private EventHandler<ActionEvent> buttonResetListener;
	private EventHandler<ActionEvent> buttonCloseListener;
	private TextFormatter<Object> textFormatterC;
	private TextFormatter<Object> textFormatterF;
	
	@Override
	public void start(Stage stage) throws Exception
	{
		/*
		 * APPLICATION : Il s'agit de notre application JavaFX
		 * STAGE : Il s'agit du contenant de haut niveau de l'application
		 * SCENE : C'est l'objet qui contient tous les �l�ments visuels
		 */
		
		//On d�finit un Pane "root" qui contiendra tous les autres �l�ments
		FlowPane root = new FlowPane();
        
		//On cr�e une scene qui contient le Pane "root" comme contenant principal
		Scene scene = new Scene(root); 
		
		//On d�finit la hauteur du stage (en param�tre)
		stage.setHeight(155);
		stage.setMaxHeight(225);
		stage.setMinHeight(155);
		//On d�finit la largeur du stage (en param�tre)
		stage.setWidth(355);
		stage.setMaxWidth(355);
		stage.setMinWidth(185);        
		
		//On initialise les TextFormatters qui g�rent les entr�es de nos TextFields
		initTextFormatters();
		
		//On initialise les Listeners des �l�ments qui composent notre interface utilisateur
		initListeners();
		
		//On initialise l'interface utilisateur (UI) de l'application
		//(GUI pour Graphic User Interface)
		initGUI(root);
		
		//On donne un titre au stage
		stage.setTitle("Temperature Converter");
		
		//On d�finit la scene ainsi cr��e comme �tant celle du stage
		stage.setScene(scene);
		
		//On affiche le stage
		stage.show();
	}
	
	/**
	 * Cette m�thode permet l'initialisation des TextFormatters.
	 * Ces TextFormatters g�rent les entr�es de nos TextFields.
	 */
	public void initTextFormatters()
	{
		/*
		* Le TextFormatter de textFieldC :
		* Ce TextFormatter accepte un nouveau caract�re seulement si le texte entr�
		* reste un nombre valide (positif or negatif). Il accepte �galement les
		* nombres scientifiques de la forme xxEx o� E repr�sente une puissance de 10.
		*/
		textFormatterC = new TextFormatter<>(character -> 
		{
			System.out.println(character);
			if (character.isContentChange())
			{
				if (character.getControlNewText().length() == 0) 
				{
					return character;
				}
				else if(character.getControlNewText().equals("-"))
				{
					return character;
				}
				else if(character.getControlNewText().length() > 1)
				{
					if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == 'E'
							&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) != 'E')
					{
						return character;
					}
					else if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == '-'
							&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) == 'E')
					{
						return character;
					}
				}
				
				try
				{
					Float.parseFloat(character.getControlNewText());
					return character;
				}
				catch (NumberFormatException e)
				{
					return null;
				}
			}
			return character;
		});

		/*
		* Le TextFormatter de textFieldF :
		* Ce TextFormatter accepte un nouveau caract�re seulement si le texte entr�
		* reste un nombre valide (positif or negatif). Il accepte �galement les
		* nombres scientifiques de la forme xxEx o� E repr�sente une puissance de 10.
		*/
		textFormatterF = new TextFormatter<>(character -> 
		{
			if (character.isContentChange())
			{
				if (character.getControlNewText().length() == 0) 
				{
					return character;
				}
				else if(character.getControlNewText().equals("-"))
				{
					return character;
				}
				else if(character.getControlNewText().length() > 1)
				{
					if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == 'E'
							&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) != 'E')
					{
						return character;
					}
					else if(character.getControlNewText().charAt(character.getControlNewText().length()  - 1) == '-'
							&& character.getControlNewText().charAt(character.getControlNewText().length()  - 2) == 'E')
					{
						return character;
					}
				}
				
				try
				{
					Float.parseFloat(character.getControlNewText());
					return character;
				}
				catch (NumberFormatException e)
				{
					return null;
				}
			}
			return character;
		});
	}

	/**
	 * Cette m�thode permet l'initialisation des Listeners des �l�ments de l'UI.
	 */
	public void initListeners()
	{
		/*
		 * Le Listener de textFieldC : 
		 * Lorsque l'utilisateur appuie sur la touche "ENTR�E", ce Listener
		 * convertit la valeur en Celsius entr�e dans textFieldC en Fahrenheit
		 * (� condition que le focus soit sur testFieldC)
		 */
		textFieldCListener = new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				//Si l'utilisateur a appuy� sur la touche "ENTR�E"
				if (e.getCode().equals(KeyCode.ENTER)) 
				{
					//On r�cup�re le texte entr� dans textFieldC
					String value = textFieldC.getText();
					
					try 
					{
						//On transforme ce texte en float
						float valC = new Float(value);
						//On calcule l'�quivalence de cette valeur en Fahrenheit
						float valF = valC * 1.8f + 32;
						//On affiche la valeur en Fahrenheit dans textFieldF
						textFieldF.setText(Float.toString(valF));
					}
					//Si le code pr�c�dent retourne une erreur
					catch (Exception exception) 
					{
						//On vide textFieldF
						textFieldF.setText("");
						//On vide textFieldC
						textFieldC.setText("");
					}
				}
			}
		};

		/*
		 * Le Listener de textFieldF : 
		 * Lorsque l'utilisateur appuie sur la touche "ENTR�E", ce Listener
		 * convertit la valeur en Fahrenheit entr�e dans textFieldF en Celsius
		 * (� condition que le focus soit sur testFieldF)
		 */
		textFieldFListener = new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e) 
			{
				if (e.getCode().equals(KeyCode.ENTER)) 
				{
					String value = textFieldF.getText();
					
					try
					{
						float valF = new Float(value);
						float valC = (valF - 32) / 1.8f;
						textFieldC.setText(Float.toString(valC));
					}
					catch (Exception exp)
					{
						textFieldF.setText("");
						textFieldC.setText("");
					}
				}
			}     		
		};

		/*
		 * Le Listener du bouton "Reset" :
		 * Si l'utilisateur clique sur le bouton "Reset", ce Listener vide les
		 * differents TextFields.
		 */
		buttonResetListener = new EventHandler<ActionEvent>()
		{
			@Override
            public void handle(ActionEvent event) 
            {
            	textFieldF.setText("");
                textFieldC.setText("");
            }
		};

		/*
		 * Le Listener du bouton "Close" :
		 * Si l'utilisateur clique sur le bouton "Close", ce Listener ferme l'application.
		 */
		buttonCloseListener = new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//On quitte l'application
				Platform.exit();
			}
		};
	}
	
	/**
	 * Cette m�thode permet l'initialisation des �l�ments graphiques.
	 * @param root Le Pane principal de la scene
	 */
	public void initGUI(Pane root)
	{
		//On cr�e le Pane de la partie Celsius
		VBox paneC = new VBox();
		paneC.setPadding(new Insets(10, 10, 10, 10));
		root.getChildren().add(paneC);
		
		//On cr�e le label de la partie Celsius
		labelC = new Label("Celsius");
		labelC.setPadding(new Insets(0, 0, 10, 0));
		paneC.getChildren().add(labelC);
		
		//On cr�e le TextField de la partie Celsius
		textFieldC = new TextField("");
		paneC.getChildren().add(textFieldC);   
		textFieldC.setOnKeyPressed(textFieldCListener);
		textFieldC.setTextFormatter(textFormatterC);
		
		//On cr�e le Pane de la partie Fahrenheit
		VBox paneF = new VBox();
		paneF.setPadding(new Insets(10, 10, 10, 10));
		root.getChildren().add(paneF);
		
		//On cr�e le label de la partie Fahrenheit
		labelF = new Label("Fahrenheit");
		labelF.setPadding(new Insets(0, 0, 10, 0));
		paneF.getChildren().add(labelF);
		
		//On cr�e le TextField de la partie Fahrenheit
		textFieldF = new TextField("");
		paneF.getChildren().add(textFieldF);
		textFieldF.setOnKeyPressed(textFieldFListener);
		textFieldF.setTextFormatter(textFormatterF);
		
		//On cr�e le Pane des boutons
		HBox paneButtons = new HBox();
		paneButtons.setPadding(new Insets(10, 10, 10, 10));
		paneButtons.setSpacing(10); 
		paneButtons.setAlignment(Pos.CENTER_RIGHT);
		root.getChildren().add(paneButtons);
		
		//On cr�e le bouton "Reset"
		buttonReset = new Button("Reset");
		buttonReset.setPrefWidth(70);
		paneButtons.getChildren().add(buttonReset);
		buttonReset.setOnAction(buttonResetListener);
		
		//On cr�e le bouton "Close"
		buttonClose = new Button("Close"); 
		buttonClose.setPrefWidth(70);
		paneButtons.getChildren().add(buttonClose);
		buttonClose.setOnAction(buttonCloseListener);
	}
	
	//La fonction principale ne doit pas �tre modifi�e !
	public static void main(String[] args) 
	{
		//On lance l'application
		launch(args);
	}
}