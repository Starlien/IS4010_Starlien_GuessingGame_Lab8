import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener{
JTextField userGuess;
JButton guessButton, playAgain;
JLabel enterGuess, highOrlow, lastGuess;
Random r;
int rNum;

GuessingGame(){
  r = new Random();
  rNum = r.nextInt(99)+1;

  //Setting frame and layout
  JFrame frame = new JFrame("Guessing Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(250,200);

  userGuess = new JTextField(10);
  userGuess.setActionCommand("myTF");

  guessButton = new JButton("Guess");
  playAgain = new JButton("Play Again");

  userGuess.addActionListener(this);
  guessButton.addActionListener(this);
  playAgain.addActionListener(this);

  enterGuess = new JLabel("Enter your guess: ");
  highOrlow = new JLabel("");
  lastGuess = new JLabel("");

  frame.add(enterGuess);
  frame.add(userGuess);
  frame.add(guessButton);
  frame.add(highOrlow);
  frame.add(lastGuess);
  frame.add(playAgain);
  frame.setVisible(true);

}

public void actionPerformed(ActionEvent ae){
  if(ae.getActionCommand().equals("Guess")){
    int guess = Integer.parseInt(userGuess.getText());
    if(rNum > guess){
      highOrlow.setText("Too Low! ");
      
    }else if(rNum < guess){
      highOrlow.setText("Too High! ");
      
    }else{
      highOrlow.setText("You got it! ");
    }
    lastGuess.setText("Last guess was: " + guess);
  }else if(ae.getActionCommand().equals("Play Again")){
    r = new Random();
    rNum = r.nextInt(99)+1;

    highOrlow.setText("");
    lastGuess.setText("");
    userGuess.setText("");
  }else{
    highOrlow.setText("You pressed Enter. ");
    lastGuess.setText("Please press the Guess Button.");
  }
}

}