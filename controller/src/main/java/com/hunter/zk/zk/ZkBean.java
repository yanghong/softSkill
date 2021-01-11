package com.hunter.zk.zk;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;

/**
 * @filename ZkBean.java
 * @author tianyang.chen
 * @date 2017年12月6日 下午5:08:05
 * @desc
 **/
public class ZkBean {
	private static CuratorFramework  client;

	public synchronized static void initZkClient(){
		if(client==null){
			RetryPolicy retryPolicy = new BoundedExponentialBackoffRetry(Constants.zkRetryBaseSleepTimeMs, Constants.zkRetryMaxRetries, Constants.zkRetryMaxSleepTimeMs);
			client = CuratorFrameworkFactory
					.builder()
					.connectString(Constants.zkHostAndPort)
					.sessionTimeoutMs(Constants.zkSessionTimeoutMs)
					.connectionTimeoutMs(Constants.zkConnectionTimeoutMs)
					.namespace(Constants.zkPathNamespace)
					.retryPolicy(retryPolicy)
					.build();
			client.start();
		}
	}

	public static CuratorFramework getZkClient(){
		if(client==null)
			initZkClient();
		return client;
	}
	
	public static void close(){
		if(client != null){
			client.close();
		}
	}
}
