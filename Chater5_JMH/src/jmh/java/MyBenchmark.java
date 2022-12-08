
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;


public class MyBenchmark {
    public static void main(String[] args) throws RuntimeException {
        Options opt = new OPtionsBuilder()
                .include(SortBenchmark.class.getSimpleName())
                .warmupIterations(100)
                .measurementIterations(5).forks(1)
                .jvmArgs("-server", "-Xms2048m", "-Xmx2048m").build();

        new Runner(opt).run();
    }
}