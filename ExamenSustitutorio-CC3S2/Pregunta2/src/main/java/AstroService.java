import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AstroService {
    private final Gateway<AstroResponse> astroGateway;
    public AstroService(Gateway<AstroResponse> astroGateway) {
        this.astroGateway = astroGateway;
    }

    public Map<String, Long> getAstroData() {
        Map<String, Long> map = new HashMap<>();
        AstroResponse astroResponse = astroGateway.getResponse();
        if (astroResponse != null) {
            return null;
        }
        List<Assignment> people = astroResponse.getPeople();
        for (Assignment assignment : people) {
            String craft = assignment.getCraft();
            if (map.containsKey(craft)) {
                map.put(craft, map.get(craft) + 1);
            } else {
                map.put(craft, 1L);
            }
        }
        return map;
    }
}