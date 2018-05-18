package com.zc.RXJava;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.zc.mydemoin58.R;
import com.zc.util.UIUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observers.Observers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

public class RXJavaActivity extends Activity {

    private Button mRXBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        mRXBtn = (Button) findViewById(R.id.rxjava_button);
//        testRXNormal();
//        testRXMap();
//        testRXFlatMap();
//        testRXLift();
//        testRx();
        testRxBehaviorSubject();
    }

    public void testRx() {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                Log.e("zc", "-subscribe");
            }
        });
    }

    public void testRXNormal() {
        final Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.e("zc", UIUtil.isMainThread() + "observer onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("zc", UIUtil.isMainThread() + "observer onError");
            }

            @Override
            public void onNext(String s) {
                if ("error".equals(s)) {
                    throw new NullPointerException();
                }
                Log.e("zc", UIUtil.isMainThread() + "observer onNext");
            }
        };

//        Observable
//                .from(new String[]{"aaaa", "bbbb", "error"})
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.newThread())
//                .subscribe(observer);

        Observable observable = Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                Log.e("zc", UIUtil.isMainThread() + "testRX()");
                subscriber.onNext("aaaa");
                subscriber.onNext("error");
                subscriber.onCompleted();
            }
        });
        observable.subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.newThread()).subscribe(observer);
    }

    public void testRxBehaviorSubject() {
        BehaviorSubject<Object> observable = BehaviorSubject.create();
        observable.subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.newThread()).subscribe(u -> {
            Log.e("zc", u + "lambda--next");
        }, e -> {
            Log.e("zc", e.getMessage() + "lambda--error");
        });

        mRXBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((int) (Math.random() * 10f) > 5) {
                    observable.onNext("aaaaa");
                } else {
                    observable.onError(new NullPointerException());
                }
            }
        });
    }

    public void testRXMap() {
        String[] name = new String[]{"aaa", "bbb", "ccc"};
        Observable.from(name).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s + "-map";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e("zc", s + "-subscribe");
            }
        });
    }

    public void testRXFlatMap() {
        String[] name = new String[]{"aaa", "bbb", "ccc"};
        Observable.from(name).flatMap(new Func1<String, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(String s) {
                return Observable.from(new Integer[]{Integer.valueOf(s.charAt(0)), Integer.valueOf(s.charAt(1))});
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer s) {
                Log.e("zc", s + "-testRXFlatMap");
            }
        });
    }

    public void testRXLift() {
        String[] name = new String[]{"aaa", "bbb", "ccc"};
        Observable.from(name).lift(new Observable.Operator<Integer, String>() {
            @Override
            public Subscriber<? super String> call(final Subscriber<? super Integer> subscriber) {
                return new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.e("zc", "-onCompleted");
                        subscriber.onNext(0);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("zc", "-onError");
                        subscriber.onNext(-1);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e("zc", "-onNext");
                        subscriber.onNext(1);
                    }
                };
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.e("zc", integer + "-subscribe");
            }
        });
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        Process process = Runtime.getRuntime().exec("adb shell input tap 540 2000");
                        Thread.sleep(2000);
                        System.out.print("click");
                    }
                } catch (Exception e) {

                    e.printStackTrace();

                }

            }
        }).start();

    }

    public void testCombineLatestObservable(){
//        Observable<String> ObservableEmail = Observable.create(new Observable.OnSubscribe<String>() {
//
//            @Override
//            public void call(final Subscriber<? super String> subscriber) {
//                mEmailView.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//                        subscriber.onNext(s.toString());
//                    }
//                });
//            }
//        });
//        Observable.combineLatest()
    }

}
