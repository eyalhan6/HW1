public class Assignment01Q05 {

    public static int[] addLocation(int[] beenTo, int v) {
        int[] New = new int[beenTo.length];
        for (int i = 0; i < beenTo.length; i++) {
            if (i == v) New[i] = 1;
            else New[i] = beenTo[i];
        }

        return New;
    }

    public static int pathRec(int[][] m, int i, int j, int[] beenTo) {
        if (i == j) return 0;

        int n = m.length;
        int minLen = n + 1;
        for (int k = 0; k < n; k++) {
            if (m[i][k] == 1 && beenTo[k] == 0) {
                minLen = Math.min(minLen, 1 + pathRec(m, k, j, addLocation(beenTo, k)));
            }
        }

        return minLen;
    }

    public static int findShortestPath(int[][] m, int i, int j) {
        int[] beenTo = new int[m.length];
        for (int k = 0; k < m.length; k++) {
            if (k == i) beenTo[k] = 1;
            else beenTo[k] = 0;
        }

        int recAnswer = pathRec(m, i, j, beenTo);
        if (recAnswer == m.length + 1) return -1;
        return recAnswer;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}
