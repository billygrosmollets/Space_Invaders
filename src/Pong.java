//Pong.java

public class Pong //extends Observable
{
    Entity ball;
    Entity paddle;
    int speedX, speedY;

    public Pong()
    {
        ball = new Entity("ball.png", 0, 0);
        paddle = new Entity("paddle.png", 200, 300);
        speedX = 1;
        speedY = 1;
    }

    public Entity getBall()
    {
        return ball;
    }

    public Entity getPaddle()
    {
        return paddle;
    }

    public void moveRight()
    {
        paddle.move(10, 0);
    }

    public void moveLeft()
    {
        paddle.move(-10, 0);
    }

    public void moveBall()
    {
        if (ball.getX() > 400) speedX = -1;
        if (ball.getX() < 0) speedX = 1;
        if (ball.getY() < 0) speedY = 1;
        if (ball.collides(paddle)) speedY = -1;
        ball.move(speedX, speedY);
        //notifyObserver();
        if (ball.getY() > 300)
        {
            ball.kill();
            ball = null;
        }
        //notifyObserver();
    }
}