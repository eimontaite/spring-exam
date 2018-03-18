package lt.itakademija.repository;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mariusg on 2017.03.19.
 */
@Component
public class SequenceGeneratorImpl implements SequenceGenerator {

    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Long getNext() {
        return sequence.incrementAndGet();
    }

}
