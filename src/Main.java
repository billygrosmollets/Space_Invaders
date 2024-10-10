//Main.java

public class Main
{
    public static void main(String[] arg)
    {
        SpaceInvaders pong = new SpaceInvaders();
        View view = new View(pong);
        Controller controller = new Controller(pong, view);
        System.out.println("TEST");
    }
}