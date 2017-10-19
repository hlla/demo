/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends a
/*     */ {
/*  15 */   protected HashMap<String, byte[]> d = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  20 */   private HashMap<String, Object> e = new HashMap();
/*     */   
/*     */ 
/*  23 */   private i f = new i();
/*     */   
/*     */ 
/*     */ 
/*     */   public void b()
/*     */   {
/*  29 */     this.d = new HashMap();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T> void a(String paramString, T paramT)
/*     */   {
/*  79 */     if (this.d != null) {
/*  80 */       if (paramString == null) {
/*  81 */         throw new IllegalArgumentException("put key can not is null");
/*     */       }
/*  83 */       if (paramT == null) {
/*  84 */         throw new IllegalArgumentException("put value can not is null");
/*     */       }
/*  86 */       if ((paramT instanceof Set)) {
/*  87 */         throw new IllegalArgumentException("can not support Set");
/*     */       }
/*     */       j localj;
/*  90 */       (localj = new j()).a(this.b);
/*  91 */       localj.a(paramT, 0);
/*  92 */       paramT = l.a(localj.a());
/*  93 */       this.d.put(paramString, paramT);
/*  94 */       return; }
/*  95 */     super.a(paramString, paramT);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final <T> T b(String paramString, T paramT)
/*     */     throws b
/*     */   {
/*     */     Object localObject3;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 138 */     if (this.d != null) {
/* 139 */       if (!this.d.containsKey(paramString))
/* 140 */         return null;
/* 141 */       if (this.e.containsKey(paramString)) {
/* 142 */         return (T)this.e.get(paramString);
/*     */       }
/* 144 */       localObject1 = (byte[])this.d.get(paramString);
/*     */       try {
/* 146 */         localObject2 = paramT;localObject1 = localObject1;paramT = this;this.f.a((byte[])localObject1);paramT.f.a(paramT.b);paramT = paramT = paramT.f.a(localObject2, 0, true);
/* 147 */         if (paramT != null) {
/* 148 */           localObject3 = paramT;localObject2 = paramString;paramString = this;this.e.put(localObject2, localObject3);
/*     */         }
/* 150 */         return paramT;
/*     */       } catch (Exception paramT) {
/* 152 */         throw new b(paramT);
/*     */       }
/*     */     }
/*     */     
/* 156 */     if (!this.a.containsKey(paramString))
/* 157 */       return null;
/* 158 */     if (this.e.containsKey(paramString)) {
/* 159 */       return (T)this.e.get(paramString);
/*     */     }
/* 161 */     Object localObject1 = (HashMap)this.a.get(paramString);
/* 162 */     Object localObject2 = new byte[0];
/*     */     
/* 164 */     if ((localObject1 = ((HashMap)localObject1).entrySet().iterator()).hasNext()) {
/* 165 */       (localObject1 = (Map.Entry)((Iterator)localObject1).next()).getKey();
/* 166 */       localObject2 = (byte[])((Map.Entry)localObject1).getValue(); }
/* 167 */     try { this.f.a((byte[])localObject2);
/*     */       
/*     */ 
/*     */ 
/* 171 */       this.f.a(this.b);
/* 172 */       localObject1 = this.f.a(paramT, 0, true);
/* 173 */       localObject3 = localObject1;localObject2 = paramString;paramString = this;this.e.put(localObject2, localObject3);
/* 174 */       return (T)localObject1;
/*     */     } catch (Exception localException) {
/* 176 */       throw new b(localException);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public byte[] a()
/*     */   {
/* 365 */     if (this.d != null) {
/*     */       j localj;
/* 367 */       (localj = new j(0)).a(this.b);
/* 368 */       localj.a(this.d, 0);
/* 369 */       return l.a(localj.a());
/*     */     }
/* 371 */     return super.a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(byte[] paramArrayOfByte)
/*     */   {
/*     */     try
/*     */     {
/* 400 */       super.a(paramArrayOfByte);
/* 401 */       return;
/*     */     } catch (Exception localException) {
/* 403 */       this.f.a(paramArrayOfByte);
/* 404 */       this.f.a(this.b);
/* 405 */       (
/* 406 */         paramArrayOfByte = new HashMap(1)).put("", new byte[0]);
/* 407 */       this.d = this.f.a(paramArrayOfByte, 0, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */