public class DFSMaze {

    static String path = "";
    static String shortestPath = "";

    public static void dfsMaze(int x, int y, int[][] maze) {
        /*
         * ��þ���Ĵ�С
         * */
        int m=maze.length;
        int n=maze[0].length;
        //���ý�������
        if (x < 0 || y < 0)
            return;
        // �������Խ�磬���� maze[x][y]==1 ��ʾ�����ϰ�
        if (x > m - 1 || y > n - 1 || maze[x][y] ==1)
            return;
        //��ʾ�����ϰ�
        if (maze[x][y] == 1)
            return; // �ж��Ƿ�ͨ·��Խ��
        if (x == m - 1 && y == n - 1) { // �ж��Ƿ�ִ����
            path = path + "(" + x + "," + y + ")";
            if (shortestPath.length() == 0 || shortestPath.length() > shortestPath.length())
                shortestPath = path;
            System.out.println("�ҵ�·��:" + path);
            return;
        }

        String temp = path;
        path = path + "(" + x + "," + y + ")" + "-"; // ��¼·��
        maze[x][y] = 1; // ���߹���·���
        // ���ĸ���������
        dfsMaze(x + 1, y, maze);  //��������
        dfsMaze(x, y + 1, maze);  //��������
        dfsMaze(x, y - 1, maze);  //��������
        dfsMaze(x - 1, y, maze);  //��������
        // ��·�ߺͱ�ǻָ�����һ�ε�״̬
        maze[x][y] = 0;
        //���
        path = temp;
    }

    public static void main(String[] args) {
        // ��ʼ��һ���Թ���ͼ
        // 0: ��ʾͨ·
        // 1:��ʾ��·
        int[][] maze = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };

        int[][] maze2 = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        /*
         * �Ӿ�������Ͻ�λ�ÿ�ʼ����
         * */
        dfsMaze(0, 0, maze2);
        if (shortestPath.length() != 0)
            System.out.println("���·��Ϊ��" + shortestPath);
        else
            System.out.println("û���ҵ�·�ߣ�");


    }

}
