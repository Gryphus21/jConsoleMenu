package jconsolemenu;

/**
 * @author Gryphus21
 * @project jConsoleMenu
 * @version 1.0.1
 * @package jconsolemenu
 * @created 12/03/2020
 */
public class InputChecker {
    private int verifiedInt = 0;
    private double verifiedDouble = 0d;
    boolean inputChecked = false;

    /**
     * Convert a string to an integer
     * @param inputStringValue String value
     * @return integer value
     */
    public boolean strToInt(String inputStringValue) {
        inputChecked = false;

        try {
            verifiedInt = Integer.parseInt(inputStringValue);
            inputChecked = true;
        }
        catch (Exception ex) {
            inputChecked = false;
        }

        return inputChecked;
    }

    /**
     * Convert a string to a double number
     * @param inputStringValue String value
     * @return double value
     */
    public boolean strToDouble(String inputStringValue) {
        inputChecked = false;

        try {
            verifiedDouble = Double.parseDouble(inputStringValue);
            inputChecked = true;
        }
        catch (Exception ex) {
            inputChecked = false;
        }

        return inputChecked;
    }

    /**
     * Method that returns the integer value taken from StrToInt()
     * @return Integer value
     */
    public int getInt() {
        return verifiedInt;
    }

    /**
     * Method that returns the integer value taken from StrToDouble()
     * @return Double value
     */
    public double getDouble() {
        return verifiedDouble;
    }
}