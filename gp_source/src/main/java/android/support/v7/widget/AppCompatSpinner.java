package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class AppCompatSpinner
  extends Spinner
  implements android.support.v4.view.ab
{
  private static final int[] d = { 16843505 };
  public int a;
  public av b;
  public final Rect c;
  private final ab e;
  private ch f;
  private final Context g;
  private final boolean h;
  private SpinnerAdapter i;
  
  public AppCompatSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt)
  {
    this(paramContext, null, 2130969520, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969520);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, null);
  }
  
  /* Error */
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, android.content.res.Resources.Theme paramTheme)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: iload_3
    //   7: invokespecial 49	android/widget/Spinner:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   10: aload_0
    //   11: new 51	android/graphics/Rect
    //   14: dup
    //   15: invokespecial 53	android/graphics/Rect:<init>	()V
    //   18: putfield 55	android/support/v7/widget/AppCompatSpinner:c	Landroid/graphics/Rect;
    //   21: aload_1
    //   22: aload_2
    //   23: getstatic 60	android/support/v7/a/a:cx	[I
    //   26: iload_3
    //   27: iconst_0
    //   28: invokestatic 65	android/support/v7/widget/hf:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/hf;
    //   31: astore 9
    //   33: aload_0
    //   34: new 67	android/support/v7/widget/ab
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 70	android/support/v7/widget/ab:<init>	(Landroid/view/View;)V
    //   42: putfield 72	android/support/v7/widget/AppCompatSpinner:e	Landroid/support/v7/widget/ab;
    //   45: aload 5
    //   47: ifnull +280 -> 327
    //   50: aload_0
    //   51: new 74	android/support/v7/view/e
    //   54: dup
    //   55: aload_1
    //   56: aload 5
    //   58: invokespecial 77	android/support/v7/view/e:<init>	(Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   61: putfield 79	android/support/v7/widget/AppCompatSpinner:g	Landroid/content/Context;
    //   64: aload_0
    //   65: getfield 79	android/support/v7/widget/AppCompatSpinner:g	Landroid/content/Context;
    //   68: ifnonnull +88 -> 156
    //   71: aload 9
    //   73: getfield 82	android/support/v7/widget/hf:c	Landroid/content/res/TypedArray;
    //   76: iconst_0
    //   77: invokevirtual 88	android/content/res/TypedArray:getTextArray	(I)[Ljava/lang/CharSequence;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnonnull +45 -> 129
    //   87: aload 9
    //   89: getfield 82	android/support/v7/widget/hf:c	Landroid/content/res/TypedArray;
    //   92: invokevirtual 91	android/content/res/TypedArray:recycle	()V
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 93	android/support/v7/widget/AppCompatSpinner:h	Z
    //   100: aload_0
    //   101: getfield 95	android/support/v7/widget/AppCompatSpinner:i	Landroid/widget/SpinnerAdapter;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +13 -> 119
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 99	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 95	android/support/v7/widget/AppCompatSpinner:i	Landroid/widget/SpinnerAdapter;
    //   119: aload_0
    //   120: getfield 72	android/support/v7/widget/AppCompatSpinner:e	Landroid/support/v7/widget/ab;
    //   123: aload_2
    //   124: iload_3
    //   125: invokevirtual 102	android/support/v7/widget/ab:a	(Landroid/util/AttributeSet;I)V
    //   128: return
    //   129: new 104	android/widget/ArrayAdapter
    //   132: dup
    //   133: aload_1
    //   134: ldc 105
    //   136: aload 5
    //   138: invokespecial 108	android/widget/ArrayAdapter:<init>	(Landroid/content/Context;I[Ljava/lang/Object;)V
    //   141: astore_1
    //   142: aload_1
    //   143: ldc 109
    //   145: invokevirtual 113	android/widget/ArrayAdapter:setDropDownViewResource	(I)V
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 99	android/support/v7/widget/AppCompatSpinner:setAdapter	(Landroid/widget/SpinnerAdapter;)V
    //   153: goto -66 -> 87
    //   156: iload 4
    //   158: istore 7
    //   160: iload 4
    //   162: iconst_m1
    //   163: if_icmpne +55 -> 218
    //   166: aload_1
    //   167: aload_2
    //   168: getstatic 29	android/support/v7/widget/AppCompatSpinner:d	[I
    //   171: iload_3
    //   172: iconst_0
    //   173: invokevirtual 119	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   176: astore 5
    //   178: iload 4
    //   180: istore 6
    //   182: aload 5
    //   184: iconst_0
    //   185: invokevirtual 123	android/content/res/TypedArray:hasValue	(I)Z
    //   188: ifeq +12 -> 200
    //   191: aload 5
    //   193: iconst_0
    //   194: iconst_0
    //   195: invokevirtual 127	android/content/res/TypedArray:getInt	(II)I
    //   198: istore 6
    //   200: iload 6
    //   202: istore 7
    //   204: aload 5
    //   206: ifnull +12 -> 218
    //   209: aload 5
    //   211: invokevirtual 91	android/content/res/TypedArray:recycle	()V
    //   214: iload 6
    //   216: istore 7
    //   218: iload 7
    //   220: iconst_1
    //   221: if_icmpne -150 -> 71
    //   224: new 129	android/support/v7/widget/av
    //   227: dup
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 79	android/support/v7/widget/AppCompatSpinner:g	Landroid/content/Context;
    //   233: aload_2
    //   234: iload_3
    //   235: invokespecial 132	android/support/v7/widget/av:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   238: astore 5
    //   240: aload_0
    //   241: getfield 79	android/support/v7/widget/AppCompatSpinner:g	Landroid/content/Context;
    //   244: aload_2
    //   245: getstatic 60	android/support/v7/a/a:cx	[I
    //   248: iload_3
    //   249: iconst_0
    //   250: invokestatic 65	android/support/v7/widget/hf:a	(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/hf;
    //   253: astore 8
    //   255: aload_0
    //   256: aload 8
    //   258: getstatic 135	android/support/v7/a/a:cy	I
    //   261: bipush -2
    //   263: invokevirtual 137	android/support/v7/widget/hf:f	(II)I
    //   266: putfield 139	android/support/v7/widget/AppCompatSpinner:a	I
    //   269: aload 5
    //   271: aload 8
    //   273: getstatic 142	android/support/v7/a/a:cz	I
    //   276: invokevirtual 145	android/support/v7/widget/hf:a	(I)Landroid/graphics/drawable/Drawable;
    //   279: invokevirtual 150	android/support/v7/widget/du:a	(Landroid/graphics/drawable/Drawable;)V
    //   282: aload 5
    //   284: aload 9
    //   286: getstatic 153	android/support/v7/a/a:cA	I
    //   289: invokevirtual 156	android/support/v7/widget/hf:d	(I)Ljava/lang/String;
    //   292: putfield 159	android/support/v7/widget/av:b	Ljava/lang/CharSequence;
    //   295: aload 8
    //   297: getfield 82	android/support/v7/widget/hf:c	Landroid/content/res/TypedArray;
    //   300: invokevirtual 91	android/content/res/TypedArray:recycle	()V
    //   303: aload_0
    //   304: aload 5
    //   306: putfield 161	android/support/v7/widget/AppCompatSpinner:b	Landroid/support/v7/widget/av;
    //   309: aload_0
    //   310: new 163	android/support/v7/widget/at
    //   313: dup
    //   314: aload_0
    //   315: aload_0
    //   316: aload 5
    //   318: invokespecial 166	android/support/v7/widget/at:<init>	(Landroid/support/v7/widget/AppCompatSpinner;Landroid/view/View;Landroid/support/v7/widget/av;)V
    //   321: putfield 168	android/support/v7/widget/AppCompatSpinner:f	Landroid/support/v7/widget/ch;
    //   324: goto -253 -> 71
    //   327: aload 9
    //   329: getstatic 171	android/support/v7/a/a:cB	I
    //   332: iconst_0
    //   333: invokevirtual 173	android/support/v7/widget/hf:g	(II)I
    //   336: istore 6
    //   338: iload 6
    //   340: ifeq +20 -> 360
    //   343: aload_0
    //   344: new 74	android/support/v7/view/e
    //   347: dup
    //   348: aload_1
    //   349: iload 6
    //   351: invokespecial 175	android/support/v7/view/e:<init>	(Landroid/content/Context;I)V
    //   354: putfield 79	android/support/v7/widget/AppCompatSpinner:g	Landroid/content/Context;
    //   357: goto -293 -> 64
    //   360: getstatic 180	android/os/Build$VERSION:SDK_INT	I
    //   363: bipush 23
    //   365: if_icmpge +15 -> 380
    //   368: aload_1
    //   369: astore 5
    //   371: aload_0
    //   372: aload 5
    //   374: putfield 79	android/support/v7/widget/AppCompatSpinner:g	Landroid/content/Context;
    //   377: goto -313 -> 64
    //   380: aconst_null
    //   381: astore 5
    //   383: goto -12 -> 371
    //   386: astore 8
    //   388: aconst_null
    //   389: astore 5
    //   391: ldc -74
    //   393: ldc -72
    //   395: aload 8
    //   397: invokestatic 189	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   400: pop
    //   401: iload 4
    //   403: istore 7
    //   405: aload 5
    //   407: ifnull -189 -> 218
    //   410: aload 5
    //   412: invokevirtual 91	android/content/res/TypedArray:recycle	()V
    //   415: iload 4
    //   417: istore 7
    //   419: goto -201 -> 218
    //   422: astore_1
    //   423: aload 5
    //   425: astore_2
    //   426: aload_2
    //   427: ifnull +7 -> 434
    //   430: aload_2
    //   431: invokevirtual 91	android/content/res/TypedArray:recycle	()V
    //   434: aload_1
    //   435: athrow
    //   436: astore_1
    //   437: aload 5
    //   439: astore_2
    //   440: goto -14 -> 426
    //   443: astore 8
    //   445: goto -54 -> 391
    //   448: astore_1
    //   449: aload 8
    //   451: astore_2
    //   452: goto -26 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	this	AppCompatSpinner
    //   0	455	1	paramContext	Context
    //   0	455	2	paramAttributeSet	AttributeSet
    //   0	455	3	paramInt1	int
    //   0	455	4	paramInt2	int
    //   0	455	5	paramTheme	android.content.res.Resources.Theme
    //   180	170	6	j	int
    //   158	260	7	k	int
    //   1	295	8	localhf1	hf
    //   386	10	8	localException1	Exception
    //   443	7	8	localException2	Exception
    //   31	297	9	localhf2	hf
    // Exception table:
    //   from	to	target	type
    //   166	178	386	java/lang/Exception
    //   182	200	422	finally
    //   391	401	436	finally
    //   182	200	443	java/lang/Exception
    //   166	178	448	finally
  }
  
  final int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable)
  {
    int j = 0;
    int n;
    if (paramSpinnerAdapter != null)
    {
      int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
      int i3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
      j = Math.max(0, getSelectedItemPosition());
      int i4 = Math.min(paramSpinnerAdapter.getCount(), j + 15);
      int m = Math.max(0, j - (15 - (i4 - j)));
      j = 0;
      n = 0;
      View localView = null;
      if (m < i4)
      {
        int i1 = paramSpinnerAdapter.getItemViewType(m);
        if (i1 != j) {}
        for (int k = i1;; k = j)
        {
          if (i1 != j) {
            localView = null;
          }
          localView = paramSpinnerAdapter.getView(m, localView, this);
          if (localView.getLayoutParams() == null) {
            localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          }
          localView.measure(i2, i3);
          n = Math.max(n, localView.getMeasuredWidth());
          m += 1;
          j = k;
          break;
        }
      }
      if (paramDrawable != null)
      {
        paramDrawable.getPadding(this.c);
        j = this.c.left + this.c.right + n;
      }
    }
    else
    {
      return j;
    }
    return n;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ab localab = this.e;
    if (localab != null) {
      localab.d();
    }
  }
  
  public int getDropDownHorizontalOffset()
  {
    av localav = this.b;
    if (localav == null) {
      return super.getDropDownHorizontalOffset();
    }
    return localav.g;
  }
  
  public int getDropDownVerticalOffset()
  {
    av localav = this.b;
    if (localav != null) {
      return localav.g();
    }
    return super.getDropDownVerticalOffset();
  }
  
  public int getDropDownWidth()
  {
    if (this.b != null) {
      return this.a;
    }
    return super.getDropDownWidth();
  }
  
  public Drawable getPopupBackground()
  {
    av localav = this.b;
    if (localav == null) {
      return super.getPopupBackground();
    }
    return localav.q.getBackground();
  }
  
  public Context getPopupContext()
  {
    if (this.b != null) {
      return this.g;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return super.getPopupContext();
    }
    return null;
  }
  
  public CharSequence getPrompt()
  {
    av localav = this.b;
    if (localav == null) {
      return super.getPrompt();
    }
    return localav.b;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    ab localab = this.e;
    if (localab != null) {
      return localab.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    ab localab = this.e;
    if (localab != null) {
      return localab.c();
    }
    return null;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    av localav = this.b;
    if ((localav != null) && (localav.q.isShowing())) {
      this.b.c();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.b != null) && (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    ch localch = this.f;
    if ((localch == null) || (!localch.onTouch(this, paramMotionEvent))) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public boolean performClick()
  {
    av localav = this.b;
    if (localav != null)
    {
      if (!localav.q.isShowing()) {
        this.b.b();
      }
      return true;
    }
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    if (!this.h) {
      this.i = paramSpinnerAdapter;
    }
    do
    {
      return;
      super.setAdapter(paramSpinnerAdapter);
    } while (this.b == null);
    Context localContext2 = this.g;
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = getContext();
    }
    this.b.a(new au(paramSpinnerAdapter, localContext1.getTheme()));
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.e;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    ab localab = this.e;
    if (localab != null) {
      localab.a(paramInt);
    }
  }
  
  public void setDropDownHorizontalOffset(int paramInt)
  {
    av localav = this.b;
    if (localav == null)
    {
      super.setDropDownHorizontalOffset(paramInt);
      return;
    }
    localav.g = paramInt;
  }
  
  public void setDropDownVerticalOffset(int paramInt)
  {
    av localav = this.b;
    if (localav != null)
    {
      localav.a(paramInt);
      return;
    }
    super.setDropDownVerticalOffset(paramInt);
  }
  
  public void setDropDownWidth(int paramInt)
  {
    if (this.b != null)
    {
      this.a = paramInt;
      return;
    }
    super.setDropDownWidth(paramInt);
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable)
  {
    av localav = this.b;
    if (localav != null)
    {
      localav.a(paramDrawable);
      return;
    }
    super.setPopupBackgroundDrawable(paramDrawable);
  }
  
  public void setPopupBackgroundResource(int paramInt)
  {
    setPopupBackgroundDrawable(a.b(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence)
  {
    av localav = this.b;
    if (localav == null)
    {
      super.setPrompt(paramCharSequence);
      return;
    }
    localav.b = paramCharSequence;
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    ab localab = this.e;
    if (localab != null) {
      localab.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    ab localab = this.e;
    if (localab != null) {
      localab.a(paramMode);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/AppCompatSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */