/*
 * MIT License
 *
 * Copyright (c) 2019 everythingbest
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ricadro.dubbotest;

import com.alibaba.fastjson.JSON;
import com.ricadro.dubbotest.appfind.zk.ZkService;
import org.junit.Ignore;
import org.junit.Test;

public class ZkServiceTest {

    @Test
    @Ignore
    public void test(){

        String addr = "127.0.0.0:2181";

        String serviceName = "com.ricadro.service.OrderService";

        ZkService zkService = new ZkService(addr,serviceName);

        System.out.println(JSON.toJSONString(zkService.allProviders));

        new Thread(new Runnable() {

            @Override
            public void run() {

                while (true){

                    try {
                        Thread.sleep(5000);
                        System.out.println(JSON.toJSONString(zkService.allProviders));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
