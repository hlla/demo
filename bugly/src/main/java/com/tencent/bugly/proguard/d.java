/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class d
/*     */   extends c
/*     */ {
/*  14 */   private f e = new f();
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
/*     */   public final <T> void a(String paramString, T paramT)
/*     */   {
/*  32 */     if (paramString.startsWith(".")) {
/*  33 */       throw new IllegalArgumentException("put name can not startwith . , now is " + paramString);
/*     */     }
/*  35 */     super.a(paramString, paramT);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final void b()
/*     */   {
/*  42 */     super.b();
/*  43 */     this.e.a = 3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public final byte[] a()
/*     */   {
/*  50 */     if (this.e.a == 2) {
/*  51 */       if (this.e.c.equals("")) {
/*  52 */         throw new IllegalArgumentException("servantName can not is null");
/*     */       }
/*  54 */       if (this.e.d.equals("")) {
/*  55 */         throw new IllegalArgumentException("funcName can not is null");
/*     */       }
/*     */     } else {
/*  58 */       if (this.e.c == null) {
/*  59 */         this.e.c = "";
/*     */       }
/*  61 */       if (this.e.d == null) {
/*  62 */         this.e.d = "";
/*     */       }
/*     */     }
/*     */     Object localObject1;
/*  66 */     (localObject1 = new j(0)).a(this.b);
/*  67 */     if (this.e.a == 2) {
/*  68 */       ((j)localObject1).a(this.a, 0);
/*     */     } else {
/*  70 */       ((j)localObject1).a(this.d, 0);
/*     */     }
/*  72 */     this.e.e = l.a(((j)localObject1).a());
/*  73 */     (
/*  74 */       localObject1 = new j(0)).a(this.b);
/*  75 */     Object localObject2 = localObject1;d locald = this;this.e.a((j)localObject2);
/*     */     
/*     */     int i;
/*     */     
/*  79 */     (localObject2 = ByteBuffer.allocate((i = (localObject1 = l.a(((j)localObject1).a())).length) + 4)).putInt(i + 4).put((byte[])localObject1).flip();
/*  80 */     return ((ByteBuffer)localObject2).array();
/*     */   }
/*     */   
/*  83 */   private static HashMap<String, byte[]> f = null;
/*  84 */   private static HashMap<String, HashMap<String, byte[]>> g = null;
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
/*     */   public final void a(byte[] paramArrayOfByte)
/*     */   {
/* 144 */     if (paramArrayOfByte.length < 4) {
/* 145 */       throw new IllegalArgumentException("decode package must include size head");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 150 */       (paramArrayOfByte = new i(paramArrayOfByte, 4)).a(this.b);
/* 151 */       Object localObject = paramArrayOfByte;paramArrayOfByte = this;this.e.a((i)localObject);
/* 152 */       if (this.e.a == 3)
/*     */       {
/* 154 */         (paramArrayOfByte = new i(this.e.e)).a(this.b);
/* 155 */         if (f == null)
/*     */         {
/* 157 */           (f = new HashMap()).put("", new byte[0]);
/*     */         }
/* 159 */         this.d = paramArrayOfByte.a(f, 0, false);
/*     */       }
/*     */       else {
/* 162 */         (paramArrayOfByte = new i(this.e.e)).a(this.b);
/* 163 */         if (g == null) {
/* 164 */           g = new HashMap();
/* 165 */           (
/* 166 */             localObject = new HashMap()).put("", new byte[0]);
/* 167 */           g.put("", localObject);
/*     */         }
/* 169 */         this.a = paramArrayOfByte.a(g, 0, false);
/* 170 */         new HashMap(); return;
/*     */       }
/*     */     } catch (Exception paramArrayOfByte) {
/* 173 */       throw new RuntimeException(paramArrayOfByte);
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
/*     */   public final void b(String paramString)
/*     */   {
/* 194 */     this.e.c = paramString;
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
/*     */   public final void c(String paramString)
/*     */   {
/* 212 */     this.e.d = paramString;
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
/*     */   public final void b(int paramInt)
/*     */   {
/* 230 */     this.e.b = 1;
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
/*     */   public d()
/*     */   {
/* 259 */     this.e.a = 2;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */