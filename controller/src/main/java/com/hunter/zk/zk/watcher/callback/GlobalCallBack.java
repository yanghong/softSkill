package com.hunter.zk.zk.watcher.callback;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;

/**
 * @filename GlobalCallBack.java
 * @author tianyang.chen
 * @date 2017年12月6日 下午4:30:31
 * @desc
 **/
public interface GlobalCallBack {
	
	public void callback(CuratorFramework client, CuratorEvent event);

}
