package ru.job4j.collection;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class ArticleBenchMark {

    @State(Scope.Thread)
    public static class MyState {

        public String origin = "Мой дядя самых честных правил, " +
                "Когда не в шутку занемог, " +
                "Он уважать себя заставил " +
                "И лучше выдумать не мог. " +
                "Его пример другим наука; " +
                "Но, боже мой, какая скука " +
                "С больным сидеть и день и ночь, " +
                "Не отходя ни шагу прочь! " +
                "Какое низкое коварство " +
                "Полуживого забавлять, " +
                "Ему подушки поправлять, " +
                "Печально подносить лекарство, " +
                "Вздыхать и думать про себя: " +
                "Когда же черт возьмет тебя!";

        public String line = "Вздыхать и думать про себя: " +
                "Когда же черт возьмет тебя!";
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void test1(MyState state) {
        Article.generateBy(state.origin, state.line);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void test2(MyState state) {
        Article.generateBy2(state.origin, state.line);
    }

}
