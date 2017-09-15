package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.l;
import android.support.v4.view.a.f;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.w;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements p, w
{
  private static final int[] YS = { 16843830 };
  private static final boolean YT;
  static final boolean YU;
  private static final Class<?>[] YV;
  private static final Interpolator ZY;
  private final int[] Dd;
  private final int[] De;
  private final o YW;
  final m YX;
  private SavedState YY;
  e YZ;
  i ZA;
  public e ZB;
  private int ZC;
  private int ZD;
  private int ZE;
  private int ZF;
  private int ZG;
  private final int ZH;
  private final int ZI;
  private float ZJ;
  final s ZK;
  final q ZL;
  public k ZM;
  private List<k> ZN;
  boolean ZO;
  boolean ZP;
  private RecyclerView.e.b ZQ;
  private boolean ZR;
  private ac ZS;
  private d ZT;
  private final int[] ZU;
  private android.support.v4.view.q ZV;
  private final int[] ZW;
  private Runnable ZX;
  private final as.b ZZ;
  s Za;
  final as Zb;
  private boolean Zc;
  private final Runnable Zd;
  private a Ze;
  public h Zf;
  private n Zg;
  public final ArrayList<g> Zh;
  public final ArrayList<j> Zi;
  public j Zj;
  private boolean Zk;
  public boolean Zl;
  boolean Zm;
  private int Zn;
  private boolean Zo;
  boolean Zp;
  private boolean Zq;
  private int Zr;
  private boolean Zs;
  private final boolean Zt;
  public List<i> Zu;
  boolean Zv;
  private int Zw;
  i Zx;
  i Zy;
  i Zz;
  private final Rect eq;
  private VelocityTracker fk;
  private int iE;
  private final AccessibilityManager jl;
  public int xV;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      YT = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      YU = bool;
      YV = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      ZY = new Interpolator()
      {
        public final float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
        }
      };
      return;
      bool = false;
      break;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: iload_3
    //   7: invokespecial 254	android/view/ViewGroup:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   10: aload_0
    //   11: new 78	android/support/v7/widget/RecyclerView$o
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 257	android/support/v7/widget/RecyclerView$o:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   19: putfield 259	android/support/v7/widget/RecyclerView:YW	Landroid/support/v7/widget/RecyclerView$o;
    //   22: aload_0
    //   23: new 72	android/support/v7/widget/RecyclerView$m
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 260	android/support/v7/widget/RecyclerView$m:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   31: putfield 262	android/support/v7/widget/RecyclerView:YX	Landroid/support/v7/widget/RecyclerView$m;
    //   34: aload_0
    //   35: new 264	android/support/v7/widget/as
    //   38: dup
    //   39: invokespecial 265	android/support/v7/widget/as:<init>	()V
    //   42: putfield 267	android/support/v7/widget/RecyclerView:Zb	Landroid/support/v7/widget/as;
    //   45: aload_0
    //   46: new 10	android/support/v7/widget/RecyclerView$1
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 268	android/support/v7/widget/RecyclerView$1:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   54: putfield 270	android/support/v7/widget/RecyclerView:Zd	Ljava/lang/Runnable;
    //   57: aload_0
    //   58: new 272	android/graphics/Rect
    //   61: dup
    //   62: invokespecial 273	android/graphics/Rect:<init>	()V
    //   65: putfield 275	android/support/v7/widget/RecyclerView:eq	Landroid/graphics/Rect;
    //   68: aload_0
    //   69: new 277	java/util/ArrayList
    //   72: dup
    //   73: invokespecial 278	java/util/ArrayList:<init>	()V
    //   76: putfield 280	android/support/v7/widget/RecyclerView:Zh	Ljava/util/ArrayList;
    //   79: aload_0
    //   80: new 277	java/util/ArrayList
    //   83: dup
    //   84: invokespecial 278	java/util/ArrayList:<init>	()V
    //   87: putfield 282	android/support/v7/widget/RecyclerView:Zi	Ljava/util/ArrayList;
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 284	android/support/v7/widget/RecyclerView:Zn	I
    //   95: aload_0
    //   96: iconst_0
    //   97: putfield 286	android/support/v7/widget/RecyclerView:Zv	Z
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 288	android/support/v7/widget/RecyclerView:Zw	I
    //   105: aload_0
    //   106: new 290	android/support/v7/widget/v
    //   109: dup
    //   110: invokespecial 291	android/support/v7/widget/v:<init>	()V
    //   113: putfield 293	android/support/v7/widget/RecyclerView:ZB	Landroid/support/v7/widget/RecyclerView$e;
    //   116: aload_0
    //   117: iconst_0
    //   118: putfield 295	android/support/v7/widget/RecyclerView:xV	I
    //   121: aload_0
    //   122: iconst_m1
    //   123: putfield 297	android/support/v7/widget/RecyclerView:ZC	I
    //   126: aload_0
    //   127: ldc_w 298
    //   130: putfield 300	android/support/v7/widget/RecyclerView:ZJ	F
    //   133: aload_0
    //   134: new 92	android/support/v7/widget/RecyclerView$s
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 301	android/support/v7/widget/RecyclerView$s:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   142: putfield 303	android/support/v7/widget/RecyclerView:ZK	Landroid/support/v7/widget/RecyclerView$s;
    //   145: aload_0
    //   146: new 86	android/support/v7/widget/RecyclerView$q
    //   149: dup
    //   150: invokespecial 304	android/support/v7/widget/RecyclerView$q:<init>	()V
    //   153: putfield 306	android/support/v7/widget/RecyclerView:ZL	Landroid/support/v7/widget/RecyclerView$q;
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 308	android/support/v7/widget/RecyclerView:ZO	Z
    //   161: aload_0
    //   162: iconst_0
    //   163: putfield 310	android/support/v7/widget/RecyclerView:ZP	Z
    //   166: aload_0
    //   167: new 51	android/support/v7/widget/RecyclerView$f
    //   170: dup
    //   171: aload_0
    //   172: invokespecial 311	android/support/v7/widget/RecyclerView$f:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   175: putfield 313	android/support/v7/widget/RecyclerView:ZQ	Landroid/support/v7/widget/RecyclerView$e$b;
    //   178: aload_0
    //   179: iconst_0
    //   180: putfield 315	android/support/v7/widget/RecyclerView:ZR	Z
    //   183: aload_0
    //   184: iconst_2
    //   185: newarray <illegal type>
    //   187: putfield 317	android/support/v7/widget/RecyclerView:ZU	[I
    //   190: aload_0
    //   191: iconst_2
    //   192: newarray <illegal type>
    //   194: putfield 319	android/support/v7/widget/RecyclerView:Dd	[I
    //   197: aload_0
    //   198: iconst_2
    //   199: newarray <illegal type>
    //   201: putfield 321	android/support/v7/widget/RecyclerView:De	[I
    //   204: aload_0
    //   205: iconst_2
    //   206: newarray <illegal type>
    //   208: putfield 323	android/support/v7/widget/RecyclerView:ZW	[I
    //   211: aload_0
    //   212: new 12	android/support/v7/widget/RecyclerView$2
    //   215: dup
    //   216: aload_0
    //   217: invokespecial 324	android/support/v7/widget/RecyclerView$2:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   220: putfield 326	android/support/v7/widget/RecyclerView:ZX	Ljava/lang/Runnable;
    //   223: aload_0
    //   224: new 16	android/support/v7/widget/RecyclerView$4
    //   227: dup
    //   228: aload_0
    //   229: invokespecial 327	android/support/v7/widget/RecyclerView$4:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   232: putfield 329	android/support/v7/widget/RecyclerView:ZZ	Landroid/support/v7/widget/as$b;
    //   235: aload_0
    //   236: iconst_1
    //   237: invokevirtual 333	android/support/v7/widget/RecyclerView:setScrollContainer	(Z)V
    //   240: aload_0
    //   241: iconst_1
    //   242: invokevirtual 336	android/support/v7/widget/RecyclerView:setFocusableInTouchMode	(Z)V
    //   245: getstatic 210	android/os/Build$VERSION:SDK_INT	I
    //   248: bipush 16
    //   250: if_icmplt +384 -> 634
    //   253: iconst_1
    //   254: istore 4
    //   256: aload_0
    //   257: iload 4
    //   259: putfield 338	android/support/v7/widget/RecyclerView:Zt	Z
    //   262: aload_1
    //   263: invokestatic 344	android/view/ViewConfiguration:get	(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    //   266: astore 6
    //   268: aload_0
    //   269: aload 6
    //   271: invokevirtual 348	android/view/ViewConfiguration:getScaledTouchSlop	()I
    //   274: putfield 350	android/support/v7/widget/RecyclerView:iE	I
    //   277: aload_0
    //   278: aload 6
    //   280: invokevirtual 353	android/view/ViewConfiguration:getScaledMinimumFlingVelocity	()I
    //   283: putfield 355	android/support/v7/widget/RecyclerView:ZH	I
    //   286: aload_0
    //   287: aload 6
    //   289: invokevirtual 358	android/view/ViewConfiguration:getScaledMaximumFlingVelocity	()I
    //   292: putfield 360	android/support/v7/widget/RecyclerView:ZI	I
    //   295: aload_0
    //   296: invokestatic 366	android/support/v4/view/z:C	(Landroid/view/View;)I
    //   299: iconst_2
    //   300: if_icmpne +340 -> 640
    //   303: iconst_1
    //   304: istore 4
    //   306: aload_0
    //   307: iload 4
    //   309: invokevirtual 369	android/support/v7/widget/RecyclerView:setWillNotDraw	(Z)V
    //   312: aload_0
    //   313: getfield 293	android/support/v7/widget/RecyclerView:ZB	Landroid/support/v7/widget/RecyclerView$e;
    //   316: aload_0
    //   317: getfield 313	android/support/v7/widget/RecyclerView:ZQ	Landroid/support/v7/widget/RecyclerView$e$b;
    //   320: putfield 372	android/support/v7/widget/RecyclerView$e:aad	Landroid/support/v7/widget/RecyclerView$e$b;
    //   323: aload_0
    //   324: new 374	android/support/v7/widget/e
    //   327: dup
    //   328: new 20	android/support/v7/widget/RecyclerView$6
    //   331: dup
    //   332: aload_0
    //   333: invokespecial 375	android/support/v7/widget/RecyclerView$6:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   336: invokespecial 378	android/support/v7/widget/e:<init>	(Landroid/support/v7/widget/e$a;)V
    //   339: putfield 380	android/support/v7/widget/RecyclerView:YZ	Landroid/support/v7/widget/e;
    //   342: aload_0
    //   343: new 382	android/support/v7/widget/s
    //   346: dup
    //   347: new 18	android/support/v7/widget/RecyclerView$5
    //   350: dup
    //   351: aload_0
    //   352: invokespecial 383	android/support/v7/widget/RecyclerView$5:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   355: invokespecial 386	android/support/v7/widget/s:<init>	(Landroid/support/v7/widget/s$b;)V
    //   358: putfield 388	android/support/v7/widget/RecyclerView:Za	Landroid/support/v7/widget/s;
    //   361: aload_0
    //   362: invokestatic 391	android/support/v4/view/z:G	(Landroid/view/View;)I
    //   365: ifne +8 -> 373
    //   368: aload_0
    //   369: iconst_1
    //   370: invokestatic 394	android/support/v4/view/z:i	(Landroid/view/View;I)V
    //   373: aload_0
    //   374: aload_0
    //   375: invokevirtual 398	android/support/v7/widget/RecyclerView:getContext	()Landroid/content/Context;
    //   378: ldc_w 400
    //   381: invokevirtual 404	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   384: checkcast 406	android/view/accessibility/AccessibilityManager
    //   387: putfield 408	android/support/v7/widget/RecyclerView:jl	Landroid/view/accessibility/AccessibilityManager;
    //   390: aload_0
    //   391: new 410	android/support/v7/widget/ac
    //   394: dup
    //   395: aload_0
    //   396: invokespecial 411	android/support/v7/widget/ac:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   399: putfield 413	android/support/v7/widget/RecyclerView:ZS	Landroid/support/v7/widget/ac;
    //   402: aload_0
    //   403: aload_0
    //   404: getfield 413	android/support/v7/widget/RecyclerView:ZS	Landroid/support/v7/widget/ac;
    //   407: invokestatic 416	android/support/v4/view/z:a	(Landroid/view/View;Landroid/support/v4/view/a;)V
    //   410: iload 5
    //   412: istore 4
    //   414: aload_2
    //   415: ifnull +212 -> 627
    //   418: aload_1
    //   419: aload_2
    //   420: getstatic 421	android/support/v7/d/a$c:cC	[I
    //   423: iload_3
    //   424: iconst_0
    //   425: invokevirtual 425	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   428: astore 6
    //   430: aload 6
    //   432: getstatic 428	android/support/v7/d/a$c:Oz	I
    //   435: invokevirtual 434	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   438: astore 7
    //   440: aload 6
    //   442: invokevirtual 437	android/content/res/TypedArray:recycle	()V
    //   445: aload 7
    //   447: ifnull +145 -> 592
    //   450: aload 7
    //   452: invokevirtual 443	java/lang/String:trim	()Ljava/lang/String;
    //   455: astore 6
    //   457: aload 6
    //   459: invokevirtual 446	java/lang/String:length	()I
    //   462: ifeq +130 -> 592
    //   465: aload 6
    //   467: iconst_0
    //   468: invokevirtual 450	java/lang/String:charAt	(I)C
    //   471: bipush 46
    //   473: if_icmpne +173 -> 646
    //   476: new 452	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   483: aload_1
    //   484: invokevirtual 456	android/content/Context:getPackageName	()Ljava/lang/String;
    //   487: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 6
    //   492: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: astore 6
    //   500: aload_0
    //   501: invokevirtual 467	android/support/v7/widget/RecyclerView:isInEditMode	()Z
    //   504: ifeq +192 -> 696
    //   507: aload_0
    //   508: invokevirtual 473	java/lang/Object:getClass	()Ljava/lang/Class;
    //   511: invokevirtual 477	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   514: astore 7
    //   516: aload 7
    //   518: aload 6
    //   520: invokevirtual 483	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   523: ldc 57
    //   525: invokevirtual 487	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   528: astore 9
    //   530: aload 9
    //   532: getstatic 228	android/support/v7/widget/RecyclerView:YV	[Ljava/lang/Class;
    //   535: invokevirtual 491	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   538: astore 7
    //   540: iconst_4
    //   541: anewarray 469	java/lang/Object
    //   544: astore 8
    //   546: aload 8
    //   548: iconst_0
    //   549: aload_1
    //   550: aastore
    //   551: aload 8
    //   553: iconst_1
    //   554: aload_2
    //   555: aastore
    //   556: aload 8
    //   558: iconst_2
    //   559: iload_3
    //   560: invokestatic 495	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: aload 8
    //   566: iconst_3
    //   567: iconst_0
    //   568: invokestatic 495	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   571: aastore
    //   572: aload 7
    //   574: iconst_1
    //   575: invokevirtual 500	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   578: aload_0
    //   579: aload 7
    //   581: aload 8
    //   583: invokevirtual 504	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   586: checkcast 57	android/support/v7/widget/RecyclerView$h
    //   589: invokevirtual 507	android/support/v7/widget/RecyclerView:a	(Landroid/support/v7/widget/RecyclerView$h;)V
    //   592: iload 5
    //   594: istore 4
    //   596: getstatic 210	android/os/Build$VERSION:SDK_INT	I
    //   599: bipush 21
    //   601: if_icmplt +26 -> 627
    //   604: aload_1
    //   605: aload_2
    //   606: getstatic 205	android/support/v7/widget/RecyclerView:YS	[I
    //   609: iload_3
    //   610: iconst_0
    //   611: invokevirtual 425	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   614: astore_1
    //   615: aload_1
    //   616: iconst_0
    //   617: iconst_1
    //   618: invokevirtual 511	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   621: istore 4
    //   623: aload_1
    //   624: invokevirtual 437	android/content/res/TypedArray:recycle	()V
    //   627: aload_0
    //   628: iload 4
    //   630: invokevirtual 514	android/support/v7/widget/RecyclerView:setNestedScrollingEnabled	(Z)V
    //   633: return
    //   634: iconst_0
    //   635: istore 4
    //   637: goto -381 -> 256
    //   640: iconst_0
    //   641: istore 4
    //   643: goto -337 -> 306
    //   646: aload 6
    //   648: ldc_w 516
    //   651: invokevirtual 520	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   654: ifeq +6 -> 660
    //   657: goto -157 -> 500
    //   660: new 452	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   667: ldc 2
    //   669: invokevirtual 524	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   672: invokevirtual 529	java/lang/Package:getName	()Ljava/lang/String;
    //   675: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: bipush 46
    //   680: invokevirtual 532	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   683: aload 6
    //   685: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: astore 6
    //   693: goto -193 -> 500
    //   696: aload_1
    //   697: invokevirtual 533	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   700: astore 7
    //   702: goto -186 -> 516
    //   705: astore 8
    //   707: aload 9
    //   709: iconst_0
    //   710: anewarray 216	java/lang/Class
    //   713: invokevirtual 491	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   716: astore 7
    //   718: aconst_null
    //   719: astore 8
    //   721: goto -149 -> 572
    //   724: astore_1
    //   725: aload_1
    //   726: aload 8
    //   728: invokevirtual 537	java/lang/NoSuchMethodException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   731: pop
    //   732: new 539	java/lang/IllegalStateException
    //   735: dup
    //   736: new 452	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   743: aload_2
    //   744: invokeinterface 542 1 0
    //   749: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: ldc_w 544
    //   755: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload 6
    //   760: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: aload_1
    //   767: invokespecial 547	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   770: athrow
    //   771: astore_1
    //   772: new 539	java/lang/IllegalStateException
    //   775: dup
    //   776: new 452	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   783: aload_2
    //   784: invokeinterface 542 1 0
    //   789: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 549
    //   795: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload 6
    //   800: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: aload_1
    //   807: invokespecial 547	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   810: athrow
    //   811: astore_1
    //   812: new 539	java/lang/IllegalStateException
    //   815: dup
    //   816: new 452	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   823: aload_2
    //   824: invokeinterface 542 1 0
    //   829: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc_w 551
    //   835: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload 6
    //   840: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: aload_1
    //   847: invokespecial 547	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   850: athrow
    //   851: astore_1
    //   852: new 539	java/lang/IllegalStateException
    //   855: dup
    //   856: new 452	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   863: aload_2
    //   864: invokeinterface 542 1 0
    //   869: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: ldc_w 551
    //   875: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: aload 6
    //   880: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: aload_1
    //   887: invokespecial 547	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   890: athrow
    //   891: astore_1
    //   892: new 539	java/lang/IllegalStateException
    //   895: dup
    //   896: new 452	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   903: aload_2
    //   904: invokeinterface 542 1 0
    //   909: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: ldc_w 553
    //   915: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload 6
    //   920: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: aload_1
    //   927: invokespecial 547	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   930: athrow
    //   931: astore_1
    //   932: new 539	java/lang/IllegalStateException
    //   935: dup
    //   936: new 452	java/lang/StringBuilder
    //   939: dup
    //   940: invokespecial 453	java/lang/StringBuilder:<init>	()V
    //   943: aload_2
    //   944: invokeinterface 542 1 0
    //   949: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: ldc_w 555
    //   955: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload 6
    //   960: invokevirtual 460	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: invokevirtual 463	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: aload_1
    //   967: invokespecial 547	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   970: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	971	0	this	RecyclerView
    //   0	971	1	paramContext	Context
    //   0	971	2	paramAttributeSet	AttributeSet
    //   0	971	3	paramInt	int
    //   254	388	4	bool1	boolean
    //   1	592	5	bool2	boolean
    //   266	693	6	localObject1	Object
    //   438	279	7	localObject2	Object
    //   544	38	8	arrayOfObject	Object[]
    //   705	1	8	localNoSuchMethodException	NoSuchMethodException
    //   719	8	8	localThrowable	Throwable
    //   528	180	9	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   530	546	705	java/lang/NoSuchMethodException
    //   556	572	705	java/lang/NoSuchMethodException
    //   707	718	724	java/lang/NoSuchMethodException
    //   500	516	771	java/lang/ClassNotFoundException
    //   516	530	771	java/lang/ClassNotFoundException
    //   530	546	771	java/lang/ClassNotFoundException
    //   556	572	771	java/lang/ClassNotFoundException
    //   572	592	771	java/lang/ClassNotFoundException
    //   696	702	771	java/lang/ClassNotFoundException
    //   707	718	771	java/lang/ClassNotFoundException
    //   725	771	771	java/lang/ClassNotFoundException
    //   500	516	811	java/lang/reflect/InvocationTargetException
    //   516	530	811	java/lang/reflect/InvocationTargetException
    //   530	546	811	java/lang/reflect/InvocationTargetException
    //   556	572	811	java/lang/reflect/InvocationTargetException
    //   572	592	811	java/lang/reflect/InvocationTargetException
    //   696	702	811	java/lang/reflect/InvocationTargetException
    //   707	718	811	java/lang/reflect/InvocationTargetException
    //   725	771	811	java/lang/reflect/InvocationTargetException
    //   500	516	851	java/lang/InstantiationException
    //   516	530	851	java/lang/InstantiationException
    //   530	546	851	java/lang/InstantiationException
    //   556	572	851	java/lang/InstantiationException
    //   572	592	851	java/lang/InstantiationException
    //   696	702	851	java/lang/InstantiationException
    //   707	718	851	java/lang/InstantiationException
    //   725	771	851	java/lang/InstantiationException
    //   500	516	891	java/lang/IllegalAccessException
    //   516	530	891	java/lang/IllegalAccessException
    //   530	546	891	java/lang/IllegalAccessException
    //   556	572	891	java/lang/IllegalAccessException
    //   572	592	891	java/lang/IllegalAccessException
    //   696	702	891	java/lang/IllegalAccessException
    //   707	718	891	java/lang/IllegalAccessException
    //   725	771	891	java/lang/IllegalAccessException
    //   500	516	931	java/lang/ClassCastException
    //   516	530	931	java/lang/ClassCastException
    //   530	546	931	java/lang/ClassCastException
    //   556	572	931	java/lang/ClassCastException
    //   572	592	931	java/lang/ClassCastException
    //   696	702	931	java/lang/ClassCastException
    //   707	718	931	java/lang/ClassCastException
    //   725	771	931	java/lang/ClassCastException
  }
  
  private void M(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.Zx != null)
    {
      bool1 = bool2;
      if (!this.Zx.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0) {
          bool1 = this.Zx.cr();
        }
      }
    }
    bool2 = bool1;
    if (this.Zz != null)
    {
      bool2 = bool1;
      if (!this.Zz.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0) {
          bool2 = bool1 | this.Zz.cr();
        }
      }
    }
    bool1 = bool2;
    if (this.Zy != null)
    {
      bool1 = bool2;
      if (!this.Zy.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0) {
          bool1 = bool2 | this.Zy.cr();
        }
      }
    }
    bool2 = bool1;
    if (this.ZA != null)
    {
      bool2 = bool1;
      if (!this.ZA.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0) {
          bool2 = bool1 | this.ZA.cr();
        }
      }
    }
    if (bool2) {
      z.F(this);
    }
  }
  
  private void X(int paramInt)
  {
    if (paramInt == this.xV) {}
    for (;;)
    {
      return;
      this.xV = paramInt;
      if (paramInt != 2) {
        fr();
      }
      if (this.Zf != null) {
        this.Zf.bi(paramInt);
      }
      if (this.ZM != null) {
        this.ZM.e(this, paramInt);
      }
      if (this.ZN != null)
      {
        int i = this.ZN.size() - 1;
        while (i >= 0)
        {
          ((k)this.ZN.get(i)).e(this, paramInt);
          i -= 1;
        }
      }
    }
  }
  
  private void a(t paramt, RecyclerView.e.c paramc)
  {
    paramt.setFlags(0, 8192);
    if ((this.ZL.aaZ) && (paramt.gs()) && (!paramt.isRemoved()) && (!paramt.gd()))
    {
      long l = g(paramt);
      this.Zb.a(l, paramt);
    }
    this.Zb.b(paramt, paramc);
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i3 = 0;
    int m = 0;
    int i1 = 0;
    int n = 0;
    int i = 0;
    int k = 0;
    int i2 = 0;
    fo();
    if (this.Ze != null)
    {
      fp();
      fz();
      android.support.v4.os.e.beginSection("RV Scroll");
      j = i3;
      if (paramInt1 != 0)
      {
        i = this.Zf.a(paramInt1, this.YX, this.ZL);
        j = paramInt1 - i;
      }
      k = i2;
      m = i1;
      if (paramInt2 != 0)
      {
        k = this.Zf.b(paramInt2, this.YX, this.ZL);
        m = paramInt2 - k;
      }
      android.support.v4.os.e.endSection();
      fM();
      fA();
      R(false);
      n = i;
    }
    if (!this.Zh.isEmpty()) {
      invalidate();
    }
    if (dispatchNestedScroll(n, k, j, m, this.Dd))
    {
      this.ZF -= this.Dd[0];
      this.ZG -= this.Dd[1];
      if (paramMotionEvent != null) {
        paramMotionEvent.offsetLocation(this.Dd[0], this.Dd[1]);
      }
      paramMotionEvent = this.ZW;
      paramMotionEvent[0] += this.Dd[0];
      paramMotionEvent = this.ZW;
      paramMotionEvent[1] += this.Dd[1];
    }
    while (z.C(this) == 2)
    {
      if ((n != 0) || (k != 0)) {
        O(n, k);
      }
      if (!awakenScrollBars()) {
        invalidate();
      }
      if ((n == 0) && (k == 0)) {
        break;
      }
      return true;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    if (paramMotionEvent != null)
    {
      f1 = paramMotionEvent.getX();
      f2 = j;
      f3 = paramMotionEvent.getY();
      f4 = m;
      j = 0;
      if (f2 >= 0.0F) {
        break label460;
      }
      fs();
      i = j;
      if (this.Zx.h(-f2 / getWidth(), 1.0F - f3 / getHeight())) {
        i = 1;
      }
      label383:
      if (f4 >= 0.0F) {
        break label511;
      }
      fu();
      j = i;
      if (this.Zy.h(-f4 / getHeight(), f1 / getWidth())) {
        j = 1;
      }
    }
    for (;;)
    {
      if ((j != 0) || (f2 != 0.0F) || (f4 != 0.0F)) {
        z.F(this);
      }
      M(paramInt1, paramInt2);
      break;
      label460:
      i = j;
      if (f2 <= 0.0F) {
        break label383;
      }
      ft();
      i = j;
      if (!this.Zz.h(f2 / getWidth(), f3 / getHeight())) {
        break label383;
      }
      i = 1;
      break label383;
      label511:
      j = i;
      if (f4 > 0.0F)
      {
        fv();
        j = i;
        if (this.ZA.h(f4 / getHeight(), 1.0F - f1 / getWidth())) {
          j = 1;
        }
      }
    }
    return false;
  }
  
  static t aZ(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).aas;
  }
  
  public static int ba(View paramView)
  {
    paramView = aZ(paramView);
    if (paramView != null) {
      return paramView.gf();
    }
    return -1;
  }
  
  public static int bb(View paramView)
  {
    paramView = aZ(paramView);
    if (paramView != null) {
      return paramView.ge();
    }
    return -1;
  }
  
  private void bd(View paramView)
  {
    aZ(paramView);
    if (this.Zu != null)
    {
      int i = this.Zu.size() - 1;
      while (i >= 0)
      {
        ((i)this.Zu.get(i)).bm(paramView);
        i -= 1;
      }
    }
  }
  
  private void d(int[] paramArrayOfInt)
  {
    int i2 = this.Za.getChildCount();
    if (i2 == 0)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return;
    }
    int i = Integer.MAX_VALUE;
    int k = Integer.MIN_VALUE;
    int n = 0;
    int m;
    int j;
    if (n < i2)
    {
      t localt = aZ(this.Za.getChildAt(n));
      m = i;
      if (localt.gd()) {
        break label122;
      }
      int i1 = localt.ge();
      j = i;
      if (i1 < i) {
        j = i1;
      }
      m = j;
      if (i1 <= k) {
        break label122;
      }
      i = i1;
    }
    for (;;)
    {
      n += 1;
      k = i;
      i = j;
      break;
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = k;
      return;
      label122:
      i = k;
      j = m;
    }
  }
  
  private void f(t paramt)
  {
    View localView = paramt.abf;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.YX.p(aQ(localView));
      if (!paramt.gn()) {
        break;
      }
      this.Za.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.Za.a(localView, -1, true);
      return;
    }
    paramt = this.Za;
    i = paramt.VL.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + localView);
    }
    paramt.VM.set(i);
    paramt.aN(localView);
  }
  
  private void fA()
  {
    this.Zw -= 1;
    if (this.Zw <= 0)
    {
      this.Zw = 0;
      int i = this.Zr;
      this.Zr = 0;
      if ((i != 0) && (fB()))
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
        localAccessibilityEvent.setEventType(2048);
        android.support.v4.view.a.a.a(localAccessibilityEvent, i);
        sendAccessibilityEventUnchecked(localAccessibilityEvent);
      }
    }
  }
  
  private boolean fC()
  {
    return this.Zw > 0;
  }
  
  private void fD()
  {
    if ((!this.ZR) && (this.Zk))
    {
      z.a(this, this.ZX);
      this.ZR = true;
    }
  }
  
  private boolean fE()
  {
    return (this.ZB != null) && (this.Zf.eQ());
  }
  
  private void fF()
  {
    boolean bool2 = true;
    if (this.Zv)
    {
      this.YZ.reset();
      fL();
      this.Zf.eM();
    }
    int i;
    label57:
    q localq;
    if (fE())
    {
      this.YZ.er();
      if ((!this.ZO) && (!this.ZP)) {
        break label176;
      }
      i = 1;
      localq = this.ZL;
      if ((!this.Zm) || (this.ZB == null) || ((!this.Zv) && (i == 0) && (!this.Zf.aam)) || ((this.Zv) && (!this.Ze.aac))) {
        break label181;
      }
      bool1 = true;
      label117:
      localq.aaX = bool1;
      localq = this.ZL;
      if ((!this.ZL.aaX) || (i == 0) || (this.Zv) || (!fE())) {
        break label186;
      }
    }
    label176:
    label181:
    label186:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localq.aaY = bool1;
      return;
      this.YZ.eu();
      break;
      i = 0;
      break label57;
      bool1 = false;
      break label117;
    }
  }
  
  private void fG()
  {
    if (this.Ze == null) {}
    for (;;)
    {
      return;
      if (this.Zf != null)
      {
        this.ZL.aba = false;
        Object localObject1;
        long l;
        RecyclerView.e.c localc;
        t localt;
        boolean bool1;
        boolean bool2;
        Object localObject2;
        int k;
        if (this.ZL.aaQ == 1)
        {
          fH();
          this.Zf.z(this);
          fI();
          this.ZL.bn(4);
          fp();
          fz();
          this.ZL.aaQ = 1;
          if (!this.ZL.aaX) {
            break label639;
          }
          i = this.Za.getChildCount() - 1;
          if (i < 0) {
            break label628;
          }
          localObject1 = aZ(this.Za.getChildAt(i));
          if (!((t)localObject1).gd())
          {
            l = g((t)localObject1);
            localc = new RecyclerView.e.c().b((t)localObject1, 0);
            localt = (t)this.Zb.afF.get(l);
            if ((localt == null) || (localt.gd())) {
              break label614;
            }
            bool1 = this.Zb.u(localt);
            bool2 = this.Zb.u((t)localObject1);
            if ((bool1) && (localt == localObject1)) {
              break label614;
            }
            localObject2 = this.Zb.c(localt, 4);
            this.Zb.c((t)localObject1, localc);
            localc = this.Zb.c((t)localObject1, 8);
            if (localObject2 != null) {
              break label519;
            }
            k = this.Za.getChildCount();
            j = 0;
          }
        }
        else
        {
          for (;;)
          {
            if (j >= k) {
              break label485;
            }
            localObject2 = aZ(this.Za.getChildAt(j));
            if ((localObject2 != localObject1) && (g((t)localObject2) == l))
            {
              if ((this.Ze != null) && (this.Ze.aac))
              {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localObject2 + " \n View Holder 2:" + localObject1);
                localObject1 = this.YZ;
                if ((!((e)localObject1).Ud.isEmpty()) && (!((e)localObject1).Uc.isEmpty())) {}
                for (i = 1;; i = 0)
                {
                  if ((i == 0) && (this.Zf.aar == getWidth()) && (this.Zf.RQ == getHeight())) {
                    break label430;
                  }
                  this.Zf.z(this);
                  fI();
                  break;
                }
                label430:
                this.Zf.z(this);
                break;
              }
              throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localObject2 + " \n View Holder 2:" + localObject1);
            }
            j += 1;
          }
          label485:
          new StringBuilder("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ").append(localt).append(" cannot be found but it is necessary for ").append(localObject1);
        }
        for (;;)
        {
          i -= 1;
          break;
          label519:
          localt.U(false);
          if (bool1) {
            f(localt);
          }
          if (localt != localObject1)
          {
            if (bool2) {
              f((t)localObject1);
            }
            localt.abk = ((t)localObject1);
            f(localt);
            this.YX.p(localt);
            ((t)localObject1).U(false);
            ((t)localObject1).abl = localt;
          }
          if (this.ZB.a(localt, (t)localObject1, (RecyclerView.e.c)localObject2, localc))
          {
            fD();
            continue;
            label614:
            this.Zb.c((t)localObject1, localc);
          }
        }
        label628:
        this.Zb.a(this.ZZ);
        label639:
        this.Zf.c(this.YX);
        this.ZL.aaT = this.ZL.aaS;
        this.Zv = false;
        this.ZL.aaX = false;
        this.ZL.aaY = false;
        this.Zf.aam = false;
        if (this.YX.aaz != null) {
          this.YX.aaz.clear();
        }
        fA();
        R(false);
        this.Zb.clear();
        int i = this.ZU[0];
        int j = this.ZU[1];
        if (this.Za.getChildCount() == 0) {
          if ((i != 0) || (j != 0)) {
            i = 1;
          }
        }
        while (i != 0)
        {
          O(0, 0);
          return;
          i = 0;
          continue;
          d(this.ZU);
          if ((this.ZU[0] != i) || (this.ZU[1] != j)) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  private void fH()
  {
    this.ZL.bn(1);
    this.ZL.aba = false;
    fp();
    this.Zb.clear();
    fz();
    fF();
    Object localObject1 = this.ZL;
    if ((this.ZL.aaX) && (this.ZP)) {}
    int j;
    int i;
    Object localObject2;
    for (boolean bool = true;; bool = false)
    {
      ((q)localObject1).aaZ = bool;
      this.ZP = false;
      this.ZO = false;
      this.ZL.aaW = this.ZL.aaY;
      this.ZL.aaS = this.Ze.getItemCount();
      d(this.ZU);
      if (!this.ZL.aaX) {
        break;
      }
      j = this.Za.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject1 = aZ(this.Za.getChildAt(i));
        if ((!((t)localObject1).gd()) && ((!((t)localObject1).gl()) || (this.Ze.aac)))
        {
          localObject2 = this.ZB.a(this.ZL, (t)localObject1, e.j((t)localObject1), ((t)localObject1).gp());
          this.Zb.b((t)localObject1, (RecyclerView.e.c)localObject2);
          if ((this.ZL.aaZ) && (((t)localObject1).gs()) && (!((t)localObject1).isRemoved()) && (!((t)localObject1).gd()) && (!((t)localObject1).gl()))
          {
            long l = g((t)localObject1);
            this.Zb.a(l, (t)localObject1);
          }
        }
        i += 1;
      }
    }
    if (this.ZL.aaY)
    {
      j = this.Za.eG();
      i = 0;
      while (i < j)
      {
        localObject1 = aZ(this.Za.aN(i));
        if ((!((t)localObject1).gd()) && (((t)localObject1).abg == -1)) {
          ((t)localObject1).abg = ((t)localObject1).kC;
        }
        i += 1;
      }
      bool = this.ZL.aaV;
      this.ZL.aaV = false;
      this.Zf.c(this.YX, this.ZL);
      this.ZL.aaV = bool;
      i = 0;
      if (i < this.Za.getChildCount())
      {
        t localt = aZ(this.Za.getChildAt(i));
        label469:
        RecyclerView.e.c localc;
        if (!localt.gd())
        {
          localObject1 = (as.a)this.Zb.afE.get(localt);
          if ((localObject1 == null) || ((((as.a)localObject1).flags & 0x4) == 0)) {
            break label543;
          }
          j = 1;
          if (j == 0)
          {
            int k = e.j(localt);
            bool = localt.bo(8192);
            j = k;
            if (!bool) {
              j = k | 0x1000;
            }
            localc = this.ZB.a(this.ZL, localt, j, localt.gp());
            if (!bool) {
              break label548;
            }
            a(localt, localc);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label543:
          j = 0;
          break label469;
          label548:
          as localas = this.Zb;
          localObject2 = (as.a)localas.afE.get(localt);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = as.a.he();
            localas.afE.put(localt, localObject1);
          }
          ((as.a)localObject1).flags |= 0x2;
          ((as.a)localObject1).afG = localc;
        }
      }
      fK();
    }
    for (;;)
    {
      fA();
      R(false);
      this.ZL.aaQ = 2;
      return;
      fK();
    }
  }
  
  private void fI()
  {
    fp();
    fz();
    this.ZL.bn(6);
    this.YZ.eu();
    this.ZL.aaS = this.Ze.getItemCount();
    this.ZL.aaU = 0;
    this.ZL.aaW = false;
    this.Zf.c(this.YX, this.ZL);
    this.ZL.aaV = false;
    this.YY = null;
    q localq = this.ZL;
    if ((this.ZL.aaX) && (this.ZB != null)) {}
    for (boolean bool = true;; bool = false)
    {
      localq.aaX = bool;
      this.ZL.aaQ = 4;
      fA();
      R(false);
      return;
    }
  }
  
  private void fK()
  {
    int j = 0;
    int k = this.Za.eG();
    int i = 0;
    while (i < k)
    {
      localObject = aZ(this.Za.aN(i));
      if (!((t)localObject).gd()) {
        ((t)localObject).gb();
      }
      i += 1;
    }
    Object localObject = this.YX;
    k = ((m)localObject).aaA.size();
    i = 0;
    while (i < k)
    {
      ((t)((m)localObject).aaA.get(i)).gb();
      i += 1;
    }
    k = ((m)localObject).aay.size();
    i = 0;
    while (i < k)
    {
      ((t)((m)localObject).aay.get(i)).gb();
      i += 1;
    }
    if (((m)localObject).aaz != null)
    {
      k = ((m)localObject).aaz.size();
      i = j;
      while (i < k)
      {
        ((t)((m)localObject).aaz.get(i)).gb();
        i += 1;
      }
    }
  }
  
  private void fL()
  {
    int j = this.Za.eG();
    int i = 0;
    while (i < j)
    {
      localObject = aZ(this.Za.aN(i));
      if ((localObject != null) && (!((t)localObject).gd())) {
        ((t)localObject).addFlags(6);
      }
      i += 1;
    }
    fJ();
    Object localObject = this.YX;
    if ((((m)localObject).aaa.Ze != null) && (((m)localObject).aaa.Ze.aac))
    {
      j = ((m)localObject).aaA.size();
      i = 0;
    }
    while (i < j)
    {
      t localt = (t)((m)localObject).aaA.get(i);
      if (localt != null)
      {
        localt.addFlags(6);
        localt.R(null);
      }
      i += 1;
      continue;
      ((m)localObject).fW();
    }
  }
  
  private void fM()
  {
    int j = this.Za.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.Za.getChildAt(i);
      Object localObject = aQ(localView);
      if ((localObject != null) && (((t)localObject).abl != null))
      {
        localObject = ((t)localObject).abl.abf;
        int k = localView.getLeft();
        int m = localView.getTop();
        if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
          ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
        }
      }
      i += 1;
    }
  }
  
  private android.support.v4.view.q fN()
  {
    if (this.ZV == null) {
      this.ZV = new android.support.v4.view.q(this);
    }
    return this.ZV;
  }
  
  private void fo()
  {
    int k = 0;
    if (!this.Zm) {}
    label160:
    label167:
    do
    {
      do
      {
        return;
        if (this.Zv)
        {
          android.support.v4.os.e.beginSection("RV FullInvalidate");
          fG();
          android.support.v4.os.e.endSection();
          return;
        }
      } while (!this.YZ.et());
      if ((this.YZ.aH(4)) && (!this.YZ.aH(11)))
      {
        android.support.v4.os.e.beginSection("RV PartialInvalidate");
        fp();
        this.YZ.er();
        int i;
        if (!this.Zo)
        {
          int m = this.Za.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            t localt = aZ(this.Za.getChildAt(i));
            if ((localt == null) || (localt.gd()) || (!localt.gs())) {
              break label160;
            }
            j = 1;
          }
          if (j == 0) {
            break label167;
          }
          fG();
        }
        for (;;)
        {
          R(true);
          android.support.v4.os.e.endSection();
          return;
          i += 1;
          break;
          this.YZ.es();
        }
      }
    } while (!this.YZ.et());
    android.support.v4.os.e.beginSection("RV FullInvalidate");
    fG();
    android.support.v4.os.e.endSection();
  }
  
  private void fq()
  {
    X(0);
    fr();
  }
  
  private void fr()
  {
    this.ZK.stop();
    if (this.Zf != null) {
      this.Zf.fV();
    }
  }
  
  private void fw()
  {
    this.ZA = null;
    this.Zy = null;
    this.Zz = null;
    this.Zx = null;
  }
  
  private void fx()
  {
    if (this.fk != null) {
      this.fk.clear();
    }
    stopNestedScroll();
    boolean bool2 = false;
    if (this.Zx != null) {
      bool2 = this.Zx.cr();
    }
    boolean bool1 = bool2;
    if (this.Zy != null) {
      bool1 = bool2 | this.Zy.cr();
    }
    bool2 = bool1;
    if (this.Zz != null) {
      bool2 = bool1 | this.Zz.cr();
    }
    bool1 = bool2;
    if (this.ZA != null) {
      bool1 = bool2 | this.ZA.cr();
    }
    if (bool1) {
      z.F(this);
    }
  }
  
  private void fy()
  {
    fx();
    X(0);
  }
  
  private void fz()
  {
    this.Zw += 1;
  }
  
  private long g(t paramt)
  {
    if (this.Ze.aac) {
      return paramt.abh;
    }
    return paramt.kC;
  }
  
  private int h(t paramt)
  {
    int i;
    if ((paramt.bo(524)) || (!paramt.isBound())) {
      i = -1;
    }
    e locale;
    int j;
    int n;
    int m;
    do
    {
      return i;
      locale = this.YZ;
      j = paramt.kC;
      n = locale.Uc.size();
      m = 0;
      i = j;
    } while (m >= n);
    paramt = (e.b)locale.Uc.get(m);
    switch (paramt.ou)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      m += 1;
      j = i;
      break;
      i = j;
      if (paramt.Uj <= j)
      {
        i = j + paramt.Ul;
        continue;
        i = j;
        if (paramt.Uj <= j)
        {
          if (paramt.Uj + paramt.Ul > j) {
            return -1;
          }
          i = j - paramt.Ul;
          continue;
          if (paramt.Uj == j)
          {
            i = paramt.Ul;
          }
          else
          {
            int k = j;
            if (paramt.Uj < j) {
              k = j - 1;
            }
            i = k;
            if (paramt.Ul <= k) {
              i = k + 1;
            }
          }
        }
      }
    }
  }
  
  private void m(MotionEvent paramMotionEvent)
  {
    int i = o.e(paramMotionEvent);
    if (o.c(paramMotionEvent, i) == this.ZC) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.ZC = o.c(paramMotionEvent, i);
      int j = (int)(o.d(paramMotionEvent, i) + 0.5F);
      this.ZF = j;
      this.ZD = j;
      i = (int)(o.e(paramMotionEvent, i) + 0.5F);
      this.ZG = i;
      this.ZE = i;
      return;
    }
  }
  
  final void N(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(h.j(paramInt1, getPaddingLeft() + getPaddingRight(), z.T(this)), h.j(paramInt2, getPaddingTop() + getPaddingBottom(), z.U(this)));
  }
  
  final void O(int paramInt1, int paramInt2)
  {
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.ZM != null) {
      this.ZM.c(this, paramInt1, paramInt2);
    }
    if (this.ZN != null)
    {
      i = this.ZN.size() - 1;
      while (i >= 0)
      {
        ((k)this.ZN.get(i)).c(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
  }
  
  final void R(boolean paramBoolean)
  {
    if (this.Zn <= 0) {
      this.Zn = 1;
    }
    if (!paramBoolean) {
      this.Zo = false;
    }
    if (this.Zn == 1)
    {
      if ((paramBoolean) && (this.Zo) && (!this.Zp) && (this.Zf != null) && (this.Ze != null)) {
        fG();
      }
      if (!this.Zp) {
        this.Zo = false;
      }
    }
    this.Zn -= 1;
  }
  
  public final void S(boolean paramBoolean)
  {
    if (paramBoolean != this.Zp)
    {
      q("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.Zp = false;
        if ((this.Zo) && (this.Zf != null) && (this.Ze != null)) {
          requestLayout();
        }
        this.Zo = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    this.Zp = true;
    this.Zq = true;
    fq();
  }
  
  public void a(a parama)
  {
    S(false);
    if (this.Ze != null) {
      this.Ze.b(this.YW);
    }
    if (this.ZB != null) {
      this.ZB.eL();
    }
    if (this.Zf != null)
    {
      this.Zf.d(this.YX);
      this.Zf.c(this.YX);
    }
    this.YX.clear();
    this.YZ.reset();
    a locala = this.Ze;
    this.Ze = parama;
    if (parama != null) {
      parama.a(this.YW);
    }
    Object localObject = this.YX;
    parama = this.Ze;
    ((m)localObject).clear();
    localObject = ((m)localObject).fX();
    if (locala != null) {
      ((l)localObject).aax -= 1;
    }
    if (((l)localObject).aax == 0) {
      ((l)localObject).aav.clear();
    }
    if (parama != null) {
      ((l)localObject).aax += 1;
    }
    this.ZL.aaV = true;
    fL();
    requestLayout();
  }
  
  public final void a(d paramd)
  {
    if (paramd == this.ZT) {
      return;
    }
    this.ZT = paramd;
    if (this.ZT != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public final void a(e parame)
  {
    if (this.ZB != null)
    {
      this.ZB.eL();
      this.ZB.aad = null;
    }
    this.ZB = parame;
    if (this.ZB != null) {
      this.ZB.aad = this.ZQ;
    }
  }
  
  public final void a(g paramg)
  {
    if (this.Zf != null) {
      this.Zf.q("Cannot add item decoration during a scroll  or layout");
    }
    if (this.Zh.isEmpty()) {
      setWillNotDraw(false);
    }
    this.Zh.add(paramg);
    fJ();
    requestLayout();
  }
  
  public void a(h paramh)
  {
    if (paramh == this.Zf) {
      return;
    }
    fq();
    if (this.Zf != null)
    {
      if (this.Zk) {
        this.Zf.b(this, this.YX);
      }
      this.Zf.y(null);
    }
    this.YX.clear();
    s locals = this.Za;
    for (s.a locala = locals.VM;; locala = locala.VP)
    {
      locala.VO = 0L;
      if (locala.VP == null) {
        break;
      }
    }
    int i = locals.VN.size() - 1;
    while (i >= 0)
    {
      locals.VL.aS((View)locals.VN.get(i));
      locals.VN.remove(i);
      i -= 1;
    }
    locals.VL.removeAllViews();
    this.Zf = paramh;
    if (paramh != null)
    {
      if (paramh.aak != null) {
        throw new IllegalArgumentException("LayoutManager " + paramh + " is already attached to a RecyclerView: " + paramh.aak);
      }
      this.Zf.y(this);
      if (this.Zk) {
        this.Zf.hi = true;
      }
    }
    requestLayout();
  }
  
  public final void a(k paramk)
  {
    if (this.ZN == null) {
      this.ZN = new ArrayList();
    }
    this.ZN.add(paramk);
  }
  
  public final t aQ(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return aZ(paramView);
  }
  
  public void aX(int paramInt)
  {
    if (this.Zp) {}
    do
    {
      return;
      fq();
    } while (this.Zf == null);
    this.Zf.aX(paramInt);
    awakenScrollBars();
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }
  
  public final t bb(int paramInt)
  {
    if (this.Zv) {}
    for (;;)
    {
      return null;
      int j = this.Za.eG();
      int i = 0;
      while (i < j)
      {
        t localt = aZ(this.Za.aN(i));
        if ((localt != null) && (!localt.isRemoved()) && (h(localt) == paramInt)) {
          return localt;
        }
        i += 1;
      }
    }
  }
  
  final Rect bc(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.aat) {
      return localLayoutParams.WM;
    }
    Rect localRect = localLayoutParams.WM;
    localRect.set(0, 0, 0, 0);
    int j = this.Zh.size();
    int i = 0;
    while (i < j)
    {
      this.eq.set(0, 0, 0, 0);
      ((g)this.Zh.get(i)).a(this.eq, paramView, this);
      localRect.left += this.eq.left;
      localRect.top += this.eq.top;
      localRect.right += this.eq.right;
      localRect.bottom += this.eq.bottom;
      i += 1;
    }
    localLayoutParams.aat = false;
    return localRect;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.Zf.a((LayoutParams)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.Zf == null) {}
    while (!this.Zf.eR()) {
      return 0;
    }
    return this.Zf.d(this.ZL);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.Zf == null) {}
    while (!this.Zf.eR()) {
      return 0;
    }
    return this.Zf.b(this.ZL);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.Zf == null) {}
    while (!this.Zf.eR()) {
      return 0;
    }
    return this.Zf.f(this.ZL);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.Zf == null) {}
    while (!this.Zf.eS()) {
      return 0;
    }
    return this.Zf.e(this.ZL);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.Zf == null) {}
    while (!this.Zf.eS()) {
      return 0;
    }
    return this.Zf.c(this.ZL);
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.Zf == null) {}
    while (!this.Zf.eS()) {
      return 0;
    }
    return this.Zf.g(this.ZL);
  }
  
  final void d(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.Za.eG();
    int i = 0;
    if (i < j)
    {
      localObject = aZ(this.Za.aN(i));
      if ((localObject != null) && (!((t)localObject).gd()))
      {
        if (((t)localObject).kC < paramInt1 + paramInt2) {
          break label82;
        }
        ((t)localObject).p(-paramInt2, paramBoolean);
        this.ZL.aaV = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (((t)localObject).kC >= paramInt1)
        {
          int k = -paramInt2;
          ((t)localObject).addFlags(8);
          ((t)localObject).p(k, paramBoolean);
          ((t)localObject).kC = (paramInt1 - 1);
          this.ZL.aaV = true;
        }
      }
    }
    Object localObject = this.YX;
    i = ((m)localObject).aaA.size() - 1;
    if (i >= 0)
    {
      t localt = (t)((m)localObject).aaA.get(i);
      if (localt != null)
      {
        if (localt.kC < paramInt1 + paramInt2) {
          break label200;
        }
        localt.p(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label200:
        if (localt.kC >= paramInt1)
        {
          localt.addFlags(8);
          ((m)localObject).bl(i);
        }
      }
    }
    requestLayout();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return fN().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return fN().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return fN().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return fN().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int m = 0;
    super.draw(paramCanvas);
    int j = this.Zh.size();
    int i = 0;
    while (i < j)
    {
      ((g)this.Zh.get(i)).b(paramCanvas, this);
      i += 1;
    }
    int n;
    if ((this.Zx != null) && (!this.Zx.isFinished()))
    {
      n = paramCanvas.save();
      if (this.Zc)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.Zx == null) || (!this.Zx.draw(paramCanvas))) {
          break label452;
        }
        j = 1;
        label124:
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      i = j;
      if (this.Zy != null)
      {
        i = j;
        if (!this.Zy.isFinished())
        {
          n = paramCanvas.save();
          if (this.Zc) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.Zy == null) || (!this.Zy.draw(paramCanvas))) {
            break label457;
          }
          i = 1;
          label198:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.Zz != null)
      {
        j = i;
        if (!this.Zz.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.Zc) {
            break label462;
          }
          j = getPaddingTop();
          label253:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.Zz == null) || (!this.Zz.draw(paramCanvas))) {
            break label467;
          }
          j = 1;
          label291:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.ZA != null)
      {
        i = j;
        if (!this.ZA.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.Zc) {
            break label472;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label368:
          i = m;
          if (this.ZA != null)
          {
            i = m;
            if (this.ZA.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.ZB != null) && (this.Zh.size() > 0) && (this.ZB.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          z.F(this);
        }
        return;
        i = 0;
        break;
        label452:
        j = 0;
        break label124;
        label457:
        i = 0;
        break label198;
        label462:
        j = 0;
        break label253;
        label467:
        j = 0;
        break label291;
        label472:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label368;
      }
      j = 0;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  final boolean fB()
  {
    return (this.jl != null) && (this.jl.isEnabled());
  }
  
  public final void fJ()
  {
    int j = 0;
    int k = this.Za.eG();
    int i = 0;
    while (i < k)
    {
      ((LayoutParams)this.Za.aN(i).getLayoutParams()).aat = true;
      i += 1;
    }
    m localm = this.YX;
    k = localm.aaA.size();
    i = j;
    while (i < k)
    {
      LayoutParams localLayoutParams = (LayoutParams)((t)localm.aaA.get(i)).abf.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.aat = true;
      }
      i += 1;
    }
  }
  
  public a fn()
  {
    return this.Ze;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    View localView2 = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localView2;
      if (this.Ze != null)
      {
        localView1 = localView2;
        if (this.Zf != null)
        {
          localView1 = localView2;
          if (!fC())
          {
            localView1 = localView2;
            if (!this.Zp)
            {
              fp();
              localView1 = this.Zf.a(paramView, paramInt, this.YX, this.ZL);
              R(false);
            }
          }
        }
      }
    }
    if (localView1 != null) {
      return localView1;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  final void fp()
  {
    this.Zn += 1;
    if ((this.Zn == 1) && (!this.Zp)) {
      this.Zo = false;
    }
  }
  
  final void fs()
  {
    if (this.Zx != null) {
      return;
    }
    this.Zx = new i(getContext());
    if (this.Zc)
    {
      this.Zx.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.Zx.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  final void ft()
  {
    if (this.Zz != null) {
      return;
    }
    this.Zz = new i(getContext());
    if (this.Zc)
    {
      this.Zz.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.Zz.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  final void fu()
  {
    if (this.Zy != null) {
      return;
    }
    this.Zy = new i(getContext());
    if (this.Zc)
    {
      this.Zy.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.Zy.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  final void fv()
  {
    if (this.ZA != null) {
      return;
    }
    this.ZA = new i(getContext());
    if (this.Zc)
    {
      this.ZA.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.ZA.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.Zf == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.Zf.eN();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.Zf == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.Zf.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.Zf == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.Zf.e(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (this.Zf != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  public int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.ZT == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.ZT.X(paramInt1, paramInt2);
  }
  
  public boolean hasNestedScrollingParent()
  {
    return fN().hasNestedScrollingParent();
  }
  
  public boolean isAttachedToWindow()
  {
    return this.Zk;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return fN().xk;
  }
  
  public final View j(float paramFloat1, float paramFloat2)
  {
    int i = this.Za.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.Za.getChildAt(i);
      float f1 = z.R(localView);
      float f2 = z.S(localView);
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= f1 + localView.getRight()) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.Zw = 0;
    this.Zk = true;
    this.Zm = false;
    if (this.Zf != null) {
      this.Zf.hi = true;
    }
    this.ZR = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.ZB != null) {
      this.ZB.eL();
    }
    this.Zm = false;
    fq();
    this.Zk = false;
    if (this.Zf != null) {
      this.Zf.b(this, this.YX);
    }
    removeCallbacks(this.ZX);
    as.a.hf();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.Zh.size();
    int i = 0;
    while (i < j)
    {
      ((g)this.Zh.get(i)).a(paramCanvas, this);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    if (this.Zf == null) {}
    label171:
    label174:
    for (;;)
    {
      return false;
      if ((!this.Zp) && ((o.g(paramMotionEvent) & 0x2) != 0) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        if (this.Zf.eS())
        {
          f1 = -o.f(paramMotionEvent, 9);
          if (!this.Zf.eR()) {
            break label171;
          }
        }
        for (float f2 = o.f(paramMotionEvent, 10);; f2 = 0.0F)
        {
          if ((f1 == 0.0F) && (f2 == 0.0F)) {
            break label174;
          }
          if (this.ZJ == Float.MIN_VALUE)
          {
            TypedValue localTypedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
              this.ZJ = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
          }
          else
          {
            f3 = this.ZJ;
          }
          a((int)(f2 * f3), (int)(f1 * f3), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = -1;
    boolean bool1 = true;
    if (this.Zp)
    {
      bool1 = false;
      return bool1;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.Zj = null;
    }
    int m = this.Zi.size();
    int i = 0;
    if (i < m)
    {
      j localj = (j)this.Zi.get(i);
      if ((localj.n(paramMotionEvent)) && (j != 3)) {
        this.Zj = localj;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label114;
      }
      fy();
      return true;
      i += 1;
      break;
    }
    label114:
    if (this.Zf == null) {
      return false;
    }
    boolean bool2 = this.Zf.eR();
    boolean bool3 = this.Zf.eS();
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
    this.fk.addMovement(paramMotionEvent);
    j = o.d(paramMotionEvent);
    i = o.e(paramMotionEvent);
    switch (j)
    {
    case 4: 
    default: 
      if (this.xV != 1) {
        return false;
      }
      break;
    case 0: 
      label216:
      if (this.Zq) {
        this.Zq = false;
      }
      this.ZC = o.c(paramMotionEvent, 0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.ZF = i;
      this.ZD = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.ZG = i;
      this.ZE = i;
      if (this.xV == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        X(1);
      }
      paramMotionEvent = this.ZW;
      this.ZW[1] = 0;
      paramMotionEvent[0] = 0;
      if (!bool2) {}
      break;
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool3) {
        j = i | 0x2;
      }
      startNestedScroll(j);
      break label216;
      this.ZC = o.c(paramMotionEvent, i);
      j = (int)(o.d(paramMotionEvent, i) + 0.5F);
      this.ZF = j;
      this.ZD = j;
      i = (int)(o.e(paramMotionEvent, i) + 0.5F);
      this.ZG = i;
      this.ZE = i;
      break label216;
      j = o.b(paramMotionEvent, this.ZC);
      if (j < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.ZC).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(o.d(paramMotionEvent, j) + 0.5F);
      j = (int)(o.e(paramMotionEvent, j) + 0.5F);
      if (this.xV == 1) {
        break label216;
      }
      i -= this.ZD;
      m = j - this.ZE;
      int n;
      if ((bool2) && (Math.abs(i) > this.iE))
      {
        j = this.ZD;
        n = this.iE;
        if (i < 0)
        {
          i = -1;
          label524:
          this.ZF = (i * n + j);
        }
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool3)
        {
          j = i;
          if (Math.abs(m) > this.iE)
          {
            j = this.ZE;
            n = this.iE;
            if (m >= 0) {
              break label605;
            }
          }
        }
        label605:
        for (i = k;; i = 1)
        {
          this.ZG = (j + i * n);
          j = 1;
          if (j == 0) {
            break;
          }
          X(1);
          break;
          i = 1;
          break label524;
        }
        m(paramMotionEvent);
        break label216;
        this.fk.clear();
        stopNestedScroll();
        break label216;
        fy();
        break label216;
        break;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    android.support.v4.os.e.beginSection("RV OnLayout");
    fG();
    android.support.v4.os.e.endSection();
    this.Zm = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.Zf == null) {
      N(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!this.Zf.aan) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
        this.Zf.aa(paramInt1, paramInt2);
      } while ((i != 0) || (this.Ze == null));
      if (this.ZL.aaQ == 1) {
        fH();
      }
      this.Zf.Y(paramInt1, paramInt2);
      this.ZL.aba = true;
      fI();
      this.Zf.Z(paramInt1, paramInt2);
    } while (!this.Zf.eX());
    this.Zf.Y(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    this.ZL.aba = true;
    fI();
    this.Zf.Z(paramInt1, paramInt2);
    return;
    if (this.Zl)
    {
      this.Zf.aa(paramInt1, paramInt2);
      return;
    }
    if (this.Zs)
    {
      fp();
      fF();
      if (this.ZL.aaY)
      {
        this.ZL.aaW = true;
        this.Zs = false;
        R(false);
      }
    }
    else
    {
      if (this.Ze == null) {
        break label313;
      }
    }
    label313:
    for (this.ZL.aaS = this.Ze.getItemCount();; this.ZL.aaS = 0)
    {
      fp();
      this.Zf.aa(paramInt1, paramInt2);
      R(false);
      this.ZL.aaW = false;
      return;
      this.YZ.eu();
      this.ZL.aaW = false;
      break;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      this.YY = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(this.YY.getSuperState());
    } while ((this.Zf == null) || (this.YY.aaF == null));
    this.Zf.onRestoreInstanceState(this.YY.aaF);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.YY != null)
    {
      SavedState.a(localSavedState, this.YY);
      return localSavedState;
    }
    if (this.Zf != null)
    {
      localSavedState.aaF = this.Zf.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.aaF = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      fw();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.Zp) || (this.Zq)) {}
    label144:
    label153:
    label159:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.Zj != null)
      {
        if (i == 0) {
          this.Zj = null;
        }
      }
      else
      {
        if (i == 0) {
          break label153;
        }
        j = this.Zi.size();
        i = 0;
        if (i >= j) {
          break label153;
        }
        localObject = (j)this.Zi.get(i);
        if (!((j)localObject).n(paramMotionEvent)) {
          break label144;
        }
        this.Zj = ((j)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label159;
        }
        fy();
        return true;
        this.Zj.o(paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.Zj = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.Zf == null);
    boolean bool1 = this.Zf.eR();
    boolean bool2 = this.Zf.eS();
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = o.d(paramMotionEvent);
    int j = o.e(paramMotionEvent);
    if (k == 0)
    {
      int[] arrayOfInt = this.ZW;
      this.ZW[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.ZW[0], this.ZW[1]);
    int i = i2;
    switch (k)
    {
    default: 
      i = i2;
    case 4: 
      if (i == 0) {
        this.fk.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    case 0: 
      this.ZC = o.c(paramMotionEvent, 0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.ZF = i;
      this.ZD = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.ZG = i;
      this.ZE = i;
      if (!bool1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j);
      i = i2;
      break;
      this.ZC = o.c(paramMotionEvent, j);
      i = (int)(o.d(paramMotionEvent, j) + 0.5F);
      this.ZF = i;
      this.ZD = i;
      i = (int)(o.e(paramMotionEvent, j) + 0.5F);
      this.ZG = i;
      this.ZE = i;
      i = i2;
      break;
      i = o.b(paramMotionEvent, this.ZC);
      if (i < 0)
      {
        new StringBuilder("Error processing scroll; pointer index for id ").append(this.ZC).append(" not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(o.d(paramMotionEvent, i) + 0.5F);
      int i4 = (int)(o.e(paramMotionEvent, i) + 0.5F);
      int m = this.ZF - i3;
      k = this.ZG - i4;
      i = k;
      j = m;
      if (dispatchNestedPreScroll(m, k, this.De, this.Dd))
      {
        j = m - this.De[0];
        i = k - this.De[1];
        ((MotionEvent)localObject).offsetLocation(this.Dd[0], this.Dd[1]);
        paramMotionEvent = this.ZW;
        paramMotionEvent[0] += this.Dd[0];
        paramMotionEvent = this.ZW;
        paramMotionEvent[1] += this.Dd[1];
      }
      k = i;
      m = j;
      if (this.xV != 1)
      {
        if ((!bool1) || (Math.abs(j) <= this.iE)) {
          break label1295;
        }
        if (j <= 0) {
          break label889;
        }
        j -= this.iE;
      }
      label728:
      label778:
      label850:
      label889:
      label901:
      label919:
      label979:
      label997:
      label1129:
      label1264:
      label1275:
      label1292:
      label1295:
      for (k = 1;; k = 0)
      {
        int n = i;
        int i1 = k;
        if (bool2)
        {
          n = i;
          i1 = k;
          if (Math.abs(i) > this.iE)
          {
            if (i <= 0) {
              break label901;
            }
            n = i - this.iE;
            i1 = 1;
          }
        }
        k = n;
        m = j;
        if (i1 != 0)
        {
          X(1);
          m = j;
          k = n;
        }
        i = i2;
        if (this.xV != 1) {
          break;
        }
        this.ZF = (i3 - this.Dd[0]);
        this.ZG = (i4 - this.Dd[1]);
        if (bool1) {
          if (!bool2) {
            break label919;
          }
        }
        for (;;)
        {
          i = i2;
          if (!a(m, k, (MotionEvent)localObject)) {
            break;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          i = i2;
          break;
          j += this.iE;
          break label728;
          n = i + this.iE;
          break label778;
          m = 0;
          break label850;
          k = 0;
        }
        m(paramMotionEvent);
        i = i2;
        break;
        this.fk.addMovement((MotionEvent)localObject);
        this.fk.computeCurrentVelocity(1000, this.ZI);
        float f1;
        float f2;
        if (bool1)
        {
          f1 = -y.a(this.fk, this.ZC);
          if (!bool2) {
            break label1264;
          }
          f2 = -y.b(this.fk, this.ZC);
          if ((f1 != 0.0F) || (f2 != 0.0F))
          {
            k = (int)f1;
            j = (int)f2;
            if ((this.Zf == null) || (this.Zp)) {
              break label1275;
            }
            bool1 = this.Zf.eR();
            bool2 = this.Zf.eS();
            if (bool1)
            {
              i = k;
              if (Math.abs(k) >= this.ZH) {}
            }
            else
            {
              i = 0;
            }
            if ((bool2) && (Math.abs(j) >= this.ZH)) {
              break label1292;
            }
            j = 0;
          }
        }
        for (;;)
        {
          if (((i != 0) || (j != 0)) && (!dispatchNestedPreFling(i, j))) {
            if ((bool1) || (bool2))
            {
              bool1 = true;
              dispatchNestedFling(i, j, bool1);
              if (!bool1) {
                break label1275;
              }
              i = Math.max(-this.ZI, Math.min(i, this.ZI));
              j = Math.max(-this.ZI, Math.min(j, this.ZI));
              paramMotionEvent = this.ZK;
              c(paramMotionEvent.aaa, 2);
              paramMotionEvent.abc = 0;
              paramMotionEvent.abb = 0;
              paramMotionEvent.iB.a(0, i, j, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
              paramMotionEvent.ga();
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              X(0);
            }
            fx();
            i = 1;
            break;
            f1 = 0.0F;
            break label979;
            f2 = 0.0F;
            break label997;
            bool1 = false;
            break label1129;
          }
          fy();
          i = i2;
          break;
        }
      }
    }
  }
  
  final void q(String paramString)
  {
    if (fC())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    t localt = aZ(paramView);
    if (localt != null)
    {
      if (!localt.gn()) {
        break label32;
      }
      localt.gk();
    }
    label32:
    while (localt.gd())
    {
      bd(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localt);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    int i;
    Object localObject;
    if ((this.Zf.fU()) || (fC()))
    {
      i = 1;
      if ((i == 0) && (paramView2 != null))
      {
        this.eq.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
        localObject = paramView2.getLayoutParams();
        if ((localObject instanceof LayoutParams))
        {
          localObject = (LayoutParams)localObject;
          if (!((LayoutParams)localObject).aat)
          {
            localObject = ((LayoutParams)localObject).WM;
            Rect localRect = this.eq;
            localRect.left -= ((Rect)localObject).left;
            localRect = this.eq;
            localRect.right += ((Rect)localObject).right;
            localRect = this.eq;
            localRect.top -= ((Rect)localObject).top;
            localRect = this.eq;
            i = localRect.bottom;
            localRect.bottom = (((Rect)localObject).bottom + i);
          }
        }
        offsetDescendantRectToMyCoords(paramView2, this.eq);
        offsetRectIntoDescendantCoords(paramView1, this.eq);
        localObject = this.eq;
        if (this.Zm) {
          break label226;
        }
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      requestChildRectangleOnScreen(paramView1, (Rect)localObject, bool);
      super.requestChildFocus(paramView1, paramView2);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    h localh = this.Zf;
    int i2 = localh.getPaddingLeft();
    int m = localh.getPaddingTop();
    int i3 = localh.aar - localh.getPaddingRight();
    int i1 = localh.RQ;
    int i6 = localh.getPaddingBottom();
    int i4 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
    int n = paramView.getTop() + paramRect.top - paramView.getScrollY();
    int i5 = i4 + paramRect.width();
    int i7 = paramRect.height();
    int i = Math.min(0, i4 - i2);
    int j = Math.min(0, n - m);
    int k = Math.max(0, i5 - i3);
    i1 = Math.max(0, n + i7 - (i1 - i6));
    if (z.J(localh.aak) == 1) {
      if (k != 0)
      {
        i = k;
        if (j == 0) {
          break label232;
        }
        label170:
        if ((i == 0) && (j == 0)) {
          break label311;
        }
        if (!paramBoolean) {
          break label247;
        }
        scrollBy(i, j);
      }
    }
    for (;;)
    {
      return true;
      i = Math.max(i, i5 - i3);
      break;
      if (i != 0) {
        break;
      }
      i = Math.min(i4 - i2, k);
      break;
      label232:
      j = Math.min(n - m, i1);
      break label170;
      label247:
      if ((this.Zf != null) && (!this.Zp))
      {
        if (!this.Zf.eR()) {
          i = 0;
        }
        if (!this.Zf.eS()) {
          j = 0;
        }
        if ((i != 0) || (j != 0)) {
          this.ZK.smoothScrollBy(i, j);
        }
      }
    }
    label311:
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.Zi.size();
    int i = 0;
    while (i < j)
    {
      ((j)this.Zi.get(i)).T(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.Zn == 0) && (!this.Zp))
    {
      super.requestLayout();
      return;
    }
    this.Zo = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.Zf == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while (this.Zp);
      bool1 = this.Zf.eR();
      bool2 = this.Zf.eS();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label64;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label64:
      paramInt2 = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {}
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 0;
    int j = 0;
    if (fC()) {
      if (paramAccessibilityEvent == null) {
        break label52;
      }
    }
    label52:
    for (i = android.support.v4.view.a.a.b(paramAccessibilityEvent);; i = 0)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.Zr = (i | this.Zr);
        i = 1;
        if (i != 0) {
          return;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        return;
      }
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.Zc) {
      fw();
    }
    this.Zc = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.Zm) {
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    fN().setNestedScrollingEnabled(paramBoolean);
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    if (this.Zp) {}
    while (this.Zf == null) {
      return;
    }
    this.Zf.a(this, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return fN().startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    fN().stopNestedScroll();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect WM = new Rect();
    RecyclerView.t aas;
    boolean aat = true;
    boolean aau = false;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    Parcelable aaF;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.aaF = paramParcel.readParcelable(RecyclerView.h.class.getClassLoader());
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.aaF, 0);
    }
  }
  
  public static abstract class a<VH extends RecyclerView.t>
  {
    public final RecyclerView.b aab = new RecyclerView.b();
    public boolean aac = false;
    
    public final void P(int paramInt1, int paramInt2)
    {
      this.aab.P(paramInt1, paramInt2);
    }
    
    public final void Q(int paramInt1, int paramInt2)
    {
      this.aab.Q(paramInt1, paramInt2);
    }
    
    public final void R(int paramInt1, int paramInt2)
    {
      this.aab.R(paramInt1, paramInt2);
    }
    
    public final void S(int paramInt1, int paramInt2)
    {
      this.aab.S(paramInt1, paramInt2);
    }
    
    public abstract VH a(ViewGroup paramViewGroup, int paramInt);
    
    public final void a(RecyclerView.c paramc)
    {
      this.aab.registerObserver(paramc);
    }
    
    public void a(VH paramVH) {}
    
    public abstract void a(VH paramVH, int paramInt);
    
    public void a(VH paramVH, int paramInt, List<Object> paramList)
    {
      a(paramVH, paramInt);
    }
    
    public final void b(int paramInt1, int paramInt2, Object paramObject)
    {
      this.aab.b(paramInt1, paramInt2, paramObject);
    }
    
    public final void b(int paramInt, Object paramObject)
    {
      this.aab.b(paramInt, 1, paramObject);
    }
    
    public final void b(RecyclerView.c paramc)
    {
      this.aab.unregisterObserver(paramc);
    }
    
    public final void bc(int paramInt)
    {
      this.aab.P(paramInt, 1);
    }
    
    public final void bd(int paramInt)
    {
      this.aab.R(paramInt, 1);
    }
    
    public final void be(int paramInt)
    {
      this.aab.S(paramInt, 1);
    }
    
    public final void fQ()
    {
      if (this.aab.fR()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      this.aac = true;
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
  }
  
  public static final class b
    extends Observable<RecyclerView.c>
  {
    public final void P(int paramInt1, int paramInt2)
    {
      b(paramInt1, paramInt2, null);
    }
    
    public final void Q(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).W(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void R(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).U(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void S(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).V(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void b(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).c(paramInt1, paramInt2, paramObject);
        i -= 1;
      }
    }
    
    public final boolean fR()
    {
      return !this.mObservers.isEmpty();
    }
    
    public final void notifyChanged()
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.c)this.mObservers.get(i)).onChanged();
        i -= 1;
      }
    }
  }
  
  public static abstract class c
  {
    public void T(int paramInt1, int paramInt2) {}
    
    public void U(int paramInt1, int paramInt2) {}
    
    public void V(int paramInt1, int paramInt2) {}
    
    public void W(int paramInt1, int paramInt2) {}
    
    public void c(int paramInt1, int paramInt2, Object paramObject)
    {
      T(paramInt1, paramInt2);
    }
    
    public void onChanged() {}
  }
  
  public static abstract interface d
  {
    public abstract int X(int paramInt1, int paramInt2);
  }
  
  public static abstract class e
  {
    b aad = null;
    private ArrayList<a> aae = new ArrayList();
    public long aaf = 120L;
    public long aag = 120L;
    public long aah = 250L;
    public long aai = 250L;
    
    static int j(RecyclerView.t paramt)
    {
      int j = paramt.uf & 0xE;
      int i;
      if (paramt.gl()) {
        i = 4;
      }
      int k;
      int m;
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while ((j & 0x4) != 0);
            k = paramt.abg;
            m = paramt.gf();
            i = j;
          } while (k == -1);
          i = j;
        } while (m == -1);
        i = j;
      } while (k == m);
      return j | 0x800;
    }
    
    public c a(RecyclerView.q paramq, RecyclerView.t paramt, int paramInt, List<Object> paramList)
    {
      return new c().b(paramt, 0);
    }
    
    public final boolean a(a parama)
    {
      boolean bool = isRunning();
      if (parama != null)
      {
        if (!bool) {
          parama.fT();
        }
      }
      else {
        return bool;
      }
      this.aae.add(parama);
      return bool;
    }
    
    public abstract boolean a(RecyclerView.t paramt1, RecyclerView.t paramt2, c paramc1, c paramc2);
    
    public boolean a(RecyclerView.t paramt, List<Object> paramList)
    {
      return m(paramt);
    }
    
    public abstract void d(RecyclerView.t paramt);
    
    public abstract boolean d(RecyclerView.t paramt, c paramc1, c paramc2);
    
    public abstract boolean e(RecyclerView.t paramt, c paramc1, c paramc2);
    
    public abstract void eJ();
    
    public abstract void eL();
    
    public abstract boolean f(RecyclerView.t paramt, c paramc1, c paramc2);
    
    public final void fS()
    {
      int j = this.aae.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.aae.get(i)).fT();
        i += 1;
      }
      this.aae.clear();
    }
    
    public abstract boolean isRunning();
    
    public final void k(RecyclerView.t paramt)
    {
      l(paramt);
      if (this.aad != null) {
        this.aad.l(paramt);
      }
    }
    
    public void l(RecyclerView.t paramt) {}
    
    public boolean m(RecyclerView.t paramt)
    {
      return true;
    }
    
    public static abstract interface a
    {
      public abstract void fT();
    }
    
    static abstract interface b
    {
      public abstract void l(RecyclerView.t paramt);
    }
    
    public static class c
    {
      public int aaj;
      public int bottom;
      public int left;
      public int right;
      public int top;
      
      public c b(RecyclerView.t paramt, int paramInt)
      {
        paramt = paramt.abf;
        this.left = paramt.getLeft();
        this.top = paramt.getTop();
        this.right = paramt.getRight();
        this.bottom = paramt.getBottom();
        return this;
      }
    }
  }
  
  private final class f
    implements RecyclerView.e.b
  {
    public f() {}
    
    public final void l(RecyclerView.t paramt)
    {
      int i = 1;
      paramt.U(true);
      if ((paramt.abk != null) && (paramt.abl == null)) {
        paramt.abk = null;
      }
      paramt.abl = null;
      if ((paramt.uf & 0x10) != 0) {}
      for (;;)
      {
        if ((i == 0) && (!RecyclerView.c(RecyclerView.this, paramt.abf)) && (paramt.gn())) {
          RecyclerView.this.removeDetachedView(paramt.abf, false);
        }
        return;
        i = 0;
      }
    }
  }
  
  public static abstract class g
  {
    public void a(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView)
    {
      ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aas.ge();
      paramRect.set(0, 0, 0, 0);
    }
    
    public void b(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
  }
  
  public static abstract class h
  {
    int RQ;
    s Za;
    RecyclerView aak;
    RecyclerView.p aal;
    public boolean aam = false;
    public boolean aan = false;
    boolean aao = true;
    int aap;
    int aaq;
    int aar;
    boolean hi = false;
    
    public static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int i = 0;
      int j = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean) {
        if (paramInt4 >= 0)
        {
          paramInt3 = 1073741824;
          paramInt1 = paramInt4;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt3);
        if (paramInt4 == -1)
        {
          switch (paramInt2)
          {
          case 0: 
          default: 
            paramInt1 = 0;
            paramInt3 = i;
            break;
          case 1073741824: 
          case -2147483648: 
            paramInt1 = j;
            paramInt3 = paramInt2;
            break;
          }
        }
        else
        {
          if (paramInt4 == -2)
          {
            paramInt1 = 0;
            paramInt3 = i;
            continue;
            if (paramInt4 >= 0)
            {
              paramInt3 = 1073741824;
              paramInt1 = paramInt4;
              continue;
            }
            if (paramInt4 == -1)
            {
              paramInt1 = j;
              paramInt3 = paramInt2;
              continue;
            }
            if (paramInt4 == -2)
            {
              if (paramInt2 != Integer.MIN_VALUE)
              {
                paramInt1 = j;
                paramInt3 = i;
                if (paramInt2 != 1073741824) {
                  continue;
                }
              }
              paramInt3 = Integer.MIN_VALUE;
              paramInt1 = j;
              continue;
            }
          }
          paramInt1 = 0;
          paramInt3 = i;
        }
      }
    }
    
    public static int be(View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).aas.ge();
    }
    
    private void bf(int paramInt)
    {
      getChildAt(paramInt);
      this.Za.detachViewFromParent(paramInt);
    }
    
    public static int bg(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).WM;
      int i = paramView.getMeasuredWidth();
      int j = localRect.left;
      return localRect.right + (i + j);
    }
    
    public static int bh(View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).WM;
      int i = paramView.getMeasuredHeight();
      int j = localRect.top;
      return localRect.bottom + (i + j);
    }
    
    public static int bi(View paramView)
    {
      return paramView.getLeft() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).WM.left;
    }
    
    public static int bj(View paramView)
    {
      return paramView.getTop() - ((RecyclerView.LayoutParams)paramView.getLayoutParams()).WM.top;
    }
    
    public static int bk(View paramView)
    {
      int i = paramView.getRight();
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).WM.right + i;
    }
    
    public static int bl(View paramView)
    {
      int i = paramView.getBottom();
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).WM.bottom + i;
    }
    
    public static void g(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).WM;
      paramView.layout(localRect.left + paramInt1, localRect.top + paramInt2, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public static int j(int paramInt1, int paramInt2, int paramInt3)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      int i = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = i;
      switch (j)
      {
      default: 
        paramInt1 = Math.max(paramInt2, paramInt3);
      case 1073741824: 
        return paramInt1;
      }
      return Math.min(i, Math.max(paramInt2, paramInt3));
    }
    
    static boolean k(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {}
      do
      {
        do
        {
          return false;
          switch (i)
          {
          default: 
            return false;
          }
        } while (paramInt2 < paramInt1);
        return true;
        return true;
      } while (paramInt2 != paramInt1);
      return true;
    }
    
    private void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null)
      {
        s locals = this.Za;
        paramInt = locals.aM(paramInt);
        View localView = locals.VL.getChildAt(paramInt);
        if (localView != null)
        {
          if (locals.VM.aO(paramInt)) {
            locals.aO(localView);
          }
          locals.VL.removeViewAt(paramInt);
        }
      }
    }
    
    public void A(int paramInt1, int paramInt2) {}
    
    public void B(int paramInt1, int paramInt2) {}
    
    public void C(int paramInt1, int paramInt2) {}
    
    final void Y(int paramInt1, int paramInt2)
    {
      this.aar = View.MeasureSpec.getSize(paramInt1);
      this.aap = View.MeasureSpec.getMode(paramInt1);
      if ((this.aap == 0) && (!RecyclerView.YU)) {
        this.aar = 0;
      }
      this.RQ = View.MeasureSpec.getSize(paramInt2);
      this.aaq = View.MeasureSpec.getMode(paramInt2);
      if ((this.aaq == 0) && (!RecyclerView.YU)) {
        this.RQ = 0;
      }
    }
    
    final void Z(int paramInt1, int paramInt2)
    {
      int j = Integer.MAX_VALUE;
      int i = Integer.MIN_VALUE;
      int i5 = getChildCount();
      if (i5 == 0)
      {
        this.aak.N(paramInt1, paramInt2);
        return;
      }
      int n = 0;
      int k = Integer.MIN_VALUE;
      int m = Integer.MAX_VALUE;
      int i1;
      int i3;
      int i2;
      if (n < i5)
      {
        View localView = getChildAt(n);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        int i4 = bi(localView) - localLayoutParams.leftMargin;
        i1 = bk(localView);
        i3 = localLayoutParams.rightMargin + i1;
        i2 = bj(localView) - localLayoutParams.topMargin;
        i1 = bl(localView);
        i1 = localLayoutParams.bottomMargin + i1;
        if (i4 >= m) {
          break label215;
        }
        m = i4;
      }
      label215:
      for (;;)
      {
        if (i3 > k) {
          k = i3;
        }
        for (;;)
        {
          if (i2 < j) {
            j = i2;
          }
          for (;;)
          {
            if (i1 > i) {
              i = i1;
            }
            for (;;)
            {
              n += 1;
              break;
              RecyclerView.v(this.aak).set(m, j, k, i);
              a(RecyclerView.v(this.aak), paramInt1, paramInt2);
              return;
            }
          }
        }
      }
    }
    
    public int a(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
    {
      return 0;
    }
    
    public int a(RecyclerView.m paramm, RecyclerView.q paramq)
    {
      if ((this.aak == null) || (RecyclerView.h(this.aak) == null)) {}
      while (!eS()) {
        return 1;
      }
      return RecyclerView.h(this.aak).getItemCount();
    }
    
    public RecyclerView.LayoutParams a(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public View a(View paramView, int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
    {
      return null;
    }
    
    public final void a(int paramInt, RecyclerView.m paramm)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramm.bn(localView);
    }
    
    public void a(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = paramRect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(j(paramInt1, i + j + k, z.T(this.aak)), j(paramInt2, m + n + i1, z.U(this.aak)));
    }
    
    public void a(RecyclerView.m paramm, RecyclerView.q paramq, View paramView, b paramb)
    {
      int i;
      if (eS())
      {
        i = be(paramView);
        if (!eR()) {
          break label48;
        }
      }
      label48:
      for (int j = be(paramView);; j = 0)
      {
        paramb.k(b.l.a(i, 1, j, 1, false));
        return;
        i = 0;
        break;
      }
    }
    
    public final void a(RecyclerView.p paramp)
    {
      if ((this.aal != null) && (paramp != this.aal) && (this.aal.aaI)) {
        this.aal.stop();
      }
      this.aal = paramp;
      paramp = this.aal;
      paramp.aak = this.aak;
      paramp.YQ = this;
      if (paramp.aaG == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      paramp.aak.ZL.aaG = paramp.aaG;
      paramp.aaI = true;
      paramp.aaH = true;
      int i = paramp.aaG;
      paramp.aaJ = paramp.aak.Zf.aV(i);
      RecyclerView.x(paramp.aak).ga();
    }
    
    public void a(RecyclerView paramRecyclerView, int paramInt) {}
    
    public void a(RecyclerView paramRecyclerView, RecyclerView.m paramm) {}
    
    public final void a(View paramView, Rect paramRect)
    {
      if (this.aak == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.aak.bc(paramView));
    }
    
    public final void a(View paramView, RecyclerView.m paramm)
    {
      s locals = this.Za;
      int i = locals.VL.indexOfChild(paramView);
      if (i >= 0)
      {
        if (locals.VM.aO(i)) {
          locals.aO(paramView);
        }
        locals.VL.removeViewAt(i);
      }
      paramm.bn(paramView);
    }
    
    public boolean a(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    final boolean a(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.aao) || (!k(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!k(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public View aV(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.t localt = RecyclerView.aZ(localView);
        if ((localt != null) && (localt.ge() == paramInt) && (!localt.gd()) && ((this.aak.ZL.aaW) || (!localt.isRemoved()))) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public void aX(int paramInt) {}
    
    public final void aa(int paramInt1, int paramInt2)
    {
      this.aak.N(paramInt1, paramInt2);
    }
    
    public int b(int paramInt, RecyclerView.m paramm, RecyclerView.q paramq)
    {
      return 0;
    }
    
    public int b(RecyclerView.m paramm, RecyclerView.q paramq)
    {
      if ((this.aak == null) || (RecyclerView.h(this.aak) == null)) {}
      while (!eR()) {
        return 1;
      }
      return RecyclerView.h(this.aak).getItemCount();
    }
    
    public int b(RecyclerView.q paramq)
    {
      return 0;
    }
    
    public final void b(RecyclerView.m paramm)
    {
      int i = getChildCount() - 1;
      if (i >= 0)
      {
        View localView = getChildAt(i);
        RecyclerView.t localt = RecyclerView.aZ(localView);
        if (!localt.gd())
        {
          if ((!localt.gl()) || (localt.isRemoved()) || (RecyclerView.h(this.aak).aac)) {
            break label78;
          }
          removeViewAt(i);
          paramm.n(localt);
        }
        for (;;)
        {
          i -= 1;
          break;
          label78:
          bf(i);
          paramm.bp(localView);
          this.aak.Zb.w(localt);
        }
      }
    }
    
    final void b(RecyclerView paramRecyclerView, RecyclerView.m paramm)
    {
      this.hi = false;
      a(paramRecyclerView, paramm);
    }
    
    final void b(View paramView, b paramb)
    {
      RecyclerView.t localt = RecyclerView.aZ(paramView);
      if ((localt != null) && (!localt.isRemoved()) && (!this.Za.aP(localt.abf))) {
        a(this.aak.YX, this.aak.ZL, paramView, paramb);
      }
    }
    
    public final View bf(View paramView)
    {
      Object localObject;
      if (this.aak == null) {
        localObject = null;
      }
      do
      {
        return (View)localObject;
        RecyclerView localRecyclerView = this.aak;
        for (localObject = paramView.getParent(); (localObject != null) && (localObject != localRecyclerView) && ((localObject instanceof View)); localObject = paramView.getParent()) {
          paramView = (View)localObject;
        }
        if (localObject == localRecyclerView) {}
        while (paramView == null)
        {
          return null;
          paramView = null;
        }
        localObject = paramView;
      } while (!this.Za.aP(paramView));
      return null;
    }
    
    public void bg(int paramInt)
    {
      if (this.aak != null)
      {
        RecyclerView localRecyclerView = this.aak;
        int j = localRecyclerView.Za.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.Za.getChildAt(i).offsetLeftAndRight(paramInt);
          i += 1;
        }
      }
    }
    
    public void bh(int paramInt)
    {
      if (this.aak != null)
      {
        RecyclerView localRecyclerView = this.aak;
        int j = localRecyclerView.Za.getChildCount();
        int i = 0;
        while (i < j)
        {
          localRecyclerView.Za.getChildAt(i).offsetTopAndBottom(paramInt);
          i += 1;
        }
      }
    }
    
    public void bi(int paramInt) {}
    
    public int c(RecyclerView.q paramq)
    {
      return 0;
    }
    
    final void c(RecyclerView.m paramm)
    {
      int j = paramm.aay.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = ((RecyclerView.t)paramm.aay.get(i)).abf;
        RecyclerView.t localt = RecyclerView.aZ(localView);
        if (!localt.gd())
        {
          localt.U(false);
          if (localt.gn()) {
            this.aak.removeDetachedView(localView, false);
          }
          if (this.aak.ZB != null) {
            this.aak.ZB.d(localt);
          }
          localt.U(true);
          paramm.bo(localView);
        }
        i -= 1;
      }
      paramm.aay.clear();
      if (paramm.aaz != null) {
        paramm.aaz.clear();
      }
      if (j > 0) {
        this.aak.invalidate();
      }
    }
    
    public void c(RecyclerView.m paramm, RecyclerView.q paramq) {}
    
    void c(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.t localt1 = RecyclerView.aZ(paramView);
      RecyclerView.LayoutParams localLayoutParams1;
      if ((paramBoolean) || (localt1.isRemoved()))
      {
        this.aak.Zb.v(localt1);
        localLayoutParams1 = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localt1.gi()) && (!localt1.gg())) {
          break label128;
        }
        if (!localt1.gg()) {
          break label120;
        }
        localt1.gh();
        label68:
        this.Za.a(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (localLayoutParams1.aau)
        {
          localt1.abf.invalidate();
          localLayoutParams1.aau = false;
        }
        return;
        this.aak.Zb.w(localt1);
        break;
        label120:
        localt1.gj();
        break label68;
        label128:
        Object localObject;
        if (paramView.getParent() == this.aak)
        {
          int j = this.Za.indexOfChild(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.Za.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.aak.indexOfChild(paramView));
          }
          if (j != i)
          {
            paramView = this.aak.Zf;
            localObject = paramView.getChildAt(j);
            if (localObject == null) {
              throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j);
            }
            paramView.bf(j);
            RecyclerView.LayoutParams localLayoutParams2 = (RecyclerView.LayoutParams)((View)localObject).getLayoutParams();
            RecyclerView.t localt2 = RecyclerView.aZ((View)localObject);
            if (localt2.isRemoved()) {
              paramView.aak.Zb.v(localt2);
            }
            for (;;)
            {
              paramView.Za.a((View)localObject, i, localLayoutParams2, localt2.isRemoved());
              break;
              paramView.aak.Zb.w(localt2);
            }
          }
        }
        else
        {
          this.Za.a(paramView, paramInt, false);
          localLayoutParams1.aat = true;
          if ((this.aal != null) && (this.aal.aaI))
          {
            localObject = this.aal;
            if (RecyclerView.bb(paramView) == ((RecyclerView.p)localObject).aaG) {
              ((RecyclerView.p)localObject).aaJ = paramView;
            }
          }
        }
      }
    }
    
    public int d(RecyclerView.q paramq)
    {
      return 0;
    }
    
    public final void d(RecyclerView.m paramm)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        if (!RecyclerView.aZ(getChildAt(i)).gd()) {
          a(i, paramm);
        }
        i -= 1;
      }
    }
    
    public int e(RecyclerView.q paramq)
    {
      return 0;
    }
    
    public RecyclerView.LayoutParams e(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public void eM() {}
    
    public abstract RecyclerView.LayoutParams eN();
    
    public boolean eQ()
    {
      return false;
    }
    
    public boolean eR()
    {
      return false;
    }
    
    public boolean eS()
    {
      return false;
    }
    
    boolean eX()
    {
      return false;
    }
    
    public int f(RecyclerView.q paramq)
    {
      return 0;
    }
    
    public final boolean fU()
    {
      return (this.aal != null) && (this.aal.aaI);
    }
    
    final void fV()
    {
      if (this.aal != null) {
        this.aal.stop();
      }
    }
    
    public int g(RecyclerView.q paramq)
    {
      return 0;
    }
    
    public final View getChildAt(int paramInt)
    {
      if (this.Za != null) {
        return this.Za.getChildAt(paramInt);
      }
      return null;
    }
    
    public final int getChildCount()
    {
      if (this.Za != null) {
        return this.Za.getChildCount();
      }
      return 0;
    }
    
    public final int getPaddingBottom()
    {
      if (this.aak != null) {
        return this.aak.getPaddingBottom();
      }
      return 0;
    }
    
    public final int getPaddingLeft()
    {
      if (this.aak != null) {
        return this.aak.getPaddingLeft();
      }
      return 0;
    }
    
    public final int getPaddingRight()
    {
      if (this.aak != null) {
        return this.aak.getPaddingRight();
      }
      return 0;
    }
    
    public final int getPaddingTop()
    {
      if (this.aak != null) {
        return this.aak.getPaddingTop();
      }
      return 0;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      Object localObject = this.aak.YX;
      localObject = this.aak.ZL;
      paramAccessibilityEvent = android.support.v4.view.a.a.a(paramAccessibilityEvent);
      if (this.aak == null) {
        return;
      }
      boolean bool1 = bool2;
      if (!z.h(this.aak, 1))
      {
        bool1 = bool2;
        if (!z.h(this.aak, -1))
        {
          bool1 = bool2;
          if (!z.g(this.aak, -1)) {
            if (!z.g(this.aak, 1)) {
              break label115;
            }
          }
        }
      }
      label115:
      for (bool1 = bool2;; bool1 = false)
      {
        paramAccessibilityEvent.setScrollable(bool1);
        if (RecyclerView.h(this.aak) == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(RecyclerView.h(this.aak).getItemCount());
        return;
      }
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void q(String paramString)
    {
      if (this.aak != null) {
        this.aak.q(paramString);
      }
    }
    
    public final boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.aak != null) {
        return this.aak.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public final void requestLayout()
    {
      if (this.aak != null) {
        this.aak.requestLayout();
      }
    }
    
    public final void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      RecyclerView.b(this.aak, paramInt1, paramInt2);
    }
    
    final void y(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.aak = null;
        this.Za = null;
        this.aar = 0;
      }
      for (this.RQ = 0;; this.RQ = paramRecyclerView.getHeight())
      {
        this.aap = 1073741824;
        this.aaq = 1073741824;
        return;
        this.aak = paramRecyclerView;
        this.Za = paramRecyclerView.Za;
        this.aar = paramRecyclerView.getWidth();
      }
    }
    
    public void z(int paramInt1, int paramInt2) {}
    
    final void z(RecyclerView paramRecyclerView)
    {
      Y(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
  }
  
  public static abstract interface i
  {
    public abstract void bm(View paramView);
  }
  
  public static abstract interface j
  {
    public abstract void T(boolean paramBoolean);
    
    public abstract boolean n(MotionEvent paramMotionEvent);
    
    public abstract void o(MotionEvent paramMotionEvent);
  }
  
  public static abstract class k
  {
    public void c(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void e(RecyclerView paramRecyclerView, int paramInt) {}
  }
  
  public static final class l
  {
    SparseArray<ArrayList<RecyclerView.t>> aav = new SparseArray();
    SparseIntArray aaw = new SparseIntArray();
    int aax = 0;
  }
  
  public final class m
  {
    final ArrayList<RecyclerView.t> aaA = new ArrayList();
    final List<RecyclerView.t> aaB = Collections.unmodifiableList(this.aay);
    private int aaC = 2;
    private RecyclerView.l aaD;
    private RecyclerView.r aaE;
    final ArrayList<RecyclerView.t> aay = new ArrayList();
    public ArrayList<RecyclerView.t> aaz = null;
    
    public m() {}
    
    private RecyclerView.t b(long paramLong, int paramInt, boolean paramBoolean)
    {
      int i = this.aay.size() - 1;
      RecyclerView.t localt;
      while (i >= 0)
      {
        localt = (RecyclerView.t)this.aay.get(i);
        if ((localt.abh == paramLong) && (!localt.gi()))
        {
          if (paramInt == localt.abi)
          {
            localt.addFlags(32);
            if ((localt.isRemoved()) && (!RecyclerView.this.ZL.aaW)) {
              localt.setFlags(2, 14);
            }
            return localt;
          }
          this.aay.remove(i);
          RecyclerView.this.removeDetachedView(localt.abf, false);
          bo(localt.abf);
        }
        i -= 1;
      }
      i = this.aaA.size() - 1;
      while (i >= 0)
      {
        localt = (RecyclerView.t)this.aaA.get(i);
        if (localt.abh == paramLong)
        {
          if (paramInt == localt.abi)
          {
            this.aaA.remove(i);
            return localt;
          }
          bl(i);
        }
        i -= 1;
      }
      return null;
    }
    
    private RecyclerView.t bm(int paramInt)
    {
      int j = 0;
      int k;
      if (this.aaz != null)
      {
        k = this.aaz.size();
        if (k != 0) {}
      }
      else
      {
        return null;
      }
      int i = 0;
      RecyclerView.t localt;
      while (i < k)
      {
        localt = (RecyclerView.t)this.aaz.get(i);
        if ((!localt.gi()) && (localt.ge() == paramInt))
        {
          localt.addFlags(32);
          return localt;
        }
        i += 1;
      }
      if (RecyclerView.h(RecyclerView.this).aac)
      {
        paramInt = RecyclerView.this.YZ.t(paramInt, 0);
        if ((paramInt > 0) && (paramInt < RecyclerView.h(RecyclerView.this).getItemCount()))
        {
          long l = RecyclerView.h(RecyclerView.this).getItemId(paramInt);
          paramInt = j;
          while (paramInt < k)
          {
            localt = (RecyclerView.t)this.aaz.get(paramInt);
            if ((!localt.gi()) && (localt.abh == l))
            {
              localt.addFlags(32);
              return localt;
            }
            paramInt += 1;
          }
        }
      }
      return null;
    }
    
    private void c(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          c((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
    }
    
    private RecyclerView.t o(int paramInt, boolean paramBoolean)
    {
      int j = 0;
      int k = this.aay.size();
      int i = 0;
      Object localObject1;
      while (i < k)
      {
        localObject1 = (RecyclerView.t)this.aay.get(i);
        if ((!((RecyclerView.t)localObject1).gi()) && (((RecyclerView.t)localObject1).ge() == paramInt) && (!((RecyclerView.t)localObject1).gl()) && ((RecyclerView.this.ZL.aaW) || (!((RecyclerView.t)localObject1).isRemoved())))
        {
          ((RecyclerView.t)localObject1).addFlags(32);
          return (RecyclerView.t)localObject1;
        }
        i += 1;
      }
      Object localObject2 = RecyclerView.this.Za;
      k = ((s)localObject2).VN.size();
      i = 0;
      Object localObject3;
      if (i < k)
      {
        localObject1 = (View)((s)localObject2).VN.get(i);
        localObject3 = ((s)localObject2).VL.aQ((View)localObject1);
        if ((((RecyclerView.t)localObject3).ge() != paramInt) || (((RecyclerView.t)localObject3).gl()) || (((RecyclerView.t)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.aZ((View)localObject1);
          localObject3 = RecyclerView.this.Za;
          paramInt = ((s)localObject3).VL.indexOfChild((View)localObject1);
          if (paramInt < 0)
          {
            throw new IllegalArgumentException("view is not a child, cannot hide " + localObject1);
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!((s)localObject3).VM.get(paramInt)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + localObject1);
          }
          ((s)localObject3).VM.clear(paramInt);
          ((s)localObject3).aO((View)localObject1);
          paramInt = RecyclerView.this.Za.indexOfChild((View)localObject1);
          if (paramInt == -1) {
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2);
          }
          RecyclerView.this.Za.detachViewFromParent(paramInt);
          bp((View)localObject1);
          ((RecyclerView.t)localObject2).addFlags(8224);
          return (RecyclerView.t)localObject2;
        }
      }
      k = this.aaA.size();
      i = j;
      while (i < k)
      {
        localObject1 = (RecyclerView.t)this.aaA.get(i);
        if ((!((RecyclerView.t)localObject1).gl()) && (((RecyclerView.t)localObject1).ge() == paramInt))
        {
          this.aaA.remove(i);
          return (RecyclerView.t)localObject1;
        }
        i += 1;
      }
      return null;
    }
    
    private void o(RecyclerView.t paramt)
    {
      z.a(paramt.abf, null);
      if (RecyclerView.u(RecyclerView.this) != null) {
        RecyclerView.u(RecyclerView.this);
      }
      if (RecyclerView.h(RecyclerView.this) != null) {
        RecyclerView.h(RecyclerView.this).a(paramt);
      }
      if (RecyclerView.this.ZL != null) {
        RecyclerView.this.Zb.x(paramt);
      }
      paramt.abt = null;
      RecyclerView.l locall = fX();
      int i = paramt.abi;
      ArrayList localArrayList2 = (ArrayList)locall.aav.get(i);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList2 = new ArrayList();
        locall.aav.put(i, localArrayList2);
        localArrayList1 = localArrayList2;
        if (locall.aaw.indexOfKey(i) < 0)
        {
          locall.aaw.put(i, 5);
          localArrayList1 = localArrayList2;
        }
      }
      if (locall.aaw.get(i) > localArrayList1.size())
      {
        paramt.gq();
        localArrayList1.add(paramt);
      }
    }
    
    public final int bj(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.ZL.getItemCount())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + RecyclerView.this.ZL.getItemCount());
      }
      if (!RecyclerView.this.ZL.aaW) {
        return paramInt;
      }
      return RecyclerView.this.YZ.aI(paramInt);
    }
    
    public final View bk(int paramInt)
    {
      boolean bool2 = true;
      if ((paramInt < 0) || (paramInt >= RecyclerView.this.ZL.getItemCount())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + RecyclerView.this.ZL.getItemCount());
      }
      Object localObject2;
      int i;
      if (RecyclerView.this.ZL.aaW)
      {
        localObject2 = bm(paramInt);
        if (localObject2 != null) {
          i = 1;
        }
      }
      for (int j = i;; j = 0)
      {
        Object localObject1 = localObject2;
        i = j;
        boolean bool1;
        if (localObject2 == null)
        {
          localObject2 = o(paramInt, false);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null)
          {
            if (!((RecyclerView.t)localObject2).isRemoved()) {
              break label300;
            }
            bool1 = RecyclerView.this.ZL.aaW;
            label154:
            if (bool1) {
              break label459;
            }
            ((RecyclerView.t)localObject2).addFlags(4);
            if (!((RecyclerView.t)localObject2).gg()) {
              break label443;
            }
            RecyclerView.this.removeDetachedView(((RecyclerView.t)localObject2).abf, false);
            ((RecyclerView.t)localObject2).gh();
            label191:
            n((RecyclerView.t)localObject2);
            localObject1 = null;
            i = j;
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            int k = RecyclerView.this.YZ.aI(paramInt);
            if ((k < 0) || (k >= RecyclerView.h(RecyclerView.this).getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + RecyclerView.this.ZL.getItemCount());
              i = 0;
              break;
              label300:
              if ((((RecyclerView.t)localObject2).kC < 0) || (((RecyclerView.t)localObject2).kC >= RecyclerView.h(RecyclerView.this).getItemCount())) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + localObject2);
              }
              if ((!RecyclerView.this.ZL.aaW) && (RecyclerView.h(RecyclerView.this).getItemViewType(((RecyclerView.t)localObject2).kC) != ((RecyclerView.t)localObject2).abi))
              {
                bool1 = false;
                break label154;
              }
              if ((RecyclerView.h(RecyclerView.this).aac) && (((RecyclerView.t)localObject2).abh != RecyclerView.h(RecyclerView.this).getItemId(((RecyclerView.t)localObject2).kC)))
              {
                bool1 = false;
                break label154;
              }
              bool1 = true;
              break label154;
              label443:
              if (!((RecyclerView.t)localObject2).gi()) {
                break label191;
              }
              ((RecyclerView.t)localObject2).gj();
              break label191;
              label459:
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            j = RecyclerView.h(RecyclerView.this).getItemViewType(k);
            if (RecyclerView.h(RecyclerView.this).aac)
            {
              localObject2 = b(RecyclerView.h(RecyclerView.this).getItemId(k), j, false);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.t)localObject2).kC = k;
                i = 1;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = localObject2;
                  if (this.aaE != null)
                  {
                    View localView = this.aaE.fZ();
                    localObject1 = localObject2;
                    if (localView != null)
                    {
                      localObject2 = RecyclerView.this.aQ(localView);
                      if (localObject2 == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                      }
                      localObject1 = localObject2;
                      if (((RecyclerView.t)localObject2).gd()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                      }
                    }
                  }
                }
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  localObject2 = (ArrayList)fX().aav.get(j);
                  if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
                  {
                    k = ((ArrayList)localObject2).size() - 1;
                    localObject1 = (RecyclerView.t)((ArrayList)localObject2).get(k);
                    ((ArrayList)localObject2).remove(k);
                    if (localObject1 != null)
                    {
                      ((RecyclerView.t)localObject1).gq();
                      if ((RecyclerView.fP()) && ((((RecyclerView.t)localObject1).abf instanceof ViewGroup))) {
                        c((ViewGroup)((RecyclerView.t)localObject1).abf, false);
                      }
                    }
                    localObject2 = localObject1;
                  }
                }
                else
                {
                  if (localObject2 != null) {
                    break label1231;
                  }
                  localObject1 = RecyclerView.h(RecyclerView.this);
                  localObject2 = RecyclerView.this;
                  android.support.v4.os.e.beginSection("RV CreateView");
                  localObject1 = ((RecyclerView.a)localObject1).a((ViewGroup)localObject2, j);
                  ((RecyclerView.t)localObject1).abi = j;
                  android.support.v4.os.e.endSection();
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((i != 0) && (!RecyclerView.this.ZL.aaW) && (((RecyclerView.t)localObject1).bo(8192)))
          {
            ((RecyclerView.t)localObject1).setFlags(0, 8192);
            if (RecyclerView.this.ZL.aaX)
            {
              j = RecyclerView.e.j((RecyclerView.t)localObject1);
              localObject2 = RecyclerView.this.ZB.a(RecyclerView.this.ZL, (RecyclerView.t)localObject1, j | 0x1000, ((RecyclerView.t)localObject1).gp());
              RecyclerView.a(RecyclerView.this, (RecyclerView.t)localObject1, (RecyclerView.e.c)localObject2);
            }
          }
          if ((RecyclerView.this.ZL.aaW) && (((RecyclerView.t)localObject1).isBound()))
          {
            ((RecyclerView.t)localObject1).abj = paramInt;
            paramInt = 0;
          }
          for (;;)
          {
            label903:
            localObject2 = ((RecyclerView.t)localObject1).abf.getLayoutParams();
            if (localObject2 == null)
            {
              localObject2 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
              ((RecyclerView.t)localObject1).abf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              label940:
              ((RecyclerView.LayoutParams)localObject2).aas = ((RecyclerView.t)localObject1);
              if ((i == 0) || (paramInt == 0)) {
                break label1220;
              }
            }
            label1220:
            for (bool1 = bool2;; bool1 = false)
            {
              ((RecyclerView.LayoutParams)localObject2).aau = bool1;
              return ((RecyclerView.t)localObject1).abf;
              localObject1 = null;
              break;
              if ((((RecyclerView.t)localObject1).isBound()) && (!((RecyclerView.t)localObject1).gm()) && (!((RecyclerView.t)localObject1).gl())) {
                break label1226;
              }
              j = RecyclerView.this.YZ.aI(paramInt);
              ((RecyclerView.t)localObject1).abt = RecyclerView.this;
              localObject2 = RecyclerView.h(RecyclerView.this);
              ((RecyclerView.t)localObject1).kC = j;
              if (((RecyclerView.a)localObject2).aac) {
                ((RecyclerView.t)localObject1).abh = ((RecyclerView.a)localObject2).getItemId(j);
              }
              ((RecyclerView.t)localObject1).setFlags(1, 519);
              android.support.v4.os.e.beginSection("RV OnBindView");
              ((RecyclerView.a)localObject2).a((RecyclerView.t)localObject1, j, ((RecyclerView.t)localObject1).gp());
              ((RecyclerView.t)localObject1).go();
              android.support.v4.os.e.endSection();
              localObject2 = ((RecyclerView.t)localObject1).abf;
              if (RecyclerView.this.fB())
              {
                if (z.G((View)localObject2) == 0) {
                  z.i((View)localObject2, 1);
                }
                if (!z.D((View)localObject2)) {
                  z.a((View)localObject2, RecyclerView.t(RecyclerView.this).abu);
                }
              }
              if (RecyclerView.this.ZL.aaW) {
                ((RecyclerView.t)localObject1).abj = paramInt;
              }
              paramInt = 1;
              break label903;
              if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject2))
              {
                localObject2 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((RecyclerView.t)localObject1).abf.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                break label940;
              }
              localObject2 = (RecyclerView.LayoutParams)localObject2;
              break label940;
            }
            label1226:
            paramInt = 0;
          }
          label1231:
          localObject1 = localObject2;
          continue;
          localObject2 = localObject1;
          break;
        }
        localObject2 = null;
      }
    }
    
    final void bl(int paramInt)
    {
      o((RecyclerView.t)this.aaA.get(paramInt));
      this.aaA.remove(paramInt);
    }
    
    public final void bn(View paramView)
    {
      RecyclerView.t localt = RecyclerView.aZ(paramView);
      if (localt.gn()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localt.gg()) {
        localt.gh();
      }
      for (;;)
      {
        n(localt);
        return;
        if (localt.gi()) {
          localt.gj();
        }
      }
    }
    
    final void bo(View paramView)
    {
      paramView = RecyclerView.aZ(paramView);
      paramView.abq = null;
      paramView.abr = false;
      paramView.gj();
      n(paramView);
    }
    
    final void bp(View paramView)
    {
      paramView = RecyclerView.aZ(paramView);
      if ((paramView.bo(12)) || (!paramView.gs()) || (RecyclerView.a(RecyclerView.this, paramView)))
      {
        if ((paramView.gl()) && (!paramView.isRemoved()) && (!RecyclerView.h(RecyclerView.this).aac)) {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
        paramView.a(this, false);
        this.aay.add(paramView);
        return;
      }
      if (this.aaz == null) {
        this.aaz = new ArrayList();
      }
      paramView.a(this, true);
      this.aaz.add(paramView);
    }
    
    public final void clear()
    {
      this.aay.clear();
      fW();
    }
    
    final void fW()
    {
      int i = this.aaA.size() - 1;
      while (i >= 0)
      {
        bl(i);
        i -= 1;
      }
      this.aaA.clear();
    }
    
    final RecyclerView.l fX()
    {
      if (this.aaD == null) {
        this.aaD = new RecyclerView.l();
      }
      return this.aaD;
    }
    
    final void n(RecyclerView.t paramt)
    {
      boolean bool = true;
      int k = 0;
      if ((paramt.gg()) || (paramt.abf.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramt.gg()).append(" isAttached:");
        if (paramt.abf.getParent() != null) {}
        for (;;)
        {
          throw new IllegalArgumentException(bool);
          bool = false;
        }
      }
      if (paramt.gn()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramt);
      }
      if (paramt.gd()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
      }
      int j;
      int i;
      if (((paramt.uf & 0x10) == 0) && (z.E(paramt.abf)))
      {
        j = 1;
        if ((RecyclerView.h(RecyclerView.this) != null) && (j != 0)) {
          RecyclerView.h(RecyclerView.this);
        }
        if (!paramt.gr()) {
          break label291;
        }
        if (paramt.bo(14)) {
          break label286;
        }
        i = this.aaA.size();
        if ((i == this.aaC) && (i > 0)) {
          bl(0);
        }
        if (i >= this.aaC) {
          break label286;
        }
        this.aaA.add(paramt);
        i = 1;
        label236:
        if (i != 0) {
          break label283;
        }
        o(paramt);
        k = 1;
      }
      for (;;)
      {
        RecyclerView.this.Zb.x(paramt);
        if ((i == 0) && (k == 0) && (j != 0)) {
          paramt.abt = null;
        }
        return;
        j = 0;
        break;
        label283:
        continue;
        label286:
        i = 0;
        break label236;
        label291:
        i = 0;
      }
    }
    
    final void p(RecyclerView.t paramt)
    {
      if (paramt.abr) {
        this.aaz.remove(paramt);
      }
      for (;;)
      {
        paramt.abq = null;
        paramt.abr = false;
        paramt.gj();
        return;
        this.aay.remove(paramt);
      }
    }
  }
  
  public static abstract interface n {}
  
  private final class o
    extends RecyclerView.c
  {
    public o() {}
    
    private void fY()
    {
      if ((RecyclerView.o(RecyclerView.this)) && (RecyclerView.p(RecyclerView.this)) && (RecyclerView.q(RecyclerView.this)))
      {
        z.a(RecyclerView.this, RecyclerView.r(RecyclerView.this));
        return;
      }
      RecyclerView.s(RecyclerView.this);
      RecyclerView.this.requestLayout();
    }
    
    public final void U(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.q(null);
      e locale = RecyclerView.this.YZ;
      locale.Uc.add(locale.a(1, paramInt1, paramInt2, null));
      locale.Ui |= 0x1;
      if (locale.Uc.size() == 1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          fY();
        }
        return;
      }
    }
    
    public final void V(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.q(null);
      e locale = RecyclerView.this.YZ;
      locale.Uc.add(locale.a(2, paramInt1, paramInt2, null));
      locale.Ui |= 0x2;
      if (locale.Uc.size() == 1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          fY();
        }
        return;
      }
    }
    
    public final void W(int paramInt1, int paramInt2)
    {
      int i = 1;
      RecyclerView.this.q(null);
      e locale = RecyclerView.this.YZ;
      if (paramInt1 != paramInt2)
      {
        locale.Uc.add(locale.a(8, paramInt1, paramInt2, null));
        locale.Ui |= 0x8;
        if (locale.Uc.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          fY();
        }
        return;
      }
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      RecyclerView.this.q(null);
      e locale = RecyclerView.this.YZ;
      locale.Uc.add(locale.a(4, paramInt1, paramInt2, paramObject));
      locale.Ui |= 0x4;
      if (locale.Uc.size() == 1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          fY();
        }
        return;
      }
    }
    
    public final void onChanged()
    {
      RecyclerView.this.q(null);
      boolean bool = RecyclerView.h(RecyclerView.this).aac;
      RecyclerView.this.ZL.aaV = true;
      RecyclerView.n(RecyclerView.this);
      if (!RecyclerView.this.YZ.et()) {
        RecyclerView.this.requestLayout();
      }
    }
  }
  
  public static abstract class p
  {
    RecyclerView.h YQ;
    public int aaG = -1;
    boolean aaH;
    boolean aaI;
    View aaJ;
    private final a aaK = new a();
    RecyclerView aak;
    
    protected abstract void a(int paramInt1, int paramInt2, a parama);
    
    protected abstract void a(View paramView, a parama);
    
    public final void ab(int paramInt1, int paramInt2)
    {
      int i = 0;
      RecyclerView localRecyclerView = this.aak;
      if ((!this.aaI) || (this.aaG == -1) || (localRecyclerView == null)) {
        stop();
      }
      this.aaH = false;
      Object localObject;
      if (this.aaJ != null)
      {
        if (RecyclerView.bb(this.aaJ) != this.aaG) {
          break label166;
        }
        localObject = this.aaJ;
        RecyclerView.q localq = localRecyclerView.ZL;
        a((View)localObject, this.aaK);
        this.aaK.A(localRecyclerView);
        stop();
      }
      for (;;)
      {
        if (this.aaI)
        {
          localObject = localRecyclerView.ZL;
          a(paramInt1, paramInt2, this.aaK);
          paramInt1 = i;
          if (this.aaK.aaN >= 0) {
            paramInt1 = 1;
          }
          this.aaK.A(localRecyclerView);
          if (paramInt1 != 0)
          {
            if (!this.aaI) {
              break;
            }
            this.aaH = true;
            RecyclerView.x(localRecyclerView).ga();
          }
        }
        return;
        label166:
        this.aaJ = null;
      }
      stop();
    }
    
    protected abstract void onStop();
    
    protected final void stop()
    {
      if (!this.aaI) {
        return;
      }
      onStop();
      this.aak.ZL.aaG = -1;
      this.aaJ = null;
      this.aaG = -1;
      this.aaH = false;
      this.aaI = false;
      RecyclerView.h localh = this.YQ;
      if (localh.aal == this) {
        localh.aal = null;
      }
      this.YQ = null;
      this.aak = null;
    }
    
    public static final class a
    {
      private int aaL = 0;
      private int aaM = 0;
      int aaN = -1;
      private boolean aaO = false;
      private int aaP = 0;
      private int ls = Integer.MIN_VALUE;
      private Interpolator mInterpolator = null;
      
      public a()
      {
        this(0, 0);
      }
      
      private a(int paramInt1, int paramInt2) {}
      
      public final void A(RecyclerView paramRecyclerView)
      {
        if (this.aaN >= 0)
        {
          int i = this.aaN;
          this.aaN = -1;
          RecyclerView.d(paramRecyclerView, i);
          this.aaO = false;
          return;
        }
        if (this.aaO)
        {
          if ((this.mInterpolator != null) && (this.ls <= 0)) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
          }
          if (this.ls <= 0) {
            throw new IllegalStateException("Scroll duration must be a positive number");
          }
          if (this.mInterpolator == null) {
            if (this.ls == Integer.MIN_VALUE) {
              RecyclerView.x(paramRecyclerView).smoothScrollBy(this.aaL, this.aaM);
            }
          }
          for (;;)
          {
            this.aaP += 1;
            this.aaO = false;
            return;
            RecyclerView.x(paramRecyclerView).l(this.aaL, this.aaM, this.ls);
            continue;
            RecyclerView.x(paramRecyclerView).b(this.aaL, this.aaM, this.ls, this.mInterpolator);
          }
        }
        this.aaP = 0;
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        this.aaL = paramInt1;
        this.aaM = paramInt2;
        this.ls = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.aaO = true;
      }
    }
  }
  
  public static final class q
  {
    public int aaG = -1;
    public int aaQ = 1;
    private SparseArray<Object> aaR;
    int aaS = 0;
    public int aaT = 0;
    public int aaU = 0;
    public boolean aaV = false;
    public boolean aaW = false;
    public boolean aaX = false;
    public boolean aaY = false;
    public boolean aaZ = false;
    public boolean aba = false;
    
    final void bn(int paramInt)
    {
      if ((this.aaQ & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(this.aaQ));
      }
    }
    
    public final int getItemCount()
    {
      if (this.aaW) {
        return this.aaT - this.aaU;
      }
      return this.aaS;
    }
    
    public final String toString()
    {
      return "State{mTargetPosition=" + this.aaG + ", mData=" + this.aaR + ", mItemCount=" + this.aaS + ", mPreviousLayoutItemCount=" + this.aaT + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.aaU + ", mStructureChanged=" + this.aaV + ", mInPreLayout=" + this.aaW + ", mRunSimpleAnimations=" + this.aaX + ", mRunPredictiveAnimations=" + this.aaY + '}';
    }
  }
  
  public static abstract class r
  {
    public abstract View fZ();
  }
  
  private final class s
    implements Runnable
  {
    int abb;
    int abc;
    private boolean abd = false;
    private boolean abe = false;
    android.support.v4.widget.q iB = android.support.v4.widget.q.a(RecyclerView.this.getContext(), RecyclerView.fO());
    private Interpolator mInterpolator = RecyclerView.fO();
    
    public s() {}
    
    public final void b(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      if (this.mInterpolator != paramInterpolator)
      {
        this.mInterpolator = paramInterpolator;
        this.iB = android.support.v4.widget.q.a(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.c(RecyclerView.this, 2);
      this.abc = 0;
      this.abb = 0;
      this.iB.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      ga();
    }
    
    final void ga()
    {
      if (this.abd)
      {
        this.abe = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      z.a(RecyclerView.this, this);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      b(paramInt1, paramInt2, paramInt3, RecyclerView.fO());
    }
    
    public final void run()
    {
      if (RecyclerView.this.Zf == null)
      {
        stop();
        return;
      }
      this.abe = false;
      this.abd = true;
      RecyclerView.d(RecyclerView.this);
      android.support.v4.widget.q localq = this.iB;
      RecyclerView.p localp = RecyclerView.this.Zf.aal;
      int i6;
      int i7;
      int i4;
      int i5;
      int i1;
      int i;
      int m;
      int i3;
      int j;
      int n;
      int k;
      if (localq.computeScrollOffset())
      {
        i6 = localq.getCurrX();
        i7 = localq.getCurrY();
        i4 = i6 - this.abb;
        i5 = i7 - this.abc;
        i1 = 0;
        i = 0;
        i2 = 0;
        m = 0;
        this.abb = i6;
        this.abc = i7;
        i3 = 0;
        j = 0;
        n = 0;
        k = 0;
        if (RecyclerView.h(RecyclerView.this) == null) {
          break label768;
        }
        RecyclerView.this.fp();
        RecyclerView.i(RecyclerView.this);
        android.support.v4.os.e.beginSection("RV Scroll");
        if (i4 != 0)
        {
          i = RecyclerView.this.Zf.a(i4, RecyclerView.this.YX, RecyclerView.this.ZL);
          j = i4 - i;
        }
        if (i5 != 0)
        {
          m = RecyclerView.this.Zf.b(i5, RecyclerView.this.YX, RecyclerView.this.ZL);
          k = i5 - m;
        }
        android.support.v4.os.e.endSection();
        RecyclerView.j(RecyclerView.this);
        RecyclerView.k(RecyclerView.this);
        RecyclerView.this.R(false);
        n = k;
        i2 = m;
        i3 = j;
        i1 = i;
        if (localp == null) {
          break label768;
        }
        n = k;
        i2 = m;
        i3 = j;
        i1 = i;
        if (localp.aaH) {
          break label768;
        }
        n = k;
        i2 = m;
        i3 = j;
        i1 = i;
        if (!localp.aaI) {
          break label768;
        }
        n = RecyclerView.this.ZL.getItemCount();
        if (n != 0) {
          break label723;
        }
        localp.stop();
        i1 = i;
        label338:
        if (!RecyclerView.l(RecyclerView.this).isEmpty()) {
          RecyclerView.this.invalidate();
        }
        if (z.C(RecyclerView.this) != 2) {
          RecyclerView.a(RecyclerView.this, i4, i5);
        }
        if ((j != 0) || (k != 0))
        {
          n = (int)localq.getCurrVelocity();
          if (j == i6) {
            break label881;
          }
          if (j >= 0) {
            break label781;
          }
          i = -n;
        }
      }
      label410:
      label427:
      label466:
      label486:
      label607:
      label634:
      label654:
      label723:
      label768:
      label781:
      label808:
      label832:
      label859:
      label864:
      label869:
      label881:
      for (int i2 = i;; i2 = 0)
      {
        if (k != i7) {
          if (k < 0) {
            i = -n;
          }
        }
        for (;;)
        {
          RecyclerView localRecyclerView;
          if (z.C(RecyclerView.this) != 2)
          {
            localRecyclerView = RecyclerView.this;
            if (i2 >= 0) {
              break label808;
            }
            localRecyclerView.fs();
            localRecyclerView.Zx.ag(-i2);
            if (i >= 0) {
              break label832;
            }
            localRecyclerView.fu();
            localRecyclerView.Zy.ag(-i);
            if ((i2 != 0) || (i != 0)) {
              z.F(localRecyclerView);
            }
          }
          if (((i2 != 0) || (j == i6) || (localq.getFinalX() == 0)) && ((i != 0) || (k == i7) || (localq.getFinalY() == 0))) {
            localq.abortAnimation();
          }
          if ((i1 != 0) || (m != 0)) {
            RecyclerView.this.O(i1, m);
          }
          if (!RecyclerView.m(RecyclerView.this)) {
            RecyclerView.this.invalidate();
          }
          if ((i5 != 0) && (RecyclerView.this.Zf.eS()) && (m == i5))
          {
            i = 1;
            if ((i4 == 0) || (!RecyclerView.this.Zf.eR()) || (i1 != i4)) {
              break label859;
            }
            j = 1;
            if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
              break label864;
            }
            i = 1;
            if ((!localq.isFinished()) && (i != 0)) {
              break label869;
            }
            RecyclerView.c(RecyclerView.this, 0);
          }
          for (;;)
          {
            if (localp != null)
            {
              if (localp.aaH) {
                localp.ab(0, 0);
              }
              if (!this.abe) {
                localp.stop();
              }
            }
            this.abd = false;
            if (!this.abe) {
              break;
            }
            ga();
            return;
            if (localp.aaG >= n) {
              localp.aaG = (n - 1);
            }
            localp.ab(i4 - j, i5 - k);
            i1 = i;
            i3 = j;
            i2 = m;
            n = k;
            m = i2;
            j = i3;
            k = n;
            break label338;
            if (j > 0)
            {
              i = n;
              break label410;
            }
            i = 0;
            break label410;
            i = n;
            if (k > 0) {
              break label427;
            }
            i = 0;
            break label427;
            if (i2 <= 0) {
              break label466;
            }
            localRecyclerView.ft();
            localRecyclerView.Zz.ag(i2);
            break label466;
            if (i <= 0) {
              break label486;
            }
            localRecyclerView.fv();
            localRecyclerView.ZA.ag(i);
            break label486;
            i = 0;
            break label607;
            j = 0;
            break label634;
            i = 0;
            break label654;
            ga();
          }
          i = 0;
        }
      }
    }
    
    public final void smoothScrollBy(int paramInt1, int paramInt2)
    {
      int k = Math.abs(paramInt1);
      int m = Math.abs(paramInt2);
      int n;
      int i1;
      if (k > m)
      {
        j = 1;
        n = (int)Math.sqrt(0.0D);
        i1 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
        if (j == 0) {
          break label157;
        }
      }
      label157:
      for (int i = RecyclerView.this.getWidth();; i = RecyclerView.this.getHeight())
      {
        int i2 = i / 2;
        float f3 = Math.min(1.0F, i1 * 1.0F / i);
        float f1 = i2;
        float f2 = i2;
        f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
        if (n <= 0) {
          break label169;
        }
        i = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / n)) * 4;
        l(paramInt1, paramInt2, Math.min(i, 2000));
        return;
        j = 0;
        break;
      }
      label169:
      if (j != 0) {}
      for (int j = k;; j = m)
      {
        i = (int)((j / i + 1.0F) * 300.0F);
        break;
      }
    }
    
    public final void stop()
    {
      RecyclerView.this.removeCallbacks(this);
      this.iB.abortAnimation();
    }
  }
  
  public static abstract class t
  {
    private static final List<Object> abm = Collections.EMPTY_LIST;
    public final View abf;
    int abg = -1;
    public long abh = -1L;
    public int abi = -1;
    int abj = -1;
    t abk = null;
    t abl = null;
    List<Object> abn = null;
    List<Object> abo = null;
    private int abp = 0;
    public RecyclerView.m abq = null;
    public boolean abr = false;
    int abs = 0;
    RecyclerView abt;
    int kC = -1;
    public int uf;
    
    public t(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      this.abf = paramView;
    }
    
    final void R(Object paramObject)
    {
      if (paramObject == null) {
        addFlags(1024);
      }
      while ((this.uf & 0x400) != 0) {
        return;
      }
      if (this.abn == null)
      {
        this.abn = new ArrayList();
        this.abo = Collections.unmodifiableList(this.abn);
      }
      this.abn.add(paramObject);
    }
    
    public final void U(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = this.abp - 1;
        this.abp = i;
        if (this.abp >= 0) {
          break label53;
        }
        this.abp = 0;
        new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
      }
      label53:
      do
      {
        return;
        i = this.abp + 1;
        break;
        if ((!paramBoolean) && (this.abp == 1))
        {
          this.uf |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (this.abp != 0));
      this.uf &= 0xFFFFFFEF;
    }
    
    final void a(RecyclerView.m paramm, boolean paramBoolean)
    {
      this.abq = paramm;
      this.abr = paramBoolean;
    }
    
    final void addFlags(int paramInt)
    {
      this.uf |= paramInt;
    }
    
    final boolean bo(int paramInt)
    {
      return (this.uf & paramInt) != 0;
    }
    
    final void gb()
    {
      this.abg = -1;
      this.abj = -1;
    }
    
    final boolean gd()
    {
      return (this.uf & 0x80) != 0;
    }
    
    public final int ge()
    {
      if (this.abj == -1) {
        return this.kC;
      }
      return this.abj;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.abj == -1) {
        return this.kC;
      }
      return this.abj;
    }
    
    public final int gf()
    {
      if (this.abt == null) {
        return -1;
      }
      return RecyclerView.b(this.abt, this);
    }
    
    final boolean gg()
    {
      return this.abq != null;
    }
    
    final void gh()
    {
      this.abq.p(this);
    }
    
    final boolean gi()
    {
      return (this.uf & 0x20) != 0;
    }
    
    final void gj()
    {
      this.uf &= 0xFFFFFFDF;
    }
    
    final void gk()
    {
      this.uf &= 0xFEFF;
    }
    
    final boolean gl()
    {
      return (this.uf & 0x4) != 0;
    }
    
    final boolean gm()
    {
      return (this.uf & 0x2) != 0;
    }
    
    final boolean gn()
    {
      return (this.uf & 0x100) != 0;
    }
    
    final void go()
    {
      if (this.abn != null) {
        this.abn.clear();
      }
      this.uf &= 0xFBFF;
    }
    
    final List<Object> gp()
    {
      if ((this.uf & 0x400) == 0)
      {
        if ((this.abn == null) || (this.abn.size() == 0)) {
          return abm;
        }
        return this.abo;
      }
      return abm;
    }
    
    final void gq()
    {
      this.uf = 0;
      this.kC = -1;
      this.abg = -1;
      this.abh = -1L;
      this.abj = -1;
      this.abp = 0;
      this.abk = null;
      this.abl = null;
      go();
      this.abs = 0;
    }
    
    public final boolean gr()
    {
      return ((this.uf & 0x10) == 0) && (!z.E(this.abf));
    }
    
    final boolean gs()
    {
      return (this.uf & 0x2) != 0;
    }
    
    final boolean isBound()
    {
      return (this.uf & 0x1) != 0;
    }
    
    final boolean isRemoved()
    {
      return (this.uf & 0x8) != 0;
    }
    
    final void p(int paramInt, boolean paramBoolean)
    {
      if (this.abg == -1) {
        this.abg = this.kC;
      }
      if (this.abj == -1) {
        this.abj = this.kC;
      }
      if (paramBoolean) {
        this.abj += paramInt;
      }
      this.kC += paramInt;
      if (this.abf.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.abf.getLayoutParams()).aat = true;
      }
    }
    
    final void setFlags(int paramInt1, int paramInt2)
    {
      this.uf = (this.uf & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.kC + " id=" + this.abh + ", oldPos=" + this.abg + ", pLpos:" + this.abj);
      String str;
      if (gg())
      {
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (this.abr)
        {
          str = "[changeScrap]";
          localStringBuilder2.append(str);
        }
      }
      else
      {
        if (gl()) {
          localStringBuilder1.append(" invalid");
        }
        if (!isBound()) {
          localStringBuilder1.append(" unbound");
        }
        if (gm()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (gd()) {
          localStringBuilder1.append(" ignored");
        }
        if (gn()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!gr()) {
          localStringBuilder1.append(" not recyclable(" + this.abp + ")");
        }
        if (((this.uf & 0x200) == 0) && (!gl())) {
          break label300;
        }
      }
      label300:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (this.abf.getParent() == null) {
          localStringBuilder1.append(" no parent");
        }
        localStringBuilder1.append("}");
        return localStringBuilder1.toString();
        str = "[attachedScrap]";
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */