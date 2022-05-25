package observerPackage;

public interface DataCallback <T>{
    void trigger(T value);
}
