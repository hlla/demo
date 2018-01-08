package com.android.launcher2;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings.System;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.android.app.CscFeature;
import java.util.HashMap;

public class FestivalPageManager
{
  private static final String ACTION_FESTIVAL_CARDWIDGET_ADDED = "com.android.launcher.action.FESTIVAL_CARDWIDGET_ADDED";
  private static final String ACTION_FESTIVAL_GREETINGWIDGET_ADDED = "com.android.launcher.action.FESTIVAL_GREETINGWIDGET_ADDED";
  private static final String ACTION_FESTIVAL_MEMORYWIDGET_ADDED = "com.android.launcher.action.FESTIVAL_MEMORYWIDGET_ADDED";
  public static final int BIRTHDAY_FESTIVAL = 999;
  public static final int CHILDREN_DAY_FESTIVAL = 6;
  public static final int CHINESE_VALENTINE_DAY_FESTIVAL = 15;
  public static final int CHRISTMAS_FESTIVAL = 11;
  public static final int CHRISTMAS_XML_FESTIVAL = 18;
  public static final int CONGRATULATION_FESTIVAL = 998;
  public static final boolean DEBUG = false;
  private static final boolean DEBUGGABLE = ;
  public static final int DOUBLE_NINTH_DAY_FESTIVAL = 17;
  public static final int DRAGON_BOAT_FESTIVAL = 14;
  public static final int LANTERN_FESTIVAL = 13;
  public static final int MAY_DAY_FESTIVAL = 4;
  public static final int MID_AUTUMN_FESTIVAL = 16;
  public static final int NATIONAL_DAY_FESTIVAL = 10;
  private static final int NETWORK_STATE_MOBILE = 1;
  private static final int NETWORK_STATE_NONE = 0;
  private static final int NETWORK_STATE_WIFI = 2;
  public static final int NEW_YEAR_DAY_FESTIVAL = 1;
  public static final int NEW_YEAR_DAY_XML_FESTIVAL = 19;
  static final String PREFERENCES_FESTIVAL_INTENT_STRING = "festivalstring";
  public static final int SPRING_FESTIVAL = 12;
  private static final String STR_TITLEIMAGE_PATH = "/system/festival/drawable/";
  public static final String TAG = "FestivalPageManager";
  public static final int TEACHER_DAY_FESTIVAL = 9;
  public static final int THANK_YOU_DAY_FESTIVAL = 3;
  public static final int TOMB_SWEEPING_DAY_FESTIVAL = 130;
  public static final int VALENTINE_DAY_FESTIVAL = 2;
  public static final SparseArray<Integer> festivalDayTextArray;
  private static final int[] festivalIndexArray = { 1, 2, 3, 4, 6, 9, 10, 17, 11, 12, 13, 14, 15, 16, 130, 998, 999 };
  public static final SparseArray<String> festivalNameArray = new SparseArray() {};
  public static final SparseArray<Integer> festivalTitleColor2Array;
  public static final SparseArray<Integer> festivalTitleColorArray;
  public static final SparseArray<String> festivalTitleImageArray = new SparseArray() {};
  private static Launcher mLauncher;
  AlertDialog.Builder adb;
  Intent callBrowserIntent;
  public CheckBox dontShowAgain;
  private boolean mCompleteShowHidedPage;
  private HashMap<Integer, CellLayout> mHidedPage = new HashMap();
  private HomeView mHomeView;
  private boolean mPageSwitchByFestivalMode = false;
  private Workspace mWorkspace;
  
  static
  {
    festivalDayTextArray = new SparseArray() {};
    festivalTitleColorArray = new SparseArray() {};
    festivalTitleColor2Array = new SparseArray() {};
  }
  
  public FestivalPageManager(Launcher paramLauncher)
  {
    mLauncher = paramLauncher;
  }
  
  private int checkNetwork()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)mLauncher.getSystemService("connectivity")).getActiveNetworkInfo();
    int i = 0;
    if (localNetworkInfo != null) {
      if (!"WIFI".equals(localNetworkInfo.getTypeName())) {
        break label62;
      }
    }
    label62:
    for (i = 2;; i = 1)
    {
      Log.d("FestivalPageManager", "checkNetwork netStatus=" + i);
      return i;
    }
  }
  
  public static boolean checkPrevFestivalStatus(String paramString)
  {
    boolean bool2 = true;
    String str = getFestivalString();
    boolean bool1;
    if ((str == null) || (str.isEmpty())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!str.equals(paramString));
      paramString = getFestivalDateEffect();
      if (paramString == null) {
        return false;
      }
      bool1 = bool2;
    } while (!paramString.equals(Settings.System.getString(mLauncher.getContentResolver(), "current_festival_effect_package")));
    Log.i("FestivalPageManager", "checkPrevFestivalStatus : current status is same as previous.");
    return false;
  }
  
  private static String getFestivalDateEffect()
  {
    return mLauncher.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("festivalDateEffect", null);
  }
  
  private String getFestivalDayText(int paramInt)
  {
    int i = 0;
    while (i < festivalDayTextArray.size())
    {
      if (paramInt == festivalIndexArray[i])
      {
        String str = mLauncher.getResources().getString(((Integer)festivalDayTextArray.get(festivalIndexArray[i])).intValue());
        if (DEBUGGABLE) {
          Log.i("FestivalPageManager", "getFestivalDayString festivalKey =  " + paramInt + " festivalIndexArray[ " + i + " ]  = " + str);
        }
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public static String getFestivalString()
  {
    return mLauncher.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("festivalstring", null);
  }
  
  private int getFestivalTitleColor(int paramInt)
  {
    String str = Settings.System.getString(this.mHomeView.getContext().getContentResolver(), "current_festival_effect_package");
    int i = 0;
    setFestivalDateEffect(str);
    if ("com.bst.festivalrespreload2".equals(str)) {
      i = 1;
    }
    int j = 0;
    while (j < festivalTitleColorArray.size())
    {
      if (paramInt == festivalIndexArray[j])
      {
        if (i != 0) {}
        for (paramInt = ((Integer)festivalTitleColorArray.get(festivalIndexArray[j])).intValue();; paramInt = ((Integer)festivalTitleColor2Array.get(festivalIndexArray[j])).intValue()) {
          return paramInt;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  private String getFestivalTitleImage(int paramInt)
  {
    int i = 0;
    while (i < festivalTitleImageArray.size())
    {
      if (paramInt == festivalIndexArray[i])
      {
        String str = (String)festivalTitleImageArray.get(festivalIndexArray[i]);
        return "/system/festival/drawable/" + str + ".png";
      }
      i += 1;
    }
    return null;
  }
  
  public static int getFestivalType(String paramString)
  {
    int j = -1;
    int i = 0;
    while (i < festivalNameArray.size())
    {
      j = festivalIndexArray[i];
      if (paramString.equals(festivalNameArray.get(festivalIndexArray[i])))
      {
        if (DEBUGGABLE) {
          Log.i("FestivalPageManager", "getFestivalType of festivalName : " + paramString + " festivalIndexArray[ " + i + " ]  = " + festivalIndexArray[i]);
        }
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  private boolean isApplicationInstalled(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = mLauncher.getPackageManager().getPackageInfo(paramString, 1);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      Log.e("FestivalPageManager", "festival widget is not installed");
    }
    return false;
  }
  
  private void launchLearnAboutFestivalDayURL(int paramInt)
  {
    String str = null;
    switch (paramInt)
    {
    default: 
      if (str != null) {
        break;
      }
    }
    do
    {
      return;
      str = "http://wapbaike.baidu.com/view/3116.htm";
      break;
      str = "http://wapbaike.baidu.com/view/3108.htm";
      break;
      str = "http://wapbaike.baidu.com/subview/1949/13291116.htm";
      break;
      str = "http://wapbaike.baidu.com/subview/2533/7683709.htm";
      break;
      str = "http://wapbaike.baidu.com/view/3148.htm";
      break;
      str = "http://wapbaike.baidu.com/view/44253.htm";
      break;
      str = "http://wapbaike.baidu.com/subview/2567/5060532.htm";
      break;
      str = "http://wapbaike.baidu.com/view/16194.htm";
      break;
      str = "http://wapbaike.baidu.com/view/25833.htm";
      break;
      str = "http://wapbaike.baidu.com/view/2568.htm";
      break;
      str = "http://wapbaike.baidu.com/view/14446.htm";
      break;
      str = "http://wapbaike.baidu.com/view/2572.htm";
      break;
      str = "http://wapbaike.baidu.com/view/2547.htm";
      break;
      str = "http://wapbaike.baidu.com/view/8489.htm";
      break;
      Intent localIntent = new Intent();
      Uri localUri = Uri.parse(str);
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setFlags(268435456);
      localIntent.setData(localUri);
      localIntent.setClassName("com.sec.android.app.sbrowser", "com.sec.android.app.sbrowser.SBrowserMainActivity");
      this.mWorkspace.getContext().startActivity(localIntent);
    } while (!DEBUGGABLE);
    Log.i("FestivalPageManager", "getLearnAboutFestivalDayURL  [ " + paramInt + " ]  = " + str);
  }
  
  private void setFestivalDateEffect(String paramString)
  {
    SharedPreferences.Editor localEditor = mLauncher.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    localEditor.putString("festivalDateEffect", paramString);
    localEditor.commit();
  }
  
  public static void setFestivalString(LauncherApplication paramLauncherApplication, String paramString)
  {
    paramLauncherApplication = paramLauncherApplication.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    paramLauncherApplication.putString("festivalstring", paramString);
    paramLauncherApplication.commit();
  }
  
  private void showRetry(final int paramInt)
  {
    String str1 = mLauncher.getResources().getString(2131755309);
    String str2 = mLauncher.getResources().getString(2131755310);
    mLauncher.setTheme(2131820545);
    new AlertDialog.Builder(mLauncher).setTitle(str1).setMessage(str2).setPositiveButton(2131755308, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousInt = FestivalPageManager.this.checkNetwork();
        if (paramAnonymousInt == 0)
        {
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.dismiss();
          }
          FestivalPageManager.this.showRetry(paramInt);
        }
        do
        {
          return;
          if (paramAnonymousInt == 1)
          {
            FestivalPageManager.this.show_checkbox_dialog(paramAnonymousInt, paramInt);
            return;
          }
        } while (paramAnonymousInt != 2);
        Log.i("FestivalPageManager", "showRetry netStatus wifi = " + paramAnonymousInt);
        FestivalPageManager.this.show_checkbox_dialog(paramAnonymousInt, paramInt);
      }
    }).setNegativeButton(2131755312, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    }).create().show();
  }
  
  private void show_checkbox_dialog(int paramInt1, final int paramInt2)
  {
    String str = null;
    Object localObject = null;
    if (mLauncher.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getBoolean("data_charging_checkbox", false) == true)
    {
      launchLearnAboutFestivalDayURL(paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      str = mLauncher.getResources().getString(2131755303);
      localObject = mLauncher.getResources().getString(2131755304);
    }
    for (;;)
    {
      mLauncher.setTheme(2131820545);
      this.adb = new AlertDialog.Builder(mLauncher);
      this.adb.setTitle(str);
      this.adb.setMessage((CharSequence)localObject);
      localObject = LayoutInflater.from(mLauncher).inflate(2130903050, null);
      this.dontShowAgain = ((CheckBox)((View)localObject).findViewById(2131689523));
      this.dontShowAgain.setChecked(true);
      this.adb.setView((View)localObject);
      this.adb.setNegativeButton(mLauncher.getResources().getString(2131755312), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Log.i("FestivalPageManager", "show_checkbox_dialog No Check permission");
        }
      });
      this.adb.setPositiveButton(mLauncher.getResources().getString(2131755311), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if (FestivalPageManager.this.dontShowAgain.isChecked())
          {
            paramAnonymousDialogInterface = FestivalPageManager.mLauncher.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
            paramAnonymousDialogInterface.putBoolean("data_charging_checkbox", true);
            paramAnonymousDialogInterface.commit();
          }
          FestivalPageManager.this.launchLearnAboutFestivalDayURL(paramInt2);
        }
      });
      this.adb.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      this.adb.show();
      return;
      if (paramInt1 == 2)
      {
        str = mLauncher.getResources().getString(2131755305);
        localObject = mLauncher.getResources().getString(2131755306);
      }
    }
  }
  
  private void updateFestivalTitle(CellLayout paramCellLayout, int paramInt)
  {
    Object localObject = (RelativeLayout)paramCellLayout.findViewById(2131689696);
    if (getFestivalTitleColor(paramInt) < 0) {
      ((RelativeLayout)localObject).setBackgroundResource(2131361834);
    }
    for (;;)
    {
      localObject = (ImageView)paramCellLayout.findViewById(2131689699);
      String str = getFestivalTitleImage(paramInt);
      if (DEBUGGABLE) {
        Log.i("FestivalPageManager", "updateFestivalTitle festivalTitleImagePath : " + str);
      }
      if (str != null) {
        ((ImageView)localObject).setImageBitmap(BitmapFactory.decodeFile(str));
      }
      localObject = (TextView)paramCellLayout.findViewById(2131689701);
      str = getFestivalDayText(paramInt);
      if (localObject != null)
      {
        ((TextView)localObject).setText(mLauncher.getResources().getString(2131755285, new Object[] { str }));
        if (paramInt == 999) {
          ((TextView)localObject).setVisibility(8);
        }
      }
      paramCellLayout = (TextView)paramCellLayout.findViewById(2131689700);
      if (paramCellLayout != null) {
        paramCellLayout.setVisibility(8);
      }
      return;
      ((RelativeLayout)localObject).setBackgroundResource(getFestivalTitleColor(paramInt));
    }
  }
  
  public void ShowEqualPageWithItem(BaseItem paramBaseItem, Workspace.State paramState)
  {
    if (paramBaseItem == null) {}
    while (!Launcher.sIsFestivalModeOn) {
      return;
    }
    setCompleteShowHidedPage(false);
    int i = this.mWorkspace.getCurrentPage();
    int j = i;
    if (((CellLayout)this.mWorkspace.getChildAt(i)).getPageType() == 2) {
      j = LauncherApplication.getHomeScreenIndex();
    }
    this.mHidedPage.clear();
    i = 0;
    while (i < this.mWorkspace.getChildCount())
    {
      paramBaseItem = (CellLayout)this.mWorkspace.getChildAt(i);
      if (paramBaseItem.getPageType() == 2) {
        this.mHidedPage.put(Integer.valueOf(i), paramBaseItem);
      }
      i += 1;
    }
    int k;
    for (i = 0; i < this.mWorkspace.getChildCount(); i = k + 1)
    {
      k = i;
      if (((CellLayout)this.mWorkspace.getChildAt(i)).getPageType() == 2)
      {
        this.mWorkspace.removeViewAt(i);
        k = i - 1;
        this.mPageSwitchByFestivalMode = true;
      }
    }
    this.mWorkspace.setCurrentPage(j);
  }
  
  public void ShowHidedPage()
  {
    if (this.mHidedPage.size() > 0)
    {
      Log.i("FestivalPageManager", "ShowFestivalHidedPage - " + this.mHidedPage.size() + " pages will be added");
      int m = LauncherApplication.getScreenCount();
      int k = LauncherApplication.getMaxScreenCount() + LauncherApplication.getFestivalScreenCount();
      int j = m;
      int i = k;
      if (Launcher.sIsSecretModeOn)
      {
        i = LauncherApplication.getSecretScreenCount();
        j = m + i;
        i = k + i;
      }
      k = 0;
      while (k < i) {
        if (!this.mHidedPage.containsKey(Integer.valueOf(k)))
        {
          k += 1;
        }
        else
        {
          if (j >= k) {
            this.mWorkspace.addView((View)this.mHidedPage.get(Integer.valueOf(k)), k + (j - k));
          }
          for (;;)
          {
            this.mPageSwitchByFestivalMode = true;
            break;
            if (j < k) {
              this.mWorkspace.addView((View)this.mHidedPage.get(Integer.valueOf(k)), k - (k - j));
            } else {
              this.mWorkspace.addView((View)this.mHidedPage.get(Integer.valueOf(k)), k);
            }
          }
        }
      }
      i = 0;
      while (i < this.mWorkspace.getChildCount())
      {
        CellLayout localCellLayout = (CellLayout)this.mWorkspace.getChildAt(i);
        if (localCellLayout != null) {
          localCellLayout.destroyDummyPanel();
        }
        i += 1;
      }
      this.mWorkspace.setAllEmptyMessageVisibility(false);
      this.mHidedPage.clear();
      setCompleteShowHidedPage(true);
      if (this.mWorkspace.getCreatedPageForDrag() != null) {
        this.mWorkspace.removeCreatedPageForDrag();
      }
    }
  }
  
  public void bindFestivalWidget(AppWidgetBinder paramAppWidgetBinder, final int paramInt1, final int paramInt2, final String paramString)
  {
    ComponentName localComponentName;
    switch (paramInt2)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (!isApplicationInstalled("com.sec.android.widget.greetingcardwidget"));
      localComponentName = new ComponentName("com.sec.android.widget.greetingcardwidget", "com.sec.android.widget.greetingcardwidget.CardTempleteProvider");
    }
    for (;;)
    {
      paramAppWidgetBinder.allocateBindNew(localComponentName, new AppWidgetBinder.Callback()
      {
        public void onBindFail()
        {
          Log.e("FestivalPageManager", "Problem binding widget. This should only happen when installed outside of /system/app and user declined authorization.");
        }
        
        public void onBindSuccess(int paramAnonymousInt)
        {
          Object localObject = FestivalPageManager.this.mWorkspace.getContext();
          AppWidgetProviderInfo localAppWidgetProviderInfo = AppWidgetManager.getInstance((Context)localObject).getAppWidgetInfo(paramAnonymousInt);
          if ((-1 == paramAnonymousInt) || (localAppWidgetProviderInfo == null)) {
            return;
          }
          HomeWidgetItem localHomeWidgetItem = new HomeWidgetItem(localAppWidgetProviderInfo, paramAnonymousInt, false);
          localHomeWidgetItem.container = -100L;
          localHomeWidgetItem.mScreen = paramInt1;
          localHomeWidgetItem.spanX = 4;
          localHomeWidgetItem.spanY = 1;
          localHomeWidgetItem.cellX = 0;
          localHomeWidgetItem.cellY = paramInt2;
          localHomeWidgetItem.mFestivalType = FestivalPageManager.getFestivalType(paramString);
          LauncherModel.addItemToDatabase((Context)localObject, localHomeWidgetItem, localHomeWidgetItem.container, localHomeWidgetItem.mScreen, localHomeWidgetItem.cellX, localHomeWidgetItem.cellY, false);
          localHomeWidgetItem.hostView = FestivalPageManager.this.mHomeView.getAppWidgetHost().createView((Context)localObject, paramAnonymousInt, localAppWidgetProviderInfo);
          localHomeWidgetItem.hostView.setAppWidget(paramAnonymousInt, localAppWidgetProviderInfo);
          localHomeWidgetItem.hostView.setTag(localHomeWidgetItem);
          localObject = ((LauncherApplication)((Context)localObject).getApplicationContext()).getSpanCalculator().getPaddingForWidget(localAppWidgetProviderInfo.provider);
          localHomeWidgetItem.hostView.setPadding(((WorkspaceSpanCalculator.Padding)localObject).left, ((WorkspaceSpanCalculator.Padding)localObject).top, ((WorkspaceSpanCalculator.Padding)localObject).right, ((WorkspaceSpanCalculator.Padding)localObject).bottom);
          localHomeWidgetItem.hostView.setBackgroundColor(16777216);
          FestivalPageManager.this.mWorkspace.addItem(localHomeWidgetItem);
          FestivalPageManager.this.mHomeView.addWidgetToAutoAdvanceIfNeeded(localHomeWidgetItem.hostView, localAppWidgetProviderInfo);
          FestivalPageManager.this.sendFestivalWidgetType(paramInt2, paramAnonymousInt, paramString);
        }
      });
      return;
      if (!isApplicationInstalled("com.sec.android.widget.festivalmemorywidget")) {
        break;
      }
      localComponentName = new ComponentName("com.sec.android.widget.festivalmemorywidget", "com.sec.android.widget.festivalmemorywidget.FestivalMemoryProvider");
      continue;
      if (!isApplicationInstalled("com.sec.android.widget.festivalsawidget")) {
        break;
      }
      localComponentName = new ComponentName("com.sec.android.widget.festivalsawidget", "com.sec.android.widget.festivalsawidget.FestivalSAProvider");
    }
  }
  
  public boolean drawFestivalPageTitle(CellLayout paramCellLayout, final int paramInt)
  {
    if (this.mWorkspace == null)
    {
      if (DEBUGGABLE) {
        Log.e("FestivalPageManager", "bindFestivalPage : Workspace is NULL!!");
      }
      return false;
    }
    if (DEBUGGABLE) {
      Log.i("FestivalPageManager", "drawFestivalPageTitle : festivalKey" + paramInt);
    }
    updateFestivalTitle(paramCellLayout, paramInt);
    ((RelativeLayout)paramCellLayout.findViewById(2131689696)).setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        return true;
      }
    });
    ((ImageView)paramCellLayout.findViewById(2131689698)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (Launcher.isHomeEditMode())) {
          return;
        }
        paramAnonymousView = new Intent("android.settings.FESTIVAL_EFFECT_SETTINGS");
        paramAnonymousView.setFlags(270532608);
        FestivalPageManager.mLauncher.startActivitySafely(paramAnonymousView);
      }
    });
    ((TextView)paramCellLayout.findViewById(2131689701)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((Launcher.CSCFEATURE_LAUNCHER_HOMESCREENEDITMODE) && (Launcher.isHomeEditMode())) {
          return;
        }
        if ("ChinaNalSecurity".equals(CscFeature.getInstance().getString("CscFeature_Common_ConfigLocalSecurityPolicy")))
        {
          if (!Boolean.valueOf(FestivalPageManager.mLauncher.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getBoolean("data_charging_checkbox", false)).booleanValue())
          {
            switch (FestivalPageManager.this.checkNetwork())
            {
            default: 
              FestivalPageManager.this.showRetry(paramInt);
              return;
            case 1: 
              FestivalPageManager.this.show_checkbox_dialog(1, paramInt);
              return;
            case 2: 
              FestivalPageManager.this.show_checkbox_dialog(2, paramInt);
              return;
            }
            FestivalPageManager.this.showRetry(paramInt);
            return;
          }
          FestivalPageManager.this.launchLearnAboutFestivalDayURL(paramInt);
          return;
        }
        FestivalPageManager.this.launchLearnAboutFestivalDayURL(paramInt);
      }
    });
    return true;
  }
  
  public boolean getCompleteShowHidedPage()
  {
    return this.mCompleteShowHidedPage;
  }
  
  public int getFestivalPageCount()
  {
    int j = 0;
    int i = 0;
    while (i < this.mWorkspace.getChildCount())
    {
      int k = j;
      if (((CellLayout)this.mWorkspace.getChildAt(i)).getPageType() == 2) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public boolean getPageSwitchByFestivalMode()
  {
    return this.mPageSwitchByFestivalMode;
  }
  
  public void initFestivalPage(HomeView paramHomeView)
  {
    this.mHomeView = paramHomeView;
    this.mWorkspace = this.mHomeView.getWorkspace();
  }
  
  public void printWorkspaceInfo()
  {
    String str = "|";
    int i = 0;
    if (i < this.mWorkspace.getChildCount())
    {
      CellLayout localCellLayout = (CellLayout)this.mWorkspace.getChildAt(i);
      if (localCellLayout.getPageType() == 2) {
        str = str + "F|";
      }
      for (;;)
      {
        i += 1;
        break;
        if (localCellLayout.getPageType() == 1) {
          str = str + "S|";
        } else {
          str = str + "N|";
        }
      }
    }
    Log.i("FestivalPageManager", "Festival WorkspaceInfo - " + str);
    Log.i("FestivalPageManager", "HidedPage size - " + this.mHidedPage.size());
  }
  
  public void sendFestivalWidgetType(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = null;
    if (paramInt1 == 1) {
      localIntent = new Intent("com.android.launcher.action.FESTIVAL_GREETINGWIDGET_ADDED");
    }
    for (;;)
    {
      localIntent.putExtra("widgetId", paramInt2);
      localIntent.putExtra("festivalType", paramString);
      mLauncher.sendBroadcast(localIntent);
      if (DEBUGGABLE) {
        Log.i("FestivalPageManager", "sendFestivalWidgetType  [ " + paramInt1 + " ]  = " + paramInt2);
      }
      return;
      if (paramInt1 == 2) {
        localIntent = new Intent("com.android.launcher.action.FESTIVAL_MEMORYWIDGET_ADDED");
      } else if (paramInt1 == 3) {
        localIntent = new Intent("com.android.launcher.action.FESTIVAL_CARDWIDGET_ADDED");
      }
    }
  }
  
  public void setCompleteShowHidedPage(boolean paramBoolean)
  {
    this.mCompleteShowHidedPage = paramBoolean;
  }
  
  public void setPageSwitchByFestivalMode(boolean paramBoolean)
  {
    this.mPageSwitchByFestivalMode = paramBoolean;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/FestivalPageManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */