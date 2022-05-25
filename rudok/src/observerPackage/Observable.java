package observerPackage;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    List<Observer> observerList = new ArrayList<>();

    public void subscribe(Observer observer){
        this.observerList.add(observer);
    }

    public void unsubscribe(Observer observer){

     this.observerList.remove(observer);

    }

    public void next(T value){
        ArrayList<Observer> observersClone = new ArrayList<>(observerList);
        observersClone.forEach(observer -> observer.onChange(value));
    }

}
