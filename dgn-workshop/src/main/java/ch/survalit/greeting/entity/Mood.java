package ch.survalit.greeting.entity;

import java.util.Objects;

public class Mood {
    public String mood;
    public String reason;

    public Mood(String mood, String reason) {
        this.mood = mood;
        this.reason = reason;
    }

    public Mood() {
    }

    public String mood() {
        return mood;
    }

    public String reason() {
        return reason;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Mood) obj;
        return Objects.equals(this.mood, that.mood) &&
                Objects.equals(this.reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mood, reason);
    }

    @Override
    public String toString() {
        return "Greeting[" +
                "mood=" + mood + ", " +
                "reason=" + reason + ']';
    }

}
