package com.ranger.LearningJVM.ch3;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class PhantomReferenceUsage {
    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        List<LargeObjectFinalizer> references = new ArrayList<>();
        List<Object> largeObjects = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            Object largeObject = new Object();
            largeObjects.add(largeObject);
            references.add(new LargeObjectFinalizer(largeObject, referenceQueue));
        }

        // 清空对象并且尝试触发GC，这个时候如果对象被收集，其对应的虚引用会进入到referenceQueue
        largeObjects = null;
        System.gc();

        Reference<?> referenceFromQueue;
        for (PhantomReference<Object> reference : references) {
            System.out.println(reference.isEnqueued());
        }

        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            ((LargeObjectFinalizer)referenceFromQueue).finalizeResources();
            referenceFromQueue.clear();
        }
    }

    // 继承类，在实际应用中可以加入其它逻辑，比如对象的Hash等
    public static class LargeObjectFinalizer extends PhantomReference<Object> {

        public LargeObjectFinalizer(
                Object referent, ReferenceQueue<? super Object> q) {
            super(referent, q);
        }

        public void finalizeResources() {
            // free resources
            System.out.println("clearing ...");
        }
    }
}
