package com.hunter.zk.zk.watcher;

import com.hunter.zk.zk.ZkBean;
import com.hunter.zk.zk.watcher.callback.*;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @filename ZkWatcher.java
 * @author tianyang.chen
 * @date 2017年12月6日 下午2:30:47
 * @desc
 **/
public class ZkWatcher {
	static Logger logger = LoggerFactory.getLogger(ZkWatcher.class);

	private CuratorFramework client;
	private String path;
	
	public ZkWatcher(){}
	
	public ZkWatcher(CuratorFramework client, String path){
		this.client = client;
		this.path = path;
	}
	
	public ZkWatcher(String path){
		this.client = ZkBean.getZkClient();
		this.path = path;
	}

	/**
	 * 树形监听
	 * @param callBack
	 * @throws Exception
	 */
	public void initTreeWatcher(final TreeCallBack callBack) throws Exception {
		final TreeCache treeCache = new TreeCache(client, path); 
		treeCache.getListenable().addListener(new TreeCacheListener() {
			@Override
			public void childEvent(CuratorFramework client, TreeCacheEvent event) throws Exception {
				callBack.callback(client, event, treeCache);
			}
		});
		treeCache.start();
	}
	/**
	 * 当前节点监听
	 * @param callBack
	 * @throws Exception
	 */
	public void initCurrentWatcher(final CurrentCallBack callBack) throws Exception {
		final NodeCache nodeCache = new NodeCache(client, path, false);
		nodeCache.getListenable().addListener(new NodeCacheListener() {  
			@Override
			public void nodeChanged() throws Exception {
				callBack.callback(nodeCache);
			}  
		});  
		nodeCache.start();  
	}
	/**
	 * 子节点监听
	 * @throws Exception
	 */
	public PathChildrenCache initChildrenWatcher(final ChildrenCallBack callBack)throws Exception {
		final PathChildrenCache childrenCache = new PathChildrenCache(client, path, true);  
		PathChildrenCacheListener childrenCacheListener = new PathChildrenCacheListener() {  
			@Override
			public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
				callBack.callback(client, event, childrenCache);
			}  
		};  
		childrenCache.getListenable().addListener(childrenCacheListener);  
		childrenCache.start(StartMode.POST_INITIALIZED_EVENT);  
		return childrenCache;
	}
	/**
	 * 单次监听
	 * @throws Exception
	 */
	public String initSingleWatcher(final SingleCallBack callback) throws Exception {
		byte[] data = client.getData().usingWatcher(new Watcher() {  
			@Override
			public void process(WatchedEvent event) {  
				callback.callback(event);
			}  
		}).forPath(path);  
		return new String(data);
	}
	/**
	 * 全局监听
	 * @throws Exception
	 */
	@Deprecated
	public void initGlobalWatcher(final GlobalCallBack callback) throws Exception {
		ExecutorService pool = Executors.newCachedThreadPool();
		CuratorListener listener = new CuratorListener() {  
			@Override
			public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
				callback.callback(client, event);
			}  
		};  
		client.getCuratorListenable().addListener(listener,pool);  
	}
	
	

	public CuratorFramework getClient() {
		return client;
	}
	public void setClient(CuratorFramework client) {
		this.client = client;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}


}
