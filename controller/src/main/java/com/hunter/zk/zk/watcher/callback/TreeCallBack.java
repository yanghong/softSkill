package com.hunter.zk.zk.watcher.callback;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;


public interface TreeCallBack {
	public void callback(CuratorFramework client, TreeCacheEvent event, TreeCache treeCache);
}
