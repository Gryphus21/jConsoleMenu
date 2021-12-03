# jConsoleMenu
# Library usage

```
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
