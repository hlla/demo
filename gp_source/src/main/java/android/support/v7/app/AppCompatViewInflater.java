package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.support.v7.view.e;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.aa;
import android.support.v7.widget.al;
import android.support.v7.widget.an;
import android.support.v7.widget.aq;
import android.support.v7.widget.ar;
import android.support.v7.widget.bb;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final String[] b = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map c = new android.support.v4.g.a();
  private static final Class[] d = { Context.class, AttributeSet.class };
  private static final int[] e = { 16843375 };
  private final Object[] a = new Object[2];
  
  static Context a(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.v7.a.a.dP, 0, 0);
    if (paramBoolean) {}
    for (int i = paramAttributeSet.getResourceId(android.support.v7.a.a.dV, 0);; i = 0)
    {
      if (i == 0)
      {
        i = paramAttributeSet.getResourceId(android.support.v7.a.a.dW, 0);
        if (i != 0) {
          Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
      }
      for (;;)
      {
        paramAttributeSet.recycle();
        paramAttributeSet = paramContext;
        if (i != 0) {
          if ((paramContext instanceof e))
          {
            paramAttributeSet = paramContext;
            if (((e)paramContext).a == i) {}
          }
          else
          {
            paramAttributeSet = new e(paramContext, i);
          }
        }
        return paramAttributeSet;
      }
    }
  }
  
  private final View a(Context paramContext, String paramString1, String paramString2)
  {
    Constructor localConstructor = (Constructor)c.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null)
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString2);
        paramContext.append(paramString1);
      }
      for (paramContext = paramContext.toString();; paramContext = paramString1)
      {
        localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(d);
        c.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(this.a);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext) {}
  }
  
  static void a(View paramView, AttributeSet paramAttributeSet)
  {
    Object localObject = paramView.getContext();
    if (((localObject instanceof ContextWrapper)) && (android.support.v4.view.ac.M(paramView)))
    {
      paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, e);
      localObject = paramAttributeSet.getString(0);
      if (localObject != null) {
        paramView.setOnClickListener(new av(paramView, (String)localObject));
      }
      paramAttributeSet.recycle();
    }
  }
  
  protected static bb b(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new bb(paramContext, paramAttributeSet);
  }
  
  protected static AppCompatImageView c(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatImageView(paramContext, paramAttributeSet);
  }
  
  protected static AppCompatEditText d(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatEditText(paramContext, paramAttributeSet);
  }
  
  protected static AppCompatSpinner e(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatSpinner(paramContext, paramAttributeSet);
  }
  
  protected static al f(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new al(paramContext, paramAttributeSet);
  }
  
  protected static AppCompatCheckBox g(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatCheckBox(paramContext, paramAttributeSet);
  }
  
  protected static AppCompatRadioButton h(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatRadioButton(paramContext, paramAttributeSet);
  }
  
  protected static android.support.v7.widget.ac i(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new android.support.v7.widget.ac(paramContext, paramAttributeSet);
  }
  
  protected static aa j(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new aa(paramContext, paramAttributeSet);
  }
  
  protected static an k(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new an(paramContext, paramAttributeSet);
  }
  
  protected static aq l(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new aq(paramContext, paramAttributeSet);
  }
  
  protected static ar m(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new ar(paramContext, paramAttributeSet);
  }
  
  public AppCompatButton a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatButton(paramContext, paramAttributeSet);
  }
  
  /* Error */
  final View a(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_2
    //   4: ldc -18
    //   6: invokevirtual 242	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +14 -> 23
    //   12: aload_3
    //   13: aconst_null
    //   14: ldc -12
    //   16: invokeinterface 248 3 0
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 48	android/support/v7/app/AppCompatViewInflater:a	[Ljava/lang/Object;
    //   27: astore_2
    //   28: aload_2
    //   29: iconst_0
    //   30: aload_1
    //   31: aastore
    //   32: aload_2
    //   33: iconst_1
    //   34: aload_3
    //   35: aastore
    //   36: aload 5
    //   38: bipush 46
    //   40: invokevirtual 252	java/lang/String:indexOf	(I)I
    //   43: iconst_m1
    //   44: if_icmpeq +27 -> 71
    //   47: aload_0
    //   48: aload_1
    //   49: aload 5
    //   51: aconst_null
    //   52: invokespecial 254	android/support/v7/app/AppCompatViewInflater:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 48	android/support/v7/app/AppCompatViewInflater:a	[Ljava/lang/Object;
    //   60: astore_2
    //   61: aload_2
    //   62: iconst_0
    //   63: aconst_null
    //   64: aastore
    //   65: aload_2
    //   66: iconst_1
    //   67: aconst_null
    //   68: aastore
    //   69: aload_1
    //   70: areturn
    //   71: iconst_0
    //   72: istore 4
    //   74: iload 4
    //   76: getstatic 37	android/support/v7/app/AppCompatViewInflater:b	[Ljava/lang/String;
    //   79: arraylength
    //   80: if_icmpge +45 -> 125
    //   83: aload_0
    //   84: aload_1
    //   85: aload 5
    //   87: getstatic 37	android/support/v7/app/AppCompatViewInflater:b	[Ljava/lang/String;
    //   90: iload 4
    //   92: aaload
    //   93: invokespecial 254	android/support/v7/app/AppCompatViewInflater:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +18 -> 116
    //   101: aload_0
    //   102: getfield 48	android/support/v7/app/AppCompatViewInflater:a	[Ljava/lang/Object;
    //   105: astore_1
    //   106: aload_1
    //   107: iconst_0
    //   108: aconst_null
    //   109: aastore
    //   110: aload_1
    //   111: iconst_1
    //   112: aconst_null
    //   113: aastore
    //   114: aload_2
    //   115: areturn
    //   116: iload 4
    //   118: iconst_1
    //   119: iadd
    //   120: istore 4
    //   122: goto -48 -> 74
    //   125: aload_0
    //   126: getfield 48	android/support/v7/app/AppCompatViewInflater:a	[Ljava/lang/Object;
    //   129: astore_1
    //   130: aload_1
    //   131: iconst_0
    //   132: aconst_null
    //   133: aastore
    //   134: aload_1
    //   135: iconst_1
    //   136: aconst_null
    //   137: aastore
    //   138: aconst_null
    //   139: areturn
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 48	android/support/v7/app/AppCompatViewInflater:a	[Ljava/lang/Object;
    //   145: astore_1
    //   146: aload_1
    //   147: iconst_0
    //   148: aconst_null
    //   149: aastore
    //   150: aload_1
    //   151: iconst_1
    //   152: aconst_null
    //   153: aastore
    //   154: aconst_null
    //   155: areturn
    //   156: astore_1
    //   157: aload_0
    //   158: getfield 48	android/support/v7/app/AppCompatViewInflater:a	[Ljava/lang/Object;
    //   161: astore_2
    //   162: aload_2
    //   163: iconst_0
    //   164: aconst_null
    //   165: aastore
    //   166: aload_2
    //   167: iconst_1
    //   168: aconst_null
    //   169: aastore
    //   170: aload_1
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	AppCompatViewInflater
    //   0	172	1	paramContext	Context
    //   0	172	2	paramString	String
    //   0	172	3	paramAttributeSet	AttributeSet
    //   72	49	4	i	int
    //   1	85	5	str	String
    // Exception table:
    //   from	to	target	type
    //   23	28	140	java/lang/Exception
    //   36	56	140	java/lang/Exception
    //   74	97	140	java/lang/Exception
    //   23	28	156	finally
    //   36	56	156	finally
    //   74	97	156	finally
  }
  
  final void a(View paramView, String paramString)
  {
    if (paramView == null)
    {
      paramView = new StringBuilder();
      paramView.append(getClass().getName());
      paramView.append(" asked to inflate view for <");
      paramView.append(paramString);
      paramView.append(">, but returned null");
      throw new IllegalStateException(paramView.toString());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/AppCompatViewInflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */