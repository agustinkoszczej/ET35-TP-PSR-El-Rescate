import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRootPane;


public class Main extends JFrame {
   public Main(){
       add(new Estados(this));
       setTitle("El Rescate");
  	   setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setSize(800,650);
       setVisible(true);
       //setUndecorated(true); 
       getRootPane().setWindowDecorationStyle(JRootPane.NONE);
       setLocationRelativeTo(null);
       setResizable(false);
       Sonidos.Fondo.loop();
   }

   public static void main(String[] args) {
       new Main();
   }

}
