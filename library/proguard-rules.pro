# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/letv/android-sdk/android-sdk-macosx/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#-classobfuscationdictionary classobfuscationdictionary.txt
-printconfiguration print_config.txt


-optimizationpasses 5
-dontoptimize
-dontshrink
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes JavascriptInterface
-keepattributes Exceptions,InnerClasses
#-renamesourcefileattribute adsourceFile
#打印异常堆栈源码和行数，便于排查问题
-keepattributes SourceFile,LineNumberTable
#-keepattributes LineNumberTable
#-ignorewarnings
#
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keepclasseswithmembernames class * {
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
  public static final android.os.Parcelable$Creator *;
}
 -keep public class android.support.**{
 *;
 }
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes JavascriptInterface
-keepattributes Exceptions,InnerClasses
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
 -keep public class com.nostra13.universalimageloader.**{
 *;
 }
 -keep public class com.google.zxing.**{
    *;
 }
  -keep public class com.letv.ads.**{
  *;
  }
  -keep public class com.letv.plugin.pluginloader.**{
      *;
   }
  -keep public class com.letv.ad.demo.utils.AdEventUtils{
      *;
   }

    -dontwarn com.letv.ads.**
    -dontwarn com.letv.plugin.pluginloader.**
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}
-dontwarn android.support.**
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
#
