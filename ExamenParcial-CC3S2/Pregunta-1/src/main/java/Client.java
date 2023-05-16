import java.util.List;

public class Client {
    public static void main(String[] args) {
        organizeTournamentsByMembers(enrolledOrganizerMembers());
    }
    private static void organizeTournamentsByMembers(List<OrganizerMember> members) {
        for (OrganizerMember m : members) {
            m.organizeTournament();
        }
    }
    private static List<OrganizerMember> enrolledOrganizerMembers() {
        List<OrganizerMember> members = List.of(
                new PremiumMember("Abejita Azul"),
                new VipMember("Kaperucita Feliz")
        );
        return members;
    }
}

