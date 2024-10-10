public class SpaceInvaders //extends Observable
{
    Entity bullet;
    Entity sprite;
    int speedX, speedY;

    public SpaceInvaders()
    {
        bullet = new Entity("ball.png", 0, 0);
        sprite = new Entity("paddle.png", 200, 300);
        speedX = 1;
        speedY = 1;
    }

    public Entity getBall()
    {
        return bullet;
    }

    public Entity getPaddle()
    {
        return sprite;
    }

    public void moveRight()
    {
        sprite.move(10, 0);
    }

    public void moveLeft()
    {
        sprite.move(-10, 0);
    }

    public void moveBall()
    {
        if (bullet.getX() > 400) speedX = -1;
        if (bullet.getX() < 0) speedX = 1;
        if (bullet.getY() < 0) speedY = 1;
        if (bullet.collides(sprite)) speedY = -1;
        bullet.move(speedX, speedY);
        //notifyObserver();
        if (bullet.getY() > 300)
        {
            bullet.kill();
            bullet = null;
        }
        //notifyObserver();
    }
}