import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SceneController {

    @FXML
    private TextField myFindWord;

    @FXML
    private TextField myInsertWord;

    @FXML
    private ListView<?> myListWord;

    @FXML
    private TextArea myOutput;

    @FXML
    private TextField mySentence;

    @FXML
    private TextField myWord;

    Trie trie = new Trie();

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

    }

    @FXML
    void replaceWord(ActionEvent event) {

    }

}
