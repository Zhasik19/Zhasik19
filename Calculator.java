import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please edit in format: int1 (operation) int2 // every symbol is separated");
        String line = in.nextLine();
        String arg[] = line.split(" ");
        int res = 0;
        try {
            if (isNumeric(arg[0]) && isNumeric(arg[2])){
                switch (arg[1].charAt(0)){
                    case '+': res = Integer.parseInt(arg[0]) + Integer.parseInt(arg[2]); break;
                    case '-': res = Integer.parseInt(arg[0]) - Integer.parseInt(arg[2]); break;
                    case '*': res = Integer.parseInt(arg[0]) * Integer.parseInt(arg[2]); break;
                    case '/': res = Integer.parseInt(arg[0]) / Integer.parseInt(arg[2]);
                }
                System.out.println(arg[0] + ' ' + arg[1] + ' ' + arg[2] + " = " + res);
            }
            else {
                int fir = toDigit(arg[0]);
                int sec = toDigit(arg[2]);
                switch (arg[1].charAt(0)){
                    case '+': res = fir+sec; break;
                    case '-': res = fir-sec; break;
                    case '*': res = fir*sec; break;
                    case '/': res = fir/sec;
                }
                System.out.println(fir + ' ' + arg[1] + ' ' + sec + " = " + res);
                int len = line.length();
            }
        }
        catch (Exception ex){
            System.out.println("Something went wrong");
        }
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static int toDigit(String in){
        int len = in.length();
        char roman[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int arabic[] = {1,  5,  10,  50,  100, 500,  1000};
        ArrayList<Integer> total = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            for (int k = 0; k < roman.length; k++) {
                if (in.charAt(j) == roman[k]) total.add(arabic[k]);
            }
        }
        int max = Collections.max(total);
        int index = total.indexOf(max);
        int sum = 0;
        for (int j = 0; j < total.size(); j++) {
            if (total.get(j) == max) sum+=total.get(j);
            else if (total.indexOf(total.get(j)) < index) sum-=total.get(j);
            else sum+=total.get(j);
        }
        return sum;
    }
}