package com.android.launcher2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.android.launcher2.guide.AddWidgetsGuider;
import com.android.launcher2.guide.GuideFragment;
import com.android.launcher2.guide.HelpAnimatedDialog;
import java.util.ArrayList;

public class HomeScreenDialogFragment
  extends DialogFragment
{
  static final int BOTH_WALLPAPER = 2;
  static final int DOWNLOAD_WALLPAPER = -1;
  static final int HOME_SCREEN_WALLPAPER = 0;
  static final int LOCK_SCREEN_WALLPAPER = 1;
  private static final boolean SVIEW_WALLPAPER_BY_SECPICKER = false;
  static final int S_VIEW_COVER = 3;
  private static final String TAG = "HomeScreenDialogFragment";
  static boolean homescreenSelected = false;
  public static boolean isHomeScreenDialogVisible = false;
  private static final String sFragmentTag = "Homescreen";
  
  static void createAndShow(FragmentManager paramFragmentManager)
  {
    if (isActive(paramFragmentManager)) {}
    HomeScreenDialogFragment localHomeScreenDialogFragment;
    do
    {
      return;
      localHomeScreenDialogFragment = new HomeScreenDialogFragment();
    } while (paramFragmentManager == null);
    localHomeScreenDialogFragment.show(paramFragmentManager, "Homescreen");
  }
  
  static void dismiss(FragmentManager paramFragmentManager)
  {
    paramFragmentManager = (DialogFragment)paramFragmentManager.findFragmentByTag("Homescreen");
    if (paramFragmentManager != null) {
      paramFragmentManager.dismissAllowingStateLoss();
    }
  }
  
  /* Error */
  public static int getTypeOfCover()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: iconst_1
    //   3: istore_1
    //   4: new 69	java/io/File
    //   7: dup
    //   8: ldc 71
    //   10: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 78	java/io/File:exists	()Z
    //   16: ifeq +64 -> 80
    //   19: aconst_null
    //   20: astore 5
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: new 80	java/io/FileReader
    //   30: dup
    //   31: ldc 71
    //   33: invokespecial 81	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: bipush 15
    //   39: newarray <illegal type>
    //   41: astore_3
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual 85	java/io/FileReader:read	([C)I
    //   47: istore_0
    //   48: iload_0
    //   49: ifle +19 -> 68
    //   52: new 87	java/lang/String
    //   55: dup
    //   56: aload_3
    //   57: iconst_0
    //   58: iload_0
    //   59: iconst_1
    //   60: isub
    //   61: invokespecial 90	java/lang/String:<init>	([CII)V
    //   64: invokestatic 96	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   67: istore_1
    //   68: iload_1
    //   69: istore_0
    //   70: aload_2
    //   71: ifnull +9 -> 80
    //   74: aload_2
    //   75: invokevirtual 99	java/io/FileReader:close	()V
    //   78: iload_1
    //   79: istore_0
    //   80: iload_0
    //   81: ireturn
    //   82: astore_2
    //   83: aload 4
    //   85: astore_2
    //   86: iconst_1
    //   87: istore_0
    //   88: aload_2
    //   89: ifnull -9 -> 80
    //   92: aload_2
    //   93: invokevirtual 99	java/io/FileReader:close	()V
    //   96: iconst_1
    //   97: ireturn
    //   98: astore_2
    //   99: iconst_1
    //   100: ireturn
    //   101: astore_2
    //   102: aload 5
    //   104: astore_2
    //   105: iconst_1
    //   106: istore_0
    //   107: aload_2
    //   108: ifnull -28 -> 80
    //   111: aload_2
    //   112: invokevirtual 99	java/io/FileReader:close	()V
    //   115: iconst_1
    //   116: ireturn
    //   117: astore_2
    //   118: iconst_1
    //   119: ireturn
    //   120: astore_2
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 99	java/io/FileReader:close	()V
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: iload_1
    //   133: ireturn
    //   134: astore_3
    //   135: goto -6 -> 129
    //   138: astore 4
    //   140: aload_2
    //   141: astore_3
    //   142: aload 4
    //   144: astore_2
    //   145: goto -24 -> 121
    //   148: astore_3
    //   149: goto -44 -> 105
    //   152: astore_3
    //   153: goto -67 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	106	0	i	int
    //   3	130	1	j	int
    //   36	39	2	localFileReader	java.io.FileReader
    //   82	1	2	localIOException1	java.io.IOException
    //   85	8	2	localObject1	Object
    //   98	1	2	localIOException2	java.io.IOException
    //   101	1	2	localNumberFormatException1	NumberFormatException
    //   104	8	2	localObject2	Object
    //   117	1	2	localIOException3	java.io.IOException
    //   120	10	2	localObject3	Object
    //   131	10	2	localIOException4	java.io.IOException
    //   144	1	2	localObject4	Object
    //   23	103	3	arrayOfChar	char[]
    //   134	1	3	localIOException5	java.io.IOException
    //   141	1	3	localObject5	Object
    //   148	1	3	localNumberFormatException2	NumberFormatException
    //   152	1	3	localIOException6	java.io.IOException
    //   25	59	4	localObject6	Object
    //   138	5	4	localObject7	Object
    //   20	83	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   27	37	82	java/io/IOException
    //   92	96	98	java/io/IOException
    //   27	37	101	java/lang/NumberFormatException
    //   111	115	117	java/io/IOException
    //   27	37	120	finally
    //   74	78	131	java/io/IOException
    //   125	129	134	java/io/IOException
    //   37	48	138	finally
    //   52	68	138	finally
    //   37	48	148	java/lang/NumberFormatException
    //   52	68	148	java/lang/NumberFormatException
    //   37	48	152	java/io/IOException
    //   52	68	152	java/io/IOException
  }
  
  static boolean isActive(FragmentManager paramFragmentManager)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFragmentManager != null)
    {
      bool1 = bool2;
      if (paramFragmentManager.findFragmentByTag("Homescreen") != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  private boolean isCoverVerified()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: new 69	java/io/File
    //   7: dup
    //   8: ldc 102
    //   10: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: invokevirtual 78	java/io/File:exists	()Z
    //   16: ifeq +78 -> 94
    //   19: aconst_null
    //   20: astore 7
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 6
    //   28: new 80	java/io/FileReader
    //   31: dup
    //   32: ldc 102
    //   34: invokespecial 81	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   37: astore 4
    //   39: bipush 15
    //   41: newarray <illegal type>
    //   43: astore 5
    //   45: aload 4
    //   47: aload 5
    //   49: invokevirtual 85	java/io/FileReader:read	([C)I
    //   52: istore_1
    //   53: iload_1
    //   54: ifle +26 -> 80
    //   57: new 87	java/lang/String
    //   60: dup
    //   61: aload 5
    //   63: iconst_0
    //   64: iload_1
    //   65: iconst_1
    //   66: isub
    //   67: invokespecial 90	java/lang/String:<init>	([CII)V
    //   70: invokestatic 96	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   73: istore_1
    //   74: iload_1
    //   75: ifne +21 -> 96
    //   78: iconst_1
    //   79: istore_3
    //   80: iload_3
    //   81: istore_2
    //   82: aload 4
    //   84: ifnull +10 -> 94
    //   87: aload 4
    //   89: invokevirtual 99	java/io/FileReader:close	()V
    //   92: iload_3
    //   93: istore_2
    //   94: iload_2
    //   95: ireturn
    //   96: iconst_0
    //   97: istore_3
    //   98: goto -18 -> 80
    //   101: astore 4
    //   103: aload 6
    //   105: astore 4
    //   107: iconst_0
    //   108: istore_2
    //   109: aload 4
    //   111: ifnull -17 -> 94
    //   114: aload 4
    //   116: invokevirtual 99	java/io/FileReader:close	()V
    //   119: iconst_0
    //   120: ireturn
    //   121: astore 4
    //   123: iconst_0
    //   124: ireturn
    //   125: astore 4
    //   127: aload 7
    //   129: astore 4
    //   131: iconst_0
    //   132: istore_2
    //   133: aload 4
    //   135: ifnull -41 -> 94
    //   138: aload 4
    //   140: invokevirtual 99	java/io/FileReader:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore 4
    //   147: iconst_0
    //   148: ireturn
    //   149: astore 4
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 99	java/io/FileReader:close	()V
    //   161: aload 4
    //   163: athrow
    //   164: astore 4
    //   166: iload_3
    //   167: ireturn
    //   168: astore 5
    //   170: goto -9 -> 161
    //   173: astore 6
    //   175: aload 4
    //   177: astore 5
    //   179: aload 6
    //   181: astore 4
    //   183: goto -32 -> 151
    //   186: astore 5
    //   188: goto -57 -> 131
    //   191: astore 5
    //   193: goto -86 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	HomeScreenDialogFragment
    //   52	23	1	i	int
    //   1	132	2	bool1	boolean
    //   3	164	3	bool2	boolean
    //   37	51	4	localFileReader	java.io.FileReader
    //   101	1	4	localIOException1	java.io.IOException
    //   105	10	4	localObject1	Object
    //   121	1	4	localIOException2	java.io.IOException
    //   125	1	4	localNumberFormatException1	NumberFormatException
    //   129	10	4	localObject2	Object
    //   145	1	4	localIOException3	java.io.IOException
    //   149	13	4	localObject3	Object
    //   164	12	4	localIOException4	java.io.IOException
    //   181	1	4	localObject4	Object
    //   23	134	5	arrayOfChar	char[]
    //   168	1	5	localIOException5	java.io.IOException
    //   177	1	5	localObject5	Object
    //   186	1	5	localNumberFormatException2	NumberFormatException
    //   191	1	5	localIOException6	java.io.IOException
    //   26	78	6	localObject6	Object
    //   173	7	6	localObject7	Object
    //   20	108	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   28	39	101	java/io/IOException
    //   114	119	121	java/io/IOException
    //   28	39	125	java/lang/NumberFormatException
    //   138	143	145	java/io/IOException
    //   28	39	149	finally
    //   87	92	164	java/io/IOException
    //   156	161	168	java/io/IOException
    //   39	53	173	finally
    //   57	74	173	finally
    //   39	53	186	java/lang/NumberFormatException
    //   57	74	186	java/lang/NumberFormatException
    //   39	53	191	java/io/IOException
    //   57	74	191	java/io/IOException
  }
  
  public static String readSalesCode()
  {
    Object localObject = "";
    try
    {
      String str1 = SystemProperties.get("ro.csc.sales_code");
      String str2 = str1;
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        localObject = str1;
        str2 = SystemProperties.get("ril.sales_code");
      }
      return str2;
    }
    catch (Exception localException) {}
    return (String)localObject;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    final Activity localActivity = getActivity();
    homescreenSelected = false;
    Object localObject1 = View.inflate(localActivity, 2130903072, null);
    ((ImageView)((View)localObject1).findViewById(2131689502)).bringToFront();
    paramBundle = new AlertDialog.Builder(localActivity);
    paramBundle.setTitle(2131755023);
    paramBundle.setView((View)localObject1);
    AlertDialog localAlertDialog = paramBundle.create();
    Object localObject2;
    if ((Launcher.isHelpAppRunning) && ("change_wallpaper".equals(GuideFragment.GMode)))
    {
      ((AddWidgetsGuider)new AddWidgetsGuider(getActivity())).dismissHelpDialog();
      Launcher.changeWallpaperStatus = 3;
      ((RelativeLayout)((View)localObject1).findViewById(2131689554)).setVisibility(0);
      paramBundle = (ImageView)((View)localObject1).findViewById(2131689500);
      paramBundle = new HelpAnimatedDialog(getActivity(), paramBundle);
      localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131689501);
      paramBundle.start();
      paramBundle.startZoom(0.6F, 0.1F, (View)localObject2);
    }
    if (!Launcher.isHelpAppRunning) {
      localAlertDialog.setCanceledOnTouchOutside(true);
    }
    paramBundle = new ArrayList();
    int i;
    if ("".contains("Wallpaper"))
    {
      paramBundle.add(getResources().getText(2131755025).toString());
      localObject2 = ((View)localObject1).findViewById(2131689556);
      if (Launcher.isHelpAppRunning)
      {
        i = 0;
        ((View)localObject2).setVisibility(i);
      }
    }
    else
    {
      paramBundle.add(getResources().getText(2131755032).toString());
      localObject2 = readSalesCode();
      if ((LauncherApplication.getSmallestWidth() < 800) || ("XAR".equals(localObject2)) || (LauncherApplication.isOwner()))
      {
        paramBundle.add(getResources().getText(2131755026).toString());
        paramBundle.add(getResources().getText(2131755027).toString());
      }
      paramBundle.add(getResources().getText(2131755028).toString());
      if ((!isCoverVerified()) || (getTypeOfCover() == 0)) {
        paramBundle.remove(getResources().getText(2131755028).toString());
      }
      if (!LauncherApplication.isScreenSmall()) {
        break label458;
      }
    }
    label458:
    for (paramBundle = new ArrayAdapter(getActivity(), 17367043, paramBundle);; paramBundle = new ArrayAdapter(localActivity, 2130903041, paramBundle))
    {
      localObject1 = (ListView)((View)localObject1).findViewById(2131689498);
      ((ListView)localObject1).setAdapter(paramBundle);
      ((ListView)localObject1).setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((paramAnonymousMotionEvent.getActionMasked() == 1) && (Launcher.isHelpAppRunning)) {
            HelpAnimatedDialog.setAlpha();
          }
          return false;
        }
      });
      ((ListView)localObject1).setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (Launcher)HomeScreenDialogFragment.this.getActivity();
          int i = paramAnonymousInt;
          if ("".contains("Wallpaper")) {
            i = paramAnonymousInt - 1;
          }
          if ((!Launcher.isHelpAppRunning) || (i == 0)) {
            HomeScreenDialogFragment.this.dismiss();
          }
          if (HomeScreenDialogFragment.this.isAdded()) {
            switch (i)
            {
            }
          }
          do
          {
            do
            {
              do
              {
                return;
              } while (Launcher.isHelpAppRunning);
              paramAnonymousAdapterView = new Intent("android.intent.action.VIEW", Uri.parse("http://waprd.telstra.com/redirect?target=3glatestpics"));
              HomeScreenDialogFragment.this.startActivity(paramAnonymousAdapterView);
              return;
              HomeScreenDialogFragment.homescreenSelected = true;
              HomescreenWallpaperOptionsDialogFragment.createAndShow(paramAnonymousAdapterView.getFragmentManager(), i);
              return;
            } while (Launcher.isHelpAppRunning);
            HomescreenWallpaperOptionsDialogFragment.createAndShow(paramAnonymousAdapterView.getFragmentManager(), i);
            return;
          } while (Launcher.isHelpAppRunning);
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.setClassName("com.android.settings", "com.android.settings.SViewColor");
          try
          {
            ((Launcher)HomeScreenDialogFragment.this.getActivity()).startActivitySafely(paramAnonymousAdapterView);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousAdapterView)
          {
            Log.e("HomeScreenDialogFragment", "Activity Not Found for S View cover option");
            paramAnonymousAdapterView.printStackTrace();
          }
        }
      });
      isHomeScreenDialogVisible = true;
      return localAlertDialog;
      i = 8;
      break;
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((Launcher.isHelpAppRunning) && (!homescreenSelected) && ((Launcher)getActivity() != null)) {
      ((Launcher)getActivity()).onBackPressed();
    }
    isHomeScreenDialogVisible = false;
    paramDialogInterface = (Launcher)getActivity();
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
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeScreenDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */