package org.springframework.boot.autoconfigure.lock.model;

import org.springframework.boot.autoconfigure.lock.handler.release.ReleaseTimeoutHandler;
import org.springframework.boot.autoconfigure.lock.handler.KlockTimeoutException;

/**
 * @author wanglaomo
 * @since 2019/4/15
 **/
public enum ReleaseTimeoutStrategy implements ReleaseTimeoutHandler {

    /**
     * 继续执行业务逻辑，不做任何处理
     */
    NO_OPERATION() {
        @Override
        public void handle(LockInfo lockInfo) {
            // do nothing
        }
    },
    /**
     * 快速失败
     */
    FAIL_FAST() {
        @Override
        public void handle(LockInfo lockInfo) {

            String errorMsg = String.format("Found Lock(%s) already been released while lock lease time is %d s", lockInfo.getName(), lockInfo.getLeaseTime());
            throw new KlockTimeoutException(errorMsg);
        }
    }
}
