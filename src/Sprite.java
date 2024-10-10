public class Sprite extends Entity
{
    private int maxPositionX;

    public Sprite(String imagePath, int startX, int startY, int maxPositionX)
    {
        super(imagePath, startX, startY);
        this.maxPositionX = maxPositionX;
    }

    public void moveRight()
    {
        if (getX() < maxPositionX)
        {
            move(10, 0);
        }
    }

    public void moveLeft()
    {
        if (getX() > 0)
        {
            move(-10, 0);
        }
    }
}
