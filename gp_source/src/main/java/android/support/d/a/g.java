package android.support.d.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.a.b;
import android.support.v4.a.d;
import android.support.v4.content.a.o;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public final class g
{
  /* Error */
  public static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: iload_3
    //   11: invokevirtual 16	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 7
    //   16: aload 7
    //   18: astore 4
    //   20: aload_0
    //   21: aload_1
    //   22: aload_2
    //   23: aload 4
    //   25: aload 4
    //   27: invokestatic 22	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   30: aconst_null
    //   31: iconst_0
    //   32: fconst_1
    //   33: invokestatic 25	android/support/d/a/g:a	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/animation/AnimatorSet;IF)Landroid/animation/Animator;
    //   36: astore_0
    //   37: aload 4
    //   39: ifnull +10 -> 49
    //   42: aload 4
    //   44: invokeinterface 31 1 0
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: aload 5
    //   54: astore 4
    //   56: new 33	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: ldc 38
    //   67: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: iload_3
    //   73: invokestatic 48	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   76: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: new 50	android/content/res/Resources$NotFoundException
    //   83: dup
    //   84: aload_1
    //   85: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 57	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   91: astore_1
    //   92: aload_1
    //   93: aload_0
    //   94: invokevirtual 61	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   97: pop
    //   98: aload_1
    //   99: athrow
    //   100: astore_0
    //   101: aload 4
    //   103: ifnull +10 -> 113
    //   106: aload 4
    //   108: invokeinterface 31 1 0
    //   113: aload_0
    //   114: athrow
    //   115: astore_0
    //   116: aload 6
    //   118: astore 4
    //   120: new 33	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   127: astore_1
    //   128: aload_1
    //   129: ldc 38
    //   131: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: iload_3
    //   137: invokestatic 48	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   140: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: new 50	android/content/res/Resources$NotFoundException
    //   147: dup
    //   148: aload_1
    //   149: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 57	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: invokevirtual 61	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   161: pop
    //   162: aload_1
    //   163: athrow
    //   164: astore_0
    //   165: goto -64 -> 101
    //   168: astore_0
    //   169: goto -68 -> 101
    //   172: astore_0
    //   173: goto -72 -> 101
    //   176: astore_0
    //   177: goto -57 -> 120
    //   180: astore_0
    //   181: goto -125 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramContext	Context
    //   0	184	1	paramResources	Resources
    //   0	184	2	paramTheme	Resources.Theme
    //   0	184	3	paramInt	int
    //   1	118	4	localObject1	Object
    //   7	46	5	localObject2	Object
    //   4	113	6	localObject3	Object
    //   14	3	7	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   9	16	51	org/xmlpull/v1/XmlPullParserException
    //   56	100	100	finally
    //   9	16	115	java/io/IOException
    //   120	164	164	finally
    //   9	16	168	finally
    //   20	37	172	finally
    //   20	37	176	java/io/IOException
    //   20	37	180	org/xmlpull/v1/XmlPullParserException
  }
  
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
  {
    int i2 = paramXmlPullParser.getDepth();
    Object localObject5 = null;
    Object localObject4 = null;
    int i;
    int k;
    int j;
    do
    {
      i = paramXmlPullParser.next();
      if ((i == 3) && (paramXmlPullParser.getDepth() <= i2)) {}
      while (i == 1)
      {
        if ((paramAnimatorSet != null) && (localObject4 != null))
        {
          paramContext = new Animator[((ArrayList)localObject4).size()];
          k = ((ArrayList)localObject4).size();
          i = 0;
          j = 0;
          while (i < k)
          {
            paramContext[j] = ((Animator)((ArrayList)localObject4).get(i));
            j += 1;
            i += 1;
          }
          if (paramInt != 0) {
            paramAnimatorSet.playSequentially(paramContext);
          }
        }
        else
        {
          return (Animator)localObject5;
        }
        paramAnimatorSet.playTogether(paramContext);
        return (Animator)localObject5;
      }
    } while (i != 2);
    Object localObject1 = paramXmlPullParser.getName();
    if (((String)localObject1).equals("objectAnimator"))
    {
      localObject1 = new ObjectAnimator();
      a(paramContext, paramResources, paramTheme, paramAttributeSet, (ValueAnimator)localObject1, paramFloat, paramXmlPullParser);
      i = 0;
    }
    Object localObject2;
    for (;;)
    {
      localObject5 = localObject1;
      if (paramAnimatorSet == null) {
        break;
      }
      localObject5 = localObject1;
      if (i != 0) {
        break;
      }
      if (localObject4 == null) {}
      for (localObject2 = new ArrayList();; localObject2 = localObject4)
      {
        ((ArrayList)localObject2).add(localObject1);
        localObject5 = localObject1;
        localObject4 = localObject2;
        break;
      }
      if (((String)localObject1).equals("animator"))
      {
        localObject1 = a(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
        i = 0;
      }
      else
      {
        if (!((String)localObject1).equals("set")) {
          break label340;
        }
        localObject1 = new AnimatorSet();
        localObject2 = o.a(paramResources, paramTheme, paramAttributeSet, a.d);
        a(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, o.a((TypedArray)localObject2, paramXmlPullParser, "ordering", 0, 0), paramFloat);
        ((TypedArray)localObject2).recycle();
        i = 0;
      }
    }
    label340:
    if (((String)localObject1).equals("propertyValuesHolder"))
    {
      AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
      localObject1 = null;
      for (;;)
      {
        i = paramXmlPullParser.getEventType();
        if (i == 3) {}
        while (i == 1)
        {
          if (localObject1 != null)
          {
            j = ((ArrayList)localObject1).size();
            localObject2 = new PropertyValuesHolder[j];
            i = 0;
            while (i < j)
            {
              localObject2[i] = ((PropertyValuesHolder)((ArrayList)localObject1).get(i));
              i += 1;
            }
          }
          for (localObject1 = localObject2;; localObject1 = null)
          {
            if (localObject1 == null)
            {
              i = 1;
              localObject1 = localObject5;
              break;
            }
            if (localObject5 == null)
            {
              i = 1;
              localObject1 = localObject5;
              break;
            }
            if ((localObject5 instanceof ValueAnimator))
            {
              ((ValueAnimator)localObject5).setValues((PropertyValuesHolder[])localObject1);
              i = 1;
              localObject1 = localObject5;
              break;
            }
            i = 1;
            localObject1 = localObject5;
            break;
          }
        }
        if (i == 2)
        {
          Object localObject3;
          label572:
          label586:
          Object localObject6;
          float f;
          label671:
          int m;
          if (paramXmlPullParser.getName().equals("propertyValuesHolder"))
          {
            TypedArray localTypedArray = o.a(paramResources, paramTheme, localAttributeSet, a.h);
            String str = o.c(localTypedArray, paramXmlPullParser, "propertyName", 3);
            int i1 = o.a(localTypedArray, paramXmlPullParser, "valueType", 2, 4);
            localObject3 = null;
            i = i1;
            j = paramXmlPullParser.next();
            if (j == 3) {
              if (localObject3 != null)
              {
                j = ((ArrayList)localObject3).size();
                if (j > 0)
                {
                  localObject2 = (Keyframe)((ArrayList)localObject3).get(0);
                  localObject6 = (Keyframe)((ArrayList)localObject3).get(j - 1);
                  f = ((Keyframe)localObject6).getFraction();
                  if (f < 1.0F) {
                    if (f >= 0.0F)
                    {
                      ((ArrayList)localObject3).add(((ArrayList)localObject3).size(), a((Keyframe)localObject6, 1.0F));
                      j += 1;
                      f = ((Keyframe)localObject2).getFraction();
                      m = j;
                      if (f != 0.0F)
                      {
                        if (f >= 0.0F)
                        {
                          ((ArrayList)localObject3).add(0, a((Keyframe)localObject2, 0.0F));
                          m = j + 1;
                        }
                      }
                      else
                      {
                        label714:
                        localObject2 = new Keyframe[m];
                        ((ArrayList)localObject3).toArray((Object[])localObject2);
                        j = 0;
                        if (j < m)
                        {
                          localObject3 = localObject2[j];
                          if (((Keyframe)localObject3).getFraction() >= 0.0F) {}
                          for (;;)
                          {
                            j += 1;
                            break;
                            if (j != 0)
                            {
                              int i3 = m - 1;
                              if (j != i3)
                              {
                                k = j + 1;
                                int n = j;
                                for (;;)
                                {
                                  if (k >= i3) {}
                                  while (localObject2[k].getFraction() >= 0.0F)
                                  {
                                    f = (localObject2[(n + 1)].getFraction() - localObject2[(j - 1)].getFraction()) / (n - j + 2);
                                    k = j;
                                    while (k <= n)
                                    {
                                      localObject2[k].setFraction(localObject2[(k - 1)].getFraction() + f);
                                      k += 1;
                                    }
                                    break;
                                  }
                                  n = k;
                                  k += 1;
                                }
                              }
                              ((Keyframe)localObject3).setFraction(1.0F);
                            }
                            else
                            {
                              ((Keyframe)localObject3).setFraction(0.0F);
                            }
                          }
                        }
                        localObject3 = PropertyValuesHolder.ofKeyframe(str, (Keyframe[])localObject2);
                        localObject2 = localObject3;
                        if (i == 3)
                        {
                          ((PropertyValuesHolder)localObject3).setEvaluator(i.a);
                          localObject2 = localObject3;
                        }
                        label948:
                        localObject3 = localObject2;
                        if (localObject2 == null) {
                          localObject3 = a(localTypedArray, i1, 0, 1, str);
                        }
                        if (localObject3 == null) {
                          label975:
                          localTypedArray.recycle();
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
            paramXmlPullParser.next();
            break;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localObject3);
            localObject1 = localObject2;
            break label975;
            ((Keyframe)localObject2).setFraction(0.0F);
            m = j;
            break label714;
            ((Keyframe)localObject6).setFraction(1.0F);
            break label671;
            break label671;
            localObject2 = null;
            break label948;
            localObject2 = null;
            break label948;
            if (j == 1) {
              break label586;
            }
            if (!paramXmlPullParser.getName().equals("keyframe")) {
              break label572;
            }
            if (i == 4)
            {
              localObject2 = o.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), a.e);
              localObject6 = o.a((TypedArray)localObject2, paramXmlPullParser, "value");
              if (localObject6 != null) {
                if (a(((TypedValue)localObject6).type))
                {
                  i = 3;
                  label1132:
                  ((TypedArray)localObject2).recycle();
                }
              }
            }
            for (;;)
            {
              localObject6 = o.a(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), a.e);
              f = o.a((TypedArray)localObject6, paramXmlPullParser, "fraction", 3, -1.0F);
              localObject2 = o.a((TypedArray)localObject6, paramXmlPullParser, "value");
              if (localObject2 == null) {}
              for (k = 0;; k = 1)
              {
                if (i != 4) {
                  j = i;
                }
                for (;;)
                {
                  if (k != 0) {
                    switch (j)
                    {
                    case 2: 
                    default: 
                      localObject2 = null;
                    }
                  }
                  for (;;)
                  {
                    j = o.b((TypedArray)localObject6, paramXmlPullParser, "interpolator", 1);
                    if (j > 0) {
                      ((Keyframe)localObject2).setInterpolator(f.a(paramContext, j));
                    }
                    ((TypedArray)localObject6).recycle();
                    if (localObject2 == null)
                    {
                      paramXmlPullParser.next();
                      break;
                    }
                    if (localObject3 == null) {
                      localObject3 = new ArrayList();
                    }
                    for (;;)
                    {
                      ((ArrayList)localObject3).add(localObject2);
                      break;
                    }
                    localObject2 = Keyframe.ofFloat(f, o.a((TypedArray)localObject6, paramXmlPullParser, "value", 0, 0.0F));
                    continue;
                    localObject2 = Keyframe.ofInt(f, o.a((TypedArray)localObject6, paramXmlPullParser, "value", 0, 0));
                    continue;
                    if (j != 0) {
                      localObject2 = Keyframe.ofInt(f);
                    } else {
                      localObject2 = Keyframe.ofFloat(f);
                    }
                  }
                  if (k != 0)
                  {
                    if (a(((TypedValue)localObject2).type)) {
                      j = 3;
                    } else {
                      j = 0;
                    }
                  }
                  else {
                    j = 0;
                  }
                }
              }
              i = 0;
              break label1132;
              i = 0;
              break label1132;
            }
          }
        }
        paramXmlPullParser.next();
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("Unknown animator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
  }
  
  private static Keyframe a(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      return Keyframe.ofFloat(paramFloat);
    }
    if (paramKeyframe.getType() == Integer.TYPE) {
      return Keyframe.ofInt(paramFloat);
    }
    return Keyframe.ofObject(paramFloat);
  }
  
  private static PropertyValuesHolder a(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject2 = paramTypedArray.peekValue(paramInt2);
    if (localObject2 != null) {}
    for (int j = ((TypedValue)localObject2).type;; j = 0)
    {
      Object localObject3 = paramTypedArray.peekValue(paramInt3);
      if (localObject3 != null) {}
      for (int i = ((TypedValue)localObject3).type;; i = 0)
      {
        if (paramInt1 != 4) {}
        for (;;)
        {
          if (paramInt1 == 2)
          {
            localObject1 = paramTypedArray.getString(paramInt2);
            paramTypedArray = paramTypedArray.getString(paramInt3);
            localObject2 = b.b((String)localObject1);
            localObject3 = b.b(paramTypedArray);
            if (localObject2 != null) {}
            while (localObject3 != null)
            {
              if (localObject2 != null)
              {
                h localh = new h();
                if (localObject3 != null)
                {
                  if (!b.a((d[])localObject2, (d[])localObject3))
                  {
                    paramString = new StringBuilder();
                    paramString.append(" Can't morph from ");
                    paramString.append((String)localObject1);
                    paramString.append(" to ");
                    paramString.append(paramTypedArray);
                    throw new InflateException(paramString.toString());
                  }
                  paramString = PropertyValuesHolder.ofObject(paramString, localh, new Object[] { localObject2, localObject3 });
                  return paramString;
                }
                return PropertyValuesHolder.ofObject(paramString, localh, new Object[] { localObject2 });
              }
              if (localObject3 == null) {
                return null;
              }
              return PropertyValuesHolder.ofObject(paramString, new h(), new Object[] { localObject3 });
            }
            return null;
          }
          if (paramInt1 == 3) {}
          for (Object localObject1 = i.a;; localObject1 = null)
          {
            if (paramInt1 != 0)
            {
              if (localObject2 == null)
              {
                if (localObject3 == null)
                {
                  paramTypedArray = null;
                  paramString = paramTypedArray;
                  if (paramTypedArray == null) {
                    break;
                  }
                  paramString = paramTypedArray;
                  if (localObject1 == null) {
                    break;
                  }
                  paramTypedArray.setEvaluator((TypeEvaluator)localObject1);
                  return paramTypedArray;
                }
                if (i == 5) {
                  paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
                }
                for (;;)
                {
                  paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
                  break;
                  if (a(i)) {
                    paramInt1 = paramTypedArray.getColor(paramInt3, 0);
                  } else {
                    paramInt1 = paramTypedArray.getInt(paramInt3, 0);
                  }
                }
              }
              if (j == 5) {
                paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
              }
              for (;;)
              {
                if (localObject3 == null)
                {
                  paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
                  break;
                }
                if (i == 5) {
                  paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
                }
                for (;;)
                {
                  paramTypedArray = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
                  break;
                  if (a(i)) {
                    paramInt2 = paramTypedArray.getColor(paramInt3, 0);
                  } else {
                    paramInt2 = paramTypedArray.getInt(paramInt3, 0);
                  }
                }
                if (a(j)) {
                  paramInt1 = paramTypedArray.getColor(paramInt2, 0);
                } else {
                  paramInt1 = paramTypedArray.getInt(paramInt2, 0);
                }
              }
            }
            if (localObject2 == null)
            {
              if (i != 5) {}
              for (f1 = paramTypedArray.getFloat(paramInt3, 0.0F);; f1 = paramTypedArray.getDimension(paramInt3, 0.0F))
              {
                paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
                break;
              }
            }
            if (j != 5) {}
            for (float f1 = paramTypedArray.getFloat(paramInt2, 0.0F);; f1 = paramTypedArray.getDimension(paramInt2, 0.0F))
            {
              if (localObject3 == null)
              {
                paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
                break;
              }
              if (i != 5) {}
              for (float f2 = paramTypedArray.getFloat(paramInt3, 0.0F);; f2 = paramTypedArray.getDimension(paramInt3, 0.0F))
              {
                paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
                break;
              }
            }
          }
          if ((localObject2 != null) && (a(j))) {
            paramInt1 = 3;
          } else if (localObject3 != null)
          {
            if (!a(i)) {
              paramInt1 = 0;
            } else {
              paramInt1 = 3;
            }
          }
          else {
            paramInt1 = 0;
          }
        }
      }
    }
  }
  
  private static ValueAnimator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    TypedArray localTypedArray1 = o.a(paramResources, paramTheme, paramAttributeSet, a.c);
    TypedArray localTypedArray2 = o.a(paramResources, paramTheme, paramAttributeSet, a.g);
    if (paramValueAnimator == null) {}
    for (paramResources = new ValueAnimator();; paramResources = paramValueAnimator)
    {
      long l1 = o.a(localTypedArray1, paramXmlPullParser, "duration", 1, 300);
      long l2 = o.a(localTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
      int j = o.a(localTypedArray1, paramXmlPullParser, "valueType", 7, 4);
      if ((!o.a(paramXmlPullParser, "valueFrom")) || (!o.a(paramXmlPullParser, "valueTo")))
      {
        paramResources.setDuration(l1);
        paramResources.setStartDelay(l2);
        paramResources.setRepeatCount(o.a(localTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
        paramResources.setRepeatMode(o.a(localTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
        if (localTypedArray2 != null)
        {
          paramValueAnimator = (ObjectAnimator)paramResources;
          Object localObject = o.c(localTypedArray2, paramXmlPullParser, "pathData", 1);
          if (localObject == null) {
            break label638;
          }
          paramTheme = o.c(localTypedArray2, paramXmlPullParser, "propertyXName", 2);
          paramAttributeSet = o.c(localTypedArray2, paramXmlPullParser, "propertyYName", 3);
          if (paramTheme == null) {
            break label596;
          }
          localObject = b.a((String)localObject);
          PathMeasure localPathMeasure = new PathMeasure((Path)localObject, false);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Float.valueOf(0.0F));
          float f1 = 0.0F;
          float f2;
          do
          {
            f2 = f1 + localPathMeasure.getLength();
            localArrayList.add(Float.valueOf(f2));
            f1 = f2;
          } while (localPathMeasure.nextContour());
          localPathMeasure = new PathMeasure((Path)localObject, false);
          int m = Math.min(100, (int)(f2 / (paramFloat * 0.5F)) + 1);
          float[] arrayOfFloat1 = new float[m];
          localObject = new float[m];
          float[] arrayOfFloat2 = new float[2];
          f1 = f2 / (m - 1);
          i = 0;
          paramFloat = 0.0F;
          j = 0;
          if (j < m)
          {
            localPathMeasure.getPosTan(paramFloat - ((Float)localArrayList.get(i)).floatValue(), arrayOfFloat2, null);
            arrayOfFloat1[j] = arrayOfFloat2[0];
            localObject[j] = arrayOfFloat2[1];
            paramFloat += f1;
            int k = i + 1;
            if (k < localArrayList.size()) {
              if (paramFloat > ((Float)localArrayList.get(k)).floatValue())
              {
                localPathMeasure.nextContour();
                i = k;
              }
            }
            for (;;)
            {
              j += 1;
              break;
            }
          }
          if (paramTheme == null) {
            break label591;
          }
          paramTheme = PropertyValuesHolder.ofFloat(paramTheme, arrayOfFloat1);
          label474:
          if (paramAttributeSet == null) {
            break label586;
          }
          paramAttributeSet = PropertyValuesHolder.ofFloat(paramAttributeSet, (float[])localObject);
          label485:
          if (paramTheme != null) {
            break label546;
          }
          paramValueAnimator.setValues(new PropertyValuesHolder[] { paramAttributeSet });
        }
        for (;;)
        {
          i = o.b(localTypedArray1, paramXmlPullParser, "interpolator", 0);
          if (i > 0) {
            paramResources.setInterpolator(f.a(paramContext, i));
          }
          localTypedArray1.recycle();
          if (localTypedArray2 != null) {
            localTypedArray2.recycle();
          }
          return paramResources;
          label546:
          if (paramAttributeSet != null)
          {
            paramValueAnimator.setValues(new PropertyValuesHolder[] { paramTheme, paramAttributeSet });
          }
          else
          {
            paramValueAnimator.setValues(new PropertyValuesHolder[] { paramTheme });
            continue;
            label586:
            paramAttributeSet = null;
            break label485;
            label591:
            paramTheme = null;
            break label474;
            label596:
            if (paramAttributeSet != null) {
              break;
            }
            paramContext = new StringBuilder();
            paramContext.append(localTypedArray2.getPositionDescription());
            paramContext.append(" propertyXName or propertyYName is needed for PathData");
            throw new InflateException(paramContext.toString());
            label638:
            paramValueAnimator.setPropertyName(o.c(localTypedArray2, paramXmlPullParser, "propertyName", 0));
          }
        }
      }
      int i = j;
      if (j == 4)
      {
        paramTheme = localTypedArray1.peekValue(5);
        if (paramTheme == null) {
          break label785;
        }
      }
      label785:
      for (i = paramTheme.type;; i = 0)
      {
        paramAttributeSet = localTypedArray1.peekValue(6);
        if (paramAttributeSet != null) {}
        for (j = paramAttributeSet.type;; j = 0)
        {
          if ((paramTheme != null) && (a(i))) {
            i = 3;
          }
          for (;;)
          {
            paramTheme = a(localTypedArray1, i, 5, 6, "");
            if (paramTheme == null) {
              break;
            }
            paramResources.setValues(new PropertyValuesHolder[] { paramTheme });
            break;
            if (paramAttributeSet != null)
            {
              if (!a(j)) {
                i = 0;
              } else {
                i = 3;
              }
            }
            else {
              i = 0;
            }
          }
        }
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt >= 28) && (paramInt <= 31);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/d/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */