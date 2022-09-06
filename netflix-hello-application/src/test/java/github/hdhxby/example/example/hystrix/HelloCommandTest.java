package github.hdhxby.example.example.hystrix;

import io.github.hdhxby.example.hystrix.HelloCommand;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class HelloCommandTest {

    /**
     * 单条-同步
     */
    @Test
    public void execute() throws ExecutionException, InterruptedException {
        log.debug(new HelloCommand()
                .execute());
        log.debug("execute");
    }

    /**
     * 单条-异步
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void queue() throws ExecutionException, InterruptedException {
        Future<String> queue = new HelloCommand()
                .queue();
        log.debug("queue");
        log.debug(queue .get());
        log.debug(queue .get());
    }

    /**
     * 单条
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void observe() throws ExecutionException, InterruptedException {
        HelloCommand helloCommand = new HelloCommand();
        Observable<String> observable = helloCommand.observe();
        log.debug("observe");
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String o) {
                log.debug("onNext");
                log.debug(o);
            }
        });
        log.debug(observable.toBlocking().single());
        log.debug(observable.toBlocking().single());
    }

    /**
     * 单条
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void toObservable() throws ExecutionException, InterruptedException {
        HelloCommand helloCommand = new HelloCommand();
        Observable<String> observable = helloCommand.toObservable();
        log.debug("toObservable");
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String o) {
                log.debug("onNext");
                log.debug(o);
            }
        });
        log.debug(observable.toBlocking().single());
    }
}
