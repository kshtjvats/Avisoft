package TaskManagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Task
{
    private String title,deadline;
    private boolean isDone=false;
    Task(String title,String deadline)
    {
        this.title=title;
        this.deadline=deadline;
    }
    void setTitle(String title)
    {
        this.title=title;
    }
    void setDeadline(String deadline)
    {
        this.deadline=deadline;
    }
    String getTaskTitle()
    {
        return title;
    }
    String getDeadline()
    {
        return deadline;
    }
    void setDoneStatus()
    {
        this.isDone=true;
    }
    boolean getStatus()
    {
        return isDone;
    }
    void showDetailsOfTask()
    {
        System.out.println("*********************");
        System.out.println("Task title : "+getTaskTitle());
        System.out.println("Task Deadline : "+getDeadline());
        System.out.println("*********************");
    }
       
    int deadlineCalculator ()
    {
    String input=getDeadline();
    LocalDateTime inputDateTime = parseDateTime(input);
    LocalDateTime currentDateTime = LocalDateTime.now();
    int comparisonResult = compareDateTime(inputDateTime, currentDateTime);
    if (inputDateTime != null) {
        currentDateTime = LocalDateTime.now();
        comparisonResult = compareDateTime(inputDateTime, currentDateTime);
    }
    else {
        System.out.println("Invalid date and time format");
    }
    return comparisonResult;
}
        void oneMinuteCalculate()
        {
        String input=getDeadline();
        int flag=0;
        LocalDateTime inputDateTime = parseDateTime(input);
        LocalDateTime currentDateTime = LocalDateTime.now();
        int comparisonResult = compareDateTime(inputDateTime, currentDateTime);
        if (inputDateTime != null) {
            while(comparisonResult!=-1)
            {
            currentDateTime = LocalDateTime.now();
            comparisonResult = compareDateTime(inputDateTime, currentDateTime);
            // Check if 1 minute left
            long minutesDifference = currentDateTime.until(inputDateTime, java.time.temporal.ChronoUnit.MINUTES);
            if(flag==0)
            {
            if (minutesDifference < 1) {
                System.out.println("1 minute left for Assignment:"+getTaskTitle());
                flag=1;
            }
            }
        }
        } else {
            System.out.println("Invalid date and time format");
        }
    }
        public static LocalDateTime parseDateTime(String input) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM uuuu h:mm a");
            try {
                return LocalDateTime.parse(input, formatter);
            } catch (Exception e) {
                return null;
            }
        }
    
        public static int compareDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
            return dateTime1.compareTo(dateTime2);
        }
    }
