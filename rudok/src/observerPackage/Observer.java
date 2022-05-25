package observerPackage;

public class Observer<T> {

    DataCallback<T> callback;

    public Observer(DataCallback dataCallback){
        this.callback = dataCallback;
    }

    public void onChange(T value){
        this.callback.trigger(value);
    }

}
