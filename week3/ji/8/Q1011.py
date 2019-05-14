'''
마지막은 무조건 1광년 이동 해야 하므로
마지막 도착지점 -1 에 무조건 도착해야 한다.
이곳을 도착하기 위해 무조건 이전의 이동은 1광년 or 2광년 이다.
이전의 이동이 2광년일 경우
다시 그 곳을 도착하기 위해 이전의 이동은 1 or 2 or 3광년이다.
또, 3광년 이동시 이전의 이동은
2 or 3 or 4 광년이어야 한다.

시작점의 경우 또한 첫번째 움직임은 무조건 1광년이므로
그 다음에 이동할 수 있는 광년이 정해진다.

start에서 한번씩 움직일 때마다 "마지막은 1광년 이동해야 한다"는
법칙에 따라 마지막 도착지점에 도착하기 위한 광년의 경로가 정해진다.

즉 start와 end지점에서 같은 방식으로
한번 씩 가장 크게 움직이는 경우가 최소한의 공간이동 회수와 같다.

start와 end 모두 이동한 거리를 뺀 남은 거리에 대해서
같은 방식으로 최소한의 공간이동 회수를 구하면 된다.

1번가는경우 -> (1번가고, count+1)
1번가고도 남는경우 ->
    2번가는경우 -> (2번가고, count+2)
    2번가고도 남는경우 -> (2번가고, count+2)
    2번가고도 남지않는 경우 -> (1번가고, 나중에 1번가고 count +2, left = 0)
1번가고도 남지않는경우 -> (1번가고 count+1, left = 0)

즉 (left(이동할 거리) == (left = left - 이동한거리))
2번가는경우의 범위는 2*(n-1) <= left <= 2*(n+1)
1번가는경우의 범위는 n-1 <= left <= n+1

2번가고도 남는경우는 (2*n+1) < left
1번가고도 남는경우는 n+1 < left < 2*(n-1)

'''