import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] currentTime = br.readLine().split(":");
    	String[] bombTime = br.readLine().split(":");
    	
    	int currentHour = Integer.parseInt(currentTime[0]);
    	int currentMinute = Integer.parseInt(currentTime[1]);
    	int currentSecond = Integer.parseInt(currentTime[2]);
    	int bombHour = Integer.parseInt(bombTime[0]);
    	int bombMinute = Integer.parseInt(bombTime[1]);
    	int bombSecond = Integer.parseInt(bombTime[2]);
    	
    	int currentCalc = currentHour*3600 + currentMinute*60 + currentSecond;
    	int bombCalc = bombHour*3600 + bombMinute*60 + bombSecond;
    	int diff = bombCalc - currentCalc;
    	diff = diff <= 0 ? 24 * 3600 + diff : diff; 
    	
    	int hour = diff / 3600;
    	diff %= 3600;
    	
    	int minute = diff / 60;
    	diff %= 60;
    	
    	int second = diff;
    	
    	String hourStr = (hour < 10) ? "0" + String.valueOf(hour)  : String.valueOf(hour);
    	String minuteStr = (minute < 10) ? "0" + String.valueOf(minute)  : String.valueOf(minute);
    	String secondStr = (second < 10) ? "0" + String.valueOf(second)  : String.valueOf(second);
    	
    	System.out.println(hourStr + ":" + minuteStr + ":" + secondStr);
    }
}