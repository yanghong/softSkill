package com.hunter.zk.zk;


import com.hunter.zk.zk.callback.ZkCallBack;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @filename ZkUtils.java
 * @author tianyang.chen
 * @date 2017年12月6日 下午5:07:26
 * @desc zk基本操作包
 **/
public class ZkUtils {
	
	static Logger logger = LoggerFactory.getLogger(ZkUtils.class);

	public static void main(String[] args) throws Exception {
		//新增节点
//		createNode("/test", "hello", CreateMode.EPHEMERAL);
//		createNode("/test2", "hello", CreateMode.EPHEMERAL_SEQUENTIAL);
//		createNode("/test", "hello", CreateMode.PERSISTENT);
//		createNode("/test4", "hello", CreateMode.PERSISTENT_SEQUENTIAL);
		//判断节点是否存在
//		System.out.println(checkExists("/test"));
		//删除节点
//		deleteNode("/test");
		//更新节点
//		updateNode("/test", "hellohello");
		//查找节点信息
//		System.out.println(showNode("/test"));
		//查找所有子节点
		List<String> list = showChildrenNodes("/scheduler");
		for(String str : list){
			System.out.println(str);
		}
		//新增节点
//		createNodeAsyn("/test11", "hello", CreateMode.PERSISTENT, new ZkCallBack() {
//			@Override
//			public void callback(CuratorFramework client, CuratorEvent event) {
//				System.out.println(event.getResultCode());
//			}
//		});
		//判断节点是否存在
//		System.out.println(checkExists("/test"));
//		checkExistsAsyn("/test11", new ZkCallBack() {
//			@Override
//			public void callback(CuratorFramework client, CuratorEvent event) {
//				System.out.println(event.getResultCode());
//			}
//		});
		//删除节点
//		deleteNode("/test");
		//更新节点
//		updateNode("/test", "hellohello");
		//查找节点信息
//		System.out.println(showNode("/test"));
		//查找所有子节点
//		List<String> list = showChildrenNodes("/test");
//		for(String str : list){
//			System.out.println(str);
//		}
		
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}
	/**
	 * 新增节点
	 * @param path
	 * @param data
	 * @param model
	 * @return
	 */
	public static String createNode(String path , String data, CreateMode model){
		try{
			String pathReal = ZkBean.getZkClient().create().withMode(model).forPath(path,data.getBytes());
			return pathReal;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 判断节点是否存在
	 * @param path
	 * @return
	 * true 存在
	 * false 不存在
	 */
	public static boolean checkExists(String path){
		try {
			Stat stat = ZkBean.getZkClient().checkExists().forPath(path);
			if(stat==null){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 更新节点
	 * @param path
	 * @param data
	 * @return
	 */
	public static boolean updateNode(String path, String data){
		try {
			Stat stat = new Stat();
			ZkBean.getZkClient().getData().storingStatIn(stat).forPath(path);
			ZkBean.getZkClient().setData().withVersion(stat.getVersion()).forPath(path, data.getBytes());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除节点
	 * @param path
	 * @return
	 */
	public static boolean deleteNode(String path){
		try {
			ZkBean.getZkClient().delete().forPath(path);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 获取节点信息
	 * @param path
	 * @return
	 */
	public static String showNode(String path){
		try {
			byte[] b = ZkBean.getZkClient().getData().forPath(path);
			return new String( b );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查找所有子节点
	 * @param path
	 * @return
	 */
	public static List<String> showChildrenNodes(String path){
		try {
			List<String> list = ZkBean.getZkClient().getChildren().forPath(path);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
	
	/**
	 * 新增节点
	 * @param path
	 * @param data
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public static void createNodeAsyn(String path , String data, CreateMode model, final ZkCallBack callback) throws Exception {
			ZkBean.getZkClient().create().withMode(model).inBackground(new BackgroundCallback() {
				@Override
				public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
					callback.callback(client, event);
				}
			}).forPath(path,data.getBytes());
	}
	/**
	 * 判断节点是否存在
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static void checkExistsAsyn(String path, final ZkCallBack callback) throws Exception {
		ZkBean.getZkClient().checkExists().inBackground(new BackgroundCallback() {
			public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
				callback.callback(client, event);
			}
		}).forPath(path);
	}
	/**
	 * 更新节点
	 * @param path
	 * @param data
	 * @return
	 */
	public static void updateNodeAsyn(String path, String data){
		//todo
	}
	/**
	 * 删除节点
	 * @param path
	 * @return
	 */
	public static void deleteNodeAsyn(String path){
		//todo
	}


}
