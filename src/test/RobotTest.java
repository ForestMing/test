package test;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class RobotTest {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-=-=-=-说明:此程序由分行科技部制作，可设置鼠标位置随机移动，用于挂网课时防止暂停-=-=-=-");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-如需停止，关闭此窗口即可。-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.print("请输入鼠标自动移动间隔时间（秒）：");
        int interval = 5 ;
        boolean falseInput = true;
        while(falseInput) {
            try {
                interval = scanner.nextInt();
                if (interval < 5 | interval > 300) {
                    System.out.println("输入时间必须在5-300之间");
                    System.out.print("请输入鼠标自动移动间隔时间（秒）：");
                }else{
                    falseInput = false ;
                }
            } catch (Exception e) {
                System.out.println("输入非法！");
                System.out.print("请输入鼠标自动移动间隔时间（秒）：");
                scanner = new Scanner(System.in);
                continue;
            }
        }
        Calendar calendarRaw = Calendar.getInstance();
       // System.out.println(calendarRaw.getTimeInMillis());
        long startTime = System.currentTimeMillis();
        System.out.println("-----已启动，开始时间:" + new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z").format(new Date(startTime)) + "-----");
        while (true){
            int x = random.nextInt(1600);
            int y = random.nextInt(800);
            System.out.print("当前坐标:" + x + "," + y);
            robot.mouseMove(x,y);
            robot.delay(interval*1000);
            long completeTime1 = System.currentTimeMillis();
            long tcompleteTime = completeTime1 - startTime;
//            System.out.println("结束时间 : " + completeTime1);
            long runningSecond = tcompleteTime / 1000 ;
            System.out.println(",已运行:" + runningSecond/3600 + "小时" + runningSecond%3600/60 +"分钟"+runningSecond%3600%60+ "秒");
        }
    }
}
