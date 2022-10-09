package com.hyen;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
public class SimulateCardTable {

    // 올드 세대는 힙의 3/4를 차지하며, 1G 올드 세대에 카드 테이블은 2M 필요.
    private static final int SIZE_FOR_20_GIG_HEAP = 15 * 2 * 1024 * 1024;

    private static final byte[] cards = new byte[SIZE_FOR_20_GIG_HEAP];

    @Setup
    public static final void setup() {
        final Random r = new Random(System.nanoTime());
        for (int i=0; i<100000; i++) {
            cards[r.nextInt(SIZE_FOR_20_GIG_HEAP)] = 1;
        }
    }

    @Benchmark
    public int scanCardTable() {
        int found = 0;
        for (int i=0; i<SIZE_FOR_20_GIG_HEAP; i++) {
            if (cards[i] > 0) {
                found++;
            }
        }
        return found;
    }

    public static void main(String[] args) throws IOException, RunnerException {



        Options opt = new OptionsBuilder()// 성능측정 옵션 설정 객체
                .include(SimulateCardTable.class.getSimpleName())
                .warmupIterations(10)           // 사전 테스트 횟수
                .measurementIterations(10)      // 실제 측정 횟수
                .forks(1)                       //
                .build();
        new Runner(opt).run();// 벤치마킹 시작
    }
}