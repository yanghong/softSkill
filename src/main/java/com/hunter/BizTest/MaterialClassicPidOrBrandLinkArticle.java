package com.hunter.BizTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 素材管-经典爆款-关联商品
 * @author: hunter.yang
 * @date: 20201116 14:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialClassicPidOrBrandLinkArticle implements Serializable {

    private static final long serialVersionUID = -5862733374334020901L;

    /**
     * 类型：1：商品 2：品牌（bid + uid）
     */
    private Integer type;

    private Long pid;

    private Long bid;

    private Long uid;

    private boolean isFeatured;

    private Integer sortId;

    private Long articleId;

}
