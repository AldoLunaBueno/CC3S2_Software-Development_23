public class VipMember extends OrganizerMember {
    public VipMember(String name) {
        super(name);
    }
    @Override
    public void joinTournament() {
        System.out.println(getName() + " se unió a un torneo.");
    }
    @Override
    public void organizeTournament() {
        System.out.println(getName() + " organizó un torneo.");
    }
}
