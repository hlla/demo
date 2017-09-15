package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bi.f;
import com.tencent.mm.bi.g;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.ui.d.d.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginEmoji
  extends com.tencent.mm.kernel.b.d
  implements com.tencent.mm.plugin.emoji.b.c
{
  private com.tencent.mm.pluginsdk.c.d kFB;
  private com.tencent.mm.plugin.emoji.b.b kFC;
  
  public PluginEmoji()
  {
    GMTrace.i(16407446159360L, 122245);
    GMTrace.o(16407446159360L, 122245);
  }
  
  public void configure(e parame)
  {
    GMTrace.i(16407983030272L, 122249);
    d.a.a(g.bKx());
    GMTrace.o(16407983030272L, 122249);
  }
  
  public void dependency()
  {
    GMTrace.i(16407848812544L, 122248);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    GMTrace.o(16407848812544L, 122248);
  }
  
  public void execute(e parame)
  {
    GMTrace.i(16408117248000L, 122250);
    if (parame.ej(""))
    {
      pin(d.akN());
      if (parame.ej("")) {
        h.a(com.tencent.mm.plugin.emoji.b.a.class, new com.tencent.mm.kernel.c.c(new a()));
      }
    }
    com.tencent.mm.ui.f.b.a.a(new com.tencent.mm.ui.f.b.c()
    {
      public final com.tencent.mm.ui.f.b.b bK(String paramAnonymousString1, String paramAnonymousString2)
      {
        GMTrace.i(16410130513920L, 122265);
        try
        {
          paramAnonymousString1 = com.tencent.mm.plugin.gif.b.aCO().cr(paramAnonymousString1, paramAnonymousString2);
          GMTrace.o(16410130513920L, 122265);
          return paramAnonymousString1;
        }
        catch (IOException paramAnonymousString1)
        {
          v.printErrStackTrace("MicroMsg.PluginEmoji", paramAnonymousString1, "", new Object[0]);
          GMTrace.o(16410130513920L, 122265);
        }
        return null;
      }
    });
    com.tencent.mm.ui.f.c.b.a(new com.tencent.mm.ui.f.c.a()
    {
      public final CharSequence a(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, float paramAnonymousFloat)
      {
        GMTrace.i(16409727860736L, 122262);
        paramAnonymousContext = g.bKx().d(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousFloat);
        GMTrace.o(16409727860736L, 122262);
        return paramAnonymousContext;
      }
      
      public final CharSequence a(Context paramAnonymousContext, CharSequence paramAnonymousCharSequence, int paramAnonymousInt)
      {
        GMTrace.i(16409593643008L, 122261);
        paramAnonymousContext = g.bKx().b(paramAnonymousContext, paramAnonymousCharSequence, paramAnonymousInt);
        GMTrace.o(16409593643008L, 122261);
        return paramAnonymousContext;
      }
      
      public final int aG(String paramAnonymousString, int paramAnonymousInt)
      {
        GMTrace.i(16409862078464L, 122263);
        g.bKx();
        Object localObject = f.bKu();
        if (bf.mA(paramAnonymousString))
        {
          GMTrace.o(16409862078464L, 122263);
          return paramAnonymousInt;
        }
        int j = paramAnonymousString.length();
        if ((paramAnonymousInt == 0) || (paramAnonymousInt == j))
        {
          GMTrace.o(16409862078464L, 122263);
          return paramAnonymousInt;
        }
        if (f.uwZ == null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          int k = ((f)localObject).uwP.length;
          i = 0;
          while (i < k)
          {
            localStringBuilder.append(Pattern.quote(localObject.uwP[i]));
            if (i != k - 1) {
              localStringBuilder.append('|');
            }
            i += 1;
          }
          k = ((f)localObject).uwQ.length;
          i = 0;
          while (i < k)
          {
            localStringBuilder.append(Pattern.quote(localObject.uwQ[i]));
            if (i != k - 1) {
              localStringBuilder.append('|');
            }
            i += 1;
          }
          k = ((f)localObject).uwR.length;
          i = 0;
          while (i < k)
          {
            localStringBuilder.append(Pattern.quote(localObject.uwR[i]));
            if (i != k - 1) {
              localStringBuilder.append('|');
            }
            i += 1;
          }
          k = ((f)localObject).uwS.length;
          i = 0;
          while (i < k)
          {
            localStringBuilder.append(Pattern.quote(localObject.uwS[i]));
            if (i != k - 1) {
              localStringBuilder.append('|');
            }
            i += 1;
          }
          k = ((f)localObject).uwT.length;
          i = 0;
          while (i < k)
          {
            localStringBuilder.append(Pattern.quote(localObject.uwT[i]));
            if (i != k - 1) {
              localStringBuilder.append('|');
            }
            i += 1;
          }
          k = ((f)localObject).uwU.length;
          i = 0;
          while (i < k)
          {
            localStringBuilder.append(Pattern.quote(localObject.uwU[i]));
            if (i != k - 1) {
              localStringBuilder.append('|');
            }
            i += 1;
          }
          if ((((f)localObject).uwV != null) && (!((f)localObject).uwV.isEmpty()))
          {
            localObject = ((f)localObject).uwV.iterator();
            while (((Iterator)localObject).hasNext())
            {
              s locals = (s)((Iterator)localObject).next();
              localStringBuilder.append(Pattern.quote(locals.field_key)).append("|");
              if (!bf.mA(locals.field_cnValue)) {
                localStringBuilder.append(Pattern.quote(locals.field_cnValue)).append("|");
              }
              if (!bf.mA(locals.field_enValue)) {
                localStringBuilder.append(Pattern.quote(locals.field_enValue)).append("|");
              }
              if (!bf.mA(locals.field_qqValue)) {
                localStringBuilder.append(Pattern.quote(locals.field_qqValue)).append("|");
              }
              if (!bf.mA(locals.field_twValue)) {
                localStringBuilder.append(Pattern.quote(locals.field_twValue)).append("|");
              }
              if (!bf.mA(locals.field_thValue)) {
                localStringBuilder.append(Pattern.quote(locals.field_thValue)).append("|");
              }
            }
          }
          f.uwZ = Pattern.compile(localStringBuilder.toString());
        }
        if (paramAnonymousInt < 6)
        {
          i = 0;
          if (paramAnonymousInt + 6 < j) {
            break label740;
          }
          j -= 1;
          label662:
          paramAnonymousString = paramAnonymousString.substring(i, j);
          paramAnonymousString = f.uwZ.matcher(paramAnonymousString);
          do
          {
            if (!paramAnonymousString.find()) {
              break;
            }
          } while ((6 <= paramAnonymousString.start()) || (6 >= paramAnonymousString.end()));
        }
        for (int i = paramAnonymousString.start();; i = 6)
        {
          if (i - 6 > 0) {
            i -= 6;
          }
          for (;;)
          {
            GMTrace.o(16409862078464L, 122263);
            return paramAnonymousInt + i;
            i = paramAnonymousInt - 6;
            break;
            label740:
            j = paramAnonymousInt + 6;
            break label662;
            i = 0;
          }
        }
      }
    });
    GMTrace.o(16408117248000L, 122250);
  }
  
  public com.tencent.mm.pluginsdk.c.d getEmojiMgr()
  {
    GMTrace.i(16408519901184L, 122253);
    if (this.kFB == null) {
      this.kFB = this.kFC.aln();
    }
    com.tencent.mm.pluginsdk.c.d locald = this.kFB;
    GMTrace.o(16408519901184L, 122253);
    return locald;
  }
  
  public void installed()
  {
    GMTrace.i(16407714594816L, 122247);
    alias(com.tencent.mm.plugin.emoji.b.c.class);
    GMTrace.o(16407714594816L, 122247);
  }
  
  public String name()
  {
    GMTrace.i(16407580377088L, 122246);
    GMTrace.o(16407580377088L, 122246);
    return "plugin-emoji";
  }
  
  public void removeEmojiMgr()
  {
    GMTrace.i(16408385683456L, 122252);
    this.kFB = null;
    GMTrace.o(16408385683456L, 122252);
  }
  
  public void setEmojiMgr()
  {
    GMTrace.i(16408251465728L, 122251);
    if (this.kFB == null) {
      this.kFB = this.kFC.aln();
    }
    GMTrace.o(16408251465728L, 122251);
  }
  
  public void setEmojiMgrProvider(com.tencent.mm.plugin.emoji.b.b paramb)
  {
    GMTrace.i(16408654118912L, 122254);
    this.kFC = paramb;
    GMTrace.o(16408654118912L, 122254);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/emoji/PluginEmoji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */