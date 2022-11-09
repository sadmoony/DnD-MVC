package GUI;

import Main.Character;
import Main.Stats;
import Visitor.DataElement;
import memento.CareTaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static Model model = Model.getInst();
    private static int item = 0;
    private static final int CHAR_NUM = 4;
    private static String[] listData = new String[CHAR_NUM];

    public static void generateStats(){
        model.setStats(Stats.generate());
        GUI.textArea1.setText(model.getStats().getAttrib().get("Strength").toString());
        GUI.textArea2.setText(model.getStats().getAttrib().get("Dexterity").toString());
        GUI.textArea3.setText(model.getStats().getAttrib().get("Constitution").toString());
        GUI.textArea4.setText(model.getStats().getAttrib().get("Intelligence").toString());
        GUI.textArea5.setText(model.getStats().getAttrib().get("Wisdom").toString());
        GUI.textArea6.setText(model.getStats().getAttrib().get("Charisma").toString());
    }

    public static void runMemento(){
        if(!model.getStats().equals(null)){
            model.setCareTaker(new CareTaker());
            model.getCareTaker().add(model.getStats().save());
            GUI.textArea8.setText("Stats saved");
        }
    }

    public static void returnMemento(){
        try {
            model.getStats().undoToLastSave(model.getCareTaker().getLast());
            GUI.textArea1.setText(model.getStats().getAttrib().get("Strength").toString());
            GUI.textArea2.setText(model.getStats().getAttrib().get("Dexterity").toString());
            GUI.textArea3.setText(model.getStats().getAttrib().get("Constitution").toString());
            GUI.textArea4.setText(model.getStats().getAttrib().get("Intelligence").toString());
            GUI.textArea5.setText(model.getStats().getAttrib().get("Wisdom").toString());
            GUI.textArea6.setText(model.getStats().getAttrib().get("Charisma").toString());
        } catch (NullPointerException e){
            GUI.textArea8.setText("No saved stats found");
        }
    }

    public static void createCharacter(){
        if(model.getStats() != null){
            if(item < CHAR_NUM){
                String name = GUI.typeYourNameTextField.getText().toString();
                String clas = GUI.comboBox1.getSelectedItem().toString();
                String race = GUI.comboBox2.getSelectedItem().toString();

                model.setCharacter(name, clas, race);
                model.getCharacter().setAttributes(model.getStats());
                model.getCharacter().addRaceBonuses();
                model.addItem(model.getCharacter());

                model.getVisitor().visit(model.getCharacter());
                GUI.textArea8.setText("Character created!");
                listData[item] = race + "-" + clas + "-" + name;
                GUI.list1.setListData(listData);
                item++;
            } else {
                GUI.textArea8.setText("Only 4 character allowed!");
            }
        } else {
            GUI.textArea8.setText("Generate stats before creating character :)");
        }
    }

    public static void saveJSON() throws IOException{
        String str = "[\n";

        for(Character cha : model.getItems()){
            model.getJsonObject().clear();
            List<DataElement> list = new ArrayList<>();

            list.add(cha);
            list.add(cha.getDndClass());
            list.add(cha.getRace());
            list.add(cha.getAttributes());

            for(DataElement elem : list){
                model.setJsonObject(elem.accept(model.getVisitor()));
            }

            str += model.getJsonObject().toJSONString();
            str += "\n";

            if(model.getItems().indexOf(cha) != model.getItems().size()-1){
                str += ",";
            }
        }

        str += "\n]";
        GUI.textPane1.setText(str);
        FileWriter file = new FileWriter("output.json");
        file.write(str);
        file.close();
    }

    static void printSelected(){
        model.getJsonObject().clear();
        List<DataElement> list = new ArrayList<>();

        list.add(model.getCharacter());
        list.add(model.getCharacter().getDndClass());
        list.add(model.getCharacter().getRace());
        list.add(model.getCharacter().getAttributes());

        String str = "";
        for (DataElement elem : list){
            model.setJsonObject(elem.accept(model.getVisitor()));
        }

        str = model.getJsonObject().toJSONString();
    }
}
