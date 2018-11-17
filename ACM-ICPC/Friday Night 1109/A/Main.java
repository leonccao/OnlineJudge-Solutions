import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();
        System.out.println(Math.sqrt(s) * 4);

        sc.close();
    }
}

