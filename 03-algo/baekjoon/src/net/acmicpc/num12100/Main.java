package net.acmicpc.num12100;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] board;
    static int maxBlock = 0;

    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("data/input12100.txt"));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(board, 0);
        System.out.println(maxBlock);
    }

    // 4가지 방향으로 움직이는 것을 재귀적으로 시도
    static void dfs(int[][] board, int count) {
        if (count == 5) {
            // 5번 이동 후 가장 큰 블록 값 갱신
            maxBlock = Math.max(maxBlock, getMax(board));
            return;
        }

        // 상, 하, 좌, 우로 보드를 이동
        for (int i = 0; i < 4; i++) {
            int[][] newBoard = move(board, i);
            dfs(newBoard, count + 1);
        }
    }

    // 보드에서 가장 큰 값을 찾음
    static int getMax(int[][] board) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }

    // 보드를 특정 방향으로 이동
    static int[][] move(int[][] board, int dir) {
        int[][] newBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        // 상
        if (dir == 0) {
            for (int j = 0; j < n; j++) {
                int[] temp = new int[n];
                int idx = 0;
                for (int i = 0; i < n; i++) {
                    if (newBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == newBoard[i][j]) {
                            temp[idx - 1] *= 2;
                        } else {
                            temp[idx++] = newBoard[i][j];
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    newBoard[i][j] = temp[i];
                }
            }
        }
        // 하
        else if (dir == 1) {
            for (int j = 0; j < n; j++) {
                int[] temp = new int[n];
                int idx = 0;
                for (int i = n - 1; i >= 0; i--) {
                    if (newBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == newBoard[i][j]) {
                            temp[idx - 1] *= 2;
                        } else {
                            temp[idx++] = newBoard[i][j];
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    newBoard[n - i - 1][j] = temp[i];
                }
            }
        }
        // 좌
        else if (dir == 2) {
            for (int i = 0; i < n; i++) {
                int[] temp = new int[n];
                int idx = 0;
                for (int j = 0; j < n; j++) {
                    if (newBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == newBoard[i][j]) {
                            temp[idx - 1] *= 2;
                        } else {
                            temp[idx++] = newBoard[i][j];
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    newBoard[i][j] = temp[j];
                }
            }
        }
        // 우
        else if (dir == 3) {
            for (int i = 0; i < n; i++) {
                int[] temp = new int[n];
                int idx = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (newBoard[i][j] != 0) {
                        if (idx > 0 && temp[idx - 1] == newBoard[i][j]) {
                            temp[idx - 1] *= 2;
                        } else {
                            temp[idx++] = newBoard[i][j];
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    newBoard[i][n - j - 1] = temp[j];
                }
            }
        }

        return newBoard;
    }
}
