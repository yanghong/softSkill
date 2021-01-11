package com.hunter.zk.zk.watcher.callback;

import org.apache.curator.framework.recipes.cache.NodeCache;

/**
 * @filename CurrentCallBack.java
 * @author tianyang.chen
 * @date 2017年12月6日 下午3:42:44
 * @desc
 **/
public interface CurrentCallBack {
	public void callback(NodeCache nodeCache);
}
