# This is a configuration file for ProGuard.
# http://proguard.sourceforge.net/index.html#manual/usage.html

# Optimizations: If you don't want to optimize, use the
# proguard-android.txt configuration file instead of this one, which
# turns off the optimization flags.  Adding optimization introduces
# certain risks, since for example not all optimizations performed by
# ProGuard works on all versions of Dalvik.  The following flags turn
# off various optimizations known to have issues, but the list may not
# be complete or up to date. (The "arithmetic" optimization can be
# used if you are only targeting Android 2.0 or later.)  Make sure you
# test thoroughly if you go this route.
#-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
#-optimizationpasses 5
#-allowaccessmodification
-dontpreverify



#-libraryjars 'mylibs/classes.jar'

# The remainder of this file is identical to the non-optimized version
# of the Proguard configuration file (except that the other file has
# flags to turn off optimization).

-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

-keepattributes *Annotation*,*JavascriptInterface*
-keepattributes SourceFile,LineNumberTable
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
-keep public class com.test.chengjian.customitem.AlertClockAppWidget
-keep public class com.test.chengjian.customitem.Clock3DAppWidget
-keep public class com.test.chengjian.widget.WrapWidthTextView
-keep public class * extends com.test.chengjian.move.OriginalDesktop
-keep public class * extends com.test.chengjian.movelog.OriginalDesktop
-keep class  com.test.chengjian.live_wallpaper.LiveWallpaperItem{*;}
-keep public class * extends com.test.chengjian.live_wallpaper.LiveWallpaperItem
-keepnames class * extends com.test.chengjian.customitem.CustomShortcutInfo
-keep public class * extends theme_engine.model.EntityNode
-keep public class com.engine.parser.lib.utils.Timer
-keep public class com.engine.parser.lib.utils.ValueInterpolator
-keep public class com.engine.parser.lib.utils.DValueInterpolator
-keepclassmembers public class * extends theme_engine.model.EntityNode {
    public static *** create(org.xmlpull.v1.XmlPullParser, theme_engine.model.EntityNode);
}
-keep public class * extends theme_engine.script.CommandParser.Command
-keepclassmembers public class * extends theme_engine.script.CommandParser.Command {
    public static *** create(org.xmlpull.v1.XmlPullParser, int);
}
-keepclassmembers class com.test.chengjian.theme.cmclub.WebAppInterfaceActivity {
    public *;
}
-keepclassmembers class com.test.chengjian.theme.cmclub.WebAppInterfaceThemeDetail {
    public *;
}
-keepclassmembers class com.test.chengjian.theme.cmclub.WebAppInterfaceThemeDIY {
    public *;
}
-keepclassmembers class com.test.chengjian.theme.cmclub.WebAppInterfaceWebView {
    public *;
}


# For native methods, see http://proguard.sourceforge.net/manual/examples.html#native
-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers class com.test.chengjian.menu.setting.CMClubActivity$Facebook {
   public *;
}
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int w(...);
    public static int d(...);
    public static int v(...);
    public static int i(...);
}
# keep cloudsdk's methods for native
-keep class com.hoi.netstat.NetStatJni { *; }
-keep class com.hoi.string.LocalString { *; }
-keep class com.hoi.antivirus.AntiVirusFunc { *; }

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# We want to keep methods in Activity that could be used in the XML attribute onClick
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
#-keepclassmembers enum * {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}
-keep class android.util.** { *; }
-keep class android.provider.** { *; }
-keep class android.os.** { *; }
-keep public class * extends android.os.*
-keepclassmembers class * implements android.os.Parcelable {
    static android.os.Parcelable$Creator CREATOR;
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
-keep class com.cmcm.gl.view.** {*;}
-keep class com.cmcm.gl.widget.** {*;}
-keep class com.cmcm.gl.engine.c3dengine.widget.** {*;}

# The support library contains references to newer platform versions.
# Don't warn about those in case this app is linking against an older
# platform version.  We know about them, and they are safe.
-dontwarn android.support.**
-dontwarn android.**
-dontwarn com.ijinshan.cloudsdk.**
-dontwarn com.appsflyer.**
-dontwarn com.cmcm.rtstub.**
-dontwarn dalvik.system.**
-dontwarn java.system.**
-dontwarn com.android.**
-dontwarn com.nineoldandroids.view.**
-dontwarn com.engine.parser.lib.widget.**

-dontwarn com.cmcm.adsdk.**
-dontwarn com.cmcm.adsdk.*
-dontwarn com.chengjian.**
-dontwarn com.facebook.ads.**
-keep class com.facebook.ads.**{*;}
-keep class  com.cmcm.adsdk.** { *;}
-keep class  com.chengjian.** { *;}

-keep class  com.mopub.nativeads.*{*;}
-keep class  com.mopub.common.**{*;}
-keep class  com.mopub.network.**{*;}
-dontwarn com.mopub.**
-keep class com.cmcm.adsdk.nativead.MopubNativeAdLoader{
        <fields>;
        <methods>;
}
-keep class com.mopub.mobileads.MoPubActivity{
        <fields>;
        <methods>;
}
-keep class com.mopub.mobileads.MraidActivity{
        <fields>;
        <methods>;
}
-keep class com.mopub.common.MoPubBrowser{
        <fields>;
        <methods>;
}
-keep class com.mopub.mobileads.MraidVideoPlayerActivity{
        <fields>;
        <methods>;
}

 -keep class com.cmcm.adsdk.nativead.FlurryNativeLoader{
    <fields>;
    <methods>;
 }

  -keep class * extends com.cmcm.onews.api.JavaScriptInterfaceBase {
         <fields>;
         <methods>;
  }

-keep class com.flurry.** { *; }
-dontwarn com.flurry.**
-keepattributes *Annotation*,EnclosingMethod
-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet, int);
}
#If you are using the Google Mobile Ads SDK, add the following:
# Preserve GMS ads classes
-keep class com.google.android.gms.ads.** { *; }
-dontwarn com.google.android.gms.ads.**
#If you are using the Google Play Services
# Preserve GMS classes to enable fetching the Advertising ID
-keep class com.google.android.gms.**
-keep class com.test.chengjian.widget.WallpaperView$StarInfo { *; }
-keep class com.test.chengjian.customitem.FolderIconJsHandler { *; }
-keep class com.test.chengjian.customitem.ThemeJsInterface { *; }

############ start for fresco ##############
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip

# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}

# Keep native methods
-keepclassmembers class * {
    native <methods>;
}

-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**
-dontwarn android.widget.ImageView
-dontwarn com.facebook.drawee.**
############ end for fresco ##############

-keepattributes SourceFile,LineNumberTable
-keep class com.parse.*{ *; }
-dontwarn com.parse.**
-dontwarn com.squareup.picasso.**
-keepclasseswithmembernames class * {
    native <methods>;
}

-keep class com.test.chengjian.menu.setting.provider.*

-keep class * extends java.util.ListResourceBundle {
        protected Object[][] getContents();
    }
-keep class com.google.ads.AdActivity{
        <fields>;
		<methods>;
    }
-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
        public static final *** NULL;
    }
-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
        @com.google.android.gms.common.annotation.KeepName *;
    }
-keepnames class * implements android.os.Parcelable {
        public static final ** CREATOR;
    }


    # 取消Keep住整个android.*之后，会有NoSuchMethodError问题，这里修正一下
    -keep public class android.service.notification.** { *; }
    -keep public class android.service.notification.StatusBarNotification { *; }
    -keep public interface android.service.notification.** { *; }
    -keep public class * extends android.service.notification.* { *; }
    -keep public class * implements android.service.notification.* { *; }

#### Start for Mobvista sdk
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.mobvista.** {*; }
-keep interface com.mobvista.** {*; }
-keep class android.support.v4.** { *; }
-keep class android.support.v7.** {* ;}
-dontwarn com.mobvista.**
-keep class **.R$* { public static final int mobvista*; }
#### End of Mobvista sdk

#### Start for mopub
-keep class com.mopub.**{*;}
-dontwarn com.mopub.**
#### End for mopub

#### batmobi
-keep class com.mnt.**{
*;
}
-dontwarn com.mnt.**
-keep class com.cmcm.adsdk.adapter.BatmobiNativeAdapter{*;}
-dontwarn com.cmcm.adsdk.adapter.BatmobiNativeAdapter.**
#### batmobi

#### Start for Eventbus
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
-keepclassmembers class ** {
    public void onEvent*(**);
}
-keep class com.ijinshan.screensavernew3.event.**
#### End for Eventbus

#Start NotificationCleaner
-dontwarn com.chengjian.ncmanager.ui.notifycleaner.view.fancleaner.NotificationCleaner
-dontwarn com.chengjian.ncmanager.ui.notifycleaner.view.fancleaner.CMLoadingSurface
-dontwarn com.chengjian.ncmanager.widget.WebViewEx
#End NotificationCleaner

#install
-keep class com.test.chengjian.view.SplashInstallSurfaceView{ *; }
-keep class com.test.chengjian.view.SplashInstallSurfaceView$Stars{ *; }
-keep class com.test.chengjian.crash_upload.CrashLogManager{ *; }
-keep class com.cmcm.launcher.utils.ThreadManager{*;}
-keep class com.test.business.sdk.utils.ThreadManager{*;}
-keep class com.chengjian.base.crash.**{*;}
-keep class com.chengjian.base.crash.util.a{*;}
-keep class com.test.business.sdk.utils.KSystemUtils{*;}
-keep class com.test.business.sdk.utils.ReflectUtil{*;}
-keep class com.test.business.sdk.wrapper.BusinessAdClient{*;}
#install

-dontwarn org.apache.*
-keep class org.apache.**{*;}

#-dontwarn com.google.android.collect.*
#-keep class com.google.android.collect.*
# facebook audience network
#-dontwarn com.facebook.*
#-keep class com.facebook.** { *; }
#-dontwarn bolts.*
#-keep class bolts.**{*;}


-keep public interface com.cmcm.IAction {
*;
}
# 视频sdk部分
-keepclasseswithmembers class com.cmcm.osvideo.sdk.player.youtubeplayer.BaseYoutubePlayer$OSPlayerJSCallBack {
    @android.webkit.JavascriptInterface
    public <methods>;
}
-dontwarn com.cmcm.orion.*
-keep class com.cmcm.orion.**{*;}

#-ignorewarnings
 #-dontwarn com.test.chengjian.wizard.*

# facebook audience network
-keep class com.facebook.** { *; }
#picks
-keep class com.cmcm.adsdk.adapter.PicksNativeAdapter{ *; }
#mopub
-keep class com.mopub.nativeads.MoPubCustomEventNative{ *; }
-keep class android.support.graphics.drawable.** { *; }

-keep class bolts.** {*;}

-dontwarn com.samsung.android.**
-keep class com.samsung.android.**  { *; }
-keep interface com.samsung.android.**  { *; }

# for dialer guava
-dontwarn com.google.common.**
# for dialer endCall
-keep interface com.android.internal.telephony.ITelephony{ *; }

# locker proguard
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends com.android.vending.licensing.ILicensingService
-keep public class * extends android.os.*
-keep public class * extends android.view.*
-keep public class * extends android.widget.*
-keep public class * extends android.content.*
-keep interface * extends android.*
-keep interface * extends com.android.*

## support-v4
-dontwarn android.support.v4.**
#-keep class android.support.v4.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

-dontwarn com.samsung.android.**
-keep class com.samsung.android.**  { *; }
-keep interface com.samsung.android.**  { *; }

-keep public class com.locker.theme.ThemeExpandViewPlugin { *; }
-keep public class com.locker.theme.plugin.KThemePlugin { *; }

-keep public interface com.cmcm.IAction {
*;
}

-dontwarn com.cmcm.adsdk.**
-dontwarn com.chengjian.**
-dontwarn com.facebook.ads.**
-keep class com.facebook.ads.**{*;}
-keep class com.cmcm.adsdk.** { *;}
-keep class com.chengjian.sdk.** { *;}
# 开启Proguard shrink后，会删除反射调用的方法，这里需要keep一下
-keep class com.chengjian.dao.** { *;}

-keep class com.cmcm.adsdk.nativead.FlurryNativeLoader{
    <fields>;
    <methods>;
 }
-keep class com.flurry.** { *; }
-dontwarn com.flurry.**
-keepattributes *Annotation*,EnclosingMethod
-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet, int);
}
#If you are using the Google Mobile Ads SDK, add the following:
# Preserve GMS ads classes
-keep class com.google.android.gms.ads.** { *; }
-dontwarn com.google.android.gms.ads.**

# Preserve GMS ads identifier classes
-keep class com.google.android.gms.ads.identifier.** {*;}


-keep public class com.ijinshan.cloudconfig.util.UtilsHelper.** { *;}

-dontwarn com.ijinshan.cloudconfig.util.**

-keep class javax.** { *; }
-keep class org.** { *; }
#-keep class android.support.v4.**
-keep class java.util.**
-keep class com.android.internal.** { *; }
#-keep class android.** { *; }
-keep interface android.** { *; }
-keep class android.os.** { *; }
-keep class android.app.** { *; }
-keep class android.content.** { *; }
-keep class com.baidu.location.** { *; }
-keep public class com.keniu.security.monitor.MonitorManager {*;}

-keep class com.google.android.gms.auth.GoogleAuthUtil.** { *; }


#-keep public class com.chengjian.ui.dialog.ClearTipDialogView.** { *; }

-keepattributes *Annotation*

-dontwarn com.makeramen.roundedimageview.**
-dontwarn com.baidu.location.**

-dontwarn javax.management.**
-dontwarn java.lang.management.**
-dontwarn org.apache.log4j.**
-dontwarn org.apache.commons.logging.**
-dontwarn org.slf4j.**
-dontwarn org.json.**
-dontwarn android.support.**
-dontwarn com.ijinshan.kingmob.**
-dontwarn android.content.pm.**
-dontwarn com.chengjian.cover.data.message.model.**
-dontwarn com.chengjian.ui.cover.LockerService$SysWindowController
-dontwarn com.chengjian.ui.cover.LockerService
-dontwarn com.chengjian.ui.cover.animationlist.widget.ViewCompatV7
-dontwarn com.facebook.ads.VideoAdActivity
-dontwarn com.facebook.ads.VideoAdActivity$1
-dontwarn com.facebook.ads.a.s
-dontwarn com.chengjian.util.SoundUtils

-dontwarn  com.chengjian.ui.cover.widget.AScrollableView.**
-dontwarn  com.chengjian.ui.widget.WeatherAlertLayout.**


-dontwarn com.chengjian.ui.widget.ViewCompat.**
-dontwarn com.google.android.gms.**

-dontwarn com.chengjian.util.TrimMemory

-dontwarn com.chengjian.ui.cover.checkMessagePermisssion

# launcher search
-dontwarn com.test.chengjian.search.webview.SearchWebView
-dontwarn com.test.chengjian.search.webview.KWebView

# EventBus
-keepclassmembers class ** {
    public void onEvent*(**);
}

# Only required if you use AsyncExecutor
-keepclassmembers class * extends de.greenrobot.event.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}

# Keep - Applications. Keep all application classes, along with their 'main'
# methods.
-keepclasseswithmembers public class * {
    public static void main(java.lang.String[]);
}

# Also keep - Enumerations. Keep the special static methods that are required in
# enumeration classes.
-keepclassmembers enum  * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Also keep - Database drivers. Keep all implementations of java.sql.Driver.
-keep class * extends java.sql.Driver

# Also keep - Swing UI L&F. Keep all extensions of javax.swing.plaf.ComponentUI,
# along with the special 'createUI' method.
-keep class * extends javax.swing.plaf.ComponentUI {
    public static javax.swing.plaf.ComponentUI createUI(javax.swing.JComponent);
}

# Keep names - Native method names. Keep all native class/method names.
-keepclasseswithmembers,allowshrinking class * {
    native <methods>;
}

# Remove - System method calls. Remove all invocations of System
# methods without side effects whose return values are not used.

-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * implements android.os.Parcelable {
    static android.os.Parcelable$Creator CREATOR;
}

# Preserve static fields of inner classes of R classes that might be accessed
# through introspection.

-keepclassmembers class **.R$* {
  public static <fields>;
}

# The Android Compatibility library references some classes that may not be
# present in all versions of the API, but we know that's ok.

-keepclasseswithmembernames class * {
    native <methods>;
}

# Preserve the special static methods that are required in all enumeration
# classes.

-keepclassmembers class * extends java.lang.Enum {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Your application may contain more items that need to be preserved;
# typically classes that are dynamically created using Class.forName:

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keep class com.chengjian.cleanhelper.a
-keepclassmembers class com.chengjian.cleanhelper.a{
  native <methods>;
  private *;
  public static java.lang.String b(java.lang.String, java.lang.String, int, java.lang.String);
}

-keep class com.chengjian.util.a
-keepclassmembers class com.chengjian.util.a{
  native <methods>;
  public static void a();
  public static void a(java.lang.String, java.lang.String);
  public static int b();
  public static java.lang.String c();
  public static java.lang.String a(byte[]);
}

-keep class com.chengjian.util.b
-keepclassmembers class com.chengjian.util.b{
  native <methods>;
}

-keep class com.chengjian.util.c
-keepclassmembers class com.chengjian.util.c{
  native <methods>;
}

-keep public interface com.chengjian.util.IProgressCtrl
-keepclasseswithmembernames class com.chengjian.util.IProgressCtrl {
  public boolean isStop();
}

-keep public interface com.chengjian.util.INameFilter
-keepclasseswithmembernames class com.chengjian.util.INameFilter {
  public boolean accept(java.lang.String, java.lang.String);
}



-keep class com.chengjian.util.CMFailedException
-keepclassmembers class com.chengjian.util.CMFailedException {
  public *;
}

# facebook audience network
-keep class com.facebook.** { *; }
-keepattributes Signature

-ignorewarnings

# for Inneractive classes
-keep class com.inneractive.api.ads.** {*;}

##---------------Begin: proguard configuration for Gson  ----------

# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

##---------------End: proguard configuration for Gson  ----------


# ************ For admob ************

-keep class com.cmcm.adsdk.nativead.AdmobNativeLoader{
      <fields>;
      <methods>;
}
-keep public class com.google.android.gms.ads.**{
    public *;
}
# For old ads classes
-keep public class com.google.ads.**{
    public *;
}

# For mediation
-keepattributes *Annotation*

# Other required classes for Google Play Services
# Read more at http://developer.android.com/google/play-services/setup.html
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
# ************ For admob ************


# for power-saver begin
-dontwarn com.chengjian.boost.acc.utils.DeviceUtils
-dontwarn com.chengjian.boost.powerengine.process.clond.ProcCloudScanTask
-dontwarn com.chengjian.cleancloud.core.base.CleanCloudDBBase
-dontwarn com.chengjian.util.PackageUtils

-dontwarn com.inneractive.api.ads.sdk.*
-dontwarn com.test.business.sdk.search.views.SearchController
-dontwarn com.test.business.sdk.search.webview.SearchWebView
-dontwarn com.test.business.sdk.search.views.*

# for power-saver end

-keepclassmembers class * {
     @android.webkit.JavascriptInterface <methods>;
 }

# for gesture unlock
-keep class com.chengjian.ui.cover.SlideToUnlockGesture$Bubble{
	*;
}

# for msg cloud rule
-keep public class com.chengjian.cloudconfig.msgcloudrule.MsgRuleGrammerParser{*;}
-keep public class com.chengjian.cloudconfig.msgcloudrule.StaticCommandMethod{*;}
-keep public class com.chengjian.cover.data.message.model.NotificationMethod{*;}

# 取消Keep住整个android.*之后，会有NoSuchMethodError问题，这里修正一下
-keep public class android.service.notification.** { *; }
-keep public class android.service.notification.StatusBarNotification { *; }
-keep public interface android.service.notification.** { *; }
-keep public class * extends android.service.notification.* { *; }
-keep public class * implements android.service.notification.* { *; }

# AppLock
-keep class com.chengjian.applocklib.base.AppLockLib {*;}
-keep class com.chengjian.applocklib.utils.AppLockUtil {*;}
-keep public interface com.chengjian.applocklib.interfaces.IAppLockLib
-keep class com.chengjian.applocklib.bridge.AppLockPref {*;}

# 广告新版sdk部分
 -keep class com.cmcm.adsdk.adapter.FacebookNativeAdapter{ *; }
 -keep class com.cmcm.adsdk.adapter.YahooNativeAdapter{ *; }
 -keep class com.cmcm.adsdk.adapter.MopubNativeAdapter{ *; }
 -keep class com.cmcm.adsdk.adapter.VKNativeAdapter{ *; }
 -keep class com.mopub.nativeads.MoPubCustomEventNative{ *; }
 -keep class com.cmcm.adsdk.adapter.AdmobNativeAdapter{ *; }
 -keep class com.cmcm.adsdk.adapter.PicksNativeAdapter{ *; }
 -keep class com.cmcm.adsdk.adapter.MopubBannerAdapter{ *; }
 -keep public class com.mopub.**{*;}
 -keep class android.support.graphics.drawable.** { *; }

# 视频sdk部分
-keepclasseswithmembers class com.cmcm.osvideo.sdk.player.youtubeplayer.BaseYoutubePlayer$OSPlayerJSCallBack {
    @android.webkit.JavascriptInterface
    public <methods>;
}

# 表情部分
-keep class com.locker.emoji.adapter.EmoticonsAdapter{ *;}

#batmobi ad
-keep class com.mnt.**{*;}

-keep class com.squareup.** {*;}
-keep interface com.squareup.** {*;}

-keep class com.test.leakcanary.leakanalyzer.** {*;}
-keep class com.test.leakcanary.report.** {*;}
-keep interface com.test.leakcanary.report.** {*;}
-keep class com.chengjian.base.crash.DexPathInfo.** {*;}

-keep class com.microsoft.bing.** {*;}
-keep class com.microsoft.cortana.** {*;}
-keep class uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.** {*;}
-keep class com.test.thirdsdk.cortana.inter.CortanaInfocConstants.** {*;}
-keep class com.test.thirdsdk.cortana.utils.CortanaUtils.** {*;}

#for juhe sdk
-keep class com.cmcm.adsdk.nativead.**{*;}
-keep class com.cmcm.adsdk.interstitial.**{*;}
-keep class com.cmcm.adsdk.adapter.FacebookInterstitialAdapter{ *; }
-keep class com.cmcm.adsdk.adapter.AdmobInterstitialAdapter{ *; }

#for textone sdk
-keepnames class com.cmcm.textone.sdk.message.TimelineFragment