import org.junit.jupiter.api.Test;

public class TestHttpURLConnectionFactory {
    @Test
    public void testGetContentOk() throws Exception {
        MockHttpURLConnection mockConnection = new MockHttpURLConnection();
        mockConnection.setupGetInputStream(
                new ByteArrayInputStream("It works".getBytes()));
        MockURL mockURL = new MockURL();
        mockURL.setupOpenConnection(mockConnection);
        WebClient client = new WebClient();
        String workingContent = client.getContent(mockURL);
        assertEquals("Esto funciona", workingContent);
    }
}
