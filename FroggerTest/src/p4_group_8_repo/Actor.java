package p4_group_8_repo;

import javafx.scene.image.ImageView;
import java.util.ArrayList;
/**
 * 
 * @author Ahmad Nabil
 *
 */
public abstract class Actor extends ImageView{
/**
 * 
 * @param dx first parameter to move method
 * @param dy second parameter to move method
 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
/**
 * 
 * @return world getparent
 */
    public World getWorld() {
        return (World) getParent();
    }
/**
 * 
 * @return returns width
 */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
/**
 * 
 * @return returns height
 */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
/**
 * 
 * @param <A> first parameter
 * @param cls second parameter
 * @return returns somearray
 */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
/**
 * 
 * @param <A> first parameter
 * @param cls second parameter
 * @return returns somearray.get
 */
    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }
/**
 * 
 * @param now First parameter in act method
 */
    public abstract void act(long now);

}
