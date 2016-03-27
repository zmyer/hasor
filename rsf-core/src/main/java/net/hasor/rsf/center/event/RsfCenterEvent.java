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
package net.hasor.rsf.center.event;
import org.more.util.StringUtils;
/**
 * 注册中心下推送的事件类型
 * 
 * @version : 2016年2月18日
 * @author 赵永春(zyc@hasor.net)
 */
public enum RsfCenterEvent {
    /**
     * 追加或重新激活地址
     * 说明：每当新的提供者上线时，都会通过该事件推送给消费者端。*/
    RsfCenter_AppendAddressEvent("AppendAddressEvent"), //
    /**
     * 使用新的地址本替换已有的地址本。
     * 说明：废弃服务已有的地址本，使用全新的地址本加以替换。*/
    RsfCenter_RefreshAddressEvent("RefreshAddressEvent"), //
    /**
     * 推送无效的地址
     * 说明：当有服务下线时，注册中心会通过该事件将无效的地址推送给消费者。*/
    RsfCenter_RemoveAddressEvent("RemoveAddressEvent"), //
    //
    /**
     * 推送默认服务级路由规则
     * 说明：推送服务的路由规则给RSF客户端，该路由策略会影响到RSF客户端上所有订阅的服务。*/
    RsfCenter_UpdateDefaultServiceRouteEvent("UpdateDefaultServiceRouteEvent"), //
    /**
     * 推送服务级路由规则
     * 说明：推送服务的路由规则给RSF客户端，该路由策略只会影响到特定的服务。*/
    RsfCenter_UpdateServiceRouteEvent("UpdateServiceRouteEvent"), //
    /**
     * 推送默认方法级路由规则。方法级路由是指：服务的路由策略可以为不同的方法做特殊配置
     * 说明：推送服务的路由规则给RSF客户端，该路由策略会影响到RSF客户端上所有订阅的服务。*/
    RsfCenter_UpdateDefaultMethodRouteEvent("UpdateDefaultMethodRouteEvent"), //
    /**
     * 推送方法级路由规则。方法级路由是指：服务的路由策略可以为不同的方法做特殊配置
     * 说明：推送服务的路由规则给RSF客户端，该路由策略只会影响到特定的服务。*/
    RsfCenter_UpdateMethodRouteEvent("UpdateMethodRouteEvent"), //
    /**
     * 推送默认参数级路由规则。参数级路由是指：服务的路由策略可以细分到服务方法的参数上，例如根据userID散列不用的服务调用地址
     * 说明：推送服务的路由规则给RSF客户端，该路由策略会影响到RSF客户端上所有订阅的服务。*/
    RsfCenter_UpdateDefaultArgsRouteEvent("UpdateDefaultArgsRouteEvent"), //
    /**
     * 推送参数级路由规则。参数级路由是指：服务的路由策略可以细分到服务方法的参数上，例如根据userID散列不用的服务调用地址
     * 说明：推送服务的路由规则给RSF客户端，该路由策略只会影响到特定的服务。*/
    RsfCenter_UpdateArgsRouteEvent("UpdateArgsRouteEvent"), //
    //
    /**
     * 推送默认服务流控规则，流控规则包含了：限流、选址、单元化
     * 说明：推送服务的路由规则给RSF客户端，该路由策略会影响到RSF客户端上所有订阅的服务。*/
    RsfCenter_UpdateDefaultFlowControlEvent("UpdateDefaultFlowControlEvent"), //
    /**
     * 推送流控流控规则，流控规则包含了：限流、选址、单元化
     * 说明：推送服务的路由规则给RSF客户端，该路由策略只会影响到特定的服务。*/
    RsfCenter_UpdateFlowControlEvent("UpdateFlowControlEvent");
    //
    //---------------------------------------------------------------------------------------------
    //
    //
    private String eventType;
    RsfCenterEvent(String eventType) {
        this.eventType = eventType;
    }
    @Override
    public String toString() {
        return "RsfCenterEvent[" + eventType + "]";
    }
    public static RsfCenterEvent getEventEnum(String eventType) {
        if (eventType != null) {
            for (RsfCenterEvent t : RsfCenterEvent.values()) {
                if (StringUtils.equalsBlankIgnoreCase(eventType, t.eventType)) {
                    return t;
                }
            }
        }
        return null;
    }
    public String getEventType() {
        return eventType;
    }
}