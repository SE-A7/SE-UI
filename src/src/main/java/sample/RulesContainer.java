package main.java.sample;

import lombok.Getter;

import java.util.LinkedList;

/**
 * Created by samur on 5/21/2017.
 */
public class RulesContainer {

    @Getter private LinkedList<Rules> container = new LinkedList<Rules>();

    private static RulesContainer instance = null;

    private RulesContainer() { }

    public static RulesContainer getInstance() {
        if(instance == null){
            instance = new RulesContainer();
        }
        return instance;
    }

    public void add(Rules rule){
        container.add(rule);
    }
    public void remove(Rules rule){
        container.remove(rule);
    }
    public void clear(){
        container.clear();
    }
}
