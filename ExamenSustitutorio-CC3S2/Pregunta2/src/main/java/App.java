import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Gateway<AstroResponse> astroGateway = new AstroGateway();
        AstroService astroService = new AstroService(astroGateway);

        astroService.getAstroData().forEach((key, value) -> {
            String str = " astronautas a bordo de ";
            if (key.equals("ISS"))
                str += "la ";
            System.out.println(value + str + key);
        });
    }
}
