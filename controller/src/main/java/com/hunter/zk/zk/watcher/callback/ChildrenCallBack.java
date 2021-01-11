package com.hunter.zk.zk.watcher.callback;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;

/**
 * @filename ChildrenCallBack.java
 * @author tianyang.chen
 * @date 2017年12月6日 下午3:41:00
 * @desc
 **/
public interface ChildrenCallBack {
	public void callback(CuratorFramework client, PathChildrenCacheEvent event, PathChildrenCache childrenCache);
}
