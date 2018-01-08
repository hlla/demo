package com.android.launcher2;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.secutil.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomescreenWallpaperOptionsDialogFragment
  extends DialogFragment
{
  public static final int BOTH_POSITION = 2;
  public static final int HOMESCREEN_POSITION = 0;
  public static final int IMAGE_PICK = 5;
  private static final String IMAGE_TYPE = "image/*";
  public static final String KEYGUARD_CATEGORY_CLASS_NAME = "com.samsung.android.keyguardwallpaperupdator.ui.KeyguardCategoriesEntryActivity";
  public static final String KEYGUARD_PACKAGE_NAME = "com.samsung.android.keyguardwallpaperupdator";
  public static final String KEYGUARD_PHOTO_SLIDE_CLASS_NAME = "com.samsung.android.keyguardwallpaperupdator.ui.KeyguardPhotoSlideMainActivity";
  public static final String LIVE_WALLPAPER_CLASS_NAME = "com.android.wallpaper.livepicker.LiveWallpaperActivity";
  public static final String LIVE_WALLPAPER_PACKAGE_NAME = "com.android.wallpaper.livepicker";
  public static final String LIVE_WEATHER_CLASS_NAME = "com.yahoo.mobile.client.android.liveweather.MainActivity";
  public static final String LIVE_WEATHER_PACKAGE_NAME = "com.yahoo.mobile.client.android.liveweather";
  public static final int LOCKSCREEN_POSITION = 1;
  private static final String TAG = "HomescreenWallpaperOptionsDialogFragment";
  protected static int currentMode = 0;
  public static boolean isHomeScreenWallpaperDialogVisible = false;
  private static final String sFragmentTag = "HomescreenWallpaperOptionsDialogFragment";
  Context context = null;
  private boolean isResultSuccess = false;
  private ImageView ivKeyword;
  private ImageView ivLocationWeather;
  private ImageView ivPhotoSlide;
  private LinearLayout llBottomContainer;
  private LinearLayout llDefaultImage;
  private LinearLayout llKeyword;
  private LinearLayout llLiveWallpaper;
  private LinearLayout llLocationWeather;
  private LinearLayout llMoreImage;
  private LinearLayout llPhotoSlide;
  private Launcher mLauncher;
  
  static void createAndShow(FragmentManager paramFragmentManager, int paramInt)
  {
    if ((paramFragmentManager != null) && (isActive(paramFragmentManager))) {}
    HomescreenWallpaperOptionsDialogFragment localHomescreenWallpaperOptionsDialogFragment;
    do
    {
      return;
      currentMode = paramInt;
      localHomescreenWallpaperOptionsDialogFragment = new HomescreenWallpaperOptionsDialogFragment();
    } while (paramFragmentManager == null);
    localHomescreenWallpaperOptionsDialogFragment.show(paramFragmentManager, "HomescreenWallpaperOptionsDialogFragment");
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("HomescreenWallpaperOptionsDialogFragment");
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  private void finishHelpWallpaperGuide()
  {
    if ((this.mLauncher != null) && (this.mLauncher.mHomeView != null) && (Launcher.isHelpAppRunning))
    {
      this.mLauncher.mHomeView.closeQuickViewWorkspace(true);
      this.mLauncher.finishWallpaperGuide(this.isResultSuccess);
    }
  }
  
  private Drawable getAppIcon(String paramString)
  {
    try
    {
      paramString = getActivity().getPackageManager().getApplicationIcon(paramString);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      Drawable localDrawable = getResources().getDrawable(2130837692);
      paramString.printStackTrace();
      return localDrawable;
    }
  }
  
  public static int getDisplayHeight(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.heightPixels;
  }
  
  public static int getDisplayWidth(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    return paramFragmentManager.findFragmentByTag("HomescreenWallpaperOptionsDialogFragment") != null;
  }
  
  private void launchTargetApp(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(ComponentName.unflattenFromString(paramString));
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.setFlags(268435456);
    startActivity(localIntent);
  }
  
  private Intent makeIntent(Uri paramUri)
  {
    int i = 1024;
    int j;
    int k;
    label41:
    float f1;
    float f2;
    label67:
    Object localObject2;
    Object localObject1;
    if (currentMode == 0)
    {
      i = 1024;
      j = this.context.getWallpaperDesiredMinimumWidth();
      k = this.context.getWallpaperDesiredMinimumHeight();
      if (j <= k) {
        break label269;
      }
      if (i != 1026) {
        break label276;
      }
      f1 = getDisplayWidth(this.context);
      f2 = getDisplayHeight(this.context);
      localObject2 = new ComponentName("com.sec.android.gallery3d", "com.sec.android.gallery3d.app.CropImage");
      if (i != 1024) {
        break label334;
      }
      localObject1 = "com.android.camera.action.CROP";
      label95:
      paramUri = new Intent((String)localObject1).setComponent((ComponentName)localObject2).setDataAndType(paramUri, "image/*").putExtra("outputX", j).putExtra("outputY", j).putExtra("aspectX", j).putExtra("aspectY", j).putExtra("spotlightX", f1).putExtra("spotlightY", f2).putExtra("scale", true).putExtra("noFaceDetection", true);
      if (i != 1024) {
        break label342;
      }
      bool = true;
      label187:
      paramUri = paramUri.putExtra("set-as-wallpaper", bool);
      if (i != 1025) {
        break label348;
      }
      bool = true;
      label208:
      paramUri = paramUri.putExtra("set-as-lockscreen", bool);
      if (i != 1026) {
        break label354;
      }
    }
    label269:
    label276:
    label334:
    label342:
    label348:
    label354:
    for (boolean bool = true;; bool = false)
    {
      return paramUri.putExtra("set-as-bothscreen", bool);
      if (currentMode == 1)
      {
        i = 1025;
        break;
      }
      if (currentMode != 2) {
        break;
      }
      i = 1026;
      break;
      j = k;
      break label41;
      localObject1 = ((Activity)this.context).getWindowManager().getDefaultDisplay();
      localObject2 = new Point();
      ((Display)localObject1).getSize((Point)localObject2);
      f1 = ((Point)localObject2).x / j;
      f2 = ((Point)localObject2).y / j;
      break label67;
      localObject1 = "com.sed.android.gallery3d.CROP_SEC_ONLY";
      break label95;
      bool = false;
      break label187;
      bool = false;
      break label208;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 5) && (paramInt2 == -1))
    {
      if ((paramIntent != null) && (paramIntent.getData() != null))
      {
        paramIntent = makeIntent(paramIntent.getData());
        if (paramIntent == null) {}
      }
      try
      {
        startActivityForResult(paramIntent, 1027);
        return;
      }
      catch (ActivityNotFoundException paramIntent)
      {
        Toast.makeText(this.context, 2131755010, 0).show();
        return;
      }
      catch (SecurityException localSecurityException)
      {
        Toast.makeText(this.context, 2131755010, 0).show();
        Log.e("HomescreenWallpaperOptionsDialogFragment", "Launcher does not have the permission to launch " + paramIntent, localSecurityException);
        return;
      }
    }
    if ((paramInt1 == 1027) && (paramInt2 == -1))
    {
      this.isResultSuccess = true;
      dismiss();
      return;
    }
    dismiss();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(final Bundle paramBundle)
  {
    paramBundle = getActivity();
    this.context = paramBundle;
    this.mLauncher = ((Launcher)this.context);
    Object localObject = View.inflate(paramBundle, 2130903079, null);
    this.llDefaultImage = ((LinearLayout)((View)localObject).findViewById(2131689567));
    this.llMoreImage = ((LinearLayout)((View)localObject).findViewById(2131689570));
    this.llLiveWallpaper = ((LinearLayout)((View)localObject).findViewById(2131689573));
    this.llKeyword = ((LinearLayout)((View)localObject).findViewById(2131689576));
    this.llLocationWeather = ((LinearLayout)((View)localObject).findViewById(2131689580));
    this.llPhotoSlide = ((LinearLayout)((View)localObject).findViewById(2131689583));
    this.llBottomContainer = ((LinearLayout)((View)localObject).findViewById(2131689579));
    this.ivKeyword = ((ImageView)((View)localObject).findViewById(2131689577));
    this.ivLocationWeather = ((ImageView)((View)localObject).findViewById(2131689581));
    this.ivPhotoSlide = ((ImageView)((View)localObject).findViewById(2131689584));
    this.ivKeyword.setImageDrawable(getAppIcon("com.samsung.android.keyguardwallpaperupdator"));
    this.ivLocationWeather.setImageDrawable(getAppIcon("com.yahoo.mobile.client.android.liveweather"));
    this.ivPhotoSlide.setImageDrawable(getAppIcon("com.samsung.android.keyguardwallpaperupdator"));
    AlertDialog.Builder localBuilder;
    if (currentMode == 1)
    {
      this.llLiveWallpaper.setVisibility(8);
      this.llBottomContainer.setVisibility(0);
      this.llKeyword.setVisibility(0);
      this.llLocationWeather.setVisibility(0);
      this.llPhotoSlide.setVisibility(0);
      localBuilder = new AlertDialog.Builder(paramBundle);
      if (currentMode != 2) {
        break label448;
      }
      localBuilder.setTitle(getString(2131755027));
    }
    for (;;)
    {
      localBuilder.setView((View)localObject);
      localObject = localBuilder.create();
      ((Dialog)localObject).setCanceledOnTouchOutside(true);
      this.llDefaultImage.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ((Launcher)paramBundle).mHomeView.startWallpaper(HomescreenWallpaperOptionsDialogFragment.currentMode);
          HomescreenWallpaperOptionsDialogFragment.this.dismiss();
        }
      });
      this.llMoreImage.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent("android.intent.action.GET_CONTENT");
          paramAnonymousView.setType("image/*");
          ComponentName localComponentName = new ComponentName("com.sec.android.gallery3d", "com.sec.android.gallery3d.app.GalleryActivity");
          if ((HomescreenWallpaperOptionsDialogFragment.currentMode == 1) || (HomescreenWallpaperOptionsDialogFragment.currentMode == 2)) {
            paramAnonymousView.setComponent(localComponentName);
          }
          paramAnonymousView.putExtra("set-as-wallpaper", true);
          try
          {
            HomescreenWallpaperOptionsDialogFragment.this.startActivityForResult(paramAnonymousView, 5);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            Toast.makeText(paramBundle, 2131755010, 0).show();
            return;
          }
          catch (SecurityException localSecurityException)
          {
            Toast.makeText(paramBundle, 2131755010, 0).show();
            Log.e("HomescreenWallpaperOptionsDialogFragment", "Launcher does not have the permission to launch " + paramAnonymousView, localSecurityException);
          }
        }
      });
      this.llLiveWallpaper.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            paramAnonymousView = new Intent("android.intent.action.MAIN");
            paramAnonymousView.setComponent(ComponentName.unflattenFromString("com.android.wallpaper.livepicker/com.android.wallpaper.livepicker.LiveWallpaperActivity"));
            paramAnonymousView.addCategory("android.intent.category.LAUNCHER");
            paramAnonymousView.setFlags(268435456);
            if ((HomescreenWallpaperOptionsDialogFragment.currentMode == 2) || (HomescreenWallpaperOptionsDialogFragment.currentMode == 1)) {
              paramAnonymousView.putExtra("SET_LOCKSCREEN_WALLPAPER", true);
            }
            HomescreenWallpaperOptionsDialogFragment.this.startActivity(paramAnonymousView);
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
            }
          }
          catch (SecurityException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
              Log.e("HomescreenWallpaperOptionsDialogFragment", "Launcher does not have the permission to launch com.android.wallpaper.livepicker/com.android.wallpaper.livepicker.LiveWallpaperActivity");
            }
          }
          HomescreenWallpaperOptionsDialogFragment.this.dismiss();
        }
      });
      this.llKeyword.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            HomescreenWallpaperOptionsDialogFragment.this.launchTargetApp("com.samsung.android.keyguardwallpaperupdator/com.samsung.android.keyguardwallpaperupdator.ui.KeyguardCategoriesEntryActivity");
            HomescreenWallpaperOptionsDialogFragment.this.dismiss();
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
            }
          }
          catch (SecurityException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
              Log.e("HomescreenWallpaperOptionsDialogFragment", "Launcher does not have the permission to launch com.samsung.android.keyguardwallpaperupdator/com.samsung.android.keyguardwallpaperupdator.ui.KeyguardCategoriesEntryActivity");
            }
          }
        }
      });
      this.llLocationWeather.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            HomescreenWallpaperOptionsDialogFragment.this.launchTargetApp("com.yahoo.mobile.client.android.liveweather/com.yahoo.mobile.client.android.liveweather.MainActivity");
            HomescreenWallpaperOptionsDialogFragment.this.dismiss();
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
            }
          }
          catch (SecurityException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
              Log.e("HomescreenWallpaperOptionsDialogFragment", "Launcher does not have the permission to launch com.yahoo.mobile.client.android.liveweather/com.yahoo.mobile.client.android.liveweather.MainActivity");
            }
          }
        }
      });
      this.llPhotoSlide.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            HomescreenWallpaperOptionsDialogFragment.this.launchTargetApp("com.samsung.android.keyguardwallpaperupdator/com.samsung.android.keyguardwallpaperupdator.ui.KeyguardPhotoSlideMainActivity");
            HomescreenWallpaperOptionsDialogFragment.this.dismiss();
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
            }
          }
          catch (SecurityException paramAnonymousView)
          {
            for (;;)
            {
              Toast.makeText(paramBundle, 2131755010, 0).show();
              Log.e("HomescreenWallpaperOptionsDialogFragment", "Launcher does not have the permission to launch com.samsung.android.keyguardwallpaperupdator/com.samsung.android.keyguardwallpaperupdator.ui.KeyguardPhotoSlideMainActivity");
            }
          }
        }
      });
      isHomeScreenWallpaperDialogVisible = true;
      return (Dialog)localObject;
      this.llKeyword.setVisibility(8);
      this.llLiveWallpaper.setVisibility(0);
      this.llLocationWeather.setVisibility(4);
      this.llPhotoSlide.setVisibility(4);
      this.llBottomContainer.setVisibility(8);
      break;
      label448:
      if (currentMode == 1) {
        localBuilder.setTitle(getString(2131755026));
      } else {
        localBuilder.setTitle(getString(2131755032));
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    isHomeScreenWallpaperDialogVisible = false;
    paramDialogInterface = (Launcher)getActivity();
    finishHelpWallpaperGuide();
    if ((paramDialogInterface != null) && (paramDialogInterface.getFragmentManager() != null))
    {
      if (paramDialogInterface.isPaused()) {
        dismissAllowingStateLoss();
      }
    }
    else {
      return;
    }
    dismiss();
  }
  
  public static class ActivityResultID
  {
    public static final int CROP_IMAGE_CMD = 1024;
  }
  
  public static class CropImage
  {
    public static final String ACTION_CROP = "com.android.camera.action.CROP";
    public static final String ACTION_CROP_SEC_ONLY = "com.sed.android.gallery3d.CROP_SEC_ONLY";
    public static final String KEY_ASPECT_X = "aspectX";
    public static final String KEY_ASPECT_Y = "aspectY";
    public static final String KEY_NO_FACE_DETECTION = "noFaceDetection";
    public static final String KEY_OUTPUT_X = "outputX";
    public static final String KEY_OUTPUT_Y = "outputY";
    public static final String KEY_SCALE = "scale";
    public static final String KEY_SET_AS_BOTHSCREEN = "set-as-bothscreen";
    public static final String KEY_SET_AS_LOCKSCREEN = "set-as-lockscreen";
    public static final String KEY_SET_AS_WALLPAPER = "set-as-wallpaper";
    public static final String KEY_SPOTLIGHT_X = "spotlightX";
    public static final String KEY_SPOTLIGHT_Y = "spotlightY";
  }
  
  public static class CropImageCmd
  {
    public static final int BOTH_SCREEN = 1026;
    public static final int LOCK_SCREEN = 1025;
    public static final int WALLPAPER_REQUEST_CODE = 1027;
    public static final int WALLPAPER_SCREEN = 1024;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomescreenWallpaperOptionsDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */