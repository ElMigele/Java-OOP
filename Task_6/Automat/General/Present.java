package Task_6.Automat.General;

import Task_6.Automat.Container.Container;
import Task_6.Product.Product;

public abstract class Present<C extends Container<P>, P extends Product, M extends Model<C, P>, V extends View> {
    protected M m;
    protected V v;

    protected boolean loop = true;
    public Present(){
        loop = true;
    }

    public abstract void Run();
}