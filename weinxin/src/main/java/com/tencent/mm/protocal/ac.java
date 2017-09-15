package com.tencent.mm.protocal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class ac
{
  public String sYE;
  public String sYF;
  public int ver;
  
  ac(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(13602027208704L, 101343);
    this.sYE = paramString1;
    this.sYF = paramString2;
    this.ver = paramInt;
    GMTrace.o(13602027208704L, 101343);
  }
  
  public static void G(String paramString1, String paramString2, int paramInt)
  {
    GMTrace.i(13601356120064L, 101338);
    v.d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    SharedPreferences.Editor localEditor = aa.getContext().getSharedPreferences("rsa_public_key_prefs", 4).edit();
    localEditor.putString("keye", paramString1);
    localEditor.putString("keyn", paramString2);
    localEditor.putInt("version", paramInt);
    localEditor.putInt("client_version", d.sXh);
    localEditor.commit();
    GMTrace.o(13601356120064L, 101338);
  }
  
  public static ac bHi()
  {
    GMTrace.i(13601490337792L, 101339);
    Object localObject = aa.getContext().getSharedPreferences("rsa_public_key_prefs", 4);
    ac localac = new ac(((SharedPreferences)localObject).getString("keye", ""), ((SharedPreferences)localObject).getString("keyn", ""), ((SharedPreferences)localObject).getInt("version", 0));
    int i = ((SharedPreferences)localObject).getInt("client_version", 0);
    if (!localac.bHl())
    {
      if (i > 637665843)
      {
        GMTrace.o(13601490337792L, 101339);
        return localac;
      }
      boolean bool = ((SharedPreferences)localObject).edit().clear().commit();
      c.oRz.a(148L, 38L, 1L, false);
      v.i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", new Object[] { Integer.valueOf(i), Integer.valueOf(d.sXh), Boolean.valueOf(bool) });
    }
    c.oRz.a(148L, 39L, 1L, false);
    v.d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67".substring(0, 4) + "_" + "E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67".substring(507, 511), Integer.valueOf(158) });
    localObject = new ac("010001", "E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67", 158);
    GMTrace.o(13601490337792L, 101339);
    return (ac)localObject;
  }
  
  public static ac bHj()
  {
    GMTrace.i(13601624555520L, 101340);
    ac localac = new ac("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
    GMTrace.o(13601624555520L, 101340);
    return localac;
  }
  
  public static ac bHk()
  {
    GMTrace.i(13601758773248L, 101341);
    v.d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", new Object[] { "010001", "DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B".substring(0, 4) + "_" + "DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B".substring(507, 511), Integer.valueOf(157) });
    ac localac = new ac("010001", "DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B", 157);
    GMTrace.o(13601758773248L, 101341);
    return localac;
  }
  
  /* Error */
  public static boolean bHm()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc2_w 192
    //   5: ldc -62
    //   7: invokestatic 23	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   10: new 196	java/io/FileWriter
    //   13: dup
    //   14: new 155	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 201	com/tencent/mm/compatible/util/e:hgk	Ljava/lang/String;
    //   24: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc -53
    //   29: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 206	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: ldc -48
    //   44: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: new 155	java/lang/StringBuilder
    //   53: dup
    //   54: ldc -43
    //   56: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: getstatic 219	com/tencent/mm/sdk/platformtools/e:CLIENT_VERSION	Ljava/lang/String;
    //   62: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc -35
    //   67: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   76: aload_3
    //   77: astore_2
    //   78: aload_3
    //   79: new 155	java/lang/StringBuilder
    //   82: dup
    //   83: ldc -33
    //   85: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: new 225	java/text/SimpleDateFormat
    //   91: dup
    //   92: ldc -29
    //   94: invokespecial 228	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   97: new 230	java/util/Date
    //   100: dup
    //   101: invokespecial 231	java/util/Date:<init>	()V
    //   104: invokevirtual 235	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   107: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc -19
    //   112: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   121: aload_3
    //   122: astore_2
    //   123: aload_3
    //   124: ldc -17
    //   126: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: astore_2
    //   131: aload_3
    //   132: ldc -15
    //   134: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   137: aload_3
    //   138: astore_2
    //   139: aload_3
    //   140: ldc -13
    //   142: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   145: aload_3
    //   146: astore_2
    //   147: aload_3
    //   148: ldc -11
    //   150: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   153: aload_3
    //   154: astore_2
    //   155: aload_3
    //   156: ldc -9
    //   158: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   161: aload_3
    //   162: astore_2
    //   163: aload_3
    //   164: ldc -7
    //   166: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   169: aload_3
    //   170: astore_2
    //   171: aload_3
    //   172: ldc -5
    //   174: invokevirtual 211	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   177: iconst_1
    //   178: istore_0
    //   179: aload_3
    //   180: invokevirtual 254	java/io/FileWriter:close	()V
    //   183: ldc2_w 192
    //   186: ldc -62
    //   188: invokestatic 32	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   191: iload_0
    //   192: ireturn
    //   193: astore 4
    //   195: aconst_null
    //   196: astore_3
    //   197: aload_3
    //   198: astore_2
    //   199: ldc 39
    //   201: aload 4
    //   203: ldc 107
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 258	com/tencent/mm/sdk/platformtools/v:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: iload_1
    //   213: istore_0
    //   214: aload_3
    //   215: ifnull -32 -> 183
    //   218: aload_3
    //   219: invokevirtual 254	java/io/FileWriter:close	()V
    //   222: iload_1
    //   223: istore_0
    //   224: goto -41 -> 183
    //   227: astore_2
    //   228: iload_1
    //   229: istore_0
    //   230: goto -47 -> 183
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_2
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 254	java/io/FileWriter:close	()V
    //   244: aload_3
    //   245: athrow
    //   246: astore_2
    //   247: goto -64 -> 183
    //   250: astore_2
    //   251: goto -7 -> 244
    //   254: astore_3
    //   255: goto -19 -> 236
    //   258: astore 4
    //   260: goto -63 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   178	52	0	bool1	boolean
    //   1	228	1	bool2	boolean
    //   40	159	2	localFileWriter1	java.io.FileWriter
    //   227	1	2	localException1	Exception
    //   235	6	2	localObject1	Object
    //   246	1	2	localException2	Exception
    //   250	1	2	localException3	Exception
    //   38	181	3	localFileWriter2	java.io.FileWriter
    //   233	12	3	localObject2	Object
    //   254	1	3	localObject3	Object
    //   193	9	4	localException4	Exception
    //   258	1	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   10	39	193	java/lang/Exception
    //   218	222	227	java/lang/Exception
    //   10	39	233	finally
    //   179	183	246	java/lang/Exception
    //   240	244	250	java/lang/Exception
    //   41	47	254	finally
    //   49	76	254	finally
    //   78	121	254	finally
    //   123	129	254	finally
    //   131	137	254	finally
    //   139	145	254	finally
    //   147	153	254	finally
    //   155	161	254	finally
    //   163	169	254	finally
    //   171	177	254	finally
    //   199	212	254	finally
    //   41	47	258	java/lang/Exception
    //   49	76	258	java/lang/Exception
    //   78	121	258	java/lang/Exception
    //   123	129	258	java/lang/Exception
    //   131	137	258	java/lang/Exception
    //   139	145	258	java/lang/Exception
    //   147	153	258	java/lang/Exception
    //   155	161	258	java/lang/Exception
    //   163	169	258	java/lang/Exception
    //   171	177	258	java/lang/Exception
  }
  
  public final boolean bHl()
  {
    GMTrace.i(13601892990976L, 101342);
    if ((this.ver == 0) || (bf.mA(this.sYE)) || (bf.mA(this.sYF)))
    {
      GMTrace.o(13601892990976L, 101342);
      return true;
    }
    GMTrace.o(13601892990976L, 101342);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */