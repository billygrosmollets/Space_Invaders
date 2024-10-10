//Controller.java

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Controller implements KeyListener, ActionListener
{
    private SpaceInvaders spaceInvaders;
    private View view;

    public Controller(SpaceInvaders pong, View view)
    {
        this.spaceInvaders = pong;
        this.view = view;
        Timer t = new Timer(10, this);
        t.start();
        view.addListeners(this);
        //pong.add(view);
        pong.getBall().add(view);
        pong.getPaddle().add(view);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (spaceInvaders.getBall() != null)
        {
            spaceInvaders.moveBall();
        }
        //view.update();
    }

    @Override
    public void keyPressed(KeyEvent kev)
    {
        switch (kev.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                spaceInvaders.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                spaceInvaders.moveRight();
                break;
        }
        //view.update();
    }

    @Override
    public void keyReleased(KeyEvent arg0)
    {
    }

    @Override
    public void keyTyped(KeyEvent arg0)
    {
    }
}
