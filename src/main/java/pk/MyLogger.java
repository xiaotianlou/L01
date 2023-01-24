package pk;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class MyLogger {
    public static Logger log = LogManager.getLogger(logtest.class);
    public static void changeLoggerLevel(String level) {
        // String loggerFactoryClassStr =
        // StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr();
        // System.out.println("loggerFactoryClassStr>>>>" + loggerFactoryClassStr);

        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);

        switch (level) {
            case "debug":
                loggerConfig.setLevel(Level.DEBUG);
                break;
            case "info":
                loggerConfig.setLevel(Level.INFO);
                break;
            case "warn":
                loggerConfig.setLevel(Level.WARN);
                break;
            case "error":
                loggerConfig.setLevel(Level.ERROR);
                break;
            case"fatal":
                loggerConfig.setLevel(Level.FATAL);
            case"trace":
                loggerConfig.setLevel(Level.TRACE);
            default:
                break;
        }
        ctx.updateLoggers();
    }
}
