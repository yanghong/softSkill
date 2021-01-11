package com.hunter.zk.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.*;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @filename ZkVote.java
 * @author tianyang.chen
 * @date 2017年12月11日 上午10:57:09
 * @desc 选举
 **/
public class ZkVote {
	static Logger logger = LoggerFactory.getLogger(ZkVote.class);

	public static void main(String[] args) {
		RetryPolicy retryPolicy = new BoundedExponentialBackoffRetry(1000, 20, 30000);
		CuratorFramework client = CuratorFrameworkFactory
				.builder()
				.connectString("172.16.254.7:2181")
				.sessionTimeoutMs(5000)
				.connectionTimeoutMs(5000)
				.retryPolicy(retryPolicy)
				.build();
		client.start();
		ZkVote zv = new ZkVote();
		zv.dowork1(client);
	}

	private void dowork1(CuratorFramework _client) {

		LeaderSelectorListener listener = new LeaderSelectorListenerAdapter() {
			public void takeLeadership(CuratorFramework client) throws Exception {
				logger.info("Take the lead.");

//				Thread.sleep(10000);
				Thread.sleep(Integer.MAX_VALUE);

				logger.info("Relinquish the lead.");
			}

		};

		LeaderSelector selector = new LeaderSelector(_client, "/simba_sd/leader", listener);
		selector.autoRequeue();
		selector.start();
		
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void dowork2(CuratorFramework _client) {
		LeaderLatch leader = new LeaderLatch(_client, "/simba_sd/leader");
		leader.addListener(new LeaderLatchListener() {
			@Override
			public void isLeader() {
				logger.info("Take the lead.");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("Relinquish the lead.");
			}
			@Override
			public void notLeader() {
				logger.info("I am not Leader");
			}
		});
		try {
			leader.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
