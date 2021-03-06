package com.kotlin.provider.router

/**
 *
 *  Desc: 模块路由 路径定义
 *
 * @author zhf QQ:578121695
 * @time 2018/11/8 14:53
 */
object RouterPath {
    //用户模块
    class UserCenter {
        companion object {
            const val PATH_LOGIN = "/userCenter/login"
        }
    }

    //订单模块
    class OrderCenter {
        companion object {
            const val PATH_ORDER_CONFIRM = "/orderCenter/confirm"
        }
    }

    //支付模块
    class PaySDK {
        companion object {
            const val PATH_PAY = "/paySDK/pay"
        }
    }

    //消息模块
    class MessageCenter {
        companion object {
            const val PATH_MESSAGE_PUSH = "/messageCenterPush/push"
            const val PATH_MESSAGE_ORDER = "/messageCenterOrder/order"
        }
    }
}
