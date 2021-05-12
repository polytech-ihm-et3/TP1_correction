Programmation Java @ Et3
<br>
Polytech Paris-Saclay | 2020-21

___

# TP1

Le but de ce TP est de créer un programme de conversion de températures.
Ce programme devra contenir :

  - deux titres (cf. [*Label*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Label.html)), "Celsius" et "Fahrenheit";
  - deux champs de texte (cf. [*TextField*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html)), pour entrer et afficher des températures;
  - deux boutons (cf. [*Button*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Button.html)), "Close" (pour fermer l'application) et "Reset" (pour vider les champs de texte).

<br><div align="center"><img src="images/tempconvH.jpg" width="300"></img></div><br>

1. Importez ce projet dans votre IDE.

> Pour importer ce projet dans Eclipse, suivez les étapes suivantes :
>   1) Allez dans *File* > *Import...*;
>   2) Sélectionnez *Git* > *Projects from Git*;
>   3) Sélectionnez *Clone URI*;
>   4) Dans *URI:*, entrez "https://github.com/polytech-ihm-et3/TP1_squelette.git" (les autres champs devraient se remplir automatiquement);
>   5) Cliquez sur "*Next >*" pour toutes les étapes suivantes, puis sur "*Finish*".
>   
> Pour visualiser les tâches à réaliser dans ce projet avec Eclipse, allez dans "*Window*" > "*Show View*" > "*Tasks*".

> Pour importer ce projet dans IntelliJ, suivez les étapes suivantes :
>   1) Allez dans *File* > *New* > *Project from Version Control...*;
>   2) Sur la droite, sélectionnez *GitHub*;
>   3) Dans la barre de recherche, en haut, inscrivez "https://github.com/polytech-ihm-et3/TP1_squelette.git";
>   4) Cliquez sur *Clone*.
>   
> Pour visualiser les tâches à réaliser dans ce projet avec IntelliJ, allez dans "*View*" > "*Tool Windows*" > "*TODO*".

2. Dans le fichier *TemperatureConverter.java*, complétez la fonction `initGUI()` pour qu'elle agence correctement les différents éléments graphiques (la disposition finale doit être proche de celle de la photo). Utilisez la classe [*FlowPane*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/FlowPane.html) pour le contenant principal puis d'autres [*Panes*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Pane.html) de votre choix pour les autres éléments.

3. Assurez-vous que les éléments graphiques sont correctement alignés et que leurs positions sont cohérentent avec la photo suivante lorsque vous changez la taille de la fenêtre.

<br><div align="center"><img src="images/tempconvV.jpg" width="150"></img></div><br>

4. Le `textFieldCListener` réalise les actions suivantes si l'utilisateur appuie sur la touche *ENTRÉE*, alors que le focus est sur textFieldC :

 - lire la valeur indiquée dans le champs de texte correspondant à la valeur en *Celsius*;
 - transformer cette valeur en float (attention à la gestion des exceptions !);
 - convertir cette valeur en *Fahrenheit*;
 - écrire cette nouvelle valeur dans le champs de texte correspondant à la valeur en *Fahrenheit*.

    Associez le `textFieldCListener` au champs de texte correspondant à la valeur en *Celsius*.

> Ici, le listener en question surveille les touches du clavier. Il s'agit donc d'un [*EventHandler*](https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html) qui surveille les [*KeyEvents*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/KeyEvent.html). On peut créer ce listener en utilisant :
> ```Java
> textFieldFListener = new EventHandler<KeyEvent>() 
> {
>    @Override
>    public void handle(KeyEvent e) 
>    {
>       //Ce que fait le listener en cas de KeyEvent
>    }
> ```
> Pour associer un Listener à un champs de texte, vous pouvez utiliser la méthode [*setOnKeyPressed*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html#setOnKeyPressed-javafx.event.EventHandler-).

5. Implémentez le `textFieldFListener` pour qu'il réalise les actions suivantes si l'utilisateur appuie sur la touche *ENTRÉE*, alors que le focus est sur textFieldF :

 - lire la valeur indiquée dans le champs de texte correspondant à la valeur en *Fahrenheit*;
 - transformer cette valeur en float (attention à la gestion des exceptions !);
 - convertir cette valeur en *Celsius*;
 - écrire cette nouvelle valeur dans le champs de texte correspondant à la valeur en *Celsius*.

    Associez le `textFieldFListener` au champs de texte correspondant à la valeur en *Fahrenheit*.

6. Le `buttonCloseListener` quitte l'application . Associez-le au bouton *Close*.

> Ici, le listener en question surveille l'action liée à un bouton. Il s'agit donc d'un [*EventHandler*](https://docs.oracle.com/javase/8/javafx/api/javafx/event/EventHandler.html) qui surveille les [*ActionEvents*](https://docs.oracle.com/javase/8/javafx/api/javafx/event/ActionEvent.html).

7. Implémentez le `buttonResetListener` pour qu'il vide les deux champs de texte. Associez-le au bouton *Reset*.

8. (Bonus) Associez un [*TextFormatter*](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextFormatter.html) aux deux champs de texte pour qu'ils n'acceptent que des entrées valides (e.g. 23, 23.345, -21, 3E -02).
