package lt.itakademija.model;

import org.springframework.stereotype.Component;

/**
 * Created by mariusg on 2017.03.19.
 */
public final class Id {

    private final Long id;

    public Id(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
