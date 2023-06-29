package ejemploMock;

public class UserNotifications {
    private final MailServer mailServer;
    public UserNotifications(MailServer mailServer) {
        this.mailServer = mailServer;
    }

    public void welcomeNewUser(String email) {
        mailServer.sendEmail(email, "Bienvenido!", "Bienvenido a tu cuenta.");
    }
}
