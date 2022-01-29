package com.company;

public class Tank {

    static final String MODEL = "T34";
    static int tankCount;
    private int x, y;
    private int dir;
    private int fuel = 100;
    private int n;


    public Tank() {
        n = ++tankCount;
    }

    public Tank(int x2, int y2) {
        this.x = x2;
        this.y = y2;
        n = ++tankCount;
    }

    public Tank(int x3, int y3, int fuel2) {
        this.x = x3;
        this.y = y3;
        this.fuel = fuel2;
        n = ++tankCount;
    }

    public void goForward(int i) {
        int requiredFuel = i > 0 ? i : -i;
        int realDistance = requiredFuel > fuel ? fuel : requiredFuel;
        int isMovingForward = i > 0 ? 1 : -1;
        realDistance *= isMovingForward;
        if (dir == 0) x += realDistance;
        else if (dir == 1) y += realDistance;
        else if (dir == 2) x -= realDistance;
        else y -= realDistance;
        fuel -= realDistance;
    }

    public void printPosition() {
        System.out.println("The Tank" + MODEL + "-" + n + " is at " + x + ", " + y + " now.");
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
    }

    public void goBackward(int i) {
        goForward(-i);
    }
}
