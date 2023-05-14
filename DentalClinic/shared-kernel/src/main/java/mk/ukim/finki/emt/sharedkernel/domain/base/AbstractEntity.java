package mk.ukim.finki.emt.sharedkernel.domain.base;

import jakarta.persistence.*;
import lombok.Getter;


@MappedSuperclass
@Getter
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    protected AbstractEntity() {
    }

}

