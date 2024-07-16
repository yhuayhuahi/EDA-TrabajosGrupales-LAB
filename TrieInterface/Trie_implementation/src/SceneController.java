import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.ArrayList;

public class SceneController {

    @FXML
    private TextField myFindWord;

    @FXML
    private TextField myInsertWord;

    @FXML
    private TextArea myListWord;

    @FXML
    private TextArea myOutput;

    @FXML
    private TextField mySentence;

    @FXML
    private TextField myWord;

    Trie trie = new Trie();

    List<String> myWords = new ArrayList<>();

    @FXML
    void findWord(ActionEvent event) {
        String myWord = myFindWord.getText();
        boolean myBoolean = trie.search(myWord);

        myFindWord.setText("");

        String myString = myOutput.getText();

        String myResponse = myBoolean ? "Palabra Encontrada: ": "Palabra no encontrada: ";

        if (myString.equals("")) 
            myOutput.setText(myString + myResponse + myWord);
        else
            myOutput.setText(myString + "\n" + myResponse + myWord);
    }

    @FXML
    void insertWord(ActionEvent event) {
        String myWord = myInsertWord.getText();
        trie.insert(myWord);

        myInsertWord.setText("");

        String myString = myOutput.getText();
        if (myString.equals("")) 
            myOutput.setText(myString + "Palabra Insertada: " + myWord);
        else
            myOutput.setText(myString + "\nPalabra Insertada: " + myWord);
    }

    @FXML
    void insertWordTemp(ActionEvent event) {
        String myWordString = myWord.getText();
        myWord.setText("");

        String myList = myListWord.getText();
        if (myList.equals("")) {
            myListWord.setText(myList + myWordString);
        } else {
            myListWord.setText(myList + "\n" + myWordString);
        }
        
        myWords.add(myWordString);
    }

    @FXML
    void replaceWord(ActionEvent event) {
        String sentence = mySentence.getText();
        
        Solution mySolution = new Solution();
        String replaceWords = mySolution.replaceWords(myWords, sentence);

        String myString = myOutput.getText();
        if (myString.equals("")) 
            myOutput.setText(myString + "Oración Original: " + sentence + "\nOración Modificada: " + replaceWords);
        else
            myOutput.setText(myString + "\nOración Original: " + sentence + "\nOración Modificada: " + replaceWords);
        
        mySentence.setText("");
        myWord.setText("");
        myListWord.setText("");
    }

}
