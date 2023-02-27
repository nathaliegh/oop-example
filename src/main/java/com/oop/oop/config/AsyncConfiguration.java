package com.oop.oop.config;

import com.oop.oop.OopApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

@Configuration
public class AsyncConfiguration extends AsyncConfigurerSupport {

    private static final Logger log = LoggerFactory.getLogger(OopApplication.class);

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new
                ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(4);
        executor.setThreadNamePrefix("asyn-oop-thread-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
    @Override
    public AsyncUncaughtExceptionHandler
    getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {

            @Override
            public void handleUncaughtException(Throwable ex,
                                                Method method, Object... params) {
                log.error("Exception: ",ex.getMessage());
                log.error("Method Name: ", method.getName());
                ex.printStackTrace();
            }
        };
    }
}
