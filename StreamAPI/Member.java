import java.time.LocalDate;

class Member {
    String memName;
    LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.memName = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return memName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return memName + " | Expiry Date : " + expiryDate;
    }
}