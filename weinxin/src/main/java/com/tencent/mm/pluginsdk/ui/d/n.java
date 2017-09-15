package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class n
{
  private static final f<String, SpannableString> sSt;
  String iCm;
  private TextView kH;
  private Context mContext;
  boolean sSA;
  boolean sSB;
  boolean sSC;
  boolean sSD;
  boolean sSE;
  boolean sSF;
  boolean sSG;
  boolean sSH;
  int sSI;
  private int sSJ;
  boolean sSK;
  Object sSL;
  private ArrayList<i> sSu;
  private ArrayList<a> sSv;
  private ArrayList<com.tencent.mm.pluginsdk.ui.applet.l> sSw;
  boolean sSx;
  boolean sSy;
  boolean sSz;
  
  static
  {
    GMTrace.i(1217489010688L, 9071);
    sSt = new f(500);
    GMTrace.o(1217489010688L, 9071);
  }
  
  public n(Context paramContext)
  {
    GMTrace.i(1215207309312L, 9054);
    this.sSu = new ArrayList();
    this.sSv = new ArrayList();
    this.sSw = new ArrayList();
    this.kH = null;
    this.sSx = false;
    this.sSy = false;
    this.sSz = false;
    this.sSA = true;
    this.sSB = true;
    this.sSC = false;
    this.sSD = false;
    this.sSE = false;
    this.sSF = false;
    this.sSG = false;
    this.sSH = true;
    this.sSI = 0;
    this.sSJ = 0;
    this.mContext = null;
    this.sSK = false;
    this.sSu = new ArrayList();
    this.sSv = new ArrayList();
    this.sSw = new ArrayList();
    this.mContext = paramContext;
    GMTrace.o(1215207309312L, 9054);
  }
  
  private CharSequence A(CharSequence paramCharSequence)
  {
    GMTrace.i(1215878397952L, 9059);
    Object localObject2 = g.a.sRF.matcher(paramCharSequence);
    Object localObject1 = paramCharSequence;
    int i = 0;
    String str1;
    String str2;
    int j;
    for (;;)
    {
      if (((Matcher)localObject2).find())
      {
        String str3 = ((Matcher)localObject2).group(0);
        localObject3 = ((Matcher)localObject2).group(1);
        str1 = ((Matcher)localObject2).group(2);
        str2 = ((Matcher)localObject2).group(3);
        if (str1.length() < 2) {
          continue;
        }
        localObject1 = ((CharSequence)localObject1).toString().replace(str3, str2);
        j = ((Matcher)localObject2).start(0);
        int k = str2.length() + j;
        if ((j < 0) || (k > paramCharSequence.length()))
        {
          v.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(paramCharSequence.length()) });
          continue;
        }
        try
        {
          i = Color.parseColor((String)localObject3);
          localObject2 = a.a(this.mContext, str1, j, k, i, i & 0x99FFFFFF);
          if (localObject2 != null)
          {
            if (this.sSL != null) {
              ((i)localObject2).data = this.sSL;
            }
            this.sSu.add(localObject2);
            this.sSv.add(new a(j, k));
          }
          localObject2 = g.a.sRF.matcher((CharSequence)localObject1);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            v.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s]", new Object[] { localObject3 });
            i = 0;
          }
        }
      }
    }
    Object localObject3 = localObject1;
    if (i == 0)
    {
      Matcher localMatcher = g.a.sRG.matcher(paramCharSequence);
      for (;;)
      {
        localObject3 = localObject1;
        if (!localMatcher.find()) {
          break;
        }
        str2 = localMatcher.group(0);
        localObject3 = localMatcher.group(1);
        str1 = localMatcher.group(2);
        if (((String)localObject3).length() >= 2)
        {
          localObject1 = ((CharSequence)localObject1).toString().replace(str2, str1);
          i = localMatcher.start(0);
          j = str1.length() + i;
          if ((i < 0) || (j > paramCharSequence.length()))
          {
            v.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
          }
          else
          {
            M((String)localObject3, i, j);
            localMatcher = g.a.sRF.matcher((CharSequence)localObject1);
          }
        }
      }
    }
    GMTrace.o(1215878397952L, 9059);
    return (CharSequence)localObject3;
  }
  
  private CharSequence B(CharSequence paramCharSequence)
  {
    GMTrace.i(1216012615680L, 9060);
    Matcher localMatcher = g.a.sRE.matcher(paramCharSequence.toString());
    Object localObject = paramCharSequence;
    while (localMatcher.find())
    {
      String str3 = localMatcher.group(0);
      String str1 = localMatcher.group(1);
      String str2 = localMatcher.group(2);
      if (str1.length() >= 2)
      {
        localObject = ((CharSequence)localObject).toString().replace(str3, str2);
        int i = localMatcher.start(0);
        int j = str2.length() + i;
        if ((i < 0) || (j > paramCharSequence.length()))
        {
          v.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramCharSequence.length()) });
        }
        else
        {
          M(str1, i, j);
          localMatcher = g.a.sRE.matcher((CharSequence)localObject);
        }
      }
    }
    GMTrace.o(1216012615680L, 9060);
    return (CharSequence)localObject;
  }
  
  private ArrayList<a> C(CharSequence paramCharSequence)
  {
    int i = 2000;
    GMTrace.i(1216146833408L, 9061);
    ArrayList localArrayList = new ArrayList();
    Object localObject = g.a.sRL;
    if (paramCharSequence.length() > 2000) {}
    for (;;)
    {
      paramCharSequence = ((Pattern)localObject).matcher(paramCharSequence.subSequence(0, i));
      while (paramCharSequence.find())
      {
        i = paramCharSequence.start();
        int j = paramCharSequence.end();
        localObject = new i(paramCharSequence.group(), 24, null);
        ((i)localObject).start = i;
        ((i)localObject).end = j;
        if (!a(this.sSv, new a(i, j)))
        {
          this.sSu.add(localObject);
          localArrayList.add(new a(i, j));
        }
      }
      i = paramCharSequence.length();
    }
    GMTrace.o(1216146833408L, 9061);
    return localArrayList;
  }
  
  private ArrayList<a> D(CharSequence paramCharSequence)
  {
    GMTrace.i(1216281051136L, 9062);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    if (str.length() > 500) {
      paramCharSequence = g.a.sRK.matcher(str.toLowerCase());
    }
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.sSv, new a(i, j))) && (i >= 0) && (j <= str.length())) {
        if (j < str.length())
        {
          int k = str.charAt(j);
          if ((97 <= k) && (k <= 122)) {}
        }
        else
        {
          i locali = new i(str.substring(i, j), 1, this.sSL);
          locali.start = i;
          locali.end = j;
          this.sSu.add(locali);
          localArrayList.add(new a(i, j));
          continue;
          paramCharSequence = g.a.sRJ.matcher(str.toLowerCase());
        }
      }
    }
    GMTrace.o(1216281051136L, 9062);
    return localArrayList;
  }
  
  private ArrayList<a> E(CharSequence paramCharSequence)
  {
    GMTrace.i(18727668023296L, 139532);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.length() > 200)
    {
      GMTrace.o(18727668023296L, 139532);
      return localArrayList;
    }
    Matcher localMatcher = g.a.sRQ.matcher(paramCharSequence);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      if ((!a(this.sSv, new a(i, j))) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        i locali = new i(paramCharSequence.substring(i, j), 44, this.sSL);
        locali.start = i;
        locali.end = j;
        this.sSu.add(locali);
        localArrayList.add(new a(i, j));
        g.oSF.a(653L, 0L, 1L, false);
      }
    }
    GMTrace.o(18727668023296L, 139532);
    return localArrayList;
  }
  
  private ArrayList<a> F(CharSequence paramCharSequence)
  {
    GMTrace.i(1216415268864L, 9063);
    ArrayList localArrayList = new ArrayList();
    String str = paramCharSequence.toString();
    paramCharSequence = g.a.sRN.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int i = paramCharSequence.start();
      int j = paramCharSequence.end();
      if ((!a(this.sSv, new a(i, j))) && (i >= 0) && (j <= str.length()))
      {
        i locali = new i(str.substring(i, j), 28, null);
        locali.start = i;
        locali.end = j;
        this.sSu.add(locali);
        localArrayList.add(new a(i, j));
      }
    }
    GMTrace.o(1216415268864L, 9063);
    return localArrayList;
  }
  
  private ArrayList<a> G(CharSequence paramCharSequence)
  {
    GMTrace.i(1216549486592L, 9064);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = g.a.sRM.matcher(paramCharSequence);
    while (paramCharSequence.find())
    {
      int k = paramCharSequence.start();
      int m = paramCharSequence.end();
      Object localObject = paramCharSequence.group();
      int j = m - k;
      int i = j;
      if (((String)localObject).startsWith("+")) {
        i = j - 1;
      }
      if (((i != 6) && (i != 5)) || (("+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567".contains((CharSequence)localObject)) && (!a(this.sSv, new a(k, m)))))
      {
        localObject = new i((String)localObject, 25, this.sSL);
        ((i)localObject).start = k;
        ((i)localObject).end = m;
        this.sSu.add(localObject);
        localArrayList.add(new a(k, m));
      }
    }
    GMTrace.o(1216549486592L, 9064);
    return localArrayList;
  }
  
  private ArrayList<a> H(CharSequence paramCharSequence)
  {
    GMTrace.i(1216683704320L, 9065);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = a.aU(this.mContext, paramCharSequence.toString()).iterator();
    while (paramCharSequence.hasNext())
    {
      i locali = (i)paramCharSequence.next();
      a locala = new a(locali.start, locali.end);
      if (!a(this.sSv, locala))
      {
        this.sSu.add(locali);
        localArrayList.add(locala);
      }
    }
    GMTrace.o(1216683704320L, 9065);
    return localArrayList;
  }
  
  private ArrayList<a> I(CharSequence paramCharSequence)
  {
    GMTrace.i(1216817922048L, 9066);
    ArrayList localArrayList = new ArrayList();
    paramCharSequence = paramCharSequence.toString();
    Matcher localMatcher = g.a.sRP.matcher(paramCharSequence);
    int i;
    int j;
    a locala;
    i locali;
    while (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      locala = new a(i, j);
      if ((!a(this.sSv, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
      {
        locali = new i(paramCharSequence.substring(i, j), 30, null);
        locali.start = i;
        locali.end = j;
        this.sSu.add(locali);
        localArrayList.add(locala);
      }
    }
    if (localArrayList.size() <= 0)
    {
      localMatcher = g.a.sRO.matcher(paramCharSequence);
      while (localMatcher.find())
      {
        i = localMatcher.start();
        j = localMatcher.end();
        locala = new a(i, j);
        if ((!a(this.sSv, locala)) && (i >= 0) && (j <= paramCharSequence.length()))
        {
          locali = new i(paramCharSequence.substring(i, j), 30, null);
          locali.start = i;
          locali.end = j;
          this.sSu.add(locali);
          localArrayList.add(locala);
        }
      }
    }
    GMTrace.o(1216817922048L, 9066);
    return localArrayList;
  }
  
  private boolean M(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(17439446269952L, 129934);
    paramString = a.a(this.mContext, paramString, paramInt1, paramInt2);
    if (paramString != null)
    {
      if (this.sSL != null) {
        paramString.data = this.sSL;
      }
      this.sSu.add(paramString);
      this.sSv.add(new a(paramInt1, paramInt2));
      GMTrace.o(17439446269952L, 129934);
      return true;
    }
    GMTrace.o(17439446269952L, 129934);
    return false;
  }
  
  private static boolean a(ArrayList<a> paramArrayList, a parama)
  {
    GMTrace.i(1216952139776L, 9067);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      a locala = (a)paramArrayList.next();
      if ((locala.end > parama.start) && (parama.end > locala.start)) {}
      for (int i = 1; i != 0; i = 0)
      {
        GMTrace.o(1216952139776L, 9067);
        return true;
      }
    }
    GMTrace.o(1216952139776L, 9067);
    return false;
  }
  
  private void bGn()
  {
    GMTrace.i(1217220575232L, 9069);
    if (this.kH != null)
    {
      k localk = new k();
      localk.iCm = this.iCm;
      this.kH.setOnTouchListener(localk);
    }
    GMTrace.o(1217220575232L, 9069);
  }
  
  public static void clearCache()
  {
    GMTrace.i(1217354792960L, 9070);
    sSt.clear();
    GMTrace.o(1217354792960L, 9070);
  }
  
  private static void d(Spannable paramSpannable)
  {
    int i = 0;
    GMTrace.i(1215609962496L, 9057);
    Object[] arrayOfObject = paramSpannable.getSpans(0, paramSpannable.length(), Object.class);
    while (i < arrayOfObject.length)
    {
      if ((!(arrayOfObject[i] instanceof com.tencent.mm.ui.widget.d)) && (!(arrayOfObject[i] instanceof l))) {
        paramSpannable.removeSpan(arrayOfObject[i]);
      }
      i += 1;
    }
    GMTrace.o(1215609962496L, 9057);
  }
  
  private void e(Spannable paramSpannable)
  {
    GMTrace.i(1217086357504L, 9068);
    if ((this.kH != null) && (!bf.mA(paramSpannable.toString())))
    {
      if (r.ijb)
      {
        this.kH.setText(paramSpannable, TextView.BufferType.SPANNABLE);
        GMTrace.o(1217086357504L, 9068);
        return;
      }
      this.kH.setText(paramSpannable);
    }
    GMTrace.o(1217086357504L, 9068);
  }
  
  private CharSequence z(CharSequence paramCharSequence)
  {
    GMTrace.i(1215744180224L, 9058);
    Object localObject2 = g.a.sRH.matcher(paramCharSequence.toString());
    Object localObject1 = paramCharSequence;
    paramCharSequence = (CharSequence)localObject2;
    if (paramCharSequence.find())
    {
      if (this.sSF) {
        paramCharSequence = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "");
      }
      for (;;)
      {
        localObject2 = g.a.sRE.matcher(paramCharSequence);
        localObject1 = paramCharSequence;
        paramCharSequence = (CharSequence)localObject2;
        break;
        localObject1 = ((CharSequence)localObject1).toString().replace(paramCharSequence.group(0), "  ");
        localObject2 = paramCharSequence.group(1);
        int i = paramCharSequence.start();
        int j = this.mContext.getResources().getIdentifier(((String)localObject2).toLowerCase(), "drawable", this.mContext.getPackageName());
        if (j != 0)
        {
          paramCharSequence = new com.tencent.mm.pluginsdk.ui.applet.l(i, i + 2, j);
          if ((!bf.mA((String)localObject2)) && ("original_label".equals(localObject2)))
          {
            paramCharSequence.height = 15;
            paramCharSequence.width = 35;
          }
          this.sSw.add(paramCharSequence);
          paramCharSequence = (CharSequence)localObject1;
        }
        else
        {
          v.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", new Object[] { localObject2 });
          paramCharSequence = (CharSequence)localObject1;
        }
      }
    }
    GMTrace.o(1215744180224L, 9058);
    return (CharSequence)localObject1;
  }
  
  public final SpannableString a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    GMTrace.i(1215475744768L, 9056);
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableString("");
      GMTrace.o(1215475744768L, 9056);
      return paramCharSequence;
    }
    this.sSJ = paramInt;
    String str = paramCharSequence + "@" + this.sSJ + "@" + this.sSx + "@" + this.sSz + "@" + this.sSA + "@" + this.sSB + "@" + this.sSI + "@" + this.sSK + "@" + this.sSE + "@" + this.sSF + "@" + this.sSG;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = (SpannableString)sSt.get(str);
      if (localObject1 != null)
      {
        d((Spannable)localObject1);
        e((Spannable)localObject1);
        bGn();
        GMTrace.o(1215475744768L, 9056);
        return (SpannableString)localObject1;
      }
    }
    this.sSu = new ArrayList();
    if (this.sSJ <= 0)
    {
      if (this.kH != null) {
        this.sSJ = ((int)this.kH.getTextSize());
      }
    }
    else
    {
      if (this.sSu == null) {
        this.sSu = new ArrayList();
      }
      if (this.sSv == null) {
        this.sSv = new ArrayList();
      }
      this.sSu.clear();
      this.sSv.clear();
      if (paramCharSequence == null) {
        break label799;
      }
      if (p.gRb.gPP != 1) {
        break label762;
      }
      paramInt = 1;
      label338:
      localObject1 = paramCharSequence;
      if (paramInt != 0)
      {
        localObject1 = paramCharSequence;
        if (this.sSH)
        {
          localObject1 = paramCharSequence;
          if (d.a.sRD != null) {
            if (!d.a.sRD.x(paramCharSequence))
            {
              localObject1 = paramCharSequence;
              if (!d.a.sRD.y(paramCharSequence)) {}
            }
            else
            {
              localObject1 = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
            }
          }
        }
      }
      paramCharSequence = (CharSequence)localObject1;
      if (this.sSx) {
        paramCharSequence = B((CharSequence)localObject1);
      }
      localObject1 = paramCharSequence;
      if (this.sSE) {
        localObject1 = z(paramCharSequence);
      }
      paramCharSequence = (CharSequence)localObject1;
      if (this.sSG) {
        paramCharSequence = A((CharSequence)localObject1);
      }
      if ((!this.sSH) || (d.a.sRD == null)) {
        break label1068;
      }
      paramCharSequence = d.a.sRD.b(this.mContext, paramCharSequence, this.sSJ);
    }
    label762:
    label799:
    label816:
    label1068:
    for (;;)
    {
      if (this.sSA) {
        this.sSv.addAll(C(paramCharSequence));
      }
      if (this.sSx) {
        this.sSv.addAll(D(paramCharSequence));
      }
      if (this.sSy) {
        this.sSv.addAll(E(paramCharSequence));
      }
      if (this.sSD) {
        this.sSv.addAll(I(paramCharSequence));
      }
      if (this.sSB) {
        this.sSv.addAll(F(paramCharSequence));
      }
      if (this.sSz) {
        this.sSv.addAll(G(paramCharSequence));
      }
      if (this.sSC) {
        this.sSv.addAll(H(paramCharSequence));
      }
      if ((paramCharSequence instanceof Spannable)) {}
      Object localObject2;
      for (paramCharSequence = (SpannableString)paramCharSequence;; paramCharSequence = new SpannableString(paramCharSequence))
      {
        if (!this.sSK) {
          break label816;
        }
        localObject1 = this.sSu.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (i)((Iterator)localObject1).next();
          ((i)localObject2).iCm = this.iCm;
          if ((((i)localObject2).start <= paramCharSequence.length()) && (((i)localObject2).end <= paramCharSequence.length())) {
            paramCharSequence.setSpan(new l(this.sSI, (i)localObject2), ((i)localObject2).start, ((i)localObject2).end, 33);
          }
        }
        this.sSJ = com.tencent.mm.bg.a.T(this.mContext, a.b.aXH);
        break;
        if ((Build.VERSION.SDK_INT == 16) && (bf.ap(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) < 0))
        {
          paramInt = 1;
          break label338;
        }
        paramInt = 0;
        break label338;
      }
      localObject1 = this.sSw.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.pluginsdk.ui.applet.l)((Iterator)localObject1).next();
        if ((((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).start <= paramCharSequence.length()) && (((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).end <= paramCharSequence.length()))
        {
          Object localObject3 = this.mContext.getResources().getDrawable(((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).id);
          if ((((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).width > 0) && (((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).height > 0))
          {
            ((Drawable)localObject3).setBounds(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.mContext, ((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).width), com.tencent.mm.bg.a.fromDPToPix(this.mContext, ((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).height));
            localObject3 = new com.tencent.mm.ui.widget.d((Drawable)localObject3);
            ((com.tencent.mm.ui.widget.d)localObject3).wsv = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 2);
            paramCharSequence.setSpan(localObject3, ((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).start, ((com.tencent.mm.pluginsdk.ui.applet.l)localObject2).start + 1, 18);
          }
          else
          {
            if (this.kH == null) {}
            for (paramInt = (int)(this.sSJ * 1.3F);; paramInt = (int)(this.kH.getTextSize() * 1.3F))
            {
              ((Drawable)localObject3).setBounds(0, 0, paramInt, paramInt);
              break;
            }
          }
        }
      }
      e(paramCharSequence);
      bGn();
      if (paramBoolean) {
        sSt.k(str, new SpannableString(paramCharSequence));
      }
      GMTrace.o(1215475744768L, 9056);
      return paramCharSequence;
    }
  }
  
  public final n i(TextView paramTextView)
  {
    GMTrace.i(1215341527040L, 9055);
    this.kH = paramTextView;
    if (paramTextView != null) {
      this.mContext = this.kH.getContext();
    }
    GMTrace.o(1215341527040L, 9055);
    return this;
  }
  
  final class a
  {
    int end;
    int start;
    
    a(int paramInt1, int paramInt2)
    {
      GMTrace.i(1203127713792L, 8964);
      this.start = paramInt1;
      this.end = paramInt2;
      GMTrace.o(1203127713792L, 8964);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/d/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */