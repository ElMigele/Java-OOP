package Task_1;

public class Container<T> {
    private T product;
    public  T Product(){
        return product;
    }
    
    public boolean IsEmpty(){
        return product == null;
    }

    public boolean IsFull(){
        return currentVolume == maxVolume;
    }

    private float currentVolume;
    public float CurrentVolume(){
        return currentVolume;
    }

    private float maxVolume;
    public float MaxVolume(){
        return maxVolume;
    }
    
    public float FreeSpace(){
        return maxVolume - currentVolume;
    }

    public Container(float maxVolume){
        if (maxVolume <= 0) {
            System.out.println("error: max volume <= 0!");
            return;
        }
        this.maxVolume = maxVolume;
    }

    public Container(float maxVolume, T product, float volume){
        if (maxVolume <= 0) {
            System.out.println("error: max volume <= 0!");
            return;
        }
        this.maxVolume = maxVolume;
        Load(product, volume);
    }

    public boolean Load(T product, float volume){
        if (this.product != null && !this.product.equals(product)){
            //System.out.println("error: container is not empty & load product type is not equal container product!");
            return false;
        }
        if (volume <= 0) {
            //System.out.println("error: load volume <= 0!");
            return false;
        } 
        if (maxVolume - currentVolume < volume) {
            //System.out.println("error: free volume is less than load volume!");
            return false;
        }
        this.product = product;
        currentVolume += volume;
        //System.out.println("Container is loaded");
        //System.out.println(GetStatus());
        return true;
    }

    public boolean Unload(float volume){
        if (volume <= 0){
            //System.out.println("error: volume <= 0!");
            return false;
        }
        if (volume > currentVolume){
            //System.out.println("error: container has not required volume!");
            return false;
        }
        currentVolume -= volume;
        if (currentVolume == 0){
            product = null;
        }
        //System.out.println(GetStatus());
        return true;
    }

    // rewrite
    public String GetStatus(){
        return product == null
        ? "Empty. Volume: " + currentVolume + "/" + maxVolume
        : "Product: " + product + ". Volume: " + currentVolume + "/" + maxVolume;
    }
}