package SigmaBatchDSA.ClassProblems.GraphsPart5;

public class FloodFillAlgo {

    // DFS Helper
    public void helper(int[][] image, int sr, int sc, int color,
                       boolean[][] vis, int orgCol) {

        // Base case
        if (sr < 0 || sc < 0 ||
                sr >= image.length || sc >= image[0].length ||
                vis[sr][sc] ||
                image[sr][sc] != orgCol) {
            return;
        }

        // Mark visited
        vis[sr][sc] = true;

        // Change color
        image[sr][sc] = color;

        // Left
        helper(image, sr, sc - 1, color, vis, orgCol);

        // Right
        helper(image, sr, sc + 1, color, vis, orgCol);

        // Up
        helper(image, sr - 1, sc, color, vis, orgCol);

        // Down
        helper(image, sr + 1, sc, color, vis, orgCol);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int orgCol = image[sr][sc];

        // If the starting pixel already has the target color
        if (orgCol == color) {
            return image;
        }

        boolean[][] vis = new boolean[image.length][image[0].length];

        helper(image, sr, sc, color, vis, orgCol);

        return image;
    }

    // Testing
    public static void main(String[] args) {

        FloodFillAlgo obj = new FloodFillAlgo();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] ans = obj.floodFill(image, 1, 1, 2);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}