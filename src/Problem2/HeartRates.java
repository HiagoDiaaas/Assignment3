package Problem2;

import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public static final int RHR = 70;
    public static final double LB = 0.5;
    public static final double UB = 0.85;

    public HeartRates(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public int getMaxHeartRate() {
        return 220 - getAge();
    }

    public void printTargetHeartRateRange() {
        int maxHeartRate = getMaxHeartRate();
        int averageHeartRate = maxHeartRate - RHR;
        double lbthr = (averageHeartRate * LB) + RHR;
        double ubthr = (averageHeartRate * UB) + RHR;
        System.out.printf("The Target Heart Rate Range is between %.1f and %.1f%n", lbthr, ubthr);
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s%nDate of Birth: %s%nAge: %d%nMaximum Heart Rate: %d",
                firstName, lastName, birthDate, getAge(), getMaxHeartRate());
    }
}

