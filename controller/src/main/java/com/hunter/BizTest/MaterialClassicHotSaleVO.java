package com.hunter.BizTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 素材管-经典爆款数据配置
 * @author: hunter.yang
 * @date: 20201116 14:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialClassicHotSaleVO implements Serializable {

    private static final long serialVersionUID = 5138171419043487426L;

    private String categoryName;

    private Integer categoryId;

    private List<MaterialClassicSubCategory> subCategories;

}
