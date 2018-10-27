package android.support.v7.widget;

import android.content.res.TypedArray;
import android.support.v7.d.a;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class de
  extends ViewGroup.MarginLayoutParams
{
  private static final int c;
  private static final int d;
  private static final int e;
  private static final int f;
  private static final int g = new dd(Integer.MIN_VALUE, -2147483647).a();
  private static final int h = a.k;
  private static final int i;
  private static final int j = a.c;
  private static final int k;
  private static final int l;
  private static final int m;
  private static final int n;
  private static final int o;
  public dh a = dh.a;
  public dh b = dh.a;
  
  static
  {
    i = a.e;
    o = a.g;
    k = a.f;
    c = a.d;
    d = a.h;
    e = a.i;
    f = a.j;
    l = a.l;
    m = a.m;
    n = a.n;
  }
  
  public de()
  {
    this(dh.a, dh.a, (byte)0);
  }
  
  /* Error */
  public de(android.content.Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 85	android/view/ViewGroup$MarginLayoutParams:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: getstatic 79	android/support/v7/widget/dh:a	Landroid/support/v7/widget/dh;
    //   10: putfield 87	android/support/v7/widget/de:b	Landroid/support/v7/widget/dh;
    //   13: aload_0
    //   14: getstatic 79	android/support/v7/widget/dh:a	Landroid/support/v7/widget/dh;
    //   17: putfield 88	android/support/v7/widget/de:a	Landroid/support/v7/widget/dh;
    //   20: aload_1
    //   21: aload_2
    //   22: getstatic 91	android/support/v7/d/a:b	[I
    //   25: invokevirtual 97	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   28: astore 7
    //   30: aload 7
    //   32: getstatic 42	android/support/v7/widget/de:j	I
    //   35: ldc 26
    //   37: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   40: istore 4
    //   42: aload_0
    //   43: aload 7
    //   45: getstatic 46	android/support/v7/widget/de:i	I
    //   48: iload 4
    //   50: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   53: putfield 106	android/support/v7/widget/de:leftMargin	I
    //   56: aload_0
    //   57: aload 7
    //   59: getstatic 49	android/support/v7/widget/de:o	I
    //   62: iload 4
    //   64: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   67: putfield 109	android/support/v7/widget/de:topMargin	I
    //   70: aload_0
    //   71: aload 7
    //   73: getstatic 53	android/support/v7/widget/de:k	I
    //   76: iload 4
    //   78: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   81: putfield 112	android/support/v7/widget/de:rightMargin	I
    //   84: aload_0
    //   85: aload 7
    //   87: getstatic 56	android/support/v7/widget/de:c	I
    //   90: iload 4
    //   92: invokevirtual 103	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   95: putfield 115	android/support/v7/widget/de:bottomMargin	I
    //   98: aload 7
    //   100: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   103: aload_1
    //   104: aload_2
    //   105: getstatic 91	android/support/v7/d/a:b	[I
    //   108: invokevirtual 97	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   111: astore_1
    //   112: aload_1
    //   113: getstatic 74	android/support/v7/widget/de:h	I
    //   116: iconst_0
    //   117: invokevirtual 121	android/content/res/TypedArray:getInt	(II)I
    //   120: istore 4
    //   122: aload_1
    //   123: getstatic 59	android/support/v7/widget/de:d	I
    //   126: ldc 26
    //   128: invokevirtual 121	android/content/res/TypedArray:getInt	(II)I
    //   131: istore 5
    //   133: aload_1
    //   134: getstatic 61	android/support/v7/widget/de:e	I
    //   137: getstatic 36	android/support/v7/widget/de:g	I
    //   140: invokevirtual 121	android/content/res/TypedArray:getInt	(II)I
    //   143: istore 6
    //   145: aload_1
    //   146: getstatic 63	android/support/v7/widget/de:f	I
    //   149: fconst_0
    //   150: invokevirtual 125	android/content/res/TypedArray:getFloat	(IF)F
    //   153: fstore_3
    //   154: aload_0
    //   155: iload 5
    //   157: iload 6
    //   159: iload 4
    //   161: iconst_1
    //   162: invokestatic 130	android/support/v7/widget/GridLayout:a	(IZ)Landroid/support/v7/widget/cx;
    //   165: fload_3
    //   166: invokestatic 133	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/cx;F)Landroid/support/v7/widget/dh;
    //   169: putfield 88	android/support/v7/widget/de:a	Landroid/support/v7/widget/dh;
    //   172: aload_1
    //   173: getstatic 66	android/support/v7/widget/de:l	I
    //   176: ldc 26
    //   178: invokevirtual 121	android/content/res/TypedArray:getInt	(II)I
    //   181: istore 5
    //   183: aload_1
    //   184: getstatic 69	android/support/v7/widget/de:m	I
    //   187: getstatic 36	android/support/v7/widget/de:g	I
    //   190: invokevirtual 121	android/content/res/TypedArray:getInt	(II)I
    //   193: istore 6
    //   195: aload_1
    //   196: getstatic 72	android/support/v7/widget/de:n	I
    //   199: fconst_0
    //   200: invokevirtual 125	android/content/res/TypedArray:getFloat	(IF)F
    //   203: fstore_3
    //   204: aload_0
    //   205: iload 5
    //   207: iload 6
    //   209: iload 4
    //   211: iconst_0
    //   212: invokestatic 130	android/support/v7/widget/GridLayout:a	(IZ)Landroid/support/v7/widget/cx;
    //   215: fload_3
    //   216: invokestatic 133	android/support/v7/widget/GridLayout:a	(IILandroid/support/v7/widget/cx;F)Landroid/support/v7/widget/dh;
    //   219: putfield 87	android/support/v7/widget/de:b	Landroid/support/v7/widget/dh;
    //   222: aload_1
    //   223: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   226: return
    //   227: astore_1
    //   228: aload 7
    //   230: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_2
    //   236: aload_1
    //   237: invokevirtual 118	android/content/res/TypedArray:recycle	()V
    //   240: aload_2
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	de
    //   0	242	1	paramContext	android.content.Context
    //   0	242	2	paramAttributeSet	android.util.AttributeSet
    //   153	63	3	f1	float
    //   40	170	4	i1	int
    //   131	75	5	i2	int
    //   143	65	6	i3	int
    //   28	201	7	localTypedArray	TypedArray
    // Exception table:
    //   from	to	target	type
    //   30	98	227	finally
    //   112	222	235	finally
  }
  
  public de(de paramde)
  {
    super(paramde);
    this.b = paramde.b;
    this.a = paramde.a;
  }
  
  private de(dh paramdh1, dh paramdh2)
  {
    super(-2, -2);
    setMargins(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    this.b = paramdh1;
    this.a = paramdh2;
  }
  
  private de(dh paramdh1, dh paramdh2, byte paramByte)
  {
    this(paramdh1, paramdh2);
  }
  
  public de(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public de(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        break label59;
      }
      paramObject = (de)paramObject;
      if (!this.a.equals(((de)paramObject).a)) {}
    }
    else
    {
      return this.b.equals(((de)paramObject).b);
    }
    return false;
    label59:
    return false;
  }
  
  public final int hashCode()
  {
    return this.b.hashCode() * 31 + this.a.hashCode();
  }
  
  protected final void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    this.width = paramTypedArray.getLayoutDimension(paramInt1, -2);
    this.height = paramTypedArray.getLayoutDimension(paramInt2, -2);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */