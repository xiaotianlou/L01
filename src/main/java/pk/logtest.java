package pk;


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
