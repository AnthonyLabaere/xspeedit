package fr.alabaere.xspeedit.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractBaseDTO {

    protected Long id;

    protected AbstractBaseDTO(){}

    protected AbstractBaseDTO(Long id) {
        this.id = id;
    }
}
