import boundary.Boundary;
import boundary.IBoundary;
import boundary.Listener;
import entity.Entity;
import entity.IEntity;
import function.Function;
import function.IFunction;


public class Main {

	public static void main(String[] args) {
		IEntity data = new Entity();
		IFunction func = new Function(data);
		Listener list = new Listener(func);
		IBoundary menu = new Boundary(func);
		func.setBoundary(menu);
		
		list.run();
	}

}
