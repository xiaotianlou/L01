package pk;



import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.module.Configuration;

public class logtest {

//static Logger log = LogManager.getLogger(logtest.class.getName());

    public static void main(String[] args) {
        Logger log = LogManager.getLogger(logtest.class);

        log.error("dsafghj11");
        log.trace("afdsghjk");
        log.fatal("afsdgh");



    }


}
