import java.util.*;

import java.util.ArrayList;
import java.util.List;


public class DFS {
    static  int[] dx = {-1, 1, 0, 0};
    static  int[] dy = {0, 0, -1, 1};
    public static boolean searchPath(int [][] maze, int x, int y, List<Integer> path) {
        if(maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x]==0) {
            maze[y][x] = 2;
            for(int k=0; k<4; k++) {
                int i = x+dx[k];
                int j = y+dy[k];
                if(searchPath(maze, i, j, path)) {
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
        }
        return false;
    }
}
