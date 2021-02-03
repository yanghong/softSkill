package com.hunter.hbase;

import java.util.Random;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/29 14:37
 */
public class linkDemo {

//        private static final HBaseTestingUtility TEST_UTIL=new HBaseTestingUtility();
//        public static final TableName tableName=TableName.valueOf("testTable");
//        public static final byte[] ROW_KEY0=Bytes.toBytes("rowkey0");
//        public static final byte[] ROW_KEY1=Bytes.toBytes("rowkey1");
//        public static final byte[] FAMILY=Bytes.toBytes("family");
//        public static final byte[] QUALIFIER=Bytes.toBytes("qualifier");
//        public static final byte[] VALUE=Bytes.toBytes("value");
//        @BeforeClass
//        public static void setUpBeforeClass() throws Exception {
//            TEST_UTIL.startMiniCluster();
//        }
//        @AfterClass
//        public static void tearDownAfterClass() throws Exception {
//            TEST_UTIL.shutdownMiniCluster();
//        }
//        @Test
//        public void test() throws IOException {
//            Configuration conf=TEST_UTIL.getConfiguration();
//            try (Connection conn=ConnectionFactory.createConnection(conf)) {
//                try (Table table=conn.getTable(tableName)) {
//                    for (byte[] rowkey : new byte[][] { ROW_KEY0, ROW_KEY1 }) {
//                        Put put=new Put(rowkey).addColumn(FAMILY, QUALIFIER, VALUE);
//                        table.put(put);
//                    }
//                    Scan scan=new Scan().withStartRow(ROW_KEY1).setLimit(1);
//                    try (ResultScanner scanner=table.getScanner(scan)) {
//                        List<Cell> cells=new ArrayList<>();
//                        for (Result result : scanner) {
//                            cells.addAll(result.listCells());
//                        }
//                        Assert.assertEquals(cells.size(), 1);
//                        Cell firstCell=cells.get(0);
//                        Assert.assertArrayEquals(CellUtil.cloneRow(firstCell), ROW_KEY1);
//                        Assert.assertArrayEquals(CellUtil.cloneFamily(firstCell), FAMILY);
//                        Assert.assertArrayEquals(CellUtil.cloneQualifier(firstCell), QUALIFIER);
//                        Assert.assertArrayEquals(CellUtil.cloneValue(firstCell), VALUE);
//                    }
//                }
//            }
//        }

    public static void main(String[] args) {
        int index=new Random().nextInt(1);
        System.out.println(index);
    }
}
