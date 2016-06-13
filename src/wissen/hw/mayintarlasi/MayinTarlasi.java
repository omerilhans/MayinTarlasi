package wissen.hw.mayintarlasi;

import java.util.Scanner;

public class MayinTarlasi {
    
    static Scanner oku = new Scanner(System.in);
    static int[][] map = new int[7][7];
    static int x, y;
    
    static void placeMines() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                map[i][j] = 9;
            }
        }
        
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int r1X = (int) (Math.random() * 7);
                int r1Y = (int) (Math.random() * 7);
                
                int r2X = (int) (Math.random() * 7);
                int r2Y = (int) (Math.random() * 7);
                
                int tmp = map[r2Y][r2X];
                
                map[r2Y][r2X] = map[r1Y][r1X];
                map[r1Y][r1X] = tmp;
            }
        }
    }
    
    static void printMap() {
        System.out.print("Mayın yerleri : ");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 9) {
                    System.out.print("[" + i + ", " + j + "]");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (map[i][j] == 9) {
                    System.out.print("0" + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
    
    static void Tusla() {
        System.out.print("x gir: ");
        x = oku.nextInt();
        System.out.print("y gir: ");
        y = oku.nextInt();
    }
    
    static boolean isEmpty() {
        if (map[x][y] == 9) {
            return false;
        }
        return true;
    }
    
    static boolean isFinish() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        placeMines();
        printMap();
        while (true) {
            Tusla();
            if (!isEmpty()) {
                System.out.println("Game Over !");
                System.out.println("You Losed...");
                break;
            } else {
                map[x][y] = 1;
                printMap();
            }
            if (isFinish()) {
                System.out.println("Game Over !");
                System.out.println("Congratulations... You Win !");
                System.exit(0);
            }
        }
    }
}
