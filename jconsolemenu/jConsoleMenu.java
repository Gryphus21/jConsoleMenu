package jconsolemenu;

import jconsolemenu.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Gryphus21
 * @version 1.0.2
 * @project jConsoleMenu
 * @package menu
 * @created 12/03/2020
 */
public class jConsoleMenu {
    private List<Integer> fieldValueList = new ArrayList<Integer>();
    private List<String> textualFieldList = new ArrayList<String>();
    private String menuTitle;
    private Scanner consoleRead = new Scanner(System.in);

    /**
     * Main constructor of the class that allows you to set a title for the menu.
     * @param title Title of the context menu shown at the top center of the menu.
     */
    public jConsoleMenu(String title) {
        menuTitle = title;
    }

    /**
     * Allows you to set the menu option texts.
     * @param textualFields Setting the options that will be displayed in the menu.
     */
    public void setTextualField(String... textualFields) {
        for (String c : textualFields) {
            textualFieldList.add(c);
        }
    }

    /**
     * Set the values to be sent in input to be able to select the preferred option.
     * @param fieldValue Setting of the values that must be sent in input to access the desired option (set the same number of values for as many options).
     */
    public void setFieldValue(int... fieldValue) {
        for (int v : fieldValue) {
            fieldValueList.add(v);
        }
    }

    /**
     * Method that prints the menu and returns the whole of the selected option.
     * @param caller List of interfaces.
     * @return Integer value of the input in the context menu.
     */
    public void print(Caller... caller) {
        List<Caller> methodList = new ArrayList<Caller>();
        int inInteger = 0;
        boolean selectedOption = false;
        boolean inIntChecked = false;
        boolean check;
        InputChecker InputChecker = new InputChecker();

        print_initialConfigurationCheck();
        print_printTextualFields();

        do {
            System.out.print(Const.cursor);
            check = InputChecker.strToInt(consoleRead.nextLine());

            // User input checker, check that the input is a number and check if the value is within the range of option values.
            if(check) {
                inInteger = InputChecker.getInt();
                if (inInteger >= fieldValueList.get(0) && inInteger <= fieldValueList.get(fieldValueList.size() - 1)) {
                    inIntChecked = true;
                } else {
                    System.out.println(Const.cursor + "[ERROR] Entered value must be between " + fieldValueList.get(0) + " and " + fieldValueList.get(fieldValueList.size() - 1));
                }
            }
            else {
                System.out.println(Const.cursor + Const.nanData);
                inIntChecked = false;
                if (check)
                    consoleRead.nextLine();
            }

            // Checks if the user input is correct and executes the relevant code.
            if (inIntChecked) {
                for (Caller sCall : caller) {
                    methodList.add(sCall);
                }
                int i = 0;
                for (int v : fieldValueList) {
                    if (inInteger == v) {
                        methodList.get(i).invoke();
                        selectedOption = true;
                    }
                    i++;
                }
                if (!selectedOption) {
                    System.out.println(Const.cursor + "[ERROR] Entered value is not an option");
                }
            }
        } while (!inIntChecked || !check || !selectedOption);
    }

    /**
     * Avoid problems here and there...
     * Exception Both must have the same element size.
     */
    private void print_initialConfigurationCheck() {
        try {
            if (fieldValueList.size() != textualFieldList.size())
                throw new Exception("setTextualField() and setFieldValue() they don't have the same number of elements.");
        } catch (Exception e) {
            System.out.println("[DEBUG] Error in print_initialConfigurationCheck: " + e.getMessage());
        }
    }

    private void print_printTextualFields() {
        String output = "\n\t\t" + menuTitle + "\n\n";

        for (String element : textualFieldList) {
            output += element + "\n";
        }

        System.out.println(output);
    }
}
