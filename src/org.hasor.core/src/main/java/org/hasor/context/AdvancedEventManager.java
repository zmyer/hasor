/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hasor.context;
import org.more.RepeateException;
/**
 * 高级事件管理器
 * @version : 2013-5-6
 * @author 赵永春 (zyc@byshell.org)
 */
public interface AdvancedEventManager extends EventManager {
    /**pushPhaseEvent方法注册的时间监听器当收到一次事件之后会被自动删除。*/
    public void pushEventListener(String eventType, HasorEventListener hasorEventListener);
    /**添加一个计时器，如果添加的计时器类型已经存在则会抛出异常。*/
    public void addTimer(String timerType, HasorEventListener hasorEventListener) throws RepeateException;
    /**移除可能或已经存在的计时器对象,当计时器正在执行时会将timer任务执行完毕.*/
    public void removeTimer(String timerType);
    /**移除可能或已经存在的计时器对象,当计时器正在执行时会尝试取消timer正在执行的任务.*/
    public void removeTimerNow(String timerType);
}