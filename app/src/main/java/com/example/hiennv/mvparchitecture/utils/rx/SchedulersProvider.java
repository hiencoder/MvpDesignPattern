package com.example.hiennv.mvparchitecture.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulersProvider {
    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
