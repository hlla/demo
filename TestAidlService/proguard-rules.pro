# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses



-keepattributes *Annotation*

-keepclassmembers class **.R$* {
    public static <fields>;
}

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**



####################################Public Rules###########################################
#-applymapping proguard/mapping/mapping.txt
#-applymapping build/outputs/mapping/debug/mapping.txt
-printmapping print_map.txt
-obfuscationdictionary obfuscationdictionary.txt
-classobfuscationdictionary classobfuscationdictionary.txt
#-printconfiguration print_config


-optimizationpasses 5
-dontoptimize
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-keepattributes Signature
#-keepattributes *Annotation*
-keepattributes JavascriptInterface
-keepattributes Exceptions,InnerClasses
#-ignorewarnings
#
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keepclasseswithmembers class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
   public   android.os.Parcelable$Creator *;
 }
-keep public class com.letv.adsdk.ui.activity.LetvWebViewActivity{
    public <fields>;
    public <methods>;
}
-keep public class com.letv.adsdk.ui.view.AdView{
    public <fields>;
    public <methods>;
}