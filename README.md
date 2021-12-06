# jConsoleMenu
This Java library allows you to build a small choice menu in a terminal console application, selecting the desired option by means of a choice number.

# Library installation
Add the **jconsolemenu** folder inside the **src** folder of your project, remember to import the dependency into your code with:
```java 
import jconsolemenu.*; 
```

# Library usage
This example code builds a menu with three selectable choices.
```cpp
public static void main(String[] args) {
    jConsoleMenu menu = new jConsoleMenu("# MAIN TITLE #");
    
    menu.setTextualField("0] Option 1", "1] Option 2", "2] Option 3");
    menu.setFieldValue(0, 1, 2);
    menu.print(
        new Caller() {
            public void invoke() {
                System.out.println("> 1");
            }
        },
        new Caller() {
            public void invoke() {
                System.out.println("> 2");
            }
        },
        new Caller() {
            public void invoke() {
                System.out.println("> 3");
            }
        }
    );
}
```
