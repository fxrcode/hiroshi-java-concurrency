package hiroshi.java.concurrency.singleThreadedExecution.exercise6;

/**
 * Demo of deadlock
 * It must fulfill all 3 requirements:
 *  1. multiple sharedResources
 *  2. when thread hold the lock of one sharedResource, it asks for another one
 *  3. there's no certain order to acquire sharedResource's lock.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing deadlock by EaterThread, hit CTRL+C to exit");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", fork, spoon).start();
    }
}
