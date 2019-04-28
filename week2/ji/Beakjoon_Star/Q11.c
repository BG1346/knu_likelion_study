# include <stdio.h>

//���� n [3*2^k (k = 1~10)] > �ִ� : 3072
//�ﰢ�� �غ� 2*n-1 > �ִ� : 6144

void draw(int n, int x, int y);

char board[3072][6144];
const int BASESIZE = 3;

int main(void){
	int n, i, j;
	
	scanf_s("%d", &n); //�Է�

	// �迭 �ʱ�ȭ

	for (i = 0; i < n; i++) {
		for (j = 0; j < 2 * n; j++) {
			board[i][j] = j == 2 * n - 1 ? '\n' : ' '; //// ��� �������� �ʱ�ȭ / �������κи� \n
		}
	}

	draw(n, 0, n - 1); // ���� �� ���������� x,y��ǥ�� �׸���

	// �迭 ���
	for (i = 0; i < n; i++) {
		for (j = 0; j < 2 * n; j++) {
			printf("%c", board[i][j]);
		}
	}
	
	return 0;
}

void draw(int n, int x, int y)
{
	if (n == BASESIZE) //�������� (base) �ﰢ���� ���
	{ // x,y��ǥ == �ﰢ�� �� �������� �������� base�ﰢ�� �׸���
		board[x][y] = '*';
		board[x + 1][y - 1] = '*';
		board[x + 1][y + 1] = '*';
		board[x + 2][y - 2] = '*';
		board[x + 2][y - 1] = '*';
		board[x + 2][y + 0] = '*';
		board[x + 2][y + 1] = '*';
		board[x + 2][y + 2] = '*';
		return;
	}
	
	draw(n / 2, x, y);
	draw(n / 2, x + n / 2, y - n / 2); // ������ �׸� x,y��������� ��ǥ���ϱ�
	draw(n / 2, x + n / 2, y + n / 2); // //������ �׸� x,y��������� ��ǥ���ϱ�
	
}