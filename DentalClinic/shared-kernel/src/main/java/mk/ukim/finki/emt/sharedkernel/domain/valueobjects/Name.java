package mk.ukim.finki.emt.sharedkernel.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.*;
import lombok.Getter;

@Embeddable
@Getter
public class Name implements ValueObject {

    private String firstName;

    private String lastName;

    public Name() {
        this.firstName = "";
        this.lastName = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
