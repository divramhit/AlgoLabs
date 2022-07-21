package QU2;

public class Assignment {
    private String moduleName;
    private int numCredits;
    private int weekDeadline;
    private double maxMark;

    public Assignment(String moduleName, int numCredits, int weekDeadline, double maxMark) {
        this.moduleName = moduleName;
        this.numCredits = numCredits;
        this.weekDeadline = weekDeadline;
        this.maxMark = maxMark;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public int getWeekDeadline() {
        return weekDeadline;
    }

    public double getMaxMark() {
        return maxMark;
    }
}

