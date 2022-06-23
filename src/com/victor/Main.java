package com.victor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        boolean ok;
        String str;

        System.out.print("Введите число: ");
        while (!scanner.hasNextInt())
        {
            scanner.next();
            System.out.println("Некорректный ввод");
            System.out.print("Введите число: ");
        }
        num = scanner.nextInt();
        System.out.println("Число "+num+" в 16-ричном виде: "+toHex(num));
        System.out.println("Число "+num+" в 2-ичном виде: "+toBin(num));
        ok = false;
        while (!ok) {
            System.out.print("Введите число в 2-ичном виде: ");
            str = scanner.next();
            ok = true;
            for (char c: str.toCharArray()) if ((c != '0') && (c != '1'))
            {
                ok = false;
                break;
            }
            if (ok)
                System.out.println("Число " + str + " в 10-ричном виде: " + toDecFromBin(str));
            else
                System.out.println("Некорректный ввод");
        }
    }

    public static String toHex(int num)
    {
        int residue;
        StringBuilder res = new StringBuilder();
        while (num > 0)
        {
            residue = num % 16;
            if (residue < 10) res.insert(0, (char) ('0' + residue));
            else res.insert(0, (char) ('A' + (residue - 10)));
            num /= 16;
        }
        return res.toString();
    }
    public static String toBin(int num)
    {
        int residue;
        StringBuilder res = new StringBuilder();
        while (num > 0)
        {
            residue = num % 2;
            res.insert(0, (char) ('0' + residue));
            num /= 2;
        }
        return res.toString();
    }
    public static int toDecFromBin(String bin)
    {
        int res = 0;
        try {
            for (char c : bin.toCharArray()) {
                res *= 2;
                if (c == '1') res += 1;
                else if (c != '0') throw new Exception("Строка имеет недопустимые символы");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return res;
    }
}