/**
 * Created by alebaffa on 28/09/16.
 */
public class LiveCell implements Cell {
    private int x;
    private int y;

    public LiveCell(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public int getPosX() {
        return x;
    }

    @Override
    public int getPosY() {
        return y;
    }
}
