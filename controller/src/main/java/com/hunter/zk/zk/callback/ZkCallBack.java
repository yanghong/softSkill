package com.hunter.zk.zk.callback;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;

/**
 * @filename ZkCallBack.java
 * @author tianyang.chen
 * @date 2017年12月7日 下午4:49:38
 * @desc
 **/
public interface ZkCallBack {
	public void callback(CuratorFramework client, CuratorEvent event);
}
