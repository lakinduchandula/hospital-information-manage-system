package sample.model;

public class GetSetTextArea {

    public static String getText(String newString) {
        String inputOneLine = "";
        String[] oneLineString = newString.split("\n");
        for(String element : oneLineString){
            inputOneLine += element + "UIOP";
        }
        return inputOneLine;
    }

    public static String setText(String newString){
        String outOneLine = "";
        String[] oneLineString = newString.split("UIOP");
        for(String element : oneLineString){
            outOneLine += element + "\n";
        }
        return outOneLine;
    }
}
