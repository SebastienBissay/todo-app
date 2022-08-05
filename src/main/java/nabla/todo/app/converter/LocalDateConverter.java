package nabla.todo.app.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sebastien Bissay
 */
@Component
public class LocalDateConverter implements Converter<String, LocalDate> {

    private static  final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, LocalDateConverter.formatter);
    }

}
