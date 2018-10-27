package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public final class ar
  extends SeekBar
{
  private final as a = new as(this);
  
  public ar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private ar(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet, 2130969475);
    this.a.a(paramAttributeSet, 2130969475);
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    as localas = this.a;
    Drawable localDrawable = localas.b;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(localas.c.getDrawableState()))) {
      localas.c.invalidateDrawable(localDrawable);
    }
  }
  
  public final void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.a.b;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  /* Error */
  protected final void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 68	android/widget/SeekBar:onDraw	(Landroid/graphics/Canvas;)V
    //   10: aload_0
    //   11: getfield 23	android/support/v7/widget/ar:a	Landroid/support/v7/widget/as;
    //   14: astore 7
    //   16: aload 7
    //   18: getfield 36	android/support/v7/widget/as:b	Landroid/graphics/drawable/Drawable;
    //   21: ifnull +171 -> 192
    //   24: aload 7
    //   26: getfield 46	android/support/v7/widget/as:c	Landroid/widget/SeekBar;
    //   29: invokevirtual 72	android/widget/SeekBar:getMax	()I
    //   32: istore 5
    //   34: iload 5
    //   36: iconst_1
    //   37: if_icmple +155 -> 192
    //   40: aload 7
    //   42: getfield 36	android/support/v7/widget/as:b	Landroid/graphics/drawable/Drawable;
    //   45: invokevirtual 75	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   48: istore_3
    //   49: aload 7
    //   51: getfield 36	android/support/v7/widget/as:b	Landroid/graphics/drawable/Drawable;
    //   54: invokevirtual 78	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   57: istore 6
    //   59: iload_3
    //   60: iflt +135 -> 195
    //   63: iload_3
    //   64: iconst_2
    //   65: idiv
    //   66: istore_3
    //   67: iload 6
    //   69: iflt +9 -> 78
    //   72: iload 6
    //   74: iconst_2
    //   75: idiv
    //   76: istore 4
    //   78: aload 7
    //   80: getfield 36	android/support/v7/widget/as:b	Landroid/graphics/drawable/Drawable;
    //   83: iload_3
    //   84: ineg
    //   85: iload 4
    //   87: ineg
    //   88: iload_3
    //   89: iload 4
    //   91: invokevirtual 82	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   94: aload 7
    //   96: getfield 46	android/support/v7/widget/as:c	Landroid/widget/SeekBar;
    //   99: invokevirtual 85	android/widget/SeekBar:getWidth	()I
    //   102: aload 7
    //   104: getfield 46	android/support/v7/widget/as:c	Landroid/widget/SeekBar;
    //   107: invokevirtual 88	android/widget/SeekBar:getPaddingLeft	()I
    //   110: isub
    //   111: aload 7
    //   113: getfield 46	android/support/v7/widget/as:c	Landroid/widget/SeekBar;
    //   116: invokevirtual 91	android/widget/SeekBar:getPaddingRight	()I
    //   119: isub
    //   120: i2f
    //   121: iload 5
    //   123: i2f
    //   124: fdiv
    //   125: fstore_2
    //   126: aload_1
    //   127: invokevirtual 96	android/graphics/Canvas:save	()I
    //   130: istore 4
    //   132: aload_1
    //   133: aload 7
    //   135: getfield 46	android/support/v7/widget/as:c	Landroid/widget/SeekBar;
    //   138: invokevirtual 88	android/widget/SeekBar:getPaddingLeft	()I
    //   141: i2f
    //   142: aload 7
    //   144: getfield 46	android/support/v7/widget/as:c	Landroid/widget/SeekBar;
    //   147: invokevirtual 99	android/widget/SeekBar:getHeight	()I
    //   150: iconst_2
    //   151: idiv
    //   152: i2f
    //   153: invokevirtual 103	android/graphics/Canvas:translate	(FF)V
    //   156: iconst_0
    //   157: istore_3
    //   158: iload_3
    //   159: iload 5
    //   161: if_icmpgt +25 -> 186
    //   164: aload 7
    //   166: getfield 36	android/support/v7/widget/as:b	Landroid/graphics/drawable/Drawable;
    //   169: aload_1
    //   170: invokevirtual 106	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   173: aload_1
    //   174: fload_2
    //   175: fconst_0
    //   176: invokevirtual 103	android/graphics/Canvas:translate	(FF)V
    //   179: iload_3
    //   180: iconst_1
    //   181: iadd
    //   182: istore_3
    //   183: goto -25 -> 158
    //   186: aload_1
    //   187: iload 4
    //   189: invokevirtual 110	android/graphics/Canvas:restoreToCount	(I)V
    //   192: aload_0
    //   193: monitorexit
    //   194: return
    //   195: iconst_1
    //   196: istore_3
    //   197: goto -130 -> 67
    //   200: astore_1
    //   201: aload_0
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	ar
    //   0	205	1	paramCanvas	android.graphics.Canvas
    //   125	50	2	f	float
    //   48	149	3	i	int
    //   1	187	4	j	int
    //   32	130	5	k	int
    //   57	19	6	m	int
    //   14	151	7	localas	as
    // Exception table:
    //   from	to	target	type
    //   5	34	200	finally
    //   40	59	200	finally
    //   63	67	200	finally
    //   72	78	200	finally
    //   78	156	200	finally
    //   164	179	200	finally
    //   186	192	200	finally
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */