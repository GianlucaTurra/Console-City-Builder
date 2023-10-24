package Settlements;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
abstract class Settlement {

    // ----------------------------------------------------------------------------------------------------------------
    // CONSTRUCTOR
    // ----------------------------------------------------------------------------------------------------------------
    protected String name;
    public Settlement(String name) {
        this.name = name;
    }
}
