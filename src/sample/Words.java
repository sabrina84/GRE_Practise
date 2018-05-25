package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Nowrin on 27-Nov-15.
 */
public class Words {


        private final SimpleStringProperty key;
        private final SimpleStringProperty meaning;
        private final SimpleStringProperty synonym;

        Words(String keyW, String mean, String syn) {
            this.key = new SimpleStringProperty(keyW);
            this.meaning = new SimpleStringProperty(mean);
            this.synonym = new SimpleStringProperty(syn);
        }

        public String getKey() {
            return key.get();
        }

        public void setKey(String keyW) {
            key.set(keyW);
        }

        public String getMeaning() {
            return meaning.get();
        }

        public void setMeaning(String mean) {
            meaning.set(mean);
        }

        public String getSynonym() {
            return synonym.get();
        }

        public void setSynonym(String syn){synonym.set(syn);}
    public String toString() {
        return key + ", " + meaning + ", " + synonym;
    }

}