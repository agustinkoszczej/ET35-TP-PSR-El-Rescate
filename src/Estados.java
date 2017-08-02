
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;


// timer
import javax.swing.Timer;

import java.awt.Toolkit;

// teclas y timer
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// teclas
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Estados extends JPanel implements ActionListener, EstadoJuego {
   private Timer timer;
   public static GameState currentState;
   public static MenuPrincipal menuprincipal;
   public static DibujarPersonaje jugando;
   
   public Estados(Main main){
       setDoubleBuffered(true);
       setFocusable(true);
       addKeyListener(new Listener());
       setBackground(Color.black);
       timer = new Timer(5, this);
       timer.start();
       currentState = GameState.MenuPrincipal;
       menuprincipal = new MenuPrincipal();
       //jugando = new DibujarPersonaje(main);

   }

   public void paint(Graphics g){
       super.paint(g);
       Graphics2D g2d = (Graphics2D)g;

       // Dibuja aca
       if(currentState == GameState.MenuPrincipal)
           menuprincipal.draw(g2d);
       if(currentState == GameState.Jugando){
           jugando.draw(g2d);
           if (MenuPrincipal.Sonido == "Con" ) Sonidos.Fondo.stop();
       }
       Toolkit.getDefaultToolkit().sync();
       g.dispose();
   }

   public void actionPerformed(ActionEvent e){
       // Logica aca
       if(currentState == GameState.Jugando)
           jugando.update();
           repaint();
   }

   private class Listener extends KeyAdapter{
       public void keyPressed(KeyEvent e){
               // Metodo de los objetos que reciben input
           if(currentState == GameState.MenuPrincipal)
               menuprincipal.keyPressed(e);
          if(currentState == GameState.Jugando)
               jugando.keyPressed(e);
       }

   
       public void keyReleased(KeyEvent e){
               // Metodo de los objetos que reciben input
    	   if(currentState == GameState.Jugando)
               jugando.keyReleased(e);
    	       
       }
   }

}