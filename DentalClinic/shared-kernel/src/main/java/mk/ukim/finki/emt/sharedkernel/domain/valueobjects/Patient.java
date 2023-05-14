package mk.ukim.finki.emt.sharedkernel.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Patient implements ValueObject{

    private Name name;

    private String email;

    private String phoneNumber;

    public Patient() {
        this.name = new Name();
        this.email = "";
        this.phoneNumber = "";
    }

    public Patient(Name name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
