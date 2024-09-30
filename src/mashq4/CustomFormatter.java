package mashq4;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append("Level: ").append(record.getLevel()).append(",");
        sb.append("Thread: ").append(record.getLongThreadID()).append(",");
        sb.append("Name: ").append(record.getLoggerName()).append(",");
        sb.append("Message: ").append(record.getMessage()).append("\n");

        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            record.getThrown().printStackTrace(pw);
            sb.append(sw);
        }

        return "";

    }
}
