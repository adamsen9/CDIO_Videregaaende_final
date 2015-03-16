import boundary.Menu;
import boundary.IMenu;
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
		IMenu menu = new Menu(func);
		func.setBoundary(menu);
		
		list.run();
	}

}
