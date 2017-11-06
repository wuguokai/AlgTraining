import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WUGUOKAI on 2017/10/27.
 */
public class testKaoQin {
    public static void main(String[] args){
        String startDate = "2017-10-06";
        String startTime = "23:00";
        String endDate ="2017-10-08";
        String endTime = "22:00";
        Map<String, String> ondutydateMap = new HashMap<>();
        Map<String, String> offdutydateMap = new HashMap<>();
        Map<String, Double> hoursMap = new HashMap<>();
        ondutydateMap.put("2017-10-06", "19:52");
        offdutydateMap.put("2017-10-06", "23:02");
        ondutydateMap.put("2017-10-07", "");
        offdutydateMap.put("2017-10-07", "");
        ondutydateMap.put("2017-10-08", "21:58");
        offdutydateMap.put("2017-10-08", "08:00");
        hoursMap.put("2017-10-05", 0d);
        hoursMap.put("2017-10-06", 9d);
        hoursMap.put("2017-10-07", 12d);
        hoursMap.put("2017-10-08", 2d);
        hoursMap.put("2017-10-09", 0d);
        String ondutydate;
        String offdutydate;


        String startTimeDate = timeForDate(startDate, startTime);//开始时间对应的日期
        String endTimeDate = timeForDate(endDate, endTime);//结束时间对应的日期

        for(String date = addDate(startDate,-1);dayDiff(date,endDate)>=0;date=addDate(date,1)) {//根据日期循环
            ondutydate = ondutydateMap.get(date);
            offdutydate = offdutydateMap.get(date);
            Double hours = hoursMap.get(date);
            Double dutyHours;
            if (hours > 0 ){
                if(date.equals(startDate)) { //是开始日期
                    dutyHours =getDutyHours(date,startTimeDate,endTimeDate,ondutydate,offdutydate,startTime,endTime);
                    System.out.println(date +"在职时间 : "+dutyHours);
                }else{//不是开始日期
                    dutyHours =getDutyHours(date,startTimeDate,endTimeDate,ondutydate,offdutydate,startTime,endTime);
                    System.out.println(date +"在职时间 : "+dutyHours);
                }
            }

        }

    }

    //计算日期时间差值
    public static double datetimeDiff(String startTime, String endTime){
//        basebean.writeLog("===================startTime , endTime  "+ startTime+" , "+endTime);
        double hour = 0;
        if(!"".equals(startTime) && !"".equals(endTime)) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date begin = df.parse(startTime);
                Date end = df.parse(endTime);
                System.out.println("===================begin:  end" + begin + " : " + end);
                System.out.println("===================begin:  end.gettime" + begin.getTime() + " : " + end.getTime());
                double between = (end.getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
                System.out.println("===================between：" + between);
                hour = between / 3600;
            } catch (Exception e) {
            }
        }
//        basebean.writeLog("===================日期时间差值结果hour："+ hour);

        return hour;
    }

    //计算时间差值
    public static double timeDiff(String startTime, String endTime){
//        basebean.writeLog("===================startTime , endTime  "+ startTime+" , "+endTime);
        SimpleDateFormat   df   =   new   SimpleDateFormat("HH:mm");
        double hour = 0;
        try{
            Date   begin=df.parse(startTime);
            Date   end   =   df.parse(endTime);
            double   between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
            hour=between/3600;
        }catch (Exception e)
        {
        }
//        basebean.writeLog("===================时间差值结果hour："+ hour);
        if(hour>=0){
            return hour;
        }else{
            return 24+hour;
        }
    }

    //时间比较
    public static int timeCompare(String startTime, String endTime){
//        basebean.writeLog("===================startTime , endTime"+ startTime+" , "+endTime);
        SimpleDateFormat   df   =   new   SimpleDateFormat("HH:mm");
        int   minute = 0;
        try{
            Date   begin=df.parse(startTime);
            Date   end   =   df.parse(endTime);
            double  between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
            minute=(int) (between/60);
        }catch (Exception e)
        {
        }
//        basebean.writeLog("===================时间比较结果minute："+ minute);

        return minute;
    }

    //计算日期差值
    public static int dayDiff(String startDate, String endDate){
        SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");
        int days = 0;
        try{
            Date   begin=df.parse(startDate);
            Date   end   =   df.parse(endDate);

            double  between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
            days=(int) (between/(24*3600));
        }catch (Exception e)
        {
        }
//        basebean.writeLog("===================日期差值days："+ days);
        return days;
    }

    //时间加上diff小时数
    public static String addTime(String time, double diff ){
        String value = null;
        int diffmin = (int) (diff*60);	//小时转换成分钟
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");//格式化
            Date inDate = sdf.parse(time);
            Calendar calendar = Calendar.getInstance();// 输入时间
            calendar.setTime(inDate);
            calendar.add(Calendar.MINUTE, diffmin);//加diffmin分钟

            Date outDate = calendar.getTime();
            value = sdf.format(outDate);
        }catch (Exception e) {
        }
//        basebean.writeLog("===================时间加上小时数的计算结果value："+ value);
        return value;
    }

    //日期加上天数
    public static String addDate(String date, int diff){
        String value = null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//格式化
            Date inDate = sdf.parse(date);
            Calendar calendar = Calendar.getInstance();// 输入时间
            calendar.setTime(inDate);
            calendar.add(Calendar.DATE, diff);//加diff天

            Date outDate = calendar.getTime();
            value = sdf.format(outDate);
        }catch (Exception e) {
        }
//        basebean.writeLog("===================日期加上天数的计算结果value："+ value);
        return value;
    }

    //跨天的日期转换
    public static String timeTran(String time, String date){
        String dateTime;
        if(timeCompare("08:00", time)>0){
            dateTime = date+" "+time;
        }else{
            dateTime = addDate(date, 1)+" "+time;
        }
//        basebean.writeLog("===================跨天时间转换的结果："+ dateTime);
        return dateTime;
    }
    //根据8班别请假的时间和日期，判断请假时间属于哪个日期
    public static String timeForDate(String date, String time){
        String timeDate = "";
        if(timeCompare("08:00", time) > 0){//大于8点的就是今天的日期
            timeDate = date;
        }else{//在8点前的就是昨天的日期
            timeDate = addDate(date, -1);
        }
        return timeDate;
    }

    public static Double getDutyHours(String date, String startTimeDate, String endTimeDate, String ondutydate, String offdutydate, String startTime, String endTime){
        String time1;
        String time2;
        Double dutyHours;
        if(date.equals(startTimeDate)){
            //取打卡和请假时间较早的计算有效时长
            if(!"".equals(ondutydate) && datetimeDiff(timeTran(startTime, date), timeTran(ondutydate, date))<0 ){
                time1 = timeTran(ondutydate, date);
            }else{
                time1 = timeTran(startTime, date);
            }
        }else{
            if (dayDiff(date, startTimeDate)<0){
                time1 = timeTran("20:00", date);
            }else {
                if (!"".equals(ondutydate))
                    time1 = timeTran(ondutydate, date);
                else
                    time1 = null;
            }
        }
        if (date.equals(endTimeDate)){
            if(!"".equals(offdutydate) && datetimeDiff(timeTran(endTime, date), timeTran(offdutydate, date))>0){
                time2 = timeTran(offdutydate, date);
            }else{
                time2 = timeTran(endTime, date);
            }
        }else {
            if(dayDiff(date, endTimeDate)>0){//结束日期在今天之后，那就拿正常下班时间
                time2 = timeTran("08:00", date);
            }else{
                if (!"".equals(offdutydate))
                    time2 = timeTran(offdutydate, date);
                else
                    time2 = null;
            }
        }


        return dutyHours =datetimeDiff(time1, time2);
    }
}
