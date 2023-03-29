import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MAZE_SOLVER_PROJECT extends JFrame {


    private int[][] maze =  {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public List<Integer> path = new ArrayList<>();

    public MAZE_SOLVER_PROJECT(){
        setTitle("Maze Solver");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                           //  when click on close button it wiill make all thing close
        DFS.searchPath(maze,1,1,path);

    }

    @Override
    public void paint(Graphics g) {

        g.translate(100, 100);

        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.DARK_GRAY;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.BLACK);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        for(int i=0;i<path.size();i+=2){
            int pathx=path.get(i);
            int pathy=path.get(i+1);

            g.setColor(Color.GREEN);
            g.fillRect(31*pathx,31*pathy,20,20);
        }

    }

    public static void main(String[] args) {
        MAZE_SOLVER_PROJECT view = new MAZE_SOLVER_PROJECT();
        view.setVisible(true);
    }
}
