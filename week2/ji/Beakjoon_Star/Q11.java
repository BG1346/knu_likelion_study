import java.util.Scanner;

//���� n [3*2^k (k = 1~10)] > �ִ� : 3072
//�ﰢ�� �غ� 2*n-1 > �ִ� : 6144

public class Q11 {

	final static int BASESIZE = 3; // ���� �ﰢ�� ������
	static char[][] board; // *�� �׸���

	public static void main(String[] args) {
	// �Է�
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // 3*2^k (k = 1~10)

		board = new char[n][2 * n - 1];
		for (int i = 0; i < board.length; i++) { // ��� �������� �ʱ�ȭ / �������κи� \n
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = j == board[i].length - 1 ? '\n' : ' ';
			}
		}

	// ó��
		recursiveDraw(n, 0, n - 1); // ���� �� ���������� x,y��ǥ�� �׸���

	// ���
		print();
	}
	
	//ó���Լ� - ���
	public static void recursiveDraw(int n, int x, int y) {
		if (n == BASESIZE) { // ���� ���� (base) �ﰢ���ϰ��
			board[x][y] = '*'; // x,y��ǥ == �ﰢ�� �� �������� �������� base�ﰢ�� �׸���
			board[x + 1][y - 1] = '*';
			board[x + 1][y + 1] = '*';
			for (int i = 0; i < 5; i++) {
				board[x + 2][y - 2 + i] = '*';
			}
			return;
		}

		recursiveDraw(n / 2, x, y);
		recursiveDraw(n / 2, x + n / 2, y - n / 2); // ������ �׸� x,y��������� ��ǥ���ϱ�
		recursiveDraw(n / 2, x + n / 2, y + n / 2); // //������ �׸� x,y��������� ��ǥ���ϱ�

	}
	
	//����Լ�
	public static void print() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
		}
	}
}

/*

// ��ü�� �̿��ؼ� Ǯ���

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // 3*2^k (k = 1~10)
		StarF s = new StarF(n); // 3, 6 ,12, 24...

		s.recursiveDraw(s.board, n, 0, n - 1); // ���� �� ���������� x,y��ǥ�� �׸���
		s.print();
	}

}

class StarF {

	final static int BASESIZE = 3; // �׸��� ���� ���� �ﰢ�� ������
	char[][] board; // *�� �׸� ��

	public StarF(int n) { // n�Է½� *�� �׷��� ũ���� �迭����
		int i, j;
		board = new char[n][2 * n - 1];
		for (i = 0; i < board.length; i++) { // ��� �������� �ʱ�ȭ / �������κи� \n
			for (j = 0; j < board[i].length; j++) {
				board[i][j] = j == board[i].length - 1 ? '\n' : ' ';
			}
		}
	}

	public static void draw(char[][] arr, int x, int y) { // x,y��ǥ == �ﰢ�� �� �������� �������� base�ﰢ�� �׸���
		arr[x][y] = '*';
		arr[x + 1][y - 1] = '*';
		arr[x + 1][y + 1] = '*';
		for (int i = 0; i < 5; i++) {
			arr[x + 2][y - 2 + i] = '*';
		}
	}

	public static void recursiveDraw(char[][] arr, int n, int x, int y) {
		if (n == BASESIZE) { // ���� ���� (base) �ﰢ���ϰ��
			draw(arr, x, y);
			return;
		}

		recursiveDraw(arr, n / 2, x, y);
		recursiveDraw(arr, n / 2, x + n / 2, y - n / 2); // ������ �׸� x,y��������� ��ǥ���ϱ�
		recursiveDraw(arr, n / 2, x + n / 2, y + n / 2); // //������ �׸� x,y��������� ��ǥ���ϱ�

	}

	public void print() { // print Method
		int i, j;
		for (i = 0; i < board.length; i++) {
			for (j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
		}
	}
}

*/