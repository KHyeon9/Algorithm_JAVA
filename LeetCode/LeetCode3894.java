public class LeetCode3894 {
    // Traffic Signal Color
    public String trafficSignal(int timer) {
        if (timer == 0) return "Green";
        if (timer == 30) return "Orange";
        if (30 < timer && timer <= 60) return "Red";
        return "Invalid";
    }
}

