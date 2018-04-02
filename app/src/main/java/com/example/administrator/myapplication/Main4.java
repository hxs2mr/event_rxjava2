package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/3/30 0030.
 */

public class Main4 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_con3);
      /*  init_rxJava();
        init_rxjavva_just();
        init_rxJava_fromarray();
        init_rxJava_Itable();
        
        inint_rxjava_defer();
        init_rxjava_timer();
       // init_rxjava_intval();
        init_rxJava_intvalRang();
        init_rxjava_rang();*/
      
      init_rxjava_map();
    }

    private void init_rxjava_map() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(3);
                emitter.onNext(5);
                emitter.onComplete();
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "数据变了  不再是 1 3 5了";
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(String s) {
                System.out.println("收到的s数据************"+s);
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onComplete() {

            }
        });
    }

    private void init_rxjava_rang() {

        //从3开始  执行10次事件
        Observable.range(3,10)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void init_rxJava_intvalRang() {
        //从数字2开始   执行4次  第一次执行延迟3秒  每隔1秒执行一次
        Observable.intervalRange(2,4,3,1,TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("收到的数据为***********"+aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void init_rxjava_intval() {
        Observable.interval(3,10,TimeUnit.SECONDS)//快速创建Observable 定时循环任务 延迟3秒执行第一次一次  每10秒执行一次
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                            
                    }

                    @Override
                    public void onNext(Long aLong) {
                    System.out.println("收到的数据为***********"+aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void init_rxjava_timer() {//延迟多少时间后执行  快速创建Observable
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void inint_rxjava_defer() {
        Integer i = 0 ;
        Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<Integer> call() throws Exception {
                return Observable.just(i);//发送事件
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void init_rxJava_Itable() {
        List<String> list = new ArrayList<>();
        list.add("13");
        list.add("22");
        Observable.fromIterable(list)//快速创建被观察者对象  并发射list事件对象
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void init_rxJava_fromarray() {
        int[] a ={1,23,4,5};
        Observable.fromArray(a)//快速创建被观察者对象  并发射事件
                .subscribe(new Observer<int[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(int[] ints) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void init_rxjavva_just() {
        Observable.just(1,2,3,4)//快速创建事件及发射事件
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void init_rxJava() {
     /*   //定义被观察者
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>(){
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

                //发送事件
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //定义观察者
        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("开始采用Subscribe链接");
            }

            @Override
            public void onNext(Integer o) {
                System.out.println("对事件"+o+"相应");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("对事件onError相应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件onComplete相应");
            }
        };

        //订阅观察者和被观察者
        observable.subscribe(observer);
*/


        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                    //发生器发射事件
                emitter.onNext("第一痴");
                emitter.onNext("第二吃");
                emitter.onNext("第三吃");
                emitter.onComplete();
                emitter.onNext("第四吃");

            }
        }).subscribe(new Observer<String>() {
            Disposable disposable ;
            int i =0 ;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                System.out.println("***开始建立链接**");
            }

            @Override
            public void onNext(String s) {
                i++;
                if(i == 2)
                {
                    disposable.dispose();//解除订阅
                }
                System.out.println("收到事件是第几个"+s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("***错误事件**");
            }

            @Override
            public void onComplete() {
                System.out.println("***onComplete事件**");
            }
        });

    }



}
