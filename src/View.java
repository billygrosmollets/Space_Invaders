//View.java

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Hashtable;

public class View implements Observer
{
    //private Pong pong;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    //private JLabel ball;
    //private JLabel paddle;
    private Hashtable<Entity, JLabel> table;


    public View(Pong pong)
    {
        //this.pong = pong;
        panel.setLayout(null);
        table = new Hashtable<Entity, JLabel>();

        /*ball = new JLabel(pong.getBall().getimage());
        ball.setBounds(pong.getBall().getX(), pong.getBall().getY(), 60, 20);
        panel.add(ball);

        paddle = new JLabel(pong.getPaddle().getimage());
        paddle.setBounds(pong.getPaddle().getX(), pong.getPaddle().getY(), 60, 20);
        panel.add(paddle);*/

        frame.add(panel);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    /*@Override
    public void update(Observable observable)
    {
        System.out.println("public void update(Observable observable)");
        //Pong pong = (Pong) observable;
        Entity entity = (Entity) observable;

        if (pong.getBall() != null)
        {
            ball.setBounds(pong.getBall().getX(), pong.getBall().getY(), 60, 20);
        } else
        {
            panel.remove(ball);  // Remove ball if it no longer exists
        }

        paddle.setBounds(pong.getPaddle().getX(), pong.getPaddle().getY(), 60, 20);
        frame.getContentPane().repaint();
    }*/

    @Override
    public void update(Observable obs)
    {
        Entity entity = (Entity) obs;
        JLabel jlabel = (JLabel) table.get(obs);
        if (!((Entity) obs).isalive() && jlabel != null)
        {
            panel.remove(jlabel);
            table.remove(entity);
        } else if (((Entity) obs).isalive() && jlabel == null)
        {
            jlabel = new JLabel();
            jlabel.setIcon(((Entity) obs).getimage());
            table.put((Entity) obs, jlabel);
            panel.add(jlabel);
            jlabel.setBounds(((Entity) obs).getX(), ((Entity) obs).getY(), 60, 20);
        } else if (((Entity) obs).isalive() && jlabel != null)
            jlabel.setBounds(((Entity) obs).getX(), ((Entity) obs).getY(), 60, 20);

        frame.getContentPane().repaint();
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public void addListeners(Controller controller)
    {
        frame.addKeyListener(controller);
    }
}
