package com.hunter.BizTest;

import lombok.Data;

/**
 * @author hunter.yang
 * @version 1.0
 * @description null
 * @date 2021/1/4 18:49
 */
@Data
public class MaterialClassicAddLinkReq {

    private Integer firstCategoryId;

    private Integer secCategoryId;

    /**
     * 新增类型：1、单品  2、品牌
     */
    private Integer type;

    private Long pid;

    private Long bid;

    private Long uid;

    private Integer sortId;

    private Long articleId;


}
