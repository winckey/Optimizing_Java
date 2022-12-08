import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class LoopTest {

    final int LIMIT_COUNT = 10000;
    final List<Integer> array = new ArrayList<>();

    @Setup
    public void init() {
        // 성능 측정 전 사전에 필요한 작업
        // 측정 시간에 포함 안댐
        for(int i = 0; i < LIMIT_COUNT; i++) {
            array.add(i);
        }
    }

    @Benchmark// 성능 측정 대상
    public void originLoopWithGetSize() {
        // 성능을 측정할 코드 작성
        int size = array.size();
        for(int i = 0; i < size; i++) {
            processor(i);
        }
    }
    @Benchmark
    public void getNum() {
        // 성능을 측정할 코드 작성
        int size = array.size();
        for(int i = 0; i < size/2; i++) {
            processor(i);
        }
    }
    Integer temp = 0;
    public void processor(Integer i) {
        temp = i;
    }

    public static void main(String[] args) throws IOException, RunnerException {



        Options opt = new OptionsBuilder()// 성능측정 옵션 설정 객체
                .include(LoopTest.class.getSimpleName())
                .warmupIterations(10)           // 사전 테스트 횟수
                .measurementIterations(10)      // 실제 측정 횟수
                .forks(1)                       // 
                .build();
        new Runner(opt).run();// 벤치마킹 시작
    }
}
