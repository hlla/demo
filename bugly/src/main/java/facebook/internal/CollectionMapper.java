/*    */ package com.facebook.internal;
/*    */ 
/*    */ import com.facebook.FacebookException;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CollectionMapper
/*    */ {
/*    */   public static <T> void iterate(Collection<T> collection, ValueMapper valueMapper, final OnMapperCompleteListener onMapperCompleteListener)
/*    */   {
/* 38 */     Mutable<Boolean> didReturnError = new Mutable(Boolean.valueOf(false));
/* 39 */     final Mutable<Integer> pendingJobCount = new Mutable(Integer.valueOf(1));
/* 40 */     final OnMapperCompleteListener jobCompleteListener = new OnMapperCompleteListener()
/*    */     {
/*    */       public void onComplete() {
/* 43 */         if (((Boolean)this.val$didReturnError.value).booleanValue()) {
/* 44 */           return;
/*    */         }
/* 46 */         if ((pendingJobCount.value = Integer.valueOf(((Integer)pendingJobCount.value).intValue() - 1)).intValue() == 0) {
/* 47 */           onMapperCompleteListener.onComplete();
/*    */         }
/*    */       }
/*    */       
/*    */       public void onError(FacebookException exception)
/*    */       {
/* 53 */         if (((Boolean)this.val$didReturnError.value).booleanValue()) {
/* 54 */           return;
/*    */         }
/* 56 */         this.val$didReturnError.value = Boolean.valueOf(true);
/* 57 */         onMapperCompleteListener.onError(exception);
/*    */       }
/*    */       
/* 60 */     };
/* 61 */     Iterator<T> keyIterator = collection.keyIterator();
/* 62 */     List<T> keys = new LinkedList();
/* 63 */     while (keyIterator.hasNext()) {
/* 64 */       keys.add(keyIterator.next());
/*    */     }
/*    */     
/* 67 */     for (final T key : keys) {
/* 68 */       Object value = collection.get(key);
/* 69 */       OnMapValueCompleteListener onMapValueCompleteListener = new OnMapValueCompleteListener()
/*    */       {
/*    */         public void onComplete(Object mappedValue)
/*    */         {
/* 73 */           this.val$collection.set(key, mappedValue, jobCompleteListener);
/* 74 */           jobCompleteListener.onComplete();
/*    */         }
/*    */         
/*    */         public void onError(FacebookException exception)
/*    */         {
/* 79 */           jobCompleteListener.onError(exception);
/*    */         }
/* 81 */       };
/* 82 */       Integer localInteger1 = (Integer)pendingJobCount.value;Integer localInteger2 = pendingJobCount.value = Integer.valueOf(((Integer)pendingJobCount.value).intValue() + 1);
/* 83 */       valueMapper.mapValue(value, onMapValueCompleteListener);
/*    */     }
/* 85 */     jobCompleteListener.onComplete();
/*    */   }
/*    */   
/*    */   public static abstract interface Collection<T>
/*    */   {
/*    */     public abstract Iterator<T> keyIterator();
/*    */     
/*    */     public abstract Object get(T paramT);
/*    */     
/*    */     public abstract void set(T paramT, Object paramObject, OnErrorListener
        paramOnErrorListener);
/*    */   }
/*    */   
/*    */   public static abstract interface ValueMapper
/*    */   {
/*    */     public abstract void mapValue(Object paramObject, OnMapValueCompleteListener
        paramOnMapValueCompleteListener);
/*    */   }
/*    */   
/*    */   public static abstract interface OnMapValueCompleteListener
/*    */     extends OnErrorListener
/*    */   {
/*    */     public abstract void onComplete(Object paramObject);
/*    */   }
/*    */   
/*    */   public static abstract interface OnMapperCompleteListener
/*    */     extends OnErrorListener
/*    */   {
/*    */     public abstract void onComplete();
/*    */   }
/*    */   
/*    */   public static abstract interface OnErrorListener
/*    */   {
/*    */     public abstract void onError(FacebookException paramFacebookException);
/*    */   }
/*    */ }


/* Location:              /home/chengjian/workspace/dev_cml_baipai/thirdsdk/libs/fb/classes.jar!/com/facebook/internal/CollectionMapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */