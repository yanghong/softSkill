package com.hunter.BizTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: hunter.yang
 * @date: 20201116 14:53
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialClassicSubCategory implements Serializable {

    private static final long serialVersionUID = -909230038765551213L;

    private String categoryIdSecName;

    private Integer categoryIdSec;

    private List<MaterialClassicPidOrBrandLinkArticle> pidOrBrandLinkArticles;

}
