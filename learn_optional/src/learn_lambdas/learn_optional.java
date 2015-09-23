package learn_lambdas;

import org.junit.Test;

import java.util.Optional;

public class learn_optional {

    @Test
    private void testOptional(){
        Integer number = null;

        Optional<Integer> of = Optional.of(number);

        of.ifPresent((s) -> s.toString());
        of.orElse(4);

    }

}
