public class BirthAndDeathCountYear {

    private int birthCount;
    private int deathCount;

    @Override
    public String toString() {
        return "BirthAndDeathCountYear{" +
                "birthCount=" + birthCount +
                ", deathCount=" + deathCount +
                '}';
    }

    public BirthAndDeathCountYear(int birthCount, int deathCount) {
        this.birthCount = birthCount;
        this.deathCount = deathCount;
    }

    public int getBirthCount() {
        return birthCount;
    }

    public void setBirthCount(int birthCount) {
        this.birthCount = birthCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }


}
