package pk;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

public class logtest {


    public static void main(String[] args) {
    MyLogger.log.fatal("asdgfhf");
    MyLogger.log.trace("asfdghj234rt5678");
        System.out.println();
    MyLogger.changeLoggerLevel("trace");
        MyLogger.log.fatal("asdgfhf");
        MyLogger.log.trace("asfdghj234rt5678");
        System.out.println();
        MyLogger.changeLoggerLevel("fatal");
        MyLogger.log.fatal("asdgfhf");
        MyLogger.log.trace("asfdghj234rt5678");


    }

}
