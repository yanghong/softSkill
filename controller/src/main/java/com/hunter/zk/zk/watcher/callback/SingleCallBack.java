package com.hunter.zk.zk.watcher.callback;

import org.apache.zookeeper.WatchedEvent;

/**
 * @filename SingleCallBack.java
 * @author tianyang.chen
 * @date 2017年12月6日 下午4:30:14
 * @desc
 **/
public interface SingleCallBack {

	public void callback(WatchedEvent event);
}
