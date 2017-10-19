package com.example;

import java.lang.management.ManagementFactory;

/**
 * Created by chengjian on 17-8-30.
 */
public class TestRegular {
    static int m = 0;
    public static final String STACK_TRACE_EXPRESSION = "(?:.*?\\bat\\s+%c\\.%m\\s*\\(.*?(?::%l)" +
            "?\\)\\s*)|(?:(?:.*?[:\"]\\s+)?%c(?::.*)?)";

    private static final String REGEX_CLASS = "\\b(?:[A-Za-z0-9_$]+\\.)*[A-Za-z0-9_$]+\\b";
    private static final String REGEX_CLASS_SLASH = "\\b(?:[A-Za-z0-9_$]+/)*[A-Za-z0-9_$]+\\b";
    private static final String REGEX_LINE_NUMBER = "\\b[0-9]+\\b";
    private static final String REGEX_TYPE = REGEX_CLASS + "(?:\\[\\])*";
    private static final String REGEX_MEMBER = "<?\\b[A-Za-z0-9_$]+\\b>?";
    private static final String REGEX_ARGUMENTS = "(?:" + REGEX_TYPE + "(?:\\s*,\\s*" +
            REGEX_TYPE + ")*)?";
    //    static String a = "(?:.*?\\bat\\s+(\\b(?:[A-Za-z0-9_$]+\\.)" +
//            "*[A-Za-z0-9_$]+\\b)" +
//            "\\.(<?\\b[A-Za-z0-9_$]+\\b>?)\\s*\\(.*?(?::(\\b[0-9]+\\b))?\\)\\s*)|(?:(?:" +
//            ".*?[:\"]\\s+)?(\\b(?:[A-Za-z0-9_$]+\\.)*[A-Za-z0-9_$]+\\b)(?::.*)?)";
    static String a = "(?:.*?\\b(?:at|references|(?:GC ROOT [a-z0-9A-Z]+))\\s+(\\b" +
            "(?:[A-Za-z0-9_$]+\\.)*[A-Za-z0-9_$]+\\b)\\." + "(<?\\b([A-Za-z0-9_$]+)\\b>?)\\s*)";

    static String bb = "(?:.*?\\b(at|references|(GC ROOT [a-z0-9A-Z]+))\\s+(\\b" +
            "(?:[A-Za-z0-9_$]+\\.)*[A-Za-z0-9_$]+\\b)\\.(<?\\b[A-Za-z0-9_$]+\\b>?)\\s*)" +
            "|(?:(?:.*?[:\"]\\s+)" +
            "?(\\b(?:[A-Za-z0-9_$]+\\.)*[A-Za-z0-9_$]+\\b)(?::.*)?)";
    static String cc = "(?:.*?\\b(?:at|references|(?:GC ROOT [a-z0-9A-Z]+))\\s+(\\b" +
            "(?:[A-Za-z0-9_$]+\\.)*[A-Za-z0-9_$]+\\b)\\." +
            "(<?\\b[A-Za-z0-9_$]+\\b>?)\\s*\\(.*?(?::(\\b[0-9]+\\b))?\\)\\s*)";
    static String b = "(?:.*?\\b(GC ROOT [a-z0-9A-Z]+))\\s+aa";

    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid);
        m++;
        System.out.println("m=" + m);
        while (true) {

        }
//        System.out.println("m=" + m);
//        Pattern pattern = Pattern.compile(cc);
////        Matcher matcher = pattern.matcher("* references com.ksmobile.launcher.LauncherAppState
//// .c" +
////                "(Unknown " +
////                "Source)");
////        System.out.println(matcher.matches());
////        Matcher matcher1 = pattern.matcher("* GC ROOT com.android.internal.policy" +
////                ".PhoneWindow$DecorView.mContext");
////        System.out.println("GC" + matcher1.matches());
////        Matcher matcher2 = pattern.matcher(" * references com.ksmobile.launcher.wizard" +
////                ".ProRatingWizardManager.a");
//        Matcher matcher2 = pattern.matcher("references letv.com.testanr.b.b.ab()");
//        System.out.println("references5=" + matcher2.matches() + " num=" + matcher2.groupCount());
//        for (int expressionTypeIndex = 0; expressionTypeIndex < matcher2.groupCount();
//             expressionTypeIndex++) {
//            System.out.println("group=" + matcher2.group(expressionTypeIndex));
//        }
//        Matcher matcher5 = pattern.matcher("* references com.ksmobile.launcher.LauncherAppState
// .a");
//        System.out.println("references5=" + matcher5.matches());
//        Matcher matcher3 = pattern.matcher(" * GC ROOT static android.view.inputmethod" +
//                ".InputMethodManager.sInstance");
//        System.out.println(" GC ROOT=" + matcher3.matches());
//        Matcher matcher6 = pattern.matcher("* at com.ksmobile.launcher.LauncherAppState.c");
//        System.out.println("at=" + matcher6.matches());
//
//        Pattern pattern1 = Pattern.compile(b);
//        Matcher matcher4 = pattern1.matcher("* GC ROOT 1sssstad11atic11 a");
//        System.out.println(matcher4.matches());
////        Pattern pattern2 = Pattern.compile("industr(?:y|ies)+ddd\\s+a\\s+(\\b(w|a)\\s)+\\b
/// (m|e)");
//        Pattern pattern2 = Pattern.compile(a);
////        Pattern pattern2 = Pattern.compile(" (?:\\b(?:at|references|(?:GC ROOT [a-z0-9A-Z]+)))
//// +\\.+(([a-z0-9A-Z]+))");
////        Matcher matcher11 = pattern2.matcher("industryddd a w ea");
//        Matcher matcher11 = pattern2.matcher("* GC ROOT static com.ksmobile.launcher.wizard" +
//                ".ProRatingWizardManager$a.a");
////        Matcher matcher11 = pattern2.matcher(" references.dsd");
//        System.out.println("matcher11=" + matcher11.matches() + " matcher11.groupCount()=" +
//                matcher11.groupCount());
//        for (int expressionTypeIndex = 0; expressionTypeIndex < matcher11.groupCount();
//             expressionTypeIndex++) {
//            System.out.println("groupssss=" + matcher11.group(expressionTypeIndex));
//        }
    }
}
