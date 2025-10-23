import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ34429 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        String[] time = line[0].split(":");
        String d = line[1];
        int late = Integer.parseInt(br.readLine());

        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        // 분단위로 변경
        int totalTime = (hour % 12) * 60 + min;
        // 오후면 12시간 추가
        if (d.equals("PM")) totalTime += 720;
        // 빨리 나와야 할 시간 계산
        totalTime -= late;
        // 하루전이면 24시간 더하기
        if (totalTime < 0) totalTime += 1440;
        // 시간 계산
        int resHour = (totalTime / 60) % 12;
        int resMin = totalTime % 60;
        // 12시간 기준으로 나눈 값이 0이 아닐경우 오후
        String resD = (totalTime / 60) / 12 == 0 ? "AM" : "PM";
        // 0시는 없으니 12시로 보정
        if (resHour == 0) resHour = 12;

        System.out.println(String.format("%d:%02d %s", resHour, resMin, resD));

    }
}
