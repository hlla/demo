package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ca;
import android.support.v4.view.az;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.e;
import android.support.v7.view.i;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.q;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.bi;
import android.support.v7.widget.cf;
import android.support.v7.widget.hf;
import android.support.v7.widget.id;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.Map;

final class aa
  extends z
  implements q, LayoutInflater.Factory2
{
  private static boolean T;
  private static final int[] U;
  private static final boolean q;
  private boolean A;
  private final Runnable B = new ac(this);
  private boolean C;
  private int D = -100;
  private boolean E;
  private MenuInflater F;
  private final Window.Callback G;
  private boolean H;
  private boolean I;
  private as J;
  private ar[] K;
  private View L;
  private ViewGroup M;
  private boolean N;
  private Rect O;
  private Rect P;
  private CharSequence Q;
  private TextView R;
  private boolean S;
  public b b;
  public PopupWindow c;
  public ActionBarContextView d;
  public final y e;
  public final Context f;
  public bi g;
  public az h = null;
  public boolean i = true;
  public boolean j;
  public int k;
  public boolean l;
  public boolean m;
  public ar n;
  public Runnable o;
  public final Window p;
  private a r;
  private ak s;
  private AppCompatViewInflater t;
  private final Window.Callback u;
  private boolean v;
  private ao w;
  private boolean x;
  private boolean y;
  private boolean z;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      q = bool;
      U = new int[] { 16842836 };
      if ((q) && (!T))
      {
        Thread.setDefaultUncaughtExceptionHandler(new ab(Thread.getDefaultUncaughtExceptionHandler()));
        T = true;
      }
      return;
    }
  }
  
  aa(Context paramContext, Window paramWindow, y paramy)
  {
    this.f = paramContext;
    this.p = paramWindow;
    this.e = paramy;
    this.G = this.p.getCallback();
    paramWindow = this.G;
    if ((paramWindow instanceof an)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.u = new an(this, paramWindow);
    this.p.setCallback(this.u);
    paramContext = hf.a(paramContext, null, U);
    paramWindow = paramContext.b(0);
    if (paramWindow != null) {
      this.p.setBackgroundDrawable(paramWindow);
    }
    paramContext.c.recycle();
  }
  
  /* Error */
  private final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 181	android/support/v7/app/aa:t	Landroid/support/v7/app/AppCompatViewInflater;
    //   7: ifnonnull +50 -> 57
    //   10: aload_0
    //   11: getfield 127	android/support/v7/app/aa:f	Landroid/content/Context;
    //   14: getstatic 186	android/support/v7/a/a:ay	[I
    //   17: invokevirtual 192	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   20: getstatic 195	android/support/v7/a/a:aC	I
    //   23: invokevirtual 199	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   26: astore 9
    //   28: aload 9
    //   30: ifnull +16 -> 46
    //   33: ldc -55
    //   35: invokevirtual 207	java/lang/Class:getName	()Ljava/lang/String;
    //   38: aload 9
    //   40: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +896 -> 939
    //   46: aload_0
    //   47: new 201	android/support/v7/app/AppCompatViewInflater
    //   50: dup
    //   51: invokespecial 214	android/support/v7/app/AppCompatViewInflater:<init>	()V
    //   54: putfield 181	android/support/v7/app/aa:t	Landroid/support/v7/app/AppCompatViewInflater;
    //   57: getstatic 88	android/support/v7/app/aa:q	Z
    //   60: ifeq +873 -> 933
    //   63: aload 4
    //   65: instanceof 216
    //   68: ifeq +772 -> 840
    //   71: aload 4
    //   73: checkcast 216	org/xmlpull/v1/XmlPullParser
    //   76: invokeinterface 220 1 0
    //   81: iconst_1
    //   82: if_icmple +752 -> 834
    //   85: iconst_1
    //   86: istore 5
    //   88: aload_0
    //   89: getfield 181	android/support/v7/app/aa:t	Landroid/support/v7/app/AppCompatViewInflater;
    //   92: astore 10
    //   94: getstatic 88	android/support/v7/app/aa:q	Z
    //   97: istore 7
    //   99: invokestatic 225	android/support/v7/widget/hv:a	()Z
    //   102: istore 8
    //   104: iload 5
    //   106: ifne +711 -> 817
    //   109: aload_3
    //   110: astore_1
    //   111: aload_1
    //   112: aload 4
    //   114: iload 7
    //   116: invokestatic 228	android/support/v7/app/AppCompatViewInflater:a	(Landroid/content/Context;Landroid/util/AttributeSet;Z)Landroid/content/Context;
    //   119: astore_1
    //   120: aload_1
    //   121: astore 9
    //   123: iload 8
    //   125: ifeq +9 -> 134
    //   128: aload_1
    //   129: invokestatic 233	android/support/v7/widget/hc:a	(Landroid/content/Context;)Landroid/content/Context;
    //   132: astore 9
    //   134: aload_2
    //   135: invokevirtual 236	java/lang/String:hashCode	()I
    //   138: lookupswitch	default:+114->252, -1946472170:+662->800, -1455429095:+645->783, -1346021293:+628->766, -938935918:+612->750, -937446323:+596->734, -658531749:+579->717, -339785223:+563->701, 776382189:+546->684, 1125864064:+529->667, 1413872058:+512->650, 1601505219:+495->633, 1666676343:+479->617, 2001146706:+463->601
    //   252: iconst_m1
    //   253: istore 5
    //   255: iload 5
    //   257: tableswitch	default:+67->324, 0:+108->365, 1:+326->583, 2:+306->563, 3:+288->545, 4:+270->527, 5:+252->509, 6:+234->491, 7:+216->473, 8:+198->455, 9:+180->437, 10:+162->419, 11:+144->401, 12:+126->383
    //   324: aconst_null
    //   325: astore_1
    //   326: aload_1
    //   327: ifnull +15 -> 342
    //   330: aload_1
    //   331: ifnull +9 -> 340
    //   334: aload_1
    //   335: aload 4
    //   337: invokestatic 239	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Landroid/util/AttributeSet;)V
    //   340: aload_1
    //   341: areturn
    //   342: aload_3
    //   343: aload 9
    //   345: if_acmpeq +17 -> 362
    //   348: aload 10
    //   350: aload 9
    //   352: aload_2
    //   353: aload 4
    //   355: invokevirtual 242	android/support/v7/app/AppCompatViewInflater:a	(Landroid/content/Context;Ljava/lang/String;Landroid/util/AttributeSet;)Landroid/view/View;
    //   358: astore_1
    //   359: goto -29 -> 330
    //   362: goto -32 -> 330
    //   365: aload 9
    //   367: aload 4
    //   369: invokestatic 245	android/support/v7/app/AppCompatViewInflater:b	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/bb;
    //   372: astore_1
    //   373: aload 10
    //   375: aload_1
    //   376: aload_2
    //   377: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   380: goto -54 -> 326
    //   383: aload 9
    //   385: aload 4
    //   387: invokestatic 251	android/support/v7/app/AppCompatViewInflater:m	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/ar;
    //   390: astore_1
    //   391: aload 10
    //   393: aload_1
    //   394: aload_2
    //   395: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   398: goto -72 -> 326
    //   401: aload 9
    //   403: aload 4
    //   405: invokestatic 254	android/support/v7/app/AppCompatViewInflater:l	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/aq;
    //   408: astore_1
    //   409: aload 10
    //   411: aload_1
    //   412: aload_2
    //   413: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   416: goto -90 -> 326
    //   419: aload 9
    //   421: aload 4
    //   423: invokestatic 257	android/support/v7/app/AppCompatViewInflater:k	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/an;
    //   426: astore_1
    //   427: aload 10
    //   429: aload_1
    //   430: aload_2
    //   431: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   434: goto -108 -> 326
    //   437: aload 9
    //   439: aload 4
    //   441: invokestatic 260	android/support/v7/app/AppCompatViewInflater:j	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/aa;
    //   444: astore_1
    //   445: aload 10
    //   447: aload_1
    //   448: aload_2
    //   449: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   452: goto -126 -> 326
    //   455: aload 9
    //   457: aload 4
    //   459: invokestatic 263	android/support/v7/app/AppCompatViewInflater:i	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/ac;
    //   462: astore_1
    //   463: aload 10
    //   465: aload_1
    //   466: aload_2
    //   467: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   470: goto -144 -> 326
    //   473: aload 9
    //   475: aload 4
    //   477: invokestatic 266	android/support/v7/app/AppCompatViewInflater:h	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/AppCompatRadioButton;
    //   480: astore_1
    //   481: aload 10
    //   483: aload_1
    //   484: aload_2
    //   485: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   488: goto -162 -> 326
    //   491: aload 9
    //   493: aload 4
    //   495: invokestatic 269	android/support/v7/app/AppCompatViewInflater:g	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/AppCompatCheckBox;
    //   498: astore_1
    //   499: aload 10
    //   501: aload_1
    //   502: aload_2
    //   503: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   506: goto -180 -> 326
    //   509: aload 9
    //   511: aload 4
    //   513: invokestatic 272	android/support/v7/app/AppCompatViewInflater:f	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/al;
    //   516: astore_1
    //   517: aload 10
    //   519: aload_1
    //   520: aload_2
    //   521: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   524: goto -198 -> 326
    //   527: aload 9
    //   529: aload 4
    //   531: invokestatic 275	android/support/v7/app/AppCompatViewInflater:e	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/AppCompatSpinner;
    //   534: astore_1
    //   535: aload 10
    //   537: aload_1
    //   538: aload_2
    //   539: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   542: goto -216 -> 326
    //   545: aload 9
    //   547: aload 4
    //   549: invokestatic 278	android/support/v7/app/AppCompatViewInflater:d	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/AppCompatEditText;
    //   552: astore_1
    //   553: aload 10
    //   555: aload_1
    //   556: aload_2
    //   557: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   560: goto -234 -> 326
    //   563: aload 10
    //   565: aload 9
    //   567: aload 4
    //   569: invokevirtual 281	android/support/v7/app/AppCompatViewInflater:a	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/AppCompatButton;
    //   572: astore_1
    //   573: aload 10
    //   575: aload_1
    //   576: aload_2
    //   577: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   580: goto -254 -> 326
    //   583: aload 9
    //   585: aload 4
    //   587: invokestatic 284	android/support/v7/app/AppCompatViewInflater:c	(Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/support/v7/widget/AppCompatImageView;
    //   590: astore_1
    //   591: aload 10
    //   593: aload_1
    //   594: aload_2
    //   595: invokevirtual 248	android/support/v7/app/AppCompatViewInflater:a	(Landroid/view/View;Ljava/lang/String;)V
    //   598: goto -272 -> 326
    //   601: aload_2
    //   602: ldc_w 286
    //   605: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   608: ifeq -356 -> 252
    //   611: iconst_2
    //   612: istore 5
    //   614: goto -359 -> 255
    //   617: aload_2
    //   618: ldc_w 288
    //   621: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   624: ifeq -372 -> 252
    //   627: iconst_3
    //   628: istore 5
    //   630: goto -375 -> 255
    //   633: aload_2
    //   634: ldc_w 290
    //   637: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifeq -388 -> 252
    //   643: bipush 6
    //   645: istore 5
    //   647: goto -392 -> 255
    //   650: aload_2
    //   651: ldc_w 292
    //   654: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   657: ifeq -405 -> 252
    //   660: bipush 9
    //   662: istore 5
    //   664: goto -409 -> 255
    //   667: aload_2
    //   668: ldc_w 294
    //   671: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   674: ifeq -422 -> 252
    //   677: iload 6
    //   679: istore 5
    //   681: goto -426 -> 255
    //   684: aload_2
    //   685: ldc_w 296
    //   688: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   691: ifeq -439 -> 252
    //   694: bipush 7
    //   696: istore 5
    //   698: goto -443 -> 255
    //   701: aload_2
    //   702: ldc_w 298
    //   705: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   708: ifeq -456 -> 252
    //   711: iconst_4
    //   712: istore 5
    //   714: goto -459 -> 255
    //   717: aload_2
    //   718: ldc_w 300
    //   721: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   724: ifeq -472 -> 252
    //   727: bipush 12
    //   729: istore 5
    //   731: goto -476 -> 255
    //   734: aload_2
    //   735: ldc_w 302
    //   738: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   741: ifeq -489 -> 252
    //   744: iconst_5
    //   745: istore 5
    //   747: goto -492 -> 255
    //   750: aload_2
    //   751: ldc_w 304
    //   754: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   757: ifeq -505 -> 252
    //   760: iconst_0
    //   761: istore 5
    //   763: goto -508 -> 255
    //   766: aload_2
    //   767: ldc_w 306
    //   770: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   773: ifeq -521 -> 252
    //   776: bipush 10
    //   778: istore 5
    //   780: goto -525 -> 255
    //   783: aload_2
    //   784: ldc_w 308
    //   787: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   790: ifeq -538 -> 252
    //   793: bipush 8
    //   795: istore 5
    //   797: goto -542 -> 255
    //   800: aload_2
    //   801: ldc_w 310
    //   804: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   807: ifeq -555 -> 252
    //   810: bipush 11
    //   812: istore 5
    //   814: goto -559 -> 255
    //   817: aload_1
    //   818: ifnull +11 -> 829
    //   821: aload_1
    //   822: invokevirtual 316	android/view/View:getContext	()Landroid/content/Context;
    //   825: astore_1
    //   826: goto -715 -> 111
    //   829: aload_3
    //   830: astore_1
    //   831: goto -720 -> 111
    //   834: iconst_0
    //   835: istore 5
    //   837: goto -749 -> 88
    //   840: aload_1
    //   841: checkcast 318	android/view/ViewParent
    //   844: astore 9
    //   846: aload 9
    //   848: ifnull +79 -> 927
    //   851: aload_0
    //   852: getfield 129	android/support/v7/app/aa:p	Landroid/view/Window;
    //   855: invokevirtual 322	android/view/Window:getDecorView	()Landroid/view/View;
    //   858: astore 10
    //   860: aload 9
    //   862: ifnonnull +9 -> 871
    //   865: iconst_1
    //   866: istore 5
    //   868: goto -780 -> 88
    //   871: aload 9
    //   873: aload 10
    //   875: if_acmpeq +46 -> 921
    //   878: aload 9
    //   880: instanceof 312
    //   883: ifeq +32 -> 915
    //   886: aload 9
    //   888: checkcast 312	android/view/View
    //   891: invokestatic 327	android/support/v4/view/ac:L	(Landroid/view/View;)Z
    //   894: ifne +15 -> 909
    //   897: aload 9
    //   899: invokeinterface 331 1 0
    //   904: astore 9
    //   906: goto -46 -> 860
    //   909: iconst_0
    //   910: istore 5
    //   912: goto -824 -> 88
    //   915: iconst_0
    //   916: istore 5
    //   918: goto -830 -> 88
    //   921: iconst_0
    //   922: istore 5
    //   924: goto -836 -> 88
    //   927: iconst_0
    //   928: istore 5
    //   930: goto -842 -> 88
    //   933: iconst_0
    //   934: istore 5
    //   936: goto -848 -> 88
    //   939: aload_0
    //   940: aload 9
    //   942: invokestatic 335	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   945: iconst_0
    //   946: anewarray 203	java/lang/Class
    //   949: invokevirtual 339	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   952: iconst_0
    //   953: anewarray 341	java/lang/Object
    //   956: invokevirtual 347	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   959: checkcast 201	android/support/v7/app/AppCompatViewInflater
    //   962: putfield 181	android/support/v7/app/aa:t	Landroid/support/v7/app/AppCompatViewInflater;
    //   965: goto -908 -> 57
    //   968: astore 10
    //   970: new 349	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   977: astore 11
    //   979: aload 11
    //   981: ldc_w 352
    //   984: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 11
    //   990: aload 9
    //   992: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload 11
    //   998: ldc_w 358
    //   1001: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: ldc_w 360
    //   1008: aload 11
    //   1010: invokevirtual 363	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: aload 10
    //   1015: invokestatic 368	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1018: pop
    //   1019: aload_0
    //   1020: new 201	android/support/v7/app/AppCompatViewInflater
    //   1023: dup
    //   1024: invokespecial 214	android/support/v7/app/AppCompatViewInflater:<init>	()V
    //   1027: putfield 181	android/support/v7/app/aa:t	Landroid/support/v7/app/AppCompatViewInflater;
    //   1030: goto -973 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1033	0	this	aa
    //   0	1033	1	paramView	View
    //   0	1033	2	paramString	String
    //   0	1033	3	paramContext	Context
    //   0	1033	4	paramAttributeSet	AttributeSet
    //   86	849	5	i1	int
    //   1	677	6	i2	int
    //   97	18	7	bool1	boolean
    //   102	22	8	bool2	boolean
    //   26	965	9	localObject1	Object
    //   92	782	10	localObject2	Object
    //   968	46	10	localThrowable	Throwable
    //   977	32	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   939	965	968	finally
  }
  
  private final void b(ar paramar, KeyEvent paramKeyEvent)
  {
    int i1 = -1;
    Object localObject1;
    if ((!paramar.h) && (!this.m) && ((paramar.d != 0) || ((this.f.getResources().getConfiguration().screenLayout & 0xF) != 4)))
    {
      localObject1 = this.p.getCallback();
      if ((localObject1 == null) || (((Window.Callback)localObject1).onMenuOpened(paramar.d, paramar.l))) {
        break label82;
      }
      a(paramar, true);
    }
    label82:
    Object localObject2;
    label326:
    do
    {
      do
      {
        return;
        localObject1 = (WindowManager)this.f.getSystemService("window");
      } while ((localObject1 == null) || (!a(paramar, paramKeyEvent)));
      paramKeyEvent = paramar.c;
      if ((paramKeyEvent != null) && (!paramar.n))
      {
        paramKeyEvent = paramar.b;
        if (paramKeyEvent != null)
        {
          paramKeyEvent = paramKeyEvent.getLayoutParams();
          if (paramKeyEvent != null) {
            if (paramKeyEvent.width != -1) {}
          }
        }
        for (;;)
        {
          paramar.g = false;
          paramKeyEvent = new WindowManager.LayoutParams(i1, -2, 0, 0, 1002, 8519680, -3);
          paramKeyEvent.gravity = paramar.f;
          paramKeyEvent.windowAnimations = paramar.q;
          ((WindowManager)localObject1).addView(paramar.c, paramKeyEvent);
          paramar.h = true;
          return;
          i1 = -2;
          continue;
          i1 = -2;
          continue;
          i1 = -2;
        }
      }
      if (paramKeyEvent != null) {
        break label774;
      }
      localObject2 = m();
      TypedValue localTypedValue = new TypedValue();
      paramKeyEvent = ((Context)localObject2).getResources().newTheme();
      paramKeyEvent.setTo(((Context)localObject2).getTheme());
      paramKeyEvent.resolveAttribute(2130968578, localTypedValue, true);
      if (localTypedValue.resourceId != 0) {
        paramKeyEvent.applyStyle(localTypedValue.resourceId, true);
      }
      paramKeyEvent.resolveAttribute(2130969387, localTypedValue, true);
      if (localTypedValue.resourceId == 0) {
        break;
      }
      paramKeyEvent.applyStyle(localTypedValue.resourceId, true);
      localObject2 = new e((Context)localObject2, 0);
      ((Context)localObject2).getTheme().setTo(paramKeyEvent);
      paramar.k = ((Context)localObject2);
      paramKeyEvent = ((Context)localObject2).obtainStyledAttributes(android.support.v7.a.a.ay);
      paramar.a = paramKeyEvent.getResourceId(android.support.v7.a.a.aB, 0);
      paramar.q = paramKeyEvent.getResourceId(android.support.v7.a.a.az, 0);
      paramKeyEvent.recycle();
      paramar.c = new aq(this, paramar.k);
      paramar.f = 81;
    } while (paramar.c == null);
    for (;;)
    {
      paramKeyEvent = paramar.b;
      if (paramKeyEvent != null)
      {
        paramar.p = paramKeyEvent;
        label433:
        if ((paramar.p != null) && ((paramar.b != null) || (paramar.j.b().getCount() > 0)))
        {
          paramKeyEvent = paramar.p.getLayoutParams();
          if (paramKeyEvent == null) {
            paramKeyEvent = new ViewGroup.LayoutParams(-2, -2);
          }
          for (;;)
          {
            i1 = paramar.a;
            paramar.c.setBackgroundResource(i1);
            localObject2 = paramar.p.getParent();
            if ((localObject2 != null) && ((localObject2 instanceof ViewGroup))) {
              ((ViewGroup)localObject2).removeView(paramar.p);
            }
            paramar.c.addView(paramar.p, paramKeyEvent);
            if (!paramar.p.hasFocus())
            {
              paramar.p.requestFocus();
              i1 = -2;
              break;
            }
            i1 = -2;
            break;
          }
        }
      }
      else
      {
        if (paramar.l == null) {
          break;
        }
        if (this.J == null) {
          this.J = new as(this);
        }
        paramKeyEvent = this.J;
        if (paramar.l == null) {
          break label758;
        }
        if (paramar.j == null)
        {
          paramar.j = new android.support.v7.view.menu.m(paramar.k);
          localObject2 = paramar.j;
          ((android.support.v7.view.menu.m)localObject2).b = paramKeyEvent;
          paramar.l.a((android.support.v7.view.menu.af)localObject2);
        }
        paramKeyEvent = paramar.j;
        localObject2 = paramar.c;
        if (paramKeyEvent.f == null)
        {
          paramKeyEvent.f = ((ExpandedMenuView)paramKeyEvent.c.inflate(2131623949, (ViewGroup)localObject2, false));
          if (paramKeyEvent.a == null) {
            paramKeyEvent.a = new android.support.v7.view.menu.n(paramKeyEvent);
          }
          paramKeyEvent.f.setAdapter(paramKeyEvent.a);
          paramKeyEvent.f.setOnItemClickListener(paramKeyEvent);
        }
      }
      label758:
      for (paramKeyEvent = paramKeyEvent.f;; paramKeyEvent = null)
      {
        paramar.p = ((View)paramKeyEvent);
        if (paramar.p == null) {
          break;
        }
        break label433;
        break;
      }
      paramKeyEvent.applyStyle(2132018159, true);
      break label326;
      label774:
      if ((paramar.n) && (paramKeyEvent.getChildCount() > 0)) {
        paramar.c.removeAllViews();
      }
    }
  }
  
  private final void g(int paramInt)
  {
    this.k |= 1 << paramInt;
    if (!this.l)
    {
      android.support.v4.view.ac.a(this.p.getDecorView(), this.B);
      this.l = true;
    }
  }
  
  private final void p()
  {
    q();
    Object localObject;
    if ((this.j) && (this.r == null))
    {
      localObject = this.G;
      if (!(localObject instanceof Activity)) {
        break label67;
      }
      this.r = new bg((Activity)localObject, this.H);
    }
    for (;;)
    {
      localObject = this.r;
      if (localObject != null) {
        ((a)localObject).b(this.y);
      }
      return;
      label67:
      if ((localObject instanceof Dialog)) {
        this.r = new bg((Dialog)localObject);
      }
    }
  }
  
  private final void q()
  {
    Object localObject1;
    if (!this.N)
    {
      localObject1 = this.f.obtainStyledAttributes(android.support.v7.a.a.ay);
      if (!((TypedArray)localObject1).hasValue(android.support.v7.a.a.aD))
      {
        ((TypedArray)localObject1).recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
      }
      if (!((TypedArray)localObject1).getBoolean(android.support.v7.a.a.aM, false)) {
        break label1087;
      }
      c(1);
    }
    for (;;)
    {
      if (((TypedArray)localObject1).getBoolean(android.support.v7.a.a.aE, false)) {
        c(109);
      }
      if (((TypedArray)localObject1).getBoolean(android.support.v7.a.a.aF, false)) {
        c(10);
      }
      this.C = ((TypedArray)localObject1).getBoolean(android.support.v7.a.a.aA, false);
      ((TypedArray)localObject1).recycle();
      this.p.getDecorView();
      localObject1 = LayoutInflater.from(this.f);
      if (!this.S)
      {
        if (this.C)
        {
          localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(2131623948, null);
          this.H = false;
          this.j = false;
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("AppCompat does not support the current theme features: { windowActionBar: ");
            ((StringBuilder)localObject1).append(this.j);
            ((StringBuilder)localObject1).append(", windowActionBarOverlay: ");
            ((StringBuilder)localObject1).append(this.H);
            ((StringBuilder)localObject1).append(", android:windowIsFloating: ");
            ((StringBuilder)localObject1).append(this.C);
            ((StringBuilder)localObject1).append(", windowActionModeOverlay: ");
            ((StringBuilder)localObject1).append(this.I);
            ((StringBuilder)localObject1).append(", windowNoTitle: ");
            ((StringBuilder)localObject1).append(this.S);
            ((StringBuilder)localObject1).append(" }");
            throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
          }
          if (this.g == null) {
            this.R = ((TextView)((ViewGroup)localObject1).findViewById(2131429479));
          }
          id.b((View)localObject1);
          Object localObject2 = (ContentFrameLayout)((ViewGroup)localObject1).findViewById(2131427368);
          ViewGroup localViewGroup = (ViewGroup)this.p.findViewById(16908290);
          if (localViewGroup != null)
          {
            while (localViewGroup.getChildCount() > 0)
            {
              View localView = localViewGroup.getChildAt(0);
              localViewGroup.removeViewAt(0);
              ((ContentFrameLayout)localObject2).addView(localView);
            }
            localViewGroup.setId(-1);
            ((ContentFrameLayout)localObject2).setId(16908290);
            if ((localViewGroup instanceof FrameLayout)) {
              ((FrameLayout)localViewGroup).setForeground(null);
            }
          }
          this.p.setContentView((View)localObject1);
          ((ContentFrameLayout)localObject2).setAttachListener(new af(this));
          this.M = ((ViewGroup)localObject1);
          localObject1 = this.G;
          if ((localObject1 instanceof Activity)) {}
          for (localObject1 = ((Activity)localObject1).getTitle();; localObject1 = this.Q)
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = this.g;
              if (localObject2 == null) {
                break label773;
              }
              ((bi)localObject2).setWindowTitle((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = (ContentFrameLayout)this.M.findViewById(16908290);
              localObject2 = this.p.getDecorView();
              int i1 = ((View)localObject2).getPaddingLeft();
              int i2 = ((View)localObject2).getPaddingTop();
              int i3 = ((View)localObject2).getPaddingRight();
              int i4 = ((View)localObject2).getPaddingBottom();
              ((ContentFrameLayout)localObject1).a.set(i1, i2, i3, i4);
              if (android.support.v4.view.ac.I((View)localObject1)) {
                ((ContentFrameLayout)localObject1).requestLayout();
              }
              localObject2 = this.f.obtainStyledAttributes(android.support.v7.a.a.ay);
              ((TypedArray)localObject2).getValue(android.support.v7.a.a.aK, ((ContentFrameLayout)localObject1).getMinWidthMajor());
              ((TypedArray)localObject2).getValue(android.support.v7.a.a.aL, ((ContentFrameLayout)localObject1).getMinWidthMinor());
              if (((TypedArray)localObject2).hasValue(android.support.v7.a.a.aI)) {
                ((TypedArray)localObject2).getValue(android.support.v7.a.a.aI, ((ContentFrameLayout)localObject1).getFixedWidthMajor());
              }
              if (((TypedArray)localObject2).hasValue(android.support.v7.a.a.aJ)) {
                ((TypedArray)localObject2).getValue(android.support.v7.a.a.aJ, ((ContentFrameLayout)localObject1).getFixedWidthMinor());
              }
              if (((TypedArray)localObject2).hasValue(android.support.v7.a.a.aG)) {
                ((TypedArray)localObject2).getValue(android.support.v7.a.a.aG, ((ContentFrameLayout)localObject1).getFixedHeightMajor());
              }
              if (((TypedArray)localObject2).hasValue(android.support.v7.a.a.aH)) {
                ((TypedArray)localObject2).getValue(android.support.v7.a.a.aH, ((ContentFrameLayout)localObject1).getFixedHeightMinor());
              }
              ((TypedArray)localObject2).recycle();
              ((ContentFrameLayout)localObject1).requestLayout();
              this.N = true;
              localObject1 = d(0);
              if ((!this.m) && ((localObject1 == null) || (((ar)localObject1).l == null))) {
                g(108);
              }
              return;
              label773:
              localObject2 = this.r;
              if (localObject2 != null)
              {
                ((a)localObject2).c((CharSequence)localObject1);
              }
              else
              {
                localObject2 = this.R;
                if (localObject2 != null) {
                  ((TextView)localObject2).setText((CharSequence)localObject1);
                }
              }
            }
          }
          if (this.j)
          {
            localObject1 = new TypedValue();
            this.f.getTheme().resolveAttribute(2130968585, (TypedValue)localObject1, true);
            if (((TypedValue)localObject1).resourceId != 0) {}
            for (localObject1 = new e(this.f, ((TypedValue)localObject1).resourceId);; localObject1 = this.f)
            {
              localObject1 = (ViewGroup)LayoutInflater.from((Context)localObject1).inflate(2131623959, null);
              this.g = ((bi)((ViewGroup)localObject1).findViewById(2131427843));
              this.g.setWindowCallback(this.p.getCallback());
              if (this.H) {
                this.g.a(109);
              }
              if (this.A) {
                this.g.a(2);
              }
              if (this.z)
              {
                this.g.a(5);
                break;
              }
              break;
            }
          }
          localObject1 = null;
        }
      }
      if (this.I) {}
      for (localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(2131623958, null);; localObject1 = (ViewGroup)((LayoutInflater)localObject1).inflate(2131623957, null))
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          android.support.v4.view.ac.a((View)localObject1, new ad(this));
          break;
        }
        ((cf)localObject1).setOnFitSystemWindowsListener(new ae(this));
        break;
      }
      label1087:
      if (((TypedArray)localObject1).getBoolean(android.support.v7.a.a.aD, false)) {
        c(108);
      }
    }
  }
  
  private final void r()
  {
    if (this.N) {
      throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }
  }
  
  private final void s()
  {
    if (this.w == null)
    {
      Context localContext = this.f;
      if (be.a == null)
      {
        localContext = localContext.getApplicationContext();
        be.a = new be(localContext, (LocationManager)localContext.getSystemService("location"));
      }
      this.w = new ao(this, be.a);
    }
  }
  
  private final boolean t()
  {
    Object localObject;
    if (this.v)
    {
      localObject = this.f;
      if ((localObject instanceof Activity)) {
        localObject = ((Context)localObject).getPackageManager();
      }
    }
    try
    {
      Context localContext = this.f;
      int i1 = ((PackageManager)localObject).getActivityInfo(new ComponentName(localContext, localContext.getClass()), 0).configChanges;
      return (i1 & 0x200) == 0;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", localNameNotFoundException);
    }
    return false;
    return true;
  }
  
  public final a a()
  {
    p();
    return this.r;
  }
  
  final ar a(Menu paramMenu)
  {
    ar[] arrayOfar = this.K;
    if (arrayOfar != null) {}
    for (int i1 = arrayOfar.length;; i1 = 0)
    {
      int i2 = 0;
      if (i2 < i1)
      {
        ar localar = arrayOfar[i2];
        if (localar == null) {}
        while (localar.l != paramMenu)
        {
          i2 += 1;
          break;
        }
        return localar;
      }
      return null;
    }
  }
  
  final b a(c paramc)
  {
    o();
    Object localObject = this.b;
    if (localObject != null) {
      ((b)localObject).c();
    }
    localObject = this.e;
    if ((localObject != null) && (!this.m)) {}
    try
    {
      ((y)localObject).L_();
      if (this.d == null)
      {
        if (!this.C) {
          break label489;
        }
        TypedValue localTypedValue = new TypedValue();
        localObject = this.f.getTheme();
        ((Resources.Theme)localObject).resolveAttribute(2130968585, localTypedValue, true);
        if (localTypedValue.resourceId == 0) {
          break label481;
        }
        Resources.Theme localTheme = this.f.getResources().newTheme();
        localTheme.setTo((Resources.Theme)localObject);
        localTheme.applyStyle(localTypedValue.resourceId, true);
        localObject = new e(this.f, 0);
        ((Context)localObject).getTheme().setTo(localTheme);
        this.d = new ActionBarContextView((Context)localObject);
        this.c = new PopupWindow((Context)localObject, null, 2130968599);
        android.support.v4.widget.ak.a(this.c, 2);
        this.c.setContentView(this.d);
        this.c.setWidth(-1);
        ((Context)localObject).getTheme().resolveAttribute(2130968579, localTypedValue, true);
        int i1 = TypedValue.complexToDimensionPixelSize(localTypedValue.data, ((Context)localObject).getResources().getDisplayMetrics());
        this.d.setContentHeight(i1);
        this.c.setHeight(-2);
        this.o = new ag(this);
      }
      for (;;)
      {
        if (this.d != null)
        {
          o();
          this.d.b();
          localObject = new android.support.v7.view.f(this.d.getContext(), this.d, paramc);
          if (!paramc.a((b)localObject, ((b)localObject).b())) {
            break label473;
          }
          ((b)localObject).d();
          this.d.a((b)localObject);
          this.b = ((b)localObject);
          if (!n()) {
            break label419;
          }
          this.d.setAlpha(0.0F);
          this.h = android.support.v4.view.ac.t(this.d).a(1.0F);
          this.h.a(new ai(this));
          if (this.c != null) {
            this.p.getDecorView().post(this.o);
          }
        }
        for (;;)
        {
          if (this.b != null)
          {
            paramc = this.e;
            if (paramc != null) {
              paramc.K_();
            }
          }
          return this.b;
          label419:
          this.d.setAlpha(1.0F);
          this.d.setVisibility(0);
          this.d.sendAccessibilityEvent(32);
          if (!(this.d.getParent() instanceof View)) {
            break;
          }
          android.support.v4.view.ac.x((View)this.d.getParent());
          break;
          label473:
          this.b = null;
        }
        label481:
        localObject = this.f;
        break;
        label489:
        localObject = (ViewStubCompat)this.M.findViewById(2131427385);
        if (localObject != null)
        {
          ((ViewStubCompat)localObject).setLayoutInflater(LayoutInflater.from(m()));
          this.d = ((ActionBarContextView)((ViewStubCompat)localObject).a());
        }
      }
    }
    catch (AbstractMethodError localAbstractMethodError)
    {
      for (;;) {}
    }
  }
  
  public final View a(int paramInt)
  {
    q();
    return this.p.findViewById(paramInt);
  }
  
  final void a(int paramInt, ar paramar, Menu paramMenu)
  {
    if (paramMenu != null)
    {
      if (paramar == null) {}
      while (paramar.h)
      {
        if (!this.m) {
          this.G.onPanelClosed(paramInt, paramMenu);
        }
        return;
      }
      return;
    }
    ar localar;
    if (paramar != null) {
      localar = paramar;
    }
    for (;;)
    {
      paramar = localar;
      if (localar == null) {
        break;
      }
      paramMenu = localar.l;
      paramar = localar;
      break;
      localar = paramar;
      if (paramInt >= 0)
      {
        ar[] arrayOfar = this.K;
        localar = paramar;
        if (paramInt < arrayOfar.length) {
          localar = arrayOfar[paramInt];
        }
      }
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    Object localObject1 = this.G;
    if ((localObject1 instanceof Activity)) {}
    try
    {
      localObject1 = ca.b((Activity)localObject1);
      if (localObject1 != null)
      {
        localObject1 = this.r;
        if (localObject1 != null) {
          break label65;
        }
        this.y = true;
      }
      for (;;)
      {
        if ((paramBundle != null) && (this.D == -100)) {
          this.D = paramBundle.getInt("appcompat:local_night_mode", -100);
        }
        return;
        label65:
        ((a)localObject1).b(true);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  final void a(ar paramar, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    Object localObject;
    do
    {
      do
      {
        localObject = (WindowManager)this.f.getSystemService("window");
        if ((localObject != null) && (paramar.h))
        {
          ViewGroup localViewGroup = paramar.c;
          if (localViewGroup != null)
          {
            ((WindowManager)localObject).removeView(localViewGroup);
            if (paramBoolean) {
              a(paramar.d, paramar, null);
            }
          }
        }
        paramar.i = false;
        paramar.g = false;
        paramar.h = false;
        paramar.p = null;
        paramar.n = true;
        if (this.n == paramar) {
          this.n = null;
        }
        return;
      } while (paramar.d != 0);
      localObject = this.g;
    } while ((localObject == null) || (!((bi)localObject).c()));
    b(paramar.l);
  }
  
  public final void a(p paramp)
  {
    paramp = this.g;
    if ((paramp != null) && (paramp.b()) && ((!ViewConfiguration.get(this.f).hasPermanentMenuKey()) || (this.g.d())))
    {
      paramp = this.p.getCallback();
      if (this.g.c())
      {
        this.g.f();
        if (!this.m) {
          paramp.onPanelClosed(108, d(0).l);
        }
      }
      ar localar;
      p localp;
      do
      {
        do
        {
          return;
        } while ((paramp == null) || (this.m));
        if ((this.l) && ((this.k & 0x1) != 0))
        {
          this.p.getDecorView().removeCallbacks(this.B);
          this.B.run();
        }
        localar = d(0);
        localp = localar.l;
      } while ((localp == null) || (localar.o) || (!paramp.onPreparePanel(0, localar.b, localp)));
      paramp.onMenuOpened(108, localar.l);
      this.g.e();
      return;
    }
    paramp = d(0);
    paramp.n = true;
    a(paramp, false);
    b(paramp, null);
  }
  
  public final void a(Toolbar paramToolbar)
  {
    if ((this.G instanceof Activity))
    {
      a locala = a();
      if ((locala instanceof bg)) {
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
      }
      this.F = null;
      if (locala != null) {
        locala.m();
      }
      if (paramToolbar == null) {
        break label94;
      }
      paramToolbar = new ax(paramToolbar, ((Activity)this.G).getTitle(), this.u);
      this.r = paramToolbar;
      this.p.setCallback(paramToolbar.c);
    }
    for (;;)
    {
      h();
      return;
      label94:
      this.r = null;
      this.p.setCallback(this.u);
    }
  }
  
  public final void a(View paramView)
  {
    q();
    ViewGroup localViewGroup = (ViewGroup)this.M.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView);
    this.G.onContentChanged();
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    q();
    ViewGroup localViewGroup = (ViewGroup)this.M.findViewById(16908290);
    localViewGroup.removeAllViews();
    localViewGroup.addView(paramView, paramLayoutParams);
    this.G.onContentChanged();
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.Q = paramCharSequence;
    Object localObject = this.g;
    if (localObject != null) {
      ((bi)localObject).setWindowTitle(paramCharSequence);
    }
    do
    {
      return;
      localObject = this.r;
      if (localObject != null)
      {
        ((a)localObject).c(paramCharSequence);
        return;
      }
      localObject = this.R;
    } while (localObject == null);
    ((TextView)localObject).setText(paramCharSequence);
  }
  
  final boolean a(ar paramar, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramKeyEvent.isSystem()) {
      if (!paramar.i) {
        break label46;
      }
    }
    for (;;)
    {
      paramar = paramar.l;
      bool1 = bool2;
      if (paramar != null) {
        bool1 = paramar.performShortcut(paramInt, paramKeyEvent, 1);
      }
      label46:
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!a(paramar, paramKeyEvent));
    }
  }
  
  final boolean a(ar paramar, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject1;
    if (!this.m)
    {
      if (paramar.i) {
        break label721;
      }
      localObject1 = this.n;
      if (localObject1 != null) {
        break label705;
      }
    }
    for (;;)
    {
      Window.Callback localCallback = this.p.getCallback();
      if (localCallback != null) {
        paramar.b = localCallback.onCreatePanelView(paramar.d);
      }
      int i1 = paramar.d;
      if (i1 == 0) {
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          localObject1 = this.g;
          if (localObject1 != null) {
            ((bi)localObject1).g();
          }
        }
        if (paramar.b == null) {
          if (i1 != 0) {
            break label676;
          }
        }
        for (;;)
        {
          localObject1 = paramar.l;
          if ((localObject1 != null) && (!paramar.o))
          {
            paramar.l.e();
            localObject1 = paramar.e;
            if (localObject1 != null)
            {
              paramar.l.b((Bundle)localObject1);
              paramar.e = null;
            }
            if (localCallback.onPreparePanel(0, paramar.b, paramar.l)) {
              if (paramKeyEvent != null)
              {
                i1 = paramKeyEvent.getDeviceId();
                label183:
                if (KeyCharacterMap.load(i1).getKeyboardType() != 1)
                {
                  bool1 = true;
                  label197:
                  paramar.m = bool1;
                  paramar.l.setQwertyMode(paramar.m);
                  paramar.l.f();
                }
              }
            }
          }
          label239:
          label308:
          label391:
          label399:
          label586:
          label593:
          label637:
          label655:
          label662:
          label676:
          do
          {
            paramar.i = true;
            paramar.g = false;
            this.n = paramar;
            bool1 = true;
            return bool1;
            bool1 = false;
            break label197;
            i1 = -1;
            break label183;
            if (i1 != 0)
            {
              paramKeyEvent = this.g;
              if (paramKeyEvent != null) {
                paramKeyEvent.a(null, this.s);
              }
            }
            paramar.l.f();
            return false;
            Object localObject2;
            int i2;
            TypedValue localTypedValue;
            Resources.Theme localTheme;
            if (localObject1 == null)
            {
              localObject2 = this.f;
              i2 = paramar.d;
              if (i2 != 0) {
                break label662;
              }
              if (this.g == null) {
                break label655;
              }
              localTypedValue = new TypedValue();
              localTheme = ((Context)localObject2).getTheme();
              localTheme.resolveAttribute(2130968585, localTypedValue, true);
              if (localTypedValue.resourceId == 0) {
                break label637;
              }
              localObject1 = ((Context)localObject2).getResources().newTheme();
              ((Resources.Theme)localObject1).setTo(localTheme);
              ((Resources.Theme)localObject1).applyStyle(localTypedValue.resourceId, true);
              ((Resources.Theme)localObject1).resolveAttribute(2130968586, localTypedValue, true);
              if (localTypedValue.resourceId != 0) {
                break label593;
              }
              if (localObject1 == null) {
                break label586;
              }
              localObject2 = new e((Context)localObject2, 0);
              ((Context)localObject2).getTheme().setTo((Resources.Theme)localObject1);
              localObject1 = localObject2;
            }
            for (;;)
            {
              localObject1 = new p((Context)localObject1);
              ((p)localObject1).a(this);
              paramar.a((p)localObject1);
              bool1 = bool2;
              if (paramar.l == null) {
                break label239;
              }
              if (i1 == 0) {}
              for (;;)
              {
                paramar.l.e();
                if (!localCallback.onCreatePanelMenu(paramar.d, paramar.l))
                {
                  paramar.a(null);
                  bool1 = bool2;
                  if (i1 == 0) {
                    break label239;
                  }
                  paramar = this.g;
                  bool1 = bool2;
                  if (paramar == null) {
                    break label239;
                  }
                  paramar.a(null, this.s);
                  return false;
                }
                paramar.o = false;
                break;
                if (this.g != null)
                {
                  if (this.s == null) {
                    this.s = new ak(this);
                  }
                  this.g.a(paramar.l, this.s);
                }
              }
              localObject1 = localObject2;
              continue;
              Object localObject3 = localObject1;
              if (localObject1 == null)
              {
                localObject3 = ((Context)localObject2).getResources().newTheme();
                ((Resources.Theme)localObject3).setTo(localTheme);
              }
              ((Resources.Theme)localObject3).applyStyle(localTypedValue.resourceId, true);
              localObject1 = localObject3;
              break label399;
              localTheme.resolveAttribute(2130968586, localTypedValue, true);
              localObject1 = null;
              break label391;
              localObject1 = localObject2;
              continue;
              if (i2 == 108) {
                break label308;
              }
              localObject1 = localObject2;
            }
          } while ((this.r instanceof ax));
        }
        if (i1 != 108) {
          i1 = 0;
        } else {
          i1 = 1;
        }
      }
      label705:
      if (localObject1 != paramar) {
        a((ar)localObject1, false);
      }
    }
    label721:
    return true;
  }
  
  public final boolean a(p paramp, MenuItem paramMenuItem)
  {
    Window.Callback localCallback = this.p.getCallback();
    if ((localCallback != null) && (!this.m))
    {
      paramp = a(paramp.l());
      if (paramp != null) {
        return localCallback.onMenuItemSelected(paramp.d, paramMenuItem);
      }
    }
    return false;
  }
  
  final boolean a(KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject = this.G;
    if (((localObject instanceof android.support.v4.view.m)) || ((localObject instanceof at)))
    {
      localObject = this.p.getDecorView();
      if (localObject != null) {
        break label541;
      }
    }
    label280:
    label425:
    label430:
    label440:
    label541:
    while (!android.support.v4.view.ac.a((View)localObject, paramKeyEvent))
    {
      int i1;
      if ((paramKeyEvent.getKeyCode() != 82) || (!this.G.dispatchKeyEvent(paramKeyEvent)))
      {
        i1 = paramKeyEvent.getKeyCode();
        if (paramKeyEvent.getAction() == 0) {
          break label440;
        }
        switch (i1)
        {
        default: 
          bool1 = false;
        }
      }
      for (;;)
      {
        return bool1;
        bool1 = this.E;
        this.E = false;
        paramKeyEvent = d(0);
        if ((paramKeyEvent == null) || (!paramKeyEvent.h))
        {
          paramKeyEvent = this.b;
          if (paramKeyEvent != null)
          {
            paramKeyEvent.c();
            bool1 = true;
            continue;
          }
          paramKeyEvent = a();
          if (paramKeyEvent != null)
          {
            if (!paramKeyEvent.l()) {
              break;
            }
            return true;
          }
          bool1 = false;
          continue;
        }
        if (bool1)
        {
          bool1 = true;
        }
        else
        {
          a(paramKeyEvent, true);
          return true;
          if (this.b == null)
          {
            localObject = d(0);
            bi localbi = this.g;
            if ((localbi != null) && (localbi.b()) && (!ViewConfiguration.get(this.f).hasPermanentMenuKey())) {
              if (!this.g.c()) {
                if (!this.m) {
                  if (a((ar)localObject, paramKeyEvent))
                  {
                    bool1 = this.g.e();
                    if (!bool1) {}
                  }
                }
              }
            }
            for (;;)
            {
              paramKeyEvent = (AudioManager)this.f.getSystemService("audio");
              if (paramKeyEvent == null)
              {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                bool1 = true;
                break;
              }
              paramKeyEvent.playSoundEffect(0);
              bool1 = true;
              break;
              bool1 = true;
              break;
              bool1 = true;
              break;
              bool1 = true;
              break;
              bool1 = this.g.f();
              break label280;
              bool1 = ((ar)localObject).h;
              if ((bool1) || (((ar)localObject).g))
              {
                a((ar)localObject, true);
                break label280;
              }
              if (!((ar)localObject).i) {
                break label430;
              }
              if (((ar)localObject).o)
              {
                ((ar)localObject).i = false;
                if (!a((ar)localObject, paramKeyEvent)) {
                  break label425;
                }
              }
              b((ar)localObject, paramKeyEvent);
            }
            bool1 = true;
            continue;
            bool1 = true;
          }
          else
          {
            bool1 = true;
            continue;
            switch (i1)
            {
            default: 
              bool1 = false;
              break;
            case 4: 
              if ((paramKeyEvent.getFlags() & 0x80) != 0) {}
              for (bool1 = bool2;; bool1 = false)
              {
                this.E = bool1;
                return false;
              }
            case 82: 
              if (paramKeyEvent.getRepeatCount() == 0)
              {
                localObject = d(0);
                if (((ar)localObject).h)
                {
                  bool1 = true;
                }
                else
                {
                  a((ar)localObject, paramKeyEvent);
                  return true;
                }
              }
              else
              {
                bool1 = true;
              }
              break;
            }
          }
        }
      }
    }
    return true;
  }
  
  public final MenuInflater b()
  {
    if (this.F == null)
    {
      p();
      localObject = this.r;
      if (localObject != null) {
        break label42;
      }
    }
    label42:
    for (Object localObject = this.f;; localObject = ((a)localObject).f())
    {
      this.F = new i((Context)localObject);
      return this.F;
    }
  }
  
  public final void b(int paramInt)
  {
    q();
    ViewGroup localViewGroup = (ViewGroup)this.M.findViewById(16908290);
    localViewGroup.removeAllViews();
    LayoutInflater.from(this.f).inflate(paramInt, localViewGroup);
    this.G.onContentChanged();
  }
  
  public final void b(Bundle paramBundle)
  {
    int i1 = this.D;
    if (i1 != -100) {
      paramBundle.putInt("appcompat:local_night_mode", i1);
    }
  }
  
  final void b(p paramp)
  {
    if (!this.x)
    {
      this.x = true;
      this.g.h();
      Window.Callback localCallback = this.p.getCallback();
      if ((localCallback != null) && (!this.m)) {
        localCallback.onPanelClosed(108, paramp);
      }
      this.x = false;
    }
  }
  
  public final void b(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    q();
    ((ViewGroup)this.M.findViewById(16908290)).addView(paramView, paramLayoutParams);
    this.G.onContentChanged();
  }
  
  public final void c()
  {
    q();
  }
  
  public final boolean c(int paramInt)
  {
    int i1;
    if (paramInt == 8)
    {
      Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
      i1 = 108;
    }
    for (;;)
    {
      if (!this.S) {}
      while (i1 != 108)
      {
        if (!this.j) {}
        for (;;)
        {
          switch (i1)
          {
          default: 
            return this.p.requestFeature(i1);
          case 109: 
            r();
            this.H = true;
            return true;
          case 108: 
            r();
            this.j = true;
            return true;
          case 10: 
            r();
            this.I = true;
            return true;
          case 5: 
            r();
            this.z = true;
            return true;
          case 2: 
            r();
            this.A = true;
            return true;
          }
          r();
          this.S = true;
          return true;
          if (i1 == 1) {
            this.j = false;
          }
        }
      }
      return false;
      i1 = paramInt;
      if (paramInt == 9)
      {
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        i1 = 109;
      }
    }
  }
  
  protected final ar d(int paramInt)
  {
    Object localObject2 = this.K;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length > paramInt) {}
    }
    else
    {
      localObject1 = new ar[paramInt + 1];
      if (localObject2 != null) {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      this.K = ((ar[])localObject1);
    }
    localObject2 = localObject1[paramInt];
    if (localObject2 == null)
    {
      localObject2 = new ar(paramInt);
      localObject1[paramInt] = localObject2;
      return (ar)localObject2;
    }
    return (ar)localObject2;
  }
  
  public final void d()
  {
    if ((this.j) && (this.N))
    {
      a locala = a();
      if (locala != null) {
        locala.h();
      }
    }
    android.support.v7.widget.ae.a().a(this.f);
    l();
  }
  
  public final void e()
  {
    l();
  }
  
  final void e(int paramInt)
  {
    ar localar = d(paramInt);
    if (localar.l != null)
    {
      Bundle localBundle = new Bundle();
      localar.l.a(localBundle);
      if (localBundle.size() > 0) {
        localar.e = localBundle;
      }
      localar.l.e();
      localar.l.clear();
    }
    localar.o = true;
    localar.n = true;
    if (paramInt == 108) {}
    for (;;)
    {
      if (this.g != null)
      {
        localar = d(0);
        if (localar != null)
        {
          localar.i = false;
          a(localar, null);
        }
      }
      do
      {
        return;
      } while (paramInt != 0);
    }
  }
  
  final int f(int paramInt)
  {
    int i3 = 1;
    int i2 = 1;
    int i4 = 0;
    Object localObject1 = this.d;
    Object localObject2;
    int i1;
    if (localObject1 != null) {
      if ((((ActionBarContextView)localObject1).getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        localObject1 = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
        if (this.d.isShown())
        {
          if (this.O == null)
          {
            this.O = new Rect();
            this.P = new Rect();
          }
          localObject2 = this.O;
          Rect localRect = this.P;
          ((Rect)localObject2).set(0, paramInt, 0, 0);
          id.a(this.M, (Rect)localObject2, localRect);
          if (localRect.top == 0)
          {
            i1 = paramInt;
            if (((ViewGroup.MarginLayoutParams)localObject1).topMargin != i1)
            {
              ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramInt;
              localObject2 = this.L;
              if (localObject2 == null)
              {
                this.L = new View(this.f);
                this.L.setBackgroundColor(this.f.getResources().getColor(2131099655));
                this.M.addView(this.L, -1, new ViewGroup.LayoutParams(-1, paramInt));
                i1 = 1;
                label207:
                if (this.L != null) {
                  label214:
                  if (this.I)
                  {
                    label221:
                    i3 = i2;
                    i2 = i1;
                    i1 = i3;
                    label229:
                    if (i2 != 0) {
                      this.d.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = this.L;
      if (localObject1 != null)
      {
        i2 = i4;
        if (i1 == 0) {
          i2 = 8;
        }
        ((View)localObject1).setVisibility(i2);
      }
      return paramInt;
      continue;
      if (i2 == 0) {
        break label221;
      }
      paramInt = 0;
      break label221;
      i2 = 0;
      break label214;
      localObject2 = ((View)localObject2).getLayoutParams();
      if (((ViewGroup.LayoutParams)localObject2).height != paramInt)
      {
        ((ViewGroup.LayoutParams)localObject2).height = paramInt;
        this.L.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        i1 = 1;
        break label207;
      }
      i1 = 1;
      break label207;
      i1 = 0;
      break label207;
      i1 = 0;
      break;
      if (((ViewGroup.MarginLayoutParams)localObject1).topMargin != 0)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
        i1 = 0;
        i2 = i3;
        break label229;
      }
      i2 = 0;
      i1 = 0;
      break label229;
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  public final void f()
  {
    Object localObject = a();
    if (localObject != null) {
      ((a)localObject).c(false);
    }
    localObject = this.w;
    if (localObject != null) {
      ((ao)localObject).a();
    }
  }
  
  public final void g()
  {
    a locala = a();
    if (locala != null) {
      locala.c(true);
    }
  }
  
  public final void h()
  {
    a locala = a();
    if ((locala == null) || (!locala.k())) {
      g(0);
    }
  }
  
  public final void i()
  {
    if (this.l) {
      this.p.getDecorView().removeCallbacks(this.B);
    }
    this.m = true;
    Object localObject = this.r;
    if (localObject != null) {
      ((a)localObject).m();
    }
    localObject = this.w;
    if (localObject != null) {
      ((ao)localObject).a();
    }
  }
  
  public final f j()
  {
    return new aj(this);
  }
  
  public final void k()
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.f);
    if (localLayoutInflater.getFactory() == null) {
      android.support.v4.view.n.a(localLayoutInflater, this);
    }
    while ((localLayoutInflater.getFactory2() instanceof aa)) {
      return;
    }
    Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
  }
  
  public final boolean l()
  {
    Field localField2 = null;
    int i1 = this.D;
    int i2 = i1;
    if (i1 == -100) {
      i2 = z.a;
    }
    switch (i2)
    {
    default: 
      i1 = i2;
    }
    for (;;)
    {
      Resources localResources;
      Object localObject1;
      label85:
      boolean bool;
      if (i1 != -1)
      {
        localResources = this.f.getResources();
        localObject1 = localResources.getConfiguration();
        int i3 = ((Configuration)localObject1).uiMode;
        if (i1 == 2)
        {
          i1 = 32;
          if ((i3 & 0x30) != i1)
          {
            if (t())
            {
              ((Activity)this.f).recreate();
              bool = true;
              label113:
              if (i2 == 0)
              {
                s();
                localObject1 = this.w;
                ((ao)localObject1).a();
                if (((ao)localObject1).a == null) {
                  ((ao)localObject1).a = new ap((ao)localObject1);
                }
                if (((ao)localObject1).b == null)
                {
                  ((ao)localObject1).b = new IntentFilter();
                  ((ao)localObject1).b.addAction("android.intent.action.TIME_SET");
                  ((ao)localObject1).b.addAction("android.intent.action.TIMEZONE_CHANGED");
                  ((ao)localObject1).b.addAction("android.intent.action.TIME_TICK");
                }
                ((ao)localObject1).e.f.registerReceiver(((ao)localObject1).a, ((ao)localObject1).b);
              }
              this.v = true;
              return bool;
            }
            localObject1 = new Configuration((Configuration)localObject1);
            DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
            ((Configuration)localObject1).uiMode = (i1 | ((Configuration)localObject1).uiMode & 0xFFFFFFCF);
            localResources.updateConfiguration((Configuration)localObject1, localDisplayMetrics);
            if ((Build.VERSION.SDK_INT < 26) && ((Build.VERSION.SDK_INT < 28) && ((Build.VERSION.SDK_INT < 24) && ((Build.VERSION.SDK_INT < 23) && ((Build.VERSION.SDK_INT >= 21) && (aw.b)))))) {}
          }
        }
      }
      try
      {
        localObject1 = Resources.class.getDeclaredField("mDrawableCache");
        aw.a = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
        aw.b = true;
        if (aw.a == null) {}
      }
      catch (NoSuchFieldException localNoSuchFieldException4)
      {
        try
        {
          localObject1 = (Map)aw.a.get(localResources);
          if (localObject1 != null)
          {
            ((Map)localObject1).clear();
            bool = true;
            break label113;
          }
          bool = true;
          break label113;
          bool = true;
          break label113;
          bool = true;
          break label113;
          if (aw.b) {}
        }
        catch (IllegalAccessException localNoSuchFieldException4)
        {
          try
          {
            localObject1 = Resources.class.getDeclaredField("mDrawableCache");
            aw.a = (Field)localObject1;
            ((Field)localObject1).setAccessible(true);
            aw.b = true;
            localObject1 = localField2;
            if (aw.a == null) {}
          }
          catch (NoSuchFieldException localNoSuchFieldException4)
          {
            try
            {
              localObject1 = aw.a.get(localResources);
              if (localObject1 != null)
              {
                aw.a(localObject1);
                bool = true;
                break label113;
              }
              bool = true;
              break label113;
              if (aw.d) {}
            }
            catch (IllegalAccessException localNoSuchFieldException4)
            {
              try
              {
                localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
                aw.c = (Field)localObject1;
                ((Field)localObject1).setAccessible(true);
                aw.d = true;
                if (aw.c == null) {}
              }
              catch (NoSuchFieldException localNoSuchFieldException4)
              {
                try
                {
                  localObject1 = aw.c.get(localResources);
                  if (localObject1 != null) {
                    if (aw.b) {}
                  }
                }
                catch (IllegalAccessException localNoSuchFieldException4)
                {
                  try
                  {
                    localField2 = localObject1.getClass().getDeclaredField("mDrawableCache");
                    aw.a = localField2;
                    localField2.setAccessible(true);
                    aw.b = true;
                    if (aw.a == null) {}
                  }
                  catch (NoSuchFieldException localNoSuchFieldException4)
                  {
                    try
                    {
                      for (;;)
                      {
                        for (localObject1 = aw.a.get(localObject1);; localObject1 = null)
                        {
                          if (localObject1 != null)
                          {
                            aw.a(localObject1);
                            bool = true;
                            break;
                          }
                          bool = true;
                          break;
                        }
                        bool = true;
                        break label113;
                        bool = true;
                        break label113;
                        bool = true;
                        break label113;
                        bool = true;
                        break label113;
                        bool = false;
                        break label113;
                        i1 = 16;
                        break label85;
                        bool = false;
                        break label113;
                        if ((Build.VERSION.SDK_INT < 23) || (((UiModeManager)this.f.getSystemService(UiModeManager.class)).getNightMode() != 0))
                        {
                          s();
                          localObject1 = this.w;
                          ((ao)localObject1).c = ((ao)localObject1).d.a();
                          if (!((ao)localObject1).c)
                          {
                            i1 = 1;
                            break;
                          }
                          i1 = 2;
                          break;
                        }
                        i1 = -1;
                        break;
                        i1 = -1;
                        break;
                        localNoSuchFieldException1 = localNoSuchFieldException1;
                        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException1);
                        continue;
                        localIllegalAccessException1 = localIllegalAccessException1;
                        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException1);
                        Object localObject2 = null;
                        continue;
                        localNoSuchFieldException2 = localNoSuchFieldException2;
                        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException2);
                        continue;
                        localIllegalAccessException2 = localIllegalAccessException2;
                        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", localIllegalAccessException2);
                        Field localField1 = localField2;
                        continue;
                        localNoSuchFieldException3 = localNoSuchFieldException3;
                        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException3);
                        continue;
                        localIllegalAccessException3 = localIllegalAccessException3;
                        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", localIllegalAccessException3);
                        Object localObject3 = null;
                      }
                      localNoSuchFieldException4 = localNoSuchFieldException4;
                      Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException4);
                    }
                    catch (IllegalAccessException localIllegalAccessException4)
                    {
                      for (;;)
                      {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", localIllegalAccessException4);
                        Object localObject4 = null;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  final Context m()
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = ((a)localObject1).f();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.f;
      }
      return (Context)localObject2;
    }
  }
  
  final boolean n()
  {
    if (this.N)
    {
      ViewGroup localViewGroup = this.M;
      if ((localViewGroup != null) && (android.support.v4.view.ac.I(localViewGroup))) {
        return true;
      }
    }
    return false;
  }
  
  final void o()
  {
    az localaz = this.h;
    if (localaz != null) {
      localaz.a();
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return a(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */