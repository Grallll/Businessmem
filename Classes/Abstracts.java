package Classes;

import java.util.Map;

abstract class Base{
    String  name;
    public abstract Map<String, String> info();
}

abstract class Person extends Base{
    String  specialization;
}
