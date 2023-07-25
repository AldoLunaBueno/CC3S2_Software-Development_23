import java.util.List;

public class FakeGateway implements Gateway<AstroResponse>{
    @Override
    public AstroResponse getResponse() {
        return new AstroResponse(
                2,
                "success",
                List.of(
                        new Assignment("Aldo", "ISS"),
                        new Assignment("Marian", "ISS")
                )
        );
    }
}
