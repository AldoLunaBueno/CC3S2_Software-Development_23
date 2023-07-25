import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AstroServiceTest {
    @Test
    public void integrationTest() {
        // Arrange
        List<String> expected = List.of(
                "3 astronautas a bordo de Tiangong",
                "7 astronautas a bordo de la ISS"
        );
        List<String> result = new ArrayList<>();
        Gateway<AstroResponse> astroGateway = new AstroGateway();
        AstroService astroService = new AstroService(astroGateway);

        // Act
        astroService.getAstroData().forEach((key, value) -> {
            String str = " astronautas a bordo de ";
            if (key.equals("ISS"))
                str += "la ";
            String message = value + str + key;
            result.add(message);
        });
        
        // Assert
        assertEquals(result, expected);
    }
}
