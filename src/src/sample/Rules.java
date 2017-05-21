package sample;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by samur on 5/21/2017.
 */
public class Rules {

    @Getter @Setter private String rule;
    @Getter @Setter private String description;

    public Rules(String rule, String description) {
        this.rule = rule;
        this.description = description;
    }
}
