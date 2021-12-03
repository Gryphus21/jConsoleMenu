package jconsolemenu;

import java.util.Scanner;

/**
 * @author Gryphus21
 * @version 1.0.0
 * @project jConsoleMenu
 * @package jconsolemenu
 * @created 05/04/2020
 */
public class Input {
    public static double doubleData(String text) {
        Scanner scan = new Scanner(System.in);
        boolean check = false;
        InputChecker inChecker = new InputChecker();

        do {
            System.out.print(Const.cursor + " " + text + ": ");
            check = inChecker.strToDouble(scan.nextLine());
            if (!check)
                System.out.println(Const.nanData);
        } while(!check);

        return inChecker.getDouble();
    }
}
