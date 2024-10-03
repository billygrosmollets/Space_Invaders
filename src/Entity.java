//Entity.java

import javax.swing.ImageIcon;

class Entity extends Observable
{
    int x, y;
    ImageIcon image;
    volatile boolean alive = true;

    public Entity(String imgPath, int x, int y)
    {
        this.x = x;
        this.y = y;
        alive = true;
        image = new ImageIcon(getClass().getResource(imgPath));
    }

    public ImageIcon getimage()
    {
        return image;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int sizeX()
    {
        return image.getIconWidth();
    }

    public int sizeY()
    {
        return image.getIconHeight();
    }

    public boolean isalive()
    {
        return alive;
    }

    public void kill()
    {
        alive = false;
    }

    public void move(int shiftX, int shiftY)
    {
        x += shiftX;
        y += shiftY;
        notifyObserver();
    }

    public boolean collides(final Entity e)
    {
        int xm1 = getX();
        int ym1 = getY();
        int xp1 = getX() + sizeX();
        int yp1 = getY() + sizeY();
        int xm2 = e.getX();
        int ym2 = e.getY();
        int xp2 = e.getX() + e.sizeX();
        int yp2 = e.getY() + e.sizeY();
        return !(xm2 > xp1 || xm1 > xp2 || ym2 > yp1 || ym1 > yp2);
    }
}