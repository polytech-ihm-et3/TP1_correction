# Exercise 1

The aim of this exercise is to create a temperature converter containing:

  - **Two labels** "Celsius" and "Fahrenheit"
  - **Two text boxes** to enter and display the temperature values
  - **Two buttons** to reset the text boxes and close the window

<p align="center"><img src="/images/tempconvH.jpg" width="300"></p>

1) Import this project in Eclipse

> *To import this project in eclipse, you should open Eclipse and follow these steps:*
>  1) *Go to File \> Import...*
>  2) *Select Git \> Projects from Git*
>  3) *Select Clone URI*
>  4) *Fill the URI box with `https://github.com/IntroductionProgIS/Exercise1.git` (All the other parts should be automatically filled)*
>  5) *Click on "Next", "Next" and "Finish"*

> *To see the tasks that you need to do in a project: Go to Eclipse and select Window \> Show View \> Tasks*

2) Complete the function `initGUI()` in the file **TemperatureConverter.java** by using the class `FlowPane` and layout panes of your choice to make the resulting window look like the pictured above.
3) Make sure the widgets are aligned and that their location remains consistent while resizing the window as in the following picture:

<p align="center"><img src="/images/tempconvV.jpg" width="150" align="middle"></p>

4) The `textFieldCListener` reads a floating value in the Celsius text box when the user press "enter", converts it from Celsius to Fahrenheit, and writes the result in the Fahrenheit text box. Associate this event handler to the text box of the Celsius value.
5) Fill in the `textFieldFListener` in order to do the conversion from Fahrenheit to Celsius. Associate it with the text box of the Fahrenheit value.

> *The temperature conversion occurs when the user presses enter. Use a `EventHandler<KeyEvent>()` (that you attach with `TextField.setOnKeyPressed`). The `EventHandler<KeyEvent>()` will be notified at each key press.*

6) The `buttonCloseListener` closes the window. Associate it to the "Close" button.
7) Fill in the `buttonResetListener` in order to empty both text boxes. Associate it to the "Reset" button.
8) (Going furhter) Associate a `TextFormatter` to `textFieldF` to ensure a valid character input (e.g., 23, 23.345, -21, 3E -02).
