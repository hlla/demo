package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class h
  extends BaseAdapter
  implements f
{
  private final Context context;
  private final SharedPreferences hgn;
  private Preference.a voE;
  private final j vpO;
  private final LinkedList<String> vpP;
  private final HashMap<String, Preference> vpQ;
  private final HashSet<String> vpR;
  private final LinkedList<String> vpS;
  private final HashMap<String, Integer> vpT;
  private final HashMap<String, String> vpU;
  private int[] vpV;
  private boolean vpW;
  private boolean vpX;
  
  public h(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    GMTrace.i(3229546971136L, 24062);
    this.vpP = new LinkedList();
    this.vpQ = new HashMap();
    this.vpR = new HashSet();
    this.vpS = new LinkedList();
    this.vpT = new HashMap();
    this.vpU = new HashMap();
    this.vpV = new int[0];
    this.vpW = false;
    this.vpX = false;
    this.vpO = new j(paramContext);
    this.context = paramContext;
    this.hgn = paramSharedPreferences;
    GMTrace.o(3229546971136L, 24062);
  }
  
  private static boolean Aw(int paramInt)
  {
    GMTrace.i(3231694454784L, 24078);
    if ((paramInt == a.h.dis) || (paramInt == a.h.hep) || (paramInt == a.h.her))
    {
      GMTrace.o(3231694454784L, 24078);
      return true;
    }
    GMTrace.o(3231694454784L, 24078);
    return false;
  }
  
  private static void a(Preference paramPreference, SharedPreferences paramSharedPreferences)
  {
    GMTrace.i(3231962890240L, 24080);
    Object localObject;
    if ((paramPreference instanceof CheckBoxPreference))
    {
      localObject = (CheckBoxPreference)paramPreference;
      if (((Preference)localObject).vqk) {
        ((CheckBoxPreference)localObject).vox = paramSharedPreferences.getBoolean(paramPreference.igr, ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
    if ((paramPreference instanceof DialogPreference))
    {
      localObject = (DialogPreference)paramPreference;
      if (((Preference)localObject).vqk) {
        ((DialogPreference)localObject).setValue(paramSharedPreferences.getString(paramPreference.igr, null));
      }
    }
    if ((paramPreference instanceof EditPreference))
    {
      localObject = (EditPreference)paramPreference;
      if (((Preference)localObject).vqk)
      {
        ((EditPreference)localObject).value = paramSharedPreferences.getString(paramPreference.igr, null);
        ((EditPreference)localObject).setSummary(((EditPreference)localObject).value);
      }
    }
    GMTrace.o(3231962890240L, 24080);
  }
  
  private void b(Preference paramPreference, int paramInt)
  {
    GMTrace.i(3230486495232L, 24069);
    String str = e(paramPreference);
    this.vpQ.put(str, paramPreference);
    LinkedList localLinkedList = this.vpP;
    int i = paramInt;
    if (paramInt == -1) {
      i = this.vpP.size();
    }
    localLinkedList.add(i, str);
    if ((!this.vpT.containsKey(d(paramPreference))) && (!this.vpX)) {
      this.vpT.put(d(paramPreference), Integer.valueOf(this.vpT.size()));
    }
    if (paramPreference.vql != null) {
      this.vpU.put(paramPreference.vql + "|" + paramPreference.igr, paramPreference.igr);
    }
    GMTrace.o(3230486495232L, 24069);
  }
  
  private void bSO()
  {
    GMTrace.i(3231560237056L, 24077);
    HashSet localHashSet = new HashSet();
    int i = 0;
    if (i < this.vpS.size())
    {
      Preference localPreference1 = (Preference)this.vpQ.get(this.vpS.get(i));
      if (((localPreference1 instanceof PreferenceCategory)) && (bf.mA(localPreference1.igr)) && (i != 0))
      {
        Preference localPreference2 = (Preference)this.vpQ.get(this.vpS.get(i - 1));
        if ((localPreference2 instanceof PreferenceCategory))
        {
          if ((!bf.mA(localPreference2.igr)) || ((localPreference2.getTitle() != null) && (localPreference2.getTitle().toString().trim().length() > 0))) {
            break label157;
          }
          localHashSet.add(e(localPreference2));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label157:
        if ((bf.mA(localPreference1.igr)) && ((localPreference1.getTitle() == null) || (localPreference1.getTitle().toString().trim().length() <= 0))) {
          localHashSet.add(e(localPreference1));
        }
      }
    }
    this.vpS.removeAll(localHashSet);
    GMTrace.o(3231560237056L, 24077);
  }
  
  private static String d(Preference paramPreference)
  {
    GMTrace.i(3229681188864L, 24063);
    paramPreference = paramPreference.getClass().getName() + "L" + paramPreference.getLayoutResource() + "W" + paramPreference.vqq;
    GMTrace.o(3229681188864L, 24063);
    return paramPreference;
  }
  
  private static String e(Preference paramPreference)
  {
    GMTrace.i(3229815406592L, 24064);
    if ((paramPreference.igr != null) && (paramPreference.igr.length() > 0))
    {
      paramPreference = paramPreference.igr;
      GMTrace.o(3229815406592L, 24064);
      return paramPreference;
    }
    paramPreference = "_anonymous_pref@" + paramPreference.hashCode();
    GMTrace.o(3229815406592L, 24064);
    return paramPreference;
  }
  
  public final Preference Tc(String paramString)
  {
    GMTrace.i(3230620712960L, 24070);
    paramString = (Preference)this.vpQ.get(paramString);
    GMTrace.o(3230620712960L, 24070);
    return paramString;
  }
  
  public final boolean Td(String paramString)
  {
    GMTrace.i(3231023366144L, 24073);
    boolean bool = c(Tc(paramString));
    GMTrace.o(3231023366144L, 24073);
    return bool;
  }
  
  public final int Te(String paramString)
  {
    GMTrace.i(3230083842048L, 24066);
    if (this.vpS == null)
    {
      GMTrace.o(3230083842048L, 24066);
      return -1;
    }
    int i = this.vpS.indexOf(paramString);
    GMTrace.o(3230083842048L, 24066);
    return i;
  }
  
  public final void a(Preference paramPreference)
  {
    GMTrace.i(3230218059776L, 24067);
    a(paramPreference, -1);
    GMTrace.o(3230218059776L, 24067);
  }
  
  public final void a(Preference paramPreference, int paramInt)
  {
    GMTrace.i(3230352277504L, 24068);
    b(paramPreference, paramInt);
    if (!this.vpW) {
      notifyDataSetChanged();
    }
    GMTrace.o(3230352277504L, 24068);
  }
  
  public final void aV(String paramString, boolean paramBoolean)
  {
    GMTrace.i(3230754930688L, 24071);
    if (paramBoolean) {
      if (!this.vpR.contains(paramString)) {
        this.vpR.add(paramString);
      }
    }
    while (this.vpR.remove(paramString))
    {
      notifyDataSetChanged();
      GMTrace.o(3230754930688L, 24071);
      return;
      GMTrace.o(3230754930688L, 24071);
      return;
    }
    GMTrace.o(3230754930688L, 24071);
  }
  
  /* Error */
  public final void addPreferencesFromResource(int paramInt)
  {
    // Byte code:
    //   0: ldc2_w 330
    //   3: sipush 24075
    //   6: invokestatic 46	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 71	com/tencent/mm/ui/base/preference/h:vpW	Z
    //   14: aload_0
    //   15: getfield 80	com/tencent/mm/ui/base/preference/h:vpO	Lcom/tencent/mm/ui/base/preference/j;
    //   18: astore 4
    //   20: aload 4
    //   22: getfield 334	com/tencent/mm/ui/base/preference/j:mContext	Landroid/content/Context;
    //   25: invokevirtual 340	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   28: iload_1
    //   29: invokevirtual 346	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   32: astore_2
    //   33: aload 4
    //   35: getfield 350	com/tencent/mm/ui/base/preference/j:HD	[Ljava/lang/Object;
    //   38: astore_3
    //   39: aload_3
    //   40: monitorenter
    //   41: aload_2
    //   42: invokestatic 356	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   45: astore 5
    //   47: aload 4
    //   49: getfield 350	com/tencent/mm/ui/base/preference/j:HD	[Ljava/lang/Object;
    //   52: iconst_0
    //   53: aload 4
    //   55: getfield 334	com/tencent/mm/ui/base/preference/j:mContext	Landroid/content/Context;
    //   58: aastore
    //   59: aload_2
    //   60: invokeinterface 361 1 0
    //   65: istore_1
    //   66: iload_1
    //   67: iconst_2
    //   68: if_icmpeq +18 -> 86
    //   71: iload_1
    //   72: iconst_1
    //   73: if_icmpeq +13 -> 86
    //   76: aload_2
    //   77: invokeinterface 361 1 0
    //   82: istore_1
    //   83: goto -17 -> 66
    //   86: iload_1
    //   87: iconst_2
    //   88: if_icmpeq +57 -> 145
    //   91: new 325	android/view/InflateException
    //   94: dup
    //   95: new 190	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   102: aload_2
    //   103: invokeinterface 364 1 0
    //   108: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 366
    //   114: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 367	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   123: athrow
    //   124: astore 4
    //   126: aload 4
    //   128: athrow
    //   129: astore 4
    //   131: aload_3
    //   132: monitorexit
    //   133: aload 4
    //   135: athrow
    //   136: astore_3
    //   137: aload_2
    //   138: invokeinterface 372 1 0
    //   143: aload_3
    //   144: athrow
    //   145: aload 4
    //   147: aload_2
    //   148: invokeinterface 373 1 0
    //   153: aload 5
    //   155: invokevirtual 376	com/tencent/mm/ui/base/preference/j:a	(Ljava/lang/String;Landroid/util/AttributeSet;)Lcom/tencent/mm/ui/base/preference/Preference;
    //   158: pop
    //   159: aload 4
    //   161: aload_2
    //   162: aload_0
    //   163: aload 5
    //   165: invokevirtual 379	com/tencent/mm/ui/base/preference/j:a	(Lorg/xmlpull/v1/XmlPullParser;Lcom/tencent/mm/ui/base/preference/f;Landroid/util/AttributeSet;)V
    //   168: aload_3
    //   169: monitorexit
    //   170: aload_2
    //   171: invokeinterface 372 1 0
    //   176: aload_0
    //   177: iconst_0
    //   178: putfield 71	com/tencent/mm/ui/base/preference/h:vpW	Z
    //   181: aload_0
    //   182: invokevirtual 310	com/tencent/mm/ui/base/preference/h:notifyDataSetChanged	()V
    //   185: ldc2_w 330
    //   188: sipush 24075
    //   191: invokestatic 87	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   194: return
    //   195: astore 4
    //   197: new 325	android/view/InflateException
    //   200: dup
    //   201: aload 4
    //   203: invokevirtual 382	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   206: invokespecial 367	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   209: astore 5
    //   211: aload 5
    //   213: aload 4
    //   215: invokevirtual 386	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   218: pop
    //   219: aload 5
    //   221: athrow
    //   222: astore 4
    //   224: new 325	android/view/InflateException
    //   227: dup
    //   228: new 190	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   235: aload_2
    //   236: invokeinterface 364 1 0
    //   241: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 388
    //   247: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 4
    //   252: invokevirtual 389	java/io/IOException:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokespecial 367	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   264: astore 5
    //   266: aload 5
    //   268: aload 4
    //   270: invokevirtual 386	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   273: pop
    //   274: aload 5
    //   276: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	h
    //   0	277	1	paramInt	int
    //   32	204	2	localXmlResourceParser	android.content.res.XmlResourceParser
    //   136	33	3	localObject1	Object
    //   18	36	4	localj	j
    //   124	3	4	localInflateException	android.view.InflateException
    //   129	31	4	localObject2	Object
    //   195	19	4	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   222	47	4	localIOException	java.io.IOException
    //   45	230	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   59	66	124	android/view/InflateException
    //   76	83	124	android/view/InflateException
    //   91	124	124	android/view/InflateException
    //   145	168	124	android/view/InflateException
    //   41	59	129	finally
    //   59	66	129	finally
    //   76	83	129	finally
    //   91	124	129	finally
    //   126	129	129	finally
    //   131	133	129	finally
    //   145	168	129	finally
    //   168	170	129	finally
    //   197	222	129	finally
    //   224	277	129	finally
    //   33	41	136	finally
    //   133	136	136	finally
    //   59	66	195	org/xmlpull/v1/XmlPullParserException
    //   76	83	195	org/xmlpull/v1/XmlPullParserException
    //   91	124	195	org/xmlpull/v1/XmlPullParserException
    //   145	168	195	org/xmlpull/v1/XmlPullParserException
    //   59	66	222	java/io/IOException
    //   76	83	222	java/io/IOException
    //   91	124	222	java/io/IOException
    //   145	168	222	java/io/IOException
  }
  
  public final void b(Preference.a parama)
  {
    GMTrace.i(3231426019328L, 24076);
    this.voE = parama;
    notifyDataSetChanged();
    GMTrace.o(3231426019328L, 24076);
  }
  
  public final void b(Preference paramPreference)
  {
    GMTrace.i(17513668673536L, 130487);
    b(paramPreference, -1);
    GMTrace.o(17513668673536L, 130487);
  }
  
  public final boolean c(Preference paramPreference)
  {
    GMTrace.i(3230889148416L, 24072);
    if (paramPreference == null)
    {
      GMTrace.o(3230889148416L, 24072);
      return false;
    }
    String str = e(paramPreference);
    this.vpP.remove(str);
    this.vpQ.remove(str);
    this.vpR.remove(paramPreference.igr);
    notifyDataSetChanged();
    GMTrace.o(3230889148416L, 24072);
    return true;
  }
  
  public int getCount()
  {
    GMTrace.i(3232097107968L, 24081);
    int i = this.vpS.size();
    GMTrace.o(3232097107968L, 24081);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    GMTrace.i(3232231325696L, 24082);
    Object localObject = this.vpQ.get(this.vpS.get(paramInt));
    GMTrace.o(3232231325696L, 24082);
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    GMTrace.i(3232365543424L, 24083);
    GMTrace.o(3232365543424L, 24083);
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    GMTrace.i(3232633978880L, 24085);
    if (paramInt > this.vpS.size())
    {
      GMTrace.o(3232633978880L, 24085);
      return -1;
    }
    Object localObject = (Preference)this.vpQ.get(this.vpS.get(paramInt));
    localObject = (Integer)this.vpT.get(d((Preference)localObject));
    if (localObject == null)
    {
      GMTrace.o(3232633978880L, 24085);
      return -1;
    }
    paramInt = ((Integer)localObject).intValue();
    GMTrace.o(3232633978880L, 24085);
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3232768196608L, 24086);
    if (paramInt > this.vpS.size())
    {
      GMTrace.o(3232768196608L, 24086);
      return paramView;
    }
    Object localObject = (Preference)this.vpQ.get(this.vpS.get(paramInt));
    if ((localObject instanceof CheckBoxPreference)) {
      ((Preference)localObject).a(this.voE);
    }
    if (!this.vpT.containsKey(d((Preference)localObject))) {
      paramView = null;
    }
    paramView = ((Preference)localObject).getView(paramView, paramViewGroup);
    int i7 = this.vpV[paramInt];
    paramViewGroup = paramView.findViewById(a.g.content);
    if (paramViewGroup == null)
    {
      v.d("MicroMsg.MMPreferenceAdapter", "find content view error");
      GMTrace.o(3232768196608L, 24086);
      return paramView;
    }
    localObject = paramView.findViewById(16908312);
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int j;
    int i3;
    int i4;
    int i5;
    int i6;
    int i;
    if ((i7 & 0x4) == 0)
    {
      k = 0;
      m = paramViewGroup.getPaddingLeft();
      n = paramViewGroup.getPaddingRight();
      i1 = paramViewGroup.getPaddingTop();
      i2 = paramViewGroup.getPaddingBottom();
      j = a.f.hbH;
      i3 = paramView.getPaddingLeft();
      i4 = paramView.getPaddingRight();
      i5 = paramView.getPaddingTop();
      i6 = paramView.getPaddingBottom();
      if ((i7 & 0x8) == 0) {
        break label345;
      }
      if ((paramInt != this.vpS.size() - 1) && ((paramInt != this.vpS.size() - 2) || (!(getItem(this.vpS.size() - 1) instanceof PreferenceCategory)))) {
        break label324;
      }
      paramInt = a.f.bhb;
      i = a.d.white;
    }
    for (;;)
    {
      paramViewGroup.setBackgroundResource(paramInt);
      paramViewGroup.setPadding(m, i1, n, i2);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(paramInt);
      }
      paramView.setBackgroundResource(i);
      paramView.setPadding(i3, i5, i4, i6);
      GMTrace.o(3232768196608L, 24086);
      return paramView;
      label324:
      if ((i7 & 0x2) != 0)
      {
        paramInt = a.f.bhb;
        break;
      }
      paramInt = a.f.bgg;
      break;
      label345:
      if ((i7 & 0x10) == 0)
      {
        i = j;
        paramInt = k;
        if ((i7 & 0x2) != 0) {}
      }
      else
      {
        paramInt = a.f.bgg;
        i = j;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    GMTrace.i(3232499761152L, 24084);
    if (!this.vpX) {
      this.vpX = true;
    }
    int i = Math.max(1, this.vpT.size());
    GMTrace.o(3232499761152L, 24084);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    GMTrace.i(3229949624320L, 24065);
    int i = this.vpP.indexOf(paramString);
    GMTrace.o(3229949624320L, 24065);
    return i;
  }
  
  public void notifyDataSetChanged()
  {
    int i = 0;
    GMTrace.i(3231828672512L, 24079);
    this.vpS.clear();
    Object localObject = this.vpP.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!this.vpR.contains(str)) {
        if (this.vpQ.get(str) == null) {
          v.e("MicroMsg.MMPreferenceAdapter", "not found pref by key " + str);
        } else {
          this.vpS.add(str);
        }
      }
    }
    if ((!this.vpS.isEmpty()) && (Aw(((Preference)this.vpQ.get(this.vpS.get(0))).getLayoutResource()))) {
      b(new PreferenceSmallCategory(this.context), 0);
    }
    bSO();
    this.vpV = new int[this.vpS.size()];
    if (this.vpV.length <= 0)
    {
      GMTrace.o(3231828672512L, 24079);
      return;
    }
    if (this.vpV.length == 1)
    {
      i = ((Preference)this.vpQ.get(this.vpS.get(0))).getLayoutResource();
      localObject = (Preference)this.vpQ.get(this.vpS.get(0));
      if (Aw(i)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.vpV;
          localObject[0] |= 0x8;
        }
      }
      for (;;)
      {
        a((Preference)this.vpQ.get(this.vpS.get(0)), this.hgn);
        super.notifyDataSetChanged();
        GMTrace.o(3231828672512L, 24079);
        return;
        this.vpV[0] = 3;
        continue;
        this.vpV[0] = 4;
      }
    }
    if (i < this.vpS.size())
    {
      a((Preference)this.vpQ.get(this.vpS.get(i)), this.hgn);
      localObject = (Preference)this.vpQ.get(this.vpS.get(i));
      int j = ((Preference)localObject).getLayoutResource();
      if (Aw(j)) {
        if ((localObject instanceof CheckBoxPreference))
        {
          localObject = this.vpV;
          localObject[i] |= 0x8;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (i == 0)
        {
          localObject = this.vpV;
          localObject[i] |= 0x1;
        }
        else
        {
          if (i == this.vpS.size() - 1)
          {
            localObject = this.vpV;
            localObject[i] |= 0x2;
          }
          j = ((Preference)this.vpQ.get(this.vpS.get(i - 1))).getLayoutResource();
          if ((j != a.h.dis) || (j == a.h.hep) || (j == a.h.her))
          {
            localObject = this.vpV;
            localObject[i] |= 0x1;
            continue;
            if (j == a.h.diV)
            {
              if (i == 0)
              {
                localObject = this.vpV;
                localObject[i] |= 0x4;
              }
              else
              {
                localObject = this.vpV;
                localObject[i] |= 0x10;
                j = ((Preference)this.vpQ.get(this.vpS.get(i - 1))).getLayoutResource();
                if ((j == a.h.dis) || (j == a.h.hep) || (j == a.h.her))
                {
                  localObject = this.vpV;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
            else
            {
              localObject = this.vpV;
              localObject[i] |= 0x4;
              if (i != 0)
              {
                j = ((Preference)this.vpQ.get(this.vpS.get(i - 1))).getLayoutResource();
                if ((Aw(j)) || (j == a.h.diV))
                {
                  localObject = this.vpV;
                  j = i - 1;
                  localObject[j] |= 0x2;
                }
              }
            }
          }
        }
      }
    }
    super.notifyDataSetChanged();
    GMTrace.o(3231828672512L, 24079);
  }
  
  public final void removeAll()
  {
    GMTrace.i(3231157583872L, 24074);
    this.vpS.clear();
    this.vpQ.clear();
    this.vpP.clear();
    this.vpR.clear();
    notifyDataSetChanged();
    GMTrace.o(3231157583872L, 24074);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */