public class Bullet extends Entity implements Runnable
{
    private int maxPositionY;
    private int speed;

    public Bullet(String imagePath, int startX, int startY, int maxPositionY, int speed)
    {
        super(imagePath, startX, startY);  // Inherit from Entity
        this.maxPositionY = maxPositionY;
        this.speed = speed;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void move(int shiftX, int shiftY)
    {
        if (getY() + shiftY >= 0 && getY() + shiftY <= maxPositionY)
        {
            super.move(shiftX, shiftY);
        } else
        {
            kill();
        }
    }

    public void run() {
        while (isalive()) {
            try {
                Thread.sleep(10);
                move(0, speed);
            } catch (InterruptedException e) {}
        }
    }

}
