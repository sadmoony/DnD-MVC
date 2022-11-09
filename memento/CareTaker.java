package memento;

import java.util.*;

public class CareTaker {
    private List<Object> mementoList = new ArrayList<Object>();
    static int saveID=0;
    public void add(Object obj){
        mementoList.add(obj);
        System.out.println("State save " + saveID + "\n");
        saveID++;
    }

    public Object get(int index){
        System.out.println("Loading stats from save "+ index);
        return mementoList.get(index);
    }
    public Object getLast(){

        return mementoList.get(mementoList.size() - 1);
    }
    public boolean isEmptyList(){
        if(mementoList.isEmpty())
            return true;

        return false;
    }
}
